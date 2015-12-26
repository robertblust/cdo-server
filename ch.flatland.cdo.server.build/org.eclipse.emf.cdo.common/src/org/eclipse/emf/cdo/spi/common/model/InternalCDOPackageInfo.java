/*
 * Copyright (c) 2009-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.model;

import org.eclipse.emf.cdo.common.model.CDOPackageInfo;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;

import java.io.IOException;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 2.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface InternalCDOPackageInfo extends CDOPackageInfo, Adapter.Internal
{
  public InternalCDOPackageUnit getPackageUnit();

  public void setPackageUnit(InternalCDOPackageUnit packageUnit);

  public void setPackageURI(String packageURI);

  public void setParentURI(String parentURI);

  /**
   * @since 4.2
   */
  public void setEPackage(EPackage ePackage);

  /**
   * @since 3.0
   */
  public void write(CDODataOutput out) throws IOException;

  /**
   * @since 3.0
   */
  public void read(CDODataInput in) throws IOException;

  /**
   * @since 4.4
   */
  public InternalCDOPackageInfo copy();
}
