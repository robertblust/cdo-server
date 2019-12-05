/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.Binding;
import ch.flatland.cdo.model.config.Config;
import ch.flatland.cdo.model.config.ConfigPackage;
import ch.flatland.cdo.model.config.Json;
import ch.flatland.cdo.model.config.Repository;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.ConfigImpl#getJson <em>Json</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigImpl extends MinimalEObjectImpl.Container implements Config {
	/**
	 * The cached value of the '{@link #getRepositories() <em>Repositories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositories()
	 * @generated
	 * @ordered
	 */
	protected EList<Repository> repositories;

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
	public EList<Repository> getRepositories() {
		if (repositories == null) {
			repositories = new EObjectContainmentEList<Repository>(Repository.class, this, ConfigPackage.CONFIG__REPOSITORIES);
		}
		return repositories;
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
	public Repository getByName(final String repoName) {
		final Function1<Repository, Boolean> _function = new Function1<Repository, Boolean>() {
			public Boolean apply(final Repository it) {
				String _repositoryName = it.getDataStore().getRepositoryName();
				return Boolean.valueOf(Objects.equal(_repositoryName, repoName));
			}
		};
		return IterableExtensions.<Repository>head(IterableExtensions.<Repository>filter(this.getRepositories(), _function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.CONFIG__REPOSITORIES:
				return ((InternalEList<?>)getRepositories()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.CONFIG__REPOSITORIES:
				return getRepositories();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.CONFIG__REPOSITORIES:
				getRepositories().clear();
				getRepositories().addAll((Collection<? extends Repository>)newValue);
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
			case ConfigPackage.CONFIG__REPOSITORIES:
				getRepositories().clear();
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
			case ConfigPackage.CONFIG__REPOSITORIES:
				return repositories != null && !repositories.isEmpty();
			case ConfigPackage.CONFIG__BINDING:
				return binding != null;
			case ConfigPackage.CONFIG__JSON:
				return json != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConfigPackage.CONFIG___GET_BY_NAME__STRING:
				return getByName((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConfigImpl
