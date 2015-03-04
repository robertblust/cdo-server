/*
 * Copyright (c) 2014 Robert Blust (Zurich, Switzerland) and others.
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
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Date
import java.util.LinkedHashMap
import java.util.List
import java.util.Map
import org.apache.commons.codec.binary.Base64
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.revision.delta.CDOAddFeatureDelta
import org.eclipse.emf.cdo.common.revision.delta.CDOContainerFeatureDelta
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta
import org.eclipse.emf.cdo.common.revision.delta.CDOMoveFeatureDelta
import org.eclipse.emf.cdo.common.revision.delta.CDORemoveFeatureDelta
import org.eclipse.emf.cdo.common.revision.delta.CDOSetFeatureDelta
import org.eclipse.emf.cdo.common.security.NoPermissionException
import org.eclipse.emf.cdo.eresource.CDOResourceNode
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
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

	val extension EMF = new EMF
	val extension DateConverter = new DateConverter
	val extension HttpStatus = new HttpStatus
	val extension References = new References
	val extension XReferences = new XReferences

	val diagnostics = new LinkedHashMap<EObject, List<Diagnostic>>
	val revisionDeltas = new LinkedHashMap<EObject, List<CDOFeatureDelta>>

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

	def getDiagnostics() {
		diagnostics
	}

	def isValid() {
		diagnostics.size == 0
	}

	def getRevisionDeltas() {
		revisionDeltas
	}

	def JsonElement safeFromJson(String jsonString) {
		try {
			val jsonElement = parser.parse(jsonString)
			switch jsonElement.class {
				case typeof(JsonObject): return jsonElement.asJsonObject
				case typeof(JsonArray): return jsonElement.asJsonArray
				default: throw new FlatlandException(SC_BAD_REQUEST, "Failed to parse json")
			}
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
		]
		eObject
	}

	def okToJson() {
		newObjectWithStatus().toString
	}

	def dispatch String safeToJson(Object object) {
		try {
			gson.toJson(new MessageResponse(object))
		} catch(Exception e) {
			throw new FlatlandException(SC_INTERNAL_SERVER_ERROR, e.message)
		}
	}
	
	def dispatch String safeToJson(Object[] object) {
		try {
			gson.toJson(new MessageResponse(object))
		} catch(Exception e) {
			throw new FlatlandException(SC_INTERNAL_SERVER_ERROR, e.message)
		}
	}

	def dispatch String safeToJson(List<EObject> objects) {
		try {
			val jsonArray = new JsonArray

			for (object : objects) {
				if(object.hasPermission) {
					val jsonBaseObject = object.toJsonBase(false)
					jsonArray.add(jsonBaseObject)
				}
			}

			// finally add status with messages
			val objectWithStatus = newObjectWithStatus

			objectWithStatus.add(DATA, jsonArray)

			objectWithStatus.toString
		} catch(NoPermissionException npe) {
			throw new FlatlandException(SC_FORBIDDEN, npe.message)
		} catch(Exception e) {
			throw new FlatlandException(SC_INTERNAL_SERVER_ERROR, e.message)
		}
	}

	def dispatch String safeToJson(EObject object) {
		try {
			val jsonBaseObject = object.toJsonBase(false)

			// finally add status with messages
			val objectWithStatus = newObjectWithStatus

			objectWithStatus.add(DATA, jsonBaseObject)

			objectWithStatus.toString
		} catch(NoPermissionException npe) {
			throw new FlatlandException(SC_FORBIDDEN, npe.message)
		} catch(Exception e) {
			throw new FlatlandException(SC_INTERNAL_SERVER_ERROR, e.message)
		}
	}

	def dispatch String safeToJson(FlatlandException object) {
		val jsonStatusObject = new JsonObject
		jsonStatusObject.addProperty(STATUS, FlatlandException.STATUS.name)
		val error = new JsonObject
		jsonStatusObject.add(ERROR, error)

		if(object.origin == null) {
			error.addProperty(ORIGIN, object.class.simpleName)
		} else {
			error.addProperty(ORIGIN, object.origin.url)
		}
		error.addProperty(MESSAGE, object.message)
		error.addProperty(HTTP_STATUS, object.httpStatus)
		error.addProperty(HTTP_STATUS_DESCRIPTION, object.httpStatus.description)

		jsonStatusObject.toString
	}

	def private JsonObject toJsonBase(EObject object, boolean stop) {
		val jsonBaseObject = new JsonObject

		if(object.oid != null) {
			jsonBaseObject.addProperty(ID, object.oid)

			if(object.eContainer != null) {
				jsonBaseObject.addProperty(CONTAINER_ID, object.eContainer.oid)
			} else if(object.eResource instanceof CDOResourceNode) {

				// it must be contained in a CDOResourceNode
				jsonBaseObject.addProperty(CONTAINER_ID, (object.eResource as CDOResourceNode).oid)
			}
		}

		// CDO Legacy Adapter implements EObject but is not an EObject
		// ITEM_DELEGATOR does a cast to EObject
		if(object instanceof CDOLegacyAdapter) {
			jsonBaseObject.addProperty(LABEL, object.toString)
		} else {
			jsonBaseObject.addProperty(LABEL, ITEM_DELEGATOR.getText(object))
		}

		jsonBaseObject.addType(object.eClass, stop)
		jsonBaseObject.addProperty(ICON, jsonConverterConfig.serverAddress + ALIAS_ICON + "/" + object.eClass.type)

		if(object instanceof CDOObject) {
			jsonBaseObject.addProperty(PERMISSION, object.cdoPermission.name)
			jsonBaseObject.addProperty(REVISION, object.cdoRevision.version)
			jsonBaseObject.addProperty(DATE, (new Date(object.cdoRevision.timeStamp).formatDate))
			jsonBaseObject.addProperty(AUTHOR, object.view.session.commitInfoManager.getCommitInfo(object.cdoRevision.timeStamp).userID)
		}

		jsonBaseObject.addAttributes(object)
		if(jsonConverterConfig.references && !stop) {
			jsonBaseObject.addReferences(object)
		}

		if(jsonConverterConfig.xreferences && !stop) {
			val xrefs = object.allXReferences
			if(xrefs.size > 0) {
				val jsonXrefsArray = new JsonArray
				jsonBaseObject.add(XREFERENCES, jsonXrefsArray)
				xrefs.forEach [
					jsonXrefsArray.add(it.toJsonBase(true))
				]
			}
		}

		if(object.oid != null) {

			// no meta model, a real object
			val jsonLinksObject = new JsonObject
			jsonBaseObject.add(LINKS, jsonLinksObject)

			val jsonSelfLink = new JsonObject
			jsonSelfLink.addProperty(HREF, object.url)
			jsonLinksObject.add(SELF, jsonSelfLink)
			
			if(jsonConverterConfig.links) {
				if(object.eClass.EAllReferences.size > 0) {

					// add reference link
					val jsonReferencesLink = new JsonObject
					jsonReferencesLink.addProperty(HREF, object.getUrl(false) + "/" + REFERENCES + object.getTimestampParam(true))
					jsonReferencesLink.addProperty(SIZE, object.referencesSize(null, jsonConverterConfig.xtraces))
					jsonLinksObject.add(REFERENCES, jsonReferencesLink)

					// add detailed reference link
					object.eClass.EAllReferences.forEach [
						if(object.referencesSize(it.name, jsonConverterConfig.xtraces) > 0) {
							val jsonReferenceLink = new JsonObject
							jsonReferenceLink.addProperty(HREF, object.getUrl(false) + "/" + REFERENCES + "/" + it.name + object.getTimestampParam(true))
							jsonReferenceLink.addProperty(SIZE, object.referencesSize(it.name, jsonConverterConfig.xtraces))
							jsonReferenceLink.addProperty(CONTAINMENT, it.containment)
							jsonReferencesLink.add(it.name, jsonReferenceLink)
						}
					]
				}

				if(object.eContents.size > 0) {
					val jsonContentsLink = new JsonObject
					jsonContentsLink.addProperty(HREF, object.getUrl(false) + "/" + CONTENTS + object.getTimestampParam(true))
					jsonContentsLink.addProperty(SIZE, object.eContents.size)
					jsonLinksObject.add(CONTENTS, jsonContentsLink)

					val jsonAllContentsLink = new JsonObject
					jsonAllContentsLink.addProperty(HREF, object.getUrl(false) + "/" + ALL_CONTENTS + object.getTimestampParam(true))
					jsonLinksObject.add(ALL_CONTENTS, jsonAllContentsLink)
				}

				val jsonContainerLink = new JsonObject
				if(object.eContainer != null) {
					jsonContainerLink.addProperty(HREF, object.eContainer.url)
				} else if(object.eResource instanceof CDOResourceNode) {

					// it must be contained in a CDOResourceNode			
					jsonContainerLink.addProperty(HREF, (object.eResource as CDOResourceNode).url)
				}
				jsonLinksObject.add(CONTAINER, jsonContainerLink)

				val jsonAllInstancesLink = new JsonObject
				jsonAllInstancesLink.addProperty(HREF, jsonConverterConfig.serverAddress + ALIAS_OBJECT + "/" + object.eClass.type + object.getTimestampParam(true))
				jsonLinksObject.add(ALL_INSTANCES, jsonAllInstancesLink)

			}
		}
		if(jsonConverterConfig.xlinks) {

			// xrefs
			if(object.hasXReferences) {
				val jsonXLinksObject = new JsonObject
				jsonBaseObject.add(XLINKS, jsonXLinksObject)

				// add x reference link
				val jsonXReferencesLink = new JsonObject
				jsonXReferencesLink.addProperty(HREF, jsonConverterConfig.serverAddress + ALIAS_XREFS + "/" + object.oid + "/" + REFERENCES + object.getTimestampParam(true))
				jsonXReferencesLink.addProperty(SIZE, object.allXReferences.size)
				jsonXLinksObject.add(REFERENCES, jsonXReferencesLink)

				// add detailed x reference link
				object.resolveGroupXReferences.forEach [ p1, p2 |
					val jsonXReferenceLink = new JsonObject
					jsonXReferenceLink.addProperty(HREF, jsonConverterConfig.serverAddress + ALIAS_XREFS + "/" + object.oid + "/" + REFERENCES + "/" + p1.name + object.getTimestampParam(true))
					jsonXReferenceLink.addProperty(SIZE, p2.size)
					jsonXReferencesLink.add(p1.name, jsonXReferenceLink)
				]
			}

		}

		if(object instanceof CDOObject) {
			if(jsonConverterConfig.history) {
				jsonBaseObject.addRevisions(object)
			}
		}
		if (!stop) {
			jsonBaseObject.addDiagnosticsAndMeta(object)
		}
		
		return jsonBaseObject
	}

	def private addRevisions(JsonObject jsonBaseObject, CDOObject object) {

		object.cdoHistory.triggerLoad
		while(object.cdoHistory.loading) {
			//TODO could be long running!
		}
		val historySize = object.cdoHistory.size
		if(historySize > 1) {
			val jsonRevisionsArray = new JsonArray
			jsonBaseObject.add(HISTORY, jsonRevisionsArray)
			for (var i = historySize - 1; i > 0; i--) {
				val commitInfo = object.cdoHistory.getElement(i)
				val jsonRevsionObject = new JsonObject
				jsonRevsionObject.addProperty(REVISION, (historySize - i))
				jsonRevsionObject.addProperty(SELF, object.getUrl(false) + "?" + PARAM_POINT_IN_TIME + "=" + commitInfo.timeStamp)
				jsonRevsionObject.addProperty(DATE, formatDate(new Date(commitInfo.timeStamp)))
				jsonRevsionObject.addProperty(AUTHOR, commitInfo.userID)
				logger.debug("'{}' resolved revsion '{}'", object, (historySize - i))
				jsonRevisionsArray.add(jsonRevsionObject)
			}
		}

	}

	def private addAttributes(JsonObject jsonBaseObject, EObject object) {
		val attributes = object.eClass.EAllAttributes

		if(attributes.size > 0) {
			val jsonAttributes = new JsonObject
			val jsonAttributesArrayAccessor = new JsonArray
			for (attribute : attributes.filter[!ignoredAttributes.contains(name)]) {
				val jsonAttributesArrayEntry = new JsonObject;
				val name = attribute.name
				if(attribute.many) {
					val values = object.eGet(attribute, true) as List<Object>
					if(values.size > 0) {
						val jsonPrimitiveArray = new JsonArray
						for (value : values) {
							jsonPrimitiveArray.add(value.toJsonPrimitive)
						}
						jsonAttributes.add(name, jsonPrimitiveArray)
						jsonAttributesArrayEntry.add(NAME, new JsonPrimitive(name))
						jsonAttributesArrayEntry.add(VALUE, jsonPrimitiveArray)
						jsonAttributesArrayAccessor.add(jsonAttributesArrayEntry)
					}
				} else {
					val value = object.eGet(attribute, true)
					if(value != null) {
						jsonAttributes.add(name, value.toJsonPrimitive)
						jsonAttributesArrayEntry.add(NAME, new JsonPrimitive(name))
						jsonAttributesArrayEntry.add(VALUE, value.toJsonPrimitive)
						jsonAttributesArrayAccessor.add(jsonAttributesArrayEntry)
					}
				}
			}
			if(jsonAttributes.entrySet.size > 0) {
				jsonBaseObject.add(ATTRIBUTES, jsonAttributes)
				if(jsonConverterConfig.arrayAccessor) {
					jsonBaseObject.add(ATTRIBUTES_ARRAY, jsonAttributesArrayAccessor)
				}
			}
		}
	}

	def private addReferences(JsonObject jsonBaseObject, EObject eObject) {
		val references = eObject.eClass.EAllReferences
		val jsonReferences = new JsonObject
		val jsonReferencesArrayAccessor = new JsonArray
		if(references.size > 0) {
			for (EReference reference : references) {
				val jsonReferencesArrayEntry = new JsonObject;

				// show containments or relations or both?
				if((reference.containment && jsonConverterConfig.creferences) || (!reference.containment && jsonConverterConfig.rreferences)) {
					val name = reference.name
					if(reference.many) {
						val List<Object> values = eObject.eGet(reference, true) as List<Object>
						if(values.size > 0) {
							val jsonReferencesArray = new JsonArray
							for (value : values) {
								val valueAsEobject = value as EObject
								if(valueAsEobject.hasPermission) {
									val jsonRefObject = valueAsEobject.toJsonObject(true) as JsonObject
									jsonReferencesArray.add(jsonRefObject)
								}
							}
							jsonReferences.add(name, jsonReferencesArray)
							jsonReferencesArrayEntry.add(NAME, new JsonPrimitive(name))
							jsonReferencesArrayEntry.add(VALUE, jsonReferencesArray)
							jsonReferencesArrayAccessor.add(jsonReferencesArrayEntry)
						}
					} else {
						val value = eObject.eGet(reference, true)
						if(value != null) {
							val valueAsEobject = value as EObject
							if(valueAsEobject.hasPermission) {
								val jsonRefObject = valueAsEobject.toJsonObject(true) as JsonObject
								jsonReferences.add(name, jsonRefObject)
								jsonReferencesArrayEntry.add(NAME, new JsonPrimitive(name))
								jsonReferencesArrayEntry.add(VALUE, jsonRefObject)
								jsonReferencesArrayAccessor.add(jsonReferencesArrayEntry)
							}
						}
					}
				}
			}
			if(jsonReferences.entrySet.size > 0) {
				jsonBaseObject.add(REFERENCES, jsonReferences)
				if(jsonConverterConfig.arrayAccessor) {
					jsonBaseObject.add(REFERENCES_ARRAY, jsonReferencesArrayAccessor)
				}
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
				if(object instanceof CDOResourceNode && attribute.name == "name") {
					jsonAttribute.addFeatureMeta(attribute, true)
				} else {
					jsonAttribute.addFeatureMeta(attribute, false)
				}
				jsonAttributes.add(jsonAttribute)
			}
		}

		if(references.size > 0) {
			val jsonReferences = new JsonArray
			jsonTypeMeta.add(REFERENCES, jsonReferences)
			for (reference : references) {
				val jsonReference = new JsonObject
				jsonReference.addFeatureMeta(reference, false)
				jsonReferences.add(jsonReference)
			}
		}
		jsonBaseObject.add(PARAM_META, jsonTypeMeta)
	}

	def private addFeatureMeta(JsonObject jsonBaseObject, EStructuralFeature feature, boolean overuleRequired) {

		if(feature instanceof EAttribute) {
			jsonBaseObject.add(FEATURE, new JsonPrimitive(feature.name))
			jsonBaseObject.addType(feature.EAttributeType, false)
			jsonBaseObject.addJsType(feature.EAttributeType)

			if(feature.EAttributeType instanceof EEnum) {
				val enum = feature.EAttributeType as EEnum
				val jsonLiterals = new JsonArray
				for (literal : enum.ELiterals) {
					jsonLiterals.add(new JsonPrimitive(literal.name))
					jsonBaseObject.add(ENUM_LITERALS, jsonLiterals)
				}
			}
			jsonBaseObject.addDefaultPattern(feature.EAttributeType)

			jsonBaseObject.addProperty(INSTANCE_CLASS_NAME, feature.EAttributeType.instanceClassName)
			feature.EAttributeType.EAnnotations.forEach [
				it.details.filter[it.key.toString != "name" && it.key.toString != "baseType"].forEach [
					try {
						jsonBaseObject.addProperty(it.key, Integer.parseInt(it.value))
					} catch(Exception e) {
						jsonBaseObject.addProperty(it.key, it.value)
						logger.debug("Not an int '{}'", it.value)
					}
				]
			]
		}
		if(feature instanceof EReference) {
			jsonBaseObject.add(FEATURE, new JsonPrimitive(feature.name))
			jsonBaseObject.addType(feature.EReferenceType, false)
			jsonBaseObject.addProperty(ABSTRACT, feature.EReferenceType.abstract)
			if(feature.EReferenceType.name == "EObject") {

				// overrule, must not be instantiated
				jsonBaseObject.addProperty(ABSTRACT, true)
			}
			jsonBaseObject.addProperty(CONTAINMENT, feature.containment)
		}
		jsonBaseObject.addProperty(DERIVED, feature.isDerived)
		jsonBaseObject.addProperty(MANY, feature.isMany)
		jsonBaseObject.addProperty(REQUIRED, feature.required)
		if(overuleRequired) {
			jsonBaseObject.addProperty(REQUIRED, true)
		}
		jsonBaseObject.addProperty(LOWER_BOUND, feature.lowerBound)
		if(overuleRequired) {
			jsonBaseObject.addProperty(LOWER_BOUND, 1)
		}
		jsonBaseObject.addProperty(UPPER_BOUND, feature.upperBound)
	}

	def private addDefaultPattern(JsonObject jsonBaseObject, EDataType type) {
		switch type.instanceClass {
			case typeof(int): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(Integer): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(long): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(Long): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(short): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(Short): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(double): jsonBaseObject.addProperty(PATTERN, PATTERN_DECIMAL)
			case typeof(Double): jsonBaseObject.addProperty(PATTERN, PATTERN_DECIMAL)
			case typeof(float): jsonBaseObject.addProperty(PATTERN, PATTERN_DECIMAL)
			case typeof(Float): jsonBaseObject.addProperty(PATTERN, PATTERN_DECIMAL)
			case typeof(BigDecimal): jsonBaseObject.addProperty(PATTERN, PATTERN_DECIMAL)
			case typeof(BigInteger): jsonBaseObject.addProperty(PATTERN, PATTERN_NUMBER)
			case typeof(Date): jsonBaseObject.addProperty(PATTERN, DateConverter.PATTERN_DATE_ALL)
		}
	}

	def private addJsType(JsonObject jsonBaseObject, EDataType type) {
		var jsonType = "string"
		switch type.instanceClass {
			case typeof(boolean): jsonType = "boolean"
			case typeof(Boolean): jsonType = "boolean"
			case typeof(int): jsonType = "number"
			case typeof(Integer): jsonType = "number"
			case typeof(long): jsonType = "number"
			case typeof(Long): jsonType = "number"
			case typeof(short): jsonType = "number"
			case typeof(Short): jsonType = "number"
			case typeof(double): jsonType = "number"
			case typeof(Double): jsonType = "number"
			case typeof(float): jsonType = "number"
			case typeof(Float): jsonType = "number"
			case typeof(BigDecimal): jsonType = "number"
			case typeof(BigInteger): jsonType = "number"
			case typeof(Date): jsonType = "date"
		}
		if(type instanceof EEnum) {
			jsonType = "enum"
		}

		jsonBaseObject.add(JS_TYPE, new JsonPrimitive(jsonType))
	}

	def private addDiagnosticsAndMeta(JsonObject jsonBaseObject, EObject object) {

		// validation requested?
		if(jsonConverterConfig.validate) {
			val diags = object.validate
			if(diags.size > 0) {
				if(!diagnostics.containsKey(object)) {
					diagnostics.put(object, diags)
				}
			}
		}

		// meta requested?
		if(jsonConverterConfig.meta) {
			jsonBaseObject.addMeta(object)
		}
	}

	def private addType(JsonObject jsonBaseObject, EClassifier classifier, boolean stop) {
		jsonBaseObject.addProperty(TYPE, classifier.type)
		if(classifier instanceof EClass) {
			if(classifier.EAllSuperTypes.size > 0) {
				val jsonSuperTypesArray = new JsonArray
				classifier.EAllSuperTypes.forEach [
					jsonSuperTypesArray.add(new JsonPrimitive(it.type))
				]
				if(jsonConverterConfig.meta && !stop) {
					jsonBaseObject.add(EXTENDS, jsonSuperTypesArray)
				}
			}
			if(jsonConverterConfig.meta && !stop && classifier.getExtendedFrom.size > 0) {
				val jsonExtendedFromArray = new JsonArray
				classifier.getExtendedFrom.forEach [
					jsonExtendedFromArray.add(new JsonPrimitive(it.type))
				]
				jsonBaseObject.add(EXTENDED_FROM, jsonExtendedFromArray)
			}
		}
	}

	def private dispatch toJsonObject(Object object, boolean stop) {
		logger.error("NO DISPATCH MEHTOD for toJsonObject({}) ", object.class.name)
		new JsonPrimitive(object.toString)
	}

	def private dispatch toJsonObject(EObject object, boolean stop) {
		object.toJsonBase(stop)
	}

	def private getUrl(EObject object) {
		return object.getUrl(true)
	}

	def private getUrl(EObject object, boolean withTimestamp) {
		var id = ""
		if(object instanceof CDOObject) {
			id = object.cdoID.toURIFragment.replace("L", "")
		} else {

			// Legacy models do not inherit from CDOObject
			id = EcoreUtil.getURI(object).fragment.replace("L", "")
		}
		jsonConverterConfig.serverAddress + ALIAS_OBJECT + "/" + object.eClass.type + "/" + id + object.getTimestampParam(withTimestamp)

	}

	def private getTimestampParam(EObject object, boolean withTimestamp) {
		if(!withTimestamp) {
			return ""
		}
		if(object instanceof CDOObject) {
			if(object.view.timeStamp > 0) {
				return "?" + PARAM_POINT_IN_TIME + "=" + object.view.timeStamp
			}
		}
		return ""
	}

	def getOid(EObject object) {
		val uri = EcoreUtil.getURI(object)
		try {
			return Long.parseLong(uri.fragment.replace("L", ""))
		} catch(Exception e) {
			logger.debug("Could not resolve CDOID from '{}'", object)
			return null
		}
	}

	def private setAttributes(JsonElement element, EObject eObject) {
		if(element.jsonObject) {

			// should always be the case if it is a valid json
			val jsonObject = element.asJsonObject
			jsonObject.entrySet.forEach [
				val jsonName = it.key
				val jsonElement = it.value
				logger.debug("Found attribute with name '{}'", jsonName)
				eObject.eClass.EAllAttributes.forEach [
					logger.debug("eObject '{}' has eAttribute '{}'", eObject, it.name)
				]
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
							eObject.safeSetAttributeArray(eAttribute, eArray)
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

	def private safeToEType(JsonPrimitive jsonPrimitive, EAttribute eAttribute) {
		logger.debug("eAttribute '{}' has data type '{}', try to set json value '{}'", eAttribute.name, eAttribute.EAttributeType.name, jsonPrimitive)
		try {
			switch eAttribute.EAttributeType.instanceClass {
				case typeof(String): return jsonPrimitive.asString
				case typeof(boolean): return jsonPrimitive.asBoolean
				case typeof(Boolean): return jsonPrimitive.asBoolean
				case typeof(int): return jsonPrimitive.asInt
				case typeof(Integer): return jsonPrimitive.asInt
				case typeof(long): return jsonPrimitive.asLong
				case typeof(Long): return jsonPrimitive.asLong
				case typeof(short): return jsonPrimitive.asShort
				case typeof(Short): return jsonPrimitive.asShort
				case typeof(double): return jsonPrimitive.asDouble
				case typeof(Double): return jsonPrimitive.asDouble
				case typeof(float): return jsonPrimitive.asFloat
				case typeof(Float): return jsonPrimitive.asFloat
				case typeof(byte): return jsonPrimitive.asByte
				case typeof(Byte): return jsonPrimitive.asByte
				case typeof(char): return jsonPrimitive.asCharacter
				case typeof(Character): return jsonPrimitive.asCharacter
				case typeof(Date): return parseDate(jsonPrimitive.asString)
				case typeof(BigDecimal): return jsonPrimitive.asBigDecimal
				case typeof(BigInteger): return jsonPrimitive.asBigInteger
				case typeof(byte[]): return Base64.decodeBase64(jsonPrimitive.asString)
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
		} catch(Exception e) {
			throw new FlatlandException(SC_BAD_REQUEST, "Json primitive '{}' could not be converted to '{}' for attribute '{}'", jsonPrimitive.asString, eAttribute.EAttributeType.name, eAttribute.name)
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
		new JsonPrimitive(object)
	}

	def private dispatch toJsonPrimitive(Date object) {
		new JsonPrimitive(formatDate(object))
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

	def private getDiagnosticsAsJsonArray(Map<EObject, List<Diagnostic>> localDiagnostics) {
		if(localDiagnostics.size > 0) {
			val messageArray = new JsonArray
			localDiagnostics.keySet.forEach [
				val origin = new JsonObject
				origin.add(ORIGIN, new JsonPrimitive(it.url))
				val diagsArray = new JsonArray
				origin.add(DIAGNOSTIC, diagsArray)
				localDiagnostics.get(it).forEach [
					val diag = new JsonObject
					diag.addProperty(MESSAGE, it.message)
					val feature = it.data.get(1) as EStructuralFeature
					if(feature instanceof EAttribute) {
						diag.addProperty(FEATURE, (ATTRIBUTES + "." + feature.name))
					} else {
						diag.addProperty(FEATURE, (REFERENCES + "." + feature.name))
					}
					diagsArray.add(diag)
					if(it.children.size > 0) {
						val detailsArray = new JsonArray
						it.children.forEach [
							detailsArray.add(new JsonPrimitive(it.message))
						]
						diag.add(DETAILS, detailsArray)
					}
				]
				messageArray.add(origin)
			]
			return messageArray
		}
		return null
	}

	def private getRevisionDeltasAsJsonArray(Map<EObject, List<CDOFeatureDelta>> localRevisionDelta) {
		if(localRevisionDelta.size > 0) {
			val messageArray = new JsonArray
			localRevisionDelta.keySet.forEach [
				val origin = new JsonObject
				origin.add(ORIGIN, new JsonPrimitive(it.url))
				val deltasArray = new JsonArray
				origin.add(REVISION_DELTA, deltasArray)
				val object = it
				for (featureDelta : localRevisionDelta.get(object)) {
					val jsonObject = featureDelta.getFeatureDeltaAsJsonObject(object) as JsonObject
					if(featureDelta.feature instanceof EAttribute) {
						jsonObject.addProperty(FEATURE, (ATTRIBUTES + "." + featureDelta.feature.name))
					} else {
						jsonObject.addProperty(FEATURE, (REFERENCES + "." + featureDelta.feature.name))
					}
					deltasArray.add(jsonObject)
				}
				messageArray.add(origin)
			]
			return messageArray
		}
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDOFeatureDelta delta, EObject object) {
		logger.debug("getFeatureDeltaAsJsonObject with CDOFeatureDelta '{}'", delta)
		val jsonObject = new JsonObject
		jsonObject.addProperty(MESSAGE, delta.type + " feature '" + delta.feature.name + "' to '" + object.eGet(delta.feature) + "'")
		return jsonObject
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDOListFeatureDelta delta, EObject object) {
		logger.debug("getFeatureDeltaAsJsonObject with CDOListFeatureDelta '{}'", delta)
		val jsonObject = new JsonObject
		jsonObject.addProperty(MESSAGE, delta.type + " feature '" + delta.feature.name + "' changed")
		if(delta.listChanges.size > 0) {
			val jsonArray = new JsonArray
			delta.listChanges.forEach [
				jsonArray.add(it.getFeatureDeltaAsJsonObject(object))
			]
			jsonObject.add(DETAILS, jsonArray)
		}
		return jsonObject
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDOSetFeatureDelta delta, EObject object) {
		logger.debug("getFeatureDeltaAsJsonObject with CDOSetFeatureDelta '{}'", delta)
		val jsonObject = new JsonObject
		jsonObject.addProperty(MESSAGE, delta.type + " feature '" + delta.feature.name + "' from '" + delta.oldValue + "' to '" + delta.value + "'")
		return jsonObject
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDOAddFeatureDelta delta, EObject object) {
		logger.debug("getFeatureDeltaAsJsonObject with CDOAddFeatureDelta '{}'", delta)
		val message = delta.type + " '" + delta.value + "' to feature '" + delta.feature.name + "[" + delta.index + "]'"
		return new JsonPrimitive(message)
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDOContainerFeatureDelta delta, EObject object) {

		logger.debug("getFeatureDeltaAsJsonObject with CDOContainerFeatureDelta '{}'", delta)
		val jsonObject = new JsonObject
		jsonObject.addProperty(MESSAGE, delta.type + " changed to '" + delta.containerID + "'")
		return jsonObject
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDOMoveFeatureDelta delta, EObject object) {

		// TODO can be more detailed
		logger.debug("getFeatureDeltaAsJsonObject with CDOMoveFeatureDelta '{}'", delta)
		val jsonObject = new JsonObject
		jsonObject.addProperty(MESSAGE, delta.type + " feature '" + delta.feature.name + "' to '" + object.eGet(delta.feature) + "'")
		return jsonObject
	}

	def private dispatch JsonElement getFeatureDeltaAsJsonObject(CDORemoveFeatureDelta delta, EObject object) {
		logger.debug("getFeatureDeltaAsJsonObject with CDORemoveFeatureDelta '{}'", delta)
		val message = delta.type + " '" + delta.value + "' form feature '" + delta.feature.name + "[" + delta.index + "]'"
		return new JsonPrimitive(message)
	}

	def getView(EObject eObject) {
		(eObject as CDOObject).cdoView
	}

	def newObjectWithStatus() {

		val objectWithStatus = new JsonObject
		if(diagnostics.size == 0) {
			objectWithStatus.addProperty(STATUS, MessageStatus.OK.name)
		} else {
			objectWithStatus.addProperty(STATUS, MessageStatus.INVALID.name)
		}

		val jsonBaseObject = new JsonObject
		jsonBaseObject.add(STATUS, objectWithStatus)
		if(diagnostics.size > 0) {
			objectWithStatus.add(DIAGNOSTICS, diagnostics.diagnosticsAsJsonArray)
		}
		if(revisionDeltas.size > 0) {
			objectWithStatus.add(REVISION_DELTAS, revisionDeltas.revisionDeltasAsJsonArray)
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

	def safeSetAttributeArray(EObject container, EAttribute eAttribute, List<Object> attArray) {
		if(eAttribute.upperBound > 0 && attArray.size > eAttribute.upperBound) {
			throw new FlatlandException(SC_BAD_REQUEST, container, "Try to add '{}' elements to array '{}' having upper limit of '{}'", attArray.size, eAttribute.name, eAttribute.upperBound)
		}
		container.eSet(eAttribute, attArray)
	}
}
