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

import java.util.Comparator
import org.eclipse.emf.ecore.EObject

class AttributeComparator implements Comparator<EObject> {

	var String eAttributeName

	new(String eAttributeName) {
		this.eAttributeName = eAttributeName
	}

	override compare(EObject o1, EObject o2) {
		var String value1 = o1.value
		var String value2 = o2.value

		return value1.compareTo(value2)
	}

	def private getValue(EObject object) {
		var String value = "undefined"
		val eAttribute = object.eClass.EAllAttributes.filter[it.name == eAttributeName].head
		if(eAttribute != null) {
			value = object.eGet(eAttribute).toString
		}
		return value
	}
}
