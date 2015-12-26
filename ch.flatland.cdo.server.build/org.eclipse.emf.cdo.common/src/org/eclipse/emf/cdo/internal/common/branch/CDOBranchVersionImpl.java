/*
 * Copyright (c) 2010-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.branch;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchManager;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.spi.common.branch.CDOBranchAdjustable;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class CDOBranchVersionImpl implements CDOBranchVersion, CDOBranchAdjustable
{
  private CDOBranch branch;

  private int version;

  public CDOBranchVersionImpl(CDOBranch branch, int version)
  {
    this.branch = branch;
    this.version = version;
  }

  public void adjustBranches(CDOBranchManager newBranchManager)
  {
    if (branch != null)
    {
      branch = newBranchManager.getBranch(branch.getID());
    }
  }

  public CDOBranch getBranch()
  {
    return branch;
  }

  public int getVersion()
  {
    return version;
  }

  @Override
  public int hashCode()
  {
    return branch.hashCode() ^ version;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof CDOBranchVersion)
    {
      CDOBranchVersion that = (CDOBranchVersion)obj;
      return branch == that.getBranch() && version == that.getVersion();
    }

    return false;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("BranchVersion[{0}, v{1}]", branch, version); //$NON-NLS-1$
  }
}
