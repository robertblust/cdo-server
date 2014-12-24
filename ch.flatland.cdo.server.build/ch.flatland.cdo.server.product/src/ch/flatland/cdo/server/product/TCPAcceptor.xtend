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

import ch.flatland.cdo.server.config.ServerConfig
import org.eclipse.net4j.acceptor.IAcceptor
import org.eclipse.net4j.util.container.IPluginContainer
import org.eclipse.net4j.util.lifecycle.LifecycleUtil

class TCPAcceptor {

	private new() {
		// hide constructor
	}

	// the singleton
	var static IAcceptor INSTANCE

	// network config
	val static ACCEPTORS_KEY = "org.eclipse.net4j.acceptors"

	def static void start() {
		App.info("Start TCP acceptor")
		INSTANCE = IPluginContainer.INSTANCE.getElement(ACCEPTORS_KEY, "tcp", ServerConfig.getConfig.binding.ip + ":" + ServerConfig.getConfig.binding.tcpPort) as IAcceptor
	}

	def static stop() {
		App.info("Stop TCP acceptor")
		LifecycleUtil.deactivate(INSTANCE)
	}
}
