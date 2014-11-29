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
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonPrimitive
import java.text.SimpleDateFormat
import java.util.Date
import java.util.List
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.eresource.CDOResourceNode
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage.Literals
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.eclipse.emf.internal.cdo.object.CDOLegacyAdapter
import org.slf4j.LoggerFactory

class JsonConverter {
	val logger = LoggerFactory.getLogger(this.class)

	val gson = new Gson
	val parser = new JsonParser
	val dateFormat = new SimpleDateFormat(JsonConverterConfig.DATE_FORMAT);
	val extension EMF = new EMF

	val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(
		new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))

	static val ignoredAttributes = newArrayList("uRI", "resourceSet", "modified", "loaded", "trackingModification",
		"errors", "warnings", "timeStamp")

	var JsonConverterConfig jsonConverterConfig

	new(JsonConverterConfig jsonConverterConfig) {
		this.jsonConverterConfig = jsonConverterConfig
	}

	new() {
		this.jsonConverterConfig = new JsonConverterConfig
	}

	def JsonObject fromJson(String jsonString) {
		try {
			parser.parse(jsonString).asJsonObject
		} catch (Exception e) {
			throw new FlatlandException("Failed to parse json!")
		}
	}

	def toEObject(JsonObject jsonObject, EObject eObject) {
		jsonObject.entrySet.filter[it.key != Json.PARAM_ID].forEach [
			val jsonName = it.key
			val jsonElement = it.value
			logger.debug("Found json element with name '{}'", jsonName)
			if (jsonName == JsonConverterConfig.ATTRIBUTES) {
				jsonElement.attributes = eObject
			}
		]
		eObject
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
		jsonBaseObject.addProperty(JsonConverterConfig.TYPE, "ch.flatland.Exception")
		jsonBaseObject.addProperty(JsonConverterConfig.LABEL, object.class.simpleName)
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
			jsonBaseObject.addProperty(JsonConverterConfig.LABEL, object.toString)
		} else {
			jsonBaseObject.addProperty(JsonConverterConfig.LABEL, ITEM_DELEGATOR.getText(object))
		}
		jsonBaseObject.addProperty(JsonConverterConfig.ID, object.oid)
		jsonBaseObject.addProperty(JsonConverterConfig.HREF, object.url)
		if (object.eContainer != null) {
			jsonBaseObject.addProperty(JsonConverterConfig.CONTAINER, object.eContainer.url)
		} else {

			// it must be contained in a CDOResourceNode
			jsonBaseObject.addProperty(JsonConverterConfig.CONTAINER, (object.eResource as CDOResourceNode).url)
		}
		if (object instanceof CDOObject) {
			jsonBaseObject.addProperty(JsonConverterConfig.PERMISSION, (object as CDOObject).cdoPermission.name)
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
							jsonPrimitiveArray.add(value.toJsonPrimitive)
						}
						jsonAttributes.add(name, jsonPrimitiveArray)
					}
				} else {
					val value = object.eGet(attribute, true)
					if (value != null) {
						jsonAttributes.add(name, value.toJsonPrimitive)
					}
				}

			}
			if (jsonAttributes.entrySet.size > 0) {
				jsonBaseObject.add(JsonConverterConfig.ATTRIBUTES, jsonAttributes)
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
							val jsonRefObject = value.toJsonObject as JsonObject

							// should we add attributes or not?
							jsonRefObject.addAttributes(value as EObject)
							jsonReferencesArray.add(jsonRefObject)
						}
						jsonReferences.add(name, jsonReferencesArray)
					}
				} else {
					val value = eObject.eGet(reference, true)
					if (value != null) {
						val jsonRefObject = value.toJsonObject as JsonObject
						jsonRefObject.addAttributes(value as EObject)

						jsonReferences.add(name, value.toJsonObject)
					}
				}
			}
			if (jsonReferences.entrySet.size > 0) {
				jsonBaseObject.add(JsonConverterConfig.REFERENCES, jsonReferences)
			}
		}
	}

	def private addMeta(JsonObject jsonBaseObject, EObject object) {
		val attributes = object.eClass.EAllAttributes.filter[!ignoredAttributes.contains(it.name)]
		val references = object.eClass.EAllReferences

		val jsonTypeMeta = new JsonObject

		if (attributes.size > 0) {
			val jsonAttributes = new JsonArray
			jsonTypeMeta.add(JsonConverterConfig.ATTRIBUTES, jsonAttributes)
			for (attribute : attributes) {
				val jsonAttribute = new JsonObject
				jsonAttribute.addProperty(JsonConverterConfig.NAME, attribute.name)

				if (attribute.EAttributeType instanceof EEnum) {
					val enum = attribute.EAttributeType as EEnum
					val jsonLiterals = new JsonArray
					for (literal : enum.ELiterals) {
						jsonLiterals.add(new JsonPrimitive(literal.name))
						jsonAttribute.add(JsonConverterConfig.ENUM_LITERALS, jsonLiterals)
					}
				} else {
					jsonAttribute.addProperty(JsonConverterConfig.TYPE, attribute.EAttributeType.name)
				}
				jsonAttribute.addProperty(JsonConverterConfig.LOWER_BOUND, attribute.lowerBound)
				jsonAttribute.addProperty(JsonConverterConfig.UPPER_BOUND, attribute.upperBound)
				jsonAttribute.addProperty(JsonConverterConfig.DERIVED, attribute.derived)
				jsonAttributes.add(jsonAttribute)
			}
		}

		if (references.size > 0) {
			val jsonReferences = new JsonArray
			jsonTypeMeta.add(JsonConverterConfig.REFERENCES, jsonReferences)
			for (reference : references) {
				val jsonReference = new JsonObject
				jsonReference.addProperty(JsonConverterConfig.NAME, reference.name)
				jsonReference.addType(reference.EReferenceType)
				jsonReference.addProperty(JsonConverterConfig.LOWER_BOUND, reference.lowerBound)
				jsonReference.addProperty(JsonConverterConfig.UPPER_BOUND, reference.upperBound)
				jsonReference.addProperty(JsonConverterConfig.CONTAINMENT, reference.containment)
				jsonReference.addProperty(JsonConverterConfig.DERIVED, reference.derived)
				jsonReferences.add(jsonReference)
			}
		}
		jsonBaseObject.add(JsonConverterConfig.META, jsonTypeMeta)
	}

	def private addType(JsonObject jsonBaseObject, EClassifier classifier) {
		jsonBaseObject.addProperty(JsonConverterConfig.TYPE, classifier.type)
	}

	def private dispatch toJsonObject(Object object) {
		logger.error("NO DISPATCH MEHTOD for toJsonObject({}) ", object.class.name)
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonObject(EObject object) {
		object.toJsonBase
	}

	def private dispatch getUrl(CDOResourceNode object) {
		jsonConverterConfig.servletUrl + object.path
	}

	def private dispatch getUrl(EObject object) {
		val uri = EcoreUtil.getURI(object)
		return jsonConverterConfig.serverUrl + uri.devicePath.replace("//", "/") + "?" + JsonConverterConfig.ID + "=" +
			uri.fragment.replace("L", "")
	}

	def private getOid(EObject object) {
		val uri = EcoreUtil.getURI(object)
		return Long.parseLong(uri.fragment.replace("L", ""))
	}

	def private setAttributes(JsonElement element, EObject eObject) {
		if (element.jsonObject) {

			// should always be the case if it is a valid json
			val jsonObject = element.asJsonObject
			jsonObject.entrySet.forEach [
				val jsonName = it.key
				val jsonElement = it.value
				logger.debug("Found attribute with name '{}'", jsonName)
				val eAttribute = eObject.eClass.EAllAttributes.filter[it.name == jsonName].head
				if (eAttribute != null) {

					logger.debug("Found matching eAttribute with name '{}'", jsonName)

					if (jsonElement.isSettable(eAttribute)) {

						logger.debug("Match - json attribute is settable to eAttribute for '{}'", jsonName)
						val eType = (jsonElement as JsonPrimitive).toEType(eAttribute)
						if (eType != null) {
							eObject.eSet(eAttribute, eType)
						}
					} else {

						logger.debug("MISSmatch - json attribute is NOT settable to eAttribute for '{}'", jsonName)
					}

				} else {
					logger.debug("NOT found matching eAttribute with name '{}'", jsonName)
				}
			]
		}
	}

	def private toEType(JsonPrimitive jsonPrimitive, EAttribute eAttribute) {
		logger.debug("eAttribute '{}' has data type '{}'", eAttribute.name, eAttribute.EAttributeType.name)

		switch eAttribute.EAttributeType {
			case Literals.ESTRING: return jsonPrimitive.asString
			case Literals.EBOOLEAN: return jsonPrimitive.asBoolean
			case Literals.EINT: return jsonPrimitive.asInt
			case Literals.ELONG: return jsonPrimitive.asLong
			case Literals.ESHORT: return jsonPrimitive.asShort
			case Literals.EDOUBLE: return jsonPrimitive.asDouble
			case Literals.EFLOAT: return jsonPrimitive.asFloat
			case Literals.EBYTE: return jsonPrimitive.asByte
			case Literals.ECHAR: return jsonPrimitive.asCharacter
			case Literals.EDATE: return dateFormat.parse(jsonPrimitive.asString)
			case Literals.EBIG_DECIMAL: return jsonPrimitive.asBigDecimal
			case Literals.EBIG_INTEGER: return jsonPrimitive.asBigInteger
		}
		
		if (eAttribute.EAttributeType instanceof EEnum) {
			logger.debug("'{}' is an EEnum", eAttribute.EAttributeType.name)
			val enum = eAttribute.EAttributeType as EEnum
			val literal = enum.getEEnumLiteral(jsonPrimitive.asString)
			if (literal != null) {
				return literal.instance	
			}
			return null
		}

		logger.error("NO CONVERSION WAS POSSIBLE of eAttribute '{}' to data type {}", eAttribute.name,
			eAttribute.EAttributeType.name)
		return null
	}

	def private dispatch toJsonPrimitive(Object object) {
		logger.error("NO DISPATCH MEHTOD for getJsonPrimitive({}) ", object.class.name)
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonPrimitive(Number object) {
		new JsonPrimitive(object)
	}

	def private dispatch toJsonPrimitive(Character object) {
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonPrimitive(Date object) {
		new JsonPrimitive(dateFormat.format(object))
	}

	def private dispatch toJsonPrimitive(URI object) {
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonPrimitive(String object) {
		new JsonPrimitive(object)
	}

	def private dispatch toJsonPrimitive(Enumerator object) {
		new JsonPrimitive(object.name)
	}

	def private dispatch toJsonPrimitive(Boolean object) {
		new JsonPrimitive(object)
	}
}
