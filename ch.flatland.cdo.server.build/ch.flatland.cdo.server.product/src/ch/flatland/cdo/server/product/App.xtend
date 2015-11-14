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

import ch.flatland.cdo.server.config.ServerConfig
import java.util.concurrent.CountDownLatch
import org.eclipse.equinox.app.IApplication
import org.eclipse.equinox.app.IApplicationContext

import static ch.flatland.cdo.server.config.ServerConfig.*

class App implements IApplication {

	public static final String BUNDLE_ID = "ch.flatland.cdo.server.product.app"

	var CountDownLatch stopLatch;
	var IApplicationContext context;

	override start(IApplicationContext context) throws Exception {
		this.context = context
		if (!ServerConfig.bridgeMode) {
			if (CONFIG.binding.tcp) {
				TCPAcceptor.start
			}
			if (CONFIG.binding.http) {
				HTTPAcceptor.start
			}
			Repository.start
		}

		if (context != null) {
			context.applicationRunning()
		}

		stopLatch = new CountDownLatch(1)
		stopLatch.await()
		stopLatch = null
		return EXIT_OK
	}

	override stop() {
		if (!ServerConfig.bridgeMode) {
			if (CONFIG.binding.http) {
				HTTPAcceptor.stop
			}
			if (CONFIG.binding.tcp) {
				TCPAcceptor.stop
			}
			Repository.stop
		}

		context = null
		if (stopLatch != null) {
			stopLatch.countDown()
		}
	}

	def static info(String message) {
		println("[INFO] " + message)
	}

}
