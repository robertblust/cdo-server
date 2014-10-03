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

class JsonConverterConfig {
	String servletUrl
	String servletContext
	var meta = false
	
	new(String servletUrl, String servletContext) {
		this.servletUrl = servletUrl
		this.servletContext = servletContext
	}
	
	def getServerUrl() {
		servletUrl.replace(servletContext, "")
	}
	
	def getServletUrl() {
		servletUrl
	}
	
	def getServletContext() {
		servletContext
	}
	
	def isMeta() {
		meta
	}
	
	def setMeta(boolean meta) {
		this.meta = meta
	}
}