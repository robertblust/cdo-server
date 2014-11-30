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
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory

class Put {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension EMF = new EMF

	/*
	 * Sample json request body
	 * {
	 *		"id": 41,
	 *		"put": "elements",
	 *		"type": "ch.flatland.cdo.model.base.FLPackage",
	 *			"attributes": {
	 *				"name": "New Child"
	 *			}
	 * }
	 * 
	 */
	def void run(HttpServletRequest req, HttpServletResponse resp) {

		val extension JsonConverter = req.createJsonConverter(RepoAccessServlet.SERVLET_CONTEXT)

		val view = SessionFactory.getCDOSession(req).openTransaction
		var String jsonString = null

		try {
			val body = req.safeReadBody
			logger.debug("Run for '{}' with body '{}'", req.userId, body)

			val jsonObject = body.safeFromJson
			val id = jsonObject.safeResolveId
			val put = jsonObject.safeResolvePut
			val type = jsonObject.safeResolveType
 			
			logger.debug("Object '{}' requested to '{}({})'", id, put, type)

			val requestedObject = view.safeRequestObject(id.value.safeAsLong)

			logger.debug("Object '{}' loaded type of {}", id, requestedObject.eClass.type)

			requestedObject.safeCanWrite(id)
			
			type.value.asString.nsUri
			type.value.asString.eType

			//jsonObject.toEObject = requestedObject

			//view.commit

			// now transform manipulated object to json for the reponse			
			jsonString = requestedObject.safeToJson

		} catch (FlatlandException e) {
			resp.status = e.httpStatus
			jsonString = e.safeToJson
			logger.error("Request failed", e)
		} finally {
			if (!view.closed) {
				view.close
			}
		}
		resp.writeResponse(req, jsonString)
	}
	
	def private nsUri(String type) {
		val segments = type.split("\\.")
		val nsUri = type.replace("." + segments.get(segments.size -1), "")
		println(nsUri)
		return nsUri
	}
	
	def private eType(String type) {
		val segments = type.split("\\.")
		val eType = segments.get(segments.size -1)
		println(eType)
		return eType
	}
}