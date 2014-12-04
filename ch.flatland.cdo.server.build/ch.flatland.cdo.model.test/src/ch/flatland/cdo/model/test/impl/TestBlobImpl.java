/**
 */
package ch.flatland.cdo.model.test.impl;

import ch.flatland.cdo.model.test.TestBlob;
import ch.flatland.cdo.model.test.TestPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blob</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.impl.TestBlobImpl#getBlob <em>Blob</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestBlobImpl extends CDOObjectImpl implements TestBlob {
	/**
	 * The default value of the '{@link #getBlob() <em>Blob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlob()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] BLOB_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestBlobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestPackage.Literals.TEST_BLOB;
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
	public byte[] getBlob() {
		return (byte[])eDynamicGet(TestPackage.TEST_BLOB__BLOB, TestPackage.Literals.TEST_BLOB__BLOB, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlob(byte[] newBlob) {
		eDynamicSet(TestPackage.TEST_BLOB__BLOB, TestPackage.Literals.TEST_BLOB__BLOB, newBlob);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestPackage.TEST_BLOB__BLOB:
				return getBlob();
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
			case TestPackage.TEST_BLOB__BLOB:
				setBlob((byte[])newValue);
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
			case TestPackage.TEST_BLOB__BLOB:
				setBlob(BLOB_EDEFAULT);
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
			case TestPackage.TEST_BLOB__BLOB:
				return BLOB_EDEFAULT == null ? getBlob() != null : !BLOB_EDEFAULT.equals(getBlob());
		}
		return super.eIsSet(featureID);
	}

} //TestBlobImpl
