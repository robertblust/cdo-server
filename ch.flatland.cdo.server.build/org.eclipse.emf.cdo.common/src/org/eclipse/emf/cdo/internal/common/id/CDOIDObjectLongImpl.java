/*
 * Copyright (c) 2009-2013 Eike Stepper (Berlin, Germany) and others.
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
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOID;
import org.eclipse.emf.cdo.spi.common.id.InternalCDOIDObject;

import org.eclipse.net4j.util.CheckUtil;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.ref.Interner;

import java.io.IOException;
import java.io.ObjectStreamException;

/**
 * @author Eike Stepper
 * @since 2.0
 */
public final class CDOIDObjectLongImpl extends AbstractCDOID implements InternalCDOIDObject
{
  private static final long serialVersionUID = 1L;

  private static final LongInterner INTERNER = new LongInterner();

  private final long value;

  private CDOIDObjectLongImpl(long value)
  {
    CheckUtil.checkArg(value != 0L, "Zero not allowed");
    this.value = value;
  }

  /**
   * A private default constructor for technologies (such as Hessian) that initialize the instance fields via reflection.
   * Note that {@link #readResolve()} must be called in any case to ensure value uniqueness.
   */
  private CDOIDObjectLongImpl()
  {
    value = 0L;
  }

  public long getLongValue()
  {
    return value;
  }

  @Override
  public void write(CDODataOutput out) throws IOException
  {
    out.writeLong(value);
  }

  public String toURIFragment()
  {
    return String.valueOf(value);
  }

  public Type getType()
  {
    return Type.OBJECT;
  }

  public boolean isExternal()
  {
    return false;
  }

  public boolean isObject()
  {
    return true;
  }

  public boolean isTemporary()
  {
    return false;
  }

  /**
   * @since 3.0
   */
  public CDOID.ObjectType getSubType()
  {
    return CDOID.ObjectType.LONG;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(value);
  }

  @Override
  public String toString()
  {
    return "OID" + value; //$NON-NLS-1$
  }

  @Override
  protected int doCompareTo(CDOID o) throws ClassCastException
  {
    return new Long(value).compareTo(((CDOIDObjectLongImpl)o).value);
  }

  private Object readResolve() throws ObjectStreamException
  {
    return create(value);
  }

  private static int getHashCode(long value)
  {
    return ObjectUtil.hashCode(value);
  }

  public static CDOIDObjectLongImpl create(long value)
  {
    return INTERNER.intern(value);
  }

  public static CDOIDObjectLongImpl create(CDODataInput in) throws IOException
  {
    long value = in.readLong();
    return create(value);
  }

  public static CDOIDObjectLongImpl create(String fragmentPart)
  {
    long value = Long.parseLong(fragmentPart);
    return create(value);
  }

  /**
   * @author Eike Stepper
   */
  private static final class LongInterner extends Interner<CDOIDObjectLongImpl>
  {
    public synchronized CDOIDObjectLongImpl intern(long value)
    {
      int hashCode = getHashCode(value);
      for (Entry<CDOIDObjectLongImpl> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry())
      {
        CDOIDObjectLongImpl id = entry.get();
        if (id != null && id.value == value)
        {
          return id;
        }
      }

      CDOIDObjectLongImpl id = new CDOIDObjectLongImpl(value);
      addEntry(createEntry(id, hashCode));
      return id;
    }

    @Override
    protected int hashCode(CDOIDObjectLongImpl id)
    {
      return getHashCode(id.value);
    }
  }
}
