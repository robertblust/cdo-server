package ch.flatland.cdo.server.product

import java.util.concurrent.CountDownLatch
import org.eclipse.equinox.app.IApplication
import org.eclipse.equinox.app.IApplicationContext

class App implements IApplication {

	public static final String BUNDLE_ID = "ch.flatland.cdo.server.product.app"

	var CountDownLatch stopLatch;
	var IApplicationContext context;

	override start(IApplicationContext context) throws Exception {
		this.context = context
		
		Acceptor.start
		Repository.start

		if (context != null) {
			context.applicationRunning()
		}

		stopLatch = new CountDownLatch(1)
		stopLatch.await()
		stopLatch = null
		return EXIT_OK
	}

	override stop() {
		Acceptor.stop
		Repository.stop

		context = null
		if (stopLatch != null) {
			stopLatch.countDown()
		}
	}

	def static info(String message) {
		println("[INFO] " + message)
	}

}
