/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getDescription <em>Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraces <em>Traces</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToOwn <em>Trace To Own</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToUse <em>Trace To Use</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToRealize <em>Trace To Realize</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToSpecify <em>Trace To Specify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToImplement <em>Trace To Implement</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToElaborate <em>Trace To Elaborate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToDerive <em>Trace To Derive</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToValidate <em>Trace To Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToTest <em>Trace To Test</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToRelate <em>Trace To Relate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToAffect <em>Trace To Affect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToSatisfy <em>Trace To Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToVerify <em>Trace To Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToRefine <em>Trace To Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceToTrack <em>Trace To Track</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromOwn <em>Trace From Own</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromUse <em>Trace From Use</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromRealize <em>Trace From Realize</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromSpecify <em>Trace From Specify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromImplement <em>Trace From Implement</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromElaborate <em>Trace From Elaborate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromDerive <em>Trace From Derive</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromValidate <em>Trace From Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromTest <em>Trace From Test</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromRelate <em>Trace From Relate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromAffect <em>Trace From Affect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromSatisfy <em>Trace From Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromVerify <em>Trace From Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromRefine <em>Trace From Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraceFromTrack <em>Trace From Track</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface FLElement extends CDOObject {
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
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_Name()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLElement#getName <em>Name</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Markdown formatted description
	 * http://en.wikipedia.org/wiki/Markdown
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_Description()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLTrace> getTraces();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Trace To Own</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Own</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Own</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToOwn()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.OWN);'"
	 * @generated
	 */
	EList<FLElement> getTraceToOwn();

	/**
	 * Returns the value of the '<em><b>Trace To Use</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Use</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Use</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToUse()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.USE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToUse();

	/**
	 * Returns the value of the '<em><b>Trace To Realize</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Realize</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Realize</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToRealize()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.REALIZE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToRealize();

	/**
	 * Returns the value of the '<em><b>Trace To Specify</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Specify</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Specify</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToSpecify()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.SPECIFY);'"
	 * @generated
	 */
	EList<FLElement> getTraceToSpecify();

	/**
	 * Returns the value of the '<em><b>Trace To Implement</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Implement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Implement</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToImplement()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.IMPLEMENT);'"
	 * @generated
	 */
	EList<FLElement> getTraceToImplement();

	/**
	 * Returns the value of the '<em><b>Trace To Elaborate</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Elaborate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Elaborate</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToElaborate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.ELABORATE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToElaborate();

	/**
	 * Returns the value of the '<em><b>Trace To Derive</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Derive</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Derive</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToDerive()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.DERIVE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToDerive();

	/**
	 * Returns the value of the '<em><b>Trace To Validate</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Validate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Validate</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToValidate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.VALIDATE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToValidate();

	/**
	 * Returns the value of the '<em><b>Trace To Test</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Test</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Test</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToTest()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.TEST);'"
	 * @generated
	 */
	EList<FLElement> getTraceToTest();

	/**
	 * Returns the value of the '<em><b>Trace To Relate</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Relate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Relate</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToRelate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.RELATE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToRelate();

	/**
	 * Returns the value of the '<em><b>Trace To Affect</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Affect</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Affect</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToAffect()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.AFFECT);'"
	 * @generated
	 */
	EList<FLElement> getTraceToAffect();

	/**
	 * Returns the value of the '<em><b>Trace To Satisfy</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Satisfy</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Satisfy</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToSatisfy()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.SATISFY);'"
	 * @generated
	 */
	EList<FLElement> getTraceToSatisfy();

	/**
	 * Returns the value of the '<em><b>Trace To Verify</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Verify</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Verify</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToVerify()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.VERIFY);'"
	 * @generated
	 */
	EList<FLElement> getTraceToVerify();

	/**
	 * Returns the value of the '<em><b>Trace To Refine</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Refine</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Refine</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToRefine()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.REFINE);'"
	 * @generated
	 */
	EList<FLElement> getTraceToRefine();

	/**
	 * Returns the value of the '<em><b>Trace To Track</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace To Track</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace To Track</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceToTrack()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLTrace%>> _traces = this.getTraces();\nreturn this.toFilterByType(_traces, <%ch.flatland.cdo.model.base.FLTraceType%>.TRACK);'"
	 * @generated
	 */
	EList<FLElement> getTraceToTrack();

	/**
	 * Returns the value of the '<em><b>Trace From Own</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Own</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Own</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromOwn()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.OWN);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromOwn();

	/**
	 * Returns the value of the '<em><b>Trace From Use</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Use</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Use</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromUse()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.USE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromUse();

	/**
	 * Returns the value of the '<em><b>Trace From Realize</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Realize</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Realize</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromRealize()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.REALIZE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromRealize();

	/**
	 * Returns the value of the '<em><b>Trace From Specify</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Specify</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Specify</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromSpecify()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.SPECIFY);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromSpecify();

	/**
	 * Returns the value of the '<em><b>Trace From Implement</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Implement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Implement</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromImplement()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.IMPLEMENT);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromImplement();

	/**
	 * Returns the value of the '<em><b>Trace From Elaborate</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Elaborate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Elaborate</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromElaborate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.ELABORATE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromElaborate();

	/**
	 * Returns the value of the '<em><b>Trace From Derive</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Derive</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Derive</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromDerive()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.DERIVE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromDerive();

	/**
	 * Returns the value of the '<em><b>Trace From Validate</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Validate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Validate</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromValidate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.VALIDATE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromValidate();

	/**
	 * Returns the value of the '<em><b>Trace From Test</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Test</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Test</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromTest()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.TEST);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromTest();

	/**
	 * Returns the value of the '<em><b>Trace From Relate</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Relate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Relate</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromRelate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.RELATE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromRelate();

	/**
	 * Returns the value of the '<em><b>Trace From Affect</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Affect</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Affect</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromAffect()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.AFFECT);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromAffect();

	/**
	 * Returns the value of the '<em><b>Trace From Satisfy</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Satisfy</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Satisfy</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromSatisfy()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.SATISFY);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromSatisfy();

	/**
	 * Returns the value of the '<em><b>Trace From Verify</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Verify</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Verify</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromVerify()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.VERIFY);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromVerify();

	/**
	 * Returns the value of the '<em><b>Trace From Refine</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Refine</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Refine</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromRefine()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.REFINE);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromRefine();

	/**
	 * Returns the value of the '<em><b>Trace From Track</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace From Track</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace From Track</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_TraceFromTrack()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.fromFilterByType(this, <%ch.flatland.cdo.model.base.FLTraceType%>.TRACK);'"
	 * @generated
	 */
	EList<FLElement> getTraceFromTrack();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Filters the traces to by trace type.
	 * @return filtered list
	 * <!-- end-model-doc -->
	 * @model unique="false" tracesUnique="false" tracesMany="true" traceTypeUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.flatland.cdo.model.base.FLElement%>> targets = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.flatland.cdo.model.base.FLElement%>>();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLTrace%>, <%java.lang.Boolean%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLTrace%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%ch.flatland.cdo.model.base.FLTrace%> it)\n\t{\n\t\t<%ch.flatland.cdo.model.base.FLTraceType%> _traceType = it.getTraceType();\n\t\treturn <%java.lang.Boolean%>.valueOf(<%com.google.common.base.Objects%>.equal(_traceType, traceType));\n\t}\n};\n<%java.lang.Iterable%><<%ch.flatland.cdo.model.base.FLTrace%>> _filter = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%ch.flatland.cdo.model.base.FLTrace%>>filter(traces, _function);\nfinal <%org.eclipse.xtext.xbase.lib.Procedures.Procedure1%><<%ch.flatland.cdo.model.base.FLTrace%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Procedures.Procedure1%><<%ch.flatland.cdo.model.base.FLTrace%>>()\n{\n\tpublic void apply(final <%ch.flatland.cdo.model.base.FLTrace%> it)\n\t{\n\t\t<%ch.flatland.cdo.model.base.FLElement%> _target = it.getTarget();\n\t\ttargets.add(_target);\n\t}\n};\n<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%ch.flatland.cdo.model.base.FLTrace%>>forEach(_filter, _function_1);\nreturn targets;'"
	 * @generated
	 */
	EList<FLElement> toFilterByType(EList<FLTrace> traces, FLTraceType traceType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Filters the traces from by trace type.
	 * @return filtered list
	 * <!-- end-model-doc -->
	 * @model unique="false" instanceUnique="false" traceTypeUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.flatland.cdo.model.base.FLElement%>> sources = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.flatland.cdo.model.base.FLElement%>>();\nboolean _and = false;\n<%org.eclipse.emf.cdo.view.CDOView%> _cdoView = instance.cdoView();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_cdoView, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%org.eclipse.emf.cdo.view.CDOView%> _cdoView_1 = instance.cdoView();\n\tboolean _isClosed = _cdoView_1.isClosed();\n\tboolean _not = (!_isClosed);\n\t_and = _not;\n}\nif (_and)\n{\n\t<%org.eclipse.emf.cdo.view.CDOView%> _cdoView_2 = instance.cdoView();\n\t<%java.util.ArrayList%><<%org.eclipse.emf.ecore.EReference%>> _newArrayList = <%org.eclipse.xtext.xbase.lib.CollectionLiterals%>.<<%org.eclipse.emf.ecore.EReference%>>newArrayList(<%ch.flatland.cdo.model.base.BasePackage.Literals%>.FL_TRACE__TARGET);\n\tfinal <%java.util.List%><<%org.eclipse.emf.cdo.CDOObjectReference%>> xrefs = _cdoView_2.queryXRefs(instance, ((<%org.eclipse.emf.ecore.EReference%>[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_newArrayList, <%org.eclipse.emf.ecore.EReference%>.class)));\n\tfor (final <%org.eclipse.emf.cdo.CDOObjectReference%> x : xrefs)\n\t{\n\t\t{\n\t\t\t<%org.eclipse.emf.cdo.CDOObject%> _sourceObject = x.getSourceObject();\n\t\t\tfinal <%ch.flatland.cdo.model.base.FLTrace%> trace = ((<%ch.flatland.cdo.model.base.FLTrace%>) _sourceObject);\n\t\t\t<%ch.flatland.cdo.model.base.FLTraceType%> _traceType = trace.getTraceType();\n\t\t\tboolean _equals = <%com.google.common.base.Objects%>.equal(_traceType, traceType);\n\t\t\tif (_equals)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.ecore.EObject%> _eContainer = trace.eContainer();\n\t\t\t\tsources.add(((<%ch.flatland.cdo.model.base.FLElement%>) _eContainer));\n\t\t\t}\n\t\t}\n\t}\n}\nreturn sources;'"
	 * @generated
	 */
	EList<FLElement> fromFilterByType(FLElement instance, FLTraceType traceType);

} // FLElement
