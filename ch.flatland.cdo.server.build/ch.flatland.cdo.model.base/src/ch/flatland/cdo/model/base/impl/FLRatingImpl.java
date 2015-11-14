/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLRating;
import ch.flatland.cdo.model.base.FLRatingType;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Rating</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLRatingImpl#getRatingType <em>Rating Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FLRatingImpl extends CDOObjectImpl implements FLRating {
	/**
	 * The default value of the '{@link #getRatingType() <em>Rating Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRatingType()
	 * @generated
	 * @ordered
	 */
	protected static final FLRatingType RATING_TYPE_EDEFAULT = FLRatingType.LIKE;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLRatingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_RATING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLRatingType getRatingType() {
		return (FLRatingType)eDynamicGet(BasePackage.FL_RATING__RATING_TYPE, BasePackage.Literals.FL_RATING__RATING_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatingType(FLRatingType newRatingType) {
		eDynamicSet(BasePackage.FL_RATING__RATING_TYPE, BasePackage.Literals.FL_RATING__RATING_TYPE, newRatingType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FL_RATING__RATING_TYPE:
				return getRatingType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasePackage.FL_RATING__RATING_TYPE:
				setRatingType((FLRatingType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BasePackage.FL_RATING__RATING_TYPE:
				setRatingType(RATING_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BasePackage.FL_RATING__RATING_TYPE:
				return getRatingType() != RATING_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //FLRatingImpl
