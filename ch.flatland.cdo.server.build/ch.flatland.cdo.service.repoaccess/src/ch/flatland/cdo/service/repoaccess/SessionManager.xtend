package ch.flatland.cdo.service.repoaccess

class SessionManager extends Thread {

	val TIMEOUT_PROPERTY = "org.eclipse.equinox.http.jetty.context.sessioninactiveinterval"
	val timeoutProperty = System.getProperty(TIMEOUT_PROPERTY)

	override run() {
		name = "Thread [" + class.name + "]"
		if (timeoutProperty == null) {
			throw new RuntimeException("-D" + TIMEOUT_PROPERTY + " not set!")
		}

		val timeout = Long.parseLong(timeoutProperty) * 1000

		while (true) {
			sleep(timeout)
			invalidateSessions(timeout)
		}
	}

	def invalidateSessions(long timeout) {
		if (RepoAccessPlugin.getDefault.debugging) {
			println(
				'''
					>>>
					   invalidateSessions(«timeout») «this.class.name»''')
		}
		val sessionIds = SessionFactory.getSessionMap.keySet.clone
		for (sessionId : sessionIds) {
			val sessionEntry = SessionFactory.getSessionMap.get(sessionId)
			if (System.currentTimeMillis - sessionEntry.lastHttpSessionActivity > timeout) {
				sessionEntry.invalidateCDOsession
				SessionFactory.getSessionMap.remove(sessionId)
				if (RepoAccessPlugin.getDefault.debugging) {
					println(
						'''      Removed inactive session [«sessionId»]''')
				}
			}
		}
		if (RepoAccessPlugin.getDefault.debugging) {
			println(
				'''<<<
				''')
		}
	}
}
