package ch.flatland.cdo.util

import com.google.gson.Gson

class Json {
	static val gson = new Gson
	
	def static String jsonContentType() {
		"application/json"
	}
	
	def static String jsonContentTypeUTF8() {
		"application/json; charset=utf-8 "
	}
	
	def static String toJson(Object object) {
		gson.toJson(object)
	}
}