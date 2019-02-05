/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rateable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLRateable#getRatings <em>Ratings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLRateable#getLikes <em>Likes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLRateable#getDislikes <em>Dislikes</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLRateable()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface FLRateable extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Ratings</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLRating}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ratings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ratings</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLRateable_Ratings()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLRating> getRatings();

	/**
	 * Returns the value of the '<em><b>Likes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Likes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Likes</em>' attribute.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLRateable_Likes()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Rating'"
	 * @generated
	 */
	int getLikes();

	/**
	 * Returns the value of the '<em><b>Dislikes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dislikes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dislikes</em>' attribute.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLRateable_Dislikes()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Rating'"
	 * @generated
	 */
	int getDislikes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	int countLikes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	int countDislikes();

} // Rateable
