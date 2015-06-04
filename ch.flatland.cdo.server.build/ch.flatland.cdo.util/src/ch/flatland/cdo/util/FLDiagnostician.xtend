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

import java.util.Map
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory

class FLDiagnostician extends Diagnostician {

	val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))
	var EObject context

	def override getObjectLabel(EObject eObject) {
		if (context == null)  {
			return super.getObjectLabel(eObject)
		}
		if (context instanceof Adapter) {
			return ITEM_DELEGATOR.getText(context.target)
		}
		return ITEM_DELEGATOR.getText(context)
		
	}

	def override validate(EObject eObject) {
		this.context = eObject
		if (context instanceof Adapter) {
			return super.validate(context.target as EObject, emptyMap)
		}
		return super.validate(eObject, emptyMap)
	}
	
	def override doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// do not validate contents! it is to expensive in the context of cdo
		return true
  	}
}
