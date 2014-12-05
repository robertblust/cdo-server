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
package ch.flatland.cdo.server

import ch.flatland.cdo.server.product.CredentialsProvider
import org.eclipse.emf.cdo.net4j.CDONet4jUtil
import org.eclipse.emf.cdo.session.CDOSession
import org.eclipse.net4j.Net4jUtil
import org.eclipse.net4j.util.container.IPluginContainer
import org.slf4j.LoggerFactory

class ServerUtil {

	public val static SUPPORTING_AUDITS = false
	public val static SUPPORTING_BRANCHES = false
	public val static ENSURE_REFERENTIAL_INTEGRITY = true
	public val static REPOSITORY_NAME = "repo"
	public val static ACCEPTOR_PORT = "2036"

	val static logger = LoggerFactory.getLogger(ServerUtil)

	private new() {
		// hide constructor
	}

	val static acceptorName = REPOSITORY_NAME + "_jvm"
	val static connector = {
		Net4jUtil.getAcceptor(IPluginContainer.INSTANCE, "jvm", acceptorName)
		Net4jUtil.getConnector(IPluginContainer.INSTANCE, "jvm", acceptorName)
	}

	def static openReadOnlySession() {
		ServerUtil.openSession(AuthenticationUtil.READONLY_USER, AuthenticationUtil.READONLY_PWD)
	}

	def static openSession(String userID, String password) {

		val config = CDONet4jUtil.createNet4jSessionConfiguration()
		config.setConnector(connector)
		config.setRepositoryName(REPOSITORY_NAME)

		config.credentialsProvider = new CredentialsProvider(userID, password)

		val session = config.openNet4jSession() as CDOSession

		logger.debug("open session '{}' for user '{}'", session.sessionID, session.userID)

		return session
	}
}
