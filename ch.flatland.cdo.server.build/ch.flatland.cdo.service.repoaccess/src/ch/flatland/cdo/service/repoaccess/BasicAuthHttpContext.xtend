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
import ch.flatland.cdo.util.Json
import ch.flatland.cdo.util.JsonConverter
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.util.Request.*

class BasicAuthHttpContext implements HttpContext {

	val logger = LoggerFactory.getLogger(this.class)

	override handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// only allow https
		if (!request.secure) {
			logger.debug("Forbidden")
			response.status = HttpServletResponse.SC_FORBIDDEN
			writeException(response, new FlatlandException(HttpServletResponse.SC_FORBIDDEN + " - Forbidden!"))
			return false
		}

		// check if authorization header is available
		if (!request.basicAuth) {
			logger.debug("No basic auth in request")
			response.status = HttpServletResponse.SC_UNAUTHORIZED
			writeException(response, new FlatlandException(HttpServletResponse.SC_UNAUTHORIZED + " - Unauthorized!"))
			return false
		}

		try {

			// try to create a CDOSession and reuse the CDO Authentication
			SessionFactory.getOrCreateCDOSession(request)
		} catch (Exception e) {
			logger.debug("Authentication failed - '{}' > stacktrace '{}'", request.userId, e)
			response.status = HttpServletResponse.SC_UNAUTHORIZED
			writeException(response, e)
			return false
		}
		logger.debug("Authentication OK for '{}'", request.userId)
		return true

	}

	override getMimeType(String name) {
		return null
	}

	override getResource(String name) {
		return null
	}
	
	def writeException(HttpServletResponse response, Exception exception) {
		val extension JsonConverter = new JsonConverter
		response.contentType = Json.JSON_CONTENTTYPE_UTF8
		response.writer.append(exception.toJson)
	}
}
