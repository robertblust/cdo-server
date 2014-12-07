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
import java.util.ArrayList
import java.util.Date
import java.util.List
import java.util.Map
import org.apache.commons.codec.binary.Base64
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.security.NoPermissionException
import org.eclipse.emf.cdo.eresource.CDOResourceNode
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage.Literals
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.eclipse.emf.internal.cdo.object.CDOLegacyAdapter
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class JsonConverter {
	val logger = LoggerFactory.getLogger(this.class)

	val gson = new Gson
	val parser = new JsonParser
	val dateFormat = new SimpleDateFormat(DATE_FORMAT);
	val extension EMF = new EMF
	val extension View = new View
	val extension HttpStatus = new HttpStatus

	val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))

	static val ignoredAttributes = newArrayList("uRI", "resourceSet", "modified", "loaded", "trackingModification", "errors", "warnings", "timeStamp")

	var JsonConverterConfig jsonConverterConfig

	new(JsonConverterConfig jsonConverterConfig) {
		this.jsonConverterConfig = jsonConverterConfig
	}

	new() {
		this.jsonConverterConfig = new JsonConverterConfig
	}

	def getConfig() {
		jsonConverterConfig
	}

	def JsonObject safeFromJson(String jsonString) {
		try {
			parser.parse(jsonString).asJsonObject
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "Failed to parse json")
		}
	}

	def toEObject(JsonObject jsonObject, EObject eObject) {
		jsonObject.entrySet.filter[it.key != ID].forEach [
			val jsonName = it.key
			val jsonElement = it.value
			logger.debug("Found json element with name '{}'", jsonName)
			if(jsonName == ATTRIBUTES) {
				jsonElement.attributes = eObject
			}
			if(jsonName == REFERENCES) {
				jsonElement.references = eObject
			}
		]
		eObject
	}

	def okToJson() {
		newObjectWithStatusOK(newHashMap).toString
	}

	def dispatch String safeToJson(Object object) {
		try {
			gson.toJson(object)
		} catch(Exception e) {
			throw new FlatlandException(SC_INTERNAL_SERVER_ERROR, e.message)
		}
	}

	def dispatch String safeToJson(List<EObject> objects) {
		try {
			val jsonArray = new JsonArray
			val validationMessages = newHashMap

			for (object : objects) {
				val jsonBaseObject = object.toJsonBase

				jsonBaseObject.addAttributes(object)
				if(jsonConverterConfig.showReferences) {
					jsonBaseObject.addReferences(object, validationMessages)
				}
				jsonBaseObject.addMessagesAndMeta(object, validationMessages)
				jsonArray.add(jsonBaseObject)
			}

			// finally add ok status with messages
			val objectWithStatusOK = newObjectWithStatusOK(validationMessages)

			objectWithStatusOK.add(DATA, jsonArray)

			objectWithStatusOK.toString
		} catch(NoPermissionException npe) {
			throw new FlatlandException(SC_FORBIDDEN, npe.message)
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, e.message)
		}
	}

	def dispatch String safeToJson(EObject object) {
		try {
			val jsonBaseObject = object.toJsonBase
			val validationMessages = newHashMap
			jsonBaseObject.addAttributes(object)
			if(jsonConverterConfig.showReferences) {
				jsonBaseObject.addReferences(object, validationMessages)
			}

			jsonBaseObject.addMessagesAndMeta(object, validationMessages)

			// finally add ok status with messages
			val objectWithStatusOK = newObjectWithStatusOK(validationMessages)

			objectWithStatusOK.add(DATA, jsonBaseObject)

			objectWithStatusOK.toString
		} catch(NoPermissionException npe) {
			throw new FlatlandException(SC_FORBIDDEN, npe.message)
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, e.message)
		}
	}

	def dispatch String safeToJson(FlatlandException object) {
		val jsonStatusObject = new JsonObject
		jsonStatusObject.addProperty(STATUS, FlatlandException.STATUS_NOK)
		val messageArray = new JsonArray
		val message = new JsonObject
		message.addProperty(MESSAGE, object.message)
		message.addProperty(ORIGIN, object.class.simpleName)
		messageArray.add(message)

		val httpStatus = new JsonObject
		httpStatus.addProperty(MESSAGE, "Status code (" + object.httpStatus + ")")
		httpStatus.addProperty(ORIGIN, object.class.simpleName)
		messageArray.add(httpStatus)

		val description = new JsonObject
		description.addProperty(MESSAGE, object.httpStatus.description)
		description.addProperty(ORIGIN, object.class.simpleName)
		messageArray.add(description)

		jsonStatusObject.add(MESSAGES, messageArray)
		val jsonBaseObject = new JsonObject
		jsonBaseObject.add(STATUS, jsonStatusObject)
		jsonBaseObject.toString
	}

	def private toJsonBase(EObject object) {
		val jsonBaseObject = new JsonObject
		jsonBaseObject.addType(object.eClass)

		// CDO Legacy Adapter implements EObject but is not an EObject
		// ITEM_DELEGATOR does a cast to EObject
		if(object instanceof CDOLegacyAdapter) {
			jsonBaseObject.addProperty(LABEL, object.toString)
		} else {
			jsonBaseObject.addProperty(LABEL, ITEM_DELEGATOR.getText(object))
		}
		jsonBaseObject.addProperty(ID, object.oid)
		jsonBaseObject.addProperty(HREF, object.url)
		if(object.eContainer != null) {
			jsonBaseObject.addProperty(CONTAINER, object.eContainer.url)
		} else {

			// it must be contained in a CDOResourceNode
			jsonBaseObject.addProperty(CONTAINER, (object.eResource as CDOResourceNode).url)
		}
		if(object instanceof CDOObject) {
			jsonBaseObject.addProperty(PERMISSION, object.cdoPermission.name)
		}
		return jsonBaseObject
	}

	def private addAttributes(JsonObject jsonBaseObject, EObject object) {
		val attributes = object.eClass.EAllAttributes
		val jsonAttributes = new JsonObject
		if(attributes.size > 0) {
			for (attribute : attributes.filter[!ignoredAttributes.contains(name)]) {
				val name = attribute.name

				if(attribute.many) {
					val values = object.eGet(attribute, true) as List<Object>
					if(values.size > 0) {
						val jsonPrimitiveArray = new JsonArray
						for (value : values) {
							jsonPrimitiveArray.add(value.toJsonPrimitive)
						}
						jsonAttributes.add(name, jsonPrimitiveArray)
					}
				} else {
					val value = object.eGet(attribute, true)
					if(value != null) {
						jsonAttributes.add(name, value.toJsonPrimitive)
					}
				}
			}
			if(jsonAttributes.entrySet.size > 0) {
				jsonBaseObject.add(ATTRIBUTES, jsonAttributes)
			}
		}
	}

	def private addReferences(JsonObject jsonBaseObject, EObject eObject, Map<EObject, List<Diagnostic>> validationMessages) {
		val references = eObject.eClass.EAllReferences
		val jsonReferences = new JsonObject
		if(references.size > 0) {
			for (EReference reference : references) {
				val name = reference.name
				if(reference.many) {
					val List<Object> values = eObject.eGet(reference, true) as List<Object>
					if(values.size > 0) {
						val jsonReferencesArray = new JsonArray
						for (value : values) {
							val jsonRefObject = value.toJsonObject as JsonObject

							// should we add attributes or not?
							jsonRefObject.addAttributes(value as EObject)
							jsonRefObject.addMessagesAndMeta(value as EObject, validationMessages)
							jsonReferencesArray.add(jsonRefObject)
						}
						jsonReferences.add(name, jsonReferencesArray)
					}
				} else {
					val value = eObject.eGet(reference, true)
					if(value != null) {
						val jsonRefObject = value.toJsonObject as JsonObject
						jsonRefObject.addAttributes(value as EObject)
						jsonRefObject.addMessagesAndMeta(value as EObject, validationMessages)
						jsonReferences.add(name, jsonRefObject)
					}
				}
			}
			if(jsonReferences.entrySet.size > 0) {
				jsonBaseObject.add(REFERENCES, jsonReferences)
			}
		}
	}

	def private addMeta(JsonObject jsonBaseObject, EObject object) {
		val attributes = object.eClass.EAllAttributes.filter[!ignoredAttributes.contains(it.name)]
		val references = object.eClass.EAllReferences

		val jsonTypeMeta = new JsonObject

		if(attributes.size > 0) {
			val jsonAttributes = new JsonArray
			jsonTypeMeta.add(ATTRIBUTES, jsonAttributes)
			for (attribute : attributes) {
				val jsonAttribute = new JsonObject
				jsonAttribute.addProperty(NAME, attribute.name)

				if(attribute.EAttributeType instanceof EEnum) {
					val enum = attribute.EAttributeType as EEnum
					val jsonLiterals = new JsonArray
					for (literal : enum.ELiterals) {
						jsonLiterals.add(new JsonPrimitive(literal.name))
						jsonAttribute.add(ENUM_LITERALS, jsonLiterals)
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

		if(references.size > 0) {
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
		jsonBaseObject.add(PARAM_META, jsonTypeMeta)
	}

	def private addMessagesAndMeta(JsonObject jsonBaseObject, EObject object, Map<EObject, List<Diagnostic>> messages) {

		// validation requested?
		if(jsonConverterConfig.validate) {
			val diags = object.validate
			if(diags.size > 0) {
				messages.put(object, diags)
				val diagnosticArray = new JsonArray
				diags.forEach [
					val jsonDiag = new JsonObject
					jsonDiag.add(MESSAGE, new JsonPrimitive(it.message))
					val feature = it.data.get(1)
					if(feature instanceof EAttribute) {
						jsonDiag.add(FEATURE, new JsonPrimitive(ATTRIBUTES + "." + feature.name))
					}
					if(feature instanceof EReference) {
						jsonDiag.add(FEATURE, new JsonPrimitive(REFERENCES + "." + feature.name))
						jsonDiag.add(FEATURE, new JsonPrimitive(CONTAINMENT + "." + feature.isContainment))
					}
					if(feature instanceof EStructuralFeature) {
						jsonDiag.addProperty(DERIVED, feature.isDerived)
						jsonDiag.addProperty(LOWER_BOUND, feature.lowerBound)
						jsonDiag.addProperty(UPPER_BOUND, feature.upperBound)
					}
					diagnosticArray.add(jsonDiag)
				]
				jsonBaseObject.add(MESSAGES, diagnosticArray)
			}
		}

		// meta requested?
		if(jsonConverterConfig.meta) {
			jsonBaseObject.addMeta(object)
		}
	}

	def private addType(JsonObject jsonBaseObject, EClassifier classifier) {
		jsonBaseObject.addProperty(TYPE, classifier.type)
	}

	def private dispatch toJsonObject(Object object) {
		logger.error("NO DISPATCH MEHTOD for toJsonObject({}) ", object.class.name)
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonObject(EObject object) {
		object.toJsonBase
	}

	def private dispatch getUrl(CDOResourceNode object) {
		ALIAS_NODE + object.path
	}

	def private dispatch getUrl(EObject object) {
		val cdoObject = object as CDOObject
		ALIAS_OBJECT + "/" + cdoObject.eClass.EPackage.nsPrefix + "." + cdoObject.eClass.name + "/" + cdoObject.cdoID.toURIFragment.replace("L", "")

	}

	def private getOid(EObject object) {
		val uri = EcoreUtil.getURI(object)
		return Long.parseLong(uri.fragment.replace("L", ""))
	}

	def private setAttributes(JsonElement element, EObject eObject) {
		if(element.jsonObject) {

			// should always be the case if it is a valid json
			val jsonObject = element.asJsonObject
			jsonObject.entrySet.forEach [
				val jsonName = it.key
				val jsonElement = it.value
				logger.debug("Found attribute with name '{}'", jsonName)
				val eAttribute = eObject.eClass.EAllAttributes.filter[it.name == jsonName].head
				if(eAttribute != null) {
					logger.debug("Found matching eAttribute with name '{}'", jsonName)
					if(jsonElement.isAttributeSettable(eAttribute)) {
						logger.debug("Match - json attribute is settable to eAttribute for '{}'", jsonName)
						if(eAttribute.many) {
							val eArray = newArrayList
							if(jsonElement.jsonNull) {
								logger.debug("JsonElement '{}' is null", jsonName)
							} else {
								jsonElement.asJsonArray.forEach [
									val eType = it.asJsonPrimitive.safeToEType(eAttribute)
									if(eType != null) {
										eArray.add(eType)
									}
								]
							}
							eObject.eSet(eAttribute, eArray)
						} else {
							if(jsonElement.jsonNull) {
								logger.debug("JsonElement '{}' is null", jsonName)
								eObject.eUnset(eAttribute)
							} else {
								val eType = jsonElement.asJsonPrimitive.safeToEType(eAttribute)
								if(eType != null) {
									eObject.eSet(eAttribute, eType)
								}
							}
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

	def private setReferences(JsonElement element, EObject eObject) {
		if(element.jsonObject) {

			// should always be the case if it is a valid json
			val jsonObject = element.asJsonObject
			jsonObject.entrySet.forEach [
				val jsonName = it.key
				val jsonElement = it.value
				logger.debug("Found reference with name '{}'", jsonName)
				val eReference = eObject.eClass.EAllReferences.filter[it.name == jsonName].head
				if(eReference != null) {
					logger.debug("Found matching eReference with name '{}'", jsonName)
					if(jsonElement.isReferenceSettable(eReference)) {
						logger.debug("Match - json reference is settable to eReference for '{}'", jsonName)
						if(eReference.many) {
							val eArray = newArrayList
							if(jsonElement.jsonNull) {
								logger.debug("JsonElement '{}' is null", jsonName)
							} else {
								jsonElement.asJsonArray.forEach [
									val jsonRefObject = it.asJsonObject
									val id = jsonRefObject.safeResolveId
									if(id.value.jsonNull) {
										logger.debug("JsonElement '{}' is null", id.key)
									} else {
										logger.debug("Object '{}' requested", id)
										val referencedObject = eObject.view.safeRequestObject(id.value.safeAsLong)

										logger.debug("ReferencedObject '{}'", referencedObject)
										eArray.add(referencedObject)
									}
								]
							}
							eObject.safeSetReferenceArray(eReference, eArray)
						} else {
							if(jsonElement.jsonNull) {
								logger.debug("JsonElement '{}' is null", jsonName)
								eObject.eUnset(eReference)
							} else {
								val jsonRefObject = jsonElement.asJsonObject
								val id = jsonRefObject.safeResolveId

								if(id.value.jsonNull) {
									logger.debug("JsonElement '{}' is null", id.key)
									eObject.eUnset(eReference)
								} else {
									logger.debug("Object '{}' requested", id)
									val referencedObject = eObject.view.safeRequestObject(id.value.safeAsLong)

									logger.debug("ReferencedObject '{}'", referencedObject)
									eObject.safeSetReference(eReference, referencedObject)
								}
							}
						}
					} else {
						logger.debug("MISSmatch - json reference is NOT settable to eReference for '{}'", jsonName)
					}
				} else {
					logger.debug("NOT found matching eReference with name '{}'", jsonName)
				}
			]
		}
	}

	def private safeToEType(JsonPrimitive jsonPrimitive, EAttribute eAttribute) {
		logger.debug("eAttribute '{}' has data type '{}', try to set json value '{}'", eAttribute.name, eAttribute.EAttributeType.name, jsonPrimitive)
		try {
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

			if(eAttribute.EAttributeType instanceof EEnum) {
				logger.debug("'{}' is an EEnum", eAttribute.EAttributeType.name)
				val enum = eAttribute.EAttributeType as EEnum
				val literal = enum.getEEnumLiteral(jsonPrimitive.asString)
				if(literal != null) {
					return literal.instance
				}
				return null
			}
			if(eAttribute.EAttributeType.name == "Base64Binary" && eAttribute.EAttributeType.instanceTypeName == "byte[]") {
				logger.debug("'{}' is a Base64Binary", eAttribute.name)
				if(Base64.isBase64(jsonPrimitive.asString)) {
					return Base64.decodeBase64(jsonPrimitive.asString)
				} else {
					throw new Exception
				}
			}
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "Json primitive '{}' could not be converted to '{}' for attribute '{}", jsonPrimitive.asString, eAttribute.EAttributeType.name, eAttribute.name)
		}

		logger.error("NO CONVERSION WAS POSSIBLE of eAttribute '{}' to data type {}", eAttribute.name, eAttribute.EAttributeType.name)
		return null
	}

	def private dispatch toJsonPrimitive(Object object) {
		logger.error("NO DISPATCH MEHTOD for getJsonPrimitive({}) ", object.class.name)
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonPrimitive(byte[] bytes) {
		new JsonPrimitive(Base64.encodeBase64String(bytes))
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

	def getView(EObject eObject) {
		(eObject as CDOObject).cdoView
	}

	def newObjectWithStatusOK(Map<EObject, List<Diagnostic>> messages) {

		val objectWithStatusOK = new JsonObject
		objectWithStatusOK.addProperty(STATUS, "OK")

		val jsonBaseObject = new JsonObject
		jsonBaseObject.add(STATUS, objectWithStatusOK)

		if(messages.size > 0) {
			val messageArray = new JsonArray
			messages.forEach [ source, diag |
				diag.forEach [
					val message = new JsonObject
					message.addProperty(MESSAGE, it.message)
					message.addProperty(ORIGIN, source.url)
					messageArray.add(message)
				]
			]
			objectWithStatusOK.add(MESSAGES, messageArray)
		}
		return jsonBaseObject
	}

	// methods which could throw an Exception
	def safeResolveId(JsonObject jsonObject) {
		val id = jsonObject.entrySet.filter[it.key == ID].head
		if(id == null || id.value.isJsonNull) {
			throw new FlatlandException(SC_BAD_REQUEST, "Attribute '{}' missing or null", ID)
		}
		return id
	}

	def safeResolvePut(JsonObject jsonObject) {
		val put = jsonObject.entrySet.filter[it.key == PUT].head
		if(put == null || put.value.isJsonNull) {
			throw new FlatlandException(SC_BAD_REQUEST, "Attribute '{}' missing or null", PUT)
		}
		return put
	}

	def safeResolveType(JsonObject jsonObject) {
		val type = jsonObject.entrySet.filter[it.key == TYPE].head
		if(type == null || type.value.isJsonNull) {
			throw new FlatlandException(SC_BAD_REQUEST, "Attribute '{}' missing or null", TYPE)
		}
		return type
	}

	def safeAsLong(JsonElement element) {
		try {
			return element.asLong
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "Attribute '{}={}' must be a long", ID, element.asString)
		}

	}

	def safeSetReference(EObject container, EReference eReference, EObject refObject) {
		try {
			container.eSet(eReference, refObject)
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "Object '{}' has wrong type for reference '{}'", refObject, eReference.name)
		}

	}

	def safeSetReferenceArray(EObject container, EReference eReference, ArrayList<EObject> refArray) {
		try {
			container.eSet(eReference, refArray)
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "Reference list contains object with wrong type for reference '{}'", eReference.name)
		}
	}
}
