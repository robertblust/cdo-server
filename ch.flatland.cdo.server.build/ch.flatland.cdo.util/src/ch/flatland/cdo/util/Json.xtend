package ch.flatland.cdo.util

import ch.flatland.cdo.util.converter.JsonConverter

class Json {

	val static converter = new JsonConverter
	
	val public static PARAM_OID = "oid"
	val public static PARAM_META = "meta"
	val public static JSON_CONTENTTYPE = "application/json"
	val public static JSON_CONTENTTYPE_UTF8 = "application/json; charset=utf-8"
	val public static JSONP_CONTENTTYPE = "application/javascript"
	val public static JSONP_CONTENTTYPE_UTF8 = "application/javascript; charset=utf-8"

	def static String paramOid() {
		PARAM_OID
	}

	def static String paramMeta() {
		PARAM_META
	}
	
	def static String jsonContentType() {
		JSON_CONTENTTYPE
	}

	def static String jsonContentTypeUTF8() {
		JSON_CONTENTTYPE_UTF8
	}

	def static String jsonpContentType() {
		JSONP_CONTENTTYPE
	}

	def static String jsonpContentTypeUTF8() {
		JSONP_CONTENTTYPE_UTF8
	}

	def static String toJson(Object object, String serverBaseUrl) {
		converter.toJson(object, serverBaseUrl)
	}
}
