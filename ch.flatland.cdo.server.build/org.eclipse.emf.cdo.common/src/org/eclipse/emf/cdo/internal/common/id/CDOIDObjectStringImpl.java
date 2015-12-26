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
import org.eclipse.emf.cdo.common.id.CDOIDString;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOID;
import org.eclipse.emf.cdo.spi.common.id.InternalCDOIDObject;

import org.eclipse.net4j.util.CheckUtil;
import org.eclipse.net4j.util.ref.Interner;

import java.io.IOException;
import java.io.ObjectStreamException;

/**
 * @author Eike Stepper
 * @since 2.0
 */
public final class CDOIDObjectStringImpl extends AbstractCDOID implements InternalCDOIDObject, CDOIDString
{
  private static final long serialVersionUID = 1L;

  private static final StringInterner INTERNER = new StringInterner();

  private final String value;

  private CDOIDObjectStringImpl(String value)
  {
    CheckUtil.checkArg(value, "Null not allowed");
    this.value = value;
  }

  /**
   * A private default constructor for technologies (such as Hessian) that initialize the instance fields via reflection.
   * Note that {@link #readResolve()} must be called in any case to ensure value uniqueness.
   */
  private CDOIDObjectStringImpl()
  {
    value = null;
  }

  @Override
  public void write(CDODataOutput out) throws IOException
  {
    out.writeString(value);
  }

  public String toURIFragment()
  {
    return value;
  }

  public String getStringValue()
  {
    return value;
  }

  public Type getType()
  {
    return Type.OBJECT;
  }

  public CDOID.ObjectType getSubType()
  {
    return CDOID.ObjectType.STRING;
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
    return value.hashCode();
  }

  @Override
  public String toString()
  {
    return "OID" + value; //$NON-NLS-1$
  }

  @Override
  protected int doCompareTo(CDOID o) throws ClassCastException
  {
    return value.compareTo(((CDOIDObjectStringImpl)o).value);
  }

  private Object readResolve() throws ObjectStreamException
  {
    return create(value);
  }

  private static int getHashCode(String value)
  {
    return value.hashCode();
  }

  public static CDOIDObjectStringImpl create(String value)
  {
    return INTERNER.intern(value);
  }

  public static CDOIDObjectStringImpl create(CDODataInput in) throws IOException
  {
    String value = in.readString();
    return create(value);
  }

  /**
   * @author Eike Stepper
   */
  private static final class StringInterner extends Interner<CDOIDObjectStringImpl>
  {
    public synchronized CDOIDObjectStringImpl intern(String value)
    {
      int hashCode = getHashCode(value);
      for (Entry<CDOIDObjectStringImpl> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry())
      {
        CDOIDObjectStringImpl id = entry.get();
        if (id != null && id.value.equals(value))
        {
          return id;
        }
      }

      CDOIDObjectStringImpl id = new CDOIDObjectStringImpl(value);
      addEntry(createEntry(id, hashCode));
      return id;
    }

    @Override
    protected int hashCode(CDOIDObjectStringImpl id)
    {
      return getHashCode(id.value);
    }
  }
}
