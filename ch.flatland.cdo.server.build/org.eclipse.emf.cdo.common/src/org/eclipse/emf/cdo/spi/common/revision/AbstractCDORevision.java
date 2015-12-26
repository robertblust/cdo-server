/*
 * Copyright (c) 2009-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - bug 201266
 *    Simon McDuff - bug 212958
 *    Simon McDuff - bug 213402
 */
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOModelUtil;
import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.CDORevisionData;
import org.eclipse.emf.cdo.common.revision.CDORevisionValueVisitor;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.util.CDOCommonUtil;
import org.eclipse.emf.cdo.internal.common.messages.Messages;
import org.eclipse.emf.cdo.spi.common.model.InternalCDOClassInfo;

import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.Predicate;
import org.eclipse.net4j.util.Predicates;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.text.MessageFormat;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 2.0
 */
public abstract class AbstractCDORevision implements InternalCDORevision
{
  private InternalCDOClassInfo classInfo;

  /**
   * @since 3.0
   */
  protected AbstractCDORevision(EClass eClass)
  {
    if (eClass != null)
    {
      if (eClass.isAbstract())
      {
        throw new IllegalArgumentException(MessageFormat.format(Messages.getString("AbstractCDORevision.0"), eClass)); //$NON-NLS-1$
      }

      initClassInfo(eClass);
    }
  }

  /**
   * @since 4.2
   */
  protected AbstractCDORevision(InternalCDOClassInfo classInfo)
  {
    this.classInfo = classInfo;
  }

  /**
   * @since 4.2
   */
  public final InternalCDOClassInfo getClassInfo()
  {
    return classInfo;
  }

  public final EClass getEClass()
  {
    if (classInfo != null)
    {
      return classInfo.getEClass();
    }

    return null;
  }

  /**
   * @since 4.2
   */
  public InternalCDORevision getRevisionForID(CDOID id)
  {
    if (id != null && id.equals(getID()))
    {
      throw new ImplementationError(); // XXX Remove me!
    }

    return classInfo.getRevisionForID(id);
  }

  /**
   * @since 4.2
   */
  public InternalCDORevision getProperRevision()
  {
    return this;
  }

  public boolean isResourceNode()
  {
    return classInfo.isResourceNode();
  }

  public boolean isResourceFolder()
  {
    return classInfo.isResourceFolder();
  }

  public boolean isResource()
  {
    return classInfo.isResource();
  }

  public CDORevisionData data()
  {
    return this;
  }

  public CDORevision revision()
  {
    return this;
  }

  /**
   * @since 3.0
   */
  public boolean isHistorical()
  {
    return getRevised() != UNSPECIFIED_DATE;
  }

  public boolean isValid(long timeStamp)
  {
    long startTime = getTimeStamp();
    long endTime = getRevised();
    return CDOCommonUtil.isValidTimeStamp(timeStamp, startTime, endTime);
  }

  /**
   * @since 4.0
   */
  public boolean isValid(CDOBranchPoint branchPoint)
  {
    return getBranch() == branchPoint.getBranch() && isValid(branchPoint.getTimeStamp());
  }

  /**
   * @since 4.1
   */
  public boolean isReadable()
  {
    return getPermission().isReadable();
  }

  /**
   * @since 4.1
   */
  public boolean isWritable()
  {
    return getPermission().isWritable();
  }

  /**
   * @since 4.2
   */
  public void accept(CDORevisionValueVisitor visitor)
  {
    accept(visitor, Predicates.<EStructuralFeature> alwaysTrue());
  }

  /**
   * @since 4.2
   */
  public void accept(CDORevisionValueVisitor visitor, Predicate<EStructuralFeature> filter)
  {
    for (EStructuralFeature feature : classInfo.getAllPersistentFeatures())
    {
      if (filter.apply(feature))
      {
        if (feature.isMany())
        {
          int index = 0;
          CDOList list = getList(feature);
          for (Object value : list)
          {
            visitor.visit(feature, value, index++);
          }
        }
        else
        {
          Object value = getValue(feature);
          visitor.visit(feature, value, CDOFeatureDelta.NO_INDEX);
        }
      }
    }
  }

  /**
   * @since 3.0
   */
  public void adjustForCommit(CDOBranch branch, long timeStamp)
  {
    if (branch == getBranch())
    {
      // Same branch, increase version
      setVersion(getVersion() + 1);
    }
    else
    {
      // Different branch, start with v1
      setVersion(FIRST_VERSION);
    }

    setBranchPoint(branch.getPoint(timeStamp));
    setRevised(UNSPECIFIED_DATE);
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(getID()) ^ ObjectUtil.hashCode(getBranch()) ^ getVersion();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof CDORevision)
    {
      CDORevision that = (CDORevision)obj;
      return getID() == that.getID() && getVersion() == that.getVersion() && getBranch() == that.getBranch();
    }

    return false;
  }

  @Override
  public String toString()
  {
    EClass eClass = getEClass();
    String name = eClass == null ? "Revision" : eClass.getName();

    String string = name + "@" + getID();

    CDOBranch branch = getBranch();
    if (branch != null)
    {
      string += ":" + branch.getID();
    }

    string += "v" + getVersion();

    if (isResourceNode())
    {
      String resourceNodeName = getResourceNodeName();
      if (resourceNodeName == null)
      {
        resourceNodeName = "/";
      }

      string += "(\"" + resourceNodeName + "\")";
    }

    return string;
  }

  /**
   * @since 4.2
   */
  protected void initClassInfo(EClass eClass)
  {
    classInfo = (InternalCDOClassInfo)CDOModelUtil.getClassInfo(eClass);
  }

  /**
   * @since 3.0
   */
  protected EStructuralFeature[] getAllPersistentFeatures()
  {
    return classInfo.getAllPersistentFeatures();
  }

  /**
   * @since 3.0
   */
  protected int getFeatureIndex(EStructuralFeature feature)
  {
    return classInfo.getPersistentFeatureIndex(feature);
  }
}
