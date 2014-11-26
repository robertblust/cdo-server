package ch.flatland.cdo.service.repoaccess

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

import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.Json
import ch.flatland.cdo.util.Request
import javax.servlet.http.HttpServletRequest
import org.eclipse.emf.cdo.common.id.CDOIDUtil
import org.eclipse.emf.cdo.common.security.CDOPermission
import org.slf4j.LoggerFactory

class Post {

	val logger = LoggerFactory.getLogger(this.class)
	
	val extension Request = new Request

	def String run(HttpServletRequest req) {
		val body = req.readBody
		logger.debug("Run for '{}' with body '{}'", req.userId, body)

		val extension JsonConverter = req.createJsonConverter(RepoAccessServlet.SERVLET_CONTEXT)
		val view = SessionFactory.getCDOSession(req).openTransaction
		var String jsonString = null

		try {
			if (body.length == 0) {
				throw new FlatlandException("Request body must not be empty")
			}
			val jsonObject = body.fromJson
			val id = jsonObject.entrySet.filter[it.key == Json.PARAM_ID].head
			logger.debug("Object '{}' requested", id)
			val requestedObject = view.getObject(CDOIDUtil.createLong(id.value.asLong))
			
			if (requestedObject.cdoPermission != CDOPermission.WRITE) {
				throw new FlatlandException("No permission to edit object '" + id + "'")
			}
						
			jsonObject.entrySet.filter[it.key != Json.PARAM_ID].forEach[
				logger.debug("Found json element with name '{}'", it.key)
				
			]			
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
