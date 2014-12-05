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
package ch.flatland.cdo.service.repoaccess

import org.eclipse.emf.cdo.session.CDOSession

class SessionEntry {
	var CDOSession cdoSession
	var long lastHttpSessionActivity

	new(CDOSession cdoSession) {
		this.cdoSession = cdoSession
		lastHttpSessionActivity = System.currentTimeMillis
	}

	def updateHttpSessionActivity() {
		lastHttpSessionActivity = System.currentTimeMillis
	}

	def getLastHttpSessionActivity() {
		lastHttpSessionActivity
	}

	def getCDOSession() {
		cdoSession
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
