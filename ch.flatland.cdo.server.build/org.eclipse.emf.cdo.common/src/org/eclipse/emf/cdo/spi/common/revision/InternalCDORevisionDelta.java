/*
 * Copyright (c) 2009-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.revision.CDORevisable;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOOriginSizeProvider;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.spi.common.branch.CDOBranchAdjustable;

import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Map;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.0
 */
public interface InternalCDORevisionDelta extends CDORevisionDelta, CDOReferenceAdjustable, CDOBranchAdjustable
{
  /**
   * @since 3.0
   */
  public Map<EStructuralFeature, CDOFeatureDelta> getFeatureDeltaMap();

  /**
   * @deprecated As of 4.2 use {@link #addFeatureDelta(CDOFeatureDelta, CDOOriginSizeProvider)}.
   */
  @Deprecated
  public void addFeatureDelta(CDOFeatureDelta delta);

  /**
   * @since 4.2
   */
  public void addFeatureDelta(CDOFeatureDelta delta, CDOOriginSizeProvider originSizeProvider);

  /**
   * @since 3.0
   */
  public void setBranch(CDOBranch branch);

  /**
   * @since 3.0
   */
  public void setVersion(int version);

  /**
   * @since 4.0
   */
  public void setTarget(CDORevisable target);
}
