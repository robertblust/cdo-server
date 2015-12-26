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
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDOAllRevisionsProvider;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.CDORevisionCache;

import org.eclipse.net4j.util.lifecycle.ILifecycle;

import java.util.List;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 3.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface InternalCDORevisionCache extends CDORevisionCache, CDOAllRevisionsProvider, ILifecycle
{
  public InternalCDORevisionCache instantiate(CDORevision revision);

  public CDORevision removeRevision(CDOID id, CDOBranchVersion branchVersion);

  public void clear();

  public List<CDORevision> getRevisions(CDOBranchPoint branchPoint);

  /**
   * Fills a list with all {@link CDORevision revisions}.
   *
   * @since 4.3
   * @see #getAllRevisions()
   */
  public void getAllRevisions(List<InternalCDORevision> result);
}
