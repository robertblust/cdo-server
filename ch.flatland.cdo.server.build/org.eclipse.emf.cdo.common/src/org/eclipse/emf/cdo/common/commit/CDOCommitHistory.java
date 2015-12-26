/*
 * Copyright (c) 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.commit;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.internal.common.commit.CDOCommitHistoryImpl;

import org.eclipse.net4j.util.container.IContainer;

/**
 * A cache for the {@link CDOCommitInfo commit infos} of a branch or of an entire repository.
 *
 * @author Eike Stepper
 * @since 4.2
 */
public interface CDOCommitHistory extends IContainer<CDOCommitInfo>, CDOCommitInfoHandler
{
  public static final CDOCommitHistory EMPTY = new CDOCommitHistoryImpl.Empty();

  public static final int DEFAULT_LOAD_COUNT = 50;

  public CDOCommitInfoManager getManager();

  public CDOBranch getBranch();

  public boolean isAppendingTriggerLoadElement();

  public void setAppendingTriggerLoadElement(boolean appendingTriggerLoadElement);

  public CDOCommitInfo getFirstElement();

  public CDOCommitInfo getLastElement();

  public CDOCommitInfo getElement(int index);

  public int size();

  public boolean isFull();

  public boolean isLoading();

  public void waitWhileLoading(long timeout);

  public int getLoadCount();

  public void setLoadCount(int loadCount);

  public boolean triggerLoad();

  public boolean triggerLoad(CDOCommitInfoHandler handler);

  /**
   * Provides consumers with {@link CDOCommitHistory histories}.
   *
   * @author Eike Stepper
   */
  public interface Provider<KEY, HISTORY extends CDOCommitHistory>
  {
    public CDOCommitHistory getHistory();

    public HISTORY getHistory(KEY key);
  }

  /**
   * A virtual {@link CDOCommitHistory history} element that can be returned from {@link CDOCommitHistory#getElements()}
   * if {@link CDOCommitHistory#isAppendingTriggerLoadElement()} is <code>true</code> to indicate that
   * the history is not {@link CDOCommitHistory#isFull() fully} loaded, yet.
   *
   * @author Eike Stepper
   */
  public interface TriggerLoadElement extends CDOCommitInfo
  {
    public CDOCommitHistory getHistory();
  }
}
