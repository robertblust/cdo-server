/**
 */
package ch.flatland.cdo.model.base.util;

import ch.flatland.cdo.model.base.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.base.BasePackage
 * @generated
 */
public class BaseAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BasePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BasePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseSwitch<Adapter> modelSwitch =
		new BaseSwitch<Adapter>() {
			@Override
			public Adapter caseFLID(FLID object) {
				return createFLIDAdapter();
			}
			@Override
			public Adapter caseFLElement(FLElement object) {
				return createFLElementAdapter();
			}
			@Override
			public Adapter caseFLPackage(FLPackage object) {
				return createFLPackageAdapter();
			}
			@Override
			public Adapter caseFLHyperLink(FLHyperLink object) {
				return createFLHyperLinkAdapter();
			}
			@Override
			public Adapter caseFLComment(FLComment object) {
				return createFLCommentAdapter();
			}
			@Override
			public Adapter caseRateable(Rateable object) {
				return createRateableAdapter();
			}
			@Override
			public Adapter caseFLRating(FLRating object) {
				return createFLRatingAdapter();
			}
			@Override
			public Adapter caseFLTrace(FLTrace object) {
				return createFLTraceAdapter();
			}
			@Override
			public Adapter caseFLProperty(FLProperty object) {
				return createFLPropertyAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLID <em>FLID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLID
	 * @generated
	 */
	public Adapter createFLIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLElement <em>FL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLElement
	 * @generated
	 */
	public Adapter createFLElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLPackage <em>FL Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLPackage
	 * @generated
	 */
	public Adapter createFLPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLHyperLink <em>FL Hyper Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLHyperLink
	 * @generated
	 */
	public Adapter createFLHyperLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLComment <em>FL Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLComment
	 * @generated
	 */
	public Adapter createFLCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.Rateable <em>Rateable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.Rateable
	 * @generated
	 */
	public Adapter createRateableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLRating <em>FL Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLRating
	 * @generated
	 */
	public Adapter createFLRatingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLTrace <em>FL Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLTrace
	 * @generated
	 */
	public Adapter createFLTraceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ch.flatland.cdo.model.base.FLProperty <em>FL Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ch.flatland.cdo.model.base.FLProperty
	 * @generated
	 */
	public Adapter createFLPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BaseAdapterFactory
