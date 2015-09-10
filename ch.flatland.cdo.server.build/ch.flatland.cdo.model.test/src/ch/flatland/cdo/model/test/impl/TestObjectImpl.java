/**
 */
package ch.flatland.cdo.model.test.impl;

import ch.flatland.cdo.model.test.TestObject;
import ch.flatland.cdo.model.test.TestPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getMaxlength8 <em>Maxlength8</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getSingleReference <em>Single Reference</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getMultiReferences <em>Multi References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getFixUpperBoundReferences <em>Fix Upper Bound References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getFixBoundReferences <em>Fix Bound References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestObjectImpl#getFixlowerBoundReferences <em>Fixlower Bound References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestObjectImpl extends CDOObjectImpl implements TestObject {
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
	 * The default value of the '{@link #getMaxlength8() <em>Maxlength8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxlength8()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXLENGTH8_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestPackage.Literals.TEST_OBJECT;
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
	public String getName() {
		return (String)eDynamicGet(TestPackage.TEST_OBJECT__NAME, TestPackage.Literals.TEST_OBJECT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(TestPackage.TEST_OBJECT__NAME, TestPackage.Literals.TEST_OBJECT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxlength8() {
		return (String)eDynamicGet(TestPackage.TEST_OBJECT__MAXLENGTH8, TestPackage.Literals.TEST_OBJECT__MAXLENGTH8, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxlength8(String newMaxlength8) {
		eDynamicSet(TestPackage.TEST_OBJECT__MAXLENGTH8, TestPackage.Literals.TEST_OBJECT__MAXLENGTH8, newMaxlength8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestObject getSingleReference() {
		return (TestObject)eDynamicGet(TestPackage.TEST_OBJECT__SINGLE_REFERENCE, TestPackage.Literals.TEST_OBJECT__SINGLE_REFERENCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestObject basicGetSingleReference() {
		return (TestObject)eDynamicGet(TestPackage.TEST_OBJECT__SINGLE_REFERENCE, TestPackage.Literals.TEST_OBJECT__SINGLE_REFERENCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleReference(TestObject newSingleReference) {
		eDynamicSet(TestPackage.TEST_OBJECT__SINGLE_REFERENCE, TestPackage.Literals.TEST_OBJECT__SINGLE_REFERENCE, newSingleReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TestObject> getMultiReferences() {
		return (EList<TestObject>)eDynamicGet(TestPackage.TEST_OBJECT__MULTI_REFERENCES, TestPackage.Literals.TEST_OBJECT__MULTI_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TestObject> getFixUpperBoundReferences() {
		return (EList<TestObject>)eDynamicGet(TestPackage.TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES, TestPackage.Literals.TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TestObject> getFixBoundReferences() {
		return (EList<TestObject>)eDynamicGet(TestPackage.TEST_OBJECT__FIX_BOUND_REFERENCES, TestPackage.Literals.TEST_OBJECT__FIX_BOUND_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TestObject> getFixlowerBoundReferences() {
		return (EList<TestObject>)eDynamicGet(TestPackage.TEST_OBJECT__FIXLOWER_BOUND_REFERENCES, TestPackage.Literals.TEST_OBJECT__FIXLOWER_BOUND_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestPackage.TEST_OBJECT__NAME:
				return getName();
			case TestPackage.TEST_OBJECT__MAXLENGTH8:
				return getMaxlength8();
			case TestPackage.TEST_OBJECT__SINGLE_REFERENCE:
				if (resolve) return getSingleReference();
				return basicGetSingleReference();
			case TestPackage.TEST_OBJECT__MULTI_REFERENCES:
				return getMultiReferences();
			case TestPackage.TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES:
				return getFixUpperBoundReferences();
			case TestPackage.TEST_OBJECT__FIX_BOUND_REFERENCES:
				return getFixBoundReferences();
			case TestPackage.TEST_OBJECT__FIXLOWER_BOUND_REFERENCES:
				return getFixlowerBoundReferences();
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
			case TestPackage.TEST_OBJECT__NAME:
				setName((String)newValue);
				return;
			case TestPackage.TEST_OBJECT__MAXLENGTH8:
				setMaxlength8((String)newValue);
				return;
			case TestPackage.TEST_OBJECT__SINGLE_REFERENCE:
				setSingleReference((TestObject)newValue);
				return;
			case TestPackage.TEST_OBJECT__MULTI_REFERENCES:
				getMultiReferences().clear();
				getMultiReferences().addAll((Collection<? extends TestObject>)newValue);
				return;
			case TestPackage.TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES:
				getFixUpperBoundReferences().clear();
				getFixUpperBoundReferences().addAll((Collection<? extends TestObject>)newValue);
				return;
			case TestPackage.TEST_OBJECT__FIX_BOUND_REFERENCES:
				getFixBoundReferences().clear();
				getFixBoundReferences().addAll((Collection<? extends TestObject>)newValue);
				return;
			case TestPackage.TEST_OBJECT__FIXLOWER_BOUND_REFERENCES:
				getFixlowerBoundReferences().clear();
				getFixlowerBoundReferences().addAll((Collection<? extends TestObject>)newValue);
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
			case TestPackage.TEST_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TestPackage.TEST_OBJECT__MAXLENGTH8:
				setMaxlength8(MAXLENGTH8_EDEFAULT);
				return;
			case TestPackage.TEST_OBJECT__SINGLE_REFERENCE:
				setSingleReference((TestObject)null);
				return;
			case TestPackage.TEST_OBJECT__MULTI_REFERENCES:
				getMultiReferences().clear();
				return;
			case TestPackage.TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES:
				getFixUpperBoundReferences().clear();
				return;
			case TestPackage.TEST_OBJECT__FIX_BOUND_REFERENCES:
				getFixBoundReferences().clear();
				return;
			case TestPackage.TEST_OBJECT__FIXLOWER_BOUND_REFERENCES:
				getFixlowerBoundReferences().clear();
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
			case TestPackage.TEST_OBJECT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case TestPackage.TEST_OBJECT__MAXLENGTH8:
				return MAXLENGTH8_EDEFAULT == null ? getMaxlength8() != null : !MAXLENGTH8_EDEFAULT.equals(getMaxlength8());
			case TestPackage.TEST_OBJECT__SINGLE_REFERENCE:
				return basicGetSingleReference() != null;
			case TestPackage.TEST_OBJECT__MULTI_REFERENCES:
				return !getMultiReferences().isEmpty();
			case TestPackage.TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES:
				return !getFixUpperBoundReferences().isEmpty();
			case TestPackage.TEST_OBJECT__FIX_BOUND_REFERENCES:
				return !getFixBoundReferences().isEmpty();
			case TestPackage.TEST_OBJECT__FIXLOWER_BOUND_REFERENCES:
				return !getFixlowerBoundReferences().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestObjectImpl
