/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLComment;

import ch.flatland.cdo.model.base.FLRating;
import ch.flatland.cdo.model.base.FLRatingType;
import com.google.common.base.Objects;
import java.lang.Iterable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Comment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLCommentImpl#getRatings <em>Ratings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLCommentImpl#getLikes <em>Likes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLCommentImpl#getDislikes <em>Dislikes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLCommentImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLCommentImpl#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FLCommentImpl extends CDOObjectImpl implements FLComment {
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
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLCommentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_COMMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLRating> getRatings() {
		return (EList<FLRating>)eDynamicGet(BasePackage.FL_COMMENT__RATINGS, BasePackage.Literals.RATEABLE__RATINGS, true, true);
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
	public String getComment() {
		return (String)eDynamicGet(BasePackage.FL_COMMENT__COMMENT, BasePackage.Literals.FL_COMMENT__COMMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		eDynamicSet(BasePackage.FL_COMMENT__COMMENT, BasePackage.Literals.FL_COMMENT__COMMENT, newComment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLComment> getComments() {
		return (EList<FLComment>)eDynamicGet(BasePackage.FL_COMMENT__COMMENTS, BasePackage.Literals.FL_COMMENT__COMMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int countLikes() {
		EList<FLRating> _ratings = this.getRatings();
		final Function1<FLRating, Boolean> _function = new Function1<FLRating, Boolean>() {
			public Boolean apply(final FLRating it) {
				FLRatingType _ratingType = it.getRatingType();
				return Boolean.valueOf(Objects.equal(_ratingType, FLRatingType.LIKE));
			}
		};
		Iterable<FLRating> _filter = IterableExtensions.<FLRating>filter(_ratings, _function);
		return IterableExtensions.size(_filter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int countDislikes() {
		EList<FLRating> _ratings = this.getRatings();
		final Function1<FLRating, Boolean> _function = new Function1<FLRating, Boolean>() {
			public Boolean apply(final FLRating it) {
				FLRatingType _ratingType = it.getRatingType();
				return Boolean.valueOf(Objects.equal(_ratingType, FLRatingType.DISLIKE));
			}
		};
		Iterable<FLRating> _filter = IterableExtensions.<FLRating>filter(_ratings, _function);
		return IterableExtensions.size(_filter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_COMMENT__RATINGS:
				return ((InternalEList<?>)getRatings()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_COMMENT__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
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
			case BasePackage.FL_COMMENT__RATINGS:
				return getRatings();
			case BasePackage.FL_COMMENT__LIKES:
				return getLikes();
			case BasePackage.FL_COMMENT__DISLIKES:
				return getDislikes();
			case BasePackage.FL_COMMENT__COMMENT:
				return getComment();
			case BasePackage.FL_COMMENT__COMMENTS:
				return getComments();
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
			case BasePackage.FL_COMMENT__RATINGS:
				getRatings().clear();
				getRatings().addAll((Collection<? extends FLRating>)newValue);
				return;
			case BasePackage.FL_COMMENT__COMMENT:
				setComment((String)newValue);
				return;
			case BasePackage.FL_COMMENT__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends FLComment>)newValue);
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
			case BasePackage.FL_COMMENT__RATINGS:
				getRatings().clear();
				return;
			case BasePackage.FL_COMMENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case BasePackage.FL_COMMENT__COMMENTS:
				getComments().clear();
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
			case BasePackage.FL_COMMENT__RATINGS:
				return !getRatings().isEmpty();
			case BasePackage.FL_COMMENT__LIKES:
				return getLikes() != LIKES_EDEFAULT;
			case BasePackage.FL_COMMENT__DISLIKES:
				return getDislikes() != DISLIKES_EDEFAULT;
			case BasePackage.FL_COMMENT__COMMENT:
				return COMMENT_EDEFAULT == null ? getComment() != null : !COMMENT_EDEFAULT.equals(getComment());
			case BasePackage.FL_COMMENT__COMMENTS:
				return !getComments().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BasePackage.FL_COMMENT___COUNT_LIKES:
				return countLikes();
			case BasePackage.FL_COMMENT___COUNT_DISLIKES:
				return countDislikes();
		}
		return super.eInvoke(operationID, arguments);
	}

} //FLCommentImpl
