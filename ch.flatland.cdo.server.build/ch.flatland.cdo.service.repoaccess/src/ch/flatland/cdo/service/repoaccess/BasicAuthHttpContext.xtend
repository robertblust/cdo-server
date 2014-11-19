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

import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext
import static extension ch.flatland.cdo.service.repoaccess.BasicAuth.*
class BasicAuthHttpContext implements HttpContext {

	override handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		val session = request.getSession(true)
	
		// only allow https
		if (!request.getScheme().equals("https")) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN)
			return false
		}

		// check if authorization header is available
		if (request.getHeader("Authorization") == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
			return false
		}
		
		try {
			// try to create a CDOSession and reuse the CDO Authentication
			SessionFactory.getOrCreateCDOSession(session.id, request.userId, request.password)
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
			if (RepoAccessPlugin.getDefault.debugging) {
				e.printStackTrace
			}
			return false
		}
		
		if (RepoAccessPlugin.getDefault.debugging) {
			println(
				'''
					>>>
					   handleSecurity(HttpServletRequest request, HttpServletResponse response) «this.class.name»
					   return true
					<<<
				''')
		}
		return true

	}

	override getMimeType(String name) {
		return null
	}

	override getResource(String name) {
		return null
	}
}