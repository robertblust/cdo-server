package ch.flatland.cdo.server.ldap;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class LdapAuthenticatorPlugin extends Plugin {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	// The shared instance
	private static LdapAuthenticatorPlugin plugin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		LdapAuthenticatorPlugin.context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		LdapAuthenticatorPlugin.context = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static LdapAuthenticatorPlugin getDefault() {
		return plugin;
	}

}
