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

class Constants {

	// http
	val public static PARAM_ARRAY_ACCESSOR = "arrayAccessor"
	val public static PARAM_META = "meta"
	val public static PARAM_JSONP_CALLBACK = "callback"
	val public static PARAM_ORDER_BY = "orderBy"
	val public static PARAM_FORCE = "force"
	val public static PARAM_XOR_FILTER = "or"
	/* all containment references */
	val public static PARAM_CREFS = "crefs"
	/* all relation references */
	val public static PARAM_RREFS = "rrefs"
	/* all cross references */
	val public static PARAM_XREFS = "xrefs"
	val public static PARAM_LINKS = "links"
	val public static PARAM_XLINKS = "xlinks"
	val public static PARAM_VALIDATION = "val"
	val public static PARAM_POINT_IN_TIME = "pit"
	val public static PARAM_HISTORY = "history"
	val public static ACCEPT_ALL_CONTENTTYPE = "*/*"
	val public static JSON_CONTENTTYPE = "application/json"
	val public static JSON_CONTENTTYPE_UTF8 = "application/json; charset=utf-8"
	val public static JSONP_CONTENTTYPE = "application/javascript"
	val public static JSONP_CONTENTTYPE_UTF8 = "application/javascript; charset=utf-8"
	val public static GIF_CONTENTTYPE = "image/gif"
	val public static GIF_FORMAT = "gif"
	val public static METHOD_POST = "POST"
	val public static METHOD_GET = "GET"
	val public static METHOD_OPTIONS = "OPTIONS"

	val public static ACCEPTED_CONTENTTYPES = newArrayList(ACCEPT_ALL_CONTENTTYPE, JSON_CONTENTTYPE, JSON_CONTENTTYPE_UTF8)

	// json
	val public static ID = "id"
	val public static TYPE = "type"
	val public static JS_TYPE = "jsType"
	val public static ENUM_LITERALS = "literals"
	val public static LABEL = "label"
	val public static LOWER_BOUND = "lowerBound"
	val public static UPPER_BOUND = "upperBound"
	val public static SELF = "self"
	val public static NAME = "name"
	val public static VALUE = "value"
	val public static CONTAINER = "container"
	val public static ATTRIBUTES = "attributes"
	val public static ATTRIBUTES_ARRAY = "attributesArray"
	val public static REFERENCES = "references"
	val public static REFERENCES_ARRAY = "referencesArray"
	val public static XREFERENCES = "xReferences"
	val public static CONTAINMENT = "containment"
	val public static EXTENDS = "extends"
	val public static DERIVED = "derived"
	val public static MANY = "many"
	val public static REQUIRED = "required"
	val public static PERMISSION = "permission"
	val public static ORIGIN = "origin"
	val public static MESSAGE = "message"
	val public static MESSAGES = "messages"
	val public static FEATURE = "feature"
	val public static STATUS = "status"
	val public static DIAGNOSTICS = "diagnostics"
	val public static DIAGNOSTIC = "diagnostic"
	val public static REVISION_DELTAS = "revisionDeltas"
	val public static REVISION_DELTA = "revisionDelta"
	val public static DETAILS = "details"
	val public static HTTP_STATUS = "httpStatus"
	val public static ALL_INSTANCES = "allInstances"
	val public static ERROR = "error"
	val public static INSTANCE_CLASS_NAME = "instanceClassName"
	val public static HTTP_STATUS_DESCRIPTION = "httpDescription"
	val public static DATA = "data"
	val public static HISTORY = "history"
	val public static REVISION = "revision"
	val public static DATE = "date"
	val public static AUTHOR = "author"
	val public static LINKS = "_links"
	val public static XLINKS = "_xLinks"
	val public static HREF = "href"
	val public static HREFS = "hrefs"
	val public static SIZE = "size"
	val public static ICON = "icon"
	val public static PATTERN = "pattern"
	val public static PATTERN_NUMBER = "-?[0-9]*"
	val public static PATTERN_DECIMAL = "-?[0-9]*\\.?[0-9]*" 
	val public static PATTERN_DATE = "[0-9][0-9][0-9][0-9]-(([1]([0|1|2]))|([0][1-9]))-(([3]([0|1]))|(([0])[1-9])|(([1]|[2])[0-9]))T([0-1][0-9]|[2][0-3]):([0-5][0-9]):([0-5][0-9]).[0-9][0-9][0-9]Z"

	// servlets
	val public static ALIAS_NODE = "/node"
	val public static ALIAS_OBJECT = "/obj"
	val public static ALIAS_ICON = "/icon"
	val public static ALIAS_XREFS = "/xrefs"
}
