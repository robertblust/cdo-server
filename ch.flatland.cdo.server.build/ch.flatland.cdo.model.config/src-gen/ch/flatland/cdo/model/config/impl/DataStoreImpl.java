/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.ConfigPackage;
import ch.flatland.cdo.model.config.DataStore;
import ch.flatland.cdo.model.config.StoreType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.DataStoreImpl#getStoreType <em>Store Type</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.DataStoreImpl#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.DataStoreImpl#getConnectionUrl <em>Connection Url</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.DataStoreImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.DataStoreImpl#getPassword <em>Password</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataStoreImpl extends MinimalEObjectImpl.Container implements DataStore {
	/**
	 * The default value of the '{@link #getStoreType() <em>Store Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreType()
	 * @generated
	 * @ordered
	 */
	protected static final StoreType STORE_TYPE_EDEFAULT = StoreType.H2;

	/**
	 * The cached value of the '{@link #getStoreType() <em>Store Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreType()
	 * @generated
	 * @ordered
	 */
	protected StoreType storeType = STORE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected String repositoryName = REPOSITORY_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.DATA_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreType getStoreType() {
		return storeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreType(StoreType newStoreType) {
		StoreType oldStoreType = storeType;
		storeType = newStoreType == null ? STORE_TYPE_EDEFAULT : newStoreType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DATA_STORE__STORE_TYPE, oldStoreType, storeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryName() {
		return repositoryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryName(String newRepositoryName) {
		String oldRepositoryName = repositoryName;
		repositoryName = newRepositoryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DATA_STORE__REPOSITORY_NAME, oldRepositoryName, repositoryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionUrl() {
		return connectionUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionUrl(String newConnectionUrl) {
		String oldConnectionUrl = connectionUrl;
		connectionUrl = newConnectionUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DATA_STORE__CONNECTION_URL, oldConnectionUrl, connectionUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DATA_STORE__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DATA_STORE__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.DATA_STORE__STORE_TYPE:
				return getStoreType();
			case ConfigPackage.DATA_STORE__REPOSITORY_NAME:
				return getRepositoryName();
			case ConfigPackage.DATA_STORE__CONNECTION_URL:
				return getConnectionUrl();
			case ConfigPackage.DATA_STORE__USER_NAME:
				return getUserName();
			case ConfigPackage.DATA_STORE__PASSWORD:
				return getPassword();
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
			case ConfigPackage.DATA_STORE__STORE_TYPE:
				setStoreType((StoreType)newValue);
				return;
			case ConfigPackage.DATA_STORE__REPOSITORY_NAME:
				setRepositoryName((String)newValue);
				return;
			case ConfigPackage.DATA_STORE__CONNECTION_URL:
				setConnectionUrl((String)newValue);
				return;
			case ConfigPackage.DATA_STORE__USER_NAME:
				setUserName((String)newValue);
				return;
			case ConfigPackage.DATA_STORE__PASSWORD:
				setPassword((String)newValue);
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
			case ConfigPackage.DATA_STORE__STORE_TYPE:
				setStoreType(STORE_TYPE_EDEFAULT);
				return;
			case ConfigPackage.DATA_STORE__REPOSITORY_NAME:
				setRepositoryName(REPOSITORY_NAME_EDEFAULT);
				return;
			case ConfigPackage.DATA_STORE__CONNECTION_URL:
				setConnectionUrl(CONNECTION_URL_EDEFAULT);
				return;
			case ConfigPackage.DATA_STORE__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case ConfigPackage.DATA_STORE__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
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
			case ConfigPackage.DATA_STORE__STORE_TYPE:
				return storeType != STORE_TYPE_EDEFAULT;
			case ConfigPackage.DATA_STORE__REPOSITORY_NAME:
				return REPOSITORY_NAME_EDEFAULT == null ? repositoryName != null : !REPOSITORY_NAME_EDEFAULT.equals(repositoryName);
			case ConfigPackage.DATA_STORE__CONNECTION_URL:
				return CONNECTION_URL_EDEFAULT == null ? connectionUrl != null : !CONNECTION_URL_EDEFAULT.equals(connectionUrl);
			case ConfigPackage.DATA_STORE__USER_NAME:
				return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
			case ConfigPackage.DATA_STORE__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (storeType: ");
		result.append(storeType);
		result.append(", repositoryName: ");
		result.append(repositoryName);
		result.append(", connectionUrl: ");
		result.append(connectionUrl);
		result.append(", userName: ");
		result.append(userName);
		result.append(", password: ");
		result.append(password);
		result.append(')');
		return result.toString();
	}

} //DataStoreImpl
