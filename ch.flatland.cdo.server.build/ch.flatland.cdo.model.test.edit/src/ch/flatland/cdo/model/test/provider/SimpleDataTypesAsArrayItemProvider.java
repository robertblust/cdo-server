/**
 */
package ch.flatland.cdo.model.test.provider;


import ch.flatland.cdo.model.test.SimpleDataTypesAsArray;
import ch.flatland.cdo.model.test.TestPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
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
 * This is the item provider adapter for a {@link ch.flatland.cdo.model.test.SimpleDataTypesAsArray} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleDataTypesAsArrayItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleDataTypesAsArrayItemProvider(AdapterFactory adapterFactory) {
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

			addTestStringPropertyDescriptor(object);
			addTestBooleanPropertyDescriptor(object);
			addTestIntPropertyDescriptor(object);
			addTestLongPropertyDescriptor(object);
			addTestShortPropertyDescriptor(object);
			addTestDoublePropertyDescriptor(object);
			addTestFloatPropertyDescriptor(object);
			addTestBytePropertyDescriptor(object);
			addTestCharPropertyDescriptor(object);
			addTestDatePropertyDescriptor(object);
			addTestBigDecimalPropertyDescriptor(object);
			addTestBigIntegerPropertyDescriptor(object);
			addTestEnumPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Test String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestStringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testString_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testString_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_STRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Boolean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestBooleanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testBoolean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testBoolean_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BOOLEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Int feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestIntPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testInt_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testInt_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_INT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Long feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestLongPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testLong_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testLong_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_LONG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Short feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestShortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testShort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testShort_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_SHORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Double feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestDoublePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testDouble_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testDouble_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DOUBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Float feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestFloatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testFloat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testFloat_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_FLOAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Byte feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestBytePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testByte_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testByte_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BYTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Char feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestCharPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testChar_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testChar_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_CHAR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testDate_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Big Decimal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestBigDecimalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testBigDecimal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testBigDecimal_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_DECIMAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Big Integer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestBigIntegerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testBigInteger_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testBigInteger_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_INTEGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Test Enum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTestEnumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimpleDataTypesAsArray_testEnum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimpleDataTypesAsArray_testEnum_feature", "_UI_SimpleDataTypesAsArray_type"),
				 TestPackage.Literals.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_ENUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns SimpleDataTypesAsArray.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SimpleDataTypesAsArray"));
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
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SimpleDataTypesAsArray_type");
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

		switch (notification.getFeatureID(SimpleDataTypesAsArray.class)) {
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_STRING:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BOOLEAN:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_INT:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_LONG:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_SHORT:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DOUBLE:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_FLOAT:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BYTE:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_CHAR:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_DATE:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_DECIMAL:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_BIG_INTEGER:
			case TestPackage.SIMPLE_DATA_TYPES_AS_ARRAY__TEST_ENUM:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TestEditPlugin.INSTANCE;
	}

}
