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

import com.google.common.base.Splitter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.id.CDOIDUtil
import org.eclipse.emf.cdo.common.security.CDOPermission
import org.eclipse.emf.cdo.view.CDOView
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*

class View {
	val logger = LoggerFactory.getLogger(this.class)
	val extension EMF = new EMF
	val extension Request = new Request

	def safeRequestResource(CDOView view, HttpServletRequest req) {
		val alias = "/" + Splitter.on("/").split(req.requestURL).get(3)

		try {
			switch (alias) {
				case ALIAS_REPO: {
					if (req.pathInfo != null) {
						return view.getResourceNode(req.pathInfo)
					} else {
						return view.getResourceNode("/home/" + req.userId)
					}
				}
				case ALIAS_OBJECT: {
					val pathSegments = Splitter.on("/").split(req.pathInfo)
					switch (pathSegments.size) {
						case 1: {
						}
						case 2: {
							return view.requestObjectList(pathSegments.get(1))
						}
						case 3: {
							val ePackage = view.ePackage(pathSegments.get(1).safePackagePrefix)
							val eClass = ePackage.getEClassifier(pathSegments.get(1).safeEType)
							if (eClass == null) {
								throw new Exception
							}
							return view.getObject(CDOIDUtil.createLong(Long.parseLong(pathSegments.get(2))))
						}
						default:
							throw new Exception
					}
				}
				default:
					throw new Exception
			}
		} catch (Exception e) {
			logger.debug("Exception '{}'", e.message)
			throw new FlatlandException('''«req.pathInfo» not found''', HttpServletResponse.SC_NOT_FOUND)
		}
	}

	def requestObjectList(CDOView view, String type) {
		val result = newArrayList
		//val query = view.createQuery("ocl", type.safeEType + ".allInstances()")
		val query = view.createQuery("sql", "SELECT cdo_id FROM " + type.replace(".", "_") + " WHERE cdo_revised = 0 and cdo_version > 0")
		logger.debug("Execute '{}' query '{}'", query.queryLanguage, query.queryString)
		val iterator = query.getResultAsync(typeof(CDOObject))
		while (iterator.hasNext) {
			val obj = iterator.next
			logger.debug("Found '{}'", obj)
			result.add(obj)
		}
		iterator.close
		return result
	}

	def safeRequestObject(CDOView view, long id) {
		try {
			return view.getObject(CDOIDUtil.createLong(id))
		} catch (Exception e) {
			throw new FlatlandException('''No object found with '«ID»=«id»' ''', HttpServletResponse.SC_BAD_REQUEST)
		}
	}

	def safeCanWrite(CDOObject object) {
		if (object.cdoPermission != CDOPermission.WRITE) {
			throw new FlatlandException("No permission to edit object '" + object.cdoID + "'",
				HttpServletResponse.SC_FORBIDDEN)
		}
	}
}
