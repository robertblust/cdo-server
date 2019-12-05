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
package ch.flatland.cdo.service.repoaccess.internal

import ch.flatland.cdo.service.repoaccess.SessionFactory
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
import org.eclipse.emf.cdo.util.CommitException
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.ecore.EObject
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

			if(!req.methodAllowed) {
				throw resp.statusMethodNotAllowed
			}
			val object = view.safeRequestResource(req, resp)
			if(!(object instanceof CDOObject)) {
				throw resp.statusMethodNotAllowed
			}

			val requestedObject = object as CDOObject

			logger.debug("Object '{}' loaded type of {}", requestedObject.cdoID, requestedObject.eClass.type)

			requestedObject.safeCanWrite

			switch req.pathSegments.size {
				case 3: {

					// delete containment
					try {
						if(requestedObject instanceof CDOResourceNode) {
							val resource = requestedObject
							if(resource.eContents.size > 0) {
								throw new FlatlandException(SC_CONFLICT, resource, "Resource '{}' cannot be deleted cause not empty", requestedObject.cdoID)
							}
						}

						view.xRefsDelete(requestedObject)

					} catch(NoPermissionException npe) {
						throw new FlatlandException(SC_FORBIDDEN, requestedObject, npe.message)
					}
				}
				case 6: {

					// delete reference
					val referenceName = req.pathSegments.get(4)

					val eReference = requestedObject.eClass.EAllReferences.filter[it.name == referenceName].head

					if(eReference === null) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, "Object '{}' does not support the feature '{}'", requestedObject.cdoID, referenceName)
					}
					if(!eReference.isReferenceSettable) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, "Feature '{}' is not a containment", referenceName)
					}

					try {
						var removed = false
						val refToDelete = view.safeResolveObject(req.pathSegments.get(5))
						if(eReference.isMany) {
							val eList = requestedObject.eGet(eReference, true) as List<EObject>
							if(refToDelete instanceof Adapter) {
								removed = eList.remove(refToDelete.target)
							} else {
								removed = eList.remove(refToDelete)
							}
						} else {
							val eRef = requestedObject.eGet(eReference, true) as EObject
							if(refToDelete instanceof Adapter) {
								if(eRef == refToDelete.target) {
									requestedObject.eUnset(eReference)
									removed = true
								}
							} else {
								if(eRef == refToDelete) {
									requestedObject.eUnset(eReference)
									removed = true
								}
							}
						}
						if(!removed) {
							throw new FlatlandException(SC_BAD_REQUEST, requestedObject, "Feature '{}' does not refers to '{}'", eReference.name, refToDelete)
						}
					} catch(Exception e) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, e.message)
					}
				}
			}

			view.addRevisionDelta(JsonConverter.revisionDeltas)

			try {
				view.commit
			} catch(CommitException e) {
				view.rollback
				throw new FlatlandException(SC_BAD_REQUEST, requestedObject, e.message)
			}

			// now transform manipulated object to json for the response		
			if(req.pathSegments.size == 3) {

				// object was deleted
				jsonString = JsonConverter.okToJson
			} else {

				// reference of object was removed
				jsonString = requestedObject.safeToJson
			}

		} catch(FlatlandException e) {
			e.printStackTrace
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
}
