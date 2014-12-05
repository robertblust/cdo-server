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

import org.eclipse.net4j.acceptor.IAcceptor
import org.eclipse.net4j.util.container.IPluginContainer
import org.eclipse.net4j.util.lifecycle.LifecycleUtil
import ch.flatland.cdo.server.ServerUtil

class Acceptor {

	private new() {
		// hide constructor
	}

	// the singleton
	var static IAcceptor INSTANCE

	// network config
	val static ACCEPTORS_KEY = "org.eclipse.net4j.acceptors"
	val static PROTOCOL = "tcp"
	val static ALL_NETWORKS = "0.0.0.0"
	val static PORT = ServerUtil.ACCEPTOR_PORT

	def static void start() {
		App.info("Start acceptor")
		INSTANCE = IPluginContainer.INSTANCE.getElement(ACCEPTORS_KEY, PROTOCOL, ALL_NETWORKS + ":" + PORT) as IAcceptor
	}

	def static stop() {
		App.info("Stop acceptor")
		LifecycleUtil.deactivate(INSTANCE)
	}
}
