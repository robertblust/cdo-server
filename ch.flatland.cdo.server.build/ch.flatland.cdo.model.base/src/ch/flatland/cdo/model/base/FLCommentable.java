/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Commentable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLCommentable#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLCommentable()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface FLCommentable extends CDOObject {
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
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLCommentable_Comments()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLComment> getComments();

} // Commentable
