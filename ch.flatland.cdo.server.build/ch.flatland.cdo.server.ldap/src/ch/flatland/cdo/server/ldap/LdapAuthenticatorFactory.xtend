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
package ch.flatland.cdo.server.ldap

import org.eclipse.net4j.util.factory.ProductCreationException
import org.eclipse.net4j.util.security.UserManagerFactory

class LdapAuthenticatorFactory extends UserManagerFactory {

	val static TYPE = "ldap"

	new() {
		super(TYPE)
	}

	override create(String description) throws ProductCreationException {
		new LdapAuthenticatorManager(description)
	}

}
