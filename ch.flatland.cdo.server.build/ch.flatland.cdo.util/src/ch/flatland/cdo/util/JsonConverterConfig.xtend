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
	val public static TYPE = "type"
	val public static ENUM_LITERALS = "literals"
	val public static LABEL = "label"
	val public static LOWER_BOUND = "lowerBound"
	val public static UPPER_BOUND = "upperBound"
	val public static HREF = "href"
	val public static NAME = "name"
	val public static CONTAINER = "hrefContainer"
	val public static ATTRIBUTES = "attributes"
	val public static REFERENCES = "references"
	val public static CONTAINMENT = "containment"
	val public static DERIVED = "derived"
	val public static PERMISSION = "permission"
	val public static MESSAGE = "message"
	val public static DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

	String servletUrl
	String servletContext
	var meta = false

	new(String servletUrl, String servletContext) {
		this.servletUrl = servletUrl
		this.servletContext = servletContext
	}

	new() {
		servletUrl = ""
		servletContext = ""
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
