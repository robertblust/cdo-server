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
package ch.flatland.cdo.server.product;

import org.eclipse.net4j.util.security.IAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.flatland.cdo.server.AuthenticationUtil;
import ch.flatland.cdo.server.config.ServerConfig;

public class SimpleAuthenticatorManager implements IAuthenticator {


	private Logger logger = LoggerFactory.getLogger(this.getClass());


	public void authenticate(String userId, char[] password) throws SecurityException {

		logger.debug("authenticate '{}'", userId);

		String p = new String(password);

		if (userId.equals(AuthenticationUtil.ADMIN_USER) && p.equals(ServerConfig.CONFIG().getAdminPassword())) {
			return;
		}

		if (userId.equals(AuthenticationUtil.READONLY_USER) && p.equals(ServerConfig.CONFIG().getReadOnlyPassword())) {
			return;
		}
		
		throw new SecurityException("Authentication Failed!");
	}
}
