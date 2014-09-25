package ch.flatland.cdo.service.ping

import ch.flatland.cdo.service.ping.model.PingBean
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static extension ch.flatland.cdo.util.Json.*

class PingServlet extends HttpServlet {
	
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.contentType = jsonContentTypeUTF8
		resp.writer.append(new PingBean("Flatland CDO Server", "1.0.0").toJson)
	}	
}