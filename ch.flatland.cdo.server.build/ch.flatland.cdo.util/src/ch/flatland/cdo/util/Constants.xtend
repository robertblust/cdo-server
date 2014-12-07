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

class Constants {

	// http
	val public static PARAM_META = "meta"
	val public static PARAM_JSONP_CALLBACK = "callback"
	val public static PARAM_ORDER_BY = "orderBy"
	val public static PARAM_FORCE = "force"
	val public static PARAM_XOR_FILTER = "or"
	val public static PARAM_NO_REFS = "noRefs"
	val public static PARAM_VALIDATE = "validate"
	val public static ACCEPT_ALL_CONTENTTYPE = "*/*"
	val public static JSON_CONTENTTYPE = "application/json"
	val public static JSON_CONTENTTYPE_UTF8 = "application/json; charset=utf-8"
	val public static JSONP_CONTENTTYPE = "application/javascript"
	val public static JSONP_CONTENTTYPE_UTF8 = "application/javascript; charset=utf-8"

	val public static ACCEPTED_CONTENTTYPES = newArrayList(ACCEPT_ALL_CONTENTTYPE, JSON_CONTENTTYPE, JSON_CONTENTTYPE_UTF8)

	// json
	val public static ID = "id"
	val public static TYPE = "type"
	val public static ENUM_LITERALS = "literals"
	val public static LABEL = "label"
	val public static LOWER_BOUND = "lowerBound"
	val public static UPPER_BOUND = "upperBound"
	val public static HREF = "href"
	val public static NAME = "name"
	val public static CONTAINER = "hrefContainer"
	val public static PUT = "put"
	val public static ATTRIBUTES = "attributes"
	val public static REFERENCES = "references"
	val public static CONTAINMENT = "containment"
	val public static DERIVED = "derived"
	val public static PERMISSION = "permission"
	val public static ORIGIN = "origin"
	val public static MESSAGE = "message"
	val public static MESSAGES = "messages"
	val public static FEATURE = "feature"
	val public static STATUS = "status"
	val public static HTTP_STATUS = "httpStatus"
	val public static HTTP_STATUS_DESCRIPTION = "httpDescription"
	val public static DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
	val public static DATA = "data"

	// servlets
	val public static ALIAS_NODE = "/node"
	val public static ALIAS_OBJECT = "/obj"
}
