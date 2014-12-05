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
package ch.flatland.cdo.util

import java.io.IOException
import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory

class AbstractServlet extends HttpServlet {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response

	val static SESSION_COOKIE = "CH-FLATLAND-CDO"

	override init() throws ServletException {
		super.init()
		logger.debug("init")
	}

	override init(ServletConfig config) throws ServletException {
		config.servletContext.sessionCookieConfig.name = SESSION_COOKIE
		super.init(config)
		logger.debug("init(ServletConfig config) - set cookie name {}", SESSION_COOKIE)
	}

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	override protected doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	override protected doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	override protected doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	override protected doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	override protected doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		methodNotAllowed(req, resp)
	}

	def methodNotAllowed(HttpServletRequest req, HttpServletResponse resp) {
		val extension JsonConverter = new JsonConverter
		resp.writeResponse(req, resp.statusMethodNotAllowed.safeToJson)
	}

	def logRequest(HttpServletRequest req) {
		if(logger.isDebugEnabled) {
			var userId = "anonymous"
			if(req.basicAuth) {
				userId = req.userId
			}
			logger.debug("Request '{}' with params '{}' from '{}'", req.requestURL, req.parameterMap, userId)
			val headerNames = req.headerNames
			while(headerNames.hasMoreElements) {
				val key = headerNames.nextElement
				logger.debug("Http header field '{}'", key)
				val fieldValues = req.getHeaders(key)
				while(fieldValues.hasMoreElements) {
					val value = fieldValues.nextElement
					logger.debug("  '{}'", value)
				}
			}
		}
	}
}
