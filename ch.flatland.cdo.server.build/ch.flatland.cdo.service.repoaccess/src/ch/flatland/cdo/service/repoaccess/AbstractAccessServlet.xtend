/*
 * Copyright (c) 2014 Robert Blust (Zürich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.server.ServerUtil
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import org.eclipse.emf.cdo.session.CDOSession
import org.eclipse.emf.cdo.view.CDOAdapterPolicy
import org.eclipse.emf.cdo.view.CDOView

class AbstractAccessServlet extends HttpServlet {

	var CDOSession session = null;
	var CDOView view = null;

	def synchronized getView() {
		if (view == null || view.closed) {
			session = ServerUtil.openReadOnlySession
			view = session.openView
			view.options().addChangeSubscriptionPolicy(CDOAdapterPolicy.ALL);
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

	def logRequest(HttpServletRequest req) {
		println(
			'''
				>>>
				   doGet() «this.class.name»
				   req.pathInfo = «req.pathInfo»
				   params = «req.parameterMap»
				<<<
			''')
	}
}
