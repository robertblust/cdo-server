/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.ConfigPackage;
import ch.flatland.cdo.model.config.Json;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Json</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isValidate <em>Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isReferences <em>References</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isXreferences <em>Xreferences</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isHistory <em>History</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isFullUrl <em>Full Url</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isMeta <em>Meta</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isLinks <em>Links</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.JsonImpl#isXlinks <em>Xlinks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JsonImpl extends MinimalEObjectImpl.Container implements Json {
	/**
	 * The default value of the '{@link #isValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidate()
	 * @generated
	 * @ordered
	 */
	protected boolean validate = VALIDATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isReferences() <em>References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFERENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReferences() <em>References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReferences()
	 * @generated
	 * @ordered
	 */
	protected boolean references = REFERENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isXreferences() <em>Xreferences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isXreferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean XREFERENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isXreferences() <em>Xreferences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isXreferences()
	 * @generated
	 * @ordered
	 */
	protected boolean xreferences = XREFERENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isHistory() <em>History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HISTORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHistory() <em>History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistory()
	 * @generated
	 * @ordered
	 */
	protected boolean history = HISTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isFullUrl() <em>Full Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullUrl()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULL_URL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullUrl() <em>Full Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullUrl()
	 * @generated
	 * @ordered
	 */
	protected boolean fullUrl = FULL_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #isMeta() <em>Meta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMeta()
	 * @generated
	 * @ordered
	 */
	protected static final boolean META_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMeta() <em>Meta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMeta()
	 * @generated
	 * @ordered
	 */
	protected boolean meta = META_EDEFAULT;

	/**
	 * The default value of the '{@link #isLinks() <em>Links</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLinks()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LINKS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLinks() <em>Links</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLinks()
	 * @generated
	 * @ordered
	 */
	protected boolean links = LINKS_EDEFAULT;

	/**
	 * The default value of the '{@link #isXlinks() <em>Xlinks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isXlinks()
	 * @generated
	 * @ordered
	 */
	protected static final boolean XLINKS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isXlinks() <em>Xlinks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isXlinks()
	 * @generated
	 * @ordered
	 */
	protected boolean xlinks = XLINKS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JsonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.JSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidate() {
		return validate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidate(boolean newValidate) {
		boolean oldValidate = validate;
		validate = newValidate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__VALIDATE, oldValidate, validate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReferences() {
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferences(boolean newReferences) {
		boolean oldReferences = references;
		references = newReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__REFERENCES, oldReferences, references));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isXreferences() {
		return xreferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXreferences(boolean newXreferences) {
		boolean oldXreferences = xreferences;
		xreferences = newXreferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__XREFERENCES, oldXreferences, xreferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHistory() {
		return history;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistory(boolean newHistory) {
		boolean oldHistory = history;
		history = newHistory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__HISTORY, oldHistory, history));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFullUrl() {
		return fullUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullUrl(boolean newFullUrl) {
		boolean oldFullUrl = fullUrl;
		fullUrl = newFullUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__FULL_URL, oldFullUrl, fullUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(boolean newMeta) {
		boolean oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__META, oldMeta, meta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLinks() {
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinks(boolean newLinks) {
		boolean oldLinks = links;
		links = newLinks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__LINKS, oldLinks, links));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isXlinks() {
		return xlinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXlinks(boolean newXlinks) {
		boolean oldXlinks = xlinks;
		xlinks = newXlinks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.JSON__XLINKS, oldXlinks, xlinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.JSON__VALIDATE:
				return isValidate();
			case ConfigPackage.JSON__REFERENCES:
				return isReferences();
			case ConfigPackage.JSON__XREFERENCES:
				return isXreferences();
			case ConfigPackage.JSON__HISTORY:
				return isHistory();
			case ConfigPackage.JSON__FULL_URL:
				return isFullUrl();
			case ConfigPackage.JSON__META:
				return isMeta();
			case ConfigPackage.JSON__LINKS:
				return isLinks();
			case ConfigPackage.JSON__XLINKS:
				return isXlinks();
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
			case ConfigPackage.JSON__VALIDATE:
				setValidate((Boolean)newValue);
				return;
			case ConfigPackage.JSON__REFERENCES:
				setReferences((Boolean)newValue);
				return;
			case ConfigPackage.JSON__XREFERENCES:
				setXreferences((Boolean)newValue);
				return;
			case ConfigPackage.JSON__HISTORY:
				setHistory((Boolean)newValue);
				return;
			case ConfigPackage.JSON__FULL_URL:
				setFullUrl((Boolean)newValue);
				return;
			case ConfigPackage.JSON__META:
				setMeta((Boolean)newValue);
				return;
			case ConfigPackage.JSON__LINKS:
				setLinks((Boolean)newValue);
				return;
			case ConfigPackage.JSON__XLINKS:
				setXlinks((Boolean)newValue);
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
			case ConfigPackage.JSON__VALIDATE:
				setValidate(VALIDATE_EDEFAULT);
				return;
			case ConfigPackage.JSON__REFERENCES:
				setReferences(REFERENCES_EDEFAULT);
				return;
			case ConfigPackage.JSON__XREFERENCES:
				setXreferences(XREFERENCES_EDEFAULT);
				return;
			case ConfigPackage.JSON__HISTORY:
				setHistory(HISTORY_EDEFAULT);
				return;
			case ConfigPackage.JSON__FULL_URL:
				setFullUrl(FULL_URL_EDEFAULT);
				return;
			case ConfigPackage.JSON__META:
				setMeta(META_EDEFAULT);
				return;
			case ConfigPackage.JSON__LINKS:
				setLinks(LINKS_EDEFAULT);
				return;
			case ConfigPackage.JSON__XLINKS:
				setXlinks(XLINKS_EDEFAULT);
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
			case ConfigPackage.JSON__VALIDATE:
				return validate != VALIDATE_EDEFAULT;
			case ConfigPackage.JSON__REFERENCES:
				return references != REFERENCES_EDEFAULT;
			case ConfigPackage.JSON__XREFERENCES:
				return xreferences != XREFERENCES_EDEFAULT;
			case ConfigPackage.JSON__HISTORY:
				return history != HISTORY_EDEFAULT;
			case ConfigPackage.JSON__FULL_URL:
				return fullUrl != FULL_URL_EDEFAULT;
			case ConfigPackage.JSON__META:
				return meta != META_EDEFAULT;
			case ConfigPackage.JSON__LINKS:
				return links != LINKS_EDEFAULT;
			case ConfigPackage.JSON__XLINKS:
				return xlinks != XLINKS_EDEFAULT;
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
		result.append(" (validate: ");
		result.append(validate);
		result.append(", references: ");
		result.append(references);
		result.append(", xreferences: ");
		result.append(xreferences);
		result.append(", history: ");
		result.append(history);
		result.append(", fullUrl: ");
		result.append(fullUrl);
		result.append(", meta: ");
		result.append(meta);
		result.append(", links: ");
		result.append(links);
		result.append(", xlinks: ");
		result.append(xlinks);
		result.append(')');
		return result.toString();
	}

} //JsonImpl
