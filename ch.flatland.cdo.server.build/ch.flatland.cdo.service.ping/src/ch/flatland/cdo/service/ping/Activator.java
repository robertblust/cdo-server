package ch.flatland.cdo.service.ping;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration<?> registration;

	  @Override
	  public void start( BundleContext context ) throws Exception {
	    PingService exampleService = new PingService();
	    registration = context.registerService( PingService.class.getName(), exampleService, null );
	  }

	  @Override
	  public void stop( BundleContext context ) throws Exception {
	    registration.unregister();
	  }

}
