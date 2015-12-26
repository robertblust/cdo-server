/*
 * Copyright (c) 2012, 2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Christian W. Damus (CEA LIST) - bug 418454
 */
package org.eclipse.emf.cdo.common.admin;

import org.eclipse.emf.cdo.common.CDOCommonRepository;

import org.eclipse.net4j.util.collection.Closeable;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.container.IManagedContainer;

import java.util.Map;

/**
 * An administrative interface to a remote server with CDO {@link CDOCommonRepository repositories}.
 *
 * @author Eike Stepper
 * @since 4.1
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CDOAdmin extends IContainer<CDOAdminRepository>, Closeable
{
  /**
   * The default admin-handler type, which is guaranteed to exist on the server.
   *
   * @since 4.3
   */
  public static final String DEFAULT_TYPE = "default"; //$NON-NLS-1$

  /**
   * The name of the boolean property that indicates whether to configure the
   * default security manager in a repository to be
   * {@linkplain #createRepository(String, String, Map) created}.
   *
   * @since 4.3
   */
  public static final String PROPERTY_SECURITY_MANAGER = "configureSecurityManager"; //$NON-NLS-1$

  /**
   * The name of the boolean property that indicates whether to configure the
   * default {@linkplain #PROPERTY_SECURITY_MANAGER security manager} with
   * support for user home folders.
   *
   * @since 4.3
   */
  public static final String PROPERTY_SECURITY_HOME_FOLDERS = "configureSecurityHomeFolders"; //$NON-NLS-1$

  /**
   * The name of the property that provides the XML configuration string for
   * the store of a repository to be
   * {@linkplain #createRepository(String, String, Map) created}.
   *
   * @since 4.3
   */
  public static final String PROPERTY_STORE_XML_CONFIG = "storeXMLConfig"; //$NON-NLS-1$

  public CDOAdminRepository[] getRepositories();

  public CDOAdminRepository getRepository(String name);

  /**
   * Creates a new remote {@link CDOCommonRepository repository} and returns its administrative interface.
   * <p>
   * On the server-side the creation is delegated to an instance of <code>org.eclipse.emf.cdo.server.spi.admin.CDOAdminHandler</code>
   * that is registered with the server's {@link IManagedContainer container} under the given <code>type</code> argument.
   * The <code>name</code> and <code>properties</code> arguments are passed on to the registered handler.
   */
  public CDOAdminRepository createRepository(String name, String type, Map<String, Object> properties);

  public CDOAdminRepository waitForRepository(String name);
}
