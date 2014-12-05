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
	val public static ACCEPT_HEADER = "Accept"

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
		return request.getHeader(AUTH_HEADER) != null
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
		while ((line = reader.readLine) != null) {
			buffer.append(line)
		}
		if (buffer.length == 0) {
			throw new FlatlandException(SC_BAD_REQUEST, "Request body must not be empty")
		}
		return buffer.toString
	}

	def private safeUserNameAndPassword(HttpServletRequest request) {
		val authHeader = request.getHeader(AUTH_HEADER)
		if (authHeader == null) {
			throw new FlatlandException(SC_BAD_REQUEST, "Request basic authentication must not be empty")
		}
		val usernameAndPassword = new String(Base64.decodeBase64(authHeader.substring(6).getBytes()))
		return usernameAndPassword
	}
}
