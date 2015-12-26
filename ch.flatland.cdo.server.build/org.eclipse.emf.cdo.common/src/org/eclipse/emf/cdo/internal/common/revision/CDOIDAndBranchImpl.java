/*
 * Copyright (c) 2011-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.revision;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchManager;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDOIDAndBranch;
import org.eclipse.emf.cdo.spi.common.branch.CDOBranchAdjustable;

import org.eclipse.net4j.util.CheckUtil;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class CDOIDAndBranchImpl implements CDOIDAndBranch, CDOBranchAdjustable
{
  private CDOID id;

  private CDOBranch branch;

  public CDOIDAndBranchImpl(CDOID id, CDOBranch branch)
  {
    CheckUtil.checkArg(id, "id");
    CheckUtil.checkArg(branch, "branch");

    this.id = id;
    this.branch = branch;
  }

  public CDOID getID()
  {
    return id;
  }

  public CDOBranch getBranch()
  {
    return branch;
  }

  public void adjustBranches(CDOBranchManager newBranchManager)
  {
    branch = newBranchManager.getBranch(branch.getID());
    CheckUtil.checkArg(branch, "branch");
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof CDOIDAndBranch)
    {
      CDOIDAndBranch that = (CDOIDAndBranch)obj;
      return branch == that.getBranch() && id == that.getID();
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return id.hashCode() ^ branch.hashCode();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}:{1}", id, branch.getID()); //$NON-NLS-1$
  }
}
