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

import org.eclipse.emf.cdo.common.commit.CDOCommitHistory;

import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.Lifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/**
 * @author Eike Stepper
 * @since 4.2
 */
public abstract class CDOCommitHistoryProviderImpl<KEY, HISTORY extends CDOCommitHistory> extends Lifecycle
    implements CDOCommitHistory.Provider<KEY, HISTORY>
{
  private Map<CDOCommitHistory, KEY> histories = new WeakHashMap<CDOCommitHistory, KEY>();

  private IListener historyListener = new LifecycleEventAdapter()
  {
    @Override
    protected void onDeactivated(ILifecycle lifecycle)
    {
      CDOCommitHistory history = (CDOCommitHistory)lifecycle;
      history.removeListener(this);

      synchronized (histories)
      {
        histories.remove(lifecycle);
      }
    }
  };

  public CDOCommitHistoryProviderImpl()
  {
  }

  public CDOCommitHistory getHistory()
  {
    return getHistory(null);
  }

  public HISTORY getHistory(KEY key)
  {
    synchronized (histories)
    {
      for (Entry<CDOCommitHistory, KEY> entry : histories.entrySet())
      {
        KEY currentKey = entry.getValue();
        if (currentKey == key)
        {
          CDOCommitHistory history = entry.getKey();
          return activateHistory(history);
        }
      }

      CDOCommitHistory history = createHistory(key);
      history.addListener(historyListener);
      histories.put(history, key);
      return activateHistory(history);
    }
  }

  protected abstract CDOCommitHistory createHistory(KEY key);

  @SuppressWarnings("unchecked")
  private HISTORY activateHistory(CDOCommitHistory history)
  {
    LifecycleUtil.activate(history);
    return (HISTORY)history;
  }
}
