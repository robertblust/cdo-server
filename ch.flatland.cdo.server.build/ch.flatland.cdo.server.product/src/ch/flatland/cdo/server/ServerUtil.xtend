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

import ch.flatland.cdo.server.product.CredentialsProvider
import org.eclipse.emf.cdo.net4j.CDONet4jUtil
import org.eclipse.emf.cdo.session.CDOSession
import org.eclipse.net4j.Net4jUtil
import org.eclipse.net4j.util.container.IPluginContainer
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*

class ServerUtil {

	public val static SUPPORTING_AUDITS = false
	public val static SUPPORTING_BRANCHES = false
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

	def static openReadOnlySession(String repoName) {
		ServerUtil.openSession(AuthenticationUtil.READONLY_USER, CONFIG.readOnlyPassword, repoName)
	}

	def static openSession(String userID, String password, String repoName) {
		val config = CDONet4jUtil.createNet4jSessionConfiguration()
		config.setConnector(connector)
		config.setRepositoryName(repoName)

		config.credentialsProvider = new CredentialsProvider(userID, password)

		val session = config.openNet4jSession() as CDOSession

		logger.debug("open session '{}' for user '{}'", session.sessionID, session.userID)

		return session
	}
}
