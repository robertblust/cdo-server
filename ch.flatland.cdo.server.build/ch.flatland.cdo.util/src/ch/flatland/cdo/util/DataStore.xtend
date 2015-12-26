/*
 * Copyright (c) 2014 Robert Blust (Zurich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.util

import com.google.gson.Gson
import java.math.BigDecimal
import java.util.Date
import java.util.List
import javax.servlet.http.HttpServletRequest
import org.eclipse.emf.cdo.common.model.CDOPackageUnit.State
import org.eclipse.emf.cdo.server.IRepository
import org.eclipse.emf.cdo.server.db.IDBStore
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy
import org.eclipse.emf.cdo.transaction.CDOTransaction
import org.eclipse.emf.cdo.view.CDOView
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.net4j.util.container.IPluginContainer
import org.slf4j.LoggerFactory

class DataStore {
	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension EMF = new EMF

	def CommitMessage getLastCommit(CDOView view, Class<?> origin) {
		val queryTimestamp = view.createQuery("sql", "SELECT COMMIT_TIME FROM CDO_COMMIT_INFOS WHERE COMMIT_COMMENT LIKE '%\"service\":\"" + origin.simpleName + "\"%' ORDER BY COMMIT_TIME DESC")
		queryTimestamp.setParameter("cdoObjectQuery", false)
		queryTimestamp.maxResults = 1
		logger.debug("Execute '{}' query '{}'", queryTimestamp.queryLanguage, queryTimestamp.queryString)
		var Long timeStamp = null
		if(view.mappingStrategy.store.DBAdapter.name == "oracle") {
			val bigDecimal = queryTimestamp.getResult(BigDecimal)?.get(0)
			if(bigDecimal != null) {
				timeStamp = Long.parseLong(bigDecimal.longValue.toString)
			}

		} else {
			timeStamp = queryTimestamp.getResult(Long)?.get(0)
		}
		if(timeStamp != null) {
			val queryComment = view.createQuery("sql", "SELECT COMMIT_COMMENT FROM CDO_COMMIT_INFOS WHERE COMMIT_TIME = '" + timeStamp + "'")
			queryComment.setParameter("cdoObjectQuery", false)
			queryComment.maxResults = 1
			logger.debug("Execute '{}' query '{}'", queryComment.queryLanguage, queryComment.queryString)
			val json = queryComment.getResult(String)?.get(0)
			if(json != null) {
				val parser = new Gson
				val commitMessage = parser.fromJson(json, CommitMessage)
				val extension DateConverter = new DateConverter
				val commitDate = new Date(timeStamp)
				commitMessage.timestamp = commitDate.formatDate
				return commitMessage
			}
		}
		return null
	}

	def long countType(CDOView view, EClass eClass, FLQuery flQuery, HttpServletRequest req) {
		logger.debug("countType '{}', flQuery = '{}'", eClass.type, flQuery)

		if(eClass.abstract) {
			return 0
		}

		val packageRegistry = view.session.packageRegistry
		val packageInfo = packageRegistry.getPackageInfo(eClass.EPackage)

		if(packageInfo == null || packageInfo.packageUnit.state == State.NEW) {
			throw new Exception("No data store for type '" + eClass.type + "' created yet")
		}

		val mappingStrategy = view.mappingStrategy
		var tableName = eClass.name
		val qualifiedNames = mappingStrategy.properties.get(IMappingStrategy.PROP_QUALIFIED_NAMES) == "true"
		if(qualifiedNames) {
			tableName = eClass.type.replace(".", "_")
		}
		var tableExists = true
		try {
			tableName = mappingStrategy.getTableName(eClass)
		} catch(Exception e) {
			tableExists = false

			// TODO find better solution 'Depends on MappingStrategy'
			// mappingStrategy.getTableName(eClass) causes an Exception
			// 'StoreThreadLocal.getSession == null'
			// when the requested class is never requested via standard cdo mechanism
			// Solution to initialize session is a hack!!! 
			// The exception should appears max once per eClass
			// The tableName is known instead of asking the mappingStrategy
			logger.debug("Hack NoSessionRegisteredException '{}'", e.message)
			val query = view.createQuery("sql", "SELECT DISTINCT CDO_ID FROM " + tableName + " WHERE " + view.temporality)
			query.maxResults = 1
			logger.debug("Hack NoSessionRegisteredException Execute '{}' query '{}'", query.queryLanguage, query.queryString)
			val iterator = query.getResultAsync(typeof(EObject))
			while(iterator.hasNext) {
				val obj = iterator.next
				logger.debug("Hack NoSessionRegisteredException Found '{}'", obj)
				tableExists = true
			}
			iterator.close
		}
		if(tableExists) {
			val query = view.createQuery("sql", "SELECT COUNT(*) CDO_ID FROM " + mappingStrategy.getTableName(eClass) + " WHERE " + view.temporality + eClass.filterQuery(req, flQuery, mappingStrategy))
			query.setParameter("cdoObjectQuery", false)
			logger.debug("Execute '{}' query '{}'", query.queryLanguage, query.queryString)
			if(mappingStrategy.store.DBAdapter.name == "oracle") {
				val size = query.getResult(BigDecimal)
				return size.get(0).longValue
			}
			val size = query.getResult(Long)
			return size.get(0)
		}

		return 0
	}

	def countType(CDOView view, String type, HttpServletRequest req) {
		return countType(view, view.safeEClass(type), null, req)
	}

	def countType(CDOView view, EClass eClass, HttpServletRequest req) {
		return countType(view, eClass, null, req)
	}

	def findByType(CDOView view, EClass eClass, FLQuery flQuery, HttpServletRequest req) {
		logger.debug("findByType '{}', flQuery = '{}'", eClass.type, flQuery)
		// TODO find better solution 'Depends on Relation DB Store' 
		// sql depends on mapping strategy
		val List<EObject> result = newArrayList

		val toProcess = newArrayList

		val packageRegistry = view.session.packageRegistry
		val packageInfo = packageRegistry.getPackageInfo(eClass.EPackage)

		if(packageInfo == null || packageInfo.packageUnit.state == State.NEW) {
			throw new Exception("No data store for type '" + eClass.type + "' created yet")
		}

		if(!eClass.abstract) {
			toProcess.add(eClass)
		}
		toProcess.addAll(eClass.getExtendedFrom(view))

		toProcess.forEach [
			val mappingStrategy = view.mappingStrategy
			var tableName = it.name
			val qualifiedNames = mappingStrategy.properties.get(IMappingStrategy.PROP_QUALIFIED_NAMES) == "true"
			if(qualifiedNames) {
				tableName = it.type.replace(".", "_")
			}
			var tableExists = true
			try {
				tableName = mappingStrategy.getTableName(it)
			} catch(Exception e) {
				tableExists = false

				// TODO find better solution 'Depends on MappingStrategy'
				// mappingStrategy.getTableName(eClass) causes an Exception
				// 'StoreThreadLocal.getSession == null'
				// when the requested class is never requested via standard cdo mechanism
				// Solution to initialize session is a hack!!! 
				// The exception should appears max once per eClass
				// The tableName is known instead of asking the mappingStrategy
				logger.debug("Hack NoSessionRegisteredException '{}'", e.message)
				val query = view.createQuery("sql", "SELECT DISTINCT CDO_ID FROM " + tableName + " WHERE " + view.temporality)
				query.maxResults = 1
				logger.debug("Hack NoSessionRegisteredException Execute '{}' query '{}'", query.queryLanguage, query.queryString)
				val iterator = query.getResultAsync(typeof(EObject))
				while(iterator.hasNext) {
					val obj = iterator.next
					logger.debug("Hack NoSessionRegisteredException Found '{}'", obj)
					tableExists = true
				}
				iterator.close
			}
			if(tableExists) {
				val query = view.createQuery("sql", "SELECT DISTINCT CDO_ID " + it.max(req, mappingStrategy) + " FROM " + mappingStrategy.getTableName(it) + " WHERE " + view.temporality + it.filterQuery(req, flQuery, mappingStrategy) + it.orderBy(req, mappingStrategy))
				logger.debug("Execute '{}' query '{}'", query.queryLanguage, query.queryString)
				val iterator = query.getResultAsync(typeof(EObject))
				while(iterator.hasNext) {
					val obj = iterator.next

					logger.debug("Found '{}'", obj)
					result.add(obj)
				}
				iterator.close
			}
		]

		// TODO check other opinion 'Rest Standards'
		// Should an empty list be returned or Status 404?
		return result
	}

	def findByType(CDOView view, String type, HttpServletRequest req) {
		return findByType(view, view.safeEClass(type), null, req)
	}

	def findByType(CDOView view, EClass eClass, HttpServletRequest req) {
		return findByType(view, eClass, null, req)
	}

	def createCommitMessage(CDOView view, Class<?> origin) {
		if(view instanceof CDOTransaction) {
			return new CommitMessage => [
				service = origin.simpleName
				newObjects = view.changeSetData.newObjects.size
				changedObjects = view.changeSetData.changedObjects.size
				deletedObjects = view.changeSetData.detachedObjects.size
			]

		}
		return null
	}

	def private temporality(CDOView view) {
		if(view.timeStamp > 0) {
			return "((CDO_CREATED <= " + view.timeStamp + " AND CDO_VERSION > 0) AND (CDO_REVISED >= " + view.timeStamp + " OR CDO_REVISED = 0 AND CDO_VERSION > 0))"
		} else {
			return "(CDO_REVISED = 0 AND CDO_VERSION > 0)"
		}
	}

	def private filterQuery(EClass eClass, HttpServletRequest req, FLQuery flQuery, IMappingStrategy mappingStrategy) {
		val reqBuilder = new StringBuilder
		var reqQuery = ""
		var kind = "AND"
		if(req.xor) {
			kind = "OR"
		}
		val params = req.parameterNameAsListValueNotNull
		for (paramName : params) {
			val attribute = eClass.getAttribute(paramName)
			if(attribute != null) {
				logger.debug("Parameter name for filter '{}'", paramName)
				for (value : req.parameterMap.get(paramName)) {
					if(req.isLike) {
						reqBuilder.append(" " + kind + " LOWER(" + mappingStrategy.getFieldName(attribute) + ") LIKE '%" + attribute.getValue(value, mappingStrategy).toLowerCase + "%'")
					} else {
						reqBuilder.append(" " + kind + " " + mappingStrategy.getFieldName(attribute) + " = '" + attribute.getValue(value, mappingStrategy) + "'")
					}

				}
			}
		}
		if(kind == "OR" && reqBuilder.length > 0) {
			reqQuery = reqBuilder.toString.replaceFirst("OR ", "AND (") + ")"
		} else {
			reqQuery = reqBuilder.toString
		}
		if(flQuery == null) {
			return reqQuery
		}

		val andBuilder = new StringBuilder
		flQuery.andStatements.forEach [
			val column = mappingStrategy.getFieldName(it.feature)
			andBuilder.append(" AND ")
			andBuilder.append(column)
			switch it.class {
				case typeof(FLEquals): andBuilder.append(" = ")
				case typeof(FLGreater): andBuilder.append(" > ")
				case typeof(FLGreaterOrEqual): andBuilder.append(" >= ")
				case typeof(FLLess): andBuilder.append(" < ")
				case typeof(FLLessOrEquals): andBuilder.append(" <= ")
			}
			if(it.feature instanceof EAttribute) {
				val attribute = it.feature as EAttribute
				andBuilder.append("'" + attribute.getValue(compare, mappingStrategy) + "'")
			} else {
				andBuilder.append("'" + it.compare + "'")
			}
		]

		val orBuilder = new StringBuilder
		flQuery.orStatements.forEach [
			val column = mappingStrategy.getFieldName(it.feature)
			orBuilder.append(" OR ")
			orBuilder.append(column)
			switch it.class {
				case typeof(FLEquals): orBuilder.append(" = ")
				case typeof(FLGreater): orBuilder.append(" > ")
				case typeof(FLGreaterOrEqual): orBuilder.append(" >= ")
				case typeof(FLLess): orBuilder.append(" < ")
				case typeof(FLLessOrEquals): orBuilder.append(" <= ")
			}
			if(it.feature instanceof EAttribute) {
				val attribute = it.feature as EAttribute
				orBuilder.append("'" + attribute.getValue(compare, mappingStrategy) + "'")
			} else {
				orBuilder.append("'" + it.compare + "'")
			}
		]
		if(orBuilder.length > 0) {
			return reqQuery + andBuilder.toString + orBuilder.toString.replaceFirst("OR ", "AND (") + ")"
		}
		return reqQuery + andBuilder.toString
	}

	def private max(EClass eClass, HttpServletRequest req, IMappingStrategy mappingStrategy) {
		val max = eClass.orderByName(req, mappingStrategy)
		if(max != null) {
			return ", MAX(" + max + ")"
		}
		return ""
	}

	def private orderBy(EClass eClass, HttpServletRequest req, IMappingStrategy mappingStrategy) {
		val name = eClass.orderByName(req, mappingStrategy)
		if(name != null) {
			return " GROUP BY CDO_ID ORDER BY MAX(" + name + ")"
		}
		return ""
	}

	def private orderByName(EClass eClass, HttpServletRequest req, IMappingStrategy mappingStrategy) {
		if(req.orderBy != null && eClass.getAttribute(req.orderBy) != null) {
			return mappingStrategy.getFieldName(eClass.getAttribute(req.orderBy))
		}
		if(eClass.nameAttribute != null) {
			return "NAME"
		}
		return null
	}

	def private getMappingStrategy(CDOView view) {
		val repoName = view.session.repositoryInfo.name
		val repo = IPluginContainer.INSTANCE.elements.filter[it instanceof IRepository && (it as IRepository).name == repoName].head
		logger.debug("Resolved repo '{}'", repo)
		val store = (repo as IRepository).store as IDBStore
		logger.debug("Resolved store '{}'", store)
		val mappingStrategy = store.mappingStrategy
		logger.debug("Resolved mapping strategy '{}'", mappingStrategy)
		return mappingStrategy
	}

	def private getValue(EAttribute attribute, String value, IMappingStrategy mappingStrategy) {
		logger.debug("DBStore '{}'", mappingStrategy.store.DBAdapter.name)
		if(mappingStrategy.store.DBAdapter.name == "mysql" || mappingStrategy.store.DBAdapter.name == "oracle") {
			switch attribute.EAttributeType.instanceClass {
				case typeof(boolean): return value.booleanIntValue
				case typeof(Boolean): return value.booleanIntValue
			}
		}

		if(attribute.EAttributeType instanceof EEnum) {
			val enum = attribute.EAttributeType as EEnum
			for (literal : enum.ELiterals) {
				if(literal.name == value) {
					return literal.value.toString
				}
			}
			return "-1"
		} else {

			// escape single quotes!
			return value.replace("'", "''")
		}
	}

	def private getBooleanIntValue(String value) {
		if(value == "true") {
			return "1";
		}
		return "0";
	}
}

