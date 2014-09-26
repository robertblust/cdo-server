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

	def static String toJson(Object object) {
		converter.toJson(object)
	}
}
