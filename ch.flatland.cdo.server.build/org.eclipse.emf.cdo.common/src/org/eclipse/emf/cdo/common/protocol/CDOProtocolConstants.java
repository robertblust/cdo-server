/*
 * Copyright (c) 2009-2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - bug 230832
 *    Simon McDuff - bug 233490
 *    Simon McDuff - bug 213402
 *    Christian W. Damus (CEA LIST) - bug 399306, bug 399487
 */
package org.eclipse.emf.cdo.common.protocol;

/**
 * Symbolic protocol constants commonly used in CDO.
 *
 * @author Eike Stepper
 * @since 2.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CDOProtocolConstants
{
  public static final String PROTOCOL_NAME = "cdo"; //$NON-NLS-1$

  /**
   * @since 4.2
   * @noreference This field is not intended to be referenced by clients.
   */
  public static final int PROTOCOL_VERSION = 27; // SIGNAL_OPENED_SESSION

  // public static final int PROTOCOL_VERSION = 26; // Add prefetch depth in LockStateRequest/Indication
  // public static final int PROTOCOL_VERSION = 25; // OpenSessionResponse.repositoryAuthenticating
  // public static final int PROTOCOL_VERSION = 24; // SIGNAL_LOAD_OBJECT_LIFETIME
  // public static final int PROTOCOL_VERSION = 23; // Fix branch renaming
  // public static final int PROTOCOL_VERSION = 22; // Prefetch returns RevisionInfo instead of CDORevision to have
  // PointerCDORevision
  // public static final int PROTOCOL_VERSION = 21; // Update how CDOChangeSetData's detachedObject is encoded, see
  // https://bugs.eclipse.org/bugs/show_bug.cgi?id=449171
  // public static final int PROTOCOL_VERSION = 20; // Have OMMOnitor optional in
  // RequestWithMonitoring/IndicationWithMonitoring
  // public static final int PROTOCOL_VERSION = 19; // Branch renaming
  // public static final int PROTOCOL_VERSION = 18; // Password change protocol
  // public static final int PROTOCOL_VERSION = 17; // Last update for make query fail in sequence

  // //////////////////////////////////////////////////////////////////////
  // Signal IDs

  public static final short SIGNAL_OPEN_SESSION = 1;

  public static final short SIGNAL_AUTHENTICATION = 2;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_OPEN_VIEW = 3;

  /**
   * @since 4.0
   */
  public static final short SIGNAL_SWITCH_TARGET = 4;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_CLOSE_VIEW = 5;

  public static final short SIGNAL_LOAD_PACKAGES = 6;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_REVISIONS = 7;

  public static final short SIGNAL_LOAD_REVISION_BY_VERSION = 8;

  public static final short SIGNAL_LOAD_CHUNK = 9;

  public static final short SIGNAL_COMMIT_NOTIFICATION = 10;

  public static final short SIGNAL_COMMIT_TRANSACTION = 11;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_COMMIT_DELEGATION = 12;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_XA_COMMIT_TRANSACTION_PHASE1 = 13;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_XA_COMMIT_TRANSACTION_PHASE2 = 14;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_XA_COMMIT_TRANSACTION_PHASE3 = 15;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_XA_COMMIT_TRANSACTION_CANCEL = 16;

  public static final short SIGNAL_QUERY = 17;

  public static final short SIGNAL_QUERY_CANCEL = 18;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REFRESH_SESSION = 19;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_DISABLE_PASSIVE_UPDATE = 20;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_SET_PASSIVE_UPDATE_MODE = 21;

  public static final short SIGNAL_CHANGE_SUBSCRIPTION = 22;

  public static final short SIGNAL_REPOSITORY_TIME = 23;

  public static final short SIGNAL_LOCK_OBJECTS = 24;

  public static final short SIGNAL_UNLOCK_OBJECTS = 25;

  public static final short SIGNAL_OBJECT_LOCKED = 26;

  /**
   * @since 4.0
   */
  public static final short SIGNAL_LOCK_AREA = 27;

  public static final short SIGNAL_GET_REMOTE_SESSIONS = 28;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REMOTE_MESSAGE = 29;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REMOTE_MESSAGE_NOTIFICATION = 30;

  public static final short SIGNAL_UNSUBSCRIBE_REMOTE_SESSIONS = 31;

  public static final short SIGNAL_REMOTE_SESSION_NOTIFICATION = 32;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_CREATE_BRANCH = 33;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_BRANCH = 34;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_SUB_BRANCHES = 35;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_BRANCHES = 36;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REPOSITORY_TYPE_NOTIFICATION = 37;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REPOSITORY_STATE_NOTIFICATION = 38;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_BRANCH_NOTIFICATION = 39;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_COMMIT_INFOS = 40;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_COMMIT_DATA = 41;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REPLICATE_REPOSITORY = 42;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_REPLICATE_REPOSITORY_RAW = 43;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_CHANGE_SETS = 44;

  /**
   * @since 3.0
   */
  public static final short SIGNAL_LOAD_MERGE_DATA = 45;

  /**
   * @since 4.0
   */
  public static final short SIGNAL_QUERY_LOBS = 46;

  /**
   * @since 4.0
   */
  public static final short SIGNAL_LOAD_LOB = 47;

  /**
   * @since 4.0
   */
  public static final short SIGNAL_HANDLE_REVISIONS = 48;

  /**
   * @since 4.1
   */
  public static final short SIGNAL_LOCK_DELEGATION = 49;

  /**
   * @since 4.1
   */
  public static final short SIGNAL_UNLOCK_DELEGATION = 50;

  /**
   * @since 4.1
   */
  public static final short SIGNAL_LOCK_NOTIFICATION = 51;

  /**
   * @since 4.1
   */
  public static final short SIGNAL_LOCK_STATE = 52;

  /**
   * @since 4.1
   */
  public static final short SIGNAL_ENABLE_LOCK_NOTIFICATION = 53;

  /**
   * @since 4.1
   */
  public static final short SIGNAL_SET_LOCK_NOTIFICATION_MODE = 54;

  /**
   * @since 4.3
   */
  public static final short SIGNAL_LOAD_PERMISSIONS = 55;

  /**
   * Client's request to the server to initiate a change-credentials operation.
   *
   * @since 4.3
   *
   * @see #SIGNAL_CREDENTIALS_CHALLENGE
   */
  public static final short SIGNAL_CHANGE_CREDENTIALS = 56;

  /**
   * Server's request to the client for new credentials.
   *
   * @since 4.3
   *
   * @see #SIGNAL_CHANGE_CREDENTIALS
   */
  public static final short SIGNAL_CREDENTIALS_CHALLENGE = 57;

  /**
   * @since 4.3
   */
  public static final short SIGNAL_RENAME_BRANCH = 58;

  /**
   * @since 4.4
   */
  public static final short SIGNAL_LOAD_OBJECT_LIFETIME = 59;

  // //////////////////////////////////////////////////////////////////////
  // Session Refresh

  /**
   * @since 3.0
   */
  public static final byte REFRESH_FINISHED = 0;

  /**
   * @since 3.0
   */
  public static final byte REFRESH_PACKAGE_UNIT = 1;

  /**
   * @since 3.0
   */
  public static final byte REFRESH_CHANGED_OBJECT = 2;

  /**
   * @since 3.0
   */
  public static final byte REFRESH_DETACHED_OBJECT = 3;

  // //////////////////////////////////////////////////////////////////////
  // Query Support

  /**
   * @since 4.3
   */
  public static final byte QUERY_RESULT_EXCEPTION = 0;

  /**
   * @since 4.3
   */
  public static final byte QUERY_RESULT_PRIMITIVE = 1;

  /**
   * @since 4.3
   */
  public static final byte QUERY_RESULT_REVISION = 2;

  public static final String QUERY_LANGUAGE_RESOURCES = "resources"; //$NON-NLS-1$

  public static final String QUERY_LANGUAGE_RESOURCES_FOLDER_ID = "folder"; //$NON-NLS-1$

  public static final String QUERY_LANGUAGE_RESOURCES_EXACT_MATCH = "exactMatch"; //$NON-NLS-1$

  /**
   * @since 4.3
   */
  public static final String QUERY_LANGUAGE_INSTANCES = "instances"; //$NON-NLS-1$

  /**
   * @since 4.3
   */
  public static final String QUERY_LANGUAGE_INSTANCES_TYPE = "type"; //$NON-NLS-1$

  /**
   * @since 4.3
   */
  public static final String QUERY_LANGUAGE_INSTANCES_EXACT = "exact"; //$NON-NLS-1$

  /**
   * @since 3.0
   */
  public static final String QUERY_LANGUAGE_XREFS = "xrefs"; //$NON-NLS-1$

  /**
   * @since 3.0
   */
  public static final String QUERY_LANGUAGE_XREFS_SOURCE_REFERENCES = "sourceReferences"; //$NON-NLS-1$

  // //////////////////////////////////////////////////////////////////////
  // Locking Objects

  public static final int RELEASE_ALL_LOCKS = -1;

  // //////////////////////////////////////////////////////////////////////
  // Remote Sessions

  public static final int NO_MORE_REMOTE_SESSIONS = -1;

  public static final byte REMOTE_SESSION_OPENED = 1;

  public static final byte REMOTE_SESSION_CLOSED = 2;

  public static final byte REMOTE_SESSION_SUBSCRIBED = 3;

  public static final byte REMOTE_SESSION_UNSUBSCRIBED = 4;

  /**
   * @since 3.0
   */
  public static final byte REMOTE_SESSION_CUSTOM_DATA = 5;

  // //////////////////////////////////////////////////////////////////////
  // Syncing

  /**
   * @since 3.0
   */
  public static final byte REPLICATE_FINISHED = 0;

  /**
   * @since 3.0
   */
  public static final byte REPLICATE_BRANCH = 1;

  /**
   * @since 3.0
   */
  public static final byte REPLICATE_COMMIT = 2;

  /**
   * @since 4.1
   */
  public static final byte REPLICATE_LOCKAREA = 3;

  // //////////////////////////////////////////////////////////////////////
  // Committing Transactions

  /**
   * @since 4.2
   */
  public static final byte ROLLBACK_REASON_UNKNOWN = 0;

  /**
   * @since 4.2
   */
  public static final byte ROLLBACK_REASON_OPTIMISTIC_LOCKING = 1;

  /**
   * @since 4.2
   */
  public static final byte ROLLBACK_REASON_COMMIT_CONFLICT = 2;

  /**
   * @since 4.2
   */
  public static final byte ROLLBACK_REASON_CONTAINMENT_CYCLE = 3;

  /**
   * @since 4.2
   */
  public static final byte ROLLBACK_REASON_REFERENTIAL_INTEGRITY = 4;

  /**
   * @since 4.3
   */
  public static final byte ROLLBACK_REASON_VALIDATION_ERROR = 5;

  // //////////////////////////////////////////////////////////////////////
  // Security

  /**
   * @since 4.3
   */
  public static final byte REVISION_DOES_NOT_EXIST = -1;
}
