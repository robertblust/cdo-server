/*
 * Copyright (c) 2009-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - bug 213402
 */
package org.eclipse.emf.cdo.spi.common.id;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 2.0
 * @noextend This interface is not intended to be extended by clients.
 */
public abstract class AbstractCDOID implements CDOID
{
  private static final long serialVersionUID = 1L;

  protected AbstractCDOID()
  {
  }

  /**
   * @since 4.2
   */
  public boolean isNull()
  {
    return false;
  }

  /**
   * @since 4.2
   */
  @Deprecated
  public final boolean isDangling()
  {
    return false;
  }

  /**
   * @deprecated As of 4.2 not called anymore.
   */
  @Deprecated
  public final void read(String fragmentPart)
  {
    // Do nothing
  }

  /**
   * @deprecated As of 4.2 not called anymore.
   */
  @Deprecated
  public final void read(ExtendedDataInput in) throws IOException
  {
    // Do nothing
  }

  /**
   * @deprecated As of 4.2 {@link #write(CDODataOutput)} is called.
   */
  @Deprecated
  public void write(ExtendedDataOutput out) throws IOException
  {
    // Do nothing
  }

  /**
   * @since 4.2
   */
  public abstract void write(CDODataOutput out) throws IOException;

  @Override
  public String toString()
  {
    return toURIFragment();
  }

  public final int compareTo(CDOID o)
  {
    try
    {
      return doCompareTo(o);
    }
    catch (ClassCastException ex)
    {
      return getType().compareTo(o.getType());
    }
  }

  @Override
  public boolean equals(Object obj)
  {
    return obj == this;
  }

  @Override
  public abstract int hashCode();

  protected abstract int doCompareTo(CDOID o) throws ClassCastException;
}
