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
 *   <li>{@link ch.flatland.cdo.model.base.FLComponent#getAggregates <em>Aggregates</em>}</li>
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
	 *  technical, machine readable identifier
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Id</em>' attribute.
	 * @see #setComponentId(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLComponent_ComponentId()
	 * @model unique="false" required="true"
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
	 * Returns the value of the '<em><b>Aggregates</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregates</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLComponent_Aggregates()
	 * @model
	 * @generated
	 */
	EList<FLComponent> getAggregates();

} // FLComponent
