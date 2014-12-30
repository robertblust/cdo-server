/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.Authenticator;
import ch.flatland.cdo.model.config.Binding;
import ch.flatland.cdo.model.config.Config;
import ch.flatland.cdo.model.config.ConfigPackage;
import ch.flatland.cdo.model.config.DataStore;
import ch.flatland.cdo.model.config.Json;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getDataStore <em>Data Store</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getAuthenticator <em>Authenticator</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getJson <em>Json</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigImpl extends MinimalEObjectImpl.Container implements Config {
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
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected Binding binding;

	/**
	 * The cached value of the '{@link #getJson() <em>Json</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJson()
	 * @generated
	 * @ordered
	 */
	protected Json json;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.CONFIG;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__DATA_STORE, oldDataStore, newDataStore);
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
				msgs = ((InternalEObject)dataStore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__DATA_STORE, null, msgs);
			if (newDataStore != null)
				msgs = ((InternalEObject)newDataStore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__DATA_STORE, null, msgs);
			msgs = basicSetDataStore(newDataStore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__DATA_STORE, newDataStore, newDataStore));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__AUTHENTICATOR, oldAuthenticator, newAuthenticator);
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
				msgs = ((InternalEObject)authenticator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__AUTHENTICATOR, null, msgs);
			if (newAuthenticator != null)
				msgs = ((InternalEObject)newAuthenticator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__AUTHENTICATOR, null, msgs);
			msgs = basicSetAuthenticator(newAuthenticator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__AUTHENTICATOR, newAuthenticator, newAuthenticator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBinding(Binding newBinding, NotificationChain msgs) {
		Binding oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__BINDING, oldBinding, newBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(Binding newBinding) {
		if (newBinding != binding) {
			NotificationChain msgs = null;
			if (binding != null)
				msgs = ((InternalEObject)binding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__BINDING, null, msgs);
			if (newBinding != null)
				msgs = ((InternalEObject)newBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__BINDING, null, msgs);
			msgs = basicSetBinding(newBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__BINDING, newBinding, newBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Json getJson() {
		return json;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJson(Json newJson, NotificationChain msgs) {
		Json oldJson = json;
		json = newJson;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__JSON, oldJson, newJson);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJson(Json newJson) {
		if (newJson != json) {
			NotificationChain msgs = null;
			if (json != null)
				msgs = ((InternalEObject)json).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__JSON, null, msgs);
			if (newJson != null)
				msgs = ((InternalEObject)newJson).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONFIG__JSON, null, msgs);
			msgs = basicSetJson(newJson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG__JSON, newJson, newJson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.CONFIG__DATA_STORE:
				return basicSetDataStore(null, msgs);
			case ConfigPackage.CONFIG__AUTHENTICATOR:
				return basicSetAuthenticator(null, msgs);
			case ConfigPackage.CONFIG__BINDING:
				return basicSetBinding(null, msgs);
			case ConfigPackage.CONFIG__JSON:
				return basicSetJson(null, msgs);
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
			case ConfigPackage.CONFIG__DATA_STORE:
				return getDataStore();
			case ConfigPackage.CONFIG__AUTHENTICATOR:
				return getAuthenticator();
			case ConfigPackage.CONFIG__BINDING:
				return getBinding();
			case ConfigPackage.CONFIG__JSON:
				return getJson();
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
			case ConfigPackage.CONFIG__DATA_STORE:
				setDataStore((DataStore)newValue);
				return;
			case ConfigPackage.CONFIG__AUTHENTICATOR:
				setAuthenticator((Authenticator)newValue);
				return;
			case ConfigPackage.CONFIG__BINDING:
				setBinding((Binding)newValue);
				return;
			case ConfigPackage.CONFIG__JSON:
				setJson((Json)newValue);
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
			case ConfigPackage.CONFIG__DATA_STORE:
				setDataStore((DataStore)null);
				return;
			case ConfigPackage.CONFIG__AUTHENTICATOR:
				setAuthenticator((Authenticator)null);
				return;
			case ConfigPackage.CONFIG__BINDING:
				setBinding((Binding)null);
				return;
			case ConfigPackage.CONFIG__JSON:
				setJson((Json)null);
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
			case ConfigPackage.CONFIG__DATA_STORE:
				return dataStore != null;
			case ConfigPackage.CONFIG__AUTHENTICATOR:
				return authenticator != null;
			case ConfigPackage.CONFIG__BINDING:
				return binding != null;
			case ConfigPackage.CONFIG__JSON:
				return json != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigImpl
