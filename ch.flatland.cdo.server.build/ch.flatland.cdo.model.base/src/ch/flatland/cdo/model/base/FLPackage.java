/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLPackage#getElements <em>Elements</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLPackage#getSubPackages <em>Sub Packages</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLPackage#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage()
 * @model
 * @generated
 */
public interface FLPackage extends FLElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLElement> getElements();

	/**
	 * Returns the value of the '<em><b>Sub Packages</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Packages</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage_SubPackages()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Package'"
	 * @generated
	 */
	EList<FLPackage> getSubPackages();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage_Contents()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Package'"
	 * @generated
	 */
	EList<FLElement> getContents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	EList<FLPackage> filterSubPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	EList<FLElement> filterContents();

} // FLPackage
