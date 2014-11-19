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

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest

import static extension ch.flatland.cdo.service.repoaccess.BasicAuth.*

class AbstractAccessServlet extends HttpServlet {

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
				   userId = «req.userId»
				<<<
			''')
	}
}
