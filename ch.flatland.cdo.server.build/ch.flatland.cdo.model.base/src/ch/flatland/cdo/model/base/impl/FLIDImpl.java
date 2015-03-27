/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLID;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FLID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLIDImpl#getUUID <em>UUID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLIDImpl#getID <em>ID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLIDImpl#getObjectID <em>Object ID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLIDImpl#getRevisionID <em>Revision ID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLIDImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FLIDImpl extends CDOObjectImpl implements FLID {
	/**
	 * The default value of the '{@link #getUUID() <em>UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUUID()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getObjectID() <em>Object ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectID()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRevisionID() <em>Revision ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevisionID()
	 * @generated
	 * @ordered
	 */
	protected static final String REVISION_ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long VERSION_EDEFAULT = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLIDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FLID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUUID() {
		return (String)eDynamicGet(BasePackage.FLID__UUID, BasePackage.Literals.FLID__UUID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUUID(String newUUID) {
		eDynamicSet(BasePackage.FLID__UUID, BasePackage.Literals.FLID__UUID, newUUID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return (String)eDynamicGet(BasePackage.FLID__ID, BasePackage.Literals.FLID__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		eDynamicSet(BasePackage.FLID__ID, BasePackage.Literals.FLID__ID, newID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectID() {
		return (String)eDynamicGet(BasePackage.FLID__OBJECT_ID, BasePackage.Literals.FLID__OBJECT_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectID(String newObjectID) {
		eDynamicSet(BasePackage.FLID__OBJECT_ID, BasePackage.Literals.FLID__OBJECT_ID, newObjectID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRevisionID() {
		return (String)eDynamicGet(BasePackage.FLID__REVISION_ID, BasePackage.Literals.FLID__REVISION_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevisionID(String newRevisionID) {
		eDynamicSet(BasePackage.FLID__REVISION_ID, BasePackage.Literals.FLID__REVISION_ID, newRevisionID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getVersion() {
		return (Long)eDynamicGet(BasePackage.FLID__VERSION, BasePackage.Literals.FLID__VERSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(long newVersion) {
		eDynamicSet(BasePackage.FLID__VERSION, BasePackage.Literals.FLID__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FLID__UUID:
				return getUUID();
			case BasePackage.FLID__ID:
				return getID();
			case BasePackage.FLID__OBJECT_ID:
				return getObjectID();
			case BasePackage.FLID__REVISION_ID:
				return getRevisionID();
			case BasePackage.FLID__VERSION:
				return getVersion();
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
			case BasePackage.FLID__UUID:
				setUUID((String)newValue);
				return;
			case BasePackage.FLID__ID:
				setID((String)newValue);
				return;
			case BasePackage.FLID__OBJECT_ID:
				setObjectID((String)newValue);
				return;
			case BasePackage.FLID__REVISION_ID:
				setRevisionID((String)newValue);
				return;
			case BasePackage.FLID__VERSION:
				setVersion((Long)newValue);
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
			case BasePackage.FLID__UUID:
				setUUID(UUID_EDEFAULT);
				return;
			case BasePackage.FLID__ID:
				setID(ID_EDEFAULT);
				return;
			case BasePackage.FLID__OBJECT_ID:
				setObjectID(OBJECT_ID_EDEFAULT);
				return;
			case BasePackage.FLID__REVISION_ID:
				setRevisionID(REVISION_ID_EDEFAULT);
				return;
			case BasePackage.FLID__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case BasePackage.FLID__UUID:
				return UUID_EDEFAULT == null ? getUUID() != null : !UUID_EDEFAULT.equals(getUUID());
			case BasePackage.FLID__ID:
				return ID_EDEFAULT == null ? getID() != null : !ID_EDEFAULT.equals(getID());
			case BasePackage.FLID__OBJECT_ID:
				return OBJECT_ID_EDEFAULT == null ? getObjectID() != null : !OBJECT_ID_EDEFAULT.equals(getObjectID());
			case BasePackage.FLID__REVISION_ID:
				return REVISION_ID_EDEFAULT == null ? getRevisionID() != null : !REVISION_ID_EDEFAULT.equals(getRevisionID());
			case BasePackage.FLID__VERSION:
				return getVersion() != VERSION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //FLIDImpl
