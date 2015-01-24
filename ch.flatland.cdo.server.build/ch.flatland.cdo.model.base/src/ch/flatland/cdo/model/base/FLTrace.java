/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLTrace#getTraceType <em>Trace Type</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLTrace#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLTrace()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface FLTrace extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Trace Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ch.flatland.cdo.model.base.FLTraceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Type</em>' attribute.
	 * @see ch.flatland.cdo.model.base.FLTraceType
	 * @see #setTraceType(FLTraceType)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLTrace_TraceType()
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace'"
	 * @generated
	 */
	FLTraceType getTraceType();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLTrace#getTraceType <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Type</em>' attribute.
	 * @see ch.flatland.cdo.model.base.FLTraceType
	 * @see #getTraceType()
	 * @generated
	 */
	void setTraceType(FLTraceType value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(FLElement)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLTrace_Target()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace'"
	 * @generated
	 */
	FLElement getTarget();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLTrace#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(FLElement value);

} // FLTrace
