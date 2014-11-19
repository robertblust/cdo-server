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

class AbstractAccessServlet extends HttpServlet {
	
	val logger = LoggerFactory.getLogger(this.class)

	override init() throws ServletException {
		super.init()
		logger.debug("init")
	}

	def logRequest(HttpServletRequest req) {
		logger.debug("Request {} with params {} from {}", req.pathInfo, req.parameterMap, req.userId)
	}
}
