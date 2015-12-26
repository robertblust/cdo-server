/*
 * Copyright (c) 2010-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.branch;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchChangedEvent;
import org.eclipse.emf.cdo.common.branch.CDOBranchChangedEvent.ChangeKind;
import org.eclipse.emf.cdo.common.branch.CDOBranchHandler;
import org.eclipse.emf.cdo.common.branch.CDOBranchManager;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.util.CDOTimeProvider;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranch;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager.BranchLoader.BranchInfo;

import org.eclipse.net4j.util.collection.Pair;
import org.eclipse.net4j.util.container.Container;
import org.eclipse.net4j.util.event.Event;
import org.eclipse.net4j.util.ref.ReferenceValueMap;
import org.eclipse.net4j.util.ref.ReferenceValueMap.Soft;

import java.text.MessageFormat;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOBranchManagerImpl extends Container<CDOBranch>implements InternalCDOBranchManager
{
  private CDOCommonRepository repository;

  private BranchLoader branchLoader;

  private InternalCDOBranch mainBranch;

  private Map<Integer, InternalCDOBranch> branches = createMap();

  public CDOBranchManagerImpl()
  {
  }

  public CDOCommonRepository getRepository()
  {
    return repository;
  }

  public void setRepository(CDOCommonRepository repository)
  {
    this.repository = repository;
  }

  public BranchLoader getBranchLoader()
  {
    return branchLoader;
  }

  public void setBranchLoader(BranchLoader branchLoader)
  {
    checkInactive();
    this.branchLoader = branchLoader;
  }

  public CDOTimeProvider getTimeProvider()
  {
    return repository;
  }

  @Deprecated
  public void setTimeProvider(CDOTimeProvider timeProvider)
  {
    throw new UnsupportedOperationException();
  }

  public void initMainBranch(boolean local, long timeStamp)
  {
    mainBranch = new CDOBranchImpl.Main(this, local, timeStamp);
  }

  @Deprecated
  public void handleBranchCreated(InternalCDOBranch branch)
  {
    handleBranchChanged(branch, ChangeKind.CREATED);
  }

  public void handleBranchChanged(InternalCDOBranch branch, ChangeKind changeKind)
  {
    if (changeKind == ChangeKind.CREATED)
    {
      CDOBranchPoint base = branch.getBase();
      InternalCDOBranch baseBranch = (InternalCDOBranch)base.getBranch();
      baseBranch.addChild(branch);

      fireEvent(new BranchCreatedEvent(branch));
    }
    else
    {
      fireEvent(new BranchChangedEvent(branch, changeKind));
    }
  }

  public CDOBranch[] getElements()
  {
    return new CDOBranch[] { getMainBranch() };
  }

  public InternalCDOBranch getMainBranch()
  {
    checkActive();
    return mainBranch;
  }

  public InternalCDOBranch getBranch(int branchID)
  {
    checkActive();
    if (branchID == CDOBranch.MAIN_BRANCH_ID)
    {
      return mainBranch;
    }

    if (!repository.isSupportingBranches())
    {
      return null;
    }

    InternalCDOBranch branch;
    synchronized (branches)
    {
      branch = branches.get(branchID);
      if (branch == null)
      {
        branch = new CDOBranchImpl(this, branchID, null, null);
        putBranch(branch);
      }
    }

    return branch;
  }

  public InternalCDOBranch getBranch(int id, String name, InternalCDOBranch baseBranch, long baseTimeStamp)
  {
    synchronized (branches)
    {
      InternalCDOBranch branch = branches.get(id);
      if (branch == null)
      {
        branch = new CDOBranchImpl(this, id, name, baseBranch.getPoint(baseTimeStamp));
        putBranch(branch);
      }
      else if (branch.isProxy())
      {
        branch.setBranchInfo(name, baseBranch, baseTimeStamp);
      }

      return branch;
    }
  }

  public InternalCDOBranch getBranch(int id, BranchInfo branchInfo)
  {
    String name = branchInfo.getName();
    InternalCDOBranch baseBranch = getBranch(branchInfo.getBaseBranchID());
    long baseTimeStamp = branchInfo.getBaseTimeStamp();
    return getBranch(id, name, baseBranch, baseTimeStamp);
  }

  public InternalCDOBranch getBranch(String path)
  {
    if (path.startsWith(CDOBranch.PATH_SEPARATOR))
    {
      path = path.substring(1);
    }

    int sep = path.indexOf(CDOBranch.PATH_SEPARATOR);
    if (sep == -1)
    {
      if (CDOBranch.MAIN_BRANCH_NAME.equals(path))
      {
        return mainBranch;
      }

      return null;
    }

    if (!repository.isSupportingBranches())
    {
      return null;
    }

    String name = path.substring(0, sep);
    if (CDOBranch.MAIN_BRANCH_NAME.equals(name))
    {
      String rest = path.substring(sep + 1);
      return mainBranch.getBranch(rest);
    }

    return null;
  }

  public int getBranches(int startID, int endID, CDOBranchHandler handler)
  {
    checkActive();
    if (!repository.isSupportingBranches())
    {
      if (startID <= CDOBranch.MAIN_BRANCH_ID && CDOBranch.MAIN_BRANCH_ID <= endID)
      {
        handler.handleBranch(mainBranch);
        return 1;
      }

      return 0;
    }

    return branchLoader.loadBranches(startID, endID, handler);
  }

  public InternalCDOBranch createBranch(int branchID, String name, InternalCDOBranch baseBranch, long baseTimeStamp)
  {
    checkActive();

    Pair<Integer, Long> result = branchLoader.createBranch(branchID,
        new BranchInfo(name, baseBranch.getID(), baseTimeStamp));
    branchID = result.getElement1();
    baseTimeStamp = result.getElement2();

    CDOBranchPoint base = baseBranch.getPoint(baseTimeStamp);
    InternalCDOBranch branch = new CDOBranchImpl(this, branchID, name, base);

    synchronized (branches)
    {
      putBranch(branch);
    }

    handleBranchCreated(branch);
    return branch;
  }

  @Deprecated
  public void renameBranch(CDOBranch branch, String newName)
  {
    branch.setName(newName);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("BranchManager[loader={0}]", branchLoader);
  }

  /**
   * {@link #branches} must be synchronized by caller!
   */
  private boolean putBranch(InternalCDOBranch branch)
  {
    int id = branch.getID();
    if (branches.containsKey(id))
    {
      return false;
    }

    branches.put(id, branch);
    return true;
  }

  protected Soft<Integer, InternalCDOBranch> createMap()
  {
    return new ReferenceValueMap.Soft<Integer, InternalCDOBranch>();
  }

  @Override
  protected void doBeforeActivate() throws Exception
  {
    super.doBeforeActivate();
    checkState(repository, "repository"); //$NON-NLS-1$
    checkState(branchLoader, "branchLoader"); //$NON-NLS-1$
  }

  /**
   * @author Eike Stepper
   */
  private static class BranchChangedEvent extends Event implements CDOBranchChangedEvent
  {
    private static final long serialVersionUID = 1L;

    private CDOBranch branch;

    private ChangeKind changeKind;

    public BranchChangedEvent(CDOBranch branch, ChangeKind changeKind)
    {
      super(branch.getBranchManager());
      this.branch = branch;
      this.changeKind = changeKind;
    }

    @Override
    public CDOBranchManager getSource()
    {
      return (CDOBranchManager)super.getSource();
    }

    public CDOBranch getBranch()
    {
      return branch;
    }

    public ChangeKind getChangeKind()
    {
      return changeKind;
    }
  }

  /**
   * @author Eike Stepper
   */
  @Deprecated
  private static final class BranchCreatedEvent extends BranchChangedEvent
      implements org.eclipse.emf.cdo.common.branch.CDOBranchCreatedEvent
  {
    private static final long serialVersionUID = 1L;

    public BranchCreatedEvent(CDOBranch branch)
    {
      super(branch, ChangeKind.CREATED);
    }
  }
}
