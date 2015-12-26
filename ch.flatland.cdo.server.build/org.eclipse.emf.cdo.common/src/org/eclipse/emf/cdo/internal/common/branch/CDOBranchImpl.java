/*
 * Copyright (c) 2010-2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Erdal Karaca - bug 414270: check if repository supports branching when querying sub branches
 */
package org.eclipse.emf.cdo.internal.common.branch;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchChangedEvent.ChangeKind;
import org.eclipse.emf.cdo.common.branch.CDOBranchCreationContext;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranch;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager.BranchLoader;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager.BranchLoader.BranchInfo;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager.BranchLoader.SubBranchInfo;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager.BranchLoader3;

import org.eclipse.net4j.util.AdapterUtil;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.container.Container;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOBranchImpl extends Container<CDOBranch>implements InternalCDOBranch
{
  private static final InternalCDOBranch[] NO_BRANCHES = new InternalCDOBranch[0];

  private InternalCDOBranchManager branchManager;

  private int id;

  private String name;

  private CDOBranchPoint base;

  private CDOBranchPoint head = getPoint(CDOBranchPoint.UNSPECIFIED_DATE);

  private InternalCDOBranch[] branches;

  public CDOBranchImpl(InternalCDOBranchManager branchManager, int id, String name, CDOBranchPoint base)
  {
    this.branchManager = branchManager;
    this.id = id;
    this.name = name;
    this.base = base;
    activate();
  }

  public boolean isMainBranch()
  {
    return false;
  }

  public boolean isLocal()
  {
    return id < 0;
  }

  public InternalCDOBranchManager getBranchManager()
  {
    return branchManager;
  }

  public int getID()
  {
    return id;
  }

  public synchronized String getName()
  {
    if (name == null)
    {
      load();
    }

    return name;
  }

  public void setName(String name)
  {
    checkActive();
    if (isMainBranch())
    {
      throw new IllegalArgumentException("Renaming of the MAIN branch is not supported");
    }

    BranchLoader branchLoader = branchManager.getBranchLoader();
    if (!(branchLoader instanceof BranchLoader3))
    {
      throw new UnsupportedOperationException("Renaming of branches is not supported by " + branchLoader);
    }

    String oldName = getName();
    if (!ObjectUtil.equals(name, oldName))
    {
      ((BranchLoader3)branchLoader).renameBranch(id, oldName, name);
      basicSetName(name);
    }
  }

  public void basicSetName(String name)
  {
    this.name = name;
    branchManager.handleBranchChanged(this, ChangeKind.RENAMED);
  }

  public CDOBranch getBranch()
  {
    return base.getBranch();
  }

  public long getTimeStamp()
  {
    return base.getTimeStamp();
  }

  public boolean isProxy()
  {
    return name == null || base == null;
  }

  public String getPathName()
  {
    StringBuilder builder = new StringBuilder();
    computePathName(this, builder);
    return builder.toString();
  }

  private void computePathName(CDOBranch branch, StringBuilder builder)
  {
    CDOBranchPoint base = branch.getBase();
    CDOBranch parent = base.getBranch();
    if (parent != null)
    {
      computePathName(parent, builder);
      builder.append(PATH_SEPARATOR);
    }

    builder.append(branch.getName());
  }

  public CDOBranchPoint[] getBasePath()
  {
    List<CDOBranchPoint> path = new ArrayList<CDOBranchPoint>();
    computeBasePath(this, path);
    return path.toArray(new CDOBranchPoint[path.size()]);
  }

  private void computeBasePath(CDOBranch branch, List<CDOBranchPoint> path)
  {
    CDOBranchPoint base = branch.getBase();
    CDOBranch parent = base.getBranch();
    if (parent != null)
    {
      computeBasePath(parent, path);
    }

    path.add(base);
  }

  public synchronized CDOBranchPoint getBase()
  {
    if (base == null)
    {
      load();
    }

    return base;
  }

  public CDOBranchPoint getHead()
  {
    return head;
  }

  public CDOBranchPoint getPoint(long timeStamp)
  {
    return new CDOBranchPointImpl(this, timeStamp);
  }

  public CDOBranchVersion getVersion(int version)
  {
    return new CDOBranchVersionImpl(this, version);
  }

  public InternalCDOBranch createBranch(String name, long timeStamp)
  {
    if (!branchManager.getRepository().isSupportingBranches())
    {
      throw new IllegalStateException("Branching is not supported");
    }

    return branchManager.createBranch(BranchLoader.NEW_BRANCH, name, this, timeStamp);
  }

  public InternalCDOBranch createBranch(String name)
  {
    return createBranch(name, CDOBranchPoint.UNSPECIFIED_DATE);
  }

  public InternalCDOBranch[] getElements()
  {
    return getBranches();
  }

  public InternalCDOBranch[] getBranches(boolean loadOnDemand)
  {
    if (!branchManager.getRepository().isSupportingBranches())
    {
      return NO_BRANCHES;
    }

    if (branches == null && loadOnDemand)
    {
      loadBranches();
    }

    return branches;
  }

  public synchronized InternalCDOBranch[] getBranches()
  {
    return getBranches(true);
  }

  public InternalCDOBranch getBranch(String path)
  {
    if (!branchManager.getRepository().isSupportingBranches())
    {
      return null;
    }

    while (path.startsWith(PATH_SEPARATOR))
    {
      path = path.substring(1);
    }

    while (path.endsWith(PATH_SEPARATOR))
    {
      path = path.substring(0, path.length() - PATH_SEPARATOR.length());
    }

    int sep = path.indexOf(PATH_SEPARATOR);
    if (sep == -1)
    {
      return getChild(path);
    }

    String name = path.substring(0, sep);
    InternalCDOBranch child = getChild(name);
    if (child == null)
    {
      return null;
    }

    // Recurse
    String rest = path.substring(sep + 1);
    return child.getBranch(rest);
  }

  @Deprecated
  public void rename(String newName)
  {
    setName(newName);
  }

  private InternalCDOBranch getChild(String name)
  {
    InternalCDOBranch[] branches = getBranches();
    for (InternalCDOBranch branch : branches)
    {
      if (name.equals(branch.getName()))
      {
        return branch;
      }
    }

    return null;
  }

  public BranchInfo getBranchInfo()
  {
    CDOBranchPoint base = getBase();
    return new BranchInfo(getName(), base.getBranch().getID(), base.getTimeStamp());
  }

  public void setBranchInfo(String name, InternalCDOBranch baseBranch, long baseTimeStamp)
  {
    this.name = name;
    base = baseBranch.getPoint(baseTimeStamp);
  }

  public void addChild(InternalCDOBranch branch)
  {
    synchronized (this)
    {
      if (branches == null)
      {
        loadBranches();
      }
      else
      {
        InternalCDOBranch[] newBranches = new InternalCDOBranch[branches.length + 1];
        System.arraycopy(branches, 0, newBranches, 0, branches.length);
        newBranches[branches.length] = branch;
        branches = newBranches;
      }
    }

    fireElementAddedEvent(branch);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Object getAdapter(Class adapter)
  {
    if (adapter == CDOBranchCreationContext.class)
    {
      CDOCommonRepository repository = branchManager.getRepository();
      if (repository.isSupportingBranches())
      {
        return new CDOBranchCreationContext()
        {
          public CDOBranchPoint getBase()
          {
            return getHead();
          }
        };
      }
    }

    return AdapterUtil.adapt(this, adapter, false);
  }

  public int compareTo(CDOBranch o)
  {
    int otherID = o.getID();
    return id < otherID ? -1 : id == otherID ? 0 : 1;
  }

  @Override
  public int hashCode()
  {
    return id;
  }

  @Override
  public boolean equals(Object obj)
  {
    return obj == this;
  }

  @Override
  public String toString()
  {
    if (isProxy())
    {
      return MessageFormat.format("Branch[id={0}, PROXY]", id); //$NON-NLS-1$
    }

    return MessageFormat.format("Branch[id={0}, name={1}]", id, name); //$NON-NLS-1$
  }

  private synchronized void load()
  {
    BranchInfo branchInfo = branchManager.getBranchLoader().loadBranch(id);
    CDOBranch baseBranch = branchManager.getBranch(branchInfo.getBaseBranchID());

    name = branchInfo.getName();
    base = baseBranch.getPoint(branchInfo.getBaseTimeStamp());
  }

  private synchronized void loadBranches()
  {
    SubBranchInfo[] infos = branchManager.getBranchLoader().loadSubBranches(id);
    branches = new InternalCDOBranch[infos.length];
    for (int i = 0; i < infos.length; i++)
    {
      SubBranchInfo info = infos[i];
      branches[i] = branchManager.getBranch(info.getID(), info.getName(), this, info.getBaseTimeStamp());
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class Main extends CDOBranchImpl
  {
    private boolean local;

    public Main(InternalCDOBranchManager branchManager, boolean local, long timeStamp)
    {
      super(branchManager, MAIN_BRANCH_ID, MAIN_BRANCH_NAME, new CDOBranchPointImpl(null, timeStamp));
      this.local = local;
    }

    @Override
    public boolean isMainBranch()
    {
      return true;
    }

    @Override
    public boolean isLocal()
    {
      return local;
    }
  }
}
