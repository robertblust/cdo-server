/*
 * Copyright (c) 2012, 2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Christian W. Damus (CEA LIST) - bug 399306
 *    Christian W. Damus (CEA LIST) - bug 418454
 *    Christian W. Damus (CEA LIST) - bug 399487
 *    Robert Blust - Adapted to support Authentication via ldap
 */
package ch.flatland.cdo.server.product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.protocol.CDOProtocol.CommitNotificationInfo;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.CDORevisionProvider;
import org.eclipse.emf.cdo.common.revision.CDORevisionUtil;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.common.security.CDOPermission;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.internal.security.PermissionUtil;
import org.eclipse.emf.cdo.internal.security.ViewCreator;
import org.eclipse.emf.cdo.net4j.CDONet4jSession;
import org.eclipse.emf.cdo.net4j.CDONet4jSessionConfiguration;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.security.Access;
import org.eclipse.emf.cdo.security.Directory;
import org.eclipse.emf.cdo.security.Group;
import org.eclipse.emf.cdo.security.PatternStyle;
import org.eclipse.emf.cdo.security.Permission;
import org.eclipse.emf.cdo.security.Realm;
import org.eclipse.emf.cdo.security.Role;
import org.eclipse.emf.cdo.security.SecurityFactory;
import org.eclipse.emf.cdo.security.SecurityPackage;
import org.eclipse.emf.cdo.security.User;
import org.eclipse.emf.cdo.security.UserPassword;
import org.eclipse.emf.cdo.security.impl.PermissionImpl;
import org.eclipse.emf.cdo.security.impl.PermissionImpl.CommitImpactContext;
import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IPermissionManager;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.ISession;
import org.eclipse.emf.cdo.server.IStoreAccessor.CommitContext;
import org.eclipse.emf.cdo.server.ITransaction;
import org.eclipse.emf.cdo.server.internal.security.bundle.OM;
import org.eclipse.emf.cdo.server.spi.security.InternalSecurityManager;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevisionDelta;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevisionManager;
import org.eclipse.emf.cdo.spi.common.revision.ManagedRevisionProvider;
import org.eclipse.emf.cdo.spi.server.InternalCommitContext;
import org.eclipse.emf.cdo.spi.server.InternalRepository;
import org.eclipse.emf.cdo.spi.server.InternalSessionManager;
import org.eclipse.emf.cdo.spi.server.ObjectWriteAccessHandler;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.spi.cdo.InternalCDOSessionInvalidationEvent;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.util.ArrayUtil;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.collection.HashBag;
import org.eclipse.net4j.util.container.ContainerEventAdapter;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.Lifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.monitor.OMMonitor;
import org.eclipse.net4j.util.security.IAuthenticator;
import org.eclipse.net4j.util.security.IPasswordCredentials;

import ch.flatland.cdo.server.AuthenticationUtil;

/**
 * @author Eike Stepper
 */
@SuppressWarnings("all")
public class SecurityManager extends Lifecycle implements InternalSecurityManager {
	private static final Map<IRepository, InternalSecurityManager> SECURITY_MANAGERS = new HashMap<IRepository, InternalSecurityManager>();

	private static final SecurityFactory SF = SecurityFactory.eINSTANCE;

	private final IListener repositoryListener = new LifecycleEventAdapter() {
		@Override
		protected void onActivated(ILifecycle lifecycle) {
			init();
		}

		@Override
		protected void onDeactivated(ILifecycle lifecycle) {
			SECURITY_MANAGERS.remove(getRepository());
			SecurityManager.this.deactivate();
		}
	};

	private final IListener sessionManagerListener = new ContainerEventAdapter<ISession>() {
		@Override
		protected void onRemoved(IContainer<ISession> container, ISession session) {
			removeUserInfo(session);
		}
	};

	private final IListener systemListener = new IListener() {
		private boolean clearUserInfos;

		public void notifyEvent(IEvent event) {
			if (event instanceof InternalCDOSessionInvalidationEvent) {
				InternalCDOSessionInvalidationEvent e = (InternalCDOSessionInvalidationEvent) event;
				if (e.getSecurityImpact() == CommitNotificationInfo.IMPACT_REALM) {
					clearUserInfos = true;
				}
			} else if (event instanceof CDOViewInvalidationEvent) {
				if (clearUserInfos) {
					clearUserInfos();
					clearUserInfos = false;
				}
			}
		}
	};

	private IAuthenticator authenticator;

	private final IPermissionManager permissionManager = new PermissionManager();

	private final IRepository.WriteAccessHandler writeAccessHandler = new WriteAccessHandler();

	private final String realmPath;

	private final IManagedContainer container;

	private final Map<ISession, UserInfo> userInfos = new HashMap<ISession, UserInfo>();

	private final HashBag<PermissionImpl> permissionBag = new HashBag<PermissionImpl>();

	private final Object commitHandlerLock = new Object();

	private CommitHandler[] commitHandlers = {};

	private CommitHandler2[] commitHandlers2 = {};

	private PermissionImpl[] permissionArray = {};

	private InternalRepository repository;

	private IAcceptor acceptor;

	private IConnector connector;

	private CDONet4jSession systemSession;

	private CDOView systemView;

	private Realm realm;

	private CDOID realmID;

	private long lastRealmModification = CDOBranchPoint.UNSPECIFIED_DATE;

	public SecurityManager(String realmPath, IManagedContainer container, IAuthenticator authenticator) {
		this.realmPath = realmPath;
		this.container = container;
		this.authenticator = authenticator;
	}

	public final IManagedContainer getContainer() {
		return container;
	}

	public final String getRealmPath() {
		return realmPath;
	}

	public final IRepository getRepository() {
		return repository;
	}

	public void setRepository(InternalRepository repository) {
		this.repository = repository;
		if (isActive()) {
			init();
		}
	}

	public Realm getRealm() {
		return realm;
	}

	public Role getRole(String id) {
		Role item = realm.getRole(id);
		if (item == null) {
			throw new SecurityException("Role " + id + " not found");
		}

		return item;
	}

	public Group getGroup(String id) {
		Group item = realm.getGroup(id);
		if (item == null) {
			throw new SecurityException("Group " + id + " not found");
		}

		return item;
	}

	public User getUser(String id) {
		User item = realm.getUser(id);
		if (item == null) {
			// ROB: create user if not exist
			addUser(id);
			item = realm.getUser(id);
		}
		if (item == null) {
			throw new SecurityException("User " + id + " not found");
		}

		return item;
	}

	public Role addRole(final String id) {
		final Role[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.addRole(id);
			}
		});

		return result[0];
	}

	public Group addGroup(final String id) {
		final Group[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.addGroup(id);
			}
		});

		return result[0];
	}

	public User addUser(final String id) {
		final User[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.addUser(id);
				// ROB add user to Users group by default
				result[0].getGroups().add(realm.getGroup(Directory.USERS));
			}
		});

		return result[0];
	}

	public User addUser(final String id, final String password) {
		final User[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				UserPassword userPassword = SF.createUserPassword();
				userPassword.setEncrypted(new String(password));

				result[0] = realm.addUser(id);
				result[0].setPassword(userPassword);
				// ROB add user to Users group by default
				result[0].getGroups().add(realm.getGroup(Directory.USERS));
			}
		});

		return result[0];
	}

	public User addUser(IPasswordCredentials credentials) {
		return addUser(credentials.getUserID(), new String(credentials.getPassword()));
	}

	public User setPassword(final String id, final String password) {
		final User[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.setPassword(id, password);
			}
		});

		return result[0];
	}

	public Role removeRole(final String id) {
		final Role[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.removeRole(id);
			}
		});

		return result[0];
	}

	public Group removeGroup(final String id) {
		final Group[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.removeGroup(id);
			}
		});

		return result[0];
	}

	public User removeUser(final String id) {
		final User[] result = { null };
		modify(new RealmOperation() {
			public void execute(Realm realm) {
				result[0] = realm.removeUser(id);
			}
		});

		return result[0];
	}

	public void read(RealmOperation operation) {
		checkReady();
		operation.execute(realm);
	}

	public void modify(RealmOperation operation) {
		modify(operation, false);
	}

	public void modify(RealmOperation operation, boolean waitUntilReadable) {
		checkReady();
		CDOTransaction transaction = systemSession.openTransaction();

		try {
			Realm transactionRealm = transaction.getObject(realm);
			operation.execute(transactionRealm);
			CDOCommitInfo commit = transaction.commit();

			if (waitUntilReadable) {
				systemView.waitForUpdate(commit.getTimeStamp());
			}
		} catch (CommitException ex) {
			throw WrappedException.wrap(ex);
		} finally {
			transaction.close();
		}
	}

	public void removeCommitHandler(CommitHandler handler) {
		checkInactive();
		synchronized (commitHandlerLock) {
			commitHandlers = ArrayUtil.remove(commitHandlers, handler);

			if (handler instanceof CommitHandler2) {
				commitHandlers2 = ArrayUtil.remove(commitHandlers2, (CommitHandler2) handler);
			}
		}
	}

	public CommitHandler[] getCommitHandlers() {
		return commitHandlers;
	}

	public CommitHandler2[] getCommitHandlers2() {
		return commitHandlers2;
	}

	public void addCommitHandler(CommitHandler handler) {
		checkInactive();
		synchronized (commitHandlerLock) {
			commitHandlers = ArrayUtil.add(commitHandlers, handler);

			if (handler instanceof CommitHandler2) {
				commitHandlers2 = ArrayUtil.add(commitHandlers2, (CommitHandler2) handler);
			}
		}
	}

	protected void initCommitHandlers(boolean firstTime) {
		CommitHandler[] handlers = getCommitHandlers();
		for (int i = 0; i < handlers.length; i++) {
			CommitHandler handler = handlers[i];

			try {
				handler.init(this, firstTime);
				OM.LOG.info("Security realm handled by " + handler);
			} catch (Exception ex) {
				OM.LOG.error(ex);
			}
		}
	}

	protected void handleCommit(CommitContext commitContext, User user) {
		CommitHandler[] handlers = getCommitHandlers();
		for (int i = 0; i < handlers.length; i++) {
			CommitHandler handler = handlers[i];

			try {
				handler.handleCommit(this, commitContext, user);
			} catch (Exception ex) {
				OM.LOG.error(ex);
			}
		}
	}

	protected void handleCommitted(CommitContext commitContext) {
		CommitHandler2[] handlers = getCommitHandlers2();
		for (int i = 0; i < handlers.length; i++) {
			CommitHandler2 handler = handlers[i];

			try {
				handler.handleCommitted(this, commitContext);
			} catch (Exception ex) {
				OM.LOG.error(ex);
			}
		}
	}

	/**
	 * Commit-handlers can call back into the security manager to read/modify
	 * the realm while the security manager is in the process of initializing,
	 * so cannot strictly check for active state to assert that we are ready.
	 */
	protected void checkReady() {
		if (realm == null || systemSession == null) {
			// If I have no realm or session, I am probably inactive, so this
			// will throw
			checkActive();
		}
	}

	protected void init() {
		if (realm != null) {
			// Already initialized
			return;
		}

		if (repository == null) {
			// Cannot initialize
			return;
		}

		repository.addListener(repositoryListener);
		if (!LifecycleUtil.isActive(repository)) {
			// Cannot initialize now
			return;
		}

		String repositoryName = repository.getName();
		String acceptorName = repositoryName + "_security";

		acceptor = Net4jUtil.getAcceptor(container, "jvm", acceptorName);
		connector = Net4jUtil.getConnector(container, "jvm", acceptorName);

		CDONet4jSessionConfiguration config = CDONet4jUtil.createNet4jSessionConfiguration();
		config.setConnector(connector);
		config.setRepositoryName(repositoryName);
		config.setUserID(SYSTEM_USER_ID);

		systemSession = config.openNet4jSession();
		systemSession.addListener(systemListener);

		CDOTransaction initialTransaction = systemSession.openTransaction();

		boolean firstTime = !initialTransaction.hasResource(realmPath);
		if (firstTime) {
			realm = createRealm();

			CDOResource resource = initialTransaction.createResource(realmPath);
			resource.getContents().add(realm);

			OM.LOG.info("Security realm created in " + realmPath);
		} else {
			CDOResource resource = initialTransaction.getResource(realmPath);
			realm = (Realm) resource.getContents().get(0);
			OM.LOG.info("Security realm loaded from " + realmPath);
		}

		try {
			initialTransaction.commit();
		} catch (Exception ex) {
			throw WrappedException.wrap(ex);
		} finally {
			initialTransaction.close();
		}

		systemView = systemSession.openView();
		systemView.addListener(systemListener);

		realm = systemView.getObject(realm);
		realmID = realm.cdoID();

		InternalSessionManager sessionManager = repository.getSessionManager();
		sessionManager.setAuthenticator(authenticator);
		sessionManager.setPermissionManager(permissionManager);
		sessionManager.addListener(sessionManagerListener);
		repository.addHandler(writeAccessHandler);

		SECURITY_MANAGERS.put(repository, this);
		initCommitHandlers(firstTime);
	}

	protected Realm createRealm() {
		Realm realm = SF.createRealm("Security Realm");
		realm.setDefaultRoleDirectory(addDirectory(realm, Directory.ROLES));
		realm.setDefaultGroupDirectory(addDirectory(realm, Directory.GROUPS));
		realm.setDefaultUserDirectory(addDirectory(realm, Directory.USERS));

		// Create roles

		Role allReaderRole = realm.addRole(Role.ALL_OBJECTS_READER);
		allReaderRole.getPermissions().add(SF.createFilterPermission(Access.READ, SF.createResourceFilter(".*", PatternStyle.REGEX)));

		Role allWriterRole = realm.addRole(Role.ALL_OBJECTS_WRITER);
		allWriterRole.getPermissions().add(SF.createFilterPermission(Access.WRITE, SF.createResourceFilter(".*", PatternStyle.REGEX)));

		Role treeReaderRole = realm.addRole(Role.RESOURCE_TREE_READER);
		treeReaderRole.getPermissions().add(SF.createFilterPermission(Access.READ, SF.createPackageFilter(EresourcePackage.eINSTANCE)));

		Role treeWriterRole = realm.addRole(Role.RESOURCE_TREE_WRITER);
		treeWriterRole.getPermissions().add(SF.createFilterPermission(Access.WRITE, SF.createPackageFilter(EresourcePackage.eINSTANCE)));

		Role adminRole = realm.addRole(Role.ADMINISTRATION);
		adminRole.getPermissions().add(SF.createFilterPermission(Access.WRITE, SF.createResourceFilter(realmPath, PatternStyle.EXACT, false)));
		adminRole.getPermissions().add(SF.createFilterPermission(Access.READ, SF.createResourceFilter(realmPath, PatternStyle.EXACT, true)));

		// Create groups

		Group adminsGroup = realm.addGroup(Group.ADMINISTRATORS);
		adminsGroup.getRoles().add(adminRole);
		// give more rights to administrator
		adminsGroup.getRoles().add(allReaderRole);
		adminsGroup.getRoles().add(allWriterRole);
		adminsGroup.getRoles().add(treeReaderRole);
		adminsGroup.getRoles().add(treeWriterRole);

		Group usersGroup = realm.addGroup(Directory.USERS);
		usersGroup.getRoles().add(allReaderRole);

		// Create users

		// User adminUser = realm.addUser(User.ADMINISTRATOR, "0000");
		User adminUser = realm.addUser(AuthenticationUtil.ADMIN_USER, AuthenticationUtil.ADMIN_PWD);
		adminUser.getGroups().add(adminsGroup);

		User readUser = realm.addUser(AuthenticationUtil.READONLY_USER, AuthenticationUtil.READONLY_USER);
		readUser.getGroups().add(usersGroup);

		return realm;
	}

	protected Directory addDirectory(Realm realm, String name) {
		Directory directory = SF.createDirectory(name);
		realm.getItems().add(directory);
		return directory;
	}

	protected CDOPermission convertPermission(Access permission) {
		if (permission != null) {
			switch (permission) {
			case READ:
				return CDOPermission.READ;

			case WRITE:
				return CDOPermission.WRITE;
			}
		}

		return CDOPermission.NONE;
	}

	protected CDOPermission authorize(CDORevision revision, CDORevisionProvider revisionProvider, CDOBranchPoint securityContext, ISession session, Access defaultAccess, Permission[] permissions) {
		if (lastRealmModification != CDOBranchPoint.UNSPECIFIED_DATE) {
			systemView.waitForUpdate(lastRealmModification);
			lastRealmModification = CDOBranchPoint.UNSPECIFIED_DATE;
		}

		boolean setUser = defaultAccess == null;
		if (setUser) {
			UserInfo userInfo = getUserInfo(session);
			User user = userInfo.getUser();

			defaultAccess = user.getDefaultAccess();
			permissions = userInfo.getPermissions();

			PermissionUtil.setUser(user.getId());
		}

		try {
			CDOPermission result = convertPermission(defaultAccess);
			if (result == CDOPermission.WRITE) {
				return result;
			}

			for (int i = 0; i < permissions.length; i++) {
				Permission permission = permissions[i];

				CDOPermission p = convertPermission(permission.getAccess());
				if (p.ordinal() <= result.ordinal()) {
					// Avoid expensive calls to Permission.isApplicable() if the
					// permission wouldn't increase
					continue;
				}

				if (permission.isApplicable(revision, revisionProvider, securityContext)) {
					result = p;
					if (result == CDOPermission.WRITE) {
						return result;
					}
				}
			}

			return result;
		} finally {
			if (setUser) {
				PermissionUtil.setUser(null);
			}
		}
	}

	protected UserInfo getUserInfo(ISession session) {
		UserInfo userInfo;
		synchronized (userInfos) {
			userInfo = userInfos.get(session);
		}

		if (userInfo == null) {
			userInfo = addUserInfo(session);
		}

		return userInfo;
	}

	protected UserInfo addUserInfo(ISession session) {
		String userID = session.getUserID();
		User user = getUser(userID);
		UserInfo userInfo = new UserInfo(user);

		synchronized (userInfos) {
			userInfos.put(session, userInfo);

			Permission[] permissions = userInfo.getPermissions();
			for (int i = 0; i < permissions.length; i++) {
				Permission permission = permissions[i];
				permissionBag.add((PermissionImpl) permission);
			}

			// Atomic update
			permissionArray = permissionBag.toArray(new PermissionImpl[permissionBag.size()]);
		}

		return userInfo;
	}

	protected UserInfo removeUserInfo(ISession session) {
		UserInfo userInfo;
		synchronized (userInfos) {
			userInfo = userInfos.remove(session);

			if (userInfo != null) {
				Permission[] permissions = userInfo.getPermissions();
				for (int i = 0; i < permissions.length; i++) {
					Permission permission = permissions[i];
					permissionBag.remove(permission);
				}

				// Atomic update
				permissionArray = permissionBag.toArray(new PermissionImpl[permissionBag.size()]);
			}
		}

		return userInfo;
	}

	protected void clearUserInfos() {
		synchronized (userInfos) {
			// System.out.println("clearUserInfos()");

			userInfos.clear();
			permissionBag.clear();
			permissionArray = null;
		}
	}

	protected final boolean isAdministrator(User user) {
		// An administrator is one that has write permission on the realm
		// resource
		Realm realm = getRealm();
		if (realm != null) {
			// Can't be an administrator if there isn't a realm
			CDORevision revision = realm.cdoRevision();
			CDORevisionProvider revisionProvider = realm.cdoView();
			CDOBranchPoint securityContext = realm.cdoView();

			for (Permission permission : user.getAllPermissions()) {
				if (permission.getAccess() == Access.WRITE && permission.isApplicable(revision, revisionProvider, securityContext)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	protected void doActivate() throws Exception {
		super.doActivate();
		init();
	}

	@Override
	protected void doDeactivate() throws Exception {
		clearUserInfos();

		realm = null;
		realmID = null;

		systemSession.close();
		systemSession = null;
		systemView = null;

		connector.close();
		connector = null;

		acceptor.close();
		acceptor = null;

		super.doDeactivate();
	}

	public static InternalSecurityManager get(IRepository repository) {
		return SECURITY_MANAGERS.get(repository);
	}

	/**
	 * @author Eike Stepper
	 */
	private static final class UserInfo {
		private final User user;

		private final Permission[] permissions;

		public UserInfo(User user) {
			this.user = user;
			EList<Permission> allPermissions = user.getAllPermissions();
			permissions = allPermissions.toArray(new Permission[allPermissions.size()]);
		}

		public User getUser() {
			return user;
		}

		public Permission[] getPermissions() {
			return permissions;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	private final class PermissionManager implements IPermissionManager {
		@Deprecated
		public CDOPermission getPermission(CDORevision revision, CDOBranchPoint securityContext, String userID) {
			throw new UnsupportedOperationException();
		}

		public CDOPermission getPermission(CDORevision revision, final CDOBranchPoint securityContext, final ISession session) {
			String userID = session.getUserID();
			if (SYSTEM_USER_ID.equals(userID)) {
				return CDOPermission.WRITE;
			}

			if (revision.getEClass() == SecurityPackage.Literals.USER_PASSWORD) {
				return CDOPermission.NONE;
			}

			InternalCDORevisionManager revisionManager = repository.getRevisionManager();
			CDORevisionProvider revisionProvider = new ManagedRevisionProvider(revisionManager, securityContext);

			PermissionUtil.initViewCreation(new ViewCreator() {
				public CDOView createView(CDORevisionProvider revisionProvider) {
					return CDOServerUtil.openView(session, securityContext, revisionProvider);
				}
			});

			try {
				CDOPermission permission = authorize(revision, revisionProvider, securityContext, session, null, null);
				// System.out.println("Loading from " + session + ": " +
				// permission + " --> " + revision);
				return permission;
			} finally {
				PermissionUtil.doneViewCreation();
			}
		}

		public boolean hasAnyRule(ISession session, Set<? extends Object> rules) {
			String userID = session.getUserID();
			if (SYSTEM_USER_ID.equals(userID)) {
				return false;
			}

			UserInfo userInfo = getUserInfo(session);
			Permission[] userPermissions = userInfo.getPermissions();
			for (int i = 0; i < userPermissions.length; i++) {
				Permission userPermission = userPermissions[i];
				if (rules.contains(userPermission)) {
					return true;
				}
			}

			return false;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	private final class WriteAccessHandler implements IRepository.WriteAccessHandler {
		private final IRepository.WriteAccessHandler realmValidationHandler = new RealmValidationHandler();

		public void handleTransactionBeforeCommitting(ITransaction transaction, final CommitContext commitContext, OMMonitor monitor) throws RuntimeException {
			doHandleTransactionBeforeCommitting(transaction, commitContext, monitor);

			if (commitContext.getSecurityImpact() == CommitNotificationInfo.IMPACT_REALM) {
				// Validate changes to the realm
				realmValidationHandler.handleTransactionBeforeCommitting(transaction, commitContext, monitor);
			}
		}

		protected void doHandleTransactionBeforeCommitting(ITransaction transaction, final CommitContext commitContext, OMMonitor monitor) throws RuntimeException {
			if (transaction.getSessionID() == systemSession.getSessionID()) {
				// Access through ISecurityManager.modify(RealmOperation)
				handleCommit(commitContext, null);
				((InternalCommitContext) commitContext).setSecurityImpact(CommitNotificationInfo.IMPACT_REALM, null);
				return;
			}

			UserInfo userInfo = getUserInfo(transaction.getSession());
			User user = userInfo.getUser();

			handleCommit(commitContext, user);

			PermissionUtil.setUser(user.getId());
			PermissionUtil.initViewCreation(new ViewCreator() {
				public CDOView createView(CDORevisionProvider revisionProvider) {
					return CDOServerUtil.openView(commitContext);
				}
			});

			try {
				CDOBranchPoint securityContext = commitContext.getBranchPoint();
				ISession session = transaction.getSession();

				Access userDefaultAccess = user.getDefaultAccess();
				Permission[] userPermissions = userInfo.getPermissions();

				final InternalCDORevision[] revisions = commitContext.getDirtyObjects();
				final InternalCDORevisionDelta[] revisionDeltas = commitContext.getDirtyObjectDeltas();

				// Check permissions on the commit changes and detect realm
				// modifications
				byte securityImpact = CommitNotificationInfo.IMPACT_NONE;
				for (int i = 0; i < revisions.length; i++) {
					InternalCDORevision revision = revisions[i];
					CDOPermission permission = authorize(revision, commitContext, securityContext, session, userDefaultAccess, userPermissions);

					if (permission != CDOPermission.WRITE) {
						throw new SecurityException("User " + commitContext.getUserID() + " is not allowed to write to " + revision);
					}

					if (securityImpact != CommitNotificationInfo.IMPACT_REALM) {
						InternalCDORevisionDelta revisionDelta = revisionDeltas[i];
						if (CDORevisionUtil.isContained(revisionDelta.getID(), realmID, transaction)) // Use
																										// "before commit"
																										// state
						{
							securityImpact = CommitNotificationInfo.IMPACT_REALM;
						}
					}
				}

				// Determine permissions that are impacted by the commit changes
				Set<Permission> impactedRules = null;
				if (securityImpact != CommitNotificationInfo.IMPACT_REALM) {
					PermissionImpl[] assignedPermissions = permissionArray; // Thread-safe
					if (assignedPermissions.length != 0) {
						CommitImpactContext commitImpactContext = new PermissionImpl.CommitImpactContext() {
							public CDORevision[] getNewObjects() {
								return commitContext.getNewObjects();
							}

							public CDORevision[] getDirtyObjects() {
								return revisions;
							}

							public CDORevisionDelta[] getDirtyObjectDeltas() {
								return revisionDeltas;
							}

							public CDOID[] getDetachedObjects() {
								return commitContext.getDetachedObjects();
							}
						};

						for (int i = 0; i < assignedPermissions.length; i++) {
							PermissionImpl permission = assignedPermissions[i];
							if (permission.isImpacted(commitImpactContext)) {
								if (impactedRules == null) {
									impactedRules = new HashSet<Permission>();
								}

								impactedRules.add(permission);
							}
						}

						if (impactedRules != null) {
							securityImpact = CommitNotificationInfo.IMPACT_PERMISSIONS;
						}
					}
				}

				((InternalCommitContext) commitContext).setSecurityImpact(securityImpact, impactedRules);
			} finally {
				PermissionUtil.setUser(null);
				PermissionUtil.doneViewCreation();
			}
		}

		public void handleTransactionAfterCommitted(ITransaction transaction, final CommitContext commitContext, OMMonitor monitor) {
			if (commitContext.getSecurityImpact() == CommitNotificationInfo.IMPACT_REALM) {
				lastRealmModification = commitContext.getBranchPoint().getTimeStamp();
			}

			handleCommitted(commitContext);
		}
	}

	/**
	 * A write-access handler that checks changes about to be committed to the
	 * security realm against its well-formedness rules, and rejects the commit
	 * if there are any integrity errors.
	 * 
	 * @author Christian W. Damus (CEA LIST)
	 */
	private final class RealmValidationHandler extends ObjectWriteAccessHandler {
		private final EValidator realmValidator = EValidator.Registry.INSTANCE.getEValidator(SecurityPackage.eINSTANCE);

		@Override
		protected void handleTransactionBeforeCommitting(OMMonitor monitor) throws RuntimeException {
			final BasicDiagnostic diagnostic = new BasicDiagnostic();
			final Map<Object, Object> context = createValidationContext();

			boolean realmChecked = false;
			for (EObject object : getDirtyObjects()) {
				if (object.eClass().getEPackage() == SecurityPackage.eINSTANCE) {
					validate(object, diagnostic, context);
					realmChecked = object instanceof Realm;
				}
			}

			for (EObject object : getNewObjects()) {
				if (object.eClass().getEPackage() == SecurityPackage.eINSTANCE) {
					validate(object, diagnostic, context);
					// The realm cannot be new
				}
			}

			if (!realmChecked) {
				// Check it, because it has some wide-ranging integrity
				// constraints
				validate(getView().getObject(realmID), diagnostic, context);
			}
		}

		protected Map<Object, Object> createValidationContext() {
			Map<Object, Object> result = new java.util.HashMap<Object, Object>();
			final CommitContext commitContext = getCommitContext();

			// Supply the revision-provider and branch point required by realm
			// validation
			result.put(CDORevisionProvider.class, commitContext);
			result.put(CDOBranchPoint.class, commitContext.getBranchPoint());

			return result;
		}

		protected void validate(EObject object, DiagnosticChain diagnostics, Map<Object, Object> context) {
			realmValidator.validate(object, diagnostics, context);

			Diagnostic error = getError(diagnostics);
			if (error != null) {
				throw new TransactionValidationException("Security realm integrity violation: " + error.getMessage());
			}
		}

		protected Diagnostic getError(DiagnosticChain diagnostics) {
			Diagnostic diagnostic = (Diagnostic) diagnostics;
			if (diagnostic.getSeverity() >= Diagnostic.ERROR) {
				for (Diagnostic child : diagnostic.getChildren()) {
					if (child.getSeverity() >= Diagnostic.ERROR) {
						return child;
					}
				}
			}

			return null;
		}
	}
}
