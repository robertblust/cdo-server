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

import org.eclipse.emf.cdo.server.spi.security.InternalSecurityManager.CommitHandler
import org.eclipse.net4j.util.container.IPluginContainer

class CommitHandlerFactory {

	private final static String COMMIT_HANDLERS_KEY = "org.eclipse.emf.cdo.server.security.commitHandlers"

	private new() {
		// hide constructor
	}

	def static createAnnotationCommitHandler() {
		IPluginContainer.INSTANCE.getElement(COMMIT_HANDLERS_KEY, "annotation", null) as CommitHandler
	}

	def static createHomeCommitHandler() {
		IPluginContainer.INSTANCE.getElement(COMMIT_HANDLERS_KEY, "home", "/home") as CommitHandler
	}

}
