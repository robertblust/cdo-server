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
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EStructuralFeature

class EMF {

	def getType(EClassifier classifier) {
		classifier.EPackage.nsURI + "." + classifier.name
	}

	def isSettable(JsonElement element, EStructuralFeature feature) {
		if (feature.derived) {
			return false
		}

		if (element.jsonPrimitive && !feature.many) {
			return true
		}

		if (element.jsonArray && feature.many) {
			return true
		}
		return false
	}
}
