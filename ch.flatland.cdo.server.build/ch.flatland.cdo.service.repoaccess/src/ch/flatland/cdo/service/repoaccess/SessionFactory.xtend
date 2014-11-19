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
import java.util.HashMap
import org.slf4j.LoggerFactory

class SessionFactory {
	val static logger = LoggerFactory.getLogger(SessionFactory)
	
	val static sessionMap = new HashMap<String, SessionEntry>

	def static getOrCreateCDOSession(String sessionId, String userID, String password) {
		if (sessionMap.containsKey(sessionId)) {
			val sessionEntry = sessionMap.get(sessionId)
			if (sessionEntry.CDOSession.closed) {
				sessionEntry.invalidateCDOsession
				sessionEntry.CDOSession = ServerUtil.openSession(userID, password)
			}
			sessionEntry.updateHttpSessionActivity
			
			logger.debug("Reuse CDO Session {} for http Session {}", getCDOSession(sessionId).sessionID, sessionId)
		} else {
			sessionMap.put(sessionId, new SessionEntry(ServerUtil.openSession(userID, password)))
			
			logger.debug("Create CDO Session {} for http Session {}", getCDOSession(sessionId).sessionID, sessionId)
		}
		return getCDOSession(sessionId)
	}

	def static getSessionMap() {
		sessionMap
	}

	def static getCDOSession(String sessionId) {
		sessionMap.get(sessionId).CDOSession
	}
}
