/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nameable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.Nameable#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.Nameable#getDescription <em>Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.Nameable#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.Nameable#getNotes <em>Notes</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getNameable()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Nameable extends CDOObject {
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
	 * @see ch.flatland.cdo.model.base.BasePackage#getNameable_Name()
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Named Element'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.Nameable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getNameable_Description()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLMarkdown"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true' propertyCategory='Named Element'"
	 *        annotation="http://www.eclipse.org/CDO/DBStore columnType='CLOB'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.Nameable#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Long Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Description</em>' attribute.
	 * @see #setLongDescription(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getNameable_LongDescription()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLMarkdown"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true' propertyCategory='Named Element'"
	 *        annotation="http://www.eclipse.org/CDO/DBStore columnType='CLOB'"
	 * @generated
	 */
	String getLongDescription();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.Nameable#getLongDescription <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Description</em>' attribute.
	 * @see #getLongDescription()
	 * @generated
	 */
	void setLongDescription(String value);

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' attribute.
	 * @see #setNotes(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getNameable_Notes()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLMarkdown"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true' propertyCategory='Named Element'"
	 *        annotation="http://www.eclipse.org/CDO/DBStore columnType='CLOB'"
	 * @generated
	 */
	String getNotes();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.Nameable#getNotes <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' attribute.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(String value);

} // Nameable
