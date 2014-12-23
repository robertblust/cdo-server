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

import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.net4j.util.container.IPluginContainer

import static ch.flatland.cdo.server.AuthenticationUtil.*

class SecurityManagerFactory {
	private new() {
		// hide constructor
	}

	def static createLDAPSecurityManager() {
		val authenticator = new LdapAuthenticatorManager(LDAP_SERVER, LDAP_DOMAIN_BASE, LDAP_USER_ID_FIELD)
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}
	
	def static createCDOSecurityManager() {
		return new org.eclipse.emf.cdo.server.internal.security.SecurityManager("/security", IPluginContainer.INSTANCE)
	}

}
