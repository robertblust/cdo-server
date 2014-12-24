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
	public val static READONLY_USER = "ReadOnly"

	private new() {
		// hide constructor
	}
}
