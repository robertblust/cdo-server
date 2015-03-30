/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FLID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Base element all Concepts should at least inherit from.
 * Provides generic features.
 * <p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLID#getUUID <em>UUID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLID#getID <em>ID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLID#getObjectID <em>Object ID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLID#getRevisionID <em>Revision ID</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLID#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLID()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface FLID extends CDOObject {
	/**
	 * Returns the value of the '<em><b>UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * A universally unique identifier (UUID) is an identifier standard used in software construction.
	 * 
	 * The intent of UUIDs is to enable distributed systems to uniquely
	 * identify information without significant central coordination.
	 * In this context the word unique should be taken to mean
	 * "practically unique" rather than "guaranteed unique".
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>UUID</em>' attribute.
	 * @see #setUUID(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLID_UUID()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLIdentifier"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='ID'"
	 * @generated
	 */
	String getUUID();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLID#getUUID <em>UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UUID</em>' attribute.
	 * @see #getUUID()
	 * @generated
	 */
	void setUUID(String value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * ID represents a kind of id from the business perspective. E.g a project id,
	 * test case id. The scope of uniqueness is not clear a this
	 * abstract level. It depends on the actual concrete sub type.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLID_ID()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLIdentifier"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='ID'"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLID#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Object ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * objectID represents a additional technical id.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object ID</em>' attribute.
	 * @see #setObjectID(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLID_ObjectID()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLIdentifier"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='ID'"
	 * @generated
	 */
	String getObjectID();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLID#getObjectID <em>Object ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object ID</em>' attribute.
	 * @see #getObjectID()
	 * @generated
	 */
	void setObjectID(String value);

	/**
	 * Returns the value of the '<em><b>Revision ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision ID</em>' attribute.
	 * @see #setRevisionID(String)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLID_RevisionID()
	 * @model unique="false" dataType="ch.flatland.cdo.model.base.FLIdentifier"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='ID'"
	 * @generated
	 */
	String getRevisionID();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLID#getRevisionID <em>Revision ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision ID</em>' attribute.
	 * @see #getRevisionID()
	 * @generated
	 */
	void setRevisionID(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(long)
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLID_Version()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='ID'"
	 * @generated
	 */
	long getVersion();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.base.FLID#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.cdo.common.security.CDOPermission%> _cdoPermission = object.cdoPermission();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_cdoPermission, <%org.eclipse.emf.cdo.common.security.CDOPermission%>.NONE));\nif (_notEquals)\n{\n\treturn true;\n}\nreturn false;'"
	 * @generated
	 */
	boolean hasPermission(FLID object);

} // FLID
