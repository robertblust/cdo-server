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
package ch.flatland.cdo.service.repoaccess.internal

import org.eclipse.emf.cdo.session.CDOSession

class SessionEntry {
	var CDOSession cdoSession
	var long lastHttpSessionActivity
	var String password
	var String repoName

	new(CDOSession cdoSession, String password, String repoName) {
		this.cdoSession = cdoSession
		lastHttpSessionActivity = System.currentTimeMillis
		this.password = password
		this.repoName = repoName
	}

	def updateHttpSessionActivity() {
		lastHttpSessionActivity = System.currentTimeMillis
	}

	def getLastHttpSessionActivity() {
		lastHttpSessionActivity
	}
	
	def getPassword() {
		password
	}

	def getCDOSession() {
		cdoSession
	}
	
	def getRepoName() {
		repoName
	}

	def setCDOSession(CDOSession cdoSession) {
		this.cdoSession = cdoSession
	}

	def invalidateCDOsession() {
		if(!cdoSession.isClosed) {
			cdoSession.close
		}
		cdoSession == null
	}
}
