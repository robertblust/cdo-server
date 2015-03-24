/*
 * Copyright (c) 2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.db.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Eike Stepper
 */
public final class JDBCUtil
{
  private JDBCUtil()
  {
  }

  public static Properties getClientInfo(Connection connection) throws SQLException
  {
    return connection.getClientInfo();
  }
}
