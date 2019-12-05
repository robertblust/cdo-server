/**
 */
package ch.flatland.cdo.model.test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 *        annotation="http://www.eclipse.org/emf/2011/Xcore DBStore='http://www.eclipse.org/CDO/DBStore'"
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
	 * The feature id for the '<em><b>Test Boolean Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Test Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_INT = 3;

	/**
	 * The feature id for the '<em><b>Test Int Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_INT_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Test Long</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_LONG = 5;

	/**
	 * The feature id for the '<em><b>Test Long Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_LONG_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Test Short</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_SHORT = 7;

	/**
	 * The feature id for the '<em><b>Test Short Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT = 8;

	/**
	 * The feature id for the '<em><b>Test Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_DOUBLE = 9;

	/**
	 * The feature id for the '<em><b>Test Double Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT = 10;

	/**
	 * The feature id for the '<em><b>Test Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_FLOAT = 11;

	/**
	 * The feature id for the '<em><b>Test Float Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT = 12;

	/**
	 * The feature id for the '<em><b>Test Byte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BYTE = 13;

	/**
	 * The feature id for the '<em><b>Test Byte Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT = 14;

	/**
	 * The feature id for the '<em><b>Test Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_CHAR = 15;

	/**
	 * The feature id for the '<em><b>Test Char Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT = 16;

	/**
	 * The feature id for the '<em><b>Test Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_DATE = 17;

	/**
	 * The feature id for the '<em><b>Test Big Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL = 18;

	/**
	 * The feature id for the '<em><b>Test Big Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_BIG_INTEGER = 19;

	/**
	 * The feature id for the '<em><b>Test Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES__TEST_ENUM = 20;

	/**
	 * The number of structural features of the '<em>Simple Data Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_TYPES_FEATURE_COUNT = 21;

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
	 * The feature id for the '<em><b>Maxlength8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__MAXLENGTH8 = 1;

	/**
	 * The feature id for the '<em><b>Single Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__SINGLE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Multi References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__MULTI_REFERENCES = 3;

	/**
	 * The feature id for the '<em><b>Fix Upper Bound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES = 4;

	/**
	 * The feature id for the '<em><b>Fix Bound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__FIX_BOUND_REFERENCES = 5;

	/**
	 * The feature id for the '<em><b>Fixlower Bound References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__FIXLOWER_BOUND_REFERENCES = 6;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.test.impl.TestClobImpl <em>Clob</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.test.impl.TestClobImpl
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestClob()
	 * @generated
	 */
	int TEST_CLOB = 3;

	/**
	 * The feature id for the '<em><b>Clob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLOB__CLOB = 0;

	/**
	 * The number of structural features of the '<em>Clob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLOB_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Clob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLOB_OPERATION_COUNT = 0;

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
	 * The meta object id for the '<em>Maxlength8</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getMaxlength8()
	 * @generated
	 */
	int MAXLENGTH8 = 5;

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestBooleanObject <em>Test Boolean Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Boolean Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestBooleanObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestBooleanObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestIntObject <em>Test Int Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Int Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestIntObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestIntObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestLongObject <em>Test Long Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Long Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestLongObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestLongObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestShortObject <em>Test Short Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Short Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestShortObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestShortObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestDoubleObject <em>Test Double Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Double Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestDoubleObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestDoubleObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestFloatObject <em>Test Float Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Float Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestFloatObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestFloatObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestByteObject <em>Test Byte Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Byte Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestByteObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestByteObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.SimpleDataTypes#getTestCharObject <em>Test Char Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Char Object</em>'.
	 * @see ch.flatland.cdo.model.test.SimpleDataTypes#getTestCharObject()
	 * @see #getSimpleDataTypes()
	 * @generated
	 */
	EAttribute getSimpleDataTypes_TestCharObject();

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
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.TestObject#getMaxlength8 <em>Maxlength8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maxlength8</em>'.
	 * @see ch.flatland.cdo.model.test.TestObject#getMaxlength8()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Maxlength8();

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
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.test.TestClob <em>Clob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clob</em>'.
	 * @see ch.flatland.cdo.model.test.TestClob
	 * @generated
	 */
	EClass getTestClob();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.test.TestClob#getClob <em>Clob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clob</em>'.
	 * @see ch.flatland.cdo.model.test.TestClob#getClob()
	 * @see #getTestClob()
	 * @generated
	 */
	EAttribute getTestClob_Clob();

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
	 * Returns the meta object for data type '{@link java.lang.String <em>Maxlength8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Maxlength8</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Maxlength8' maxLength='8'"
	 * @generated
	 */
	EDataType getMaxlength8();

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
		 * The meta object literal for the '<em><b>Test Boolean Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT = eINSTANCE.getSimpleDataTypes_TestBooleanObject();

		/**
		 * The meta object literal for the '<em><b>Test Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_INT = eINSTANCE.getSimpleDataTypes_TestInt();

		/**
		 * The meta object literal for the '<em><b>Test Int Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_INT_OBJECT = eINSTANCE.getSimpleDataTypes_TestIntObject();

		/**
		 * The meta object literal for the '<em><b>Test Long</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_LONG = eINSTANCE.getSimpleDataTypes_TestLong();

		/**
		 * The meta object literal for the '<em><b>Test Long Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_LONG_OBJECT = eINSTANCE.getSimpleDataTypes_TestLongObject();

		/**
		 * The meta object literal for the '<em><b>Test Short</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_SHORT = eINSTANCE.getSimpleDataTypes_TestShort();

		/**
		 * The meta object literal for the '<em><b>Test Short Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT = eINSTANCE.getSimpleDataTypes_TestShortObject();

		/**
		 * The meta object literal for the '<em><b>Test Double</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_DOUBLE = eINSTANCE.getSimpleDataTypes_TestDouble();

		/**
		 * The meta object literal for the '<em><b>Test Double Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT = eINSTANCE.getSimpleDataTypes_TestDoubleObject();

		/**
		 * The meta object literal for the '<em><b>Test Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_FLOAT = eINSTANCE.getSimpleDataTypes_TestFloat();

		/**
		 * The meta object literal for the '<em><b>Test Float Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT = eINSTANCE.getSimpleDataTypes_TestFloatObject();

		/**
		 * The meta object literal for the '<em><b>Test Byte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BYTE = eINSTANCE.getSimpleDataTypes_TestByte();

		/**
		 * The meta object literal for the '<em><b>Test Byte Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT = eINSTANCE.getSimpleDataTypes_TestByteObject();

		/**
		 * The meta object literal for the '<em><b>Test Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_CHAR = eINSTANCE.getSimpleDataTypes_TestChar();

		/**
		 * The meta object literal for the '<em><b>Test Char Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT = eINSTANCE.getSimpleDataTypes_TestCharObject();

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
		 * The meta object literal for the '<em><b>Maxlength8</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_OBJECT__MAXLENGTH8 = eINSTANCE.getTestObject_Maxlength8();

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
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.impl.TestClobImpl <em>Clob</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.impl.TestClobImpl
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestClob()
		 * @generated
		 */
		EClass TEST_CLOB = eINSTANCE.getTestClob();

		/**
		 * The meta object literal for the '<em><b>Clob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CLOB__CLOB = eINSTANCE.getTestClob_Clob();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.test.TestEnum <em>Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.test.TestEnum
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getTestEnum()
		 * @generated
		 */
		EEnum TEST_ENUM = eINSTANCE.getTestEnum();

		/**
		 * The meta object literal for the '<em>Maxlength8</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ch.flatland.cdo.model.test.impl.TestPackageImpl#getMaxlength8()
		 * @generated
		 */
		EDataType MAXLENGTH8 = eINSTANCE.getMaxlength8();

	}

} //TestPackage
