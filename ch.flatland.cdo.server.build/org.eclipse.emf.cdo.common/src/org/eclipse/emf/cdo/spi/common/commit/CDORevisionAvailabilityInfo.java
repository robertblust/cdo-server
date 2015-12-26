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

import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.common.revision.CDORevisionProvider;

import java.text.MessageFormat;
import java.util.Map;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 3.0
 */
public final class CDORevisionAvailabilityInfo implements CDORevisionProvider
{
  private CDOBranchPoint branchPoint;

  private Map<CDOID, CDORevisionKey> availableRevisions = CDOIDUtil.createMap();

  public CDORevisionAvailabilityInfo(CDOBranchPoint branchPoint)
  {
    this.branchPoint = branchPoint;
  }

  public CDOBranchPoint getBranchPoint()
  {
    return branchPoint;
  }

  public Map<CDOID, CDORevisionKey> getAvailableRevisions()
  {
    return availableRevisions;
  }

  public void addRevision(CDORevisionKey key)
  {
    availableRevisions.put(key.getID(), key);
  }

  public void removeRevision(CDOID id)
  {
    availableRevisions.remove(id);
  }

  public boolean containsRevision(CDOID id)
  {
    return availableRevisions.containsKey(id);
  }

  public CDORevision getRevision(CDOID id)
  {
    return (CDORevision)availableRevisions.get(id);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDORevisionAvailabilityInfo[{0} -> {1} ]", branchPoint, availableRevisions.values());
  }
}
