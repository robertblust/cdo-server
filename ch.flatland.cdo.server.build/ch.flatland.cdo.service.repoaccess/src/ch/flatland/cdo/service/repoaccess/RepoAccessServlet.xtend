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

import ch.flatland.cdo.util.AbstractServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RepoAccessServlet extends AbstractServlet {

	override protected doGet(HttpServletRequest req, HttpServletResponse resp) {
		logRequest(req)
		(new Get).run(req, resp)
	}

	override protected doPost(HttpServletRequest req, HttpServletResponse resp) {
		logRequest(req)
		(new Post).run(req, resp)
	}

	override protected doDelete(HttpServletRequest req, HttpServletResponse resp) {
		logRequest(req)
		(new Delete).run(req, resp)
	}

	override protected doPut(HttpServletRequest req, HttpServletResponse resp) {
		logRequest(req)
		(new Put).run(req, resp)
	}
}
