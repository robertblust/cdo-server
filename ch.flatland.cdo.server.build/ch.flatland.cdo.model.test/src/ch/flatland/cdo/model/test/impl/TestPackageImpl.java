/**
 */
package ch.flatland.cdo.model.test.impl;

import ch.flatland.cdo.model.test.SimpleDataTypes;
import ch.flatland.cdo.model.test.SimpleDataTypesAsArray;
import ch.flatland.cdo.model.test.TestClob;
import ch.flatland.cdo.model.test.TestEnum;
import ch.flatland.cdo.model.test.TestFactory;
import ch.flatland.cdo.model.test.TestObject;
import ch.flatland.cdo.model.test.TestPackage;
import ch.flatland.cdo.model.test.util.TestValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestPackageImpl extends EPackageImpl implements TestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleDataTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleDataTypesAsArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testClobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum testEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType maxlength8EDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ch.flatland.cdo.model.test.TestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestPackageImpl() {
		super(eNS_URI, TestFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestPackage init() {
		if (isInited) return (TestPackage)EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestPackageImpl theTestPackage = registeredTestPackage instanceof TestPackageImpl ? (TestPackageImpl)registeredTestPackage : new TestPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestPackage.createPackageContents();

		// Initialize created meta-data
		theTestPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTestPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return TestValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTestPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestPackage.eNS_URI, theTestPackage);
		return theTestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleDataTypes() {
		return simpleDataTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestString() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestBoolean() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestBooleanObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestInt() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestIntObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestLong() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestLongObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestShort() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestShortObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestDouble() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestDoubleObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestFloat() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestFloatObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestByte() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestByteObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestChar() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestCharObject() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestDate() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestBigDecimal() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestBigInteger() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypes_TestEnum() {
		return (EAttribute)simpleDataTypesEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleDataTypesAsArray() {
		return simpleDataTypesAsArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestString() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestBoolean() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestInt() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestLong() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestShort() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestDouble() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestFloat() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestByte() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestChar() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestDate() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestBigDecimal() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestBigInteger() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleDataTypesAsArray_TestEnum() {
		return (EAttribute)simpleDataTypesAsArrayEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestObject() {
		return testObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Name() {
		return (EAttribute)testObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Maxlength8() {
		return (EAttribute)testObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestObject_SingleReference() {
		return (EReference)testObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestObject_MultiReferences() {
		return (EReference)testObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestObject_FixUpperBoundReferences() {
		return (EReference)testObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestObject_FixBoundReferences() {
		return (EReference)testObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestObject_FixlowerBoundReferences() {
		return (EReference)testObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestClob() {
		return testClobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestClob_Clob() {
		return (EAttribute)testClobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTestEnum() {
		return testEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMaxlength8() {
		return maxlength8EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestFactory getTestFactory() {
		return (TestFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		simpleDataTypesEClass = createEClass(SIMPLE_DATA_TYPES);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_STRING);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_BOOLEAN);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_INT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_INT_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_LONG);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_LONG_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_SHORT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_DOUBLE);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_FLOAT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_BYTE);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_CHAR);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_DATE);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_BIG_INTEGER);
		createEAttribute(simpleDataTypesEClass, SIMPLE_DATA_TYPES__TEST_ENUM);

		simpleDataTypesAsArrayEClass = createEClass(SIMPLE_DATA_TYPES_AS_ARRAY);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_STRING);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BOOLEAN);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_INT);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_LONG);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_SHORT);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DOUBLE);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_FLOAT);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BYTE);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_CHAR);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DATE);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_DECIMAL);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_INTEGER);
		createEAttribute(simpleDataTypesAsArrayEClass, SIMPLE_DATA_TYPES_AS_ARRAY__TEST_ENUM);

		testObjectEClass = createEClass(TEST_OBJECT);
		createEAttribute(testObjectEClass, TEST_OBJECT__NAME);
		createEAttribute(testObjectEClass, TEST_OBJECT__MAXLENGTH8);
		createEReference(testObjectEClass, TEST_OBJECT__SINGLE_REFERENCE);
		createEReference(testObjectEClass, TEST_OBJECT__MULTI_REFERENCES);
		createEReference(testObjectEClass, TEST_OBJECT__FIX_UPPER_BOUND_REFERENCES);
		createEReference(testObjectEClass, TEST_OBJECT__FIX_BOUND_REFERENCES);
		createEReference(testObjectEClass, TEST_OBJECT__FIXLOWER_BOUND_REFERENCES);

		testClobEClass = createEClass(TEST_CLOB);
		createEAttribute(testClobEClass, TEST_CLOB__CLOB);

		// Create enums
		testEnumEEnum = createEEnum(TEST_ENUM);

		// Create data types
		maxlength8EDataType = createEDataType(MAXLENGTH8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(simpleDataTypesEClass, SimpleDataTypes.class, "SimpleDataTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleDataTypes_TestString(), theEcorePackage.getEString(), "testString", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestBoolean(), theEcorePackage.getEBoolean(), "testBoolean", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestBooleanObject(), theEcorePackage.getEBooleanObject(), "testBooleanObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestInt(), theEcorePackage.getEInt(), "testInt", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestIntObject(), theEcorePackage.getEIntegerObject(), "testIntObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestLong(), theEcorePackage.getELong(), "testLong", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestLongObject(), theEcorePackage.getELongObject(), "testLongObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestShort(), theEcorePackage.getEShort(), "testShort", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestShortObject(), theEcorePackage.getEShortObject(), "testShortObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestDouble(), theEcorePackage.getEDouble(), "testDouble", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestDoubleObject(), theEcorePackage.getEDoubleObject(), "testDoubleObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestFloat(), theEcorePackage.getEFloat(), "testFloat", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestFloatObject(), theEcorePackage.getEFloatObject(), "testFloatObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestByte(), theEcorePackage.getEByte(), "testByte", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestByteObject(), theEcorePackage.getEByteObject(), "testByteObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestChar(), theEcorePackage.getEChar(), "testChar", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestCharObject(), theEcorePackage.getECharacterObject(), "testCharObject", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestDate(), theEcorePackage.getEDate(), "testDate", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestBigDecimal(), theEcorePackage.getEBigDecimal(), "testBigDecimal", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestBigInteger(), theEcorePackage.getEBigInteger(), "testBigInteger", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypes_TestEnum(), this.getTestEnum(), "testEnum", null, 0, 1, SimpleDataTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleDataTypesAsArrayEClass, SimpleDataTypesAsArray.class, "SimpleDataTypesAsArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleDataTypesAsArray_TestString(), theEcorePackage.getEString(), "testString", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestBoolean(), theEcorePackage.getEBoolean(), "testBoolean", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestInt(), theEcorePackage.getEInt(), "testInt", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestLong(), theEcorePackage.getELong(), "testLong", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestShort(), theEcorePackage.getEShort(), "testShort", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestDouble(), theEcorePackage.getEDouble(), "testDouble", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestFloat(), theEcorePackage.getEFloat(), "testFloat", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestByte(), theEcorePackage.getEByte(), "testByte", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestChar(), theEcorePackage.getEChar(), "testChar", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestDate(), theEcorePackage.getEDate(), "testDate", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestBigDecimal(), theEcorePackage.getEBigDecimal(), "testBigDecimal", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestBigInteger(), theEcorePackage.getEBigInteger(), "testBigInteger", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleDataTypesAsArray_TestEnum(), this.getTestEnum(), "testEnum", null, 0, -1, SimpleDataTypesAsArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testObjectEClass, TestObject.class, "TestObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestObject_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Maxlength8(), this.getMaxlength8(), "maxlength8", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestObject_SingleReference(), this.getTestObject(), null, "singleReference", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestObject_MultiReferences(), this.getTestObject(), null, "multiReferences", null, 0, -1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestObject_FixUpperBoundReferences(), this.getTestObject(), null, "fixUpperBoundReferences", null, 0, 2, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestObject_FixBoundReferences(), this.getTestObject(), null, "fixBoundReferences", null, 2, 2, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestObject_FixlowerBoundReferences(), this.getTestObject(), null, "fixlowerBoundReferences", null, 1, 2, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testClobEClass, TestClob.class, "TestClob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestClob_Clob(), theXMLTypePackage.getBase64Binary(), "clob", null, 0, 1, TestClob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(testEnumEEnum, TestEnum.class, "TestEnum");
		addEEnumLiteral(testEnumEEnum, TestEnum.LITERAL0);
		addEEnumLiteral(testEnumEEnum, TestEnum.LITERAL1);
		addEEnumLiteral(testEnumEEnum, TestEnum.LITERAL2);

		// Initialize data types
		initEDataType(maxlength8EDataType, String.class, "Maxlength8", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http://www.eclipse.org/CDO/DBStore
		createDBStoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "DBStore", "http://www.eclipse.org/CDO/DBStore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/CDO/DBStore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDBStoreAnnotations() {
		String source = "http://www.eclipse.org/CDO/DBStore";
		addAnnotation
		  (getTestClob_Clob(),
		   source,
		   new String[] {
			   "columnType", "CLOB"
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (maxlength8EDataType,
		   source,
		   new String[] {
			   "name", "Maxlength8",
			   "maxLength", "8"
		   });
	}

} //TestPackageImpl
