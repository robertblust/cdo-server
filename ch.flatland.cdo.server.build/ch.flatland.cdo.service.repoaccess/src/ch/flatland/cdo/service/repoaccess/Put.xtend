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
import org.slf4j.LoggerFactory

import static javax.servlet.http.HttpServletResponse.*

class Put {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension EMF = new EMF
	val extension View = new View

	/*
	 * Sample json request body
	   {
	 		"put": "elements",
	 		"type": "base.FLPackage",
	 			"attributes": {
	 				"name": "New Child"
	  			}
	   }
	 * 
	 */
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
			val put = jsonObject.safeResolvePut
			val type = jsonObject.safeResolveType

			logger.debug("Object '{}' loaded type of {}", requestedObject.cdoID, requestedObject.eClass.type)

			requestedObject.safeCanWrite

			val newObject = view.safeCreateType(type.value.asString)

			val eReference = requestedObject.eClass.EAllReferences.filter[it.name == put.value.asString].head

			if(eReference == null) {
				throw new FlatlandException(SC_BAD_REQUEST, "Object '{}' does not support '{}'", requestedObject.cdoID, put)
			}
			if(!eReference.isContainmentSettable) {
				throw new FlatlandException(SC_BAD_REQUEST, "Feature '{}' is not a containment", put)
			}

			jsonObject.toEObject = newObject

			if(eReference.many) {
				val objects = requestedObject.eGet(eReference) as List<Object>
				try {
					objects.add(newObject)
				} catch (ArrayStoreException e) {
					throw new FlatlandException(SC_BAD_REQUEST, "'{}' does not support type '{}'", put, type)
				}
				
			} else {
				requestedObject.eSet(eReference, newObject)
			}

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
		resp.status = SC_CREATED
		resp.writeResponse(req, jsonString)
	}
}
