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
package ch.flatland.cdo.service.ping

import ch.flatland.cdo.service.ping.model.PingBean
import ch.flatland.cdo.util.Json
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class PingServlet extends HttpServlet {

	public val static SERVLET_CONTEXT = "/ping"

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.contentType = Json.JSON_CONTENTTYPE_UTF8
		resp.writer.append(new PingBean("Flatland CDO Server", "1.0.0").toString)
	}

	override init() throws ServletException {
		super.init()
		if (PingPlugin.getDefault.debugging) {
			println(
				'''
					>>>
					   init() «this.class.name»
					<<<
				''')
		}
	}
}
