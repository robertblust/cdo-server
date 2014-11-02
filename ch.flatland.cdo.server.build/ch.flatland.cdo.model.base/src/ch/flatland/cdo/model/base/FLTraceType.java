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
 * @see ch.flatland.cdo.model.base.BasePackage#getFLTraceType()
 * @model
 * @generated
 */
public enum FLTraceType implements Enumerator {
	/**
	 * The '<em><b>Owned By</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OWNED_BY_VALUE
	 * @generated
	 * @ordered
	 */
	OWNED_BY(0, "ownedBy", "ownedBy"),

	/**
	 * The '<em><b>Verifies</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERIFIES_VALUE
	 * @generated
	 * @ordered
	 */
	VERIFIES(1, "verifies", "verifies"),

	/**
	 * The '<em><b>Specifies</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFIES_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIFIES(2, "specifies", "specifies"),

	/**
	 * The '<em><b>Satisfies</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SATISFIES_VALUE
	 * @generated
	 * @ordered
	 */
	SATISFIES(3, "satisfies", "satisfies"),

	/**
	 * The '<em><b>Mesures</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESURES_VALUE
	 * @generated
	 * @ordered
	 */
	MESURES(4, "mesures", "mesures");

	/**
	 * The '<em><b>Owned By</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Owned By</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OWNED_BY
	 * @model name="ownedBy"
	 * @generated
	 * @ordered
	 */
	public static final int OWNED_BY_VALUE = 0;

	/**
	 * The '<em><b>Verifies</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verifies</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERIFIES
	 * @model name="verifies"
	 * @generated
	 * @ordered
	 */
	public static final int VERIFIES_VALUE = 1;

	/**
	 * The '<em><b>Specifies</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Specifies</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIFIES
	 * @model name="specifies"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFIES_VALUE = 2;

	/**
	 * The '<em><b>Satisfies</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Satisfies</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SATISFIES
	 * @model name="satisfies"
	 * @generated
	 * @ordered
	 */
	public static final int SATISFIES_VALUE = 3;

	/**
	 * The '<em><b>Mesures</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mesures</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESURES
	 * @model name="mesures"
	 * @generated
	 * @ordered
	 */
	public static final int MESURES_VALUE = 4;

	/**
	 * An array of all the '<em><b>FL Trace Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FLTraceType[] VALUES_ARRAY =
		new FLTraceType[] {
			OWNED_BY,
			VERIFIES,
			SPECIFIES,
			SATISFIES,
			MESURES,
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
	 * @generated
	 */
	public static FLTraceType get(int value) {
		switch (value) {
			case OWNED_BY_VALUE: return OWNED_BY;
			case VERIFIES_VALUE: return VERIFIES;
			case SPECIFIES_VALUE: return SPECIFIES;
			case SATISFIES_VALUE: return SATISFIES;
			case MESURES_VALUE: return MESURES;
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
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
