/**
 */
package ch.flatland.cdo.model.test;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.TestObject#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.TestObject#getSingleReference <em>Single Reference</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.TestObject#getMultiReferences <em>Multi References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.TestObject#getFixUpperBoundReferences <em>Fix Upper Bound References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.TestObject#getFixBoundReferences <em>Fix Bound References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.TestObject#getFixlowerBoundReferences <em>Fixlower Bound References</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface TestObject extends CDOObject {
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
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.test.TestObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Single Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Reference</em>' reference.
	 * @see #setSingleReference(TestObject)
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject_SingleReference()
	 * @model
	 * @generated
	 */
	TestObject getSingleReference();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.test.TestObject#getSingleReference <em>Single Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Reference</em>' reference.
	 * @see #getSingleReference()
	 * @generated
	 */
	void setSingleReference(TestObject value);

	/**
	 * Returns the value of the '<em><b>Multi References</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.test.TestObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi References</em>' reference list.
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject_MultiReferences()
	 * @model
	 * @generated
	 */
	EList<TestObject> getMultiReferences();

	/**
	 * Returns the value of the '<em><b>Fix Upper Bound References</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.test.TestObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fix Upper Bound References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fix Upper Bound References</em>' reference list.
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject_FixUpperBoundReferences()
	 * @model upper="2"
	 * @generated
	 */
	EList<TestObject> getFixUpperBoundReferences();

	/**
	 * Returns the value of the '<em><b>Fix Bound References</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.test.TestObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fix Bound References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fix Bound References</em>' reference list.
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject_FixBoundReferences()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<TestObject> getFixBoundReferences();

	/**
	 * Returns the value of the '<em><b>Fixlower Bound References</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.test.TestObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixlower Bound References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixlower Bound References</em>' reference list.
	 * @see ch.flatland.cdo.model.test.TestPackage#getTestObject_FixlowerBoundReferences()
	 * @model required="true" upper="2"
	 * @generated
	 */
	EList<TestObject> getFixlowerBoundReferences();

} // TestObject
