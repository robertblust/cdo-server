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
import ch.flatland.cdo.util.Json
import ch.flatland.cdo.util.JsonConverter
import ch.flatland.cdo.util.JsonConverterConfig
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.common.id.CDOIDUtil

class RepoAccessServlet extends AbstractServlet {

	val public static PARAM_ID = Json.PARAM_ID
	val public static PARAM_META = Json.PARAM_META
	val public static SERVLET_CONTEXT = "/repo"

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logRequest(req)
		val get = new Get
		writeResponse(req, resp, get.run(req))
	}

	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logRequest(req)
		val post = new Post
		writeResponse(req, resp, post.run(req))
	}

	def static createJsonConverter(HttpServletRequest req) {
		var meta = false
		if (req.getParameter(PARAM_META) != null) {
			meta = true
		}
		val servletUrl = req.requestURL.substring(0, req.requestURL.indexOf(SERVLET_CONTEXT)) + SERVLET_CONTEXT
		val jsonConverterConfig = new JsonConverterConfig(servletUrl, SERVLET_CONTEXT)
		jsonConverterConfig.meta = meta
		return new JsonConverter(jsonConverterConfig)
	}

	def static getCDOID(HttpServletRequest req) {
		if (req.getParameter(RepoAccessServlet.PARAM_ID) != null &&
			req.getParameter(RepoAccessServlet.PARAM_ID).length > 0) {

			return CDOIDUtil.createLong(Long.parseLong(req.getParameter(RepoAccessServlet.PARAM_ID)))
		}
		return null
	}
}
