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
package ch.flatland.cdo.util

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class Response {
	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request

	def writeResponse(HttpServletResponse resp, HttpServletRequest req, String jsonString) {
		logger.debug("Json '{}'", jsonString)

		// write response
		if(req.jsonCallback !== null) {
			resp.contentType = JSONP_CONTENTTYPE
			resp.writer.append('''«req.jsonCallback»(«jsonString»)''')
		} else {
			resp.contentType = JSON_CONTENTTYPE
			resp.writer.append(jsonString)
		}
	}

	def writeEmptyResponse(HttpServletResponse resp, HttpServletRequest req) {
		logger.debug("Return empty response")

		// write response
		if(req.jsonCallback !== null) {
			resp.contentType = JSONP_CONTENTTYPE

		} else {
			resp.contentType = JSON_CONTENTTYPE
		}
	}

	def statusForbidden(HttpServletResponse resp) {
		resp.status = SC_FORBIDDEN
		return new FlatlandException(SC_FORBIDDEN, "Forbidden")
	}

	def statusUnauthorized(HttpServletResponse resp) {
		resp.status = SC_UNAUTHORIZED
		return new FlatlandException(SC_UNAUTHORIZED, "Unauthorized")
	}

	def statusMethodNotAllowed(HttpServletResponse resp) {
		resp.status = SC_METHOD_NOT_ALLOWED
		return new FlatlandException(SC_METHOD_NOT_ALLOWED, "Method not allowed")
	}

	def statusNotAcceptable(HttpServletResponse resp) {
		resp.status = SC_NOT_ACCEPTABLE
		return new FlatlandException(SC_NOT_ACCEPTABLE, "Not acceptable")
	}

	def statusCreated(HttpServletResponse resp) {
		resp.status = SC_CREATED
	}
}
