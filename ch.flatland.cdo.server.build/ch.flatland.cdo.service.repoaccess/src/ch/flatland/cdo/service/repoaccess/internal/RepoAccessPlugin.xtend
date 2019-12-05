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

import ch.flatland.cdo.util.AbstractFlatlandPlugin
import org.osgi.framework.BundleContext

class RepoAccessPlugin extends AbstractFlatlandPlugin {

	var SessionManager sessionManager

	override start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext)
		sessionManager = new SessionManager
		sessionManager.start
	}
}
