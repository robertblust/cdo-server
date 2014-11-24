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

import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.service.repoaccess.BasicAuth.*

class BasicAuthHttpContext implements HttpContext {

	val logger = LoggerFactory.getLogger(this.class)

	override handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// only allow https
		if (!request.getScheme().equals("https")) {
			logger.debug("Forbidden")
			
			response.sendError(HttpServletResponse.SC_FORBIDDEN)
			return false
		}

		// check if authorization header is available
		if (request.getHeader("Authorization") == null) {
			logger.debug("No basic auth in request")
			
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
			return false
		}

		try {

			// try to create a CDOSession and reuse the CDO Authentication
			SessionFactory.getOrCreateCDOSession(request)
		} catch (Exception e) {
			logger.debug("Authentication failed - {}", request.userId)
			
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
			if (RepoAccessPlugin.getDefault.debugging) {
				e.printStackTrace
			}
			return false
		}
		logger.debug("Authentication OK - {}", request.userId)
		return true

	}

	override getMimeType(String name) {
		return null
	}

	override getResource(String name) {
		return null
	}
}
