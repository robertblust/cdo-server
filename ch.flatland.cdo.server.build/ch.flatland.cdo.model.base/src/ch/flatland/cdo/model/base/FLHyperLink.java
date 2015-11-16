/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Hyper Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLHyperLink#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLHyperLink#getHyperLink <em>Hyper Link</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLHyperLink()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface FLHyperLink extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLHyperLink_Name()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Hyper Link'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLHyperLink#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Hyper Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hyper Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hyper Link</em>' attribute.
	 * @see #setHyperLink(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLHyperLink_HyperLink()
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Hyper Link'"
	 * @generated
	 */
	String getHyperLink();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLHyperLink#getHyperLink <em>Hyper Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hyper Link</em>' attribute.
	 * @see #getHyperLink()
	 * @generated
	 */
	void setHyperLink(String value);

} // FLHyperLink
