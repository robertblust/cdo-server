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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ch.flatland.cdo.model.base.FLElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FLElementItemProvider 
	extends FLIDItemProvider {
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
			addLongDescriptionPropertyDescriptor(object);
			addNotesPropertyDescriptor(object);
			addLikesPropertyDescriptor(object);
			addDislikesPropertyDescriptor(object);
			addDataProviderPropertyDescriptor(object);
			addUpStreamMappingsPropertyDescriptor(object);
			addDownStreamMappingsPropertyDescriptor(object);
			addHorizontalMappingsPropertyDescriptor(object);
			addHorizontalOppositeMappingsPropertyDescriptor(object);
			addDerivedContainerPropertyDescriptor(object);
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
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Likes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLikesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rateable_likes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rateable_likes_feature", "_UI_Rateable_type"),
				 BasePackage.Literals.RATEABLE__LIKES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_RatingPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Dislikes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDislikesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Rateable_dislikes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Rateable_dislikes_feature", "_UI_Rateable_type"),
				 BasePackage.Literals.RATEABLE__DISLIKES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_RatingPropertyCategory"),
				 null));
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
				 getString("_UI_Nameable_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Nameable_name_feature", "_UI_Nameable_type"),
				 BasePackage.Literals.NAMEABLE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_NamedElementPropertyCategory"),
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
				 getString("_UI_Nameable_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Nameable_description_feature", "_UI_Nameable_type"),
				 BasePackage.Literals.NAMEABLE__DESCRIPTION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_NamedElementPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Long Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLongDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Nameable_longDescription_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Nameable_longDescription_feature", "_UI_Nameable_type"),
				 BasePackage.Literals.NAMEABLE__LONG_DESCRIPTION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_NamedElementPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Notes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Nameable_notes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Nameable_notes_feature", "_UI_Nameable_type"),
				 BasePackage.Literals.NAMEABLE__NOTES,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_NamedElementPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Data Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_dataProvider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_dataProvider_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__DATA_PROVIDER,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasePropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Up Stream Mappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpStreamMappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_upStreamMappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_upStreamMappings_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__UP_STREAM_MAPPINGS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_MappingPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Down Stream Mappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDownStreamMappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_downStreamMappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_downStreamMappings_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__DOWN_STREAM_MAPPINGS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_MappingPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Horizontal Mappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHorizontalMappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_horizontalMappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_horizontalMappings_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__HORIZONTAL_MAPPINGS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_MappingPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Horizontal Opposite Mappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHorizontalOppositeMappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_horizontalOppositeMappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_horizontalOppositeMappings_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_MappingPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Derived Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDerivedContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FLElement_derivedContainer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FLElement_derivedContainer_feature", "_UI_FLElement_type"),
				 BasePackage.Literals.FL_ELEMENT__DERIVED_CONTAINER,
				 false,
				 false,
				 false,
				 null,
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
			childrenFeatures.add(BasePackage.Literals.RATEABLE__RATINGS);
			childrenFeatures.add(BasePackage.Literals.COMMENTABLE__COMMENTS);
			childrenFeatures.add(BasePackage.Literals.HYPER_LINKABLE__HYPER_LINKS);
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
		String id =  ((FLElement)object).getID();
		if (id != null) {
			label = "[" + id + "] " + label;
		}
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
			case BasePackage.FL_ELEMENT__LONG_DESCRIPTION:
			case BasePackage.FL_ELEMENT__NOTES:
			case BasePackage.FL_ELEMENT__LIKES:
			case BasePackage.FL_ELEMENT__DISLIKES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case BasePackage.FL_ELEMENT__RATINGS:
			case BasePackage.FL_ELEMENT__COMMENTS:
			case BasePackage.FL_ELEMENT__HYPER_LINKS:
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
				(BasePackage.Literals.RATEABLE__RATINGS,
				 BaseFactory.eINSTANCE.createFLRating()));

		newChildDescriptors.add
			(createChildParameter
				(BasePackage.Literals.COMMENTABLE__COMMENTS,
				 BaseFactory.eINSTANCE.createFLComment()));

		newChildDescriptors.add
			(createChildParameter
				(BasePackage.Literals.HYPER_LINKABLE__HYPER_LINKS,
				 BaseFactory.eINSTANCE.createFLHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(BasePackage.Literals.FL_ELEMENT__TRACES,
				 BaseFactory.eINSTANCE.createFLTrace()));

		newChildDescriptors.add
			(createChildParameter
				(BasePackage.Literals.FL_ELEMENT__PROPERTIES,
				 BaseFactory.eINSTANCE.createFLProperty()));
	}

}
