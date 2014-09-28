package ch.flatland.cdo.service.ping

import ch.flatland.cdo.service.ping.model.PingBean
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static extension ch.flatland.cdo.util.Json.*

class PingServlet extends HttpServlet {

	public val static SERVLET_CONTEXT = "/ping"

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.contentType = jsonContentTypeUTF8
		val serverBaseUrl = req.requestURL.substring(0, req.requestURL.indexOf(SERVLET_CONTEXT)) + SERVLET_CONTEXT
		resp.writer.append(new PingBean("Flatland CDO Server", "1.0.0").toJson(serverBaseUrl))
	}

	override init() throws ServletException {
		super.init()
		if (PingPlugin.getDefault.debugging) {
			println(
				'''
					>>>
					   init() «this.class.name»
					<<<
				''')
		}
	}
}
