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