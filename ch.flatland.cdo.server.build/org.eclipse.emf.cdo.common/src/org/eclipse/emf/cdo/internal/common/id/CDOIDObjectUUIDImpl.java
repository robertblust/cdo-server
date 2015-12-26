/*
 * Copyright (c) 2010-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Martin Taal - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.internal.common.id;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOID;
import org.eclipse.emf.cdo.spi.common.id.InternalCDOIDObject;

import org.eclipse.net4j.util.CheckUtil;
import org.eclipse.net4j.util.ref.Interner;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.Arrays;

/**
 * @author Martin Taal
 * @since 3.0
 */
public final class CDOIDObjectUUIDImpl extends AbstractCDOID implements InternalCDOIDObject
{
  private static final long serialVersionUID = 1L;

  private static final UUIDInterner INTERNER = new UUIDInterner();

  private final byte[] value;

  private CDOIDObjectUUIDImpl(byte[] value)
  {
    CheckUtil.checkArg(value, "Null not allowed");
    this.value = value;
  }

  /**
   * A private default constructor for technologies (such as Hessian) that initialize the instance fields via reflection.
   * Note that {@link #readResolve()} must be called in any case to ensure value uniqueness.
   */
  private CDOIDObjectUUIDImpl()
  {
    value = null;
  }

  public byte[] getByteArrayValue()
  {
    return value;
  }

  @Override
  public void write(CDODataOutput out) throws IOException
  {
    out.writeByteArray(value);
  }

  public String toURIFragment()
  {
    return CDOIDUtil.encodeUUID(value);
  }

  public Type getType()
  {
    return Type.OBJECT;
  }

  public CDOID.ObjectType getSubType()
  {
    return CDOID.ObjectType.UUID;
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

  @Override
  public int hashCode()
  {
    return getHashCode(value);
  }

  @Override
  protected int doCompareTo(CDOID o) throws ClassCastException
  {
    byte[] thatValue = ((CDOIDObjectUUIDImpl)o).value;
    int minLength = Math.min(value.length, thatValue.length);

    for (int i = 0; i < minLength; i++)
    {
      byte thisByte = value[i];
      byte thatByte = thatValue[i];
      if (thisByte < thatByte)
      {
        return -1;
      }

      if (thisByte > thatByte)
      {
        return 1;
      }
    }

    if (value.length < thatValue.length)
    {
      return -1;
    }

    if (value.length > thatValue.length)
    {
      return 1;
    }

    return 0;
  }

  private Object readResolve() throws ObjectStreamException
  {
    return create(value);
  }

  private static int getHashCode(byte[] value)
  {
    return Arrays.hashCode(value);
  }

  public static CDOIDObjectUUIDImpl create(byte[] value)
  {
    return INTERNER.intern(value);
  }

  public static CDOIDObjectUUIDImpl create(CDODataInput in) throws IOException
  {
    byte[] value = in.readByteArray();
    return create(value);
  }

  public static CDOIDObjectUUIDImpl create(String fragmentPart)
  {
    byte[] value = CDOIDUtil.decodeUUID(fragmentPart);
    return create(value);
  }

  /**
   * @author Eike Stepper
   */
  private static final class UUIDInterner extends Interner<CDOIDObjectUUIDImpl>
  {
    public synchronized CDOIDObjectUUIDImpl intern(byte[] value)
    {
      int hashCode = getHashCode(value);
      for (Entry<CDOIDObjectUUIDImpl> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry())
      {
        CDOIDObjectUUIDImpl id = entry.get();
        if (id != null && Arrays.equals(id.value, value))
        {
          return id;
        }
      }

      CDOIDObjectUUIDImpl id = new CDOIDObjectUUIDImpl(value);
      addEntry(createEntry(id, hashCode));
      return id;
    }

    @Override
    protected int hashCode(CDOIDObjectUUIDImpl id)
    {
      return getHashCode(id.value);
    }
  }
}
