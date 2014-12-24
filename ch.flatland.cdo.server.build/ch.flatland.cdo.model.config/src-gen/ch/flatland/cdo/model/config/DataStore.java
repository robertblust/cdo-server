/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.DataStore#getStoreType <em>Store Type</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.DataStore#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.DataStore#getConnectionUrl <em>Connection Url</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.DataStore#getUserName <em>User Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.DataStore#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.config.ConfigPackage#getDataStore()
 * @model
 * @generated
 */
public interface DataStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Store Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ch.flatland.cdo.model.config.StoreType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Type</em>' attribute.
	 * @see ch.flatland.cdo.model.config.StoreType
	 * @see #setStoreType(StoreType)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getDataStore_StoreType()
	 * @model unique="false" required="true"
	 * @generated
	 */
	StoreType getStoreType();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.DataStore#getStoreType <em>Store Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Type</em>' attribute.
	 * @see ch.flatland.cdo.model.config.StoreType
	 * @see #getStoreType()
	 * @generated
	 */
	void setStoreType(StoreType value);

	/**
	 * Returns the value of the '<em><b>Repository Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Name</em>' attribute.
	 * @see #setRepositoryName(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getDataStore_RepositoryName()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getRepositoryName();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.DataStore#getRepositoryName <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Name</em>' attribute.
	 * @see #getRepositoryName()
	 * @generated
	 */
	void setRepositoryName(String value);

	/**
	 * Returns the value of the '<em><b>Connection Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Url</em>' attribute.
	 * @see #setConnectionUrl(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getDataStore_ConnectionUrl()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getConnectionUrl();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.DataStore#getConnectionUrl <em>Connection Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Url</em>' attribute.
	 * @see #getConnectionUrl()
	 * @generated
	 */
	void setConnectionUrl(String value);

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getDataStore_UserName()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.DataStore#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getDataStore_Password()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.DataStore#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

} // DataStore
