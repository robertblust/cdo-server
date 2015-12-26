/*
 * Copyright (c) 2009, 2011-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.id;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDExternal;
import org.eclipse.emf.cdo.common.id.CDOIDString;
import org.eclipse.emf.cdo.common.id.CDOIDTemp;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOID;

import org.eclipse.net4j.util.CheckUtil;
import org.eclipse.net4j.util.ref.Interner;

import java.io.IOException;
import java.io.ObjectStreamException;

/**
 * @author Eike Stepper
 * @since 2.0
 */
public final class CDOIDTempObjectExternalImpl extends AbstractCDOID implements CDOIDExternal, CDOIDTemp, CDOIDString
{
  private static final long serialVersionUID = 1L;

  private static final StringInterner INTERNER = new StringInterner();

  private final String uri;

  private CDOIDTempObjectExternalImpl(String uri)
  {
    CheckUtil.checkArg(uri, "Null not allowed");
    this.uri = uri;
  }

  /**
   * A private default constructor for technologies (such as Hessian) that initialize the instance fields via reflection.
   * Note that {@link #readResolve()} must be called in any case to ensure value uniqueness.
   */
  private CDOIDTempObjectExternalImpl()
  {
    uri = null;
  }

  @Override
  public void write(CDODataOutput out) throws IOException
  {
    out.writeString(uri);
  }

  public String toURIFragment()
  {
    return uri;
  }

  public String getURI()
  {
    return uri;
  }

  public String getStringValue()
  {
    return uri;
  }

  public Type getType()
  {
    return Type.EXTERNAL_TEMP_OBJECT;
  }

  public boolean isExternal()
  {
    return true;
  }

  public boolean isObject()
  {
    return true;
  }

  public boolean isTemporary()
  {
    return true;
  }

  @Override
  public int hashCode()
  {
    return uri.hashCode();
  }

  @Override
  public String toString()
  {
    return "oid:" + uri; //$NON-NLS-1$
  }

  @Override
  protected int doCompareTo(CDOID o) throws ClassCastException
  {
    return uri.compareTo(((CDOIDTempObjectExternalImpl)o).uri);
  }

  private Object readResolve() throws ObjectStreamException
  {
    return create(uri);
  }

  private static int getHashCode(String uri)
  {
    return uri.hashCode();
  }

  public static CDOIDTempObjectExternalImpl create(String uri)
  {
    return INTERNER.intern(uri);
  }

  public static CDOIDTempObjectExternalImpl create(CDODataInput in) throws IOException
  {
    String uri = in.readString();
    return create(uri);
  }

  /**
   * @author Eike Stepper
   */
  private static final class StringInterner extends Interner<CDOIDTempObjectExternalImpl>
  {
    public synchronized CDOIDTempObjectExternalImpl intern(String uri)
    {
      int hashCode = getHashCode(uri);
      for (Entry<CDOIDTempObjectExternalImpl> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry())
      {
        CDOIDTempObjectExternalImpl id = entry.get();
        if (id != null && id.uri.equals(uri))
        {
          return id;
        }
      }

      CDOIDTempObjectExternalImpl id = new CDOIDTempObjectExternalImpl(uri);
      addEntry(createEntry(id, hashCode));
      return id;
    }

    @Override
    protected int hashCode(CDOIDTempObjectExternalImpl id)
    {
      return getHashCode(id.uri);
    }
  }
}
