/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLComment#getComment <em>Comment</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLComment#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLComment()
 * @model
 * @generated
 */
public interface FLComment extends FLRateable {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLComment_Comment()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLMarkdown" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true' propertyCategory='Comment'"
	 *        annotation="http://www.eclipse.org/CDO/DBStore columnType='CLOB'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLComment#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLComment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLComment_Comments()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLComment> getComments();

} // FLComment
