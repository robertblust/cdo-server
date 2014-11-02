package ch.flatland.cdo.model.base.provider

import ch.flatland.cdo.model.base.FLPackage
import org.eclipse.emf.common.notify.AdapterFactory

class FLPackageItemProviderCustom extends FLPackageItemProvider {
	new(AdapterFactory adapterFactory) {
		super(adapterFactory)
	}

	def override getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("FLPackage"));
	}
	
	def override getText(Object object) {
		val package = object as FLPackage
		if (package.name != null && package.name.length > 0) {
			return package.name
		}
		return "?"
	}
}
