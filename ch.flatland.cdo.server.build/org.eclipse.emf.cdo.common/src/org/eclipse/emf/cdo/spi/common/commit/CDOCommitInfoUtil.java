/*
 * Copyright (c) 2010-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.commit;

import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.commit.CDOChangeSetData;
import org.eclipse.emf.cdo.common.commit.CDOCommitData;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOPackageUnit;
import org.eclipse.emf.cdo.common.revision.CDOIDAndVersion;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.internal.common.commit.CDOCommitDataImpl;
import org.eclipse.emf.cdo.internal.common.commit.CDOCommitInfoManagerImpl;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.List;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 3.0
 */
public final class CDOCommitInfoUtil
{
  private CDOCommitInfoUtil()
  {
  }

  /**
   * @since 4.2
   */
  public static InternalCDOCommitInfoManager createCommitInfoManager(boolean caching)
  {
    return new CDOCommitInfoManagerImpl(caching);
  }

  public static InternalCDOCommitInfoManager createCommitInfoManager()
  {
    return createCommitInfoManager(false);
  }

  /**
   * @since 4.2
   */
  public static CDOCommitData createCommitData(List<CDOPackageUnit> newPackageUnits, List<CDOIDAndVersion> newObjects,
      List<CDORevisionKey> changedObjects, List<CDOIDAndVersion> detachedObjects)
  {
    return new CDOCommitDataImpl(newPackageUnits, newObjects, changedObjects, detachedObjects);
  }

  /**
   * @since 4.2
   */
  public static long encodeCount(int count)
  {
    long timeStamp = count;
    if (count < 0)
    {
      timeStamp = -timeStamp + Integer.MAX_VALUE;
    }

    return -timeStamp;
  }

  /**
   * @since 4.2
   */
  public static int decodeCount(long timeStamp)
  {
    if (timeStamp < CDOBranchPoint.UNSPECIFIED_DATE)
    {
      timeStamp = -timeStamp;
      if (timeStamp > Integer.MAX_VALUE)
      {
        return (int)(Integer.MAX_VALUE - timeStamp);
      }

      return (int)timeStamp;
    }

    return Integer.MAX_VALUE;
  }

  /**
   * @since 4.0
   */
  public static void dump(PrintStream out, CDOChangeSetData changeSetData)
  {
    for (CDOIDAndVersion key : changeSetData.getNewObjects())
    {
      out.println("  + " + key);
      if (key instanceof InternalCDORevision)
      {
        InternalCDORevision revision = (InternalCDORevision)key;
        for (EStructuralFeature feature : revision.getClassInfo().getAllPersistentFeatures())
        {
          Object value = revision.getValue(feature);
          dumpFeature(out, feature, value);
        }
      }
    }

    for (CDORevisionKey key : changeSetData.getChangedObjects())
    {
      CDORevisionDelta delta = (CDORevisionDelta)key;

      String name = delta.getEClass().getName();
      CDOID id = delta.getID();
      int branch = delta.getBranch().getID();
      int version = delta.getVersion();

      out.println(MessageFormat.format("  * {0}@{1}:{2}v{3}", name, id, branch, version));
      dumpFeatureDeltas(out, delta.getFeatureDeltas());
    }

    for (CDOIDAndVersion key : changeSetData.getDetachedObjects())
    {
      out.println("  - " + key);
    }
  }

  private static void dumpFeatureDeltas(PrintStream out, List<CDOFeatureDelta> featureDeltas)
  {
    for (CDOFeatureDelta featureDelta : featureDeltas)
    {
      if (featureDelta instanceof CDOListFeatureDelta)
      {
        CDOListFeatureDelta list = (CDOListFeatureDelta)featureDelta;
        dumpFeatureDeltas(out, list.getListChanges());
      }
      else
      {
        dumpFeature(out, featureDelta.getFeature(), featureDelta);
      }
    }
  }

  private static void dumpFeature(PrintStream out, EStructuralFeature feature, Object value)
  {
    out.println("    " + feature.getName() + " = " + value);
  }
}
