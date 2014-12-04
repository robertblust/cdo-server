/**
 */
package ch.flatland.cdo.model.test;

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
 * @see ch.flatland.cdo.model.test.TestFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel featureDelegation='Dynamic' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' childCreationExtenders='true' editDirectory='/ch.flatland.cdo.model.test.edit/src' modelDirectory='/ch.flatland.cdo.model.test/src' creationIcons='false' basePackage='ch.flatland.cdo.model'"
 * @generated
 */
public interface TestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "test";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ch.flatland.cdo.model.test";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "test";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestPackage eINSTANCE = ch.flatland.cdo.model.test.impl.TestPackageImpl.init();

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl <em>Simple Data Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getSimpleDataTypes()
	 * @generated
	 */
	int SIMPLE_DATA_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Test String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_STRING = 0;

	/**
	 * The feature id for the '<em><b>Test Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BOOLEAN = 1;

	/**
	 * The feature id for the '<em><b>Test Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_INT = 2;

	/**
	 * The feature id for the '<em><b>Test Long</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_LONG = 3;

	/**
	 * The feature id for the '<em><b>Test Short</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_SHORT = 4;

	/**
	 * The feature id for the '<em><b>Test Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_DOUBLE = 5;

	/**
	 * The feature id for the '<em><b>Test Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_FLOAT = 6;

	/**
	 * The feature id for the '<em><b>Test Byte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BYTE = 7;

	/**
	 * The feature id for the '<em><b>Test Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_CHAR = 8;

	/**
	 * The feature id for the '<em><b>Test Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_DATE = 9;

	/**
	 * The feature id for the '<em><b>Test Big Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL = 10;

	/**
	 * The feature id for the '<em><b>Test Big Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BIG_INTEGER = 11;

	/**
	 * The feature id for the '<em><b>Test Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_ENUM = 12;

	/**
	 * The number of structural features of the '<em>Simple Data Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Simple Data Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesAsArrayImpl <em>Simple Data Types As Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.test.impl.SimpleDataTypesAsArrayImpl
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getSimpleDataTypesAsArray()
	 * @generated
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY = 1;

	/**
	 * The feature id for the '<em><b>Test String</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_STRING = 0;

	/**
	 * The feature id for the '<em><b>Test Boolean</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BOOLEAN = 1;

	/**
	 * The feature id for the '<em><b>Test Int</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_INT = 2;

	/**
	 * The feature id for the '<em><b>Test Long</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_LONG = 3;

	/**
	 * The feature id for the '<em><b>Test Short</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_SHORT = 4;

	/**
	 * The feature id for the '<em><b>Test Double</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DOUBLE = 5;

	/**
	 * The feature id for the '<em><b>Test Float</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_FLOAT = 6;

	/**
	 * The feature id for the '<em><b>Test Byte</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BYTE = 7;

	/**
	 * The feature id for the '<em><b>Test Char</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_CHAR = 8;

	/**
	 * The feature id for the '<em><b>Test Date</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DATE = 9;

	/**
	 * The feature id for the '<em><b>Test Big Decimal</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_DECIMAL = 10;

	/**
	 * The feature id for the '<em><b>Test Big Integer</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_INTEGER = 11;

	/**
	 * The feature id for the '<em><b>Test Enum</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY__TEST_ENUM = 12;

	/**
	 * The number of structural features of the '<em>Simple Data Types As Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Simple Data Types As Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_AS_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.test.impl.TestObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.test.impl.TestObjectImpl
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestObject()
	 * @generated
	 */
	int TEST_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Single Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__SINGLE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Multi References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__MULTI_REFERENCES = 2;

	/**
	 * The feature id for the '<em><b>Fix Upper Bound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES = 3;

	/**
	 * The feature id for the '<em><b>Fix Bound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__FIX_BOUND_REFERENCES = 4;

	/**
	 * The feature id for the '<em><b>Fixlower Bound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__FIXLOWER_BOUND_REFERENCES = 5;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.test.impl.TestBlobImpl <em>Blob</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.test.impl.TestBlobImpl
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestBlob()
	 * @generated
	 */
	int TEST_BLOB = 3;

	/**
	 * The feature id for the '<em><b>Blob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_BLOB__BLOB = 0;

	/**
	 * The number of structural features of the '<em>Blob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_BLOB_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Blob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_BLOB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.test.TestEnum <em>Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.test.TestEnum
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestEnum()
	 * @generated
	 */
	int TEST_ENUM = 4;


	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.test.SimpleDataTypes <em>Simple Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Data Types</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes
	 * @generated
	 */
	EClass getSimpleDataTypes();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestString <em>Test String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test String</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestString()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestString();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#isTestBoolean <em>Test Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Boolean</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#isTestBoolean()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestBoolean();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestInt <em>Test Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Int</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestInt()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestInt();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestLong <em>Test Long</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Long</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestLong()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestLong();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestShort <em>Test Short</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Short</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestShort()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestShort();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestDouble <em>Test Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Double</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestDouble()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestDouble();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestFloat <em>Test Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Float</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestFloat()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestFloat();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestByte <em>Test Byte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Byte</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestByte()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestByte();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestChar <em>Test Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Char</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestChar()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestChar();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestDate <em>Test Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Date</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestDate()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestDate();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestBigDecimal <em>Test Big Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Big Decimal</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestBigDecimal()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestBigDecimal();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestBigInteger <em>Test Big Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Big Integer</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestBigInteger()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestBigInteger();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestEnum <em>Test Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Enum</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestEnum()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestEnum();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray <em>Simple Data Types As Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Data Types As Array</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray
	 * @generated
	 */
	EClass getSimpleDataTypesAsArray();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestString <em>Test String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test String</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestString()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestString();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestBoolean <em>Test Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Boolean</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestBoolean()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestBoolean();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestInt <em>Test Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Int</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestInt()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestInt();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestLong <em>Test Long</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Long</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestLong()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestLong();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestShort <em>Test Short</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Short</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestShort()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestShort();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestDouble <em>Test Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Double</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestDouble()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestDouble();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestFloat <em>Test Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Float</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestFloat()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestFloat();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestByte <em>Test Byte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Byte</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestByte()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestByte();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestChar <em>Test Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Char</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestChar()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestChar();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestDate <em>Test Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Date</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestDate()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestDate();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestBigDecimal <em>Test Big Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Big Decimal</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestBigDecimal()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestBigDecimal();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestBigInteger <em>Test Big Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Big Integer</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestBigInteger()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestBigInteger();

	/**
	 * Returns the meta object for the attribute list '{@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestEnum <em>Test Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Test Enum</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypesAsArray#getTestEnum()
	 * @see #getSimpleDataTypesAsArray()
	 * @generated
	 */
	EAttribute getSimpleDataTypesAsArray_TestEnum();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.test.TestObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject
	 * @generated
	 */
	EClass getTestObject();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.TestObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getName()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Name();

	/**
	 * Returns the meta object for the reference '{@link ch.flatland.cdo.model.test.TestObject#getSingleReference <em>Single Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Reference</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getSingleReference()
	 * @see #getTestObject()
	 * @generated
	 */
	EReference getTestObject_SingleReference();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.test.TestObject#getMultiReferences <em>Multi References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multi References</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getMultiReferences()
	 * @see #getTestObject()
	 * @generated
	 */
	EReference getTestObject_MultiReferences();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.test.TestObject#getFixUpperBoundReferences <em>Fix Upper Bound References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fix Upper Bound References</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getFixUpperBoundReferences()
	 * @see #getTestObject()
	 * @generated
	 */
	EReference getTestObject_FixUpperBoundReferences();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.test.TestObject#getFixBoundReferences <em>Fix Bound References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fix Bound References</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getFixBoundReferences()
	 * @see #getTestObject()
	 * @generated
	 */
	EReference getTestObject_FixBoundReferences();

	/**
	 * Returns the meta object for the reference list '{@link ch.flatland.cdo.model.test.TestObject#getFixlowerBoundReferences <em>Fixlower Bound References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fixlower Bound References</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getFixlowerBoundReferences()
	 * @see #getTestObject()
	 * @generated
	 */
	EReference getTestObject_FixlowerBoundReferences();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.test.TestBlob <em>Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blob</em>'.
	 * @see ch.flatland.cdo.model.test.TestBlob
	 * @generated
	 */
	EClass getTestBlob();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.TestBlob#getBlob <em>Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blob</em>'.
	 * @see ch.flatland.cdo.model.test.TestBlob#getBlob()
	 * @see #getTestBlob()
	 * @generated
	 */
	EAttribute getTestBlob_Blob();

	/**
	 * Returns the meta object for enum '{@link ch.flatland.cdo.model.test.TestEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum</em>'.
	 * @see ch.flatland.cdo.model.test.TestEnum
	 * @generated
	 */
	EEnum getTestEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestFactory getTestFactory();

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
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl <em>Simple Data Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getSimpleDataTypes()
		 * @generated
		 */
		EClass SIMPLE_DATA_TYPES = eINSTANCE.getSimpleDataTypes();

		/**
		 * The meta object literal for the '<em><b>Test String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_STRING = eINSTANCE.getSimpleDataTypes_TestString();

		/**
		 * The meta object literal for the '<em><b>Test Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BOOLEAN = eINSTANCE.getSimpleDataTypes_TestBoolean();

		/**
		 * The meta object literal for the '<em><b>Test Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_INT = eINSTANCE.getSimpleDataTypes_TestInt();

		/**
		 * The meta object literal for the '<em><b>Test Long</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_LONG = eINSTANCE.getSimpleDataTypes_TestLong();

		/**
		 * The meta object literal for the '<em><b>Test Short</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_SHORT = eINSTANCE.getSimpleDataTypes_TestShort();

		/**
		 * The meta object literal for the '<em><b>Test Double</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_DOUBLE = eINSTANCE.getSimpleDataTypes_TestDouble();

		/**
		 * The meta object literal for the '<em><b>Test Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_FLOAT = eINSTANCE.getSimpleDataTypes_TestFloat();

		/**
		 * The meta object literal for the '<em><b>Test Byte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BYTE = eINSTANCE.getSimpleDataTypes_TestByte();

		/**
		 * The meta object literal for the '<em><b>Test Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_CHAR = eINSTANCE.getSimpleDataTypes_TestChar();

		/**
		 * The meta object literal for the '<em><b>Test Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_DATE = eINSTANCE.getSimpleDataTypes_TestDate();

		/**
		 * The meta object literal for the '<em><b>Test Big Decimal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL = eINSTANCE.getSimpleDataTypes_TestBigDecimal();

		/**
		 * The meta object literal for the '<em><b>Test Big Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BIG_INTEGER = eINSTANCE.getSimpleDataTypes_TestBigInteger();

		/**
		 * The meta object literal for the '<em><b>Test Enum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_ENUM = eINSTANCE.getSimpleDataTypes_TestEnum();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesAsArrayImpl <em>Simple Data Types As Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.impl.SimpleDataTypesAsArrayImpl
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getSimpleDataTypesAsArray()
		 * @generated
		 */
		EClass SIMPLE_DATA_TYPES_AS_ARRAY = eINSTANCE.getSimpleDataTypesAsArray();

		/**
		 * The meta object literal for the '<em><b>Test String</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_STRING = eINSTANCE.getSimpleDataTypesAsArray_TestString();

		/**
		 * The meta object literal for the '<em><b>Test Boolean</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BOOLEAN = eINSTANCE.getSimpleDataTypesAsArray_TestBoolean();

		/**
		 * The meta object literal for the '<em><b>Test Int</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_INT = eINSTANCE.getSimpleDataTypesAsArray_TestInt();

		/**
		 * The meta object literal for the '<em><b>Test Long</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_LONG = eINSTANCE.getSimpleDataTypesAsArray_TestLong();

		/**
		 * The meta object literal for the '<em><b>Test Short</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_SHORT = eINSTANCE.getSimpleDataTypesAsArray_TestShort();

		/**
		 * The meta object literal for the '<em><b>Test Double</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DOUBLE = eINSTANCE.getSimpleDataTypesAsArray_TestDouble();

		/**
		 * The meta object literal for the '<em><b>Test Float</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_FLOAT = eINSTANCE.getSimpleDataTypesAsArray_TestFloat();

		/**
		 * The meta object literal for the '<em><b>Test Byte</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BYTE = eINSTANCE.getSimpleDataTypesAsArray_TestByte();

		/**
		 * The meta object literal for the '<em><b>Test Char</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_CHAR = eINSTANCE.getSimpleDataTypesAsArray_TestChar();

		/**
		 * The meta object literal for the '<em><b>Test Date</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DATE = eINSTANCE.getSimpleDataTypesAsArray_TestDate();

		/**
		 * The meta object literal for the '<em><b>Test Big Decimal</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_DECIMAL = eINSTANCE.getSimpleDataTypesAsArray_TestBigDecimal();

		/**
		 * The meta object literal for the '<em><b>Test Big Integer</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_INTEGER = eINSTANCE.getSimpleDataTypesAsArray_TestBigInteger();

		/**
		 * The meta object literal for the '<em><b>Test Enum</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES_AS_ARRAY__TEST_ENUM = eINSTANCE.getSimpleDataTypesAsArray_TestEnum();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.impl.TestObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.impl.TestObjectImpl
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestObject()
		 * @generated
		 */
		EClass TEST_OBJECT = eINSTANCE.getTestObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_OBJECT__NAME = eINSTANCE.getTestObject_Name();

		/**
		 * The meta object literal for the '<em><b>Single Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_OBJECT__SINGLE_REFERENCE = eINSTANCE.getTestObject_SingleReference();

		/**
		 * The meta object literal for the '<em><b>Multi References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_OBJECT__MULTI_REFERENCES = eINSTANCE.getTestObject_MultiReferences();

		/**
		 * The meta object literal for the '<em><b>Fix Upper Bound References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES = eINSTANCE.getTestObject_FixUpperBoundReferences();

		/**
		 * The meta object literal for the '<em><b>Fix Bound References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_OBJECT__FIX_BOUND_REFERENCES = eINSTANCE.getTestObject_FixBoundReferences();

		/**
		 * The meta object literal for the '<em><b>Fixlower Bound References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_OBJECT__FIXLOWER_BOUND_REFERENCES = eINSTANCE.getTestObject_FixlowerBoundReferences();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.impl.TestBlobImpl <em>Blob</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.impl.TestBlobImpl
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestBlob()
		 * @generated
		 */
		EClass TEST_BLOB = eINSTANCE.getTestBlob();

		/**
		 * The meta object literal for the '<em><b>Blob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_BLOB__BLOB = eINSTANCE.getTestBlob_Blob();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.TestEnum <em>Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.TestEnum
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestEnum()
		 * @generated
		 */
		EEnum TEST_ENUM = eINSTANCE.getTestEnum();

	}

} //TestPackage
