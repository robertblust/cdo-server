/*
 * Copyright (c) 2014 Robert Blust (Zürich, Switzerland) and others.
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
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.view.CDOView
import org.eclipse.emf.ecore.EObject
import org.slf4j.LoggerFactory

class DataStore {
	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension EMF = new EMF

	def findByType(CDOView view, String type) {

		// TODO sql depends on mapping strategy
		val List<EObject> result = newArrayList
		
		var orderBy = ""
		if (view.safeEClass(type).nameAttribute != null) {
			orderBy = " ORDER BY name"
		}

		//val query = view.createQuery("ocl", type.safeEType + ".allInstances()")
		val query = view.createQuery("sql", "SELECT cdo_id FROM " + type.replace(".", "_") + " WHERE cdo_revised = 0 and cdo_version > 0" + orderBy)
		logger.debug("Execute '{}' query '{}'", query.queryLanguage, query.queryString)
		val iterator = query.getResultAsync(typeof(CDOObject))
		while(iterator.hasNext) {
			val obj = iterator.next
			logger.debug("Found '{}'", obj)
			result.add(obj)
		}
		iterator.close
		return result
	}

	def filterByAttribute(List<EObject> objects, HttpServletRequest req) {
		if(req.xor) {
			return objects.filterByAttributeXOR(req)
		}
		return objects.filterByAttributeAND(req)
	}

	def private filterByAttributeXOR(List<EObject> objects, HttpServletRequest req) {
		if(objects.size == 0 || req.parameterMap.size == 0) {
			return objects
		}
		val matches = newArrayList
		val eClass = objects.get(0).eClass

		val params = req.parameterMapValueNotNull
		for (paramName : params.keySet) {
			logger.debug("Parameter name for filter '{}'", paramName)
			val attribute = eClass.getAttribute(paramName)
			if(attribute != null) {
				for (object : objects) {
					if(object.eGet(attribute) != null) {
						val objectValue = object.eGet(attribute).toString.toLowerCase
						val paramValue = params.get(paramName).toLowerCase
						logger.debug("Compare values '{}' contains '{}'", objectValue, paramValue)
						if(objectValue.contains(paramValue)) {
							logger.debug("Match '{}'", object)
							if(!matches.contains(object)) {
								matches.add(object)
							}
						}
					}
				}
			}
		}
		return matches
	}

	def private filterByAttributeAND(List<EObject> objects, HttpServletRequest req) {
		if(objects.size == 0 || req.parameterMap.size == 0) {
			return objects
		}
		val matches = newArrayList
		matches.addAll(objects)
		val eClass = objects.get(0).eClass
		var processed = false

		val params = req.parameterMapValueNotNull
		for (paramName : params.keySet) {
			logger.debug("Parameter name for filter '{}'", paramName)
			val attribute = eClass.getAttribute(paramName)
			if(attribute != null) {
				for (object : objects) {
					if(object.eGet(attribute) != null) {
						val objectValue = object.eGet(attribute).toString.toLowerCase
						val paramValue = params.get(paramName).toLowerCase
						if(!objectValue.contains(paramValue)) {
							logger.debug("Reduce '{}'", object)
							matches.remove(object)
							processed = true
						}
					} else {
						logger.debug("Reduce '{}'", object)
						matches.remove(object)
						processed = true
					}
				}
			}
		}

		if(processed) {
			return matches
		} else {
			return emptyList
		}
	}
}
