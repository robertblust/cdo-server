package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.server.ServerUtil
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import org.eclipse.emf.cdo.session.CDOSession
import org.eclipse.emf.cdo.view.CDOView

class AbstractAccessServlet extends HttpServlet {

	var CDOSession session = null;
	var CDOView view = null;

	def synchronized getView() {
		if (view == null || view.closed) {
			session = ServerUtil.openReadOnlySession
			view = session.openView
		}
		view
	}

	override init() throws ServletException {
		super.init()
		if (RepoAccessPlugin.getDefault.debugging) {
			println(
				'''
					>>>
					   init() «this.class.name»
					<<<
				''')
		}
	}
}
