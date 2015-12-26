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
package org.eclipse.emf.cdo.internal.common.commit;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.commit.CDOChangeKind;
import org.eclipse.emf.cdo.common.commit.CDOChangeSetData;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoManager;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOPackageUnit;
import org.eclipse.emf.cdo.common.revision.CDOIDAndVersion;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;

import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class DelegatingCommitInfo implements CDOCommitInfo
{
  public DelegatingCommitInfo()
  {
  }

  protected abstract CDOCommitInfo getDelegate();

  public CDOBranch getBranch()
  {
    return getDelegate().getBranch();
  }

  public CDOCommitInfoManager getCommitInfoManager()
  {
    return getDelegate().getCommitInfoManager();
  }

  public long getPreviousTimeStamp()
  {
    return getDelegate().getPreviousTimeStamp();
  }

  public long getTimeStamp()
  {
    return getDelegate().getTimeStamp();
  }

  public String getUserID()
  {
    return getDelegate().getUserID();
  }

  public String getComment()
  {
    return getDelegate().getComment();
  }

  public boolean isEmpty()
  {
    return getDelegate().isEmpty();
  }

  public boolean isInitialCommit()
  {
    return getDelegate().isInitialCommit();
  }

  public boolean isCommitDataLoaded()
  {
    return getDelegate().isCommitDataLoaded();
  }

  public List<CDOPackageUnit> getNewPackageUnits()
  {
    return getDelegate().getNewPackageUnits();
  }

  public List<CDOIDAndVersion> getNewObjects()
  {
    return getDelegate().getNewObjects();
  }

  public List<CDORevisionKey> getChangedObjects()
  {
    return getDelegate().getChangedObjects();
  }

  public List<CDOIDAndVersion> getDetachedObjects()
  {
    return getDelegate().getDetachedObjects();
  }

  public Map<CDOID, CDOChangeKind> getChangeKinds()
  {
    return getDelegate().getChangeKinds();
  }

  public CDOChangeKind getChangeKind(CDOID id)
  {
    return getDelegate().getChangeKind(id);
  }

  public CDOChangeSetData copy()
  {
    return getDelegate().copy();
  }

  public void merge(CDOChangeSetData changeSetData)
  {
    getDelegate().merge(changeSetData);
  }

  @Override
  public String toString()
  {
    return getDelegate().toString();
  }
}
