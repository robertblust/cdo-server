/*
 * Copyright (c) 2010-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andre Dietisheim - initial API and implementation
 */
package org.eclipse.emf.cdo.common.commit;

import org.eclipse.emf.cdo.common.CDOCommonRepository;
import org.eclipse.emf.cdo.common.branch.CDOBranch;

/**
 * Loads, provides and possible manages {@link CDOCommitInfo commit info} objects.
 *
 * @author Andre Dietisheim
 * @since 3.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @apiviz.landmark
 * @apiviz.uses {@link CDOCommitInfo} - - manages
 */
public interface CDOCommitInfoManager
    extends CDOCommitInfoProvider, CDOCommitHistory.Provider<CDOBranch, CDOCommitHistory>
{
  /**
   * @since 4.2
   */
  public CDOCommonRepository getRepository();

  /**
   * @since 4.0
   */
  public CDOCommitInfo getCommitInfo(long timeStamp);

  /**
   * @since 4.2
   */
  public CDOCommitInfo getCommitInfo(CDOBranch branch, long startTime, boolean up);

  public void getCommitInfos(CDOBranch branch, long startTime, long endTime, CDOCommitInfoHandler handler);

  /**
   * @since 4.0
   */
  public void getCommitInfos(CDOBranch branch, long startTime, String reserved1, String reserved2, int count,
      CDOCommitInfoHandler handler);

  /**
   * @since 4.2
   */
  public CDOCommitInfo getBaseOfBranch(CDOBranch branch);

  /**
   * @since 4.2
   */
  public CDOCommitInfo getFirstOfBranch(CDOBranch branch);

  /**
   * @since 4.2
   */
  public CDOCommitInfo getLastOfBranch(CDOBranch branch);
}
