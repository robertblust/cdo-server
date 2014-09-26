package ch.flatland.cdo.service.repoaccess

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static extension ch.flatland.cdo.util.Json.*

class RepoAccessServlet extends HttpServlet {

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.contentType = jsonContentTypeUTF8
		resp.writer.append("Hallo Repo Access")
	}

}
