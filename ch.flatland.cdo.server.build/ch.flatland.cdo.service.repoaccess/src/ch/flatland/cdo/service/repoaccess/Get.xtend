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

import javax.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.service.repoaccess.RepoAccessServlet.*
import static extension ch.flatland.cdo.util.Request.*

class Get {

	val logger = LoggerFactory.getLogger(this.class)
	
	def String run(HttpServletRequest req) {
		logger.debug("Run for '{}'", req.userId)
		
		val view = SessionFactory.getCDOSession(req).openView

		var Object requestedObject = null
		var String jsonString = null

		val extension JsonConverter = req.createJsonConverter
		
		try {

			var processed = false

			// processes id
			if (req.CDOID != null) {
				requestedObject = view.getObject(req.CDOID)
				processed = true
			}

			// processes path
			if (!processed) {
				requestedObject = view.getResourceNode(req.pathInfo)
			}

			jsonString = requestedObject.toJson

		} catch (Exception e) {
			jsonString = e.toJson
			logger.error("Could not processing request", e)
		} finally {
			if (!view.closed) {
				view.close
			}
		}
		return jsonString
	}
}
