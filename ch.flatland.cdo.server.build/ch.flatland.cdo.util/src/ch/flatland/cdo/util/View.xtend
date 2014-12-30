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

import com.google.common.base.Splitter
import java.util.Collections
import java.util.List
import java.util.Map
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.id.CDOIDUtil
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta
import org.eclipse.emf.cdo.common.security.CDOPermission
import org.eclipse.emf.cdo.transaction.CDOTransaction
import org.eclipse.emf.cdo.view.CDOView
import org.eclipse.emf.ecore.EObject
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class View {
	val logger = LoggerFactory.getLogger(this.class)

	val extension EMF = new EMF
	val extension DataStore = new DataStore
	val extension References = new References
	val extension Request = new Request

	def safeRequestResource(CDOView view, HttpServletRequest req, HttpServletResponse resp) {

		try {
			switch (req.servletAlias) {
				case ALIAS_NODE: {
					if(req.pathInfo != null) {
						var String referenceName = null
						var pathInfo = req.pathInfo
						val pathSegments = req.pathSegments
						var references = false

						// all references requested?
						if(pathSegments.get(pathSegments.size - 1) == REFERENCES) {
							pathInfo = pathInfo.replace("/" + REFERENCES, "")
							references = true
						}

						// detail references requested?
						if(pathSegments.get(pathSegments.size - 2) == REFERENCES) {
							pathInfo = pathInfo.replace("/" + REFERENCES + "/" + pathSegments.get(pathSegments.size - 1), "")
							referenceName = pathSegments.get(pathSegments.size - 1)
							if(req.method != METHOD_POST) {
								references = true
							}
						}
						val CDOObject object = view.getResourceNode(pathInfo)
						if(!references) {
							return object
						} else {

							// resolve references
							return req.orderBy(req.filterBy(object.safeResolveReferences(referenceName)))
						}
					} else {
						return view.getResourceNode("/")
					}
				}
				case ALIAS_OBJECT: {
					val pathSegments = Splitter.on("/").split(req.pathInfo)
					switch (pathSegments.size) {
						case 1: {
						}
						case 2: {
							val objects = view.findByType(pathSegments.get(1), req)
							return objects
						}
						case 3: {
							return view.safeResolveObject(pathSegments)
						}
						// all references requested?
						case 4: {
							if(pathSegments.get(3) == REFERENCES) {
								val object = view.safeResolveObject(pathSegments)
								return req.orderBy(req.filterBy(object.safeResolveReferences(null)))
							} else {
								throw new Exception
							}
						}
						// detail references requested?
						case 5: {
							if(pathSegments.get(3) == REFERENCES) {
								val object = view.safeResolveObject(pathSegments)
								if(req.method == METHOD_POST) {
									return view.safeResolveObject(pathSegments)
								}
								return req.orderBy(req.filterBy(object.safeResolveReferences(pathSegments.get(4))))
							} else {
								throw new Exception
							}
						}
						default:
							throw new Exception
					}
				}
				default:
					throw new Exception
			}
		} catch(Exception e) {
			throw new FlatlandException(SC_NOT_FOUND, "{} not found", req.pathInfo)
		}
	}

	def safeRequestObject(CDOView view, long id) {
		try {
			return view.getObject(CDOIDUtil.createLong(id))
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "No object found with '{}={}", ID, id)
		}
	}

	def safeCanWrite(CDOObject object) {
		if(object.cdoPermission != CDOPermission.WRITE) {
			throw new FlatlandException(SC_FORBIDDEN, object, "No permission to edit object '{}'", object.cdoID)
		}
	}

	def addRevisionDelta(CDOTransaction view, Map<EObject, List<CDOFeatureDelta>> revisionDeltas) {
		view.revisionDeltas.forEach [ id, revisionDelta |
			val scope = view.getObject(id)
			if(scope != null) {
				var List<CDOFeatureDelta> list = newArrayList
				if(revisionDeltas.containsKey(scope)) {
					list = revisionDeltas.get(scope)
				} else {
					revisionDeltas.put(scope, list)
				}
				for (delta : revisionDelta.featureDeltas) {
					logger.debug("Add revision delta '{}' with class '{}'", delta, delta.class.name)
					list.add(delta)
				}
			}
		]
	}

	def private safeResolveObject(CDOView view, Iterable<String> pathSegments) {
		val ePackage = view.safeEPackage(pathSegments.get(1).safePackagePrefix)
		val eClass = ePackage.getEClassifier(pathSegments.get(1).safeEType)
		if(eClass == null) {
			throw new Exception
		}
		val object = view.getObject(CDOIDUtil.createLong(Long.parseLong(pathSegments.get(2))))
		if(object.eClass.type != pathSegments.get(1)) {
			throw new Exception
		}
		return object
	}

	def private dispatch filterBy(HttpServletRequest req, Object object) {
		return object
	}

	def private dispatch filterBy(HttpServletRequest req, EObject object) {
		return object
	}

	def private dispatch filterBy(HttpServletRequest req, List<EObject> list) {
		val filteredList = newArrayList
		list.forEach [
			if(req.matches(it)) {
				filteredList.add(it)
			}
		]
		return filteredList
	}

	def private matches(HttpServletRequest req, EObject object) {
		var matches = 0
		var criterias = 0
		val or = req.xor
		val params = req.parameterNameAsListValueNotNull
		val supportedFeatures = newArrayList
		params.forEach [
			val param = it
			object.eClass.EAllAttributes.forEach [
				if(param == it.name) {
					supportedFeatures.add(param)
				}
			]
		]
		logger.debug("'{}' supports features '{}' and query is or = '{}'", object, supportedFeatures, or)
		for (paramName : supportedFeatures) {
			val eAttribute = object.eClass.EAllAttributes.filter[it.name == paramName].head
			val toCheck = object.eGet(eAttribute)

			if(toCheck != null) {
				for (value : req.parameterMap.get(paramName)) {
					logger.debug("Check attribute '{}' with value '{}' matches '{}'", paramName, toCheck, value)
					criterias++
					if(toCheck.toString.toLowerCase.contains(value.toLowerCase)) {
						logger.debug("MATCHES")
						matches++
					}
				}
			}
		}
		logger.debug("Matches '{}' - Criterias '{}'", matches, criterias)
		if(or && matches > 0) {
			return true
		}
		if(!or && matches == criterias) {
			return true
		}
		return false
	}

	def private dispatch orderBy(HttpServletRequest req, Object object) {
		return object
	}

	def private dispatch orderBy(HttpServletRequest req, EObject object) {
		return object
	}

	def private dispatch orderBy(HttpServletRequest req, List<EObject> list) {
		val orderBy = req.orderBy
		if(orderBy != null) {
			logger.debug("OrderBy '{}'", orderBy)
			Collections.sort(list, new AttributeComparator(orderBy))
		} else {
			logger.debug("OrderBy '{}'", "name")
			Collections.sort(list, new AttributeComparator("name"))
		}
		return list
	}
}
