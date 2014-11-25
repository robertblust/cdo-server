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
import javax.servlet.http.HttpServletRequest
import org.eclipse.emf.cdo.common.id.CDOIDUtil
import org.slf4j.LoggerFactory

import static extension ch.flatland.cdo.service.repoaccess.RepoAccessServlet.*
import static extension ch.flatland.cdo.util.Request.*

class Post {

	val logger = LoggerFactory.getLogger(this.class)

	def String run(HttpServletRequest req) {
		val body = req.readBody
		logger.debug("Run for '{}' with body '{}'", req.userId, body)

		val extension JsonConverter = req.createJsonConverter
		val view = SessionFactory.getCDOSession(req).openTransaction
		var String jsonString = null

		try {
			if (body.length == 0) {
				throw new FlatlandException("Request body must not be empty")
			}
			val jsonObject = body.fromJson
			val id = jsonObject.entrySet.filter[it.key == RepoAccessServlet.PARAM_ID].head
			logger.debug("CDOObject '{}' requested", id)
			val requestedObject = view.getObject(CDOIDUtil.createLong(id.value.asLong))
						
			jsonObject.entrySet.filter[it.key != RepoAccessServlet.PARAM_ID].forEach[
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
