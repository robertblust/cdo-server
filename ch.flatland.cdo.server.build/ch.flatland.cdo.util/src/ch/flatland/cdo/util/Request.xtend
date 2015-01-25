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

import com.google.common.base.Splitter
import javax.servlet.http.HttpServletRequest
import org.apache.commons.codec.binary.Base64
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletRequest.*
import static javax.servlet.http.HttpServletResponse.*

class Request {

	val logger = LoggerFactory.getLogger(this.class)

	val public static AUTH_HEADER = "Authorization"
	val public static ACCEPT_HEADER = "Accept"
	val public static OPENSHIFT_FORWARD_PROTO_HEADER = "X-Forwarded-Proto"
	val public static OPENSHIFT_FORWARD_PORT_HEADER = "X-Forwarded-Port"
	val public static HTTPS_PROTO = "https"
	val public static HTTP_PROTO = "http"
	val public static HTTPS_PORT = "443"
	val static IGNORED_PARAMS_FOR_FILTER = newArrayList(PARAM_POINT_IN_TIME);

	def getParameterNameAsListValueNotNull(HttpServletRequest req) {
		val params = newArrayList
		val enum = req.parameterNames
		while(enum.hasMoreElements) {
			val paramName = enum.nextElement
			if(req.getParameter(paramName) != null && req.getParameter(paramName).length > 0 && !IGNORED_PARAMS_FOR_FILTER.contains(paramName)) {
				params.add(paramName)
			}
		}
		return params
	}

	def getPointInTime(HttpServletRequest req) {
		if(req.getParameter(PARAM_POINT_IN_TIME) != null && req.getParameter(PARAM_POINT_IN_TIME).length > 0) {
			return req.getParameter(PARAM_POINT_IN_TIME)
		}
		return null
	}

	def getServerAddress(HttpServletRequest req) {
		var serverAddress = req.requestURL.substring(0, req.requestURL.indexOf(req.servletAlias))
		if(req.getHeader(OPENSHIFT_FORWARD_PROTO_HEADER) != null && req.getHeader(OPENSHIFT_FORWARD_PROTO_HEADER) == HTTPS_PROTO) {
			serverAddress = serverAddress.replaceFirst(HTTP_PROTO, HTTPS_PROTO)
		}
		return serverAddress
	}

	def getServletAlias(HttpServletRequest req) {
		return "/" + Splitter.on("/").split(req.requestURL).get(3)
	}

	def getPathSegments(HttpServletRequest req) {
		if(req.pathInfo == null) {
			return null
		}
		return Splitter.on("/").split(req.pathInfo)
	}

	def getJsonCallback(HttpServletRequest req) {
		if(req.method == METHOD_GET && req.getParameter(PARAM_JSONP_CALLBACK) != null && req.getParameter(PARAM_JSONP_CALLBACK).length > 0) {
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

	def isArrayAccessor(HttpServletRequest req) {
		return req.getParameter(PARAM_ARRAY_ACCESSOR) != null
	}

	def isValidate(HttpServletRequest req) {
		return req.getParameter(PARAM_VALIDATION) != null
	}

	def isHistory(HttpServletRequest req) {
		return req.getParameter(PARAM_HISTORY) != null
	}

	def isXor(HttpServletRequest req) {
		return req.getParameter(PARAM_XOR_FILTER) != null
	}

	def isRefs(HttpServletRequest req) {
		if(req.crefs || req.rrefs) {
			return true
		}
		return false
	}

	def isRrefs(HttpServletRequest req) {
		return req.getParameter(PARAM_RREFS) != null
	}

	def isCrefs(HttpServletRequest req) {
		return req.getParameter(PARAM_CREFS) != null
	}

	def isXrefs(HttpServletRequest req) {
		return req.getParameter(PARAM_XREFS) != null
	}

	def isLinks(HttpServletRequest req) {
		return req.getParameter(PARAM_LINKS) != null
	}

	def isXlinks(HttpServletRequest req) {
		return req.getParameter(PARAM_XLINKS) != null
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
		return request.getHeader(AUTH_HEADER) != null && request.getHeader(AUTH_HEADER).toLowerCase.startsWith(BASIC_AUTH.toLowerCase)
	}

	def isSecureConnection(HttpServletRequest req) {
		if(req.secure) {
			return true
		}
		if(req.getHeader(OPENSHIFT_FORWARD_PROTO_HEADER) != null && req.getHeader(OPENSHIFT_FORWARD_PROTO_HEADER) == HTTPS_PROTO && req.getHeader(OPENSHIFT_FORWARD_PORT_HEADER) != null && req.getHeader(OPENSHIFT_FORWARD_PORT_HEADER) == HTTPS_PORT) {
			return true
		}
		return false
	}

	def isAcceptable(HttpServletRequest request) {
		val acceptHeader = request.getHeader(ACCEPT_HEADER)
		if(acceptHeader != null) {
			for (contentType : ACCEPTED_CONTENTTYPES) {
				if(acceptHeader.contains(contentType)) {
					return true;
				}
			}
		}
		return false
	}

	def createJsonConverter(HttpServletRequest req) {
		return new JsonConverter(new JsonConverterConfig(req))
	}

	def methodAllowed(HttpServletRequest req) {
		if(req.method == METHOD_PUT || req.method == METHOD_DELETE) {
			if (req.pointInTime != null) {
				// history can not be edited
				return false
			}
			if (req.pathSegments == null) {
				// one of 2 path pattern must be present
				return false
			}
			// required path pattern
			// 1. /obj/prefix.type/oid --> size == 3
			// 2. /obj/prefix.type/oid/references/feature/oid --> size == 6
			if (req.pathSegments.size < 3) {
				return false
			}
			if (req.pathSegments.size > 3 && req.pathSegments.size < 6) {
				return false
			}
			if (req.pathSegments.size == 6 && req.pathSegments.get(3) != REFERENCES) {
				return false
			}
			return true
		}
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

	def logRequest(HttpServletRequest req) {
		if(logger.isDebugEnabled) {
			var userId = "anonymous"
			if(req.basicAuth) {
				userId = req.userId
			}
			logger.debug("Request '{}' with params '{}' from '{}'", req.requestURL, req.parameterMap, userId)
			val headerNames = req.headerNames
			while(headerNames.hasMoreElements) {
				val key = headerNames.nextElement
				logger.debug("Http header field '{}'", key)
				val fieldValues = req.getHeaders(key)
				while(fieldValues.hasMoreElements) {
					val value = fieldValues.nextElement
					logger.debug("  '{}'", value)
				}
			}
		}
	}
}
