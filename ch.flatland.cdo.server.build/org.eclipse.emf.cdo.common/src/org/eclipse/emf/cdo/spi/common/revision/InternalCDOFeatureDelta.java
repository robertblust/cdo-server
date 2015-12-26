/*
 * Copyright (c) 2010-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Simon McDuff
 * @since 3.0
 */
public interface InternalCDOFeatureDelta extends CDOFeatureDelta
{
  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Eike Stepper
   * @noextend This interface is not intended to be extended by clients.
   * @noimplement This interface is not intended to be implemented by clients.
   */
  public interface WithIndex
  {
    public void adjustAfterAddition(int index);

    public void adjustAfterRemoval(int index);
  }

  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Eike Stepper
   * @noextend This interface is not intended to be extended by clients.
   * @noimplement This interface is not intended to be implemented by clients.
   */
  public interface ListIndexAffecting
  {
    /**
     * Expects the number of indices in the first element of the indices array.
     */
    public void affectIndices(ListTargetAdding source[], int[] indices);
  }

  /**
   * If the meaning of this type isn't clear, there really should be more of a description here...
   *
   * @author Eike Stepper
   * @noextend This interface is not intended to be extended by clients.
   * @noimplement This interface is not intended to be implemented by clients.
   */
  public interface ListTargetAdding
  {
    /**
     * @since 4.0
     */
    public Object getValue();

    public int getIndex();

    public void clear();
  }
}
