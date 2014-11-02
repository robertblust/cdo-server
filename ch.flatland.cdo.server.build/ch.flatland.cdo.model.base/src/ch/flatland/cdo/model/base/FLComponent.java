/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An encapsulation of functionality that is aligned to architectural structuring.
 * Can be further detailed by nesting.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLComponent#getComponentId <em>Component Id</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLComponent#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLComponent()
 * @model
 * @generated
 */
public interface FLComponent extends FLElement {
	/**
	 * Returns the value of the '<em><b>Component Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Technical, machine readable identifier should only contain
	 * characters matching <em><b>^[a-zA-Z0-9_\-\.]*$</em></b>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Id</em>' attribute.
	 * @see #setComponentId(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLComponent_ComponentId()
	 * @model unique="false"
	 * @generated
	 */
	String getComponentId();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLComponent#getComponentId <em>Component Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Id</em>' attribute.
	 * @see #getComponentId()
	 * @generated
	 */
	void setComponentId(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Recursive structure to define hierarchies of components.
	 * Relationship not defined as containment allows restructuring of components.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLComponent_Children()
	 * @model
	 * @generated
	 */
	EList<FLComponent> getChildren();

} // FLComponent
