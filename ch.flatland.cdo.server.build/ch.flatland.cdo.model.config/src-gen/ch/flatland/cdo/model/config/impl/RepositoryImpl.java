/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.Authenticator;
import ch.flatland.cdo.model.config.ConfigPackage;
import ch.flatland.cdo.model.config.DataStore;
import ch.flatland.cdo.model.config.Repository;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.RepositoryImpl#getDataStore <em>Data Store</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.RepositoryImpl#getAuthenticator <em>Authenticator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryImpl extends MinimalEObjectImpl.Container implements Repository {
	/**
	 * The cached value of the '{@link #getDataStore() <em>Data Store</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataStore()
	 * @generated
	 * @ordered
	 */
	protected DataStore dataStore;

	/**
	 * The cached value of the '{@link #getAuthenticator() <em>Authenticator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthenticator()
	 * @generated
	 * @ordered
	 */
	protected Authenticator authenticator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStore getDataStore() {
		return dataStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataStore(DataStore newDataStore, NotificationChain msgs) {
		DataStore oldDataStore = dataStore;
		dataStore = newDataStore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.REPOSITORY__DATA_STORE, oldDataStore, newDataStore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataStore(DataStore newDataStore) {
		if (newDataStore != dataStore) {
			NotificationChain msgs = null;
			if (dataStore != null)
				msgs = ((InternalEObject)dataStore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.REPOSITORY__DATA_STORE, null, msgs);
			if (newDataStore != null)
				msgs = ((InternalEObject)newDataStore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.REPOSITORY__DATA_STORE, null, msgs);
			msgs = basicSetDataStore(newDataStore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.REPOSITORY__DATA_STORE, newDataStore, newDataStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Authenticator getAuthenticator() {
		return authenticator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthenticator(Authenticator newAuthenticator, NotificationChain msgs) {
		Authenticator oldAuthenticator = authenticator;
		authenticator = newAuthenticator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.REPOSITORY__AUTHENTICATOR, oldAuthenticator, newAuthenticator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthenticator(Authenticator newAuthenticator) {
		if (newAuthenticator != authenticator) {
			NotificationChain msgs = null;
			if (authenticator != null)
				msgs = ((InternalEObject)authenticator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.REPOSITORY__AUTHENTICATOR, null, msgs);
			if (newAuthenticator != null)
				msgs = ((InternalEObject)newAuthenticator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.REPOSITORY__AUTHENTICATOR, null, msgs);
			msgs = basicSetAuthenticator(newAuthenticator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.REPOSITORY__AUTHENTICATOR, newAuthenticator, newAuthenticator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.REPOSITORY__DATA_STORE:
				return basicSetDataStore(null, msgs);
			case ConfigPackage.REPOSITORY__AUTHENTICATOR:
				return basicSetAuthenticator(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.REPOSITORY__DATA_STORE:
				return getDataStore();
			case ConfigPackage.REPOSITORY__AUTHENTICATOR:
				return getAuthenticator();
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
			case ConfigPackage.REPOSITORY__DATA_STORE:
				setDataStore((DataStore)newValue);
				return;
			case ConfigPackage.REPOSITORY__AUTHENTICATOR:
				setAuthenticator((Authenticator)newValue);
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
			case ConfigPackage.REPOSITORY__DATA_STORE:
				setDataStore((DataStore)null);
				return;
			case ConfigPackage.REPOSITORY__AUTHENTICATOR:
				setAuthenticator((Authenticator)null);
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
			case ConfigPackage.REPOSITORY__DATA_STORE:
				return dataStore != null;
			case ConfigPackage.REPOSITORY__AUTHENTICATOR:
				return authenticator != null;
		}
		return super.eIsSet(featureID);
	}

} //RepositoryImpl
