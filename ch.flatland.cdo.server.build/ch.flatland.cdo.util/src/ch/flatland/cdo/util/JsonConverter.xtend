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

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import java.util.List
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.eresource.CDOResourceNode
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.eclipse.emf.internal.cdo.object.CDOLegacyAdapter

class JsonConverter {
	static val gson = new Gson
	static val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(
		new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))

	static val TYPE = "type"
	static val LABEL = "label"
	static val LOWER_BOUND = "lowerBound"
	static val UPPER_BOUND = "upperBound"
	static val ID = Json.PARAM_ID
	static val META = Json.PARAM_META
	static val HREF = "href"
	static val NAME = "name"
	static val CONTAINER = "hrefContainer"
	static val ATTRIBUTES = "attributes"
	static val REFERENCES = "references"
	static val CONTAINMENT = "containment"
	static val DERIVED = "derived"
	static val PERMISSION = "permission"

	static val ignoredAttributes = newArrayList("uRI", "resourceSet", "modified", "loaded", "trackingModification", "errors",
		"warnings", "timeStamp")

	var JsonConverterConfig jsonConverterConfig

	new(JsonConverterConfig jsonConverterConfig) {
		this.jsonConverterConfig = jsonConverterConfig
	}
	
	new() {
		this.jsonConverterConfig = new JsonConverterConfig
	}

	def dispatch String toJson(Object object) {
		gson.toJson(object)
	}


	def dispatch String toJson(EObject object) {
		val jsonBaseObject = object.toJsonBase

		jsonBaseObject.addAttributes(object)
		jsonBaseObject.addReferences(object)
		if (jsonConverterConfig.meta) {
			jsonBaseObject.addMeta(object)
		}	
		jsonBaseObject.toString
	}

	def dispatch String toJson(Throwable object) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addProperty(TYPE, "ch.flatland.Exception")
		jsonBaseObject.addProperty(LABEL, object.class.simpleName)
		if (object.message != null) {
			jsonBaseObject.addProperty("message", object.message)
		}
		jsonBaseObject.toString
	}

	def private toJsonBase(EObject object) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addType(object.eClass)
		// CDO Legacy Adapter implements EObject but is not an EObject
		// ITEM_DELEGATOR does a cast to EObject
		if (object instanceof CDOLegacyAdapter) {
			jsonBaseObject.addProperty(LABEL, object.toString)
		} else {
			jsonBaseObject.addProperty(LABEL, ITEM_DELEGATOR.getText(object))
		}
		jsonBaseObject.addProperty(ID, object.oid)
		jsonBaseObject.addProperty(HREF, object.url)
		if (object.eContainer != null) {
			jsonBaseObject.addProperty(CONTAINER, object.eContainer.url)
		} else {

			// it must be contained in a CDOResourceNode
			jsonBaseObject.addProperty(CONTAINER, (object.eResource as CDOResourceNode).url)
		}
		if (object instanceof CDOObject) {
			jsonBaseObject.addProperty(PERMISSION, (object as CDOObject).cdoPermission.name)		
		}
		return jsonBaseObject
	}

	def private addAttributes(JsonObject jsonBaseObject, EObject object) {
		val attributes = object.eClass.EAllAttributes
		val jsonAttributes = new JsonObject
		if (attributes.size > 0) {
			for (attribute : attributes.filter[!ignoredAttributes.contains(name)]) {
				val name = attribute.name

				if (attribute.many) {
					val values = object.eGet(attribute, true) as List<Object>
					if (values.size > 0) {
						val jsonPrimitiveArray = new JsonArray
						for (value : values) {
							jsonPrimitiveArray.add(value.jsonPrimitive)
						}
						jsonAttributes.add(name, jsonPrimitiveArray)
					}
				} else {
					val value = object.eGet(attribute, true)
					if (value != null) {
						jsonAttributes.add(name, value.jsonPrimitive)
					}
				}

			}
			if (jsonAttributes.entrySet.size > 0) {
				jsonBaseObject.add(ATTRIBUTES, jsonAttributes)
			}
		}
	}

	def private addReferences(JsonObject jsonBaseObject, EObject eObject) {
		val references = eObject.eClass.EAllReferences
		val jsonReferences = new JsonObject
		if (references.size > 0) {
			for (EReference reference : references) {
				val name = reference.name
				if (reference.many) {
					val List<Object> values = eObject.eGet(reference, true) as List<Object>
					if (values.size > 0) {
						val jsonReferencesArray = new JsonArray
						for (value : values) {
							val jsonRefObject = value.getJsonObject as JsonObject

							// should we add attributes or not?
							jsonRefObject.addAttributes(value as EObject)
							jsonReferencesArray.add(jsonRefObject)
						}
						jsonReferences.add(name, jsonReferencesArray)
					}
				} else {
					val value = eObject.eGet(reference, true)
					if (value != null) {
						val jsonRefObject = value.getJsonObject as JsonObject
						jsonRefObject.addAttributes(value as EObject)

						jsonReferences.add(name, value.getJsonObject)
					}
				}
			}
			if (jsonReferences.entrySet.size > 0) {
				jsonBaseObject.add(REFERENCES, jsonReferences)
			}
		}
	}
	
	def private addMeta(JsonObject jsonBaseObject, EObject object) {
		val attributes = object.eClass.EAllAttributes.filter[!ignoredAttributes.contains(it.name)]
		val references = object.eClass.EAllReferences

		val jsonTypeMeta = new JsonObject

		if (attributes.size > 0) {
			val jsonAttributes = new JsonArray
			jsonTypeMeta.add(ATTRIBUTES, jsonAttributes)
			for (attribute : attributes) {
				val jsonAttribute = new JsonObject
				jsonAttribute.addProperty(NAME, attribute.name)

				if (attribute.EAttributeType.eClass.name == "EEnum") {
					val enum = attribute.EAttributeType as EEnum
					val jsonLiterals = new JsonArray
					for (literal : enum.ELiterals) {
						jsonLiterals.add(new JsonPrimitive(literal.name))
						jsonAttribute.add(TYPE, jsonLiterals)
					}
				} else {
					jsonAttribute.addProperty(TYPE, attribute.EAttributeType.name)
				}
				jsonAttribute.addProperty(LOWER_BOUND, attribute.lowerBound)
				jsonAttribute.addProperty(UPPER_BOUND, attribute.upperBound)
				jsonAttribute.addProperty(DERIVED, attribute.derived)
				jsonAttributes.add(jsonAttribute)
			}
		}

		if (references.size > 0) {
			val jsonReferences = new JsonArray
			jsonTypeMeta.add(REFERENCES, jsonReferences)
			for (reference : references) {
				val jsonReference = new JsonObject
				jsonReference.addProperty(NAME, reference.name)
				jsonReference.addType(reference.EReferenceType)
				jsonReference.addProperty(LOWER_BOUND, reference.lowerBound)
				jsonReference.addProperty(UPPER_BOUND, reference.upperBound)
				jsonReference.addProperty(CONTAINMENT, reference.containment)
				jsonReference.addProperty(DERIVED, reference.derived)
				jsonReferences.add(jsonReference)
			}
		}
		jsonBaseObject.add(META, jsonTypeMeta)
	}

	def private addType(JsonObject jsonBaseObject, EClassifier classifier) {
		jsonBaseObject.addProperty(TYPE, classifier.EPackage.nsURI + "." + classifier.name)
	}

	def private dispatch getJsonPrimitive(Object object) {
		System.err.println("getJsonPrimitive(Object object) " + object.class.name + " returns " + object.toString)
		new JsonPrimitive(object.toString)
	}

	def private dispatch getJsonPrimitive(Number object) {
		new JsonPrimitive(object.toString)
	}

	def private dispatch getJsonPrimitive(URI object) {
		new JsonPrimitive(object.toString)
	}

	def private dispatch getJsonPrimitive(String object) {
		new JsonPrimitive(object)
	}

	def private dispatch getJsonPrimitive(Enumerator object) {
		new JsonPrimitive(object.name)
	}

	def private dispatch getJsonPrimitive(Boolean object) {
		new JsonPrimitive(object)
	}

	def private dispatch getJsonObject(Object object) {
		System.err.println(
			"getJsonObject(Object object, String serverUrl) " + object.class.name + " returns " + object.toString)
		new JsonPrimitive(object.toString)
	}

	def private dispatch getJsonObject(EObject object) {
		object.toJsonBase
	}

	def private dispatch getUrl(CDOResourceNode object) {
		jsonConverterConfig.servletUrl + object.path
	}

	def private dispatch getUrl(EObject object) {
		val uri = EcoreUtil.getURI(object)
		return jsonConverterConfig.serverUrl + uri.devicePath.replace("//", "/") + "?" + ID + "=" +
			uri.fragment.replace("L", "")
	}

	def private getOid(EObject object) {
		val uri = EcoreUtil.getURI(object)
		return Long.parseLong(uri.fragment.replace("L", ""))
	}
}
