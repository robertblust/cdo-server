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

import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.util.BasicAuth.*
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class AbstractServlet extends HttpServlet {
	
	val logger = LoggerFactory.getLogger(this.class)
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
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET not supported!")
	}
	
	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST not supported!")
	}
	
	override protected doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "PUT not supported!")
	}
	
	override protected doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "DELETE not supported!")
	}
	
	override protected doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "HEAD not supported!")
	}
	
	override protected doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "OPTIONS not supported!")
	}
	
	override protected doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "TRACE not supported!")
	}

	def logRequest(HttpServletRequest req) {
		var userId = "anonymous"
		if (req.basicAuth) {
			userId = req.userId
		}
		logger.debug("Request {} with params {} from {}", req.requestURL, req.parameterMap, userId)
	}
}
