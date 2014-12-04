/**
 */
package ch.flatland.cdo.model.test;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blob</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.TestBlob#getBlob <em>Blob</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.test.TestPackage#getTestBlob()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface TestBlob extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Blob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blob</em>' attribute.
	 * @see #setBlob(byte[])
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestBlob_Blob()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Base64Binary"
	 * @generated
	 */
	byte[] getBlob();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.test.TestBlob#getBlob <em>Blob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blob</em>' attribute.
	 * @see #getBlob()
	 * @generated
	 */
	void setBlob(byte[] value);

} // TestBlob
