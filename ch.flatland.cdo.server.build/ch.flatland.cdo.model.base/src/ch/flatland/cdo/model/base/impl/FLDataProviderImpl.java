/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLCommentable;
import ch.flatland.cdo.model.base.FLComment;
import ch.flatland.cdo.model.base.FLDataProvider;

import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLHyperLink;
import ch.flatland.cdo.model.base.FLHyperLinkable;
import ch.flatland.cdo.model.base.FLNameable;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLDataProviderImpl#getProvidedElements <em>Provided Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FLDataProviderImpl extends FLIDImpl implements FLDataProvider {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_DESCRIPTION_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLDataProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_DATA_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)eDynamicGet(BasePackage.FL_DATA_PROVIDER__NAME, BasePackage.Literals.FL_NAMEABLE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(BasePackage.FL_DATA_PROVIDER__NAME, BasePackage.Literals.FL_NAMEABLE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String)eDynamicGet(BasePackage.FL_DATA_PROVIDER__DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eDynamicSet(BasePackage.FL_DATA_PROVIDER__DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongDescription() {
		return (String)eDynamicGet(BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__LONG_DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongDescription(String newLongDescription) {
		eDynamicSet(BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__LONG_DESCRIPTION, newLongDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNotes() {
		return (String)eDynamicGet(BasePackage.FL_DATA_PROVIDER__NOTES, BasePackage.Literals.FL_NAMEABLE__NOTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNotes(String newNotes) {
		eDynamicSet(BasePackage.FL_DATA_PROVIDER__NOTES, BasePackage.Literals.FL_NAMEABLE__NOTES, newNotes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<FLHyperLink> getHyperLinks() {
		return (EList<FLHyperLink>)eDynamicGet(BasePackage.FL_DATA_PROVIDER__HYPER_LINKS, BasePackage.Literals.FL_HYPER_LINKABLE__HYPER_LINKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<FLComment> getComments() {
		return (EList<FLComment>)eDynamicGet(BasePackage.FL_DATA_PROVIDER__COMMENTS, BasePackage.Literals.FL_COMMENTABLE__COMMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<FLElement> getProvidedElements() {
		return (EList<FLElement>)eDynamicGet(BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS, BasePackage.Literals.FL_DATA_PROVIDER__PROVIDED_ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_DATA_PROVIDER__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_DATA_PROVIDER__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS:
				return ((InternalEList<?>)getProvidedElements()).basicRemove(otherEnd, msgs);
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
			case BasePackage.FL_DATA_PROVIDER__NAME:
				return getName();
			case BasePackage.FL_DATA_PROVIDER__DESCRIPTION:
				return getDescription();
			case BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION:
				return getLongDescription();
			case BasePackage.FL_DATA_PROVIDER__NOTES:
				return getNotes();
			case BasePackage.FL_DATA_PROVIDER__COMMENTS:
				return getComments();
			case BasePackage.FL_DATA_PROVIDER__HYPER_LINKS:
				return getHyperLinks();
			case BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS:
				return getProvidedElements();
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
			case BasePackage.FL_DATA_PROVIDER__NAME:
				setName((String)newValue);
				return;
			case BasePackage.FL_DATA_PROVIDER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION:
				setLongDescription((String)newValue);
				return;
			case BasePackage.FL_DATA_PROVIDER__NOTES:
				setNotes((String)newValue);
				return;
			case BasePackage.FL_DATA_PROVIDER__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends FLComment>)newValue);
				return;
			case BasePackage.FL_DATA_PROVIDER__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends FLHyperLink>)newValue);
				return;
			case BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS:
				getProvidedElements().clear();
				getProvidedElements().addAll((Collection<? extends FLElement>)newValue);
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
			case BasePackage.FL_DATA_PROVIDER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasePackage.FL_DATA_PROVIDER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION:
				setLongDescription(LONG_DESCRIPTION_EDEFAULT);
				return;
			case BasePackage.FL_DATA_PROVIDER__NOTES:
				setNotes(NOTES_EDEFAULT);
				return;
			case BasePackage.FL_DATA_PROVIDER__COMMENTS:
				getComments().clear();
				return;
			case BasePackage.FL_DATA_PROVIDER__HYPER_LINKS:
				getHyperLinks().clear();
				return;
			case BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS:
				getProvidedElements().clear();
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
			case BasePackage.FL_DATA_PROVIDER__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case BasePackage.FL_DATA_PROVIDER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION:
				return LONG_DESCRIPTION_EDEFAULT == null ? getLongDescription() != null : !LONG_DESCRIPTION_EDEFAULT.equals(getLongDescription());
			case BasePackage.FL_DATA_PROVIDER__NOTES:
				return NOTES_EDEFAULT == null ? getNotes() != null : !NOTES_EDEFAULT.equals(getNotes());
			case BasePackage.FL_DATA_PROVIDER__COMMENTS:
				return !getComments().isEmpty();
			case BasePackage.FL_DATA_PROVIDER__HYPER_LINKS:
				return !getHyperLinks().isEmpty();
			case BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS:
				return !getProvidedElements().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FLNameable.class) {
			switch (derivedFeatureID) {
				case BasePackage.FL_DATA_PROVIDER__NAME: return BasePackage.FL_NAMEABLE__NAME;
				case BasePackage.FL_DATA_PROVIDER__DESCRIPTION: return BasePackage.FL_NAMEABLE__DESCRIPTION;
				case BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION: return BasePackage.FL_NAMEABLE__LONG_DESCRIPTION;
				case BasePackage.FL_DATA_PROVIDER__NOTES: return BasePackage.FL_NAMEABLE__NOTES;
				default: return -1;
			}
		}
		if (baseClass == FLCommentable.class) {
			switch (derivedFeatureID) {
				case BasePackage.FL_DATA_PROVIDER__COMMENTS: return BasePackage.FL_COMMENTABLE__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == FLHyperLinkable.class) {
			switch (derivedFeatureID) {
				case BasePackage.FL_DATA_PROVIDER__HYPER_LINKS: return BasePackage.FL_HYPER_LINKABLE__HYPER_LINKS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FLNameable.class) {
			switch (baseFeatureID) {
				case BasePackage.FL_NAMEABLE__NAME: return BasePackage.FL_DATA_PROVIDER__NAME;
				case BasePackage.FL_NAMEABLE__DESCRIPTION: return BasePackage.FL_DATA_PROVIDER__DESCRIPTION;
				case BasePackage.FL_NAMEABLE__LONG_DESCRIPTION: return BasePackage.FL_DATA_PROVIDER__LONG_DESCRIPTION;
				case BasePackage.FL_NAMEABLE__NOTES: return BasePackage.FL_DATA_PROVIDER__NOTES;
				default: return -1;
			}
		}
		if (baseClass == FLCommentable.class) {
			switch (baseFeatureID) {
				case BasePackage.FL_COMMENTABLE__COMMENTS: return BasePackage.FL_DATA_PROVIDER__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == FLHyperLinkable.class) {
			switch (baseFeatureID) {
				case BasePackage.FL_HYPER_LINKABLE__HYPER_LINKS: return BasePackage.FL_DATA_PROVIDER__HYPER_LINKS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FLDataProviderImpl
