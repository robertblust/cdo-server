/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authenticator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#getAuthenticatorType <em>Authenticator Type</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#getConnectionUrl <em>Connection Url</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#getDomainBase <em>Domain Base</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#getUserIdField <em>User Id Field</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#getReadOnlyPassword <em>Read Only Password</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#getAdminPassword <em>Admin Password</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Authenticator#isCheckSSL <em>Check SSL</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator()
 * @model
 * @generated
 */
public interface Authenticator extends EObject {
	/**
	 * Returns the value of the '<em><b>Authenticator Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ch.flatland.cdo.model.config.AuthenticatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authenticator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authenticator Type</em>' attribute.
	 * @see ch.flatland.cdo.model.config.AuthenticatorType
	 * @see #setAuthenticatorType(AuthenticatorType)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_AuthenticatorType()
	 * @model unique="false" required="true"
	 * @generated
	 */
	AuthenticatorType getAuthenticatorType();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#getAuthenticatorType <em>Authenticator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authenticator Type</em>' attribute.
	 * @see ch.flatland.cdo.model.config.AuthenticatorType
	 * @see #getAuthenticatorType()
	 * @generated
	 */
	void setAuthenticatorType(AuthenticatorType value);

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
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_ConnectionUrl()
	 * @model unique="false"
	 * @generated
	 */
	String getConnectionUrl();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#getConnectionUrl <em>Connection Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Url</em>' attribute.
	 * @see #getConnectionUrl()
	 * @generated
	 */
	void setConnectionUrl(String value);

	/**
	 * Returns the value of the '<em><b>Domain Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Base</em>' attribute.
	 * @see #setDomainBase(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_DomainBase()
	 * @model unique="false"
	 * @generated
	 */
	String getDomainBase();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#getDomainBase <em>Domain Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Base</em>' attribute.
	 * @see #getDomainBase()
	 * @generated
	 */
	void setDomainBase(String value);

	/**
	 * Returns the value of the '<em><b>User Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id Field</em>' attribute.
	 * @see #setUserIdField(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_UserIdField()
	 * @model unique="false"
	 * @generated
	 */
	String getUserIdField();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#getUserIdField <em>User Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id Field</em>' attribute.
	 * @see #getUserIdField()
	 * @generated
	 */
	void setUserIdField(String value);

	/**
	 * Returns the value of the '<em><b>Read Only Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only Password</em>' attribute.
	 * @see #setReadOnlyPassword(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_ReadOnlyPassword()
	 * @model unique="false"
	 * @generated
	 */
	String getReadOnlyPassword();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#getReadOnlyPassword <em>Read Only Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only Password</em>' attribute.
	 * @see #getReadOnlyPassword()
	 * @generated
	 */
	void setReadOnlyPassword(String value);

	/**
	 * Returns the value of the '<em><b>Admin Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Admin Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Admin Password</em>' attribute.
	 * @see #setAdminPassword(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_AdminPassword()
	 * @model unique="false"
	 * @generated
	 */
	String getAdminPassword();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#getAdminPassword <em>Admin Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin Password</em>' attribute.
	 * @see #getAdminPassword()
	 * @generated
	 */
	void setAdminPassword(String value);

	/**
	 * Returns the value of the '<em><b>Check SSL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check SSL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check SSL</em>' attribute.
	 * @see #setCheckSSL(boolean)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getAuthenticator_CheckSSL()
	 * @model unique="false"
	 * @generated
	 */
	boolean isCheckSSL();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Authenticator#isCheckSSL <em>Check SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check SSL</em>' attribute.
	 * @see #isCheckSSL()
	 * @generated
	 */
	void setCheckSSL(boolean value);

} // Authenticator
