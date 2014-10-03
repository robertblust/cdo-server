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

import org.eclipse.emf.cdo.security.User

class AuthenticationUtil {
	public val static ADMIN_USER = User.ADMINISTRATOR
	public val static ADMIN_PWD = System.getProperty("ch.flatland.cdo.server.admin.pwd")
	public val static READONLY_USER = "ReadOnly"
	public val static READONLY_PWD = System.getProperty("ch.flatland.cdo.server.readonly.pwd")

	public val static LDAP_SERVER = "faked://flatland.ch:333"
	public val static LDAP_DOMAIN_BASE = "ou=person,o=FLATLAND,c=CH"
	public val static LDAP_USER_ID_FIELD = "empid"

	private new() {
		// hide constructor
	}
}
