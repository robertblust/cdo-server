package ch.flatland.cdo.model.base.provider

import org.eclipse.emf.common.notify.AdapterFactory

class FLTraceItemProviderCustom extends FLTraceItemProvider {
	new(AdapterFactory adapterFactory) {
		super(adapterFactory)
	}

	def override getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("FLTrace"));
	}
}