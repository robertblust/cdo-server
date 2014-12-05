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

import ch.flatland.cdo.server.ServerUtil
import ch.flatland.cdo.util.Request
import java.util.HashMap
import javax.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

class SessionFactory {
	val static logger = LoggerFactory.getLogger(SessionFactory)

	val static sessionMap = new HashMap<String, SessionEntry>

	def static synchronized getOrCreateCDOSession(HttpServletRequest request) {
		val extension Request = new Request
		if(sessionMap.containsKey(request.sessionKey)) {
			val sessionEntry = sessionMap.get(request.sessionKey)
			if(sessionEntry.CDOSession.closed) {
				sessionEntry.invalidateCDOsession
				sessionEntry.CDOSession = ServerUtil.openSession(request.userId, request.password)
			}
			sessionEntry.updateHttpSessionActivity

			logger.debug("Reuse CDO Session")
		} else {
			sessionMap.put(request.sessionKey, new SessionEntry(ServerUtil.openSession(request.userId, request.password)))

			logger.debug("Create CDO Session")
		}

		logger.debug("CDO Session '{}' for http Session '{}' and user '{}'", getCDOSession(request).sessionID, request.sessionId, request.userId)

		return getCDOSession(request)
	}

	def static getSessionMap() {
		sessionMap
	}

	def static synchronized getCDOSession(HttpServletRequest request) {
		val extension Request = new Request
		sessionMap.get(request.sessionKey).CDOSession
	}
}
