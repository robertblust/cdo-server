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
import org.eclipse.emf.cdo.common.security.NoPermissionException
import org.eclipse.emf.ecore.util.EcoreUtil
import org.slf4j.LoggerFactory
import org.eclipse.emf.cdo.eresource.CDOResource

class Delete {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension EMF = new EMF

	def void run(HttpServletRequest req, HttpServletResponse resp) {

		val extension JsonConverter = req.createJsonConverter(RepoAccessServlet.SERVLET_CONTEXT)

		val view = SessionFactory.getCDOSession(req).openTransaction
		var String jsonString = null

		try {
			val body = req.safeReadBody
			logger.debug("Run for '{}' with body '{}'", req.userId, body)

			val jsonObject = body.safeFromJson
			val id = jsonObject.safeResolveId

			logger.debug("Object '{}' requested", id)

			val requestedObject = view.safeRequestObject(id.value.safeAsLong)

			logger.debug("Object '{}' loaded type of {}", id, requestedObject.eClass.type)

			requestedObject.safeCanWrite(id)

			try {
				if (requestedObject instanceof CDOResource) {
					val resource = requestedObject as CDOResource
					if (resource.eContents.size > 0) {
						throw new FlatlandException('''Resource '«id»' cannot be deleted cause not empty''', HttpServletResponse.SC_CONFLICT)
					}
				}
				
				EcoreUtil.delete(requestedObject, true)
			} catch (NoPermissionException npe) {
				throw new FlatlandException(npe.message, HttpServletResponse.SC_FORBIDDEN)
			}
			view.commit

			// now transform manipulated object to json for the reponse			
			jsonString = JsonConverter.okToJson

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

}
