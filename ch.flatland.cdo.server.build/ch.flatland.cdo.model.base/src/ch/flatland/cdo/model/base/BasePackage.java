/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel featureDelegation='Dynamic' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' childCreationExtenders='true' extensibleProviderFactory='true' editDirectory='/ch.flatland.cdo.model.base.edit/src' modelDirectory='/ch.flatland.cdo.model.base/src' creationIcons='false' basePackage='ch.flatland.cdo.model'"
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
	 * The feature id for the '<em><b>Trace To Own</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_OWN = 4;

	/**
	 * The feature id for the '<em><b>Trace To Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_USE = 5;

	/**
	 * The feature id for the '<em><b>Trace To Realize</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_REALIZE = 6;

	/**
	 * The feature id for the '<em><b>Trace To Specify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_SPECIFY = 7;

	/**
	 * The feature id for the '<em><b>Trace To Implement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_IMPLEMENT = 8;

	/**
	 * The feature id for the '<em><b>Trace To Elaborate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_ELABORATE = 9;

	/**
	 * The feature id for the '<em><b>Trace To Derive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_DERIVE = 10;

	/**
	 * The feature id for the '<em><b>Trace To Validate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_VALIDATE = 11;

	/**
	 * The feature id for the '<em><b>Trace To Test</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_TEST = 12;

	/**
	 * The feature id for the '<em><b>Trace To Relate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_RELATE = 13;

	/**
	 * The feature id for the '<em><b>Trace To Affect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_AFFECT = 14;

	/**
	 * The feature id for the '<em><b>Trace To Satisfy</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_SATISFY = 15;

	/**
	 * The feature id for the '<em><b>Trace To Verify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_VERIFY = 16;

	/**
	 * The feature id for the '<em><b>Trace To Refine</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_REFINE = 17;

	/**
	 * The feature id for the '<em><b>Trace To Track</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_TO_TRACK = 18;

	/**
	 * The feature id for the '<em><b>Trace From Own</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_OWN = 19;

	/**
	 * The feature id for the '<em><b>Trace From Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_USE = 20;

	/**
	 * The feature id for the '<em><b>Trace From Realize</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_REALIZE = 21;

	/**
	 * The feature id for the '<em><b>Trace From Specify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_SPECIFY = 22;

	/**
	 * The feature id for the '<em><b>Trace From Implement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_IMPLEMENT = 23;

	/**
	 * The feature id for the '<em><b>Trace From Elaborate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_ELABORATE = 24;

	/**
	 * The feature id for the '<em><b>Trace From Derive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_DERIVE = 25;

	/**
	 * The feature id for the '<em><b>Trace From Validate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_VALIDATE = 26;

	/**
	 * The feature id for the '<em><b>Trace From Test</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_TEST = 27;

	/**
	 * The feature id for the '<em><b>Trace From Relate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_RELATE = 28;

	/**
	 * The feature id for the '<em><b>Trace From Affect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_AFFECT = 29;

	/**
	 * The feature id for the '<em><b>Trace From Satisfy</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_SATISFY = 30;

	/**
	 * The feature id for the '<em><b>Trace From Verify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_VERIFY = 31;

	/**
	 * The feature id for the '<em><b>Trace From Refine</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_REFINE = 32;

	/**
	 * The feature id for the '<em><b>Trace From Track</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT__TRACE_FROM_TRACK = 33;

	/**
	 * The number of structural features of the '<em>FL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT_FEATURE_COUNT = 34;

	/**
	 * The operation id for the '<em>To Filter By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT___TO_FILTER_BY_TYPE__FLTRACETYPE = 0;

	/**
	 * The operation id for the '<em>From Filter By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT___FROM_FILTER_BY_TYPE__FLTRACETYPE = 1;

	/**
	 * The number of operations of the '<em>FL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_ELEMENT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.base.impl.FLPackageImpl <em>FL Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.base.impl.FLPackageImpl
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLPackage()
	 * @generated
	 */
	int FL_PACKAGE = 1;

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
	 * The feature id for the '<em><b>Trace To Own</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_OWN = FL_ELEMENT__TRACE_TO_OWN;

	/**
	 * The feature id for the '<em><b>Trace To Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_USE = FL_ELEMENT__TRACE_TO_USE;

	/**
	 * The feature id for the '<em><b>Trace To Realize</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_REALIZE = FL_ELEMENT__TRACE_TO_REALIZE;

	/**
	 * The feature id for the '<em><b>Trace To Specify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_SPECIFY = FL_ELEMENT__TRACE_TO_SPECIFY;

	/**
	 * The feature id for the '<em><b>Trace To Implement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_IMPLEMENT = FL_ELEMENT__TRACE_TO_IMPLEMENT;

	/**
	 * The feature id for the '<em><b>Trace To Elaborate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_ELABORATE = FL_ELEMENT__TRACE_TO_ELABORATE;

	/**
	 * The feature id for the '<em><b>Trace To Derive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_DERIVE = FL_ELEMENT__TRACE_TO_DERIVE;

	/**
	 * The feature id for the '<em><b>Trace To Validate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_VALIDATE = FL_ELEMENT__TRACE_TO_VALIDATE;

	/**
	 * The feature id for the '<em><b>Trace To Test</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_TEST = FL_ELEMENT__TRACE_TO_TEST;

	/**
	 * The feature id for the '<em><b>Trace To Relate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_RELATE = FL_ELEMENT__TRACE_TO_RELATE;

	/**
	 * The feature id for the '<em><b>Trace To Affect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_AFFECT = FL_ELEMENT__TRACE_TO_AFFECT;

	/**
	 * The feature id for the '<em><b>Trace To Satisfy</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_SATISFY = FL_ELEMENT__TRACE_TO_SATISFY;

	/**
	 * The feature id for the '<em><b>Trace To Verify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_VERIFY = FL_ELEMENT__TRACE_TO_VERIFY;

	/**
	 * The feature id for the '<em><b>Trace To Refine</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_REFINE = FL_ELEMENT__TRACE_TO_REFINE;

	/**
	 * The feature id for the '<em><b>Trace To Track</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_TO_TRACK = FL_ELEMENT__TRACE_TO_TRACK;

	/**
	 * The feature id for the '<em><b>Trace From Own</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_OWN = FL_ELEMENT__TRACE_FROM_OWN;

	/**
	 * The feature id for the '<em><b>Trace From Use</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_USE = FL_ELEMENT__TRACE_FROM_USE;

	/**
	 * The feature id for the '<em><b>Trace From Realize</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_REALIZE = FL_ELEMENT__TRACE_FROM_REALIZE;

	/**
	 * The feature id for the '<em><b>Trace From Specify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_SPECIFY = FL_ELEMENT__TRACE_FROM_SPECIFY;

	/**
	 * The feature id for the '<em><b>Trace From Implement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_IMPLEMENT = FL_ELEMENT__TRACE_FROM_IMPLEMENT;

	/**
	 * The feature id for the '<em><b>Trace From Elaborate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_ELABORATE = FL_ELEMENT__TRACE_FROM_ELABORATE;

	/**
	 * The feature id for the '<em><b>Trace From Derive</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_DERIVE = FL_ELEMENT__TRACE_FROM_DERIVE;

	/**
	 * The feature id for the '<em><b>Trace From Validate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_VALIDATE = FL_ELEMENT__TRACE_FROM_VALIDATE;

	/**
	 * The feature id for the '<em><b>Trace From Test</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_TEST = FL_ELEMENT__TRACE_FROM_TEST;

	/**
	 * The feature id for the '<em><b>Trace From Relate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_RELATE = FL_ELEMENT__TRACE_FROM_RELATE;

	/**
	 * The feature id for the '<em><b>Trace From Affect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_AFFECT = FL_ELEMENT__TRACE_FROM_AFFECT;

	/**
	 * The feature id for the '<em><b>Trace From Satisfy</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_SATISFY = FL_ELEMENT__TRACE_FROM_SATISFY;

	/**
	 * The feature id for the '<em><b>Trace From Verify</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_VERIFY = FL_ELEMENT__TRACE_FROM_VERIFY;

	/**
	 * The feature id for the '<em><b>Trace From Refine</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_REFINE = FL_ELEMENT__TRACE_FROM_REFINE;

	/**
	 * The feature id for the '<em><b>Trace From Track</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE__TRACE_FROM_TRACK = FL_ELEMENT__TRACE_FROM_TRACK;

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
	 * The operation id for the '<em>To Filter By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE___TO_FILTER_BY_TYPE__FLTRACETYPE = FL_ELEMENT___TO_FILTER_BY_TYPE__FLTRACETYPE;

	/**
	 * The operation id for the '<em>From Filter By Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FL_PACKAGE___FROM_FILTER_BY_TYPE__FLTRACETYPE = FL_ELEMENT___FROM_FILTER_BY_TYPE__FLTRACETYPE;

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
	int FL_TRACE = 2;

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
	int FL_PROPERTY = 3;

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
	int FL_TRACE_TYPE = 4;


	/**
	 * The meta object id for the '<em>FL Identifier</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLIdentifier()
	 * @generated
	 */
	int FL_IDENTIFIER = 5;

	/**
	 * The meta object id for the '<em>FL Markdown</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLMarkdown()
	 * @generated
	 */
	int FL_MARKDOWN = 6;

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
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToOwn <em>Trace To Own</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Own</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToOwn()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToOwn();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToUse <em>Trace To Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Use</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToUse()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToUse();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToRealize <em>Trace To Realize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Realize</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToRealize()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToRealize();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToSpecify <em>Trace To Specify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Specify</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToSpecify()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToSpecify();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToImplement <em>Trace To Implement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Implement</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToImplement()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToImplement();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToElaborate <em>Trace To Elaborate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Elaborate</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToElaborate()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToElaborate();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToDerive <em>Trace To Derive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Derive</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToDerive()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToDerive();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToValidate <em>Trace To Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Validate</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToValidate()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToValidate();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToTest <em>Trace To Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Test</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToTest()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToTest();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToRelate <em>Trace To Relate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Relate</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToRelate()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToRelate();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToAffect <em>Trace To Affect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Affect</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToAffect()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToAffect();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToSatisfy <em>Trace To Satisfy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Satisfy</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToSatisfy()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToSatisfy();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToVerify <em>Trace To Verify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Verify</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToVerify()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToVerify();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToRefine <em>Trace To Refine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Refine</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToRefine()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToRefine();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceToTrack <em>Trace To Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace To Track</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceToTrack()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceToTrack();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromOwn <em>Trace From Own</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Own</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromOwn()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromOwn();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromUse <em>Trace From Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Use</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromUse()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromUse();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromRealize <em>Trace From Realize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Realize</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromRealize()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromRealize();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromSpecify <em>Trace From Specify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Specify</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromSpecify()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromSpecify();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromImplement <em>Trace From Implement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Implement</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromImplement()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromImplement();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromElaborate <em>Trace From Elaborate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Elaborate</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromElaborate()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromElaborate();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromDerive <em>Trace From Derive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Derive</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromDerive()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromDerive();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromValidate <em>Trace From Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Validate</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromValidate()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromValidate();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromTest <em>Trace From Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Test</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromTest()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromTest();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromRelate <em>Trace From Relate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Relate</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromRelate()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromRelate();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromAffect <em>Trace From Affect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Affect</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromAffect()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromAffect();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromSatisfy <em>Trace From Satisfy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Satisfy</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromSatisfy()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromSatisfy();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromVerify <em>Trace From Verify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Verify</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromVerify()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromVerify();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromRefine <em>Trace From Refine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Refine</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromRefine()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromRefine();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.base.FLElement#getTraceFromTrack <em>Trace From Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace From Track</em>'.
	 * @see ch.flatland.cdo.model.base.FLElement#getTraceFromTrack()
	 * @see #getFLElement()
	 * @generated
	 */
	EReference getFLElement_TraceFromTrack();

	/**
	 * Returns the meta object for the '{@link ch.flatland.cdo.model.base.FLElement#toFilterByType(ch.flatland.cdo.model.base.FLTraceType) <em>To Filter By Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Filter By Type</em>' operation.
	 * @see ch.flatland.cdo.model.base.FLElement#toFilterByType(ch.flatland.cdo.model.base.FLTraceType)
	 * @generated
	 */
	EOperation getFLElement__ToFilterByType__FLTraceType();

	/**
	 * Returns the meta object for the '{@link ch.flatland.cdo.model.base.FLElement#fromFilterByType(ch.flatland.cdo.model.base.FLTraceType) <em>From Filter By Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>From Filter By Type</em>' operation.
	 * @see ch.flatland.cdo.model.base.FLElement#fromFilterByType(ch.flatland.cdo.model.base.FLTraceType)
	 * @generated
	 */
	EOperation getFLElement__FromFilterByType__FLTraceType();

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
	 * Returns the meta object for data type '{@link java.lang.String <em>FL Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>FL Identifier</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='FLIdentifier' pattern='[a-zA-Z0-9_\\-\\.]*'"
	 * @generated
	 */
	EDataType getFLIdentifier();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>FL Markdown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>FL Markdown</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getFLMarkdown();

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
		 * The meta object literal for the '<em><b>Trace To Own</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_OWN = eINSTANCE.getFLElement_TraceToOwn();

		/**
		 * The meta object literal for the '<em><b>Trace To Use</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_USE = eINSTANCE.getFLElement_TraceToUse();

		/**
		 * The meta object literal for the '<em><b>Trace To Realize</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_REALIZE = eINSTANCE.getFLElement_TraceToRealize();

		/**
		 * The meta object literal for the '<em><b>Trace To Specify</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_SPECIFY = eINSTANCE.getFLElement_TraceToSpecify();

		/**
		 * The meta object literal for the '<em><b>Trace To Implement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_IMPLEMENT = eINSTANCE.getFLElement_TraceToImplement();

		/**
		 * The meta object literal for the '<em><b>Trace To Elaborate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_ELABORATE = eINSTANCE.getFLElement_TraceToElaborate();

		/**
		 * The meta object literal for the '<em><b>Trace To Derive</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_DERIVE = eINSTANCE.getFLElement_TraceToDerive();

		/**
		 * The meta object literal for the '<em><b>Trace To Validate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_VALIDATE = eINSTANCE.getFLElement_TraceToValidate();

		/**
		 * The meta object literal for the '<em><b>Trace To Test</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_TEST = eINSTANCE.getFLElement_TraceToTest();

		/**
		 * The meta object literal for the '<em><b>Trace To Relate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_RELATE = eINSTANCE.getFLElement_TraceToRelate();

		/**
		 * The meta object literal for the '<em><b>Trace To Affect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_AFFECT = eINSTANCE.getFLElement_TraceToAffect();

		/**
		 * The meta object literal for the '<em><b>Trace To Satisfy</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_SATISFY = eINSTANCE.getFLElement_TraceToSatisfy();

		/**
		 * The meta object literal for the '<em><b>Trace To Verify</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_VERIFY = eINSTANCE.getFLElement_TraceToVerify();

		/**
		 * The meta object literal for the '<em><b>Trace To Refine</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_REFINE = eINSTANCE.getFLElement_TraceToRefine();

		/**
		 * The meta object literal for the '<em><b>Trace To Track</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_TO_TRACK = eINSTANCE.getFLElement_TraceToTrack();

		/**
		 * The meta object literal for the '<em><b>Trace From Own</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_OWN = eINSTANCE.getFLElement_TraceFromOwn();

		/**
		 * The meta object literal for the '<em><b>Trace From Use</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_USE = eINSTANCE.getFLElement_TraceFromUse();

		/**
		 * The meta object literal for the '<em><b>Trace From Realize</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_REALIZE = eINSTANCE.getFLElement_TraceFromRealize();

		/**
		 * The meta object literal for the '<em><b>Trace From Specify</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_SPECIFY = eINSTANCE.getFLElement_TraceFromSpecify();

		/**
		 * The meta object literal for the '<em><b>Trace From Implement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_IMPLEMENT = eINSTANCE.getFLElement_TraceFromImplement();

		/**
		 * The meta object literal for the '<em><b>Trace From Elaborate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_ELABORATE = eINSTANCE.getFLElement_TraceFromElaborate();

		/**
		 * The meta object literal for the '<em><b>Trace From Derive</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_DERIVE = eINSTANCE.getFLElement_TraceFromDerive();

		/**
		 * The meta object literal for the '<em><b>Trace From Validate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_VALIDATE = eINSTANCE.getFLElement_TraceFromValidate();

		/**
		 * The meta object literal for the '<em><b>Trace From Test</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_TEST = eINSTANCE.getFLElement_TraceFromTest();

		/**
		 * The meta object literal for the '<em><b>Trace From Relate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_RELATE = eINSTANCE.getFLElement_TraceFromRelate();

		/**
		 * The meta object literal for the '<em><b>Trace From Affect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_AFFECT = eINSTANCE.getFLElement_TraceFromAffect();

		/**
		 * The meta object literal for the '<em><b>Trace From Satisfy</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_SATISFY = eINSTANCE.getFLElement_TraceFromSatisfy();

		/**
		 * The meta object literal for the '<em><b>Trace From Verify</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_VERIFY = eINSTANCE.getFLElement_TraceFromVerify();

		/**
		 * The meta object literal for the '<em><b>Trace From Refine</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_REFINE = eINSTANCE.getFLElement_TraceFromRefine();

		/**
		 * The meta object literal for the '<em><b>Trace From Track</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FL_ELEMENT__TRACE_FROM_TRACK = eINSTANCE.getFLElement_TraceFromTrack();

		/**
		 * The meta object literal for the '<em><b>To Filter By Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FL_ELEMENT___TO_FILTER_BY_TYPE__FLTRACETYPE = eINSTANCE.getFLElement__ToFilterByType__FLTraceType();

		/**
		 * The meta object literal for the '<em><b>From Filter By Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FL_ELEMENT___FROM_FILTER_BY_TYPE__FLTRACETYPE = eINSTANCE.getFLElement__FromFilterByType__FLTraceType();

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

		/**
		 * The meta object literal for the '<em>FL Identifier</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLIdentifier()
		 * @generated
		 */
		EDataType FL_IDENTIFIER = eINSTANCE.getFLIdentifier();

		/**
		 * The meta object literal for the '<em>FL Markdown</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ch.flatland.cdo.model.base.impl.BasePackageImpl#getFLMarkdown()
		 * @generated
		 */
		EDataType FL_MARKDOWN = eINSTANCE.getFLMarkdown();

	}

} //BasePackage
