/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BaseFactory;
import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLCommentable;
import ch.flatland.cdo.model.base.FLComment;
import ch.flatland.cdo.model.base.FLDataProvider;
import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLGlobalSearch;
import ch.flatland.cdo.model.base.FLHyperLink;
import ch.flatland.cdo.model.base.FLPackage;
import ch.flatland.cdo.model.base.FLProperty;
import ch.flatland.cdo.model.base.FLRating;
import ch.flatland.cdo.model.base.FLRatingType;
import ch.flatland.cdo.model.base.FLTrace;
import ch.flatland.cdo.model.base.FLTraceType;
import ch.flatland.cdo.model.base.FLHyperLinkable;
import ch.flatland.cdo.model.base.FLNameable;
import ch.flatland.cdo.model.base.FLRateable;
import ch.flatland.cdo.model.base.util.BaseValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasePackageImpl extends EPackageImpl implements BasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flHyperLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flDataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flCommentableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flHyperLinkableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flNameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flRateableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flGlobalSearchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flRatingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flTraceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum flRatingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum flTraceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType flIdentifierEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType flMarkdownEDataType = null;

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
	 * @see ch.flatland.cdo.model.base.BasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BasePackageImpl() {
		super(eNS_URI, BaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BasePackage init() {
		if (isInited) return (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BasePackageImpl theBasePackage = registeredBasePackage instanceof BasePackageImpl ? (BasePackageImpl)registeredBasePackage : new BasePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBasePackage.createPackageContents();

		// Initialize created meta-data
		theBasePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theBasePackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return BaseValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theBasePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BasePackage.eNS_URI, theBasePackage);
		return theBasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLID() {
		return flidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_UUID() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_ID() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_ObjectID() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_RevisionID() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_Version() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_CDate() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLID_UDate() {
		return (EAttribute)flidEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLID__HasPermission__FLID() {
		return flidEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLElement() {
		return flElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_Traces() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_Properties() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_DataProvider() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_UpStreamMappings() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_DownStreamMappings() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_HorizontalMappings() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_HorizontalOppositeMappings() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToOwn() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToUse() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToRealize() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToSpecify() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToImplement() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToElaborate() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToDerive() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToValidate() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToTest() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToRelate() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToAffect() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToSatisfy() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToVerify() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToRefine() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceToTrack() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromOwn() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromUse() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromRealize() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromSpecify() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromImplement() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromElaborate() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromDerive() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromValidate() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromTest() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromRelate() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromAffect() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromSatisfy() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromVerify() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromRefine() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLElement_TraceFromTrack() {
		return (EReference)flElementEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLElement__ToFilterByType__FLTraceType() {
		return flElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLElement__FromFilterByType__FLTraceType() {
		return flElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLElement__ResolveXrefs__EReference_Class() {
		return flElementEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLPackage() {
		return flPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLPackage_Elements() {
		return (EReference)flPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLPackage_SubPackages() {
		return (EReference)flPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLPackage_Contents() {
		return (EReference)flPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLPackage__FilterSubPackages() {
		return flPackageEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLPackage__FilterContents() {
		return flPackageEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLHyperLink() {
		return flHyperLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLHyperLink_Name() {
		return (EAttribute)flHyperLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLHyperLink_HyperLink() {
		return (EAttribute)flHyperLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLComment() {
		return flCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLComment_Comment() {
		return (EAttribute)flCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLComment_Comments() {
		return (EReference)flCommentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLDataProvider() {
		return flDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLDataProvider_ProvidedElements() {
		return (EReference)flDataProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLCommentable() {
		return flCommentableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLCommentable_Comments() {
		return (EReference)flCommentableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLHyperLinkable() {
		return flHyperLinkableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLHyperLinkable_HyperLinks() {
		return (EReference)flHyperLinkableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLNameable() {
		return flNameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLNameable_Name() {
		return (EAttribute)flNameableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLNameable_Description() {
		return (EAttribute)flNameableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLNameable_LongDescription() {
		return (EAttribute)flNameableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLNameable_Notes() {
		return (EAttribute)flNameableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLRateable() {
		return flRateableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLRateable_Ratings() {
		return (EReference)flRateableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLRateable_Likes() {
		return (EAttribute)flRateableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLRateable_Dislikes() {
		return (EAttribute)flRateableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLRateable__CountLikes() {
		return flRateableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFLRateable__CountDislikes() {
		return flRateableEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLGlobalSearch() {
		return flGlobalSearchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLRating() {
		return flRatingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLRating_RatingType() {
		return (EAttribute)flRatingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLTrace() {
		return flTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLTrace_TraceType() {
		return (EAttribute)flTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFLTrace_Target() {
		return (EReference)flTraceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFLProperty() {
		return flPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLProperty_Name() {
		return (EAttribute)flPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFLProperty_Value() {
		return (EAttribute)flPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getFLRatingType() {
		return flRatingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getFLTraceType() {
		return flTraceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getFLIdentifier() {
		return flIdentifierEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getFLMarkdown() {
		return flMarkdownEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BaseFactory getBaseFactory() {
		return (BaseFactory)getEFactoryInstance();
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
		flidEClass = createEClass(FLID);
		createEAttribute(flidEClass, FLID__UUID);
		createEAttribute(flidEClass, FLID__ID);
		createEAttribute(flidEClass, FLID__OBJECT_ID);
		createEAttribute(flidEClass, FLID__REVISION_ID);
		createEAttribute(flidEClass, FLID__VERSION);
		createEAttribute(flidEClass, FLID__CDATE);
		createEAttribute(flidEClass, FLID__UDATE);
		createEOperation(flidEClass, FLID___HAS_PERMISSION__FLID);

		flElementEClass = createEClass(FL_ELEMENT);
		createEReference(flElementEClass, FL_ELEMENT__TRACES);
		createEReference(flElementEClass, FL_ELEMENT__PROPERTIES);
		createEReference(flElementEClass, FL_ELEMENT__DATA_PROVIDER);
		createEReference(flElementEClass, FL_ELEMENT__UP_STREAM_MAPPINGS);
		createEReference(flElementEClass, FL_ELEMENT__DOWN_STREAM_MAPPINGS);
		createEReference(flElementEClass, FL_ELEMENT__HORIZONTAL_MAPPINGS);
		createEReference(flElementEClass, FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_OWN);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_USE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_REALIZE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_SPECIFY);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_IMPLEMENT);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_ELABORATE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_DERIVE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_VALIDATE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_TEST);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_RELATE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_AFFECT);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_SATISFY);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_VERIFY);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_REFINE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_TO_TRACK);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_OWN);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_USE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_REALIZE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_SPECIFY);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_IMPLEMENT);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_ELABORATE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_DERIVE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_VALIDATE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_TEST);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_RELATE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_AFFECT);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_SATISFY);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_VERIFY);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_REFINE);
		createEReference(flElementEClass, FL_ELEMENT__TRACE_FROM_TRACK);
		createEOperation(flElementEClass, FL_ELEMENT___TO_FILTER_BY_TYPE__FLTRACETYPE);
		createEOperation(flElementEClass, FL_ELEMENT___FROM_FILTER_BY_TYPE__FLTRACETYPE);
		createEOperation(flElementEClass, FL_ELEMENT___RESOLVE_XREFS__EREFERENCE_CLASS);

		flPackageEClass = createEClass(FL_PACKAGE);
		createEReference(flPackageEClass, FL_PACKAGE__ELEMENTS);
		createEReference(flPackageEClass, FL_PACKAGE__SUB_PACKAGES);
		createEReference(flPackageEClass, FL_PACKAGE__CONTENTS);
		createEOperation(flPackageEClass, FL_PACKAGE___FILTER_SUB_PACKAGES);
		createEOperation(flPackageEClass, FL_PACKAGE___FILTER_CONTENTS);

		flHyperLinkEClass = createEClass(FL_HYPER_LINK);
		createEAttribute(flHyperLinkEClass, FL_HYPER_LINK__NAME);
		createEAttribute(flHyperLinkEClass, FL_HYPER_LINK__HYPER_LINK);

		flCommentEClass = createEClass(FL_COMMENT);
		createEAttribute(flCommentEClass, FL_COMMENT__COMMENT);
		createEReference(flCommentEClass, FL_COMMENT__COMMENTS);

		flDataProviderEClass = createEClass(FL_DATA_PROVIDER);
		createEReference(flDataProviderEClass, FL_DATA_PROVIDER__PROVIDED_ELEMENTS);

		flCommentableEClass = createEClass(FL_COMMENTABLE);
		createEReference(flCommentableEClass, FL_COMMENTABLE__COMMENTS);

		flHyperLinkableEClass = createEClass(FL_HYPER_LINKABLE);
		createEReference(flHyperLinkableEClass, FL_HYPER_LINKABLE__HYPER_LINKS);

		flNameableEClass = createEClass(FL_NAMEABLE);
		createEAttribute(flNameableEClass, FL_NAMEABLE__NAME);
		createEAttribute(flNameableEClass, FL_NAMEABLE__DESCRIPTION);
		createEAttribute(flNameableEClass, FL_NAMEABLE__LONG_DESCRIPTION);
		createEAttribute(flNameableEClass, FL_NAMEABLE__NOTES);

		flRateableEClass = createEClass(FL_RATEABLE);
		createEReference(flRateableEClass, FL_RATEABLE__RATINGS);
		createEAttribute(flRateableEClass, FL_RATEABLE__LIKES);
		createEAttribute(flRateableEClass, FL_RATEABLE__DISLIKES);
		createEOperation(flRateableEClass, FL_RATEABLE___COUNT_LIKES);
		createEOperation(flRateableEClass, FL_RATEABLE___COUNT_DISLIKES);

		flGlobalSearchEClass = createEClass(FL_GLOBAL_SEARCH);

		flRatingEClass = createEClass(FL_RATING);
		createEAttribute(flRatingEClass, FL_RATING__RATING_TYPE);

		flTraceEClass = createEClass(FL_TRACE);
		createEAttribute(flTraceEClass, FL_TRACE__TRACE_TYPE);
		createEReference(flTraceEClass, FL_TRACE__TARGET);

		flPropertyEClass = createEClass(FL_PROPERTY);
		createEAttribute(flPropertyEClass, FL_PROPERTY__NAME);
		createEAttribute(flPropertyEClass, FL_PROPERTY__VALUE);

		// Create enums
		flRatingTypeEEnum = createEEnum(FL_RATING_TYPE);
		flTraceTypeEEnum = createEEnum(FL_TRACE_TYPE);

		// Create data types
		flIdentifierEDataType = createEDataType(FL_IDENTIFIER);
		flMarkdownEDataType = createEDataType(FL_MARKDOWN);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		flElementEClass.getESuperTypes().add(this.getFLID());
		flElementEClass.getESuperTypes().add(this.getFLNameable());
		flElementEClass.getESuperTypes().add(this.getFLRateable());
		flElementEClass.getESuperTypes().add(this.getFLCommentable());
		flElementEClass.getESuperTypes().add(this.getFLHyperLinkable());
		flPackageEClass.getESuperTypes().add(this.getFLElement());
		flCommentEClass.getESuperTypes().add(this.getFLRateable());
		flDataProviderEClass.getESuperTypes().add(this.getFLID());
		flDataProviderEClass.getESuperTypes().add(this.getFLNameable());
		flDataProviderEClass.getESuperTypes().add(this.getFLCommentable());
		flDataProviderEClass.getESuperTypes().add(this.getFLHyperLinkable());

		// Initialize classes, features, and operations; add parameters
		initEClass(flidEClass, ch.flatland.cdo.model.base.FLID.class, "FLID", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLID_UUID(), this.getFLIdentifier(), "UUID", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLID_ID(), this.getFLIdentifier(), "ID", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLID_ObjectID(), this.getFLIdentifier(), "objectID", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLID_RevisionID(), this.getFLIdentifier(), "revisionID", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLID_Version(), theEcorePackage.getEString(), "version", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLID_CDate(), theEcorePackage.getEDate(), "cDate", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLID_UDate(), theEcorePackage.getEDate(), "uDate", null, 0, 1, ch.flatland.cdo.model.base.FLID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getFLID__HasPermission__FLID(), theEcorePackage.getEBoolean(), "hasPermission", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFLID(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(flElementEClass, FLElement.class, "FLElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLElement_Traces(), this.getFLTrace(), null, "traces", null, 0, -1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_Properties(), this.getFLProperty(), null, "properties", null, 0, -1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_DataProvider(), this.getFLDataProvider(), this.getFLDataProvider_ProvidedElements(), "dataProvider", null, 0, 1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_UpStreamMappings(), this.getFLElement(), this.getFLElement_DownStreamMappings(), "upStreamMappings", null, 0, -1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_DownStreamMappings(), this.getFLElement(), this.getFLElement_UpStreamMappings(), "downStreamMappings", null, 0, -1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_HorizontalMappings(), this.getFLElement(), this.getFLElement_HorizontalOppositeMappings(), "horizontalMappings", null, 0, -1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_HorizontalOppositeMappings(), this.getFLElement(), this.getFLElement_HorizontalMappings(), "horizontalOppositeMappings", null, 0, -1, FLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToOwn(), this.getFLElement(), null, "traceToOwn", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToUse(), this.getFLElement(), null, "traceToUse", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToRealize(), this.getFLElement(), null, "traceToRealize", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToSpecify(), this.getFLElement(), null, "traceToSpecify", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToImplement(), this.getFLElement(), null, "traceToImplement", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToElaborate(), this.getFLElement(), null, "traceToElaborate", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToDerive(), this.getFLElement(), null, "traceToDerive", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToValidate(), this.getFLElement(), null, "traceToValidate", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToTest(), this.getFLElement(), null, "traceToTest", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToRelate(), this.getFLElement(), null, "traceToRelate", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToAffect(), this.getFLElement(), null, "traceToAffect", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToSatisfy(), this.getFLElement(), null, "traceToSatisfy", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToVerify(), this.getFLElement(), null, "traceToVerify", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToRefine(), this.getFLElement(), null, "traceToRefine", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceToTrack(), this.getFLElement(), null, "traceToTrack", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromOwn(), this.getFLElement(), null, "traceFromOwn", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromUse(), this.getFLElement(), null, "traceFromUse", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromRealize(), this.getFLElement(), null, "traceFromRealize", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromSpecify(), this.getFLElement(), null, "traceFromSpecify", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromImplement(), this.getFLElement(), null, "traceFromImplement", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromElaborate(), this.getFLElement(), null, "traceFromElaborate", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromDerive(), this.getFLElement(), null, "traceFromDerive", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromValidate(), this.getFLElement(), null, "traceFromValidate", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromTest(), this.getFLElement(), null, "traceFromTest", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromRelate(), this.getFLElement(), null, "traceFromRelate", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromAffect(), this.getFLElement(), null, "traceFromAffect", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromSatisfy(), this.getFLElement(), null, "traceFromSatisfy", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromVerify(), this.getFLElement(), null, "traceFromVerify", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromRefine(), this.getFLElement(), null, "traceFromRefine", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLElement_TraceFromTrack(), this.getFLElement(), null, "traceFromTrack", null, 0, -1, FLElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getFLElement__ToFilterByType__FLTraceType(), this.getFLElement(), "toFilterByType", 0, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFLTraceType(), "traceType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFLElement__FromFilterByType__FLTraceType(), this.getFLElement(), "fromFilterByType", 0, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFLTraceType(), "traceType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFLElement__ResolveXrefs__EReference_Class(), null, "resolveXrefs", 0, 1, !IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		EGenericType g1 = createEGenericType(theEcorePackage.getEObject());
		t1.getEBounds().add(g1);
		addEParameter(op, theEcorePackage.getEReference(), "eRefernce", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "classType", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEEList());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(flPackageEClass, FLPackage.class, "FLPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLPackage_Elements(), this.getFLElement(), null, "elements", null, 0, -1, FLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLPackage_SubPackages(), this.getFLPackage(), null, "subPackages", null, 0, -1, FLPackage.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFLPackage_Contents(), this.getFLElement(), null, "contents", null, 0, -1, FLPackage.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getFLPackage__FilterSubPackages(), this.getFLPackage(), "filterSubPackages", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getFLPackage__FilterContents(), this.getFLElement(), "filterContents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(flHyperLinkEClass, FLHyperLink.class, "FLHyperLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLHyperLink_Name(), theEcorePackage.getEString(), "name", null, 0, 1, FLHyperLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLHyperLink_HyperLink(), theEcorePackage.getEString(), "hyperLink", null, 1, 1, FLHyperLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flCommentEClass, FLComment.class, "FLComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLComment_Comment(), this.getFLMarkdown(), "comment", null, 1, 1, FLComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLComment_Comments(), this.getFLComment(), null, "comments", null, 0, -1, FLComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flDataProviderEClass, FLDataProvider.class, "FLDataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLDataProvider_ProvidedElements(), this.getFLElement(), this.getFLElement_DataProvider(), "providedElements", null, 0, -1, FLDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flCommentableEClass, FLCommentable.class, "FLCommentable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLCommentable_Comments(), this.getFLComment(), null, "comments", null, 0, -1, FLCommentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flHyperLinkableEClass, FLHyperLinkable.class, "FLHyperLinkable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLHyperLinkable_HyperLinks(), this.getFLHyperLink(), null, "hyperLinks", null, 0, -1, FLHyperLinkable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flNameableEClass, FLNameable.class, "FLNameable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLNameable_Name(), theEcorePackage.getEString(), "name", null, 1, 1, FLNameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLNameable_Description(), this.getFLMarkdown(), "description", null, 0, 1, FLNameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLNameable_LongDescription(), this.getFLMarkdown(), "longDescription", null, 0, 1, FLNameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLNameable_Notes(), this.getFLMarkdown(), "notes", null, 0, 1, FLNameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flRateableEClass, FLRateable.class, "FLRateable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFLRateable_Ratings(), this.getFLRating(), null, "ratings", null, 0, -1, FLRateable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLRateable_Likes(), theEcorePackage.getEInt(), "likes", null, 0, 1, FLRateable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLRateable_Dislikes(), theEcorePackage.getEInt(), "dislikes", null, 0, 1, FLRateable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getFLRateable__CountLikes(), theEcorePackage.getEInt(), "countLikes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getFLRateable__CountDislikes(), theEcorePackage.getEInt(), "countDislikes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(flGlobalSearchEClass, FLGlobalSearch.class, "FLGlobalSearch", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(flRatingEClass, FLRating.class, "FLRating", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLRating_RatingType(), this.getFLRatingType(), "ratingType", null, 1, 1, FLRating.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flTraceEClass, FLTrace.class, "FLTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLTrace_TraceType(), this.getFLTraceType(), "traceType", null, 1, 1, FLTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFLTrace_Target(), this.getFLElement(), null, "target", null, 1, 1, FLTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flPropertyEClass, FLProperty.class, "FLProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFLProperty_Name(), this.getFLIdentifier(), "name", null, 1, 1, FLProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFLProperty_Value(), theEcorePackage.getEString(), "value", null, 1, 1, FLProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(flRatingTypeEEnum, FLRatingType.class, "FLRatingType");
		addEEnumLiteral(flRatingTypeEEnum, FLRatingType.LIKE);
		addEEnumLiteral(flRatingTypeEEnum, FLRatingType.DISLIKE);

		initEEnum(flTraceTypeEEnum, FLTraceType.class, "FLTraceType");
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.OWN);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.USE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.REALIZE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.SPECIFY);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.IMPLEMENT);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.ELABORATE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.DERIVE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.VALIDATE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.TEST);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.RELATE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.AFFECT);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.SATISFY);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.VERIFY);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.REFINE);
		addEEnumLiteral(flTraceTypeEEnum, FLTraceType.TRACK);

		// Initialize data types
		initEDataType(flIdentifierEDataType, String.class, "FLIdentifier", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(flMarkdownEDataType, String.class, "FLMarkdown", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (getFLComment_Comment(),
		   source,
		   new String[] {
			   "columnType", "CLOB"
		   });
		addAnnotation
		  (getFLNameable_Description(),
		   source,
		   new String[] {
			   "columnType", "CLOB"
		   });
		addAnnotation
		  (getFLNameable_LongDescription(),
		   source,
		   new String[] {
			   "columnType", "CLOB"
		   });
		addAnnotation
		  (getFLNameable_Notes(),
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
		  (flIdentifierEDataType,
		   source,
		   new String[] {
			   "name", "FLIdentifier",
			   "pattern", "[a-zA-Z0-9_\\-\\.]*"
		   });
	}

} //BasePackageImpl
