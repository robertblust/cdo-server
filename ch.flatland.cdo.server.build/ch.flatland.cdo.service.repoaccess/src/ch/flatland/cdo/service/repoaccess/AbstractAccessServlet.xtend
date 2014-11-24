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

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.service.repoaccess.BasicAuth.*
import javax.servlet.ServletConfig

class AbstractAccessServlet extends HttpServlet {
	
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

	def logRequest(HttpServletRequest req) {
		logger.debug("Request {} with params {} from {}", req.pathInfo, req.parameterMap, req.userId)
	}
}
