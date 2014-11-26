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

import ch.flatland.cdo.util.AbstractServlet
import ch.flatland.cdo.util.Response
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RepoAccessServlet extends AbstractServlet {

	val public static SERVLET_CONTEXT = "/repo"

	val extension Response = new Response

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logRequest(req)
		val get = new Get
		resp.writeResponse(req, get.run(req))
	}

	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logRequest(req)
		val post = new Post
		resp.writeResponse(req, post.run(req))
	}
}
