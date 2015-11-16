/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLDataProvider#getProvidedElements <em>Provided Elements</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLDataProvider()
 * @model
 * @generated
 */
public interface FLDataProvider extends FLID, Nameable, Commentable, HyperLinkable {
	/**
	 * Returns the value of the '<em><b>Provided Elements</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * It is bidirectional and its opposite is '{@link ch.flatland.cdo.model.base.FLElement#getDataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Elements</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLDataProvider_ProvidedElements()
	 * @see ch.flatland.cdo.model.base.FLElement#getDataProvider
	 * @model opposite="dataProvider"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Data Provider'"
	 * @generated
	 */
	EList<FLElement> getProvidedElements();

} // FLDataProvider
