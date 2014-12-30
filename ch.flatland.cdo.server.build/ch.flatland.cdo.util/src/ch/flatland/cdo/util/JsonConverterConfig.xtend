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
package ch.flatland.cdo.util

import javax.servlet.http.HttpServletRequest
import static ch.flatland.cdo.server.config.ServerConfig.*

class JsonConverterConfig {

	var meta = false
	var showReferences = true
	var validate = false
	var history = false
	var serverAddress = ""

	val extension Request = new Request

	new(HttpServletRequest req) {
		init(req)
	}

	def private init(HttpServletRequest req) {
		meta = req.metaDataRequested
		showReferences = req.refs
		validate = req.validate
		history = req.history
		serverAddress = req.serverAddress
	}

	new() {
	}

	def isMeta() {
		if(CONFIG.json.meta) {
			return true
		}
		return meta
	}

	def isShowReferences() {
		if(CONFIG.json.references) {
			return true
		}
		return showReferences
	}

	def isValidate() {
		if(CONFIG.json.validate) {
			return true
		}
		return validate
	}

	def isHistory() {
		if(CONFIG.json.history) {
			return true
		}
		return history
	}

	def getServerAddress() {
		if(CONFIG.json.fullUrl) {
			return serverAddress
		}
		return ""
	}
}
