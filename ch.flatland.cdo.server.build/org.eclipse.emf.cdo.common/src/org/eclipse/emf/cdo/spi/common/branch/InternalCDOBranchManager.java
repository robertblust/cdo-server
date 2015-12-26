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
package org.eclipse.emf.cdo.spi.common.branch;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchChangedEvent.ChangeKind;
import org.eclipse.emf.cdo.common.branch.CDOBranchHandler;
import org.eclipse.emf.cdo.common.branch.CDOBranchManager;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.util.CDOTimeProvider;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranchManager.BranchLoader.BranchInfo;

import org.eclipse.net4j.util.collection.Pair;
import org.eclipse.net4j.util.lifecycle.ILifecycle;

import java.io.IOException;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 3.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface InternalCDOBranchManager extends CDOBranchManager, ILifecycle
{
  /**
   * @since 4.2
   */
  public void setRepository(CDOCommonRepository repository);

  public BranchLoader getBranchLoader();

  public void setBranchLoader(BranchLoader branchLoader);

  public CDOTimeProvider getTimeProvider();

  /**
   * @deprecated As of 4.2 replaced by {@link #setRepository(CDOCommonRepository)}
   */
  @Deprecated
  public void setTimeProvider(CDOTimeProvider timeProvider);

  /**
   * @since 4.0
   */
  public void initMainBranch(boolean local, long timestamp);

  public InternalCDOBranch getMainBranch();

  public InternalCDOBranch getBranch(int branchID);

  public InternalCDOBranch getBranch(int id, String name, InternalCDOBranch baseBranch, long baseTimeStamp);

  public InternalCDOBranch getBranch(int id, BranchInfo branchInfo);

  public InternalCDOBranch getBranch(String path);

  public InternalCDOBranch createBranch(int id, String name, InternalCDOBranch baseBranch, long baseTimeStamp);

  /**
   * @since 4.3
   * @deprecated as of 4.4 use {@link CDOBranch#setName(String)}.
   */
  @Deprecated
  public void renameBranch(CDOBranch branch, String newName);

  /**
   * @deprecated As of 4.3 use {@link #handleBranchChanged(InternalCDOBranch, ChangeKind)}.
   */
  @Deprecated
  public void handleBranchCreated(InternalCDOBranch branch);

  /**
   * @since 4.3
   */
  public void handleBranchChanged(InternalCDOBranch branch, ChangeKind changeKind);

  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Eike Stepper
   * @since 3.0
   */
  public interface BranchLoader
  {
    /**
     * Passed as the branchID in {@link #createBranch(int, BranchInfo)} causes a new non-local branch to be created.
     */
    public static final int NEW_BRANCH = Integer.MAX_VALUE;

    /**
     * Passed as the branchID in {@link #createBranch(int, BranchInfo)} causes a new local branch to be created.
     */
    public static final int NEW_LOCAL_BRANCH = Integer.MIN_VALUE;

    /**
     * Creates a new branch with the given id and branch info. If the id is equal to {@link #NEW_BRANCH} the implementor
     * of this method will determine a new positive unique branch id. If the id is equal to {@link #NEW_LOCAL_BRANCH}
     * the implementor of this method will determine a new negative unique branch id, so that the new branch becomes a
     * local branch. In either case the used branch id is returned to the caller.
     *
     * @since 4.0
     */
    public Pair<Integer, Long> createBranch(int branchID, BranchInfo branchInfo);

    public BranchInfo loadBranch(int branchID);

    public SubBranchInfo[] loadSubBranches(int branchID);

    public int loadBranches(int startID, int endID, CDOBranchHandler branchHandler);

    /**
     * If the meaning of this type isn't clear, there really should be more of a description here...
     *
     * @author Eike Stepper
     * @since 3.0
     */
    public static final class BranchInfo
    {
      private String name;

      private int baseBranchID;

      private long baseTimeStamp;

      public BranchInfo(String name, int baseBranchID, long baseTimeStamp)
      {
        this.name = name;
        this.baseBranchID = baseBranchID;
        this.baseTimeStamp = baseTimeStamp;
      }

      public BranchInfo(CDODataInput in) throws IOException
      {
        name = in.readString();
        baseBranchID = in.readInt();
        baseTimeStamp = in.readLong();
      }

      public void write(CDODataOutput out) throws IOException
      {
        out.writeString(name);
        out.writeInt(baseBranchID);
        out.writeLong(baseTimeStamp);
      }

      public String getName()
      {
        return name;
      }

      /**
       * @since 4.4
       */
      public void setName(String name)
      {
        this.name = name;
      }

      public int getBaseBranchID()
      {
        return baseBranchID;
      }

      public long getBaseTimeStamp()
      {
        return baseTimeStamp;
      }

      @Override
      public String toString()
      {
        return "BranchInfo[name=" + name + ", baseBranchID=" + baseBranchID + ", baseTimeStamp=" + baseTimeStamp + "]";
      }
    }

    /**
     * If the meaning of this type isn't clear, there really should be more of a description here...
     * @author Eike Stepper
     * @since 3.0
     */
    public static final class SubBranchInfo
    {
      private int id;

      private String name;

      private long baseTimeStamp;

      public SubBranchInfo(int id, String name, long baseTimeStamp)
      {
        this.id = id;
        this.name = name;
        this.baseTimeStamp = baseTimeStamp;
      }

      public SubBranchInfo(CDODataInput in) throws IOException
      {
        id = in.readInt();
        name = in.readString();
        baseTimeStamp = in.readLong();
      }

      public void write(CDODataOutput out) throws IOException
      {
        out.writeInt(id);
        out.writeString(name);
        out.writeLong(baseTimeStamp);
      }

      public int getID()
      {
        return id;
      }

      public String getName()
      {
        return name;
      }

      public long getBaseTimeStamp()
      {
        return baseTimeStamp;
      }
    }
  }

  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Mathieu Velten
   * @since 4.3
   */
  public interface BranchLoader2 extends BranchLoader
  {
    /**
     * @deprecated Not yet implemented.
     */
    @Deprecated
    public void deleteBranch(int branchID);

    /**
     * @deprecated as of 4.4. use {@link BranchLoader3#renameBranch(int, String, String)}.
     */
    @Deprecated
    public void renameBranch(int branchID, String newName);
  }

  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Eike Stepper
   * @since 4.4
   */
  public interface BranchLoader3 extends BranchLoader2
  {
    public void renameBranch(int branchID, String oldName, String newName);
  }
}
