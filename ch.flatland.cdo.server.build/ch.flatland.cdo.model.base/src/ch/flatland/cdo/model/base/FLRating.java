/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Rating</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLRating#getRatingType <em>Rating Type</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLRating()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface FLRating extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Rating Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ch.flatland.cdo.model.base.FLRatingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating Type</em>' attribute.
	 * @see ch.flatland.cdo.model.base.FLRatingType
	 * @see #setRatingType(FLRatingType)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLRating_RatingType()
	 * @model unique="false" required="true"
	 * @generated
	 */
	FLRatingType getRatingType();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLRating#getRatingType <em>Rating Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating Type</em>' attribute.
	 * @see ch.flatland.cdo.model.base.FLRatingType
	 * @see #getRatingType()
	 * @generated
	 */
	void setRatingType(FLRatingType value);

} // FLRating
