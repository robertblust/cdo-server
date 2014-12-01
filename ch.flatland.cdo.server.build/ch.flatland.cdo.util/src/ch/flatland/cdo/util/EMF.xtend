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

import com.google.gson.JsonElement
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EReference
import org.slf4j.LoggerFactory

class EMF {

	val logger = LoggerFactory.getLogger(this.class)
	
	def getType(EClassifier classifier) {
		classifier.EPackage.nsURI + "." + classifier.name
	}

	def isAttributeSettable(JsonElement element, EAttribute feature) {
		if (feature.derived) {
			logger.debug("EAttribute '{}' is derived", feature.name)
			return false
		}

		if ((element.jsonNull || element.jsonPrimitive) && !feature.many) {
			logger.debug("EAttribute '{}' is primitive or null", feature.name)
			return true
		}

		if ((element.jsonNull || element.jsonArray) && feature.many) {
			logger.debug("EAttribute '{}' is array or null", feature.name)
			return true
		}
		return false
	}
	
	def isReferenceSettable(JsonElement element, EReference feature) {
		if (feature.containment) {
			logger.debug("EReference '{}' is containment", feature.name)
			return false
		}
		
		if (feature.derived) {
			logger.debug("EReference '{}' is derived", feature.name)
			return false
		}

		if ((element.jsonNull || element.jsonObject) && !feature.many) {
			logger.debug("EReference '{}' is object or null", feature.name)
			return true
		}

		if ((element.jsonNull || element.jsonArray) && feature.many) {
			logger.debug("EReference '{}' is array or null", feature.name)
			return true
		}
		return false
	}
	
	def isContainmentSettable(EReference feature) {
		if (feature.containment) {
			logger.debug("EReference '{}' is containment", feature.name)
			return true
		}
	}
}
