/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hyper Linkable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.HyperLinkable#getHyperLinks <em>Hyper Links</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getHyperLinkable()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface HyperLinkable extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Hyper Links</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLHyperLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hyper Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hyper Links</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getHyperLinkable_HyperLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLHyperLink> getHyperLinks();

} // HyperLinkable
