package ch.flatland.cdo.util.converter

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import java.util.List
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
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

		jsonBaseObject.addJsonAttributes(object, serverBaseUrl)
		jsonBaseObject.addReferences(object, serverBaseUrl)
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
		val jsonBaseObject = toJsonBase(object as EObject, serverBaseUrl)
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
	
	def private toJsonBase(EObject object, String serverBaseUrl) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addProperty("type", object.eClass.EPackage.nsPrefix + "." + object.eClass.name)
		jsonBaseObject.addProperty("label", ITEM_DELEGATOR.getText(object))
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

	def private addReferences(JsonObject jsonBaseObject, CDOObject cdoObject, String serverUrl) {
		val references = cdoObject.eClass.EAllReferences
		val jsonReferences = new JsonObject
		if (references.size > 0) {
			for (EReference reference : references) {
				val name = reference.name
				if (reference.many) {
					val List<Object> values = cdoObject.eGet(reference, true) as List<Object>
					if (values.size > 0) {
						val jsonReferencesArray = new JsonArray
						for (v : values) {
							if (v instanceof CDOObject) {
								jsonReferencesArray.add((v as CDOObject).toJsonBase(serverUrl))
							} else if (v instanceof EObject) {
								jsonReferencesArray.add((v as EObject).toJsonBase(serverUrl))
							} else {
								jsonReferencesArray.add(new JsonPrimitive(v.toString))
							}		
						}
						jsonReferences.add(name, jsonReferencesArray)
					}
				} else {
					val v = cdoObject.eGet(reference, true)
					if (v != null) {
						if (v instanceof CDOObject) {
							jsonReferences.add(name, (v as CDOObject).toJsonBase(serverUrl))
						} else if (v instanceof EObject) {
							jsonReferences.add(name, (v as EObject).toJsonBase(serverUrl))
						} else {
							jsonReferences.add(name, new JsonPrimitive(v.toString))
						}						
					}
				}
			}
			if (jsonReferences.entrySet.size > 0) {
				jsonBaseObject.add("references", jsonReferences)
			}		
		}
	}
}
