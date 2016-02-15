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
package ch.flatland.cdo.server.product

import ch.flatland.cdo.model.config.AuthenticatorType
import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.emf.cdo.server.spi.security.InternalSecurityManager
import org.eclipse.net4j.util.container.IPluginContainer
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*

class SecurityManagerFactory {

	val static logger = LoggerFactory.getLogger(SecurityManagerFactory)

	private new() {
		// hide constructor
	}

	def static InternalSecurityManager createSecurityManager(String repoName) {
		if(CONFIG.getByName(repoName).authenticator.authenticatorType == AuthenticatorType.LDAP) {
			logger.info("Create LDAP security manager")
			return createLDAPSecurityManager(repoName)
		} else if (CONFIG.getByName(repoName).authenticator.authenticatorType == AuthenticatorType.SIMPLE) {
			return createSimpleSecurityManager
		} else {
			logger.info("Create CDO security manager")
			return createCDOSecurityManager
		}
	}

	def private static createLDAPSecurityManager(String repoName) {
		val authenticator = new LdapAuthenticatorManager(CONFIG.getByName(repoName).authenticator.connectionUrl, CONFIG.getByName(repoName).authenticator.domainBase, CONFIG.getByName(repoName).authenticator.userIdField)
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}
	
	def private static createSimpleSecurityManager() {
		val authenticator = new SimpleAuthenticatorManager
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}

	def private static createCDOSecurityManager() {
		return new org.eclipse.emf.cdo.server.internal.security.SecurityManager("/security", IPluginContainer.INSTANCE)
	}

}
