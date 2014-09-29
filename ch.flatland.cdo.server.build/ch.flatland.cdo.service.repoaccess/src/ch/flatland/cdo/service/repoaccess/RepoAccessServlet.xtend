package ch.flatland.cdo.service.repoaccess

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.id.CDOIDUtil

import static extension ch.flatland.cdo.util.Json.*

class RepoAccessServlet extends AbstractAccessServlet {

	public val static PARAM_OID = "oid"
	public val static PARAM_META = "meta"
	public val static SERVLET_CONTEXT = "/repo"

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (RepoAccessPlugin.getDefault.debugging) {
			logRequest(req)
		}
		resp.contentType = jsonContentTypeUTF8
		val serverBaseUrl = req.requestURL.substring(0, req.requestURL.indexOf(SERVLET_CONTEXT)) + SERVLET_CONTEXT
		
		try {
			var CDOObject requestedObject = null
			if (req.getParameter(PARAM_META) != null && req.getParameter(PARAM_META).length > 0) {
				val meta = req.getParameter(PARAM_META)
				resp.writer.append(meta.toJson(serverBaseUrl))
				return
			} else if (req.getParameter(PARAM_OID) != null && req.getParameter(PARAM_OID).length > 0) {
				val oid = Long.parseLong(req.getParameter(PARAM_OID))
				requestedObject = view.getObject(CDOIDUtil.createLong(oid))
			} else {
				requestedObject = view.getResourceNode(req.pathInfo)
			}
			resp.writer.append(requestedObject.toJson(serverBaseUrl))
		} catch (Exception e) {
			resp.writer.append(e.toJson(serverBaseUrl))
			e.printStackTrace
		}
	}

}
