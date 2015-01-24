/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLComponent;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLComponentImpl#getComponentId <em>Component Id</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLComponentImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FLComponentImpl extends FLElementImpl implements FLComponent {
	/**
	 * The default value of the '{@link #getComponentId() <em>Component Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentId()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentId() {
		return (String)eDynamicGet(BasePackage.FL_COMPONENT__COMPONENT_ID, BasePackage.Literals.FL_COMPONENT__COMPONENT_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentId(String newComponentId) {
		eDynamicSet(BasePackage.FL_COMPONENT__COMPONENT_ID, BasePackage.Literals.FL_COMPONENT__COMPONENT_ID, newComponentId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLComponent> getChildren() {
		return (EList<FLComponent>)eDynamicGet(BasePackage.FL_COMPONENT__CHILDREN, BasePackage.Literals.FL_COMPONENT__CHILDREN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FL_COMPONENT__COMPONENT_ID:
				return getComponentId();
			case BasePackage.FL_COMPONENT__CHILDREN:
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasePackage.FL_COMPONENT__COMPONENT_ID:
				setComponentId((String)newValue);
				return;
			case BasePackage.FL_COMPONENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends FLComponent>)newValue);
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
			case BasePackage.FL_COMPONENT__COMPONENT_ID:
				setComponentId(COMPONENT_ID_EDEFAULT);
				return;
			case BasePackage.FL_COMPONENT__CHILDREN:
				getChildren().clear();
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
			case BasePackage.FL_COMPONENT__COMPONENT_ID:
				return COMPONENT_ID_EDEFAULT == null ? getComponentId() != null : !COMPONENT_ID_EDEFAULT.equals(getComponentId());
			case BasePackage.FL_COMPONENT__CHILDREN:
				return !getChildren().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FLComponentImpl
