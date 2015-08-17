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

import com.google.common.base.Splitter
import com.google.gson.JsonElement
import java.util.List
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.common.security.CDOPermission
import org.eclipse.emf.cdo.common.security.NoPermissionException
import org.eclipse.emf.cdo.eresource.EresourcePackage
import org.eclipse.emf.cdo.view.CDOView
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.slf4j.LoggerFactory

import static javax.servlet.http.HttpServletResponse.*

class EMF {

	val logger = LoggerFactory.getLogger(this.class)
	val static IGNORED_EPACKAGES = newArrayList(
		"xcore.lang"
	)
	val static IGNORED_EPACKAGES_META = newArrayList(
		"xcore.lang",
		"ch.flatland.cdo.model.config",
		"http://www.eclipse.org/emf/2003/Change",
		"http://www.eclipse.org/ocl/1.1.0/Ecore",
		"http://www.eclipse.org/emf/CDO/security/4.1.0",
		"http://www.eclipse.org/ocl/1.1.0/OCL/CST",
		"http://www.eclipse.org/emf/2003/XMLType",
		"http://www.eclipse.org/emf/2002/Ecore",
		"http://www.eclipse.org/emf/CDO/expressions/4.3.0",
		"http://www.eclipse.org/emf/CDO/Etypes/4.0.0",
		"http://www.eclipse.org/ocl/1.1.0/OCL",
		"http://www.eclipse.org/ocl/1.1.0/OCL/Types",
		"http://www.eclipse.org/ocl/1.1.0/OCL/Expressions",
		"http://www.eclipse.org/emf/2002/Tree",
		"http://www.eclipse.org/emf/CDO/admin/RepositoryCatalog/4.3.0",
		"http://www.eclipse.org/ocl/1.1.0/OCL/Utilities",
		"http://www.w3.org/XML/1998/namespace",
		"http://www.eclipse.org/emf/CDO/Eresource/4.0.0"
	)
	val static IGNORED_ECLASSES = newArrayList("CDOBinaryResource", "CDOTextResource", "EObject")

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

	def isContainmentSettable(EReference feature) {
		if(feature.containment) {
			logger.debug("EReference '{}' is containment", feature.name)
			return true
		}
	}
	
	def isReferenceSettable(EReference feature) {
		if(feature.containment) {
			logger.debug("EReference '{}' is containment", feature.name)
			return false
		}
		
		if(feature.derived) {
			logger.debug("EReference '{}' is derived", feature.name)
			return false
		}
		return true
	}

	def getNameAttribute(EClass eClass) {
		return eClass.getAttribute("name")
	}

	def getAttribute(EClass eClass, String name) {
		return eClass.EAllAttributes.filter[it.name == name && !it.derived].head
	}

	def getExtendedFrom(EClass eClass, CDOView view) {
		logger.trace("getExtendedFrom(EClass eClass, CDOView view)", eClass.name)
		val eClasses = newArrayList

		// look for all concrete classes inherit from this eClass
		view.session.packageRegistry.packageInfos.forEach [
			it.EPackage.eContents.forEach [
				if(it instanceof EClass) {
					if(it.EAllSuperTypes.contains(eClass) && it.abstract == false && !IGNORED_ECLASSES.contains(it.name) && !eClasses.contains(it)) {
						eClasses.add(it)
					}
					if(eClass.name == "EObject" && it.abstract == false && !eClasses.contains(it)) {
						logger.debug("Look for all valid sub types of EObject add '{}'", it.name)
						eClasses.add(it)
					}
				}
			]
		]
		return eClasses
	}

	def getExtendedFrom(EClass eClass) {
		logger.trace("getExtendedFrom(EClass eClass) '{}'", eClass.name)
		val eClasses = newArrayList	
					
		if (eClass.name == "CDOResourceNode" ) {
			eClasses.add(EresourcePackage.eINSTANCE.CDOResource)
			eClasses.add(EresourcePackage.eINSTANCE.CDOResourceFolder)
		}
		
		val List<String> newIgnoredPackages = IGNORED_EPACKAGES_META.clone as List<String>
		if (eClass.EPackage.nsURI == "http://www.eclipse.org/emf/CDO/security/4.1.0") {
			newIgnoredPackages.remove("http://www.eclipse.org/emf/CDO/security/4.1.0")
		}
		
		// look for all concrete classes inherit from this eClass
		val keySet = EPackage.Registry.INSTANCE.keySet.filter[!newIgnoredPackages.contains(it)].clone

		for (key : keySet) {
			val ePackage = EPackage.Registry.INSTANCE.getEPackage(key)
			ePackage.eContents.forEach [
				if(it instanceof EClass) {
					if(it.EAllSuperTypes.contains(eClass) && it.abstract == false && !IGNORED_ECLASSES.contains(it.name) && !eClasses.contains(it)) {
						eClasses.add(it)
					}
					if(eClass.name == "EObject" && it.abstract == false && !IGNORED_ECLASSES.contains(it.name) && !eClasses.contains(it)) {

						logger.debug("Look for all valid sub types of EObject add '{}'", it.name)
						eClasses.add(it)
					}
				}
			]
		}
		return eClasses
	}

	def validate(EObject object) {
		val fLDiagnostics = newArrayList

		try {
			val diagnostic = new FLDiagnostician().validate(object)

			if(diagnostic.severity > 0) {
				for (child : diagnostic.children) {
					if(child.severity > 0 && child.data.contains(object)) {
						logger.debug("Diagnostics '{}'", child.message)
						fLDiagnostics.add(child)
					}
				}
			}
		} catch(NoPermissionException npe) {
			logger.debug("No permission exception, can not validate '{}'", object)
		}
		return fLDiagnostics
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
		val ePackage = view.safeEPackage(type.safePackagePrefix)
		val eClass = view.safeEClass(type)
		val newObject = ePackage.EFactoryInstance.create(eClass)
		logger.debug("Created new object '{}'", newObject)
		return newObject
	}

	def safeEPackage(CDOView view, String nsPrefix) {
		val packageRegistry = view.session.packageRegistry
		val packageInfo = packageRegistry.packageInfos.filter[it.EPackage.nsPrefix == nsPrefix].head
		if(packageInfo == null) {
			val newPackage = view.registerNewPackage(nsPrefix)
			if(newPackage != null) {
				return newPackage
			}
			throw new FlatlandException(SC_BAD_REQUEST, "Invalid package prefix '{}'", nsPrefix)
		}
		val ePackage = packageInfo.EPackage
		logger.debug("Resolved EPackage '{}'", ePackage.nsURI)
		return ePackage
	}

	def safeEClass(CDOView view, String type) {
		val eType = type.safeEType
		val ePackage = view.safeEPackage(type.safePackagePrefix)
		val eClassifier = ePackage.EClassifiers.filter[it.name == eType].head
		if(eClassifier == null) {
			throw new FlatlandException(SC_BAD_REQUEST, "Could not resolve eClass for '{}'", type)
		}
		if(!(eClassifier instanceof EClass)) {
			throw new FlatlandException(SC_BAD_REQUEST, "Not an eClass '{}', i'm a '{}'", type, eClassifier.eClass.name)
		}
		val eClass = eClassifier as EClass
		logger.debug("Resolved EClass '{}'", eClass.name)
		return eClass
	}

	def safeEPackage(String nsPrefix) {
		val keySet = EPackage.Registry.INSTANCE.keySet.filter[!IGNORED_EPACKAGES.contains(it)].clone
		for (key : keySet) {
			val ePackage = EPackage.Registry.INSTANCE.getEPackage(key)
			if(ePackage != null) {
				if(ePackage.nsPrefix == nsPrefix) {
					return ePackage
				}
			}
		}
		throw new FlatlandException(SC_BAD_REQUEST, "Invalid package prefix '{}'", nsPrefix)
	}

	def safeEClass(EPackage ePackage, String type) {
		val eClassifier = ePackage.EClassifiers.filter[it.name == type].head
		if(eClassifier == null) {
			throw new FlatlandException(SC_BAD_REQUEST, "Could not resolve eClass for '{}'", type)
		}
		if(!(eClassifier instanceof EClass)) {
			throw new FlatlandException(SC_BAD_REQUEST, "Not an eClass '{}', i'm a '{}'", type, eClassifier.eClass.name)
		}
		val eClass = eClassifier as EClass
		logger.debug("Resolved EClass '{}'", eClass.name)
		return eClass
	}

	def hasPermission(EObject object) {
		if(object instanceof CDOObject) {
			if(object.cdoPermission != CDOPermission.NONE) {
				return true
			}
		} else {
			return true
		}
		return false
	}

	def private registerNewPackage(CDOView view, String nsPrefix) {
		val keySet = EPackage.Registry.INSTANCE.keySet.filter[!IGNORED_EPACKAGES.contains(it)].clone
		for (key : keySet) {
			val ePackage = EPackage.Registry.INSTANCE.getEPackage(key)
			if(ePackage != null) {
				if(ePackage.nsPrefix == nsPrefix) {
					view.session.packageRegistry.putEPackage(ePackage)
					logger.debug("New EPackage registered '{}'", ePackage.nsURI)
					return ePackage
				}
			}
		}
		return null
	}
}
