/*
 * Copyright (c) 2008-2013 Eike Stepper (Berlin, Germany) and others.
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
import org.eclipse.emf.cdo.common.id.CDOIDTemp;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOID;

import org.eclipse.net4j.util.CheckUtil;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.ref.Interner;

import java.io.IOException;

/**
 * @author Eike Stepper
 * @since 2.0
 */
public final class CDOIDTempObjectImpl extends AbstractCDOID implements CDOIDTemp
{
  private static final long serialVersionUID = 1L;

  private static final IntInterner INTERNER = new IntInterner();

  private final int value;

  private CDOIDTempObjectImpl(int value)
  {
    CheckUtil.checkArg(value != 0, "Zero not allowed");
    this.value = value;
  }

  /**
   * A private default constructor for technologies (such as Hessian) that initialize the instance fields via reflection.
   * Note that {@link #readResolve()} must be called in any case to ensure value uniqueness.
   */
  private CDOIDTempObjectImpl()
  {
    value = 0;
  }

  public int getIntValue()
  {
    return value;
  }

  @Override
  public void write(CDODataOutput out) throws IOException
  {
    out.writeInt(value);
  }

  public String toURIFragment()
  {
    return String.valueOf(value);
  }

  public Type getType()
  {
    return Type.TEMP_OBJECT;
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
    return true;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(value);
  }

  @Override
  public String toString()
  {
    return "oid" + value; //$NON-NLS-1$
  }

  @Override
  protected int doCompareTo(CDOID o) throws ClassCastException
  {
    CDOIDTempObjectImpl that = (CDOIDTempObjectImpl)o;
    if (value < that.value)
    {
      return -1;
    }

    if (value > that.value)
    {
      return 1;
    }

    return 0;
  }

  private static int getHashCode(int value)
  {
    return value;
  }

  public static CDOIDTempObjectImpl create(int value)
  {
    return INTERNER.intern(value);
  }

  public static CDOIDTempObjectImpl create(CDODataInput in) throws IOException
  {
    int value = in.readInt();
    return create(value);
  }

  public static CDOIDTempObjectImpl create(String fragmentPart)
  {
    int value = Integer.parseInt(fragmentPart);
    return create(value);
  }

  /**
   * @author Eike Stepper
   */
  private static final class IntInterner extends Interner<CDOIDTempObjectImpl>
  {
    public synchronized CDOIDTempObjectImpl intern(int value)
    {
      int hashCode = getHashCode(value);
      for (Entry<CDOIDTempObjectImpl> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry())
      {
        CDOIDTempObjectImpl id = entry.get();
        if (id != null && id.value == value)
        {
          return id;
        }
      }

      CDOIDTempObjectImpl id = new CDOIDTempObjectImpl(value);
      addEntry(createEntry(id, hashCode));
      return id;
    }

    @Override
    protected int hashCode(CDOIDTempObjectImpl id)
    {
      return getHashCode(id.value);
    }
  }
}
