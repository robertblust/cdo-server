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

import ch.flatland.cdo.service.ping.model.PingBean
import ch.flatland.cdo.util.AbstractServlet
import ch.flatland.cdo.util.JsonConverter
import ch.flatland.cdo.util.Response
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class PingServlet extends AbstractServlet {

	val extension Response = new Response

	val static extension JsonConverter = new JsonConverter
	
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) {
		val version = PingPlugin.^default.bundle.version
		val ping = new PingBean("Flatland CDO Server", version.toString).safeToJson
		resp.writeResponse(req, ping)
	}
}
