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

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*

class Response {
	val logger = LoggerFactory.getLogger(this.class)
	
	def writeResponse(HttpServletResponse resp, HttpServletRequest req, String jsonString) {
		logger.debug("Json '{}'", jsonString)

		// write response
		if (req.getParameter(PARAM_JSONP_CALLBACK) != null && req.getParameter(PARAM_JSONP_CALLBACK).length > 0) {
			resp.contentType = JSONP_CONTENTTYPE_UTF8
			resp.writer.append('''«req.getParameter(PARAM_JSONP_CALLBACK)»(«jsonString»)''')
		} else {
			resp.contentType = JSON_CONTENTTYPE_UTF8
			resp.writer.append(jsonString)
		}
	}
	
	def statusForbidden(HttpServletResponse resp) {
		resp.status = HttpServletResponse.SC_FORBIDDEN
		return new FlatlandException("Forbidden", resp.status)
	}
	
	def statusUnauthorized(HttpServletResponse resp) {
		resp.status = HttpServletResponse.SC_UNAUTHORIZED
		return new FlatlandException("Unauthorized", resp.status)
	}
	
	def statusMethodNotAllowed(HttpServletResponse resp) {
		resp.status = HttpServletResponse.SC_METHOD_NOT_ALLOWED
		return new FlatlandException("Method not allowed", resp.status)
	}
	
	def statusNotAcceptable(HttpServletResponse resp) {
		resp.status = HttpServletResponse.SC_NOT_ACCEPTABLE
		return new FlatlandException("Not acceptable", resp.status)
	}
}
