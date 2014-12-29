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
package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.util.EMF
import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import ch.flatland.cdo.util.View
import com.google.gson.JsonObject
import java.util.List
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.util.CommitException
import org.eclipse.emf.ecore.EReference
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class Post {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension EMF = new EMF
	val extension View = new View

	/*
	 * Sample json request body
	   {
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

			if(!req.methodAllowed(object)) {
				throw resp.statusMethodNotAllowed
			}
			val container = object as CDOObject

			logger.debug("Object '{}' loaded with type {}", container.cdoID, container.eClass.type)

			container.safeCanWrite

			val body = req.safeReadBody

			logger.debug("Run for '{}' with body '{}'", req.userId, body)

			val referenceName = req.pathSegments.get(req.pathSegments.size - 1)

			val eReference = container.eClass.EAllReferences.filter[it.name == referenceName].head

			if(eReference == null) {
				throw new FlatlandException(SC_BAD_REQUEST, container, "Object '{}' does not support the feature '{}'", container.cdoID, referenceName)
			}
			if(!eReference.isContainmentSettable) {
				throw new FlatlandException(SC_BAD_REQUEST, container, "Feature '{}' is not a containment", referenceName)
			}

			val jsonElement = body.safeFromJson

			if(jsonElement.isJsonArray) {
				jsonElement.asJsonArray.forEach [
					createObject(it.asJsonObject, container, eReference, req)
				]
			} else {
				createObject(jsonElement.asJsonObject, container, eReference, req)
			}

			view.addRevisionDelta(container, JsonConverter.revisionDeltas)

			try {
				view.commit
			} catch(CommitException e) {
				view.rollback
				throw new FlatlandException(SC_BAD_REQUEST, container, e.message)
			}

			// now transform manipulated object to json for the reponse			
			jsonString = container.safeToJson
			resp.status = SC_CREATED

		} catch(FlatlandException e) {
			resp.status = e.httpStatus
			jsonString = e.safeToJson
			logger.debug("Request failed", e)
		} finally {
			if(!view.closed) {
				view.close
			}
		}
		resp.writeResponse(req, jsonString)
	}

	def private createObject(JsonObject jsonObject, CDOObject container, EReference eReference, HttpServletRequest req) {
		val extension JsonConverter = req.createJsonConverter

		val type = jsonObject.safeResolveType

		val newObject = container.view.safeCreateType(type.value.asString)

		jsonObject.toEObject = newObject

		if(eReference.many) {
			val objects = container.eGet(eReference) as List<Object>
			try {
				objects.add(newObject)
			} catch(ArrayStoreException e) {
				throw new FlatlandException(SC_BAD_REQUEST, container, "'{}' does not support type '{}'", eReference.name, type)
			}
		} else {
			container.eSet(eReference, newObject)
		}
	}

	def private methodAllowed(HttpServletRequest req, Object object) {
		if(!(object instanceof CDOObject) || req.pointInTime != null || req.pathSegments == null || req.pathSegments.get(req.pathSegments.size - 2) != REFERENCES) {
			return false
		}
		return true
	}
}
