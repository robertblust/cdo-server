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

import java.util.HashMap
import java.util.List
import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.slf4j.LoggerFactory

class XReferences {
	val logger = LoggerFactory.getLogger(this.class)

	def safeResolveXReferences(EObject object) {
		val xrefs = object.allXReferences
		if(xrefs.size > 0) {
			return xrefs
		}
		throw new Exception
	}

	def safeResolveGroupXReferences(EObject object, String referenceName) {
		val map = object.resolveGroupXReferences
		for (feature : map.keySet) {
			if(feature.name == referenceName) {
				return map.get(feature)
			}
		}
		throw new Exception
	}

	def hasXReferences(EObject object) {
		if(object.allXReferences.size > 0) {
			return true
		}
		return false
	}

	def resolveGroupXReferences(EObject object) {
		val map = new HashMap<EStructuralFeature, List<EObject>>()
		if(object instanceof CDOObject) {
			val xrefs = object.cdoView.queryXRefs(object, emptyList)
			if(xrefs.size > 0) {
				for (x : xrefs) {
					val source = x.sourceObject
					val sourceFeature = x.sourceFeature
					if(map.keySet.contains(sourceFeature)) {
						map.get(sourceFeature).add(source)
					} else {
						val list = newArrayList
						list.add(source)
						map.put(sourceFeature, list)
					}
				}
			}
		}
		return map
	}

	def getAllXReferences(EObject object) {
		val list = newArrayList
		if(object instanceof CDOObject) {
			val xrefs = object.cdoView.queryXRefs(object, emptyList)
			xrefs.forEach [
				if(!list.contains(it.sourceObject)) {
					logger.debug("Found xref feature '{}', source '{}', target '{}'", sourceFeature.name, sourceObject, targetObject)
					list.add(it.sourceObject)
				}
			]
		}
		return list
	}
}
