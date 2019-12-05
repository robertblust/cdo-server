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

import ch.flatland.cdo.service.repoaccess.SessionFactory
import ch.flatland.cdo.util.DateConverter
import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import ch.flatland.cdo.util.View
import java.util.Date
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.view.CDOView
import org.slf4j.LoggerFactory

import static javax.servlet.http.HttpServletResponse.*

class Get {

	val logger = LoggerFactory.getLogger(this.class)

	val extension Request = new Request
	val extension Response = new Response
	val extension View = new View
	val extension DateConverter = new DateConverter

	def void run(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("Run for '{}'", req.userId)

		var String jsonString = null
		var CDOView view = null
		val extension JsonConverter = req.createJsonConverter

		try {
			if(req.pointInTime !== null) {
				try {
					val session = SessionFactory.getCDOSession(req)
					val creationTime = session.repositoryInfo.creationTime
					val pit = Long.parseLong(req.pointInTime)
					if (pit < creationTime) {
						throw new FlatlandException(SC_BAD_REQUEST, "Requested pit '{}' is older than the Repository Creation Time '{}'", new Date(pit).formatDate, new Date(creationTime).formatDate)
					}
					view = SessionFactory.getCDOSession(req).openView(Long.parseLong(req.pointInTime))
				} catch (FlatlandException fle) {
					throw fle
				} catch(Exception e) {
					throw new FlatlandException(SC_NOT_FOUND, "{} not found", req.pathInfo)
				}
			} else {
				view = SessionFactory.getCDOSession(req).openView
			}

			val requestedObject = view.safeRequestResource(req, resp)

			jsonString = requestedObject.safeToJson

		} catch(FlatlandException e) {
			resp.status = e.httpStatus
			jsonString = e.safeToJson
			logger.debug("Request failed", e)
		} finally {
			if(view !== null && !view.closed) {
				view.close
			}
		}
		resp.writeResponse(req, jsonString)
	}
}
