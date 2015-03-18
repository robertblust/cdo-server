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

} // Authenticator
