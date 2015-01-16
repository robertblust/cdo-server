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

import java.util.List
import javax.servlet.http.HttpServletRequest
import org.eclipse.emf.cdo.server.IRepository
import org.eclipse.emf.cdo.server.db.IDBStore
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy
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

	def findByType(CDOView view, String type, HttpServletRequest req) {

		// TODO find better solution 'Depends on Relation DB Store' 
		//sql depends on mapping strategy
		val List<EObject> result = newArrayList

		val toProcess = newArrayList

		val eClass = view.safeEClass(type)
		if(eClass.abstract) {
			toProcess.addAll(eClass.getExtendedFrom(view))
		} else {
			toProcess.add(eClass)
		}

		toProcess.forEach [

			val mappingStrategy = view.mappingStrategy
			var tableName = it.type.replace(".", "_")
			try {
				tableName = mappingStrategy.getTableName(it)
			} catch(Exception e) {

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
				}
				iterator.close
			}
			val query = view.createQuery("sql", "SELECT DISTINCT CDO_ID " + it.max(req, mappingStrategy) + " FROM " + mappingStrategy.getTableName(it) + " WHERE " + view.temporality + it.filterQuery(req, mappingStrategy) + it.orderBy(req, mappingStrategy))
			logger.debug("Execute '{}' query '{}'", query.queryLanguage, query.queryString)
			val iterator = query.getResultAsync(typeof(EObject))
			while(iterator.hasNext) {
				val obj = iterator.next
				logger.debug("Found '{}'", obj)
				result.add(obj)
			}
			iterator.close
		]

		// TODO check other opinion 'Rest Standards'
		// Should an empty list be returned or Status 404?
		return result
	}

	def private temporality(CDOView view) {
		if(view.timeStamp > 0) {
			return "((CDO_CREATED <= " + view.timeStamp + " AND CDO_VERSION > 0) AND (CDO_REVISED >= " + view.timeStamp + " OR CDO_REVISED = 0 AND CDO_VERSION > 0))"
		} else {
			return "(CDO_REVISED = 0 AND CDO_VERSION > 0)"
		}
	}

	def private filterQuery(EClass eClass, HttpServletRequest req, IMappingStrategy mappingStrategy) {
		val builder = new StringBuilder
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
					builder.append(" " + kind + " LOWER(" + mappingStrategy.getFieldName(attribute) + ") LIKE '%" + attribute.getValue(value).toLowerCase + "%'")
				}
			}
		}
		if(req.xor && builder.length > 0) {
			return builder.toString.replaceFirst("OR ", "AND (") + ")"
		}
		return builder.toString
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

	def private getValue(EAttribute attribute, String value) {
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
}
