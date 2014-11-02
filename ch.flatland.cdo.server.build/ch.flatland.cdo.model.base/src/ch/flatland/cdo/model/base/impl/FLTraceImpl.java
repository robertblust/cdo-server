/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLTrace;
import ch.flatland.cdo.model.base.FLTraceType;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLTraceImpl#getTraceType <em>Trace Type</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLTraceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FLTraceImpl extends CDOObjectImpl implements FLTrace {
	/**
	 * The default value of the '{@link #getTraceType() <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceType()
	 * @generated
	 * @ordered
	 */
	protected static final FLTraceType TRACE_TYPE_EDEFAULT = FLTraceType.OWNED_BY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_TRACE;
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
	public FLTraceType getTraceType() {
		return (FLTraceType)eDynamicGet(BasePackage.FL_TRACE__TRACE_TYPE, BasePackage.Literals.FL_TRACE__TRACE_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceType(FLTraceType newTraceType) {
		eDynamicSet(BasePackage.FL_TRACE__TRACE_TYPE, BasePackage.Literals.FL_TRACE__TRACE_TYPE, newTraceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLElement getTarget() {
		return (FLElement)eDynamicGet(BasePackage.FL_TRACE__TARGET, BasePackage.Literals.FL_TRACE__TARGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLElement basicGetTarget() {
		return (FLElement)eDynamicGet(BasePackage.FL_TRACE__TARGET, BasePackage.Literals.FL_TRACE__TARGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(FLElement newTarget, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newTarget, BasePackage.FL_TRACE__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(FLElement newTarget) {
		eDynamicSet(BasePackage.FL_TRACE__TARGET, BasePackage.Literals.FL_TRACE__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_TRACE__TARGET:
				FLElement target = basicGetTarget();
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, BasePackage.FL_ELEMENT__TRACES_FROM, FLElement.class, msgs);
				return basicSetTarget((FLElement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_TRACE__TARGET:
				return basicSetTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FL_TRACE__TRACE_TYPE:
				return getTraceType();
			case BasePackage.FL_TRACE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case BasePackage.FL_TRACE__TRACE_TYPE:
				setTraceType((FLTraceType)newValue);
				return;
			case BasePackage.FL_TRACE__TARGET:
				setTarget((FLElement)newValue);
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
			case BasePackage.FL_TRACE__TRACE_TYPE:
				setTraceType(TRACE_TYPE_EDEFAULT);
				return;
			case BasePackage.FL_TRACE__TARGET:
				setTarget((FLElement)null);
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
			case BasePackage.FL_TRACE__TRACE_TYPE:
				return getTraceType() != TRACE_TYPE_EDEFAULT;
			case BasePackage.FL_TRACE__TARGET:
				return basicGetTarget() != null;
		}
		return super.eIsSet(featureID);
	}

} //FLTraceImpl
