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
package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.util.EMF
import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import ch.flatland.cdo.util.View
import java.util.List
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.security.NoPermissionException
import org.eclipse.emf.cdo.eresource.CDOResourceNode
import org.eclipse.emf.cdo.view.CDOView
import org.slf4j.LoggerFactory

import static javax.servlet.http.HttpServletResponse.*

class Delete {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension View = new View
	val extension EMF = new EMF

	def void run(HttpServletRequest req, HttpServletResponse resp) {

		val extension JsonConverter = req.createJsonConverter

		val view = SessionFactory.getCDOSession(req).openTransaction
		var String jsonString = null

		try {
			logger.debug("Run for '{}'", req.userId)
			
			val object = view.safeRequestResource(req, resp)
			if (!(object instanceof CDOObject)) {
				throw resp.statusMethodNotAllowed
			}
			val requestedObject = object as CDOObject

			logger.debug("Object '{}' loaded type of {}", requestedObject.cdoID, requestedObject.eClass.type)

			requestedObject.safeCanWrite

			try {
				if(requestedObject instanceof CDOResourceNode) {
					val resource = requestedObject
					if(resource.eContents.size > 0) {
						throw new FlatlandException(SC_CONFLICT, "Resource '{}' cannot be deleted cause not empty", requestedObject.cdoID)
					}
				}

				view.xRefsDelete(requestedObject)

			} catch(NoPermissionException npe) {
				throw new FlatlandException(SC_FORBIDDEN, npe.message)
			}

			view.commit

			// now transform manipulated object to json for the reponse			
			jsonString = JsonConverter.okToJson
		} catch(FlatlandException e) {
			resp.status = e.httpStatus
			jsonString = e.safeToJson
			logger.error("Request failed", e)
		} finally {
			if(!view.closed) {
				view.close
			}
		}
		resp.writeResponse(req, jsonString)
	}

	def private xRefsDelete(CDOView view, CDOObject cdoObject) {
		val suspects = newArrayList
		suspects.add(cdoObject)
		suspects.addAll(cdoObject.eAllContents.toList)

		suspects.forEach [
			view.queryXRefs(it as CDOObject, emptyList).forEach [
				val source = it.sourceObject
				val sourceFeature = it.sourceFeature
				val sourceIndex = it.sourceIndex
				logger.debug("Found xref feature '{}', source '{}', index '{}'", sourceFeature.name, source, sourceIndex)
				if(sourceFeature.isMany) {
					(source.eGet(sourceFeature) as List<Object>).remove(sourceIndex)
				} else {
					source.eUnset(sourceFeature)
				}
			]
		]
		val container = cdoObject.eContainer
		if(container == null) {

			// must be a CDOResource Node
			val resource = cdoObject.cdoResource
			resource.contents.remove(cdoObject)
		} else {
			val containingFeature = cdoObject.eContainingFeature
			if(containingFeature.isMany) {
				(container.eGet(containingFeature) as List<Object>).remove(cdoObject)
			} else {
				container.eUnset(containingFeature)
			}
		}
	}
}
