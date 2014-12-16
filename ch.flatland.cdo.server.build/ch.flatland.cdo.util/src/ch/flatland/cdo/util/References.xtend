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

import java.util.List
import org.eclipse.emf.ecore.EObject

class References {

	def safeResolveReferences(EObject object, String referenceName) {
		if(referenceName == null) {
			val allReferences = newArrayList
			object.eClass.EAllReferences.forEach [
				if(it.many) {
					val List<EObject> refs = object.eGet(it) as List<EObject>
					for (r : refs) {
						allReferences.addIfNotExits(r)
					}
				} else {
					allReferences.addIfNotExits(object.eGet(it) as EObject)
				}
			]
			return allReferences.checkNullOrEmpty
		} else {
			val eReference = object.eClass.EAllReferences.filter[it.name == referenceName].head
			if(eReference != null) {
				if(eReference.many) {
					val references = newArrayList
					val List<EObject> refs = object.eGet(eReference) as List<EObject>
					for (r : refs) {
						references.addIfNotExits(r)
					}
					return references.checkNullOrEmpty
				} else {
					val reference = object.eGet(eReference) as EObject
					return reference.checkNullOrEmpty
				}
			}
			throw new Exception
		}
	}

	def hasReferences(EObject object, String referenceName) {
		if(referenceName == null) {
			val allReferences = newArrayList
			object.eClass.EAllReferences.forEach [
				if(it.many) {
					val List<EObject> refs = object.eGet(it) as List<EObject>
					for (r : refs) {
						allReferences.addIfNotExits(r)
					}
				} else {
					allReferences.addIfNotExits(object.eGet(it) as EObject)
				}
			]
			return allReferences.size > 0
		} else {
			val eReference = object.eClass.EAllReferences.filter[it.name == referenceName].head
			if(eReference != null) {
				if(eReference.many) {
					val references = newArrayList
					val List<EObject> refs = object.eGet(eReference) as List<EObject>
					for (r : refs) {
						references.addIfNotExits(r)
					}
					return references.size > 0
				} else {
					val reference = object.eGet(eReference) as EObject
					return reference != null
				}
			}
			return false
		}
	}

	def private checkNullOrEmpty(Object object) {
		if(object == null) {
			throw new Exception
		}
		if(object instanceof List<?> && (object as List<?>).size == 0) {
			throw new Exception
		}
		return object
	}

	def private addIfNotExits(List<EObject> list, EObject toAdd) {
		if(!list.contains(toAdd) && toAdd != null) {
			list.add(toAdd)
		}
	}
}
