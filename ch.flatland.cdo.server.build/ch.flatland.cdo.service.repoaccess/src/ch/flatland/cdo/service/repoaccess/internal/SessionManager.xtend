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
import org.slf4j.LoggerFactory

class SessionManager extends Thread {

	int SESSION_TIMEOUT = 300

	val logger = LoggerFactory.getLogger(this.class)

	override run() {
		name = class.simpleName

		val timeout = SESSION_TIMEOUT * 1000

		logger.debug("run with session timeout '{}' ms", timeout)

		while(true) {
			sleep(timeout)
			invalidateSessions(timeout)
		}
	}

	def invalidateSessions(long timeout) {

		val sessionIds = SessionFactory.getSessionMap.keySet.clone

		logger.debug("Available sessions '{}'", sessionIds.size)

		for (sessionId : sessionIds) {
			val sessionEntry = SessionFactory.getSessionMap.get(sessionId)
			if(System.currentTimeMillis - sessionEntry.lastHttpSessionActivity > timeout) {
				sessionEntry.invalidateCDOsession
				SessionFactory.getSessionMap.remove(sessionId)

				logger.debug("Invalidate session '{}'", sessionId)
			}
		}
	}
}
