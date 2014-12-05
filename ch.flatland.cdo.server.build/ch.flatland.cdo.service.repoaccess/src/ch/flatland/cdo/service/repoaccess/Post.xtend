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
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.eclipse.emf.cdo.CDOObject

class Post {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension EMF = new EMF
	val extension View = new View

	def void run(HttpServletRequest req, HttpServletResponse resp) {

		val extension JsonConverter = req.createJsonConverter

		val view = SessionFactory.getCDOSession(req).openTransaction
		var String jsonString = null

		try {
			val object = view.safeRequestResource(req, resp)
			if(!(object instanceof CDOObject)) {
				throw resp.statusMethodNotAllowed
			}
			val requestedObject = object as CDOObject

			val body = req.safeReadBody
			logger.debug("Run for '{}' with body '{}'", req.userId, body)

			val jsonObject = body.safeFromJson

			logger.debug("Object '{}' loaded type of {}", requestedObject.cdoID, requestedObject.eClass.type)

			requestedObject.safeCanWrite

			jsonObject.toEObject = requestedObject

			view.commit

			// now transform manipulated object to json for the reponse			
			jsonString = requestedObject.safeToJson

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
}
