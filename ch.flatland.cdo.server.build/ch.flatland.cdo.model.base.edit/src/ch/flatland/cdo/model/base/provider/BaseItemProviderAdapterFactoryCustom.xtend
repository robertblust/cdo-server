package ch.flatland.cdo.model.base.provider

import org.eclipse.emf.common.notify.Adapter

class BaseItemProviderAdapterFactoryCustom extends BaseItemProviderAdapterFactory {

	def override Adapter createFLComponentAdapter() {
		if (flComponentItemProvider == null) {
			flComponentItemProvider = new FLComponentItemProvider(this);
		}

		return flComponentItemProvider;
	}

	def override Adapter createFLPackageAdapter() {
		if (flPackageItemProvider == null) {
			flPackageItemProvider = new FLPackageItemProviderCustom(this);
		}

		return flPackageItemProvider;
	}

	def override Adapter createFLTraceAdapter() {
		if (flTraceItemProvider == null) {
			flTraceItemProvider = new FLTraceItemProviderCustom(this);
		}

		return flTraceItemProvider;
	}
}
