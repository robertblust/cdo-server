/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.Binding#getIp <em>Ip</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Binding#isTcp <em>Tcp</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Binding#getTcpPort <em>Tcp Port</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Binding#isHttp <em>Http</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Binding#getHttpPort <em>Http Port</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.Binding#isCheckSSL <em>Check SSL</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends EObject {
	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding_Ip()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Binding#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Tcp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tcp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tcp</em>' attribute.
	 * @see #setTcp(boolean)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding_Tcp()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isTcp();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Binding#isTcp <em>Tcp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tcp</em>' attribute.
	 * @see #isTcp()
	 * @generated
	 */
	void setTcp(boolean value);

	/**
	 * Returns the value of the '<em><b>Tcp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tcp Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tcp Port</em>' attribute.
	 * @see #setTcpPort(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding_TcpPort()
	 * @model unique="false"
	 * @generated
	 */
	String getTcpPort();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Binding#getTcpPort <em>Tcp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tcp Port</em>' attribute.
	 * @see #getTcpPort()
	 * @generated
	 */
	void setTcpPort(String value);

	/**
	 * Returns the value of the '<em><b>Http</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http</em>' attribute.
	 * @see #setHttp(boolean)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding_Http()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isHttp();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Binding#isHttp <em>Http</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http</em>' attribute.
	 * @see #isHttp()
	 * @generated
	 */
	void setHttp(boolean value);

	/**
	 * Returns the value of the '<em><b>Http Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http Port</em>' attribute.
	 * @see #setHttpPort(String)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding_HttpPort()
	 * @model unique="false"
	 * @generated
	 */
	String getHttpPort();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Binding#getHttpPort <em>Http Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http Port</em>' attribute.
	 * @see #getHttpPort()
	 * @generated
	 */
	void setHttpPort(String value);

	/**
	 * Returns the value of the '<em><b>Check SSL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check SSL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check SSL</em>' attribute.
	 * @see #setCheckSSL(boolean)
	 * @see ch.flatland.cdo.model.config.ConfigPackage#getBinding_CheckSSL()
	 * @model unique="false"
	 * @generated
	 */
	boolean isCheckSSL();

	/**
	 * Sets the value of the '{@link ch.flatland.cdo.model.config.Binding#isCheckSSL <em>Check SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check SSL</em>' attribute.
	 * @see #isCheckSSL()
	 * @generated
	 */
	void setCheckSSL(boolean value);

} // Binding
