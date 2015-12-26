/*
 * Copyright (c) 2009-2013, 2015 Eike Stepper (Berlin, Germany) and others.
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
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
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
 * @author Martin Taal
 * @since 3.0
 */
public final class CDOIDObjectLongWithClassifierImpl extends AbstractCDOID
    implements InternalCDOIDObject, CDOClassifierRef.Provider
{
  private static final long serialVersionUID = 1L;

  private static final LongWithClassifierInterner INTERNER = new LongWithClassifierInterner();

  private final long value;

  private final CDOClassifierRef classifierRef;

  private CDOIDObjectLongWithClassifierImpl(long value, CDOClassifierRef classifierRef)
  {
    CheckUtil.checkArg(value != 0L, "Zero not allowed");
    this.value = value;
    this.classifierRef = classifierRef;
  }

  /**
   * A private default constructor for technologies (such as Hessian) that initialize the instance fields via reflection.
   * Note that {@link #readResolve()} must be called in any case to ensure value uniqueness.
   */
  private CDOIDObjectLongWithClassifierImpl()
  {
    value = 0L;
    classifierRef = null;
  }

  public long getLongValue()
  {
    return value;
  }

  public CDOClassifierRef getClassifierRef()
  {
    return classifierRef;
  }

  @Override
  public void write(CDODataOutput out) throws IOException
  {
    out.writeLong(value);
    out.writeCDOClassifierRef(classifierRef);
  }

  public String toURIFragment()
  {
    return classifierRef.getPackageURI() + CDOClassifierRef.URI_SEPARATOR + classifierRef.getClassifierName()
    + CDOClassifierRef.URI_SEPARATOR + value;
  }

  public Type getType()
  {
    return Type.OBJECT;
  }

  public CDOID.ObjectType getSubType()
  {
    return CDOID.ObjectType.LONG_WITH_CLASSIFIER;
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
    return getHashCode(value, classifierRef);
  }

  @Override
  public String toString()
  {
    return "OID:" + toURIFragment(); //$NON-NLS-1$
  }

  @Override
  protected int doCompareTo(CDOID o) throws ClassCastException
  {
    return toURIFragment().compareTo(o.toURIFragment());
  }

  private Object readResolve() throws ObjectStreamException
  {
    return create(value, classifierRef);
  }

  private static int getHashCode(long value, CDOClassifierRef classifierRef)
  {
    return ObjectUtil.hashCode(value) ^ classifierRef.hashCode();
  }

  public static CDOIDObjectLongWithClassifierImpl create(long value, CDOClassifierRef classifierRef)
  {
    return INTERNER.intern(value, classifierRef);
  }

  public static CDOIDObjectLongWithClassifierImpl create(CDODataInput in) throws IOException
  {
    long value = in.readLong();
    CDOClassifierRef classifierRef = in.readCDOClassifierRef();
    return create(value, classifierRef);
  }

  public static CDOIDObjectLongWithClassifierImpl create(String fragmentPart)
  {
    int index1 = fragmentPart.indexOf(CDOClassifierRef.URI_SEPARATOR);
    int index2 = fragmentPart.indexOf(CDOClassifierRef.URI_SEPARATOR, index1 + 1);
    if (index1 == -1 || index2 == -1)
    {
      throw new IllegalArgumentException("The fragment " + fragmentPart + " is not a valid fragment");
    }

    String packageURI = fragmentPart.substring(0, index1);
    String classifierName = fragmentPart.substring(index1 + 1, index2);
    CDOClassifierRef classifierRef = new CDOClassifierRef(packageURI, classifierName);

    long value = Long.parseLong(fragmentPart.substring(index2 + 1));
    return create(value, classifierRef);
  }

  /**
   * @author Eike Stepper
   */
  private static final class LongWithClassifierInterner extends Interner<CDOIDObjectLongWithClassifierImpl>
  {
    public synchronized CDOIDObjectLongWithClassifierImpl intern(long value, CDOClassifierRef classifierRef)
    {
      int hashCode = getHashCode(value, classifierRef);
      for (Entry<CDOIDObjectLongWithClassifierImpl> entry = getEntry(hashCode); entry != null; entry = entry
          .getNextEntry())
      {
        CDOIDObjectLongWithClassifierImpl id = entry.get();
        if (id != null && id.value == value && id.classifierRef.equals(classifierRef))
        {
          return id;
        }
      }

      CDOIDObjectLongWithClassifierImpl id = new CDOIDObjectLongWithClassifierImpl(value, classifierRef);
      addEntry(createEntry(id, hashCode));
      return id;
    }

    @Override
    protected int hashCode(CDOIDObjectLongWithClassifierImpl id)
    {
      return getHashCode(id.value, id.classifierRef);
    }
  }
}
