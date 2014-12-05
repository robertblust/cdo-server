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
package ch.flatland.cdo.util

import org.eclipse.core.runtime.Plugin
import org.osgi.framework.BundleContext

abstract class AbstractFlatlandPlugin extends Plugin {
	var static BundleContext context

	def static getContext() {
		context
	}

	// The shared instance
	var static AbstractFlatlandPlugin plugin

	def override start(BundleContext bundleContext) throws Exception {
		AbstractFlatlandPlugin.context = bundleContext
		plugin = this;
	}

	def override stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		AbstractFlatlandPlugin.context = null;
	}

	def static getDefault() {
		return plugin;
	}
}
