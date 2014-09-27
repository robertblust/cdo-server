package ch.flatland.cdo.service.repoaccess

import javax.servlet.http.HttpServlet
import org.eclipse.emf.cdo.session.CDOSession
import org.eclipse.emf.cdo.view.CDOView
import ch.flatland.cdo.server.ServerUtil

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
	
	override destroy() {
		if (view != null && !view.closed) {
			view.close
			view = null
		}
		if (session != null && !session.closed) {
			session.close
			session = null
		}
		super.destroy()
	}	
}
