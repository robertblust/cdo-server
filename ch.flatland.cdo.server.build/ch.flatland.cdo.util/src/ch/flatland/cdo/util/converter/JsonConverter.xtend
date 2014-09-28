package ch.flatland.cdo.util.converter

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory

class JsonConverter {
	static val gson = new Gson
	static val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(
		new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))

	static val ignoredAttributes = newArrayList("resourceSet", "modified", "loaded", "trackingModification", "errors",
		"warnings", "timeStamp")

	def dispatch String toJson(Object object, String serverBaseUrl) {
		gson.toJson(object)
	}

	def dispatch String toJson(CDOObject object, String serverBaseUrl) {
		val jsonBaseObject = object.toJsonBase(serverBaseUrl)

		jsonBaseObject.addJsonContent(object, serverBaseUrl)
		jsonBaseObject.addJsonAttributes(object, serverBaseUrl)
		jsonBaseObject.toString
	}

	def dispatch String toJson(Throwable object, String serverBaseUrl) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addProperty("type", "ch.flatland.Exception")
		jsonBaseObject.addProperty("label", object.class.simpleName)
		if (object.message != null) {
			jsonBaseObject.addProperty("message", object.message)
		}
		jsonBaseObject.toString
	}

	// helper
	def private toJsonBase(CDOObject object, String serverBaseUrl) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addProperty("type", object.eClass.EPackage.nsPrefix + "." + object.eClass.name)
		jsonBaseObject.addProperty("label", ITEM_DELEGATOR.getText(object))
		jsonBaseObject.addProperty("oid", Long.parseLong(object.cdoID.toURIFragment.replace("L", "")))
		jsonBaseObject.addProperty("uri", serverBaseUrl + "?oid=" + object.cdoID.toURIFragment.replace("L", ""))
		return jsonBaseObject
	}

	def private addJsonContent(JsonObject jsonBaseObject, CDOObject object, String serverBaseUrl) {
		if (object.eContents.size > 0) {
			val jsonContentArray = new JsonArray
			for (o : object.eContents) {
				jsonContentArray.add((o as CDOObject).toJsonBase(serverBaseUrl))
			}
			jsonBaseObject.add("content", jsonContentArray)
		}
	}

	def private addJsonAttributes(JsonObject jsonBaseObject, CDOObject object, String serverBaseUrl) {
		val attributes = object.eClass.EAllAttributes
		val jsonAttributeArray = new JsonArray
		if (attributes.size > 0) {
			for (attribute : attributes.filter[!ignoredAttributes.contains(name)]) {
				println(attribute.name + " is many " + attribute.many)
				val name = attribute.name
				val value = object.eGet(attribute, true)
				if (value != null) {
					println(value.class.name)
					val jsonObject = new JsonObject
					switch value.class {
						case Long: jsonObject.addProperty(name, value as Long)
						case Integer: jsonObject.addProperty(name, value as Integer)
						case Boolean: jsonObject.addProperty(name, value as Boolean)
						default: jsonObject.addProperty(name, value.toString)
					}
					jsonAttributeArray.add(jsonObject)
				}
			}
			jsonBaseObject.add("attributes", jsonAttributeArray)
		}
	}
}
