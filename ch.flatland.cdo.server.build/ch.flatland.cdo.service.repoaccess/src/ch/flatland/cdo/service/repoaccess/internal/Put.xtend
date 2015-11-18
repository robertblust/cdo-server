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
import org.eclipse.emf.cdo.eresource.CDOResource
import org.eclipse.emf.cdo.eresource.CDOResourceFolder
import org.eclipse.emf.cdo.eresource.CDOResourceNode
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.slf4j.LoggerFactory

import static javax.servlet.http.HttpServletResponse.*

class Put {

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

			if(!req.methodAllowed) {
				throw resp.statusMethodNotAllowed
			}
			val object = view.safeRequestResource(req, resp)
			if(!(object instanceof CDOObject)) {
				throw resp.statusMethodNotAllowed
			}
			val requestedObject = object as CDOObject

			switch req.pathSegments.size {
				case 3: {

					// put new attributes
					val body = req.safeReadBody
					logger.debug("Run for '{}' with body '{}'", req.userId, body)

					val jsonElement = body.safeFromJson
					if(!jsonElement.isJsonObject) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, "Request body is not a json object!")
					}

					val jsonObject = jsonElement.asJsonObject

					logger.debug("Object '{}' loaded type of {}", requestedObject.cdoID, requestedObject.eClass.type)

					requestedObject.safeCanWrite

					jsonObject.toEObject = requestedObject

				}
				case 6: {

					// put new relations
					logger.debug("Run for '{}'", req.userId)
					val referenceName = req.pathSegments.get(4)

					val eReference = requestedObject.eClass.EAllReferences.filter[it.name == referenceName].head

					if(eReference == null) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, "Object '{}' does not support the feature '{}'", requestedObject.cdoID, referenceName)
					}
					if(!eReference.isReferenceSettable) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, "Feature '{}' is not a containment", referenceName)
					}

					try {
						val objectToPut = view.safeResolveObject(req.pathSegments.get(5))

						if(eReference.isMany) {
							requestedObject.safeAddReferenceArray(eReference, objectToPut)
						} else {
							requestedObject.safeSetReference(eReference, objectToPut)
						}

					} catch(Exception e) {
						throw new FlatlandException(SC_BAD_REQUEST, requestedObject, e.message)
					}
				}
			}

			view.addRevisionDelta(JsonConverter.revisionDeltas)

			if(requestedObject.eContainer instanceof CDOResourceNode && requestedObject instanceof CDOResourceNode) {

				val node = requestedObject as CDOResourceNode
				val containerNode = requestedObject.eContainer as CDOResourceNode

				// check name is not null
				if(node.name == null || node.name.length == 0) {
					throw new FlatlandException(SC_BAD_REQUEST, containerNode, "Name must not be null or empty")
				}
				// check for duplicates
				if(containerNode instanceof CDOResourceFolder) {
					if(containerNode.nodes.filter[it.name == node.name && it.cdoID != node.cdoID].size > 0) {
						throw new FlatlandException(SC_BAD_REQUEST, containerNode, "Resource with name '{}' already exist!", node.name)
					}
				}

				if(containerNode.isRoot) {
					// it is the root resource, it can just contain resource node
					val root = containerNode as CDOResource
					if(root.contents.filter[(it as CDOResourceNode).name == node.name && (it as CDOResourceNode).cdoID != node.cdoID].size > 0) {
						throw new FlatlandException(SC_BAD_REQUEST, containerNode, "Resource with name '{}' already exist!", node.name)
					}
				}
			}

			view.commit

			// now transform manipulated object to json for the response			
			jsonString = requestedObject.safeToJson

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

	def private safeAddReferenceArray(EObject container, EReference eReference, EObject objectToPut) {
		val eList = container.eGet(eReference, true) as List<EObject>

		if(eReference.upperBound > 0 && (eList.size + 1) > eReference.upperBound) {
			throw new FlatlandException(SC_BAD_REQUEST, container, "Try to add new element to array '{}' with '{}' items having upper limit of '{}'", eReference.name, eList.size, eReference.upperBound)
		}
		try {
			if(objectToPut instanceof Adapter) {
				eList.add(objectToPut.target as EObject)
			} else {
				eList.add(objectToPut)
			}
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, container, "Element has wrong type for reference '{}'", eReference.name)
		}
	}

	def private safeSetReference(EObject container, EReference eReference, EObject refObject) {
		try {
			if(refObject instanceof Adapter) {
				container.eSet(eReference, refObject.target)
			} else {
				container.eSet(eReference, refObject)
			}
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, container, "Object '{}' has wrong type for reference '{}'", refObject, eReference.name)
		}
	}
}
