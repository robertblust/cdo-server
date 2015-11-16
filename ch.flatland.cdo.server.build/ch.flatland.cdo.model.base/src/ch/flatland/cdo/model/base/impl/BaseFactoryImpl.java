/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseFactoryImpl extends EFactoryImpl implements BaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BaseFactory init() {
		try {
			BaseFactory theBaseFactory = (BaseFactory)EPackage.Registry.INSTANCE.getEFactory(BasePackage.eNS_URI);
			if (theBaseFactory != null) {
				return theBaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BasePackage.FL_PACKAGE: return (EObject)createFLPackage();
			case BasePackage.FL_HYPER_LINK: return (EObject)createFLHyperLink();
			case BasePackage.FL_COMMENT: return (EObject)createFLComment();
			case BasePackage.FL_DATA_PROVIDER: return (EObject)createFLDataProvider();
			case BasePackage.FL_RATING: return (EObject)createFLRating();
			case BasePackage.FL_TRACE: return (EObject)createFLTrace();
			case BasePackage.FL_PROPERTY: return (EObject)createFLProperty();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BasePackage.FL_RATING_TYPE:
				return createFLRatingTypeFromString(eDataType, initialValue);
			case BasePackage.FL_TRACE_TYPE:
				return createFLTraceTypeFromString(eDataType, initialValue);
			case BasePackage.FL_IDENTIFIER:
				return createFLIdentifierFromString(eDataType, initialValue);
			case BasePackage.FL_MARKDOWN:
				return createFLMarkdownFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BasePackage.FL_RATING_TYPE:
				return convertFLRatingTypeToString(eDataType, instanceValue);
			case BasePackage.FL_TRACE_TYPE:
				return convertFLTraceTypeToString(eDataType, instanceValue);
			case BasePackage.FL_IDENTIFIER:
				return convertFLIdentifierToString(eDataType, instanceValue);
			case BasePackage.FL_MARKDOWN:
				return convertFLMarkdownToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLPackage createFLPackage() {
		FLPackageImpl flPackage = new FLPackageImpl();
		return flPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLHyperLink createFLHyperLink() {
		FLHyperLinkImpl flHyperLink = new FLHyperLinkImpl();
		return flHyperLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLComment createFLComment() {
		FLCommentImpl flComment = new FLCommentImpl();
		return flComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLDataProvider createFLDataProvider() {
		FLDataProviderImpl flDataProvider = new FLDataProviderImpl();
		return flDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLRating createFLRating() {
		FLRatingImpl flRating = new FLRatingImpl();
		return flRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLTrace createFLTrace() {
		FLTraceImpl flTrace = new FLTraceImpl();
		return flTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLProperty createFLProperty() {
		FLPropertyImpl flProperty = new FLPropertyImpl();
		return flProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLRatingType createFLRatingTypeFromString(EDataType eDataType, String initialValue) {
		FLRatingType result = FLRatingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFLRatingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLTraceType createFLTraceTypeFromString(EDataType eDataType, String initialValue) {
		FLTraceType result = FLTraceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFLTraceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFLIdentifierFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFLIdentifierToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createFLMarkdownFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFLMarkdownToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasePackage getBasePackage() {
		return (BasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BasePackage getPackage() {
		return BasePackage.eINSTANCE;
	}

} //BaseFactoryImpl
