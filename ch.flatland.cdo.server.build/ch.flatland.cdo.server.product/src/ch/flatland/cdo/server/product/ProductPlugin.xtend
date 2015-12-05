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

import ch.flatland.cdo.util.AbstractFlatlandPlugin
import org.osgi.framework.BundleContext
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*

class ProductPlugin extends AbstractFlatlandPlugin {

	val logger = LoggerFactory.getLogger(AbstractFlatlandPlugin)
	val static final INFO = '''
		
			--------------------------------------------------------------------
			Found plugin 'ch.flatland.cdo.client.admin'
			CDO Web Admin Client
			http://localhost:«System.getProperty("org.eclipse.equinox.http.jetty.http.port")»/admin/index.html
			--------------------------------------------------------------------
	'''

	override start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext)
		if(bundleContext.bundles.filter[it.symbolicName == "ch.flatland.cdo.client.admin"].size == 1) {
			logger.info(INFO)
		}

		if(CONFIG.binding.tcp) {
			TCPAcceptor.start
		}
		if(CONFIG.binding.http) {
			HTTPAcceptor.start
		}
		Repository.start

	}

	override stop(BundleContext bundleContext) throws Exception {

		if(CONFIG.binding.http) {
			HTTPAcceptor.stop
		}
		if(CONFIG.binding.tcp) {
			TCPAcceptor.stop
		}
		Repository.stop

		super.stop(bundleContext)
	}

}
