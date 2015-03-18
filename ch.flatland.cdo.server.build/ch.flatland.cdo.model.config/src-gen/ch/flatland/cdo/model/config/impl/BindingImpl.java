/**
 */
package ch.flatland.cdo.model.config.impl;

import ch.flatland.cdo.model.config.Binding;
import ch.flatland.cdo.model.config.ConfigPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.config.impl.BindingImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.BindingImpl#isTcp <em>Tcp</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.BindingImpl#getTcpPort <em>Tcp Port</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.BindingImpl#isHttp <em>Http</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.BindingImpl#getHttpPort <em>Http Port</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.config.impl.BindingImpl#isCheckSSL <em>Check SSL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingImpl extends MinimalEObjectImpl.Container implements Binding {
	/**
	 * The default value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIp() <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIp()
	 * @generated
	 * @ordered
	 */
	protected String ip = IP_EDEFAULT;

	/**
	 * The default value of the '{@link #isTcp() <em>Tcp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTcp()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TCP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTcp() <em>Tcp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTcp()
	 * @generated
	 * @ordered
	 */
	protected boolean tcp = TCP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTcpPort() <em>Tcp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTcpPort()
	 * @generated
	 * @ordered
	 */
	protected static final String TCP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTcpPort() <em>Tcp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTcpPort()
	 * @generated
	 * @ordered
	 */
	protected String tcpPort = TCP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #isHttp() <em>Http</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHttp()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HTTP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHttp() <em>Http</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHttp()
	 * @generated
	 * @ordered
	 */
	protected boolean http = HTTP_EDEFAULT;

	/**
	 * The default value of the '{@link #getHttpPort() <em>Http Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpPort()
	 * @generated
	 * @ordered
	 */
	protected static final String HTTP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHttpPort() <em>Http Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpPort()
	 * @generated
	 * @ordered
	 */
	protected String httpPort = HTTP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #isCheckSSL() <em>Check SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckSSL()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_SSL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheckSSL() <em>Check SSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckSSL()
	 * @generated
	 * @ordered
	 */
	protected boolean checkSSL = CHECK_SSL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(String newIp) {
		String oldIp = ip;
		ip = newIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.BINDING__IP, oldIp, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTcp() {
		return tcp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTcp(boolean newTcp) {
		boolean oldTcp = tcp;
		tcp = newTcp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.BINDING__TCP, oldTcp, tcp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTcpPort() {
		return tcpPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTcpPort(String newTcpPort) {
		String oldTcpPort = tcpPort;
		tcpPort = newTcpPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.BINDING__TCP_PORT, oldTcpPort, tcpPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHttp() {
		return http;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHttp(boolean newHttp) {
		boolean oldHttp = http;
		http = newHttp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.BINDING__HTTP, oldHttp, http));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHttpPort() {
		return httpPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHttpPort(String newHttpPort) {
		String oldHttpPort = httpPort;
		httpPort = newHttpPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.BINDING__HTTP_PORT, oldHttpPort, httpPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheckSSL() {
		return checkSSL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckSSL(boolean newCheckSSL) {
		boolean oldCheckSSL = checkSSL;
		checkSSL = newCheckSSL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.BINDING__CHECK_SSL, oldCheckSSL, checkSSL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.BINDING__IP:
				return getIp();
			case ConfigPackage.BINDING__TCP:
				return isTcp();
			case ConfigPackage.BINDING__TCP_PORT:
				return getTcpPort();
			case ConfigPackage.BINDING__HTTP:
				return isHttp();
			case ConfigPackage.BINDING__HTTP_PORT:
				return getHttpPort();
			case ConfigPackage.BINDING__CHECK_SSL:
				return isCheckSSL();
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
			case ConfigPackage.BINDING__IP:
				setIp((String)newValue);
				return;
			case ConfigPackage.BINDING__TCP:
				setTcp((Boolean)newValue);
				return;
			case ConfigPackage.BINDING__TCP_PORT:
				setTcpPort((String)newValue);
				return;
			case ConfigPackage.BINDING__HTTP:
				setHttp((Boolean)newValue);
				return;
			case ConfigPackage.BINDING__HTTP_PORT:
				setHttpPort((String)newValue);
				return;
			case ConfigPackage.BINDING__CHECK_SSL:
				setCheckSSL((Boolean)newValue);
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
			case ConfigPackage.BINDING__IP:
				setIp(IP_EDEFAULT);
				return;
			case ConfigPackage.BINDING__TCP:
				setTcp(TCP_EDEFAULT);
				return;
			case ConfigPackage.BINDING__TCP_PORT:
				setTcpPort(TCP_PORT_EDEFAULT);
				return;
			case ConfigPackage.BINDING__HTTP:
				setHttp(HTTP_EDEFAULT);
				return;
			case ConfigPackage.BINDING__HTTP_PORT:
				setHttpPort(HTTP_PORT_EDEFAULT);
				return;
			case ConfigPackage.BINDING__CHECK_SSL:
				setCheckSSL(CHECK_SSL_EDEFAULT);
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
			case ConfigPackage.BINDING__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ConfigPackage.BINDING__TCP:
				return tcp != TCP_EDEFAULT;
			case ConfigPackage.BINDING__TCP_PORT:
				return TCP_PORT_EDEFAULT == null ? tcpPort != null : !TCP_PORT_EDEFAULT.equals(tcpPort);
			case ConfigPackage.BINDING__HTTP:
				return http != HTTP_EDEFAULT;
			case ConfigPackage.BINDING__HTTP_PORT:
				return HTTP_PORT_EDEFAULT == null ? httpPort != null : !HTTP_PORT_EDEFAULT.equals(httpPort);
			case ConfigPackage.BINDING__CHECK_SSL:
				return checkSSL != CHECK_SSL_EDEFAULT;
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
		result.append(" (ip: ");
		result.append(ip);
		result.append(", tcp: ");
		result.append(tcp);
		result.append(", tcpPort: ");
		result.append(tcpPort);
		result.append(", http: ");
		result.append(http);
		result.append(", httpPort: ");
		result.append(httpPort);
		result.append(", checkSSL: ");
		result.append(checkSSL);
		result.append(')');
		return result.toString();
	}

} //BindingImpl
