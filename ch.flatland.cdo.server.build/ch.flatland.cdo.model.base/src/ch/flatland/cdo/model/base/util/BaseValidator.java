/**
 */
package ch.flatland.cdo.model.base.util;

import ch.flatland.cdo.model.base.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.base.BasePackage
 * @generated
 */
public class BaseValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final BaseValidator INSTANCE = new BaseValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ch.flatland.cdo.model.base";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return BasePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case BasePackage.FLID:
				return validateFLID((FLID)value, diagnostics, context);
			case BasePackage.FL_ELEMENT:
				return validateFLElement((FLElement)value, diagnostics, context);
			case BasePackage.FL_PACKAGE:
				return validateFLPackage((FLPackage)value, diagnostics, context);
			case BasePackage.FL_TRACE:
				return validateFLTrace((FLTrace)value, diagnostics, context);
			case BasePackage.FL_PROPERTY:
				return validateFLProperty((FLProperty)value, diagnostics, context);
			case BasePackage.FL_TRACE_TYPE:
				return validateFLTraceType((FLTraceType)value, diagnostics, context);
			case BasePackage.FL_IDENTIFIER:
				return validateFLIdentifier((String)value, diagnostics, context);
			case BasePackage.FL_MARKDOWN:
				return validateFLMarkdown((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLID(FLID flid, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)flid, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLElement(FLElement flElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)flElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLPackage(FLPackage flPackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)flPackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLTrace(FLTrace flTrace, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)flTrace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLProperty(FLProperty flProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)flProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLTraceType(FLTraceType flTraceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLIdentifier(String flIdentifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateFLIdentifier_Pattern(flIdentifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateFLIdentifier_Pattern
	 */
	public static final  PatternMatcher [][] FL_IDENTIFIER__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("[a-zA-Z0-9_\\-\\.]*")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>FL Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLIdentifier_Pattern(String flIdentifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(BasePackage.Literals.FL_IDENTIFIER, flIdentifier, FL_IDENTIFIER__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFLMarkdown(String flMarkdown, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //BaseValidator
