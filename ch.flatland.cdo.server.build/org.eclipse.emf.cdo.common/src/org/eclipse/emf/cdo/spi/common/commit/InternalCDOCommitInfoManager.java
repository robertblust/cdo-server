/*
 * Copyright (c) 2010-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.commit;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.commit.CDOCommitData;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoManager;

import org.eclipse.net4j.util.lifecycle.ILifecycle;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 3.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface InternalCDOCommitInfoManager extends CDOCommitInfoManager, ILifecycle
{
  /**
   * @since 4.2
   */
  public void setRepository(CDOCommonRepository repository);

  public CommitInfoLoader getCommitInfoLoader();

  public void setCommitInfoLoader(CommitInfoLoader commitInfoLoader);

  /**
   * @since 4.2
   */
  public void notifyCommitInfoHandlers(CDOCommitInfo commitInfo);

  /**
   * @since 4.0
   */
  public CDOCommitInfo createCommitInfo(CDOBranch branch, long timeStamp, long previousTimeStamp, String userID,
      String comment, CDOCommitData commitData);

  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Eike Stepper
   */
  public interface CommitInfoLoader
  {
    public void loadCommitInfos(CDOBranch branch, long startTime, long endTime, CDOCommitInfoHandler handler);

    public CDOCommitData loadCommitData(long timeStamp);
  }
}
