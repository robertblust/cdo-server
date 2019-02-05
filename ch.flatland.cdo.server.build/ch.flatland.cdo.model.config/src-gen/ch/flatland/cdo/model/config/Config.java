/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getReadOnlyPassword <em>Read Only Password</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getAdminPassword <em>Admin Password</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getBinding <em>Binding</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Config#getJson <em>Json</em>}</li>
 * </ul>
 *
 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig()
 * @model
 * @generated
 */
public interface Config extends EObject {
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
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_ReadOnlyPassword()
	 * @model unique="false"
	 * @generated
	 */
	String getReadOnlyPassword();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getReadOnlyPassword <em>Read Only Password</em>}' attribute.
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
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_AdminPassword()
	 * @model unique="false"
	 * @generated
	 */
	String getAdminPassword();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getAdminPassword <em>Admin Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin Password</em>' attribute.
	 * @see #getAdminPassword()
	 * @generated
	 */
	void setAdminPassword(String value);

	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.config.Repository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_Repositories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepositories();

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference.
	 * @see #setBinding(Binding)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_Binding()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Binding getBinding();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getBinding <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' containment reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(Binding value);

	/**
	 * Returns the value of the '<em><b>Json</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Json</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Json</em>' containment reference.
	 * @see #setJson(Json)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getConfig_Json()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Json getJson();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Config#getJson <em>Json</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Json</em>' containment reference.
	 * @see #getJson()
	 * @generated
	 */
	void setJson(Json value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" repoNameUnique="false"
	 * @generated
	 */
	Repository getByName(String repoName);

} // Config
