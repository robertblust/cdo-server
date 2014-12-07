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

import com.google.common.base.Splitter
import com.google.gson.JsonElement
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.view.CDOView
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.slf4j.LoggerFactory

import static javax.servlet.http.HttpServletResponse.*

class EMF {

	val logger = LoggerFactory.getLogger(this.class)

	def getType(EClassifier classifier) {
		classifier.EPackage.nsPrefix + "." + classifier.name
	}

	def isAttributeSettable(JsonElement element, EAttribute feature) {
		if(feature.derived) {
			logger.debug("EAttribute '{}' is derived", feature.name)
			return false
		}

		if((element.jsonNull || element.jsonPrimitive) && !feature.many) {
			logger.debug("EAttribute '{}' is primitive or null", feature.name)
			return true
		}

		if((element.jsonNull || element.jsonArray) && feature.many) {
			logger.debug("EAttribute '{}' is array or null", feature.name)
			return true
		}
		return false
	}

	def isReferenceSettable(JsonElement element, EReference feature) {
		if(feature.containment) {
			logger.debug("EReference '{}' is containment", feature.name)
			return false
		}

		if(feature.derived) {
			logger.debug("EReference '{}' is derived", feature.name)
			return false
		}

		if((element.jsonNull || element.jsonObject) && !feature.many) {
			logger.debug("EReference '{}' is object or null", feature.name)
			return true
		}

		if((element.jsonNull || element.jsonArray) && feature.many) {
			logger.debug("EReference '{}' is array or null", feature.name)
			return true
		}
		return false
	}

	def isContainmentSettable(EReference feature) {
		if(feature.containment) {
			logger.debug("EReference '{}' is containment", feature.name)
			return true
		}
	}

	def getNameAttribute(EClass eClass) {
		return eClass.getAttribute("name")
	}

	def getAttribute(EClass eClass, String name) {
		return eClass.EAllAttributes.filter[it.name == name && !it.derived].head
	}

	def validate(EObject object) {
		val filterdDiagnostics = newArrayList
		val diagnostics = new FLDiagnostician().validate(object)

		if(diagnostics.severity > 0) {
			for (child : diagnostics.children) {
				if(child.severity > 0 && child.data.contains(object)) {
					logger.debug("Diagnostics '{}'", (object as CDOObject).cdoID + ": " + child.message)
					filterdDiagnostics.add(child)
				}
			}
		}
		return filterdDiagnostics
	}

	def safePackagePrefix(String type) {
		val segments = Splitter.on(".").split(type)
		if(segments.size != 2) {
			throw new FlatlandException(SC_BAD_REQUEST, "Not a valid type '{}'", type)
		}
		segments.get(0)
	}

	def safeEType(String type) {
		val segments = Splitter.on(".").split(type)
		if(segments.size != 2) {
			throw new FlatlandException(SC_BAD_REQUEST, "Not a valid type '{}'", type)
		}
		segments.get(1)
	}

	def safeCreateType(CDOView view, String type) {
		val ePackage = view.ePackage(type.safePackagePrefix)
		val eClass = view.safeEClass(type)
		val newObject = ePackage.EFactoryInstance.create(eClass)
		logger.debug("Created new object '{}'", newObject)
		return newObject
	}

	def ePackage(CDOView view, String nsPrefix) {
		val packageRegistry = view.session.packageRegistry
		val packageInfo = packageRegistry.packageInfos.filter[it.EPackage.nsPrefix == nsPrefix].head
		if(packageInfo == null) {
			throw new FlatlandException(SC_BAD_REQUEST, "Invalid package prefix '{}'", nsPrefix)
		}
		val ePackage = packageInfo.EPackage
		logger.debug("Resolved EPackage '{}'", ePackage.nsURI)
		return ePackage
	}

	def safeEClass(CDOView view, String type) {
		val eType = type.safeEType
		val ePackage = view.ePackage(type.safePackagePrefix)
		val eClass = ePackage.EClassifiers.filter[it.name == eType].head as EClass
		if(eClass == null) {
			throw new FlatlandException(SC_BAD_REQUEST, "Could not resolve eClass for '{}'", type)
		}
		logger.debug("Resolved EClass '{}'", eClass.name)
		return eClass
	}
}
