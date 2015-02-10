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
package ch.flatland.cdo.service.repoaccess.internal

import ch.flatland.cdo.util.AbstractServlet
import ch.flatland.cdo.util.JsonConverter
import ch.flatland.cdo.util.Response
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthServlet extends AbstractServlet {
	def override protected doGet(HttpServletRequest req, HttpServletResponse resp) {
		val extension Response = new Response
		resp.writeResponse(req, (new JsonConverter).okToJson)
	}
}
