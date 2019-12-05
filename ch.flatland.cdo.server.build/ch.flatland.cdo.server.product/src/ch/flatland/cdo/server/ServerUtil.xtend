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
package ch.flatland.cdo.server

import org.eclipse.emf.cdo.net4j.CDONet4jSession
import org.eclipse.emf.cdo.net4j.CDONet4jUtil
import org.eclipse.emf.cdo.session.CDOSession
import org.eclipse.net4j.Net4jUtil
import org.eclipse.net4j.util.container.IPluginContainer
import org.slf4j.LoggerFactory

class ServerUtil {

	public val static SUPPORTING_AUDITS = true
	public val static SUPPORTING_BRANCHES = false
	// set to false cause API already checks referential integrity (xrefsDelete)
	public val static ENSURE_REFERENTIAL_INTEGRITY = true

	val static logger = LoggerFactory.getLogger(ServerUtil)

	private new() {
		// hide constructor
	}

	val static acceptorName = "flatland_jvm"
	val static connector = {
		Net4jUtil.getAcceptor(IPluginContainer.INSTANCE, "jvm", acceptorName)
		Net4jUtil.getConnector(IPluginContainer.INSTANCE, "jvm", acceptorName)
	}

	def static CDOSession openSession(String repoName, String userId) {
		val config = CDONet4jUtil.createNet4jSessionConfiguration()
		config.userID = userId
		config.setConnector(connector)
		config.setRepositoryName(repoName)

		val session = config.openNet4jSession() as CDOSession
		(session as CDONet4jSession).options.net4jProtocol.setTimeout(Long.MAX_VALUE)
		(session as CDONet4jSession).options().setCommitTimeout(10000);
		logger.debug("open session '{}' for user '{}'", session.sessionID, userId)
		return session
	}
}
