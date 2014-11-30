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

import javax.servlet.http.HttpServletResponse

class HttpStatus {
	def getDescription(int httpStatus) {
		switch httpStatus {
			case HttpServletResponse.SC_BAD_REQUEST: return '''Status code (400) indicating the request sent by the client was syntactically incorrect'''
			case HttpServletResponse.SC_UNAUTHORIZED: return '''Status code (401) indicating that the request requires HTTP authentication'''
			case HttpServletResponse.SC_FORBIDDEN: return '''Status code (403) indicating the server understood the request but refused to fulfill it'''
			case HttpServletResponse.SC_METHOD_NOT_ALLOWED: return '''Status code (405) indicating that the method specified in the 'Request-Line' is not allowed for the resource identified by the 'Request-URI' '''
			case HttpServletResponse.SC_NOT_FOUND: return '''Status code (404) indicating that the requested resource is not available'''
			case HttpServletResponse.SC_INTERNAL_SERVER_ERROR: return '''Status code (500) indicating an error inside the HTTP server which prevented it from fulfilling the request'''
			case HttpServletResponse.SC_CONFLICT: return '''Status code (409) indicating that the request could not be completed due to a conflict with the current state of the resource'''
			default: return '''No description'''
		}
	}
}
