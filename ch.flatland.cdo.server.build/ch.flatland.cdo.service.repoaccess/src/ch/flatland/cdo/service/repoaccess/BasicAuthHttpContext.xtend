package ch.flatland.cdo.service.repoaccess

import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.osgi.service.http.HttpContext

class BasicAuthHttpContext implements HttpContext {

	override handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// only allow https
		if (!request.getScheme().equals("https")) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN)
			return false
		}

		// check if authorization header is available
		if (request.getHeader("Authorization") == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
			return false
		}

		if (RepoAccessPlugin.getDefault.debugging) {
			println(
				'''
					>>>
					   handleSecurity(HttpServletRequest request, HttpServletResponse response) «this.class.name»
					   Authorization != null
					<<<
				''')
		}
		return true

	}

	override getMimeType(String name) {
		return null
	}

	override getResource(String name) {
		return null
	}
}
