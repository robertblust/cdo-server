/*
 * Copyright (c) 2010-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Andre Dietisheim - bug 256649
 */
package org.eclipse.emf.cdo.internal.common.commit;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.commit.CDOCommitData;
import org.eclipse.emf.cdo.common.commit.CDOCommitHistory;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.internal.common.bundle.OM;
import org.eclipse.emf.cdo.spi.common.commit.CDOCommitInfoUtil;
import org.eclipse.emf.cdo.spi.common.commit.InternalCDOCommitInfoManager;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Andre Dietisheim
 */
public class CDOCommitInfoManagerImpl extends CDOCommitHistoryProviderImpl<CDOBranch, CDOCommitHistory>
    implements InternalCDOCommitInfoManager
{
  private final Map<CDOCommitInfo, WeakReference<CDOCommitInfo>> cache;

  private final Object cacheLock = new Object();

  private final Map<CDOBranch, BranchInfoCache> branches = new WeakHashMap<CDOBranch, BranchInfoCache>();

  private CDOCommonRepository repository;

  private CommitInfoLoader loader;

  private List<CDOCommitInfoHandler> handlers = new ArrayList<CDOCommitInfoHandler>();

  public CDOCommitInfoManagerImpl(boolean caching)
  {
    if (caching)
    {
      cache = new WeakHashMap<CDOCommitInfo, WeakReference<CDOCommitInfo>>();
    }
    else
    {
      cache = null;
    }
  }

  public CDOCommonRepository getRepository()
  {
    return repository;
  }

  public void setRepository(CDOCommonRepository repository)
  {
    checkInactive();
    this.repository = repository;
  }

  public CommitInfoLoader getCommitInfoLoader()
  {
    return loader;
  }

  public void setCommitInfoLoader(CommitInfoLoader commitInfoLoader)
  {
    checkInactive();
    loader = commitInfoLoader;
  }

  public CDOCommitInfoHandler[] getCommitInfoHandlers()
  {
    synchronized (handlers)
    {
      return handlers.toArray(new CDOCommitInfoHandler[handlers.size()]);
    }
  }

  /**
   * @since 4.0
   */
  public void addCommitInfoHandler(CDOCommitInfoHandler handler)
  {
    synchronized (handlers)
    {
      handlers.add(handler);
    }
  }

  /**
   * @since 4.0
   */
  public void removeCommitInfoHandler(CDOCommitInfoHandler handler)
  {
    synchronized (handlers)
    {
      handlers.remove(handler);
    }
  }

  public void notifyCommitInfoHandlers(CDOCommitInfo commitInfo)
  {
    for (CDOCommitInfoHandler handler : getCommitInfoHandlers())
    {
      try
      {
        handler.handleCommitInfo(commitInfo);
      }
      catch (Exception ex)
      {
        OM.LOG.error(ex);
      }
    }
  }

  public CDOCommitInfo createCommitInfo(CDOBranch branch, long timeStamp, long previousTimeStamp, String userID,
      String comment, CDOCommitData commitData)
  {
    checkActive();
    CDOCommitInfo commitInfo = new CDOCommitInfoImpl(this, branch, timeStamp, previousTimeStamp, userID, comment,
        commitData);
    return intern(commitInfo);
  }

  public CDOCommitInfo getCommitInfo(long timeStamp)
  {
    checkActive();

    if (cache != null)
    {
      synchronized (cacheLock)
      {
        for (CDOCommitInfo commitInfo : cache.keySet())
        {
          if (commitInfo.getTimeStamp() == timeStamp)
          {
            return commitInfo;
          }
        }
      }
    }

    final CDOCommitInfo[] result = { null };
    getCommitInfos(null, timeStamp, timeStamp, new CDOCommitInfoHandler()
    {
      public void handleCommitInfo(CDOCommitInfo commitInfo)
      {
        result[0] = commitInfo;
      }
    });

    return result[0];
  }

  public CDOCommitInfo getCommitInfo(CDOBranch branch, long startTime, boolean up)
  {
    checkActive();
    int count = up ? 1 : -1;

    final CDOCommitInfo[] result = { null };
    getCommitInfos(branch, startTime, null, null, count, new CDOCommitInfoHandler()
    {
      public void handleCommitInfo(CDOCommitInfo commitInfo)
      {
        result[0] = commitInfo;
      }
    });

    return result[0];
  }

  public void getCommitInfos(CDOBranch branch, long startTime, long endTime, CDOCommitInfoHandler handler)
  {
    checkActive();
    if (cache != null)
    {
      final CDOCommitInfoHandler delegate = handler;
      handler = new CDOCommitInfoHandler()
      {
        public void handleCommitInfo(CDOCommitInfo commitInfo)
        {
          delegate.handleCommitInfo(intern(commitInfo));
        }
      };
    }

    loader.loadCommitInfos(branch, startTime, endTime, handler);
  }

  public void getCommitInfos(CDOBranch branch, long startTime, String reserved1, String reserved2, int count,
      CDOCommitInfoHandler handler)
  {
    if (reserved1 != null || reserved2 != null)
    {
      throw new IllegalArgumentException("The parameters reserved1 and reserved2 are not supported");
    }

    long endTime = CDOCommitInfoUtil.encodeCount(count);
    getCommitInfos(branch, startTime, endTime, handler);
  }

  public CDOCommitInfo getBaseOfBranch(CDOBranch branch)
  {
    if (branch.isMainBranch())
    {
      return null;
    }

    BranchInfoCache infoCache = getBranchInfoCache(branch);
    CDOCommitInfo base = infoCache.getBase();
    if (base == null)
    {
      base = loadBaseOfBranch(branch);
      infoCache.setBase(base);
    }

    return base;
  }

  public CDOCommitInfo getFirstOfBranch(CDOBranch branch)
  {
    BranchInfoCache infoCache = getBranchInfoCache(branch);
    CDOCommitInfo first = infoCache.getFirst();
    if (first == null)
    {
      first = loadFirstOfBranch(branch);
      infoCache.setFirst(first);
    }

    return first;
  }

  public CDOCommitInfo getLastOfBranch(CDOBranch branch)
  {
    BranchInfoCache infoCache = getBranchInfoCache(branch);
    CDOCommitInfo last = infoCache.getLast();
    if (last == null)
    {
      last = loadLastOfBranch(branch);
      infoCache.setLast(last);
    }

    return last;
  }

  @Override
  public String toString()
  {
    return "CommitInfoManager";
  }

  @Override
  protected void doBeforeActivate() throws Exception
  {
    super.doBeforeActivate();
    checkState(loader, "commitInfoLoader"); //$NON-NLS-1$
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    if (cache != null)
    {
      synchronized (cacheLock)
      {
        cache.clear();
      }
    }

    super.doDeactivate();
  }

  @Override
  protected CDOCommitHistory createHistory(CDOBranch key)
  {
    return new CDOCommitHistoryImpl(this, key);
  }

  private CDOCommitInfo intern(CDOCommitInfo commitInfo)
  {
    if (cache != null && commitInfo != null)
    {
      synchronized (cacheLock)
      {
        WeakReference<CDOCommitInfo> ref = cache.get(commitInfo);
        CDOCommitInfo cachedCommitInfo = ref != null ? ref.get() : null;
        if (cachedCommitInfo != null)
        {
          return cachedCommitInfo;
        }

        cache.put(commitInfo, new WeakReference<CDOCommitInfo>(commitInfo));
      }
    }

    return commitInfo;
  }

  private BranchInfoCache getBranchInfoCache(CDOBranch branch)
  {
    BranchInfoCache infoCache = branches.get(branch);
    if (infoCache == null)
    {
      infoCache = new BranchInfoCache();
      branches.put(branch, infoCache);
    }

    return infoCache;
  }

  private CDOCommitInfo loadBaseOfBranch(CDOBranch branch)
  {
    CDOBranchPoint base = branch.getBase();
    for (;;)
    {
      CDOBranch baseBranch = base.getBranch();
      if (baseBranch == null)
      {
        break;
      }

      long baseTime = base.getTimeStamp();

      CDOCommitInfo commitInfo = getCommitInfo(baseBranch, baseTime, false);
      if (commitInfo != null)
      {
        return commitInfo;
      }

      base = baseBranch.getBase();
    }

    return null;
  }

  private CDOCommitInfo loadFirstOfBranch(CDOBranch branch)
  {
    return getCommitInfo(branch, 1L, true);
  }

  private CDOCommitInfo loadLastOfBranch(CDOBranch branch)
  {
    return getCommitInfo(branch, Long.MAX_VALUE, false);
  }

  /**
   * @author Eike Stepper
   */
  private static final class BranchInfoCache
  {
    private SoftReference<CDOCommitInfo> base;

    private SoftReference<CDOCommitInfo> first;

    private SoftReference<CDOCommitInfo> last;

    public BranchInfoCache()
    {
    }

    public CDOCommitInfo getBase()
    {
      return base != null ? base.get() : null;
    }

    public void setBase(CDOCommitInfo base)
    {
      this.base = new SoftReference<CDOCommitInfo>(base);
    }

    public CDOCommitInfo getFirst()
    {
      return first != null ? first.get() : null;
    }

    public void setFirst(CDOCommitInfo first)
    {
      this.first = new SoftReference<CDOCommitInfo>(first);
    }

    public CDOCommitInfo getLast()
    {
      return last != null ? last.get() : null;
    }

    public void setLast(CDOCommitInfo last)
    {
      this.last = new SoftReference<CDOCommitInfo>(last);
    }
  }
}
