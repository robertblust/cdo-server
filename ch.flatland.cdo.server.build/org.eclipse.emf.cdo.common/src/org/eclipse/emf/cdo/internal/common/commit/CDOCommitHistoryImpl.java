/*
 * Copyright (c) 2012, 2015 Eike Stepper (Berlin, Germany) and others.
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
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.commit.CDOChangeKind;
import org.eclipse.emf.cdo.common.commit.CDOChangeSetData;
import org.eclipse.emf.cdo.common.commit.CDOCommitHistory;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoManager;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOPackageUnit;
import org.eclipse.emf.cdo.common.revision.CDOIDAndVersion;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.internal.common.bundle.OM;

import org.eclipse.net4j.util.collection.GrowingRandomAccessList;
import org.eclipse.net4j.util.container.Container;
import org.eclipse.net4j.util.event.FinishedEvent;
import org.eclipse.net4j.util.event.IListener;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Eike Stepper
 * @since 4.2
 */
public class CDOCommitHistoryImpl extends Container<CDOCommitInfo>implements CDOCommitHistory
{
  private final TriggerLoadElement triggerLoadElement = new TriggerLoadElementImpl();

  private final CDOCommitInfoManager manager;

  private final CDOBranch branch;

  private int loadCount = DEFAULT_LOAD_COUNT;

  private GrowingRandomAccessList<CDOCommitInfo> commitInfos = new GrowingRandomAccessList<CDOCommitInfo>(
      CDOCommitInfo.class, DEFAULT_LOAD_COUNT);

  private CDOCommitInfo[] elements;

  private boolean appendingTriggerLoadElement;

  private boolean full;

  private Thread loaderThread;

  private Object loaderThreadLock = new Object();

  public CDOCommitHistoryImpl(CDOCommitInfoManager manager, CDOBranch branch)
  {
    super(true);
    this.manager = manager;
    this.branch = branch;
  }

  public final CDOCommitInfoManager getManager()
  {
    return manager;
  }

  public final CDOBranch getBranch()
  {
    return branch;
  }

  public final int getLoadCount()
  {
    return loadCount;
  }

  public void setLoadCount(int loadCount)
  {
    this.loadCount = loadCount;
  }

  public boolean isAppendingTriggerLoadElement()
  {
    return appendingTriggerLoadElement;
  }

  public void setAppendingTriggerLoadElement(boolean appendingTriggerLoadElement)
  {
    int event = 0;
    synchronized (commitInfos)
    {
      if (this.appendingTriggerLoadElement != appendingTriggerLoadElement)
      {
        this.appendingTriggerLoadElement = appendingTriggerLoadElement;
        elements = null;

        if (!full)
        {
          if (appendingTriggerLoadElement)
          {
            event = 1;
          }
          else
          {
            event = 2;
          }
        }
      }
    }

    switch (event)
    {
    case 1:
      fireElementAddedEvent(triggerLoadElement);
      break;

    case 2:
      fireElementRemovedEvent(triggerLoadElement);
      break;
    }
  }

  public CDOCommitInfo getFirstElement()
  {
    checkActive();
    synchronized (commitInfos)
    {
      if (commitInfos.isEmpty())
      {
        return null;
      }

      return commitInfos.getFirst();
    }
  }

  public CDOCommitInfo getLastElement()
  {
    checkActive();
    synchronized (commitInfos)
    {
      if (commitInfos.isEmpty())
      {
        return null;
      }

      return commitInfos.getLast();
    }
  }

  public CDOCommitInfo getElement(int index)
  {
    checkActive();
    synchronized (commitInfos)
    {
      return commitInfos.get(index);
    }
  }

  public CDOCommitInfo[] getElements()
  {
    checkActive();
    synchronized (commitInfos)
    {
      if (elements == null)
      {
        int size = commitInfos.size();
        if (!full && appendingTriggerLoadElement && !isLoading())
        {
          elements = commitInfos.toArray(new CDOCommitInfo[size + 1]);
          elements[size] = triggerLoadElement;
        }
        else
        {
          elements = commitInfos.toArray(new CDOCommitInfo[size]);
        }
      }

      return elements;
    }
  }

  public int size()
  {
    checkActive();
    synchronized (commitInfos)
    {
      int size = commitInfos.size();
      if (!full && appendingTriggerLoadElement)
      {
        ++size;
      }

      return size;
    }
  }

  @Override
  public boolean isEmpty()
  {
    checkActive();
    synchronized (commitInfos)
    {
      if (!full && appendingTriggerLoadElement)
      {
        return false;
      }

      return commitInfos.isEmpty();
    }
  }

  public boolean isFull()
  {
    return full;
  }

  public boolean isLoading()
  {
    synchronized (loaderThreadLock)
    {
      return loaderThread != null;
    }
  }

  public void waitWhileLoading(long timeout)
  {
    long end = System.currentTimeMillis() + timeout;

    synchronized (commitInfos)
    {
      while (isLoading())
      {
        try
        {
          long remaining = end - System.currentTimeMillis();
          if (remaining <= 0)
          {
            return;
          }

          commitInfos.wait(remaining);
        }
        catch (InterruptedException ex)
        {
          return;
        }
      }
    }
  }

  public boolean triggerLoad()
  {
    return triggerLoad(null);
  }

  public boolean triggerLoad(final CDOCommitInfoHandler handler)
  {
    synchronized (loaderThreadLock)
    {
      if (full || loaderThread != null)
      {
        return false;
      }

      loaderThread = new Thread("CDOCommitHistoryLoader")
      {
        @Override
        public void run()
        {
          try
          {
            doLoadCommitInfos(handler);
          }
          catch (Throwable ex)
          {
            OM.LOG.error(ex);
          }
          finally
          {
            synchronized (loaderThreadLock)
            {
              loaderThread = null;
            }
          }
        }
      };
    }

    loaderThread.start();
    return true;
  }

  public void handleCommitInfo(CDOCommitInfo commitInfo)
  {
    if (filter(commitInfo))
    {
      return;
    }

    long timeStamp = commitInfo.getTimeStamp();
    synchronized (commitInfos)
    {
      if (commitInfos.isEmpty() || timeStamp > commitInfos.getFirst().getTimeStamp())
      {
        commitInfos.addFirst(commitInfo);
      }
      else
      {
        if (timeStamp < commitInfos.getLast().getTimeStamp())
        {
          commitInfos.addLast(commitInfo);
        }
        else
        {
          for (ListIterator<CDOCommitInfo> it = commitInfos.listIterator(); it.hasNext();)
          {
            CDOCommitInfo current = it.next();
            long currentTimeStamp = current.getTimeStamp();
            if (timeStamp == currentTimeStamp)
            {
              // Ignore duplicate commit infos
              return;
            }

            if (timeStamp < currentTimeStamp)
            {
              it.add(commitInfo);
              break;
            }
          }
        }
      }

      elements = null;
      commitInfos.notifyAll();
    }

    fireElementAddedEvent(commitInfo);
  }

  protected boolean filter(CDOCommitInfo commitInfo)
  {
    return branch != null && branch != commitInfo.getBranch();
  }

  protected void setFull()
  {
    full = true;
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    manager.addCommitInfoHandler(this);
  }

  @Override
  protected void doAfterActivate() throws Exception
  {
    super.doAfterActivate();
    triggerLoad();
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    manager.removeCommitInfoHandler(this);
    super.doDeactivate();
  }

  protected void doLoadCommitInfos(final CDOCommitInfoHandler handler)
  {
    final long startTime;
    synchronized (commitInfos)
    {
      startTime = commitInfos.isEmpty() ? CDOBranchPoint.UNSPECIFIED_DATE : commitInfos.getLast().getTimeStamp();
    }

    final int[] loaded = { 0 };
    manager.getCommitInfos(branch, startTime, null, null, -loadCount, new CDOCommitInfoHandler()
    {
      private boolean ignore = startTime != CDOBranchPoint.UNSPECIFIED_DATE;

      public void handleCommitInfo(CDOCommitInfo commitInfo)
      {
        ++loaded[0];

        if (ignore)
        {
          ignore = false;
          return;
        }

        CDOCommitHistoryImpl.this.handleCommitInfo(commitInfo);
        handle(handler, commitInfo);
      }
    });

    if (loaded[0] < loadCount)
    {
      setFull();
    }
    else if (appendingTriggerLoadElement)
    {
      fireElementAddedEvent(triggerLoadElement);
      handle(handler, triggerLoadElement);
    }

    if (handler instanceof IListener)
    {
      IListener listener = (IListener)handler;
      listener.notifyEvent(FinishedEvent.INSTANCE);
    }
  }

  private static void handle(final CDOCommitInfoHandler handler, CDOCommitInfo commitInfo)
  {
    if (handler != null)
    {
      handler.handleCommitInfo(commitInfo);
    }
  }

  /**
   * @author Eike Stepper
   */
  private final class TriggerLoadElementImpl implements TriggerLoadElement
  {
    public CDOCommitHistory getHistory()
    {
      return CDOCommitHistoryImpl.this;
    }

    public CDOCommitInfoManager getCommitInfoManager()
    {
      return manager;
    }

    public CDOBranch getBranch()
    {
      return null;
    }

    public long getTimeStamp()
    {
      return CDOBranchPoint.UNSPECIFIED_DATE;
    }

    public long getPreviousTimeStamp()
    {
      return CDOBranchPoint.UNSPECIFIED_DATE;
    }

    public String getUserID()
    {
      return null;
    }

    public String getComment()
    {
      return "Load more history elements";
    }

    public boolean isEmpty()
    {
      return true;
    }

    public boolean isInitialCommit()
    {
      return false;
    }

    public boolean isCommitDataLoaded()
    {
      return true;
    }

    public List<CDOPackageUnit> getNewPackageUnits()
    {
      return null;
    }

    public List<CDOIDAndVersion> getNewObjects()
    {
      return null;
    }

    public List<CDORevisionKey> getChangedObjects()
    {
      return null;
    }

    public List<CDOIDAndVersion> getDetachedObjects()
    {
      return null;
    }

    public Map<CDOID, CDOChangeKind> getChangeKinds()
    {
      return null;
    }

    public CDOChangeKind getChangeKind(CDOID id)
    {
      return null;
    }

    public void merge(CDOChangeSetData changeSetData)
    {
    }

    public CDOChangeSetData copy()
    {
      return null;
    }
  }

  /**
   * @author Eike Stepper
   */
  public static final class Empty extends Container<CDOCommitInfo>implements CDOCommitHistory
  {
    private static final CDOCommitInfo[] NO_ELEMENTS = {};

    public CDOCommitInfo[] getElements()
    {
      return NO_ELEMENTS;
    }

    public CDOCommitInfo[] getElements(boolean withTriggerLoadElement)
    {
      return NO_ELEMENTS;
    }

    public void handleCommitInfo(CDOCommitInfo commitInfo)
    {
    }

    public CDOCommitInfoManager getManager()
    {
      return null;
    }

    public CDOBranch getBranch()
    {
      return null;
    }

    public boolean isAppendingTriggerLoadElement()
    {
      return false;
    }

    public void setAppendingTriggerLoadElement(boolean appendingTriggerLoadElement)
    {
    }

    public CDOCommitInfo getFirstElement()
    {
      return null;
    }

    public CDOCommitInfo getLastElement()
    {
      return null;
    }

    public CDOCommitInfo getElement(int index)
    {
      return null;
    }

    public int size()
    {
      return 0;
    }

    public boolean isLoading()
    {
      return false;
    }

    public void waitWhileLoading(long timeout)
    {
    }

    public int getLoadCount()
    {
      return 0;
    }

    public void setLoadCount(int loadCount)
    {
    }

    public boolean triggerLoad()
    {
      return false;
    }

    public boolean triggerLoad(CDOCommitInfoHandler handler)
    {
      return false;
    }

    public boolean isFull()
    {
      return true;
    }
  }
}
