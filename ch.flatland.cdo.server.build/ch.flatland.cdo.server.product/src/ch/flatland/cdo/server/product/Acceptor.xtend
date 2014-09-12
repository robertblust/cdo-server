package ch.flatland.cdo.server.product

import org.eclipse.net4j.acceptor.IAcceptor
import org.eclipse.net4j.util.container.IPluginContainer
import org.eclipse.net4j.util.lifecycle.LifecycleUtil

class Acceptor {
	
	private new () {
		// hide constructor
	}
	
	// the singleton
	var static IAcceptor INSTANCE
	
	// network config
	val static ACCEPTORS_KEY = "org.eclipse.net4j.acceptors"
	val static PROTOCOL = "tcp"
	val static ALL_NETWORKS = "0.0.0.0"
	val static PORT = "2036"
	
	def static void start() {
		App.info("Start acceptor")
		INSTANCE = IPluginContainer.INSTANCE.getElement(ACCEPTORS_KEY, PROTOCOL,  ALL_NETWORKS + ":" + PORT) as IAcceptor
	}
	
	def static stop() {
		App.info("Stop acceptor")
		LifecycleUtil.deactivate(INSTANCE)
	}
}