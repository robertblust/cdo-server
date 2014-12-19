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

import ch.flatland.cdo.util.JsonConverter
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext
import org.slf4j.LoggerFactory

class AuthHttpContext implements HttpContext {

	val logger = LoggerFactory.getLogger(this.class)

	override handleSecurity(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		val extension Request = new Request
		val extension Response = new Response

		// only allow https
		if(!req.secure) {
			logger.debug("Forbidden")
			resp.sendError(req, resp.statusForbidden)
			return false
		}

		// check accepted contentypes
		if(!req.acceptable) {
			logger.debug("Forbidden")
			resp.sendError(req, resp.statusNotAcceptable)
			return false
		}

		// check if authorization header is available
		if(!req.basicAuth) {
			logger.debug("No basic auth in request")
			resp.sendError(req, resp.statusUnauthorized)
			return false
		}

		try {

			// try to create or reuse the CDOSession
			SessionFactory.getOrCreateCDOSession(req)
		} catch(Exception e) {
			logger.debug("Authentication failed - '{}' > stacktrace '{}'", req.userId, e)
			resp.sendError(req, resp.statusUnauthorized)
			return false
		}
		logger.debug("Authentication OK for '{}'", req.userId)
		return true

	}

	override getMimeType(String name) {
		return null
	}

	override getResource(String name) {
		return null
	}

	def private sendError(HttpServletResponse resp, HttpServletRequest req, Exception exception) {
		val extension Response = new Response
		val extension JsonConverter = new JsonConverter
		resp.writeResponse(req, exception.safeToJson)
	}
}
