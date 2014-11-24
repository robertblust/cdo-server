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
import org.slf4j.LoggerFactory

class RepoAccessServlet extends AbstractServlet {

	val logger = LoggerFactory.getLogger(this.class)

	val static PARAM_ID = Json.PARAM_ID
	val static PARAM_META = Json.PARAM_META
	val static PARAM_JSONP_CALLBACK = "callback"
	val static SERVLET_CONTEXT = "/repo"

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logRequest(req)

		val view = SessionFactory.getCDOSession(req).openView

		val servletUrl = req.requestURL.substring(0, req.requestURL.indexOf(SERVLET_CONTEXT)) + SERVLET_CONTEXT
		val jsonConverterConfig = new JsonConverterConfig(servletUrl, SERVLET_CONTEXT)
		var Object requestedObject = null
		var String jsonString = null

		if (req.getParameter(PARAM_META) != null) {
			jsonConverterConfig.meta = true
		}
		try {

			var processed = false

			// processes oid
			if (req.getParameter(PARAM_ID) != null && req.getParameter(PARAM_ID).length > 0) {
				requestedObject = view.getObject(CDOIDUtil.createLong(Long.parseLong(req.getParameter(RepoAccessServlet.PARAM_ID))))
				processed = true
			}

			// processes path
			if (!processed) {
				requestedObject = view.getResourceNode(req.pathInfo)
			}

			jsonString = new JsonConverter(jsonConverterConfig).toJson(requestedObject)

		} catch (Exception e) {
			jsonString = new JsonConverter(jsonConverterConfig).toJson(e)
			logger.error("Could not processing request", e)
		} finally {
			logger.debug("Response json {}", jsonString)

			// write response
			if (req.getParameter(PARAM_JSONP_CALLBACK) != null && req.getParameter(PARAM_JSONP_CALLBACK).length > 0) {
				resp.contentType = Json.JSON_CONTENTTYPE_UTF8
				resp.writer.append('''«req.getParameter(PARAM_JSONP_CALLBACK)»(«jsonString»)''')
			} else {
				resp.contentType = Json.JSONP_CONTENTTYPE_UTF8
				resp.writer.append(jsonString)
			}

			if (!view.closed) {
				view.close
			}
		}
	}
}
