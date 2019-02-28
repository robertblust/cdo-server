/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLHyperLink;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Hyper Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLHyperLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLHyperLinkImpl#getHyperLink <em>Hyper Link</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FLHyperLinkImpl extends CDOObjectImpl implements FLHyperLink {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getHyperLink() <em>Hyper Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLink()
	 * @generated
	 * @ordered
	 */
	protected static final String HYPER_LINK_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLHyperLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_HYPER_LINK;
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
	@Override
	public String getName() {
		return (String)eDynamicGet(BasePackage.FL_HYPER_LINK__NAME, BasePackage.Literals.FL_HYPER_LINK__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(BasePackage.FL_HYPER_LINK__NAME, BasePackage.Literals.FL_HYPER_LINK__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHyperLink() {
		return (String)eDynamicGet(BasePackage.FL_HYPER_LINK__HYPER_LINK, BasePackage.Literals.FL_HYPER_LINK__HYPER_LINK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHyperLink(String newHyperLink) {
		eDynamicSet(BasePackage.FL_HYPER_LINK__HYPER_LINK, BasePackage.Literals.FL_HYPER_LINK__HYPER_LINK, newHyperLink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FL_HYPER_LINK__NAME:
				return getName();
			case BasePackage.FL_HYPER_LINK__HYPER_LINK:
				return getHyperLink();
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
			case BasePackage.FL_HYPER_LINK__NAME:
				setName((String)newValue);
				return;
			case BasePackage.FL_HYPER_LINK__HYPER_LINK:
				setHyperLink((String)newValue);
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
			case BasePackage.FL_HYPER_LINK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasePackage.FL_HYPER_LINK__HYPER_LINK:
				setHyperLink(HYPER_LINK_EDEFAULT);
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
			case BasePackage.FL_HYPER_LINK__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case BasePackage.FL_HYPER_LINK__HYPER_LINK:
				return HYPER_LINK_EDEFAULT == null ? getHyperLink() != null : !HYPER_LINK_EDEFAULT.equals(getHyperLink());
		}
		return super.eIsSet(featureID);
	}

} //FLHyperLinkImpl
