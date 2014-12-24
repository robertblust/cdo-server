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
package ch.flatland.cdo.server.product

import ch.flatland.cdo.model.config.AuthenticatorType
import ch.flatland.cdo.server.config.ServerConfig
import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.emf.cdo.server.spi.security.InternalSecurityManager
import org.eclipse.net4j.util.container.IPluginContainer
import org.slf4j.LoggerFactory

class SecurityManagerFactory {
	
	val static logger = LoggerFactory.getLogger(SecurityManagerFactory)
	
	private new() {
		// hide constructor
	}
	
	def static InternalSecurityManager createSecurityManager() {
		if (ServerConfig.getConfig.authenticator.authenticatorType == AuthenticatorType.LDAP) {
			logger.info("Create LDAP security manager")
			return createLDAPSecurityManager
		} else {
			logger.info("Create CDO security manager")
			return createCDOSecurityManager
		}
	}

	def private static createLDAPSecurityManager() {
		val authenticator = new LdapAuthenticatorManager(ServerConfig.getConfig.authenticator.connectionUrl, ServerConfig.getConfig.authenticator.domainBase, ServerConfig.getConfig.authenticator.userIdField)
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}

	def private static createCDOSecurityManager() {
		return new org.eclipse.emf.cdo.server.internal.security.SecurityManager("/security", IPluginContainer.INSTANCE)
	}

}
