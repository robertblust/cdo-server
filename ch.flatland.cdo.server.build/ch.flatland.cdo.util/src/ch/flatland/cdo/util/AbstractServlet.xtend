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
	val static PARAM_JSONP_CALLBACK = "callback"
	val static extension JsonConverter = new JsonConverter

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
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	override protected doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	override protected doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	override protected doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	override protected doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	override protected doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeResponse(req, resp, new FlatlandException(HttpServletResponse.SC_METHOD_NOT_ALLOWED.toString).toJson)
	}

	def protected writeResponse(HttpServletRequest req, HttpServletResponse resp, String jsonString) {
		logger.debug("Response json {}", jsonString)

		// write response
		if (req.getParameter(PARAM_JSONP_CALLBACK) != null && req.getParameter(PARAM_JSONP_CALLBACK).length > 0) {
			resp.contentType = Json.JSON_CONTENTTYPE_UTF8
			resp.writer.append('''«req.getParameter(PARAM_JSONP_CALLBACK)»(«jsonString»)''')
		} else {
			resp.contentType = Json.JSONP_CONTENTTYPE_UTF8
			resp.writer.append(jsonString)
		}
	}

	def logRequest(HttpServletRequest req) {
		var userId = "anonymous"
		if (req.basicAuth) {
			userId = req.userId
		}
		logger.debug("Request {} with params {} from {}", req.requestURL, req.parameterMap, userId)
	}
}
