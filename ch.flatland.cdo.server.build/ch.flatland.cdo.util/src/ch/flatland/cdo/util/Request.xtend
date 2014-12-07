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
import org.apache.commons.codec.binary.Base64

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class Request {

	val public static AUTH_HEADER = "Authorization"
	val public static AUTH_BASIC = "Basic"
	val public static ACCEPT_HEADER = "Accept"

	def getParameterNameAsListValueNotNull(HttpServletRequest req) {
		val params = newArrayList
		val enum = req.parameterNames
		while(enum.hasMoreElements) {
			val paramName = enum.nextElement
			if(req.getParameter(paramName) != null && req.getParameter(paramName).length > 0) {
				params.add(paramName)
			}
		}
		return params
	}

	def getJsonCallback(HttpServletRequest req) {
		if(req.getParameter(PARAM_JSONP_CALLBACK) != null && req.getParameter(PARAM_JSONP_CALLBACK).length > 0) {
			return req.getParameter(PARAM_JSONP_CALLBACK)
		}
		return null
	}
	
	def getOrderBy(HttpServletRequest req) {
		if(req.getParameter(PARAM_ORDER_BY) != null && req.getParameter(PARAM_ORDER_BY).length > 0) {
			return req.getParameter(PARAM_ORDER_BY)
		}
		return null
	}
	
	def isValidate(HttpServletRequest req) {
		return req.getParameter(PARAM_VALIDATE) != null
	}

	def isXor(HttpServletRequest req) {
		return req.getParameter(PARAM_XOR_FILTER) != null
	}

	def isNoRefs(HttpServletRequest req) {
		return req.getParameter(PARAM_NO_REFS) != null
	}

	def isMetaDataRequested(HttpServletRequest req) {
		return req.getParameter(PARAM_META) != null
	}

	def isForceRequested(HttpServletRequest req) {
		return req.getParameter(PARAM_FORCE) != null
	}

	def getUserId(HttpServletRequest request) {
		val userNameIndex = request.safeUserNameAndPassword.indexOf(":")
		val userName = request.safeUserNameAndPassword.substring(0, userNameIndex)
		return userName
	}

	def getSessionId(HttpServletRequest request) {
		return request.session.id
	}

	def getSessionKey(HttpServletRequest request) {
		return request.sessionId + "-" + request.userId
	}

	def getPassword(HttpServletRequest request) {
		val userNameIndex = request.safeUserNameAndPassword.indexOf(":")
		val password = request.safeUserNameAndPassword.substring(userNameIndex + 1)
		return password
	}

	def isBasicAuth(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER) != null && request.getHeader(AUTH_HEADER).toLowerCase.startsWith(AUTH_BASIC.toLowerCase)
	}

	def isAcceptable(HttpServletRequest request) {
		val acceptHeader = request.getHeader(ACCEPT_HEADER)
		return ACCEPTED_CONTENTTYPES.contains(acceptHeader)
	}

	def createJsonConverter(HttpServletRequest req) {
		return new JsonConverter(new JsonConverterConfig(req))
	}

	// methods which could throw an Exception
	def String safeReadBody(HttpServletRequest request) {
		val buffer = new StringBuffer();
		var String line = null;

		val reader = request.getReader();
		while((line = reader.readLine) != null) {
			buffer.append(line)
		}
		if(buffer.length == 0) {
			throw new FlatlandException(SC_BAD_REQUEST, "Request body must not be empty")
		}
		return buffer.toString
	}

	def private safeUserNameAndPassword(HttpServletRequest request) {
		val authHeader = request.getHeader(AUTH_HEADER)
		if(authHeader == null) {
			throw new FlatlandException(SC_BAD_REQUEST, "Request basic authentication must not be empty")
		}
		val usernameAndPassword = new String(Base64.decodeBase64(authHeader.substring(6).getBytes()))
		return usernameAndPassword
	}
}
