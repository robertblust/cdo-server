package ch.flatland.cdo.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician

class FLDiagnostician extends Diagnostician {

	var String label

	new(String label) {
		this.label = label
	}

	def override getObjectLabel(EObject eObject) {
		return label
	}
}
