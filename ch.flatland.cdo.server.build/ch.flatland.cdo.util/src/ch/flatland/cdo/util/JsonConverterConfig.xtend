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
package ch.flatland.cdo.util

import javax.servlet.http.HttpServletRequest

import static ch.flatland.cdo.util.Constants.*

class JsonConverterConfig {

	var meta = false

	new(HttpServletRequest req) {
		init(req)
	}

	def private init(HttpServletRequest req) {
		if (req.getParameter(PARAM_META) != null) {
			meta = true
		}
	}

	new() {
	}

	def isMeta() {
		meta
	}

	def setMeta(boolean meta) {
		this.meta = meta
	}
}
