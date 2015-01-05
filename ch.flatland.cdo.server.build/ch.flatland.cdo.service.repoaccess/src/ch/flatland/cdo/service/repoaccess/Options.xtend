/*
 * Copyright (c) 2014 Robert Blust (Zurich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.util.Response
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory

class Options {
	
	val logger = LoggerFactory.getLogger(this.class)

	val extension Response = new Response
	
	def void run(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("Run")
		
		resp.writeEmptyResponse(req)
	}
}