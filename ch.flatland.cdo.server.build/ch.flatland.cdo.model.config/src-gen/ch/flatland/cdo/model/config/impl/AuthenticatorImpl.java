/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.Authenticator;
import ch.flatland.cdo.model.config.AuthenticatorType;
import ch.flatland.cdo.model.config.ConfigPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Authenticator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.AuthenticatorImpl#getAuthenticatorType <em>Authenticator Type</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.AuthenticatorImpl#getConnectionUrl <em>Connection Url</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.AuthenticatorImpl#getDomainBase <em>Domain Base</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.AuthenticatorImpl#getUserIdField <em>User Id Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AuthenticatorImpl extends MinimalEObjectImpl.Container implements Authenticator {
	/**
	 * The default value of the '{@link #getAuthenticatorType() <em>Authenticator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticatorType()
	 * @generated
	 * @ordered
	 */
	protected static final AuthenticatorType AUTHENTICATOR_TYPE_EDEFAULT = AuthenticatorType.CDO;

	/**
	 * The cached value of the '{@link #getAuthenticatorType() <em>Authenticator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticatorType()
	 * @generated
	 * @ordered
	 */
	protected AuthenticatorType authenticatorType = AUTHENTICATOR_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionUrl() <em>Connection Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionUrl() <em>Connection Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionUrl()
	 * @generated
	 * @ordered
	 */
	protected String connectionUrl = CONNECTION_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainBase() <em>Domain Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainBase()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_BASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainBase() <em>Domain Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainBase()
	 * @generated
	 * @ordered
	 */
	protected String domainBase = DOMAIN_BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserIdField() <em>User Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserIdField()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserIdField() <em>User Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserIdField()
	 * @generated
	 * @ordered
	 */
	protected String userIdField = USER_ID_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthenticatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.AUTHENTICATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AuthenticatorType getAuthenticatorType() {
		return authenticatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthenticatorType(AuthenticatorType newAuthenticatorType) {
		AuthenticatorType oldAuthenticatorType = authenticatorType;
		authenticatorType = newAuthenticatorType == null ? AUTHENTICATOR_TYPE_EDEFAULT : newAuthenticatorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.AUTHENTICATOR__AUTHENTICATOR_TYPE, oldAuthenticatorType, authenticatorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConnectionUrl() {
		return connectionUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionUrl(String newConnectionUrl) {
		String oldConnectionUrl = connectionUrl;
		connectionUrl = newConnectionUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.AUTHENTICATOR__CONNECTION_URL, oldConnectionUrl, connectionUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainBase() {
		return domainBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainBase(String newDomainBase) {
		String oldDomainBase = domainBase;
		domainBase = newDomainBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.AUTHENTICATOR__DOMAIN_BASE, oldDomainBase, domainBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserIdField() {
		return userIdField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserIdField(String newUserIdField) {
		String oldUserIdField = userIdField;
		userIdField = newUserIdField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.AUTHENTICATOR__USER_ID_FIELD, oldUserIdField, userIdField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.AUTHENTICATOR__AUTHENTICATOR_TYPE:
				return getAuthenticatorType();
			case ConfigPackage.AUTHENTICATOR__CONNECTION_URL:
				return getConnectionUrl();
			case ConfigPackage.AUTHENTICATOR__DOMAIN_BASE:
				return getDomainBase();
			case ConfigPackage.AUTHENTICATOR__USER_ID_FIELD:
				return getUserIdField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.AUTHENTICATOR__AUTHENTICATOR_TYPE:
				setAuthenticatorType((AuthenticatorType)newValue);
				return;
			case ConfigPackage.AUTHENTICATOR__CONNECTION_URL:
				setConnectionUrl((String)newValue);
				return;
			case ConfigPackage.AUTHENTICATOR__DOMAIN_BASE:
				setDomainBase((String)newValue);
				return;
			case ConfigPackage.AUTHENTICATOR__USER_ID_FIELD:
				setUserIdField((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigPackage.AUTHENTICATOR__AUTHENTICATOR_TYPE:
				setAuthenticatorType(AUTHENTICATOR_TYPE_EDEFAULT);
				return;
			case ConfigPackage.AUTHENTICATOR__CONNECTION_URL:
				setConnectionUrl(CONNECTION_URL_EDEFAULT);
				return;
			case ConfigPackage.AUTHENTICATOR__DOMAIN_BASE:
				setDomainBase(DOMAIN_BASE_EDEFAULT);
				return;
			case ConfigPackage.AUTHENTICATOR__USER_ID_FIELD:
				setUserIdField(USER_ID_FIELD_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.AUTHENTICATOR__AUTHENTICATOR_TYPE:
				return authenticatorType != AUTHENTICATOR_TYPE_EDEFAULT;
			case ConfigPackage.AUTHENTICATOR__CONNECTION_URL:
				return CONNECTION_URL_EDEFAULT == null ? connectionUrl != null : !CONNECTION_URL_EDEFAULT.equals(connectionUrl);
			case ConfigPackage.AUTHENTICATOR__DOMAIN_BASE:
				return DOMAIN_BASE_EDEFAULT == null ? domainBase != null : !DOMAIN_BASE_EDEFAULT.equals(domainBase);
			case ConfigPackage.AUTHENTICATOR__USER_ID_FIELD:
				return USER_ID_FIELD_EDEFAULT == null ? userIdField != null : !USER_ID_FIELD_EDEFAULT.equals(userIdField);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (authenticatorType: ");
		result.append(authenticatorType);
		result.append(", connectionUrl: ");
		result.append(connectionUrl);
		result.append(", domainBase: ");
		result.append(domainBase);
		result.append(", userIdField: ");
		result.append(userIdField);
		result.append(')');
		return result.toString();
	}

} //AuthenticatorImpl
