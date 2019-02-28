/**
 */
package ch.flatland.cdo.model.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>FL Trace Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * <p>
 * Expresses the concrete type of a relationship between entities.
 * </p>
 * <!-- end-model-doc -->
 * @see ch.flatland.cdo.model.base.BasePackage#getFLTraceType()
 * @model
 * @generated
 */
public enum FLTraceType implements Enumerator {
	/**
	 * The '<em><b>Own</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * UML2
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #OWN_VALUE
	 * @generated
	 * @ordered
	 */
	OWN(101, "own", "own"), /**
	 * The '<em><b>Use</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_VALUE
	 * @generated
	 * @ordered
	 */
	USE(102, "use", "use"), /**
	 * The '<em><b>Realize</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REALIZE_VALUE
	 * @generated
	 * @ordered
	 */
	REALIZE(103, "realize", "realize"), /**
	 * The '<em><b>Specify</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFY_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIFY(104, "specify", "specify"), /**
	 * The '<em><b>Implement</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	IMPLEMENT(105, "implement", "implement"), /**
	 * The '<em><b>Elaborate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELABORATE_VALUE
	 * @generated
	 * @ordered
	 */
	ELABORATE(106, "elaborate", "elaborate"), /**
	 * The '<em><b>Derive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DERIVE_VALUE
	 * @generated
	 * @ordered
	 */
	DERIVE(107, "derive", "derive"), /**
	 * The '<em><b>Validate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * Test Management Domain
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #VALIDATE_VALUE
	 * @generated
	 * @ordered
	 */
	VALIDATE(201, "validate", "validate"), /**
	 * The '<em><b>Test</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OSLC TM / CM - A test case tests a change request
	 * <!-- end-model-doc -->
	 * @see #TEST_VALUE
	 * @generated
	 * @ordered
	 */
	TEST(202, "test", "test"), /**
	 * The '<em><b>Relate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  OSLC TM / CM - A test case relates to a change request
	 * <!-- end-model-doc -->
	 * @see #RELATE_VALUE
	 * @generated
	 * @ordered
	 */
	RELATE(203, "relate", "relate"), /**
	 * The '<em><b>Affect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OSLC TM - A defect may be said to affect a requirement.
	 * <!-- end-model-doc -->
	 * @see #AFFECT_VALUE
	 * @generated
	 * @ordered
	 */
	AFFECT(204, "affect", "affect"), /**
	 * The '<em><b>Satisfy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * Requirement Management Domain
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #SATISFY_VALUE
	 * @generated
	 * @ordered
	 */
	SATISFY(301, "satisfy", "satisfy"), /**
	 * The '<em><b>Verify</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SYSML REQ - A requirement satisfy a requirement
	 * <!-- end-model-doc -->
	 * @see #VERIFY_VALUE
	 * @generated
	 * @ordered
	 */
	VERIFY(302, "verify", "verify"), /**
	 * The '<em><b>Refine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SYSML REQ - A requirement verifies a requirement
	 * <!-- end-model-doc -->
	 * @see #REFINE_VALUE
	 * @generated
	 * @ordered
	 */
	REFINE(303, "refine", "refine"), /**
	 * The '<em><b>Track</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * Change Management Domain
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #TRACK_VALUE
	 * @generated
	 * @ordered
	 */
	TRACK(401, "track", "track");

	/**
	 * The '<em><b>Own</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Own</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * UML2
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #OWN
	 * @model name="own"
	 * @generated
	 * @ordered
	 */
	public static final int OWN_VALUE = 101;

	/**
	 * The '<em><b>Use</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Use</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USE
	 * @model name="use"
	 * @generated
	 * @ordered
	 */
	public static final int USE_VALUE = 102;

	/**
	 * The '<em><b>Realize</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Realize</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REALIZE
	 * @model name="realize"
	 * @generated
	 * @ordered
	 */
	public static final int REALIZE_VALUE = 103;

	/**
	 * The '<em><b>Specify</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Specify</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIFY
	 * @model name="specify"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFY_VALUE = 104;

	/**
	 * The '<em><b>Implement</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLEMENT
	 * @model name="implement"
	 * @generated
	 * @ordered
	 */
	public static final int IMPLEMENT_VALUE = 105;

	/**
	 * The '<em><b>Elaborate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELABORATE
	 * @model name="elaborate"
	 * @generated
	 * @ordered
	 */
	public static final int ELABORATE_VALUE = 106;

	/**
	 * The '<em><b>Derive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Derive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DERIVE
	 * @model name="derive"
	 * @generated
	 * @ordered
	 */
	public static final int DERIVE_VALUE = 107;

	/**
	 * The '<em><b>Validate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Validate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * Test Management Domain
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #VALIDATE
	 * @model name="validate"
	 * @generated
	 * @ordered
	 */
	public static final int VALIDATE_VALUE = 201;

	/**
	 * The '<em><b>Test</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OSLC TM / CM - A test case tests a change request
	 * <!-- end-model-doc -->
	 * @see #TEST
	 * @model name="test"
	 * @generated
	 * @ordered
	 */
	public static final int TEST_VALUE = 202;

	/**
	 * The '<em><b>Relate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  OSLC TM / CM - A test case relates to a change request
	 * <!-- end-model-doc -->
	 * @see #RELATE
	 * @model name="relate"
	 * @generated
	 * @ordered
	 */
	public static final int RELATE_VALUE = 203;

	/**
	 * The '<em><b>Affect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OSLC TM - A defect may be said to affect a requirement.
	 * <!-- end-model-doc -->
	 * @see #AFFECT
	 * @model name="affect"
	 * @generated
	 * @ordered
	 */
	public static final int AFFECT_VALUE = 204;

	/**
	 * The '<em><b>Satisfy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Satisfy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * Requirement Management Domain
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #SATISFY
	 * @model name="satisfy"
	 * @generated
	 * @ordered
	 */
	public static final int SATISFY_VALUE = 301;

	/**
	 * The '<em><b>Verify</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SYSML REQ - A requirement satisfy a requirement
	 * <!-- end-model-doc -->
	 * @see #VERIFY
	 * @model name="verify"
	 * @generated
	 * @ordered
	 */
	public static final int VERIFY_VALUE = 302;

	/**
	 * The '<em><b>Refine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Refine</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SYSML REQ - A requirement verifies a requirement
	 * <!-- end-model-doc -->
	 * @see #REFINE
	 * @model name="refine"
	 * @generated
	 * @ordered
	 */
	public static final int REFINE_VALUE = 303;

	/**
	 * The '<em><b>Track</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ---------------------------------------------
	 * Change Management Domain
	 * ---------------------------------------------
	 * <!-- end-model-doc -->
	 * @see #TRACK
	 * @model name="track"
	 * @generated
	 * @ordered
	 */
	public static final int TRACK_VALUE = 401;

	/**
	 * An array of all the '<em><b>FL Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FLTraceType[] VALUES_ARRAY =
		new FLTraceType[] {
			OWN,
			USE,
			REALIZE,
			SPECIFY,
			IMPLEMENT,
			ELABORATE,
			DERIVE,
			VALIDATE,
			TEST,
			RELATE,
			AFFECT,
			SATISFY,
			VERIFY,
			REFINE,
			TRACK,
		};

	/**
	 * A public read-only list of all the '<em><b>FL Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FLTraceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>FL Trace Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FLTraceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FLTraceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>FL Trace Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FLTraceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FLTraceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>FL Trace Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FLTraceType get(int value) {
		switch (value) {
			case OWN_VALUE: return OWN;
			case USE_VALUE: return USE;
			case REALIZE_VALUE: return REALIZE;
			case SPECIFY_VALUE: return SPECIFY;
			case IMPLEMENT_VALUE: return IMPLEMENT;
			case ELABORATE_VALUE: return ELABORATE;
			case DERIVE_VALUE: return DERIVE;
			case VALIDATE_VALUE: return VALIDATE;
			case TEST_VALUE: return TEST;
			case RELATE_VALUE: return RELATE;
			case AFFECT_VALUE: return AFFECT;
			case SATISFY_VALUE: return SATISFY;
			case VERIFY_VALUE: return VERIFY;
			case REFINE_VALUE: return REFINE;
			case TRACK_VALUE: return TRACK;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FLTraceType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FLTraceType
