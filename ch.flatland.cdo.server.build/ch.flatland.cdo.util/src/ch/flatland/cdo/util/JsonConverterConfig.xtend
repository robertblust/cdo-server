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

	var arrayAccessor = false
	var meta = false
	var references = false
	var rreferences = false
	var creferences = false
	var xreferences = false
	var validate = true
	var history = false
	var links = true
	var xlinks = true
	var xtraces = false
	var serverAddress = ""

	val extension Request = new Request

	new(HttpServletRequest req) {
		init(req)
	}

	def private init(HttpServletRequest req) {
		arrayAccessor = req.arrayAccessor
		meta = req.metaDataRequested
		references = req.refs
		rreferences = req.rrefs
		creferences = req.crefs
		xreferences = req.xrefs
		validate = req.validate
		history = req.history
		serverAddress = req.serverAddress
		links = req.links
		xlinks = req.xlinks
		xtraces = req.xtraces
	}

	new() {
	}

	def isMeta() {
		if(CONFIG.json.meta) {
			return true
		}
		return meta
	}
	
	def isArrayAccessor() {
		if(CONFIG.json.arrayaccessor) {
			return true
		}
		return arrayAccessor
	}

	def isReferences() {
		if(CONFIG.json.rreferences || CONFIG.json.creferences) {
			return true
		}
		return references
	}
	
	def isRreferences() {
		if(CONFIG.json.rreferences) {
			return true
		}
		return rreferences
	}
	
	def isCreferences() {
		if(CONFIG.json.creferences) {
			return true
		}
		return creferences
	}
	
	def isXreferences() {
		if(CONFIG.json.xreferences) {
			return true
		}
		return xreferences
	}

	def isValidate() {
		if(CONFIG.json.validate) {
			return true
		}
		return validate
	}
	
	def isXtraces() {
		if(CONFIG.json.xtraces) {
			return true
		}
		return xtraces
	}

	def isHistory() {
		if(CONFIG.json.history) {
			return true
		}
		return history
	}
	
	def isLinks() {
		if(CONFIG.json.links) {
			return true
		}
		return links
	}
	
	def isXlinks() {
		if(CONFIG.json.xlinks) {
			return true
		}
		return xlinks
	}

	def getServerAddress() {
		if(CONFIG.json.fullUrl) {
			return serverAddress
		}
		return ""
	}
}
