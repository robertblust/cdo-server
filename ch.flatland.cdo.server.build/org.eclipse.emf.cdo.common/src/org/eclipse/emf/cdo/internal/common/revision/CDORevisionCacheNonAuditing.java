/*
 * Copyright (c) 2011-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - bug 201266
 *    Simon McDuff - bug 230832
 */
package org.eclipse.emf.cdo.internal.common.revision;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevisionCache;

import org.eclipse.net4j.util.CheckUtil;

import org.eclipse.emf.ecore.EClass;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDORevisionCacheNonAuditing extends AbstractCDORevisionCache
{
  private Map<CDOID, Reference<InternalCDORevision>> revisions = CDOIDUtil.createMap();

  public CDORevisionCacheNonAuditing()
  {
  }

  public InternalCDORevisionCache instantiate(CDORevision revision)
  {
    return new CDORevisionCacheNonAuditing();
  }

  public EClass getObjectType(CDOID id)
  {
    synchronized (revisions)
    {
      Reference<InternalCDORevision> ref = revisions.get(id);
      if (ref != null)
      {
        InternalCDORevision revision = ref.get();
        if (revision != null)
        {
          return revision.getEClass();
        }
      }

      return null;
    }
  }

  public InternalCDORevision getRevision(CDOID id, CDOBranchPoint branchPoint)
  {
    checkBranch(branchPoint.getBranch());

    synchronized (revisions)
    {
      Reference<InternalCDORevision> ref = revisions.get(id);
      if (ref != null)
      {
        InternalCDORevision revision = ref.get();
        if (revision != null && revision.isValid(branchPoint))
        {
          return revision;
        }
      }

      return null;
    }
  }

  public InternalCDORevision getRevisionByVersion(CDOID id, CDOBranchVersion branchVersion)
  {
    checkBranch(branchVersion.getBranch());

    synchronized (revisions)
    {
      Reference<InternalCDORevision> ref = revisions.get(id);
      if (ref != null)
      {
        InternalCDORevision revision = ref.get();
        if (revision != null && revision.getVersion() == branchVersion.getVersion())
        {
          return revision;
        }
      }

      return null;
    }
  }

  public List<CDORevision> getCurrentRevisions()
  {
    List<CDORevision> currentRevisions = new ArrayList<CDORevision>();
    synchronized (revisions)
    {
      for (Reference<InternalCDORevision> ref : revisions.values())
      {
        InternalCDORevision revision = ref.get();
        if (revision != null && !revision.isHistorical())
        {
          currentRevisions.add(revision);
        }
      }
    }

    return currentRevisions;
  }

  public Map<CDOBranch, List<CDORevision>> getAllRevisions()
  {
    Map<CDOBranch, List<CDORevision>> result = new HashMap<CDOBranch, List<CDORevision>>();
    synchronized (revisions)
    {
      List<CDORevision> list = new ArrayList<CDORevision>();
      for (Reference<InternalCDORevision> ref : revisions.values())
      {
        InternalCDORevision revision = ref.get();
        if (revision != null)
        {
          list.add(revision);
        }
      }

      if (!list.isEmpty())
      {
        result.put(list.get(0).getBranch(), list);
      }
    }

    return result;
  }

  public void getAllRevisions(List<InternalCDORevision> result)
  {
    for (Reference<InternalCDORevision> ref : revisions.values())
    {
      InternalCDORevision revision = ref.get();
      if (revision != null)
      {
        result.add(revision);
      }
    }
  }

  public List<CDORevision> getRevisions(CDOBranchPoint branchPoint)
  {
    checkBranch(branchPoint.getBranch());
    List<CDORevision> result = new ArrayList<CDORevision>();

    synchronized (revisions)
    {
      for (Reference<InternalCDORevision> ref : revisions.values())
      {
        InternalCDORevision revision = ref.get();
        if (revision != null && revision.isValid(branchPoint))
        {
          result.add(revision);
        }
      }
    }

    return result;
  }

  @Override
  protected void doAddRevision(CDORevision revision)
  {
    CheckUtil.checkArg(revision, "revision");
    checkBranch(revision.getBranch());

    if (!revision.isHistorical())
    {
      CDOID id = revision.getID();
      Reference<InternalCDORevision> reference = createReference(revision);

      synchronized (revisions)
      {
        Reference<InternalCDORevision> oldReference = revisions.put(id, reference);
        if (oldReference != null)
        {
          InternalCDORevision oldRevision = oldReference.get();
          if (oldRevision != null)
          {
            if (oldRevision.getVersion() > revision.getVersion())
            {
              // Put the old revision back because it's newer.
              revisions.put(id, oldReference);
            }
          }
        }
      }
    }
  }

  @Override
  protected InternalCDORevision doRemoveRevision(CDOID id, CDOBranchVersion branchVersion)
  {
    checkBranch(branchVersion.getBranch());
    synchronized (revisions)
    {
      Reference<InternalCDORevision> ref = revisions.get(id);
      if (ref != null)
      {
        InternalCDORevision revision = ref.get();
        if (revision != null)
        {
          if (revision.getVersion() == branchVersion.getVersion()) // No branch check needed in non-auditing
          {
            revisions.remove(id);
            return revision;
          }
        }
        else
        {
          revisions.remove(id);
        }
      }
    }

    return null;
  }

  public void clear()
  {
    synchronized (revisions)
    {
      revisions.clear();
    }
  }
}
