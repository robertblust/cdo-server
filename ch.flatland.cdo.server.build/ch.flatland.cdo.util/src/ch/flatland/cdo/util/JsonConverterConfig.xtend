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

class JsonConverterConfig {

	var meta = false
	var showReferences = true
	var validate = false

	val extension Request = new Request

	new(HttpServletRequest req) {
		init(req)
	}

	def private init(HttpServletRequest req) {
		meta = req.metaDataRequested
		showReferences = !req.noRefs
		validate = req.validate
	}

	new() {
	}

	def isMeta() {
		meta
	}

	def isShowReferences() {
		showReferences
	}
	
	def isValidate() {
		validate
	}
}
