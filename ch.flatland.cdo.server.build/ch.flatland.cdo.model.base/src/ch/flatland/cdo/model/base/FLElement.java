/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getTraces <em>Traces</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getUpStreamMappings <em>Up Stream Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getDownStreamMappings <em>Down Stream Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getHorizontalMappings <em>Horizontal Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLElement#getHorizontalOppositeMappings <em>Horizontal Opposite Mappings</em>}</li>
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
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement()
 * @model abstract="true"
 * @generated
 */
public interface FLElement extends FLID, FLNameable, FLRateable, FLCommentable, FLHyperLinkable {
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
	 * Returns the value of the '<em><b>Data Provider</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ch.flatland.cdo.model.base.FLDataProvider#getProvidedElements <em>Provided Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider</em>' reference.
	 * @see #setDataProvider(FLDataProvider)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_DataProvider()
	 * @see ch.flatland.cdo.model.base.FLDataProvider#getProvidedElements
	 * @model opposite="providedElements"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Base'"
	 * @generated
	 */
	FLDataProvider getDataProvider();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLElement#getDataProvider <em>Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' reference.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(FLDataProvider value);

	/**
	 * Returns the value of the '<em><b>Up Stream Mappings</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * It is bidirectional and its opposite is '{@link ch.flatland.cdo.model.base.FLElement#getDownStreamMappings <em>Down Stream Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Up Stream Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Up Stream Mappings</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_UpStreamMappings()
	 * @see ch.flatland.cdo.model.base.FLElement#getDownStreamMappings
	 * @model opposite="downStreamMappings"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Mapping'"
	 * @generated
	 */
	EList<FLElement> getUpStreamMappings();

	/**
	 * Returns the value of the '<em><b>Down Stream Mappings</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * It is bidirectional and its opposite is '{@link ch.flatland.cdo.model.base.FLElement#getUpStreamMappings <em>Up Stream Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Down Stream Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Down Stream Mappings</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_DownStreamMappings()
	 * @see ch.flatland.cdo.model.base.FLElement#getUpStreamMappings
	 * @model opposite="upStreamMappings"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Mapping'"
	 * @generated
	 */
	EList<FLElement> getDownStreamMappings();

	/**
	 * Returns the value of the '<em><b>Horizontal Mappings</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * It is bidirectional and its opposite is '{@link ch.flatland.cdo.model.base.FLElement#getHorizontalOppositeMappings <em>Horizontal Opposite Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Horizontal Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Mappings</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_HorizontalMappings()
	 * @see ch.flatland.cdo.model.base.FLElement#getHorizontalOppositeMappings
	 * @model opposite="horizontalOppositeMappings"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Mapping'"
	 * @generated
	 */
	EList<FLElement> getHorizontalMappings();

	/**
	 * Returns the value of the '<em><b>Horizontal Opposite Mappings</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * It is bidirectional and its opposite is '{@link ch.flatland.cdo.model.base.FLElement#getHorizontalMappings <em>Horizontal Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Horizontal Opposite Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Opposite Mappings</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLElement_HorizontalOppositeMappings()
	 * @see ch.flatland.cdo.model.base.FLElement#getHorizontalMappings
	 * @model opposite="horizontalMappings"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Mapping'"
	 * @generated
	 */
	EList<FLElement> getHorizontalOppositeMappings();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace to'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Trace from' property='None'"
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
	 * @model unique="false" traceTypeUnique="false"
	 * @generated
	 */
	EList<FLElement> toFilterByType(FLTraceType traceType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Filters the traces from by trace type.
	 * @return filtered list
	 * <!-- end-model-doc -->
	 * @model unique="false" traceTypeUnique="false"
	 * @generated
	 */
	EList<FLElement> fromFilterByType(FLTraceType traceType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Generic operation to resolve xRefs for an eReference.
	 * Just work when the instance comes from a cdo repository
	 * otherwise an empty list is returned.
	 * </p>
	 * <!-- end-model-doc -->
	 * @model unique="false" many="false" eRefernceUnique="false" classTypeUnique="false"
	 * @generated
	 */
	<T extends EObject> EList<T> resolveXrefs(EReference eRefernce, Class<T> classType);

} // FLElement
