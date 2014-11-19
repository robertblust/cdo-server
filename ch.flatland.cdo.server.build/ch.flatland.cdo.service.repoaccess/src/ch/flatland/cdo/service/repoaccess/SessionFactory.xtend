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

class SessionFactory {

	val static sessionMap = new HashMap<String, SessionEntry>

	def static getOrCreateCDOSession(String sessionId, String userID, String password) {
		if (sessionMap.containsKey(sessionId)) {
			val sessionEntry = sessionMap.get(sessionId)
			if (sessionEntry.CDOSession.closed) {
				sessionEntry.invalidateCDOsession
				sessionEntry.CDOSession = ServerUtil.openSession(userID, password)
			}
			sessionEntry.updateHttpSessionActivity
			if (RepoAccessPlugin.getDefault.debugging) {
				println(
					'''
						>>>
						   getOrCreateCDOSession(«sessionId», «userID») «SessionFactory.name»
						   reused CDOSession = «getCDOSession(sessionId).sessionID»
						<<<
					''')
			}
		} else {
			sessionMap.put(sessionId, new SessionEntry(ServerUtil.openSession(userID, password)))
			if (RepoAccessPlugin.getDefault.debugging) {
				println(
					'''
						>>>
						   getOrCreateCDOSession(«sessionId», «userID») «SessionFactory.name»
						   new CDOSession = «getCDOSession(sessionId).sessionID»
						<<<
					''')
			}
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
