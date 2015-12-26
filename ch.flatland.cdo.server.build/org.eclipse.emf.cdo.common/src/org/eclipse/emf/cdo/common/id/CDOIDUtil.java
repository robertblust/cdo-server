/*
 * Copyright (c) 2008-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - bug 226778
 *    Simon McDuff - bug 213402
 *    Martin Taal - Added subtype handling and EClass conversion, bug 283106
 */
package org.eclipse.emf.cdo.common.id;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.id.CDOID.ObjectType;
import org.eclipse.emf.cdo.common.id.CDOID.Type;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.revision.CDOIDAndBranch;
import org.eclipse.emf.cdo.common.revision.CDOIDAndVersion;
import org.eclipse.emf.cdo.internal.common.bundle.OM;
import org.eclipse.emf.cdo.internal.common.id.CDOIDExternalImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDObjectLongImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDObjectLongWithClassifierImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDObjectStringImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDObjectStringWithClassifierImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDObjectUUIDImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDTempObjectExternalImpl;
import org.eclipse.emf.cdo.internal.common.id.CDOIDTempObjectImpl;
import org.eclipse.emf.cdo.internal.common.messages.Messages;
import org.eclipse.emf.cdo.internal.common.revision.CDOIDAndBranchImpl;
import org.eclipse.emf.cdo.internal.common.revision.CDOIDAndVersionImpl;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOID;
import org.eclipse.emf.cdo.spi.common.id.InternalCDOIDObject;

import org.eclipse.net4j.util.UUIDGenerator;
import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;
import org.eclipse.net4j.util.om.trace.ContextTracer;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Various static methods that may help with CDO {@link CDOID IDs}.
 *
 * @author Eike Stepper
 * @since 2.0
 */
public final class CDOIDUtil
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_PROTOCOL, CDOIDUtil.class);

  private CDOIDUtil()
  {
  }

  /**
   * @since 4.2
   */
  public static <V> Map<CDOID, V> createMap()
  {
    return new HashMap<CDOID, V>();
  }

  /**
   * @since 4.0
   */
  public static CDOIDAndVersion createIDAndVersion(CDOID id, int version)
  {
    return new CDOIDAndVersionImpl(id, version);
  }

  /**
   * @since 4.0
   */
  public static CDOIDAndVersion createIDAndVersion(CDOIDAndVersion source)
  {
    return createIDAndVersion(source.getID(), source.getVersion());
  }

  /**
   * @since 4.0
   */
  public static CDOIDAndBranch createIDAndBranch(CDOID id, CDOBranch branch)
  {
    return new CDOIDAndBranchImpl(id, branch);
  }

  /**
   * @since 4.2
   */
  public static CDOID getCDOID(Object object)
  {
    if (object == null)
    {
      return CDOID.NULL;
    }

    if (object instanceof CDOID)
    {
      return (CDOID)object;
    }

    if (object instanceof CDOWithID)
    {
      CDOID id = ((CDOWithID)object).cdoID();
      return id == null ? CDOID.NULL : id;
    }

    if (object instanceof CDOIdentifiable)
    {
      CDOID id = ((CDOIdentifiable)object).getID();
      return id == null ? CDOID.NULL : id;
    }

    return null;
  }

  /**
   * @since 2.0
   */
  public static boolean isNull(CDOID id)
  {
    return id == null || id.isNull();
  }

  public static long getLong(CDOID id)
  {
    if (id == null)
    {
      return 0L;
    }

    switch (id.getType())
    {
    case NULL:
      return 0L;

    case OBJECT:
      if (id instanceof CDOIDObjectLongImpl)
      {
        return ((CDOIDObjectLongImpl)id).getLongValue();
      }

      if (id instanceof CDOIDObjectLongWithClassifierImpl)
      {
        return ((CDOIDObjectLongWithClassifierImpl)id).getLongValue();
      }

      throw new IllegalArgumentException(
          MessageFormat.format(Messages.getString("CDOIDUtil.0"), id.getClass().getName())); //$NON-NLS-1$

    case TEMP_OBJECT:
      throw new IllegalArgumentException(Messages.getString("CDOIDUtil.1")); //$NON-NLS-1$

    case EXTERNAL_OBJECT:
    case EXTERNAL_TEMP_OBJECT:
      throw new IllegalArgumentException(Messages.getString("CDOIDUtil.2")); //$NON-NLS-1$

    default:
      throw new IllegalArgumentException(
          MessageFormat.format(Messages.getString("CDOIDUtil.3"), id.getClass().getName())); //$NON-NLS-1$
    }
  }

  /**
   * @since 4.0
   */
  public static String getString(CDOID id)
  {
    if (id instanceof CDOIDString)
    {
      return ((CDOIDString)id).getStringValue();
    }

    return null;
  }

  /**
   * @since 4.1
   */
  public static byte[] getByteArray(CDOID id)
  {
    if (id instanceof CDOIDObjectUUIDImpl)
    {
      return ((CDOIDObjectUUIDImpl)id).getByteArrayValue();
    }

    return null;
  }

  /**
   * @since 3.0
   */
  public static CDOClassifierRef getClassifierRef(CDOID id)
  {
    if (id instanceof CDOClassifierRef.Provider)
    {
      return ((CDOClassifierRef.Provider)id).getClassifierRef();
    }

    return null;
  }

  public static CDOIDTemp createTempObject(int value)
  {
    return CDOIDTempObjectImpl.create(value);
  }

  /**
   * @since 3.0
   */
  public static CDOIDExternal createTempObjectExternal(String uri)
  {
    return CDOIDTempObjectExternalImpl.create(uri);
  }

  public static CDOID createLong(long value)
  {
    if (value == 0L)
    {
      return CDOID.NULL;
    }

    return CDOIDObjectLongImpl.create(value);
  }

  /**
   * @since 4.2
   */
  public static CDOID createLongWithClassifier(long value, CDOClassifierRef classifierRef)
  {
    return CDOIDObjectLongWithClassifierImpl.create(value, classifierRef);
  }

  /**
   * @since 4.0
   */
  public static CDOID createString(String value)
  {
    return CDOIDObjectStringImpl.create(value);
  }

  /**
   * @since 4.2
   */
  public static CDOID createStringWithClassifier(String value, CDOClassifierRef classifierRef)
  {
    return CDOIDObjectStringWithClassifierImpl.create(value, classifierRef);
  }

  /**
   * @since 4.1
   */
  public static CDOID createUUID(byte[] value)
  {
    return CDOIDObjectUUIDImpl.create(value);
  }

  /**
   * @since 4.1
   */
  public static CDOID createUUID()
  {
    byte[] value = new byte[16];
    UUIDGenerator.DEFAULT.generate(value);
    return createUUID(value);
  }

  /**
   * @since 4.1
   */
  public static String encodeUUID(byte[] bytes)
  {
    return UUIDGenerator.DEFAULT.encode(bytes);
  }

  /**
   * @since 4.1
   */
  public static byte[] decodeUUID(String string)
  {
    return UUIDGenerator.DEFAULT.decode(string);
  }

  /**
   * @since 2.0
   */
  public static CDOIDExternal createExternal(String uri)
  {
    return CDOIDExternalImpl.create(uri);
  }

  /**
   * Format of the uri fragment.
   * <p>
   * Non-legacy: <code>&lt;ID TYPE>/&lt;CUSTOM STRING FROM OBJECT FACTORY></code>
   * <p>
   * Legacy: <code>&lt;ID TYPE>/&lt;PACKAGE URI>/&lt;CLASSIFIER ID>/&lt;CUSTOM STRING FROM OBJECT FACTORY></code>
   *
   * @since 2.0
   */
  public static void write(StringBuilder builder, CDOID id)
  {
    if (id == null)
    {
      id = CDOID.NULL;
    }

    if (id instanceof InternalCDOIDObject)
    {
      ObjectType subType = ((InternalCDOIDObject)id).getSubType();
      builder.append(subType.getID());
    }
    else
    {
      Type type = id.getType();
      builder.append(type.getID());
    }

    builder.append(id.toURIFragment());
  }

  /**
   * Format of the URI fragment.
   * <p>
   * Non-legacy: <code>&lt;ID TYPE>/&lt;CUSTOM STRING FROM OBJECT FACTORY></code>
   * <p>
   * Legacy: <code>&lt;ID TYPE>/&lt;PACKAGE URI>/&lt;CLASSIFIER ID>/&lt;CUSTOM STRING FROM OBJECT FACTORY></code>
   *
   * @since 3.0
   */
  public static CDOID read(String uriFragment)
  {
    char typeID = uriFragment.charAt(0);
    Enum<?> literal = CDOID.Type.getLiteral(typeID);
    if (literal == null)
    {
      throw new IllegalArgumentException("Unknown type ID: " + typeID);
    }

    String fragment = uriFragment.substring(1);
    if (literal instanceof ObjectType)
    {
      return readCDOIDObject(fragment, (ObjectType)literal);
    }

    Type type = (Type)literal;
    switch (type)
    {
    case NULL:
      return CDOID.NULL;

    case TEMP_OBJECT:
      return CDOIDTempObjectImpl.create(Integer.valueOf(fragment));

    case EXTERNAL_OBJECT:
      return CDOIDExternalImpl.create(fragment);

    case EXTERNAL_TEMP_OBJECT:
      return CDOIDTempObjectExternalImpl.create(fragment);

    default:
      throw new IllegalArgumentException(MessageFormat.format(Messages.getString("CDOIDUtil.5"), uriFragment)); //$NON-NLS-1$
    }
  }

  private static CDOID readCDOIDObject(String fragment, CDOID.ObjectType subType)
  {
    switch (subType)
    {
    case LONG:
      return CDOIDObjectLongImpl.create(fragment);

    case STRING:
      return CDOIDObjectStringImpl.create(fragment);

    case LONG_WITH_CLASSIFIER:
      return CDOIDObjectLongWithClassifierImpl.create(fragment);

    case STRING_WITH_CLASSIFIER:
      return CDOIDObjectStringWithClassifierImpl.create(fragment);

    case UUID:
      return CDOIDObjectUUIDImpl.create(fragment);

    default:
      throw new IllegalArgumentException("Subtype " + subType.name() + " not supported");
    }
  }

  /**
   * @since 4.2
   */
  public static void write(CDODataOutput out, CDOID id) throws IOException
  {
    if (id == null)
    {
      id = CDOID.NULL;
    }

    if (id instanceof InternalCDOIDObject)
    {
      CDOID.ObjectType subType = ((InternalCDOIDObject)id).getSubType();
      int ordinal = subType.ordinal();
      if (TRACER.isEnabled())
      {
        TRACER.format("Writing CDOIDObject of subtype {0} ({1})", ordinal, subType); //$NON-NLS-1$
      }

      // Negated to distinguish between the subtypes and the maintypes.
      // Note: Added 1 because ordinal start at 0
      out.writeByte(-ordinal - 1);
    }
    else
    {
      CDOID.Type type = id.getType();
      int ordinal = type.ordinal();
      if (TRACER.isEnabled())
      {
        TRACER.format("Writing CDOID of type {0} ({1})", ordinal, type); //$NON-NLS-1$
      }

      out.writeByte(ordinal);
    }

    ((AbstractCDOID)id).write(out);
  }

  /**
   * @since 4.2
   */
  public static CDOID read(CDODataInput in) throws IOException
  {
    byte ordinal = in.readByte();

    // A subtype of OBJECT
    if (ordinal < 0)
    {
      // The ordinal value is negated in the stream to distinguish from the main type.
      // Note: Added 1 because ordinal start at 0, so correct by minus 1.
      return readCDOIDObject(in, -ordinal - 1);
    }

    if (TRACER.isEnabled())
    {
      String type;
      try
      {
        type = Type.values()[ordinal].toString();
      }
      catch (RuntimeException ex)
      {
        type = ex.getMessage();
      }

      TRACER.format("Reading CDOID of type {0} ({1})", ordinal, type); //$NON-NLS-1$
    }

    Type type = Type.values()[ordinal];
    switch (type)
    {
    case NULL:
      return CDOID.NULL;

    case TEMP_OBJECT:
      return CDOIDTempObjectImpl.create(in.readInt());

    case EXTERNAL_OBJECT:
      return CDOIDExternalImpl.create(in.readString());

    case EXTERNAL_TEMP_OBJECT:
      return CDOIDTempObjectExternalImpl.create(in.readString());

    default:
      throw new IOException("Illegal type: " + type);
    }
  }

  private static CDOID readCDOIDObject(CDODataInput in, int subTypeOrdinal) throws IOException
  {
    if (TRACER.isEnabled())
    {
      String subType;

      try
      {
        subType = CDOID.ObjectType.values()[subTypeOrdinal].toString();
      }
      catch (RuntimeException ex)
      {
        subType = ex.getMessage();
      }

      TRACER.format("Reading CDOIDObject of subtype {0} ({1})", subTypeOrdinal, subType); //$NON-NLS-1$
    }

    CDOID.ObjectType subType = CDOID.ObjectType.values()[subTypeOrdinal];
    if (subType == null)
    {
      throw new IllegalArgumentException("Subtype may not be null");
    }

    switch (subType)
    {
    case LONG:
      return CDOIDObjectLongImpl.create(in);

    case STRING:
      return CDOIDObjectStringImpl.create(in);

    case LONG_WITH_CLASSIFIER:
      return CDOIDObjectLongWithClassifierImpl.create(in);

    case STRING_WITH_CLASSIFIER:
      return CDOIDObjectStringWithClassifierImpl.create(in);

    case UUID:
      return CDOIDObjectUUIDImpl.create(in);

    default:
      throw new IllegalArgumentException("Subtype " + subType.name() + " not supported");
    }
  }

  /**
   * @since 2.0
   */
  public static boolean equals(CDOID id1, CDOID id2)
  {
    if (id1 == id2)
    {
      return true;
    }

    if (id1 == null)
    {
      return id2 == CDOID.NULL;
    }

    if (id2 == null)
    {
      return id1 == CDOID.NULL;
    }

    return false;
  }

  /**
   * @since 3.0
   * @deprecated As of 4.2 use {@link #createLongWithClassifier(long, CDOClassifierRef)}.
   */
  @Deprecated
  public static CDOID createLongWithClassifier(CDOClassifierRef classifierRef, long value)
  {
    return createLongWithClassifier(value, classifierRef);
  }

  /**
   * @since 3.0
   * @deprecated As of 4.2 use {@link #createStringWithClassifier(String, CDOClassifierRef)}.
   */
  @Deprecated
  public static CDOID createStringWithClassifier(CDOClassifierRef classifierRef, String value)
  {
    return createStringWithClassifier(value, classifierRef);
  }

  /**
   * Creates the correct implementation class for the passed {@link CDOID.ObjectType}.
   *
   * @param subType
   *          the subType for which to create an empty CDOID instance
   * @return the instance of CDOIDObject which represents the subtype.
   * @since 3.0
   * @deprecated As of 4.2 no longer supported. IDs can't be created without a value anymore.
   */
  @Deprecated
  public static AbstractCDOID createCDOIDObject(CDOID.ObjectType subType)
  {
    throw new UnsupportedOperationException();
  }

  /**
   * @since 4.1
   * @deprecated As of 4.2 use {@link #write(CDODataOutput, CDOID)}.
   */
  @Deprecated
  public static void write(ExtendedDataOutput out, CDOID id) throws IOException
  {
    write((CDODataOutput)out, id);
  }

  /**
   * @since 4.1
   * @deprecated As of 4.2 use {@link #read(CDODataInput)}.
   */
  @Deprecated
  public static CDOID read(ExtendedDataInput in) throws IOException
  {
    return read((CDODataInput)in);
  }
}
