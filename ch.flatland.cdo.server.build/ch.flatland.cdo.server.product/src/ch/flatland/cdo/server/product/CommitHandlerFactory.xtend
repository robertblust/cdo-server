package ch.flatland.cdo.server.product

import org.eclipse.emf.cdo.server.spi.security.InternalSecurityManager.CommitHandler
import org.eclipse.net4j.util.container.IPluginContainer

class CommitHandlerFactory {

	private final static String COMMIT_HANDLERS_KEY = "org.eclipse.emf.cdo.server.security.commitHandlers";

	private new() {
		// hide constructor
	}

	def static createAnnotationCommitHandler() {
		IPluginContainer.INSTANCE.getElement(COMMIT_HANDLERS_KEY, "annotation", null) as CommitHandler
	}

	def static createHomeCommitHandler() {
		IPluginContainer.INSTANCE.getElement(COMMIT_HANDLERS_KEY, "home", "/home") as CommitHandler
	}

}
