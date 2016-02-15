/**
 */
package ch.flatland.cdo.model.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.config.ConfigFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='ch.flatland.cdo.model'"
 * @generated
 */
public interface ConfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "config";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ch.flatland.cdo.model.config";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "config";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigPackage eINSTANCE = ch.flatland.cdo.model.config.impl.ConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.impl.ConfigImpl <em>Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.impl.ConfigImpl
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getConfig()
	 * @generated
	 */
	int CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Read Only Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__READ_ONLY_PASSWORD = 0;

	/**
	 * The feature id for the '<em><b>Admin Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__ADMIN_PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Repositories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__REPOSITORIES = 2;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__BINDING = 3;

	/**
	 * The feature id for the '<em><b>Json</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__JSON = 4;

	/**
	 * The number of structural features of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get By Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG___GET_BY_NAME__STRING = 0;

	/**
	 * The number of operations of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.impl.BindingImpl
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 1;

	/**
	 * The feature id for the '<em><b>Tcp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__TCP = 0;

	/**
	 * The feature id for the '<em><b>Tcp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__TCP_PORT = 1;

	/**
	 * The feature id for the '<em><b>Http</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__HTTP = 2;

	/**
	 * The feature id for the '<em><b>Check SSL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__CHECK_SSL = 3;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.impl.JsonImpl <em>Json</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.impl.JsonImpl
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getJson()
	 * @generated
	 */
	int JSON = 2;

	/**
	 * The feature id for the '<em><b>Validate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__VALIDATE = 0;

	/**
	 * The feature id for the '<em><b>Rreferences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__RREFERENCES = 1;

	/**
	 * The feature id for the '<em><b>Creferences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__CREFERENCES = 2;

	/**
	 * The feature id for the '<em><b>Xreferences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__XREFERENCES = 3;

	/**
	 * The feature id for the '<em><b>History</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__HISTORY = 4;

	/**
	 * The feature id for the '<em><b>Full Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__FULL_URL = 5;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__META = 6;

	/**
	 * The feature id for the '<em><b>Links</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__LINKS = 7;

	/**
	 * The feature id for the '<em><b>Xlinks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__XLINKS = 8;

	/**
	 * The feature id for the '<em><b>Arrayaccessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__ARRAYACCESSOR = 9;

	/**
	 * The feature id for the '<em><b>Xtraces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__XTRACES = 10;

	/**
	 * The feature id for the '<em><b>Cdometa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON__CDOMETA = 11;

	/**
	 * The number of structural features of the '<em>Json</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Json</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.impl.RepositoryImpl
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Data Store</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DATA_STORE = 0;

	/**
	 * The feature id for the '<em><b>Authenticator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__AUTHENTICATOR = 1;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.impl.DataStoreImpl <em>Data Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.impl.DataStoreImpl
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getDataStore()
	 * @generated
	 */
	int DATA_STORE = 4;

	/**
	 * The feature id for the '<em><b>Store Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__STORE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Repository Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__REPOSITORY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Connection Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__CONNECTION_URL = 2;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__USER_NAME = 3;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__PASSWORD = 4;

	/**
	 * The feature id for the '<em><b>Temporality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__TEMPORALITY = 5;

	/**
	 * The number of structural features of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.impl.AuthenticatorImpl <em>Authenticator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.impl.AuthenticatorImpl
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getAuthenticator()
	 * @generated
	 */
	int AUTHENTICATOR = 5;

	/**
	 * The feature id for the '<em><b>Authenticator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATOR__AUTHENTICATOR_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Connection Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATOR__CONNECTION_URL = 1;

	/**
	 * The feature id for the '<em><b>Domain Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATOR__DOMAIN_BASE = 2;

	/**
	 * The feature id for the '<em><b>User Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATOR__USER_ID_FIELD = 3;

	/**
	 * The number of structural features of the '<em>Authenticator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATOR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Authenticator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.StoreType <em>Store Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.StoreType
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getStoreType()
	 * @generated
	 */
	int STORE_TYPE = 6;

	/**
	 * The meta object id for the '{@link ch.flatland.cdo.model.config.AuthenticatorType <em>Authenticator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.flatland.cdo.model.config.AuthenticatorType
	 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getAuthenticatorType()
	 * @generated
	 */
	int AUTHENTICATOR_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.config.Config <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config</em>'.
	 * @see ch.flatland.cdo.model.config.Config
	 * @generated
	 */
	EClass getConfig();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Config#getReadOnlyPassword <em>Read Only Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only Password</em>'.
	 * @see ch.flatland.cdo.model.config.Config#getReadOnlyPassword()
	 * @see #getConfig()
	 * @generated
	 */
	EAttribute getConfig_ReadOnlyPassword();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Config#getAdminPassword <em>Admin Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Admin Password</em>'.
	 * @see ch.flatland.cdo.model.config.Config#getAdminPassword()
	 * @see #getConfig()
	 * @generated
	 */
	EAttribute getConfig_AdminPassword();

	/**
	 * Returns the meta object for the containment reference list '{@link ch.flatland.cdo.model.config.Config#getRepositories <em>Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repositories</em>'.
	 * @see ch.flatland.cdo.model.config.Config#getRepositories()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Repositories();

	/**
	 * Returns the meta object for the containment reference '{@link ch.flatland.cdo.model.config.Config#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding</em>'.
	 * @see ch.flatland.cdo.model.config.Config#getBinding()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Binding();

	/**
	 * Returns the meta object for the containment reference '{@link ch.flatland.cdo.model.config.Config#getJson <em>Json</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Json</em>'.
	 * @see ch.flatland.cdo.model.config.Config#getJson()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Json();

	/**
	 * Returns the meta object for the '{@link ch.flatland.cdo.model.config.Config#getByName(java.lang.String) <em>Get By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get By Name</em>' operation.
	 * @see ch.flatland.cdo.model.config.Config#getByName(java.lang.String)
	 * @generated
	 */
	EOperation getConfig__GetByName__String();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.config.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see ch.flatland.cdo.model.config.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Binding#isTcp <em>Tcp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tcp</em>'.
	 * @see ch.flatland.cdo.model.config.Binding#isTcp()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Tcp();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Binding#getTcpPort <em>Tcp Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tcp Port</em>'.
	 * @see ch.flatland.cdo.model.config.Binding#getTcpPort()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_TcpPort();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Binding#isHttp <em>Http</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http</em>'.
	 * @see ch.flatland.cdo.model.config.Binding#isHttp()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Http();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Binding#isCheckSSL <em>Check SSL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check SSL</em>'.
	 * @see ch.flatland.cdo.model.config.Binding#isCheckSSL()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_CheckSSL();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.config.Json <em>Json</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Json</em>'.
	 * @see ch.flatland.cdo.model.config.Json
	 * @generated
	 */
	EClass getJson();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isValidate <em>Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validate</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isValidate()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Validate();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isRreferences <em>Rreferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rreferences</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isRreferences()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Rreferences();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isCreferences <em>Creferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creferences</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isCreferences()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Creferences();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isXreferences <em>Xreferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xreferences</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isXreferences()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Xreferences();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>History</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isHistory()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_History();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isFullUrl <em>Full Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Url</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isFullUrl()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_FullUrl();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isMeta()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Meta();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Links</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isLinks()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Links();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isXlinks <em>Xlinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xlinks</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isXlinks()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Xlinks();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isArrayaccessor <em>Arrayaccessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrayaccessor</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isArrayaccessor()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Arrayaccessor();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isXtraces <em>Xtraces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xtraces</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isXtraces()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Xtraces();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Json#isCdometa <em>Cdometa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cdometa</em>'.
	 * @see ch.flatland.cdo.model.config.Json#isCdometa()
	 * @see #getJson()
	 * @generated
	 */
	EAttribute getJson_Cdometa();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.config.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see ch.flatland.cdo.model.config.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the containment reference '{@link ch.flatland.cdo.model.config.Repository#getDataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Store</em>'.
	 * @see ch.flatland.cdo.model.config.Repository#getDataStore()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_DataStore();

	/**
	 * Returns the meta object for the containment reference '{@link ch.flatland.cdo.model.config.Repository#getAuthenticator <em>Authenticator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Authenticator</em>'.
	 * @see ch.flatland.cdo.model.config.Repository#getAuthenticator()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Authenticator();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.config.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Store</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore
	 * @generated
	 */
	EClass getDataStore();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.DataStore#getStoreType <em>Store Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Type</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore#getStoreType()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_StoreType();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.DataStore#getRepositoryName <em>Repository Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Name</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore#getRepositoryName()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_RepositoryName();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.DataStore#getConnectionUrl <em>Connection Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Url</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore#getConnectionUrl()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_ConnectionUrl();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.DataStore#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore#getUserName()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_UserName();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.DataStore#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore#getPassword()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_Password();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.DataStore#isTemporality <em>Temporality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temporality</em>'.
	 * @see ch.flatland.cdo.model.config.DataStore#isTemporality()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_Temporality();

	/**
	 * Returns the meta object for class '{@link ch.flatland.cdo.model.config.Authenticator <em>Authenticator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Authenticator</em>'.
	 * @see ch.flatland.cdo.model.config.Authenticator
	 * @generated
	 */
	EClass getAuthenticator();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Authenticator#getAuthenticatorType <em>Authenticator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authenticator Type</em>'.
	 * @see ch.flatland.cdo.model.config.Authenticator#getAuthenticatorType()
	 * @see #getAuthenticator()
	 * @generated
	 */
	EAttribute getAuthenticator_AuthenticatorType();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Authenticator#getConnectionUrl <em>Connection Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Url</em>'.
	 * @see ch.flatland.cdo.model.config.Authenticator#getConnectionUrl()
	 * @see #getAuthenticator()
	 * @generated
	 */
	EAttribute getAuthenticator_ConnectionUrl();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Authenticator#getDomainBase <em>Domain Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Base</em>'.
	 * @see ch.flatland.cdo.model.config.Authenticator#getDomainBase()
	 * @see #getAuthenticator()
	 * @generated
	 */
	EAttribute getAuthenticator_DomainBase();

	/**
	 * Returns the meta object for the attribute '{@link ch.flatland.cdo.model.config.Authenticator#getUserIdField <em>User Id Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id Field</em>'.
	 * @see ch.flatland.cdo.model.config.Authenticator#getUserIdField()
	 * @see #getAuthenticator()
	 * @generated
	 */
	EAttribute getAuthenticator_UserIdField();

	/**
	 * Returns the meta object for enum '{@link ch.flatland.cdo.model.config.StoreType <em>Store Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Store Type</em>'.
	 * @see ch.flatland.cdo.model.config.StoreType
	 * @generated
	 */
	EEnum getStoreType();

	/**
	 * Returns the meta object for enum '{@link ch.flatland.cdo.model.config.AuthenticatorType <em>Authenticator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Authenticator Type</em>'.
	 * @see ch.flatland.cdo.model.config.AuthenticatorType
	 * @generated
	 */
	EEnum getAuthenticatorType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigFactory getConfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.impl.ConfigImpl <em>Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.impl.ConfigImpl
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getConfig()
		 * @generated
		 */
		EClass CONFIG = eINSTANCE.getConfig();

		/**
		 * The meta object literal for the '<em><b>Read Only Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG__READ_ONLY_PASSWORD = eINSTANCE.getConfig_ReadOnlyPassword();

		/**
		 * The meta object literal for the '<em><b>Admin Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG__ADMIN_PASSWORD = eINSTANCE.getConfig_AdminPassword();

		/**
		 * The meta object literal for the '<em><b>Repositories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__REPOSITORIES = eINSTANCE.getConfig_Repositories();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__BINDING = eINSTANCE.getConfig_Binding();

		/**
		 * The meta object literal for the '<em><b>Json</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__JSON = eINSTANCE.getConfig_Json();

		/**
		 * The meta object literal for the '<em><b>Get By Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFIG___GET_BY_NAME__STRING = eINSTANCE.getConfig__GetByName__String();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.impl.BindingImpl
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Tcp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__TCP = eINSTANCE.getBinding_Tcp();

		/**
		 * The meta object literal for the '<em><b>Tcp Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__TCP_PORT = eINSTANCE.getBinding_TcpPort();

		/**
		 * The meta object literal for the '<em><b>Http</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__HTTP = eINSTANCE.getBinding_Http();

		/**
		 * The meta object literal for the '<em><b>Check SSL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__CHECK_SSL = eINSTANCE.getBinding_CheckSSL();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.impl.JsonImpl <em>Json</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.impl.JsonImpl
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getJson()
		 * @generated
		 */
		EClass JSON = eINSTANCE.getJson();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__VALIDATE = eINSTANCE.getJson_Validate();

		/**
		 * The meta object literal for the '<em><b>Rreferences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__RREFERENCES = eINSTANCE.getJson_Rreferences();

		/**
		 * The meta object literal for the '<em><b>Creferences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__CREFERENCES = eINSTANCE.getJson_Creferences();

		/**
		 * The meta object literal for the '<em><b>Xreferences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__XREFERENCES = eINSTANCE.getJson_Xreferences();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__HISTORY = eINSTANCE.getJson_History();

		/**
		 * The meta object literal for the '<em><b>Full Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__FULL_URL = eINSTANCE.getJson_FullUrl();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__META = eINSTANCE.getJson_Meta();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__LINKS = eINSTANCE.getJson_Links();

		/**
		 * The meta object literal for the '<em><b>Xlinks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__XLINKS = eINSTANCE.getJson_Xlinks();

		/**
		 * The meta object literal for the '<em><b>Arrayaccessor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__ARRAYACCESSOR = eINSTANCE.getJson_Arrayaccessor();

		/**
		 * The meta object literal for the '<em><b>Xtraces</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__XTRACES = eINSTANCE.getJson_Xtraces();

		/**
		 * The meta object literal for the '<em><b>Cdometa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON__CDOMETA = eINSTANCE.getJson_Cdometa();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.impl.RepositoryImpl
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Data Store</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__DATA_STORE = eINSTANCE.getRepository_DataStore();

		/**
		 * The meta object literal for the '<em><b>Authenticator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__AUTHENTICATOR = eINSTANCE.getRepository_Authenticator();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.impl.DataStoreImpl <em>Data Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.impl.DataStoreImpl
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getDataStore()
		 * @generated
		 */
		EClass DATA_STORE = eINSTANCE.getDataStore();

		/**
		 * The meta object literal for the '<em><b>Store Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_STORE__STORE_TYPE = eINSTANCE.getDataStore_StoreType();

		/**
		 * The meta object literal for the '<em><b>Repository Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_STORE__REPOSITORY_NAME = eINSTANCE.getDataStore_RepositoryName();

		/**
		 * The meta object literal for the '<em><b>Connection Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_STORE__CONNECTION_URL = eINSTANCE.getDataStore_ConnectionUrl();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_STORE__USER_NAME = eINSTANCE.getDataStore_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_STORE__PASSWORD = eINSTANCE.getDataStore_Password();

		/**
		 * The meta object literal for the '<em><b>Temporality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_STORE__TEMPORALITY = eINSTANCE.getDataStore_Temporality();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.impl.AuthenticatorImpl <em>Authenticator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.impl.AuthenticatorImpl
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getAuthenticator()
		 * @generated
		 */
		EClass AUTHENTICATOR = eINSTANCE.getAuthenticator();

		/**
		 * The meta object literal for the '<em><b>Authenticator Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHENTICATOR__AUTHENTICATOR_TYPE = eINSTANCE.getAuthenticator_AuthenticatorType();

		/**
		 * The meta object literal for the '<em><b>Connection Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHENTICATOR__CONNECTION_URL = eINSTANCE.getAuthenticator_ConnectionUrl();

		/**
		 * The meta object literal for the '<em><b>Domain Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHENTICATOR__DOMAIN_BASE = eINSTANCE.getAuthenticator_DomainBase();

		/**
		 * The meta object literal for the '<em><b>User Id Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHENTICATOR__USER_ID_FIELD = eINSTANCE.getAuthenticator_UserIdField();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.StoreType <em>Store Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.StoreType
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getStoreType()
		 * @generated
		 */
		EEnum STORE_TYPE = eINSTANCE.getStoreType();

		/**
		 * The meta object literal for the '{@link ch.flatland.cdo.model.config.AuthenticatorType <em>Authenticator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.flatland.cdo.model.config.AuthenticatorType
		 * @see ch.flatland.cdo.model.config.impl.ConfigPackageImpl#getAuthenticatorType()
		 * @generated
		 */
		EEnum AUTHENTICATOR_TYPE = eINSTANCE.getAuthenticatorType();

	}

} //ConfigPackage
