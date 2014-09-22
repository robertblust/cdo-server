package ch.flatland.cdo.service.ping

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.osgi.framework.ServiceRegistration

class Activator implements BundleActivator {
	private var ServiceRegistration<?> registration

	def override start(BundleContext context) throws Exception {
		val pingService = new PingService()
		registration = context.registerService(typeof(PingService).name, pingService, null)
	}

	def override stop(BundleContext context) throws Exception {
		registration.unregister()
	}
}
