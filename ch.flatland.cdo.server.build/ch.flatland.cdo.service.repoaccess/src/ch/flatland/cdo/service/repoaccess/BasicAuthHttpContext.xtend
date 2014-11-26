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

import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.JsonConverter
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.util.Request.*
import static extension ch.flatland.cdo.util.Response.*

class BasicAuthHttpContext implements HttpContext {

	val logger = LoggerFactory.getLogger(this.class)

	override handleSecurity(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// only allow https
		if (!req.secure) {
			logger.debug("Forbidden")
			resp.status = HttpServletResponse.SC_FORBIDDEN
			writeException(req, resp, new FlatlandException(HttpServletResponse.SC_FORBIDDEN + " - Forbidden!"))
			return false
		}

		// check if authorization header is available
		if (!req.basicAuth) {
			logger.debug("No basic auth in request")
			resp.status = HttpServletResponse.SC_UNAUTHORIZED
			writeException(req, resp,
				new FlatlandException(HttpServletResponse.SC_UNAUTHORIZED + " - Unauthorized!"))
			return false
		}

		try {

			// try to create a CDOSession and reuse the CDO Authentication
			SessionFactory.getOrCreateCDOSession(req)
		} catch (Exception e) {
			logger.debug("Authentication failed - '{}' > stacktrace '{}'", req.userId, e)
			resp.status = HttpServletResponse.SC_UNAUTHORIZED
			writeException(req, resp,
				new FlatlandException(HttpServletResponse.SC_UNAUTHORIZED + " - Unauthorized!"))
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

	def writeException(HttpServletRequest req, HttpServletResponse resp, Exception exception) {
		val extension JsonConverter = new JsonConverter
		resp.writeResponse(req, exception.toJson)
	}
}
