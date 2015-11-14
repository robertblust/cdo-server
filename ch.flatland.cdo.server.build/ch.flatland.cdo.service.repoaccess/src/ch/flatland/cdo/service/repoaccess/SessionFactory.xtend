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
package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.model.config.AuthenticatorType
import ch.flatland.cdo.server.ServerUtil
import ch.flatland.cdo.service.repoaccess.internal.SessionEntry
import ch.flatland.cdo.util.Request
import java.util.HashMap
import javax.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*

class SessionFactory {
	val static logger = LoggerFactory.getLogger(SessionFactory)

	val static sessionMap = new HashMap<String, SessionEntry>

	def static synchronized getOrCreateCDOSession(HttpServletRequest request) {
		val extension Request = new Request
		if (sessionMap.containsKey(request.sessionKey)) {
			val sessionEntry = sessionMap.get(request.sessionKey)
			if (sessionEntry.password != request.password) {
				throw new Exception
			}
			if (sessionEntry.CDOSession.closed) {
				sessionEntry.invalidateCDOsession
				val repository = CONFIG.repositories.filter[it.dataStore.repositoryName == request.repoName].head
				if (repository.authenticator.authenticatorType == AuthenticatorType.NONE) {
					sessionEntry.CDOSession = ServerUtil.openUnauthenticatedSession(request.repoName)
				} else {
					sessionEntry.CDOSession = ServerUtil.openSession(request.userId, request.password, request.repoName)
				}
			}
			sessionEntry.updateHttpSessionActivity

			logger.debug("Reuse CDO Session")
		} else {
			val repository = CONFIG.repositories.filter[it.dataStore.repositoryName == request.repoName].head
			if (repository.authenticator.authenticatorType == AuthenticatorType.NONE) {
				sessionMap.put(request.sessionKey,
					new SessionEntry( ServerUtil.openUnauthenticatedSession(request.repoName),
						request.password, request.repoName))
			} else {
				sessionMap.put(request.sessionKey,
					new SessionEntry(ServerUtil.openSession(request.userId, request.password, request.repoName),
						request.password, request.repoName))
			}

			logger.debug("Create CDO Session")
		}

		logger.debug("CDO Session '{}' for http Session '{}' and user '{}' for repo '{}'",
			getCDOSession(request).sessionID, request.sessionId, request.userId, request.repoName)

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
