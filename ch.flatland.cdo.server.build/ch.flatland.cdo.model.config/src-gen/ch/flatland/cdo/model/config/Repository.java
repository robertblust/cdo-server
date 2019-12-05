/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.Repository#getDataStore <em>Data Store</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.config.ConfigPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Store</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Store</em>' containment reference.
	 * @see #setDataStore(DataStore)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getRepository_DataStore()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataStore getDataStore();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Repository#getDataStore <em>Data Store</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Store</em>' containment reference.
	 * @see #getDataStore()
	 * @generated
	 */
	void setDataStore(DataStore value);

} // Repository
