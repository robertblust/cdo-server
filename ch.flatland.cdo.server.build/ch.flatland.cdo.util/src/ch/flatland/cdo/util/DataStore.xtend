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

	def findByType(CDOView view, String type) {

		// TODO sql depends on mapping strategy
		val List<EObject> result = newArrayList

		//val query = view.createQuery("ocl", type.safeEType + ".allInstances()")
		val query = view.createQuery("sql", "SELECT cdo_id FROM " + type.replace(".", "_") + " WHERE cdo_revised = 0 and cdo_version > 0")
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

	def filterByAttributeXOR(List<EObject> objects, HttpServletRequest req) {
		if(objects.size == 0 || req.parameterMap.size == 0) {
			return objects
		}
		val matches = newArrayList
		val eClass = objects.get(0).eClass

		val enum = req.parameterNames
		while(enum.hasMoreElements) {
			val paramName = enum.nextElement
			logger.debug("Parameter name for filter '{}'", paramName)
			for (attribute : eClass.EAllAttributes) {
				if(attribute.name == paramName) {
					logger.debug("Found eAttribute '{}'", attribute.name)
					for (object : objects) {
						if(object.eGet(attribute) != null) {
							val objectValue = object.eGet(attribute).toString.toLowerCase
							val paramValue = req.getParameter(paramName).toLowerCase
							if(objectValue.contains(paramValue)) {
								logger.debug("Match '{}'", object)
								if (!matches.contains(object)) {
									matches.add(object)
								}	
							}
						}

					}
				}
			}
		}
		return matches
	}
	
	def filterByAttributeAND(List<EObject> objects, HttpServletRequest req) {
		if(objects.size == 0 || req.parameterMap.size == 0) {
			return objects
		}
		val matches = newArrayList
		matches.addAll(objects)
		val eClass = objects.get(0).eClass
		
		val enum = req.parameterNames
		while(enum.hasMoreElements) {
			val paramName = enum.nextElement
			logger.debug("Parameter name for filter '{}'", paramName)
			for (attribute : eClass.EAllAttributes) {
				if(attribute.name == paramName) {
					logger.debug("Found eAttribute '{}'", attribute.name)
					for (object : objects) {
						if(object.eGet(attribute) != null) {
							val objectValue = object.eGet(attribute).toString.toLowerCase
							val paramValue = req.getParameter(paramName).toLowerCase
							if(!objectValue.contains(paramValue)) {
								logger.debug("Reduce '{}'", object)
								matches.remove(object)		
							}
						}

					}
				}
			}
		}
		return matches
	}
}
