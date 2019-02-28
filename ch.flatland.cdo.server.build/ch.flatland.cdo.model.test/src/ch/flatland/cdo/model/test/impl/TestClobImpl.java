/**
 */
package ch.flatland.cdo.model.test.impl;

import ch.flatland.cdo.model.test.TestClob;
import ch.flatland.cdo.model.test.TestPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clob</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestClobImpl#getClob <em>Clob</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestClobImpl extends CDOObjectImpl implements TestClob {
	/**
	 * The default value of the '{@link #getClob() <em>Clob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClob()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] CLOB_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestClobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestPackage.Literals.TEST_CLOB;
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
	public byte[] getClob() {
		return (byte[])eDynamicGet(TestPackage.TEST_CLOB__CLOB, TestPackage.Literals.TEST_CLOB__CLOB, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClob(byte[] newClob) {
		eDynamicSet(TestPackage.TEST_CLOB__CLOB, TestPackage.Literals.TEST_CLOB__CLOB, newClob);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestPackage.TEST_CLOB__CLOB:
				return getClob();
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
			case TestPackage.TEST_CLOB__CLOB:
				setClob((byte[])newValue);
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
			case TestPackage.TEST_CLOB__CLOB:
				setClob(CLOB_EDEFAULT);
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
			case TestPackage.TEST_CLOB__CLOB:
				return CLOB_EDEFAULT == null ? getClob() != null : !CLOB_EDEFAULT.equals(getClob());
		}
		return super.eIsSet(featureID);
	}

} //TestClobImpl
