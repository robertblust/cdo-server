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

import ch.flatland.cdo.model.config.AuthenticatorType
import ch.flatland.cdo.util.JsonConverter
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*
import static ch.flatland.cdo.util.Constants.*

class AuthHttpContext implements HttpContext {

	val logger = LoggerFactory.getLogger(this.class)
	
	override handleSecurity(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		val extension Request = new Request
		val extension Response = new Response
		
		req.logRequest
		
		// only allow https
		if(!req.secureConnection) {
			logger.debug("Forbidden - not secure (https)")
			resp.sendError(req, resp.statusForbidden)
			return false
		}
		
		// CORS request
		if (req.method == METHOD_OPTIONS) {
			return true
		}

		// check accepted contentypes
		if(!req.acceptable) {
			logger.debug("Forbidden - wrong content type")
			resp.sendError(req, resp.statusNotAcceptable)
			return false
		}

		val repository = CONFIG.repositories.filter[it.dataStore.repositoryName == req.repoName].head
		// check if authorization header is available or repo does not requires authentication
		if(!req.basicAuth && repository.authenticator.authenticatorType != AuthenticatorType.NONE) {
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
