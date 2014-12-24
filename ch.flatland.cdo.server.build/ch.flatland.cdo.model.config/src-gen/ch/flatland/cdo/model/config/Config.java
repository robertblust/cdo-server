/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getDataStore <em>Data Store</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getAuthenticator <em>Authenticator</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig()
 * @model
 * @generated
 */
public interface Config extends EObject {
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
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_DataStore()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataStore getDataStore();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getDataStore <em>Data Store</em>}' containment reference.
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
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_Authenticator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Authenticator getAuthenticator();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getAuthenticator <em>Authenticator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authenticator</em>' containment reference.
	 * @see #getAuthenticator()
	 * @generated
	 */
	void setAuthenticator(Authenticator value);

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference.
	 * @see #setBinding(Binding)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_Binding()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Binding getBinding();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getBinding <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' containment reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(Binding value);

} // Config
