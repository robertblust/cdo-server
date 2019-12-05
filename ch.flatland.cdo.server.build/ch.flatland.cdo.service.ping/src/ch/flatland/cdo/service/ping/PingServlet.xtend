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
package ch.flatland.cdo.service.ping

import ch.flatland.cdo.service.ping.model.Build
import ch.flatland.cdo.service.ping.model.Health
import ch.flatland.cdo.service.ping.model.Info
import ch.flatland.cdo.service.repoaccess.Options
import ch.flatland.cdo.util.AbstractServlet
import ch.flatland.cdo.util.Response
import com.google.gson.Gson
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class PingServlet extends AbstractServlet {

	val extension Response = new Response
	val gson = new Gson

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) {
		if(req.pathInfo.equals("/info")) {
			val version = PingPlugin.^default.bundle.version
			resp.writeResponse(req, gson.toJson(new Info(new Build(version.toString))))
			return
		}
		resp.writeResponse(req, gson.toJson(new Health("UP")))
	}

	override protected doOptions(HttpServletRequest req, HttpServletResponse resp) {
		(new Options).run(req, resp)
	}
}
