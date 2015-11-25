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

	val static ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin"
	val static ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials"
	val static ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods"
	val static ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers"
	val static HEADER_ORIGIN = "Origin"

	val extension Request = new Request

	def writeResponse(HttpServletResponse resp, HttpServletRequest req, String jsonString) {
		logger.debug("Json '{}'", jsonString)

		resp.addCORSHeader(req)
		
		// write response
		if(req.jsonCallback != null) {
			resp.contentType = JSONP_CONTENTTYPE_UTF8
			resp.writer.append('''«req.jsonCallback»(«jsonString»)''')
		} else {
			resp.contentType = JSON_CONTENTTYPE_UTF8
			resp.writer.append(jsonString)
		}
	}

	def writeEmptyResponse(HttpServletResponse resp, HttpServletRequest req) {
		logger.debug("Return empty response")

		resp.addCORSHeader(req)
		
		// write response
		if(req.jsonCallback != null) {
			resp.contentType = JSONP_CONTENTTYPE_UTF8

		} else {
			resp.contentType = JSON_CONTENTTYPE_UTF8
		}
	}

	def private addCORSHeader(HttpServletResponse resp, HttpServletRequest req) {
		if (req.getHeader(HEADER_ORIGIN) != null) {
			resp.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, req.getHeader("Origin"))
		}
		resp.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true")
		resp.addHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE")
		resp.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Origin, X-Requested-With, Content-Type, Accept, Authorization, Cookie")
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
