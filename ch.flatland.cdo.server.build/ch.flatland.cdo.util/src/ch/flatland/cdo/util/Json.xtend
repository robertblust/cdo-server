package ch.flatland.cdo.util

import ch.flatland.cdo.util.converter.JsonConverter

class Json {

	val static converter = new JsonConverter

	def static String jsonContentType() {
		"application/json"
	}

	def static String jsonContentTypeUTF8() {
		"application/json; charset=utf-8 "
	}

	def static String jsonpContentType() {
		"application/javascript"
	}

	def static String jsonpContentTypeUTF8() {
		"application/javascript; charset=utf-8 "
	}

	def static String toJson(Object object, String serverBaseUrl) {
		converter.toJson(object, serverBaseUrl)
	}
}
