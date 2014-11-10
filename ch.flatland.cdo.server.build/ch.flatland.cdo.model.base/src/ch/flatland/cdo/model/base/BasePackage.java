/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.base.BaseFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel featureDelegation='Dynamic' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' childCreationExtenders='true' editDirectory='/ch.flatland.cdo.model.base.edit/src' modelDirectory='/ch.flatland.cdo.model.base/src' creationIcons='false' basePackage='ch.flatland.cdo.model'"
 * @generated
 */
public interface BasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ch.flatland.cdo.model.base";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "base";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasePackage eINSTANCE = ch.flatland.cdo.model.base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.impl.FLElementImpl <em>FL Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.impl.FLElementImpl
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLElement()
	 * @generated
	 */
	int FL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACES = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__PROPERTIES = 3;

	/**
	 * The number of structural features of the '<em>FL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>FL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.impl.FLComponentImpl <em>FL Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.impl.FLComponentImpl
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLComponent()
	 * @generated
	 */
	int FL_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT__NAME = FL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT__DESCRIPTION = FL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT__TRACES = FL_ELEMENT__TRACES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT__PROPERTIES = FL_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Component Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT__COMPONENT_ID = FL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT__CHILDREN = FL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FL Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT_FEATURE_COUNT = FL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>FL Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_COMPONENT_OPERATION_COUNT = FL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.impl.FLPackageImpl <em>FL Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.impl.FLPackageImpl
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLPackage()
	 * @generated
	 */
	int FL_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__NAME = FL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__DESCRIPTION = FL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACES = FL_ELEMENT__TRACES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__PROPERTIES = FL_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__ELEMENTS = FL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__SUB_PACKAGES = FL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__CONTENTS = FL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FL Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE_FEATURE_COUNT = FL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>FL Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE_OPERATION_COUNT = FL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.impl.FLTraceImpl <em>FL Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.impl.FLTraceImpl
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLTrace()
	 * @generated
	 */
	int FL_TRACE = 3;

	/**
	 * The feature id for the '<em><b>Trace Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_TRACE__TRACE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_TRACE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>FL Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_TRACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>FL Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.impl.FLPropertyImpl <em>FL Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.impl.FLPropertyImpl
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLProperty()
	 * @generated
	 */
	int FL_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>FL Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>FL Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.FLTraceType <em>FL Trace Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.FLTraceType
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLTraceType()
	 * @generated
	 */
	int FL_TRACE_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.base.FLElement <em>FL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FL Element</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement
	 * @generated
	 */
	EClass getFLElement();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.base.FLElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getName()
	 * @see #getFLElement()
	 * @generated
	 */
	EAttribute getFLElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.base.FLElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getDescription()
	 * @see #getFLElement()
	 * @generated
	 */
	EAttribute getFLElement_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraces()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_Traces();

	/**
	 * Returns the meta object for the containment reference list '{@link ch.flatland.cdo.model.base.FLElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getProperties()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_Properties();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.base.FLComponent <em>FL Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FL Component</em>'.
	 * @see ch.flatland.cdo.model.base.FLComponent
	 * @generated
	 */
	EClass getFLComponent();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.base.FLComponent#getComponentId <em>Component Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Id</em>'.
	 * @see ch.flatland.cdo.model.base.FLComponent#getComponentId()
	 * @see #getFLComponent()
	 * @generated
	 */
	EAttribute getFLComponent_ComponentId();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLComponent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see ch.flatland.cdo.model.base.FLComponent#getChildren()
	 * @see #getFLComponent()
	 * @generated
	 */
	EReference getFLComponent_Children();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.base.FLPackage <em>FL Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FL Package</em>'.
	 * @see ch.flatland.cdo.model.base.FLPackage
	 * @generated
	 */
	EClass getFLPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link ch.flatland.cdo.model.base.FLPackage#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see ch.flatland.cdo.model.base.FLPackage#getElements()
	 * @see #getFLPackage()
	 * @generated
	 */
	EReference getFLPackage_Elements();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLPackage#getSubPackages <em>Sub Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Packages</em>'.
	 * @see ch.flatland.cdo.model.base.FLPackage#getSubPackages()
	 * @see #getFLPackage()
	 * @generated
	 */
	EReference getFLPackage_SubPackages();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLPackage#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contents</em>'.
	 * @see ch.flatland.cdo.model.base.FLPackage#getContents()
	 * @see #getFLPackage()
	 * @generated
	 */
	EReference getFLPackage_Contents();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.base.FLTrace <em>FL Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FL Trace</em>'.
	 * @see ch.flatland.cdo.model.base.FLTrace
	 * @generated
	 */
	EClass getFLTrace();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.base.FLTrace#getTraceType <em>Trace Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Type</em>'.
	 * @see ch.flatland.cdo.model.base.FLTrace#getTraceType()
	 * @see #getFLTrace()
	 * @generated
	 */
	EAttribute getFLTrace_TraceType();

	/**
	 * Returns the meta object for the reference '{@link ch.flatland.cdo.model.base.FLTrace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ch.flatland.cdo.model.base.FLTrace#getTarget()
	 * @see #getFLTrace()
	 * @generated
	 */
	EReference getFLTrace_Target();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.base.FLProperty <em>FL Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FL Property</em>'.
	 * @see ch.flatland.cdo.model.base.FLProperty
	 * @generated
	 */
	EClass getFLProperty();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.base.FLProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ch.flatland.cdo.model.base.FLProperty#getName()
	 * @see #getFLProperty()
	 * @generated
	 */
	EAttribute getFLProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.base.FLProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ch.flatland.cdo.model.base.FLProperty#getValue()
	 * @see #getFLProperty()
	 * @generated
	 */
	EAttribute getFLProperty_Value();

	/**
	 * Returns the meta object for enum '{@link ch.flatland.cdo.model.base.FLTraceType <em>FL Trace Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>FL Trace Type</em>'.
	 * @see ch.flatland.cdo.model.base.FLTraceType
	 * @generated
	 */
	EEnum getFLTraceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseFactory getBaseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.base.impl.FLElementImpl <em>FL Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.base.impl.FLElementImpl
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLElement()
		 * @generated
		 */
		EClass FL_ELEMENT = eINSTANCE.getFLElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FL_ELEMENT__NAME = eINSTANCE.getFLElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FL_ELEMENT__DESCRIPTION = eINSTANCE.getFLElement_Description();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACES = eINSTANCE.getFLElement_Traces();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__PROPERTIES = eINSTANCE.getFLElement_Properties();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.base.impl.FLComponentImpl <em>FL Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.base.impl.FLComponentImpl
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLComponent()
		 * @generated
		 */
		EClass FL_COMPONENT = eINSTANCE.getFLComponent();

		/**
		 * The meta object literal for the '<em><b>Component Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FL_COMPONENT__COMPONENT_ID = eINSTANCE.getFLComponent_ComponentId();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_COMPONENT__CHILDREN = eINSTANCE.getFLComponent_Children();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.base.impl.FLPackageImpl <em>FL Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.base.impl.FLPackageImpl
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLPackage()
		 * @generated
		 */
		EClass FL_PACKAGE = eINSTANCE.getFLPackage();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_PACKAGE__ELEMENTS = eINSTANCE.getFLPackage_Elements();

		/**
		 * The meta object literal for the '<em><b>Sub Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_PACKAGE__SUB_PACKAGES = eINSTANCE.getFLPackage_SubPackages();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_PACKAGE__CONTENTS = eINSTANCE.getFLPackage_Contents();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.base.impl.FLTraceImpl <em>FL Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.base.impl.FLTraceImpl
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLTrace()
		 * @generated
		 */
		EClass FL_TRACE = eINSTANCE.getFLTrace();

		/**
		 * The meta object literal for the '<em><b>Trace Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FL_TRACE__TRACE_TYPE = eINSTANCE.getFLTrace_TraceType();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_TRACE__TARGET = eINSTANCE.getFLTrace_Target();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.base.impl.FLPropertyImpl <em>FL Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.base.impl.FLPropertyImpl
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLProperty()
		 * @generated
		 */
		EClass FL_PROPERTY = eINSTANCE.getFLProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FL_PROPERTY__NAME = eINSTANCE.getFLProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FL_PROPERTY__VALUE = eINSTANCE.getFLProperty_Value();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.base.FLTraceType <em>FL Trace Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.base.FLTraceType
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLTraceType()
		 * @generated
		 */
		EEnum FL_TRACE_TYPE = eINSTANCE.getFLTraceType();

	}

} //BasePackage
