/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.BasePackage.Literals;
import ch.flatland.cdo.model.base.FLCommentable;
import ch.flatland.cdo.model.base.FLComment;
import ch.flatland.cdo.model.base.FLDataProvider;
import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLHyperLink;
import ch.flatland.cdo.model.base.FLProperty;
import ch.flatland.cdo.model.base.FLRating;
import ch.flatland.cdo.model.base.FLRatingType;
import ch.flatland.cdo.model.base.FLTrace;
import ch.flatland.cdo.model.base.FLTraceType;
import ch.flatland.cdo.model.base.FLHyperLinkable;
import ch.flatland.cdo.model.base.FLNameable;
import ch.flatland.cdo.model.base.FLRateable;
import com.google.common.base.Objects;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getRatings <em>Ratings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getLikes <em>Likes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getDislikes <em>Dislikes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraces <em>Traces</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getUpStreamMappings <em>Up Stream Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getDownStreamMappings <em>Down Stream Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getHorizontalMappings <em>Horizontal Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getHorizontalOppositeMappings <em>Horizontal Opposite Mappings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToOwn <em>Trace To Own</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToUse <em>Trace To Use</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRealize <em>Trace To Realize</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToSpecify <em>Trace To Specify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToImplement <em>Trace To Implement</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToElaborate <em>Trace To Elaborate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToDerive <em>Trace To Derive</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToValidate <em>Trace To Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToTest <em>Trace To Test</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRelate <em>Trace To Relate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToAffect <em>Trace To Affect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToSatisfy <em>Trace To Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToVerify <em>Trace To Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRefine <em>Trace To Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToTrack <em>Trace To Track</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromOwn <em>Trace From Own</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromUse <em>Trace From Use</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromRealize <em>Trace From Realize</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromSpecify <em>Trace From Specify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromImplement <em>Trace From Implement</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromElaborate <em>Trace From Elaborate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromDerive <em>Trace From Derive</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromValidate <em>Trace From Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromTest <em>Trace From Test</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromRelate <em>Trace From Relate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromAffect <em>Trace From Affect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromSatisfy <em>Trace From Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromVerify <em>Trace From Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromRefine <em>Trace From Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromTrack <em>Trace From Track</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FLElementImpl extends FLIDImpl implements FLElement {
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
	 * The default value of the '{@link #getLikes() <em>Likes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikes()
	 * @generated
	 * @ordered
	 */
	protected static final int LIKES_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getDislikes() <em>Dislikes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDislikes()
	 * @generated
	 * @ordered
	 */
	protected static final int DISLIKES_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__NAME, BasePackage.Literals.FL_NAMEABLE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(BasePackage.FL_ELEMENT__NAME, BasePackage.Literals.FL_NAMEABLE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(BasePackage.FL_ELEMENT__DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongDescription() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__LONG_DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__LONG_DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongDescription(String newLongDescription) {
		eDynamicSet(BasePackage.FL_ELEMENT__LONG_DESCRIPTION, BasePackage.Literals.FL_NAMEABLE__LONG_DESCRIPTION, newLongDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__NOTES, BasePackage.Literals.FL_NAMEABLE__NOTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotes(String newNotes) {
		eDynamicSet(BasePackage.FL_ELEMENT__NOTES, BasePackage.Literals.FL_NAMEABLE__NOTES, newNotes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLTrace> getTraces() {
		return (EList<FLTrace>)eDynamicGet(BasePackage.FL_ELEMENT__TRACES, BasePackage.Literals.FL_ELEMENT__TRACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLProperty> getProperties() {
		return (EList<FLProperty>)eDynamicGet(BasePackage.FL_ELEMENT__PROPERTIES, BasePackage.Literals.FL_ELEMENT__PROPERTIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLHyperLink> getHyperLinks() {
		return (EList<FLHyperLink>)eDynamicGet(BasePackage.FL_ELEMENT__HYPER_LINKS, BasePackage.Literals.FL_HYPER_LINKABLE__HYPER_LINKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLComment> getComments() {
		return (EList<FLComment>)eDynamicGet(BasePackage.FL_ELEMENT__COMMENTS, BasePackage.Literals.FL_COMMENTABLE__COMMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLDataProvider getDataProvider() {
		return (FLDataProvider)eDynamicGet(BasePackage.FL_ELEMENT__DATA_PROVIDER, BasePackage.Literals.FL_ELEMENT__DATA_PROVIDER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLDataProvider basicGetDataProvider() {
		return (FLDataProvider)eDynamicGet(BasePackage.FL_ELEMENT__DATA_PROVIDER, BasePackage.Literals.FL_ELEMENT__DATA_PROVIDER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataProvider(FLDataProvider newDataProvider, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newDataProvider, BasePackage.FL_ELEMENT__DATA_PROVIDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataProvider(FLDataProvider newDataProvider) {
		eDynamicSet(BasePackage.FL_ELEMENT__DATA_PROVIDER, BasePackage.Literals.FL_ELEMENT__DATA_PROVIDER, newDataProvider);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLElement> getUpStreamMappings() {
		return (EList<FLElement>)eDynamicGet(BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS, BasePackage.Literals.FL_ELEMENT__UP_STREAM_MAPPINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLRating> getRatings() {
		return (EList<FLRating>)eDynamicGet(BasePackage.FL_ELEMENT__RATINGS, BasePackage.Literals.FL_RATEABLE__RATINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getLikes() {
		return this.countLikes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDislikes() {
		return this.countDislikes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLElement> getDownStreamMappings() {
		return (EList<FLElement>)eDynamicGet(BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS, BasePackage.Literals.FL_ELEMENT__DOWN_STREAM_MAPPINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLElement> getHorizontalMappings() {
		return (EList<FLElement>)eDynamicGet(BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS, BasePackage.Literals.FL_ELEMENT__HORIZONTAL_MAPPINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLElement> getHorizontalOppositeMappings() {
		return (EList<FLElement>)eDynamicGet(BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS, BasePackage.Literals.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToOwn() {
		return this.toFilterByType(FLTraceType.OWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToUse() {
		return this.toFilterByType(FLTraceType.USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRealize() {
		return this.toFilterByType(FLTraceType.REALIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToSpecify() {
		return this.toFilterByType(FLTraceType.SPECIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToImplement() {
		return this.toFilterByType(FLTraceType.IMPLEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToElaborate() {
		return this.toFilterByType(FLTraceType.ELABORATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToDerive() {
		return this.toFilterByType(FLTraceType.DERIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToValidate() {
		return this.toFilterByType(FLTraceType.VALIDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToTest() {
		return this.toFilterByType(FLTraceType.TEST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRelate() {
		return this.toFilterByType(FLTraceType.RELATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToAffect() {
		return this.toFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToffect() {
		return this.toFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToSatisfy() {
		return this.toFilterByType(FLTraceType.SATISFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToVerify() {
		return this.toFilterByType(FLTraceType.VERIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRefine() {
		return this.toFilterByType(FLTraceType.REFINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToTrack() {
		return this.toFilterByType(FLTraceType.TRACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromOwn() {
		return this.fromFilterByType(FLTraceType.OWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromUse() {
		return this.fromFilterByType(FLTraceType.USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromRealize() {
		return this.fromFilterByType(FLTraceType.REALIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromSpecify() {
		return this.fromFilterByType(FLTraceType.SPECIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromImplement() {
		return this.fromFilterByType(FLTraceType.IMPLEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromElaborate() {
		return this.fromFilterByType(FLTraceType.ELABORATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromDerive() {
		return this.fromFilterByType(FLTraceType.DERIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromValidate() {
		return this.fromFilterByType(FLTraceType.VALIDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromTest() {
		return this.fromFilterByType(FLTraceType.TEST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromRelate() {
		return this.fromFilterByType(FLTraceType.RELATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromAffect() {
		return this.fromFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromffect() {
		return this.fromFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromSatisfy() {
		return this.fromFilterByType(FLTraceType.SATISFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromVerify() {
		return this.fromFilterByType(FLTraceType.VERIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromRefine() {
		return this.fromFilterByType(FLTraceType.REFINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromTrack() {
		return this.fromFilterByType(FLTraceType.TRACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FLElement> toFilterByType(final FLTraceType traceType) {
		final BasicEList<FLElement> targets = new BasicEList<FLElement>();
		final Function1<FLTrace, Boolean> _function = new Function1<FLTrace, Boolean>() {
			public Boolean apply(final FLTrace it) {
				FLTraceType _traceType = it.getTraceType();
				return Boolean.valueOf(Objects.equal(_traceType, traceType));
			}
		};
		final Consumer<FLTrace> _function_1 = new Consumer<FLTrace>() {
			public void accept(final FLTrace it) {
				FLElement _target = it.getTarget();
				boolean _notEquals = (!Objects.equal(_target, null));
				if (_notEquals) {
					targets.add(it.getTarget());
				}
			}
		};
		IterableExtensions.<FLTrace>filter(this.getTraces(), _function).forEach(_function_1);
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FLElement> fromFilterByType(final FLTraceType traceType) {
		final BasicEList<FLElement> sources = new BasicEList<FLElement>();
		if (((!Objects.equal(this.cdoView(), null)) && (!this.cdoView().isClosed()))) {
			final List<CDOObjectReference> xrefs = this.cdoView().queryXRefs(this, 
				((EReference[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(CollectionLiterals.<EReference>newArrayList(Literals.FL_TRACE__TARGET), EReference.class)));
			for (final CDOObjectReference x : xrefs) {
				{
					CDOObject _sourceObject = x.getSourceObject();
					final FLTrace trace = ((FLTrace) _sourceObject);
					FLTraceType _traceType = trace.getTraceType();
					boolean _equals = Objects.equal(_traceType, traceType);
					if (_equals) {
						EObject _eContainer = trace.eContainer();
						sources.add(((FLElement) _eContainer));
					}
				}
			}
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends EObject> EList<T> resolveXrefs(final EReference eRefernce, final Class<T> classType) {
		final BasicEList<T> elements = new BasicEList<T>();
		if (((!Objects.equal(this.cdoView(), null)) && (!this.cdoView().isClosed()))) {
			final ArrayList<EReference> eRefs = CollectionLiterals.<EReference>newArrayList();
			boolean _notEquals = (!Objects.equal(eRefernce, null));
			if (_notEquals) {
				eRefs.add(eRefernce);
			}
			final List<CDOObjectReference> xrefs = this.cdoView().queryXRefs(this, ((EReference[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(eRefs, EReference.class)));
			for (final CDOObjectReference x : xrefs) {
				{
					final T element = classType.cast(x.getSourceObject());
					elements.add(element);
				}
			}
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int countLikes() {
		final Function1<FLRating, Boolean> _function = new Function1<FLRating, Boolean>() {
			public Boolean apply(final FLRating it) {
				FLRatingType _ratingType = it.getRatingType();
				return Boolean.valueOf(Objects.equal(_ratingType, FLRatingType.LIKE));
			}
		};
		return IterableExtensions.size(IterableExtensions.<FLRating>filter(this.getRatings(), _function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int countDislikes() {
		final Function1<FLRating, Boolean> _function = new Function1<FLRating, Boolean>() {
			public Boolean apply(final FLRating it) {
				FLRatingType _ratingType = it.getRatingType();
				return Boolean.valueOf(Objects.equal(_ratingType, FLRatingType.DISLIKE));
			}
		};
		return IterableExtensions.size(IterableExtensions.<FLRating>filter(this.getRatings(), _function));
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
			case BasePackage.FL_ELEMENT__DATA_PROVIDER:
				FLDataProvider dataProvider = basicGetDataProvider();
				if (dataProvider != null)
					msgs = ((InternalEObject)dataProvider).eInverseRemove(this, BasePackage.FL_DATA_PROVIDER__PROVIDED_ELEMENTS, FLDataProvider.class, msgs);
				return basicSetDataProvider((FLDataProvider)otherEnd, msgs);
			case BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUpStreamMappings()).basicAdd(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDownStreamMappings()).basicAdd(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHorizontalMappings()).basicAdd(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHorizontalOppositeMappings()).basicAdd(otherEnd, msgs);
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
			case BasePackage.FL_ELEMENT__RATINGS:
				return ((InternalEList<?>)getRatings()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__TRACES:
				return ((InternalEList<?>)getTraces()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__DATA_PROVIDER:
				return basicSetDataProvider(null, msgs);
			case BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS:
				return ((InternalEList<?>)getUpStreamMappings()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS:
				return ((InternalEList<?>)getDownStreamMappings()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS:
				return ((InternalEList<?>)getHorizontalMappings()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS:
				return ((InternalEList<?>)getHorizontalOppositeMappings()).basicRemove(otherEnd, msgs);
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
			case BasePackage.FL_ELEMENT__NAME:
				return getName();
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				return getDescription();
			case BasePackage.FL_ELEMENT__LONG_DESCRIPTION:
				return getLongDescription();
			case BasePackage.FL_ELEMENT__NOTES:
				return getNotes();
			case BasePackage.FL_ELEMENT__RATINGS:
				return getRatings();
			case BasePackage.FL_ELEMENT__LIKES:
				return getLikes();
			case BasePackage.FL_ELEMENT__DISLIKES:
				return getDislikes();
			case BasePackage.FL_ELEMENT__COMMENTS:
				return getComments();
			case BasePackage.FL_ELEMENT__HYPER_LINKS:
				return getHyperLinks();
			case BasePackage.FL_ELEMENT__TRACES:
				return getTraces();
			case BasePackage.FL_ELEMENT__PROPERTIES:
				return getProperties();
			case BasePackage.FL_ELEMENT__DATA_PROVIDER:
				if (resolve) return getDataProvider();
				return basicGetDataProvider();
			case BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS:
				return getUpStreamMappings();
			case BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS:
				return getDownStreamMappings();
			case BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS:
				return getHorizontalMappings();
			case BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS:
				return getHorizontalOppositeMappings();
			case BasePackage.FL_ELEMENT__TRACE_TO_OWN:
				return getTraceToOwn();
			case BasePackage.FL_ELEMENT__TRACE_TO_USE:
				return getTraceToUse();
			case BasePackage.FL_ELEMENT__TRACE_TO_REALIZE:
				return getTraceToRealize();
			case BasePackage.FL_ELEMENT__TRACE_TO_SPECIFY:
				return getTraceToSpecify();
			case BasePackage.FL_ELEMENT__TRACE_TO_IMPLEMENT:
				return getTraceToImplement();
			case BasePackage.FL_ELEMENT__TRACE_TO_ELABORATE:
				return getTraceToElaborate();
			case BasePackage.FL_ELEMENT__TRACE_TO_DERIVE:
				return getTraceToDerive();
			case BasePackage.FL_ELEMENT__TRACE_TO_VALIDATE:
				return getTraceToValidate();
			case BasePackage.FL_ELEMENT__TRACE_TO_TEST:
				return getTraceToTest();
			case BasePackage.FL_ELEMENT__TRACE_TO_RELATE:
				return getTraceToRelate();
			case BasePackage.FL_ELEMENT__TRACE_TO_AFFECT:
				return getTraceToAffect();
			case BasePackage.FL_ELEMENT__TRACE_TO_SATISFY:
				return getTraceToSatisfy();
			case BasePackage.FL_ELEMENT__TRACE_TO_VERIFY:
				return getTraceToVerify();
			case BasePackage.FL_ELEMENT__TRACE_TO_REFINE:
				return getTraceToRefine();
			case BasePackage.FL_ELEMENT__TRACE_TO_TRACK:
				return getTraceToTrack();
			case BasePackage.FL_ELEMENT__TRACE_FROM_OWN:
				return getTraceFromOwn();
			case BasePackage.FL_ELEMENT__TRACE_FROM_USE:
				return getTraceFromUse();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REALIZE:
				return getTraceFromRealize();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SPECIFY:
				return getTraceFromSpecify();
			case BasePackage.FL_ELEMENT__TRACE_FROM_IMPLEMENT:
				return getTraceFromImplement();
			case BasePackage.FL_ELEMENT__TRACE_FROM_ELABORATE:
				return getTraceFromElaborate();
			case BasePackage.FL_ELEMENT__TRACE_FROM_DERIVE:
				return getTraceFromDerive();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VALIDATE:
				return getTraceFromValidate();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TEST:
				return getTraceFromTest();
			case BasePackage.FL_ELEMENT__TRACE_FROM_RELATE:
				return getTraceFromRelate();
			case BasePackage.FL_ELEMENT__TRACE_FROM_AFFECT:
				return getTraceFromAffect();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SATISFY:
				return getTraceFromSatisfy();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VERIFY:
				return getTraceFromVerify();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REFINE:
				return getTraceFromRefine();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TRACK:
				return getTraceFromTrack();
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
			case BasePackage.FL_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__LONG_DESCRIPTION:
				setLongDescription((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__NOTES:
				setNotes((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__RATINGS:
				getRatings().clear();
				getRatings().addAll((Collection<? extends FLRating>)newValue);
				return;
			case BasePackage.FL_ELEMENT__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends FLComment>)newValue);
				return;
			case BasePackage.FL_ELEMENT__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends FLHyperLink>)newValue);
				return;
			case BasePackage.FL_ELEMENT__TRACES:
				getTraces().clear();
				getTraces().addAll((Collection<? extends FLTrace>)newValue);
				return;
			case BasePackage.FL_ELEMENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends FLProperty>)newValue);
				return;
			case BasePackage.FL_ELEMENT__DATA_PROVIDER:
				setDataProvider((FLDataProvider)newValue);
				return;
			case BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS:
				getUpStreamMappings().clear();
				getUpStreamMappings().addAll((Collection<? extends FLElement>)newValue);
				return;
			case BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS:
				getDownStreamMappings().clear();
				getDownStreamMappings().addAll((Collection<? extends FLElement>)newValue);
				return;
			case BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS:
				getHorizontalMappings().clear();
				getHorizontalMappings().addAll((Collection<? extends FLElement>)newValue);
				return;
			case BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS:
				getHorizontalOppositeMappings().clear();
				getHorizontalOppositeMappings().addAll((Collection<? extends FLElement>)newValue);
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
			case BasePackage.FL_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__LONG_DESCRIPTION:
				setLongDescription(LONG_DESCRIPTION_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__NOTES:
				setNotes(NOTES_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__RATINGS:
				getRatings().clear();
				return;
			case BasePackage.FL_ELEMENT__COMMENTS:
				getComments().clear();
				return;
			case BasePackage.FL_ELEMENT__HYPER_LINKS:
				getHyperLinks().clear();
				return;
			case BasePackage.FL_ELEMENT__TRACES:
				getTraces().clear();
				return;
			case BasePackage.FL_ELEMENT__PROPERTIES:
				getProperties().clear();
				return;
			case BasePackage.FL_ELEMENT__DATA_PROVIDER:
				setDataProvider((FLDataProvider)null);
				return;
			case BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS:
				getUpStreamMappings().clear();
				return;
			case BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS:
				getDownStreamMappings().clear();
				return;
			case BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS:
				getHorizontalMappings().clear();
				return;
			case BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS:
				getHorizontalOppositeMappings().clear();
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
			case BasePackage.FL_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case BasePackage.FL_ELEMENT__LONG_DESCRIPTION:
				return LONG_DESCRIPTION_EDEFAULT == null ? getLongDescription() != null : !LONG_DESCRIPTION_EDEFAULT.equals(getLongDescription());
			case BasePackage.FL_ELEMENT__NOTES:
				return NOTES_EDEFAULT == null ? getNotes() != null : !NOTES_EDEFAULT.equals(getNotes());
			case BasePackage.FL_ELEMENT__RATINGS:
				return !getRatings().isEmpty();
			case BasePackage.FL_ELEMENT__LIKES:
				return getLikes() != LIKES_EDEFAULT;
			case BasePackage.FL_ELEMENT__DISLIKES:
				return getDislikes() != DISLIKES_EDEFAULT;
			case BasePackage.FL_ELEMENT__COMMENTS:
				return !getComments().isEmpty();
			case BasePackage.FL_ELEMENT__HYPER_LINKS:
				return !getHyperLinks().isEmpty();
			case BasePackage.FL_ELEMENT__TRACES:
				return !getTraces().isEmpty();
			case BasePackage.FL_ELEMENT__PROPERTIES:
				return !getProperties().isEmpty();
			case BasePackage.FL_ELEMENT__DATA_PROVIDER:
				return basicGetDataProvider() != null;
			case BasePackage.FL_ELEMENT__UP_STREAM_MAPPINGS:
				return !getUpStreamMappings().isEmpty();
			case BasePackage.FL_ELEMENT__DOWN_STREAM_MAPPINGS:
				return !getDownStreamMappings().isEmpty();
			case BasePackage.FL_ELEMENT__HORIZONTAL_MAPPINGS:
				return !getHorizontalMappings().isEmpty();
			case BasePackage.FL_ELEMENT__HORIZONTAL_OPPOSITE_MAPPINGS:
				return !getHorizontalOppositeMappings().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_OWN:
				return !getTraceToOwn().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_USE:
				return !getTraceToUse().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_REALIZE:
				return !getTraceToRealize().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_SPECIFY:
				return !getTraceToSpecify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_IMPLEMENT:
				return !getTraceToImplement().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_ELABORATE:
				return !getTraceToElaborate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_DERIVE:
				return !getTraceToDerive().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_VALIDATE:
				return !getTraceToValidate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_TEST:
				return !getTraceToTest().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_RELATE:
				return !getTraceToRelate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_AFFECT:
				return !getTraceToAffect().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_SATISFY:
				return !getTraceToSatisfy().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_VERIFY:
				return !getTraceToVerify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_REFINE:
				return !getTraceToRefine().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_TRACK:
				return !getTraceToTrack().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_OWN:
				return !getTraceFromOwn().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_USE:
				return !getTraceFromUse().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REALIZE:
				return !getTraceFromRealize().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SPECIFY:
				return !getTraceFromSpecify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_IMPLEMENT:
				return !getTraceFromImplement().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_ELABORATE:
				return !getTraceFromElaborate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_DERIVE:
				return !getTraceFromDerive().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VALIDATE:
				return !getTraceFromValidate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TEST:
				return !getTraceFromTest().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_RELATE:
				return !getTraceFromRelate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_AFFECT:
				return !getTraceFromAffect().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SATISFY:
				return !getTraceFromSatisfy().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VERIFY:
				return !getTraceFromVerify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REFINE:
				return !getTraceFromRefine().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TRACK:
				return !getTraceFromTrack().isEmpty();
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
				case BasePackage.FL_ELEMENT__NAME: return BasePackage.FL_NAMEABLE__NAME;
				case BasePackage.FL_ELEMENT__DESCRIPTION: return BasePackage.FL_NAMEABLE__DESCRIPTION;
				case BasePackage.FL_ELEMENT__LONG_DESCRIPTION: return BasePackage.FL_NAMEABLE__LONG_DESCRIPTION;
				case BasePackage.FL_ELEMENT__NOTES: return BasePackage.FL_NAMEABLE__NOTES;
				default: return -1;
			}
		}
		if (baseClass == FLRateable.class) {
			switch (derivedFeatureID) {
				case BasePackage.FL_ELEMENT__RATINGS: return BasePackage.FL_RATEABLE__RATINGS;
				case BasePackage.FL_ELEMENT__LIKES: return BasePackage.FL_RATEABLE__LIKES;
				case BasePackage.FL_ELEMENT__DISLIKES: return BasePackage.FL_RATEABLE__DISLIKES;
				default: return -1;
			}
		}
		if (baseClass == FLCommentable.class) {
			switch (derivedFeatureID) {
				case BasePackage.FL_ELEMENT__COMMENTS: return BasePackage.FL_COMMENTABLE__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == FLHyperLinkable.class) {
			switch (derivedFeatureID) {
				case BasePackage.FL_ELEMENT__HYPER_LINKS: return BasePackage.FL_HYPER_LINKABLE__HYPER_LINKS;
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
				case BasePackage.FL_NAMEABLE__NAME: return BasePackage.FL_ELEMENT__NAME;
				case BasePackage.FL_NAMEABLE__DESCRIPTION: return BasePackage.FL_ELEMENT__DESCRIPTION;
				case BasePackage.FL_NAMEABLE__LONG_DESCRIPTION: return BasePackage.FL_ELEMENT__LONG_DESCRIPTION;
				case BasePackage.FL_NAMEABLE__NOTES: return BasePackage.FL_ELEMENT__NOTES;
				default: return -1;
			}
		}
		if (baseClass == FLRateable.class) {
			switch (baseFeatureID) {
				case BasePackage.FL_RATEABLE__RATINGS: return BasePackage.FL_ELEMENT__RATINGS;
				case BasePackage.FL_RATEABLE__LIKES: return BasePackage.FL_ELEMENT__LIKES;
				case BasePackage.FL_RATEABLE__DISLIKES: return BasePackage.FL_ELEMENT__DISLIKES;
				default: return -1;
			}
		}
		if (baseClass == FLCommentable.class) {
			switch (baseFeatureID) {
				case BasePackage.FL_COMMENTABLE__COMMENTS: return BasePackage.FL_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == FLHyperLinkable.class) {
			switch (baseFeatureID) {
				case BasePackage.FL_HYPER_LINKABLE__HYPER_LINKS: return BasePackage.FL_ELEMENT__HYPER_LINKS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == FLNameable.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == FLRateable.class) {
			switch (baseOperationID) {
				case BasePackage.FL_RATEABLE___COUNT_LIKES: return BasePackage.FL_ELEMENT___COUNT_LIKES;
				case BasePackage.FL_RATEABLE___COUNT_DISLIKES: return BasePackage.FL_ELEMENT___COUNT_DISLIKES;
				default: return -1;
			}
		}
		if (baseClass == FLCommentable.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == FLHyperLinkable.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BasePackage.FL_ELEMENT___TO_FILTER_BY_TYPE__FLTRACETYPE:
				return toFilterByType((FLTraceType)arguments.get(0));
			case BasePackage.FL_ELEMENT___FROM_FILTER_BY_TYPE__FLTRACETYPE:
				return fromFilterByType((FLTraceType)arguments.get(0));
			case BasePackage.FL_ELEMENT___RESOLVE_XREFS__EREFERENCE_CLASS:
				return resolveXrefs((EReference)arguments.get(0), (Class)arguments.get(1));
			case BasePackage.FL_ELEMENT___COUNT_LIKES:
				return countLikes();
			case BasePackage.FL_ELEMENT___COUNT_DISLIKES:
				return countDislikes();
		}
		return super.eInvoke(operationID, arguments);
	}

} //FLElementImpl
