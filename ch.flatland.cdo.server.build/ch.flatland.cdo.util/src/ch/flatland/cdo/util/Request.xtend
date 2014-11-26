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
import javax.servlet.http.HttpServletRequest
import org.apache.commons.codec.binary.Base64

class Request {

	val static AUTH_HEADER = "Authorization"

	def getUserId(HttpServletRequest request) {
		val userNameIndex = request.userNameAndPassword.indexOf(":")
		val userName = request.userNameAndPassword.substring(0, userNameIndex)
		return userName
	}

	def getSessionId(HttpServletRequest request) {
		return request.session.id
	}

	def getSessionKey(HttpServletRequest request) {
		return request.sessionId + "-" + request.userId
	}

	def getPassword(HttpServletRequest request) {
		val userNameIndex = request.userNameAndPassword.indexOf(":")
		val password = request.userNameAndPassword.substring(userNameIndex + 1)
		return password
	}

	def isBasicAuth(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER) != null
	}

	def String readBody(HttpServletRequest request) throws IOException {
		val buffer = new StringBuffer();
		var String line = null;

		val reader = request.getReader();
		while ((line = reader.readLine) != null) {
			buffer.append(line)
		}
		return buffer.toString
	}

	def private getUserNameAndPassword(HttpServletRequest request) {
		val authHeader = request.getHeader(AUTH_HEADER)
		if (authHeader == null) {
			throw new FlatlandException("request.getHeader(\"Authorization\") == null, should not happen")
		}
		val usernameAndPassword = new String(Base64.decodeBase64(authHeader.substring(6).getBytes()))
		return usernameAndPassword
	}
}
