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

import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import ch.flatland.cdo.util.FlatlandException

class Get {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response

	def void run(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("Run for '{}'", req.userId)

		val view = SessionFactory.getCDOSession(req).openView

		var Object requestedObject = null
		var String jsonString = null

		val extension JsonConverter = req.createJsonConverter(RepoAccessServlet.SERVLET_CONTEXT)

		try {

			var processed = false

			// processes id
			if (req.safeIdCheck != null) {
				requestedObject = view.safeRequestObject(req.safeIdCheck)
				processed = true
			}

			// processes path
			if (!processed) {
				view.safeRequestPath(req.pathInfo)		
			}

			jsonString = requestedObject.toJson

		} catch (FlatlandException e) {
			resp.status = e.httpStatus
			jsonString = e.toJson
			logger.error("Request failed", e)
		} finally {
			if (!view.closed) {
				view.close
			}
		}
		resp.writeResponse(req, jsonString)
	}
}
