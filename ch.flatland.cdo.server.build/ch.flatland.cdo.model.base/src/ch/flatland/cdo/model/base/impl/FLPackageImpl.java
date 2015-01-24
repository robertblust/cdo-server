/**
 */
package ch.flatland.cdo.model.base.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLPackage;
import com.google.common.collect.Iterables;
import java.lang.Iterable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLPackageImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLPackageImpl#getSubPackages <em>Sub Packages</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLPackageImpl#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FLPackageImpl extends FLElementImpl implements FLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLElement> getElements() {
		return (EList<FLElement>)eDynamicGet(BasePackage.FL_PACKAGE__ELEMENTS, BasePackage.Literals.FL_PACKAGE__ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLPackage> getSubPackages() {
		EList<FLElement> _elements = this.getElements();
		Iterable<FLPackage> _filter = Iterables.<FLPackage>filter(_elements, FLPackage.class);
		return ECollections.<FLPackage>asEList(((FLPackage[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_filter, FLPackage.class)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getContents() {
		EList<FLElement> _elements = this.getElements();
		final Function1<FLElement, Boolean> _function = new Function1<FLElement, Boolean>() {
			public Boolean apply(final FLElement it) {
				return Boolean.valueOf((!(it instanceof FLPackage)));
			}
		};
		Iterable<FLElement> _filter = IterableExtensions.<FLElement>filter(_elements, _function);
		return ECollections.<FLElement>asEList(((FLElement[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_filter, FLElement.class)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_PACKAGE__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FL_PACKAGE__ELEMENTS:
				return getElements();
			case BasePackage.FL_PACKAGE__SUB_PACKAGES:
				return getSubPackages();
			case BasePackage.FL_PACKAGE__CONTENTS:
				return getContents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasePackage.FL_PACKAGE__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends FLElement>)newValue);
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
			case BasePackage.FL_PACKAGE__ELEMENTS:
				getElements().clear();
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
			case BasePackage.FL_PACKAGE__ELEMENTS:
				return !getElements().isEmpty();
			case BasePackage.FL_PACKAGE__SUB_PACKAGES:
				return !getSubPackages().isEmpty();
			case BasePackage.FL_PACKAGE__CONTENTS:
				return !getContents().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FLPackageImpl
