package ch.flatland.cdo.service.repoaccess

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static ch.flatland.cdo.util.Json.*
import ch.flatland.cdo.server.ServerUtil

class RepoAccessServlet extends HttpServlet {

	override init() throws ServletException {
		super.init()

	}

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.contentType = jsonContentTypeUTF8
		
		val session = ServerUtil.openReadOnlySession
		resp.writer.append("Hallo Repo Access" + session.sessionID)
	}

}
