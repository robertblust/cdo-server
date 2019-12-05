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

import java.util.Set
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString
class FLQuery {
	val Set<FLConstraint> andStatements = newHashSet
	val Set<FLConstraint> orStatements = newHashSet
}

interface FLConstraint {
	def EStructuralFeature getFeature()

	def String getCompare()
}

@Data
class FLEquals implements FLConstraint {
	EStructuralFeature feature
	String compare
}

@Data
class FLLess implements FLConstraint {
	EStructuralFeature feature
	String compare
}

@Data
class FLLessOrEquals implements FLConstraint {
	EStructuralFeature feature
	String compare
}

@Data
class FLGreater implements FLConstraint {
	EStructuralFeature feature
	String compare
}

@Data
class FLGreaterOrEqual implements FLConstraint {
	EStructuralFeature feature
	String compare
}
