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
 *   <li>{@link ch.flatland.cdo.model.config.Repository#getAuthenticator <em>Authenticator</em>}</li>
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
	 * <p>
	 * If the meaning of the '<em>Data Store</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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

	/**
	 * Returns the value of the '<em><b>Authenticator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authenticator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authenticator</em>' containment reference.
	 * @see #setAuthenticator(Authenticator)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getRepository_Authenticator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Authenticator getAuthenticator();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Repository#getAuthenticator <em>Authenticator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authenticator</em>' containment reference.
	 * @see #getAuthenticator()
	 * @generated
	 */
	void setAuthenticator(Authenticator value);

} // Repository
