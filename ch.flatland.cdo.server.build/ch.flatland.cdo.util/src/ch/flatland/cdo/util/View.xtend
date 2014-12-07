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
import static javax.servlet.http.HttpServletResponse.*

class View {
	val logger = LoggerFactory.getLogger(this.class)
	val extension EMF = new EMF
	val extension DataStore = new DataStore

	def safeRequestResource(CDOView view, HttpServletRequest req, HttpServletResponse resp) {
		val alias = "/" + Splitter.on("/").split(req.requestURL).get(3)

		try {
			switch (alias) {
				case ALIAS_NODE: {
					if(req.pathInfo != null) {
						return view.getResourceNode(req.pathInfo)
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
							//return objects.filterByAttribute(req)
							return objects
						}
						case 3: {
							val ePackage = view.ePackage(pathSegments.get(1).safePackagePrefix)
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
						default:
							throw new Exception
					}
				}
				default:
					throw new Exception
			}
		} catch(Exception e) {
			logger.debug("Exception '{}'", e.message)
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
			throw new FlatlandException(SC_FORBIDDEN, "No permission to edit object '{}'", object.cdoID)
		}
	}
}
