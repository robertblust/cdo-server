/**
 */
package ch.flatland.cdo.model.test.impl;

import ch.flatland.cdo.model.test.SimpleDataTypes;
import ch.flatland.cdo.model.test.TestEnum;
import ch.flatland.cdo.model.test.TestPackage;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Date;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Data Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestString <em>Test String</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#isTestBoolean <em>Test Boolean</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestBooleanObject <em>Test Boolean Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestInt <em>Test Int</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestIntObject <em>Test Int Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestLong <em>Test Long</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestLongObject <em>Test Long Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestShort <em>Test Short</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestShortObject <em>Test Short Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestDouble <em>Test Double</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestDoubleObject <em>Test Double Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestFloat <em>Test Float</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestFloatObject <em>Test Float Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestByte <em>Test Byte</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestByteObject <em>Test Byte Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestChar <em>Test Char</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestCharObject <em>Test Char Object</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestDate <em>Test Date</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestBigDecimal <em>Test Big Decimal</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestBigInteger <em>Test Big Integer</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.test.impl.SimpleDataTypesImpl#getTestEnum <em>Test Enum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleDataTypesImpl extends CDOObjectImpl implements SimpleDataTypes {
	/**
	 * The default value of the '{@link #getTestString() <em>Test String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestString()
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_STRING_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isTestBoolean() <em>Test Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTestBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEST_BOOLEAN_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getTestBooleanObject() <em>Test Boolean Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestBooleanObject()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean TEST_BOOLEAN_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestInt() <em>Test Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestInt()
	 * @generated
	 * @ordered
	 */
	protected static final int TEST_INT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getTestIntObject() <em>Test Int Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestIntObject()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TEST_INT_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestLong() <em>Test Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestLong()
	 * @generated
	 * @ordered
	 */
	protected static final long TEST_LONG_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getTestLongObject() <em>Test Long Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestLongObject()
	 * @generated
	 * @ordered
	 */
	protected static final Long TEST_LONG_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestShort() <em>Test Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestShort()
	 * @generated
	 * @ordered
	 */
	protected static final short TEST_SHORT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getTestShortObject() <em>Test Short Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestShortObject()
	 * @generated
	 * @ordered
	 */
	protected static final Short TEST_SHORT_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestDouble() <em>Test Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestDouble()
	 * @generated
	 * @ordered
	 */
	protected static final double TEST_DOUBLE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getTestDoubleObject() <em>Test Double Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestDoubleObject()
	 * @generated
	 * @ordered
	 */
	protected static final Double TEST_DOUBLE_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestFloat() <em>Test Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestFloat()
	 * @generated
	 * @ordered
	 */
	protected static final float TEST_FLOAT_EDEFAULT = 0.0F;

	/**
	 * The default value of the '{@link #getTestFloatObject() <em>Test Float Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestFloatObject()
	 * @generated
	 * @ordered
	 */
	protected static final Float TEST_FLOAT_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestByte() <em>Test Byte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestByte()
	 * @generated
	 * @ordered
	 */
	protected static final byte TEST_BYTE_EDEFAULT = 0x00;

	/**
	 * The default value of the '{@link #getTestByteObject() <em>Test Byte Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestByteObject()
	 * @generated
	 * @ordered
	 */
	protected static final Byte TEST_BYTE_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestChar() <em>Test Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestChar()
	 * @generated
	 * @ordered
	 */
	protected static final char TEST_CHAR_EDEFAULT = '\u0000';

	/**
	 * The default value of the '{@link #getTestCharObject() <em>Test Char Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCharObject()
	 * @generated
	 * @ordered
	 */
	protected static final Character TEST_CHAR_OBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestDate() <em>Test Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date TEST_DATE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestBigDecimal() <em>Test Big Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal TEST_BIG_DECIMAL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestBigInteger() <em>Test Big Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestBigInteger()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger TEST_BIG_INTEGER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTestEnum() <em>Test Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestEnum()
	 * @generated
	 * @ordered
	 */
	protected static final TestEnum TEST_ENUM_EDEFAULT = TestEnum.LITERAL0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleDataTypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestPackage.Literals.SIMPLE_DATA_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTestString() {
		return (String)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_STRING, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_STRING, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestString(String newTestString) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_STRING, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_STRING, newTestString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTestBoolean() {
		return (Boolean)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BOOLEAN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestBoolean(boolean newTestBoolean) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BOOLEAN, newTestBoolean);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getTestBooleanObject() {
		return (Boolean)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestBooleanObject(Boolean newTestBooleanObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT, newTestBooleanObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTestInt() {
		return (Integer)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_INT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_INT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestInt(int newTestInt) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_INT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_INT, newTestInt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getTestIntObject() {
		return (Integer)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_INT_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_INT_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestIntObject(Integer newTestIntObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_INT_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_INT_OBJECT, newTestIntObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getTestLong() {
		return (Long)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_LONG, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_LONG, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestLong(long newTestLong) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_LONG, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_LONG, newTestLong);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getTestLongObject() {
		return (Long)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestLongObject(Long newTestLongObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT, newTestLongObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public short getTestShort() {
		return (Short)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_SHORT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestShort(short newTestShort) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_SHORT, newTestShort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Short getTestShortObject() {
		return (Short)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestShortObject(Short newTestShortObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT, newTestShortObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTestDouble() {
		return (Double)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_DOUBLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestDouble(double newTestDouble) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_DOUBLE, newTestDouble);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Double getTestDoubleObject() {
		return (Double)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestDoubleObject(Double newTestDoubleObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT, newTestDoubleObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getTestFloat() {
		return (Float)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_FLOAT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestFloat(float newTestFloat) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_FLOAT, newTestFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Float getTestFloatObject() {
		return (Float)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestFloatObject(Float newTestFloatObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT, newTestFloatObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte getTestByte() {
		return (Byte)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BYTE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestByte(byte newTestByte) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BYTE, newTestByte);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Byte getTestByteObject() {
		return (Byte)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestByteObject(Byte newTestByteObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT, newTestByteObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public char getTestChar() {
		return (Character)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_CHAR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestChar(char newTestChar) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_CHAR, newTestChar);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Character getTestCharObject() {
		return (Character)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestCharObject(Character newTestCharObject) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT, newTestCharObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getTestDate() {
		return (Date)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_DATE, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_DATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestDate(Date newTestDate) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_DATE, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_DATE, newTestDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getTestBigDecimal() {
		return (BigDecimal)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestBigDecimal(BigDecimal newTestBigDecimal) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL, newTestBigDecimal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigInteger getTestBigInteger() {
		return (BigInteger)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestBigInteger(BigInteger newTestBigInteger) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER, newTestBigInteger);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestEnum getTestEnum() {
		return (TestEnum)eDynamicGet(TestPackage.SIMPLE_DATA_TYPES__TEST_ENUM, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_ENUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestEnum(TestEnum newTestEnum) {
		eDynamicSet(TestPackage.SIMPLE_DATA_TYPES__TEST_ENUM, TestPackage.Literals.SIMPLE_DATA_TYPES__TEST_ENUM, newTestEnum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestPackage.SIMPLE_DATA_TYPES__TEST_STRING:
				return getTestString();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN:
				return isTestBoolean();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT:
				return getTestBooleanObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT:
				return getTestInt();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT_OBJECT:
				return getTestIntObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG:
				return getTestLong();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT:
				return getTestLongObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT:
				return getTestShort();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT:
				return getTestShortObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE:
				return getTestDouble();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT:
				return getTestDoubleObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT:
				return getTestFloat();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT:
				return getTestFloatObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE:
				return getTestByte();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT:
				return getTestByteObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR:
				return getTestChar();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT:
				return getTestCharObject();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DATE:
				return getTestDate();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL:
				return getTestBigDecimal();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER:
				return getTestBigInteger();
			case TestPackage.SIMPLE_DATA_TYPES__TEST_ENUM:
				return getTestEnum();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestPackage.SIMPLE_DATA_TYPES__TEST_STRING:
				setTestString((String)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN:
				setTestBoolean((Boolean)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT:
				setTestBooleanObject((Boolean)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT:
				setTestInt((Integer)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT_OBJECT:
				setTestIntObject((Integer)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG:
				setTestLong((Long)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT:
				setTestLongObject((Long)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT:
				setTestShort((Short)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT:
				setTestShortObject((Short)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE:
				setTestDouble((Double)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT:
				setTestDoubleObject((Double)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT:
				setTestFloat((Float)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT:
				setTestFloatObject((Float)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE:
				setTestByte((Byte)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT:
				setTestByteObject((Byte)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR:
				setTestChar((Character)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT:
				setTestCharObject((Character)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DATE:
				setTestDate((Date)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL:
				setTestBigDecimal((BigDecimal)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER:
				setTestBigInteger((BigInteger)newValue);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_ENUM:
				setTestEnum((TestEnum)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestPackage.SIMPLE_DATA_TYPES__TEST_STRING:
				setTestString(TEST_STRING_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN:
				setTestBoolean(TEST_BOOLEAN_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT:
				setTestBooleanObject(TEST_BOOLEAN_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT:
				setTestInt(TEST_INT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT_OBJECT:
				setTestIntObject(TEST_INT_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG:
				setTestLong(TEST_LONG_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT:
				setTestLongObject(TEST_LONG_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT:
				setTestShort(TEST_SHORT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT:
				setTestShortObject(TEST_SHORT_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE:
				setTestDouble(TEST_DOUBLE_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT:
				setTestDoubleObject(TEST_DOUBLE_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT:
				setTestFloat(TEST_FLOAT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT:
				setTestFloatObject(TEST_FLOAT_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE:
				setTestByte(TEST_BYTE_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT:
				setTestByteObject(TEST_BYTE_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR:
				setTestChar(TEST_CHAR_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT:
				setTestCharObject(TEST_CHAR_OBJECT_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DATE:
				setTestDate(TEST_DATE_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL:
				setTestBigDecimal(TEST_BIG_DECIMAL_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER:
				setTestBigInteger(TEST_BIG_INTEGER_EDEFAULT);
				return;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_ENUM:
				setTestEnum(TEST_ENUM_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestPackage.SIMPLE_DATA_TYPES__TEST_STRING:
				return TEST_STRING_EDEFAULT == null ? getTestString() != null : !TEST_STRING_EDEFAULT.equals(getTestString());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN:
				return isTestBoolean() != TEST_BOOLEAN_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BOOLEAN_OBJECT:
				return TEST_BOOLEAN_OBJECT_EDEFAULT == null ? getTestBooleanObject() != null : !TEST_BOOLEAN_OBJECT_EDEFAULT.equals(getTestBooleanObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT:
				return getTestInt() != TEST_INT_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_INT_OBJECT:
				return TEST_INT_OBJECT_EDEFAULT == null ? getTestIntObject() != null : !TEST_INT_OBJECT_EDEFAULT.equals(getTestIntObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG:
				return getTestLong() != TEST_LONG_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_LONG_OBJECT:
				return TEST_LONG_OBJECT_EDEFAULT == null ? getTestLongObject() != null : !TEST_LONG_OBJECT_EDEFAULT.equals(getTestLongObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT:
				return getTestShort() != TEST_SHORT_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_SHORT_OBJECT:
				return TEST_SHORT_OBJECT_EDEFAULT == null ? getTestShortObject() != null : !TEST_SHORT_OBJECT_EDEFAULT.equals(getTestShortObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE:
				return getTestDouble() != TEST_DOUBLE_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DOUBLE_OBJECT:
				return TEST_DOUBLE_OBJECT_EDEFAULT == null ? getTestDoubleObject() != null : !TEST_DOUBLE_OBJECT_EDEFAULT.equals(getTestDoubleObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT:
				return getTestFloat() != TEST_FLOAT_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_FLOAT_OBJECT:
				return TEST_FLOAT_OBJECT_EDEFAULT == null ? getTestFloatObject() != null : !TEST_FLOAT_OBJECT_EDEFAULT.equals(getTestFloatObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE:
				return getTestByte() != TEST_BYTE_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BYTE_OBJECT:
				return TEST_BYTE_OBJECT_EDEFAULT == null ? getTestByteObject() != null : !TEST_BYTE_OBJECT_EDEFAULT.equals(getTestByteObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR:
				return getTestChar() != TEST_CHAR_EDEFAULT;
			case TestPackage.SIMPLE_DATA_TYPES__TEST_CHAR_OBJECT:
				return TEST_CHAR_OBJECT_EDEFAULT == null ? getTestCharObject() != null : !TEST_CHAR_OBJECT_EDEFAULT.equals(getTestCharObject());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_DATE:
				return TEST_DATE_EDEFAULT == null ? getTestDate() != null : !TEST_DATE_EDEFAULT.equals(getTestDate());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_DECIMAL:
				return TEST_BIG_DECIMAL_EDEFAULT == null ? getTestBigDecimal() != null : !TEST_BIG_DECIMAL_EDEFAULT.equals(getTestBigDecimal());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_BIG_INTEGER:
				return TEST_BIG_INTEGER_EDEFAULT == null ? getTestBigInteger() != null : !TEST_BIG_INTEGER_EDEFAULT.equals(getTestBigInteger());
			case TestPackage.SIMPLE_DATA_TYPES__TEST_ENUM:
				return getTestEnum() != TEST_ENUM_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //SimpleDataTypesImpl
