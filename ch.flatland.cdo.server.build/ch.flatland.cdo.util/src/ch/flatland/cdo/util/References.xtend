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

import java.util.List
import javax.servlet.http.HttpServletRequest
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference

class References {

	val extension EMF = new EMF
	val extension Request = new Request

	def safeResolveReferences(EObject object, String referenceName, HttpServletRequest req) {
		if(referenceName === null) {
			val allReferences = object.getAllReferences(req)
			return allReferences.checkNull
		} else {
			val references = object.getReferences(referenceName, true)
			return references.checkNull
		}
	}

	def referencesSize(EObject object, String referenceName, boolean includeXtraces) {
		if(referenceName === null) {
			val allReferences = object.getAllReferences(includeXtraces)
			return allReferences.size
		} else {
			val references = object.getReferences(referenceName, includeXtraces)
			if(references === null) {
				return 0
			}
			if(references instanceof List<?>) {
				return references.size
			}
			if(references instanceof EObject) {
				return 1
			}
			return 0
		}
	}

	def hasReferences(EObject object, String referenceName, boolean includeXtraces) {
		if(referenceName === null) {
			val allReferences = object.getAllReferences(includeXtraces)
			return allReferences.size > 0
		} else {
			val references = object.getReferences(referenceName, includeXtraces)
			if(references !== null) {
				if(references instanceof EObject) {
					return true
				}
				if(references instanceof List<?> && (references as List<?>).size > 0) {
					return true
				}
			}
			return false
		}
	}

	def private getAllReferences(EObject object, HttpServletRequest req) {
		val allReferences = newArrayList
		object.eClass.EAllReferences.forEach [
			if(it.needsReference(req) && it.name.includeRef(true)) {
				if(it.many) {
					val List<EObject> refs = object.eGet(it) as List<EObject>
					for (r : refs) {
						if(r.hasPermission) {
							allReferences.addIfNotExits(r)
						}
					}
				} else {
					val r = object.eGet(it) as EObject
					if(r !== null && r.hasPermission) {
						allReferences.addIfNotExits(r)
					}
				}
			}
		]
		return allReferences
	}

	def private getAllReferences(EObject object, boolean includeXtraces) {
		val allReferences = newArrayList
		object.eClass.EAllReferences.forEach [
			if(it.name.includeRef(includeXtraces)) {
				if(it.many) {
					val List<EObject> refs = object.eGet(it) as List<EObject>
					for (r : refs) {
						if(r.hasPermission) {
							allReferences.addIfNotExits(r)
						}
					}
				} else {
					val r = object.eGet(it) as EObject
					if(r !== null && r.hasPermission) {
						allReferences.addIfNotExits(r)
					}
				}
			}
		]
		return allReferences
	}

	def private getReferences(EObject object, String referenceName, boolean includeXtraces) {
		val eReference = object.eClass.EAllReferences.filter[it.name == referenceName].head
		if(!eReference.name.includeRef(includeXtraces)) {
			return null
		}
		if(eReference !== null) {
			if(eReference.many) {
				val references = newArrayList
				val List<EObject> refs = object.eGet(eReference) as List<EObject>
				for (r : refs) {
					if(r.hasPermission) {
						references.addIfNotExits(r)
					}
				}
				return references
			} else {
				val reference = object.eGet(eReference) as EObject
				if(reference !== null && reference.hasPermission) {
					return reference
				} else {
					return null
				}
			}
		}
		return null
	}

	def private checkNull(Object object) {
		if(object === null) {
			throw new Exception("Passed object is null")
		}
		return object
	}

	def private addIfNotExits(List<EObject> list, EObject toAdd) {
		if(!list.contains(toAdd) && toAdd !== null) {
			list.add(toAdd)
		}
	}

	def private needsReference(EReference reference, HttpServletRequest req) {
		if(req === null || !req.refs) {
			return true
		}
		if(req.crefs && reference.containment) {
			return true
		}
		if(req.rrefs && !reference.containment) {
			return true
		}
		return false
	}

	def private includeRef(String referenceName, boolean includeXtraces) {
		if(referenceName.startsWith("traceFrom")) {
			if(includeXtraces) {
				return true
			}
		} else {
			return true
		}
		return false
	}
}
