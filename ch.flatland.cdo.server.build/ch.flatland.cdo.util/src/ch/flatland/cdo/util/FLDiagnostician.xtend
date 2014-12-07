package ch.flatland.cdo.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory

class FLDiagnostician extends Diagnostician {

	val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))
	var EObject context

	def override getObjectLabel(EObject eObject) {
		if (context != null) {
			return ITEM_DELEGATOR.getText(context)
		}
		return super.getObjectLabel(eObject)
	}
	
	def override validate(EObject eObject) {
		this.context = eObject
		return super.validate(eObject)
	}
}
