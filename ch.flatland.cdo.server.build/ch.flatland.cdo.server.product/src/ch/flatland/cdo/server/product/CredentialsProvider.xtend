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

import org.eclipse.net4j.util.security.IPasswordCredentialsProvider
import org.eclipse.net4j.util.security.PasswordCredentials

class CredentialsProvider implements IPasswordCredentialsProvider {

	var String userID
	var String password

	new(String userID, String password) {
		this.userID = userID
		this.password = password
	}

	override getCredentials() {
		new PasswordCredentials(userID, password)
	}

	override isInteractive() {
		false
	}

}
