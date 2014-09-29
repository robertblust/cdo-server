package ch.flatland.cdo.util.converter

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.util.List
import java.util.Map
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import com.google.gson.JsonPrimitive

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

		jsonBaseObject.addJsonAttributes(object, serverBaseUrl)
		val references = addReferences(object, serverBaseUrl)
		if (references.size > 0) {
			jsonBaseObject.add("references", references)
		}
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

	// helpers
	def private toJsonBase(CDOObject object, String serverBaseUrl) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addProperty("type", object.eClass.EPackage.nsPrefix + "." + object.eClass.name)
		jsonBaseObject.addProperty("label", ITEM_DELEGATOR.getText(object))
		jsonBaseObject.addProperty("oid", Long.parseLong(object.cdoID.toURIFragment.replace("L", "")))
		jsonBaseObject.addProperty("url", serverBaseUrl + "?oid=" + object.cdoID.toURIFragment.replace("L", ""))
		
		var CDOObject container = null
		if (object.eContainer != null) {
			container = object.eContainer as CDOObject
		} else {
			container = object.cdoResource
		}

		jsonBaseObject.addProperty("container", serverBaseUrl + "?oid=" + container.cdoID.toURIFragment.replace("L", ""))

		return jsonBaseObject
	}

	def private addJsonAttributes(JsonObject jsonBaseObject, CDOObject object, String serverBaseUrl) {
		val attributes = object.eClass.EAllAttributes
		val jsonAttributes = new JsonObject
		if (attributes.size > 0) {
			for (attribute : attributes.filter[!ignoredAttributes.contains(name)]) {
				val name = attribute.name
				if (attribute.many) {
					val values = object.eGet(attribute, true) as List<Object>
					if (values.size > 0) {
						val jsonPrimitiveArray = new JsonArray
						for (v : values) {
							switch v.class {
								case Long: jsonPrimitiveArray.add(new JsonPrimitive(v as Long))
								case Integer: jsonPrimitiveArray.add(new JsonPrimitive(v as Integer))
								case Boolean: jsonPrimitiveArray.add(new JsonPrimitive(v as Boolean))
								default: jsonPrimitiveArray.add(new JsonPrimitive(v.toString))
							}
						}
						jsonAttributes.add(name, jsonPrimitiveArray)
					}
				} else {
					val value = object.eGet(attribute, true)
					if (value != null) {
						switch value.class {
							case Long: jsonAttributes.addProperty(name, value as Long)
							case Integer: jsonAttributes.addProperty(name, value as Integer)
							case Boolean: jsonAttributes.addProperty(name, value as Boolean)
							default: jsonAttributes.addProperty(name, value.toString)
						}
					}
				}

			}
			if (jsonAttributes.entrySet.size > 0) {
				jsonBaseObject.add("attributes", jsonAttributes)
			}
		}
	}

	def private addReferences(CDOObject cdoObject, String serverUrl) {
		val references = cdoObject.eClass.EAllReferences
		val Map<String, JsonArray> objectMap = newHashMap
		for (EReference r : references) {
			val name = r.getName()
			var JsonArray list = null
			if (objectMap.containsKey(name)) {
				list = objectMap.get(r)
			} else {
				list = new JsonArray
				objectMap.put(name, list);
			}
			if (r.isMany()) {
				val List<Object> manies = cdoObject.eGet(r, true) as List<Object>
				for (Object o : manies) {
					list.add((o as CDOObject).toJsonBase(serverUrl))
				}
			} else {
				val o = cdoObject.eGet(r, true)
				if (o != null) {
					list.add((o as CDOObject).toJsonBase(serverUrl))
				}
			}
		}
		val refsArray = new JsonArray
		for (key : objectMap.keySet) {
			val typedObjects = new JsonObject
			typedObjects.addProperty("name", key)
			typedObjects.add("values", objectMap.get(key))
			if (objectMap.get(key).size > 0) {
				refsArray.add(typedObjects)
			}
		}
		return refsArray;
	}
}
