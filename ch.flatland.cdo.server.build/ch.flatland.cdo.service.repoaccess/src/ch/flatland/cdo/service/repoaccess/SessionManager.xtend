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

import org.slf4j.LoggerFactory

class SessionManager extends Thread {

	val TIMEOUT_PROPERTY = "org.eclipse.equinox.http.jetty.context.sessioninactiveinterval"
	val timeoutProperty = System.getProperty(TIMEOUT_PROPERTY)

	val logger = LoggerFactory.getLogger(this.class)

	override run() {
		name = class.simpleName
		if(timeoutProperty == null) {
			throw new RuntimeException("-D" + TIMEOUT_PROPERTY + " not set!")
		}

		val timeout = Long.parseLong(timeoutProperty) * 1000

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
