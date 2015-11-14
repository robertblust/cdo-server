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
 *   <li>{@link ch.flatland.cdo.model.base.Rateable#getRatings <em>Ratings</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.Rateable#getLikes <em>Likes</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.Rateable#getDislikes <em>Dislikes</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getRateable()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Rateable extends CDOObject {
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
	 * @see ch.flatland.cdo.model.base.BasePackage#getRateable_Ratings()
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
	 * @see ch.flatland.cdo.model.base.BasePackage#getRateable_Likes()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.countLikes();'"
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
	 * @see ch.flatland.cdo.model.base.BasePackage#getRateable_Dislikes()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.countDislikes();'"
	 * @generated
	 */
	int getDislikes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLRating%>> _ratings = this.getRatings();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLRating%>, <%java.lang.Boolean%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLRating%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%ch.flatland.cdo.model.base.FLRating%> it)\n\t{\n\t\t<%ch.flatland.cdo.model.base.FLRatingType%> _ratingType = it.getRatingType();\n\t\treturn <%java.lang.Boolean%>.valueOf(<%com.google.common.base.Objects%>.equal(_ratingType, <%ch.flatland.cdo.model.base.FLRatingType%>.LIKE));\n\t}\n};\n<%java.lang.Iterable%><<%ch.flatland.cdo.model.base.FLRating%>> _filter = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%ch.flatland.cdo.model.base.FLRating%>>filter(_ratings, _function);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.size(_filter);'"
	 * @generated
	 */
	int countLikes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLRating%>> _ratings = this.getRatings();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLRating%>, <%java.lang.Boolean%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLRating%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%ch.flatland.cdo.model.base.FLRating%> it)\n\t{\n\t\t<%ch.flatland.cdo.model.base.FLRatingType%> _ratingType = it.getRatingType();\n\t\treturn <%java.lang.Boolean%>.valueOf(<%com.google.common.base.Objects%>.equal(_ratingType, <%ch.flatland.cdo.model.base.FLRatingType%>.DISLIKE));\n\t}\n};\n<%java.lang.Iterable%><<%ch.flatland.cdo.model.base.FLRating%>> _filter = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%ch.flatland.cdo.model.base.FLRating%>>filter(_ratings, _function);\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.size(_filter);'"
	 * @generated
	 */
	int countDislikes();

} // Rateable
