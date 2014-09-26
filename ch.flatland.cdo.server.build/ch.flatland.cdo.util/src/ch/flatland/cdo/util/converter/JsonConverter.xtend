package ch.flatland.cdo.util.converter

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.eclipse.emf.cdo.CDOObject

class JsonConverter {
	static val gson = new Gson
	
	def dispatch String toJson(Object object) {
		gson.toJson(object)
	}
	
	def dispatch String toJson(CDOObject object) {
		val jsonObject = new JsonObject
		jsonObject.addProperty("type", object.eClass.EPackage.nsPrefix + "." + object.eClass.name)
		jsonObject.addProperty("uri", object.cdoResource.URI.path)
		val allAttributes = object.eClass.EAllAttributes
		allAttributes.forEach[
			
			
		]
		""	
	}
}