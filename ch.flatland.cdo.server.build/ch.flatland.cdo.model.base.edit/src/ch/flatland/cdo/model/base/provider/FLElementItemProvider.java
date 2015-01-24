/**
 */
package ch.flatland.cdo.model.base.provider;


import ch.flatland.cdo.model.base.BaseFactory;
import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLElement;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ch.flatland.cdo.model.base.FLElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FLElementItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addTraceToOwnPropertyDescriptor(object);
			addTraceToUsePropertyDescriptor(object);
			addTraceToRealizePropertyDescriptor(object);
			addTraceToSpecifyPropertyDescriptor(object);
			addTraceToImplementPropertyDescriptor(object);
			addTraceToElaboratePropertyDescriptor(object);
			addTraceToDerivePropertyDescriptor(object);
			addTraceToValidatePropertyDescriptor(object);
			addTraceToTestPropertyDescriptor(object);
			addTraceToRelatePropertyDescriptor(object);
			addTraceToAffectPropertyDescriptor(object);
			addTraceToSatisfyPropertyDescriptor(object);
			addTraceToVerifyPropertyDescriptor(object);
			addTraceToRefinePropertyDescriptor(object);
			addTraceToTrackPropertyDescriptor(object);
			addTraceFromOwnPropertyDescriptor(object);
			addTraceFromUsePropertyDescriptor(object);
			addTraceFromRealizePropertyDescriptor(object);
			addTraceFromSpecifyPropertyDescriptor(object);
			addTraceFromImplementPropertyDescriptor(object);
			addTraceFromElaboratePropertyDescriptor(object);
			addTraceFromDerivePropertyDescriptor(object);
			addTraceFromValidatePropertyDescriptor(object);
			addTraceFromTestPropertyDescriptor(object);
			addTraceFromRelatePropertyDescriptor(object);
			addTraceFromAffectPropertyDescriptor(object);
			addTraceFromSatisfyPropertyDescriptor(object);
			addTraceFromVerifyPropertyDescriptor(object);
			addTraceFromRefinePropertyDescriptor(object);
			addTraceFromTrackPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_name_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_description_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__DESCRIPTION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Own feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToOwnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToOwn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToOwn_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_OWN,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Use feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToUsePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToUse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToUse_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_USE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Realize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToRealizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToRealize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToRealize_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_REALIZE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Specify feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToSpecifyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToSpecify_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToSpecify_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_SPECIFY,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Implement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToImplementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToImplement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToImplement_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_IMPLEMENT,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Elaborate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToElaboratePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToElaborate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToElaborate_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_ELABORATE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Derive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToDerivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToDerive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToDerive_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_DERIVE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Validate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToValidatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToValidate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToValidate_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_VALIDATE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Test feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToTestPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToTest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToTest_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_TEST,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Relate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToRelatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToRelate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToRelate_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_RELATE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Affect feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToAffectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToAffect_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToAffect_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_AFFECT,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Satisfy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToSatisfyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToSatisfy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToSatisfy_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_SATISFY,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Verify feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToVerifyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToVerify_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToVerify_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_VERIFY,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Refine feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToRefinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToRefine_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToRefine_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_REFINE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace To Track feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceToTrackPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceToTrack_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceToTrack_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_TO_TRACK,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracetoPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Own feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromOwnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromOwn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromOwn_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_OWN,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Use feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromUsePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromUse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromUse_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_USE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Realize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromRealizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromRealize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromRealize_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_REALIZE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Specify feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromSpecifyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromSpecify_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromSpecify_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_SPECIFY,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Implement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromImplementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromImplement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromImplement_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_IMPLEMENT,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Elaborate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromElaboratePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromElaborate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromElaborate_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_ELABORATE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Derive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromDerivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromDerive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromDerive_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_DERIVE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Validate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromValidatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromValidate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromValidate_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_VALIDATE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Test feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromTestPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromTest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromTest_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_TEST,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Relate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromRelatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromRelate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromRelate_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_RELATE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Affect feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromAffectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromAffect_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromAffect_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_AFFECT,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Satisfy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromSatisfyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromSatisfy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromSatisfy_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_SATISFY,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Verify feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromVerifyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromVerify_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromVerify_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_VERIFY,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Refine feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromRefinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromRefine_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromRefine_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_REFINE,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace From Track feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceFromTrackPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_traceFromTrack_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_traceFromTrack_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__TRACE_FROM_TRACK,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TracefromPropertyCategory"),
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(BasePackage.Literals.FL_ELEMENT__TRACES);
			childrenFeatures.add(BasePackage.Literals.FL_ELEMENT__PROPERTIES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((FLElement)object).getName();
		return label == null || label.length() == 0 ?
			"?" :
			label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FLElement.class)) {
			case BasePackage.FL_ELEMENT__NAME:
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case BasePackage.FL_ELEMENT__TRACES:
			case BasePackage.FL_ELEMENT__PROPERTIES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(BasePackage.Literals.FL_ELEMENT__TRACES,
				 BaseFactory.eINSTANCE.createFLTrace()));

		newChildDescriptors.add
			(createChildParameter
				(BasePackage.Literals.FL_ELEMENT__PROPERTIES,
				 BaseFactory.eINSTANCE.createFLProperty()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ((IChildCreationExtender)adapterFactory).getResourceLocator();
	}

}
