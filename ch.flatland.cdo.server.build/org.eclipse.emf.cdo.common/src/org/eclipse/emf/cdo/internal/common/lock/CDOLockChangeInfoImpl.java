/*
 * Copyright (c) 2011, 2012, 2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Caspar De Groot - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.lock;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchManager;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.lock.CDOLockChangeInfo;
import org.eclipse.emf.cdo.common.lock.CDOLockOwner;
import org.eclipse.emf.cdo.common.lock.CDOLockState;
import org.eclipse.emf.cdo.spi.common.branch.CDOBranchAdjustable;

import org.eclipse.net4j.util.concurrent.IRWLockManager.LockType;

/**
 * @author Caspar De Groot
 */
public class CDOLockChangeInfoImpl implements CDOLockChangeInfo, CDOBranchAdjustable
{
  private CDOBranchPoint branchPoint;

  private final CDOLockOwner lockOwner;

  private final CDOLockState[] lockStates;

  private final Operation operation;

  private final LockType lockType;

  private final boolean isInvalidateAll;

  public CDOLockChangeInfoImpl(CDOBranchPoint branchPoint, CDOLockOwner lockOwner, CDOLockState[] lockStates,
      Operation operation, LockType lockType)
  {
    this.branchPoint = branchPoint;
    this.lockOwner = lockOwner;
    this.lockStates = lockStates;
    this.operation = operation;
    this.lockType = lockType;
    isInvalidateAll = false;
  }

  public CDOLockChangeInfoImpl()
  {
    lockOwner = null;
    lockStates = null;
    operation = null;
    lockType = null;
    isInvalidateAll = true;
  }

  public void adjustBranches(CDOBranchManager newBranchManager)
  {
    if (branchPoint != null)
    {
      CDOBranch branch = branchPoint.getBranch();
      if (branch != null)
      {
        branch = newBranchManager.getBranch(branch.getID());
        branchPoint = branch.getPoint(branchPoint.getTimeStamp());
      }
    }
  }

  public CDOBranch getBranch()
  {
    return branchPoint == null ? null : branchPoint.getBranch();
  }

  public long getTimeStamp()
  {
    return branchPoint == null ? CDOBranchPoint.UNSPECIFIED_DATE : branchPoint.getTimeStamp();
  }

  public CDOLockOwner getLockOwner()
  {
    return lockOwner;
  }

  public CDOLockState[] getLockStates()
  {
    return lockStates;
  }

  public Operation getOperation()
  {
    return operation;
  }

  public LockType getLockType()
  {
    return lockType;
  }

  public boolean isInvalidateAll()
  {
    return isInvalidateAll;
  }
}
