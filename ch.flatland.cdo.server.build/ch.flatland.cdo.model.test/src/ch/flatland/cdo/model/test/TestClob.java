/**
 */
package ch.flatland.cdo.model.test;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clob</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.TestClob#getClob <em>Clob</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.test.TestPackage#getTestClob()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface TestClob extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Clob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clob</em>' attribute.
	 * @see #setClob(byte[])
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestClob_Clob()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Base64Binary"
	 *        annotation="http://www.eclipse.org/CDO/DBStore columnType='CLOB'"
	 * @generated
	 */
	byte[] getClob();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.test.TestClob#getClob <em>Clob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clob</em>' attribute.
	 * @see #getClob()
	 * @generated
	 */
	void setClob(byte[] value);

} // TestClob
