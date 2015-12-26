/*
 * Copyright (c) 2009-2013 Eike Stepper (Berlin, Germany) and others.
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

import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDORevisionUtil;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Simon McDuff
 * @since 2.0
 */
public interface InternalCDOList extends CDOList
{
  public static final Object UNINITIALIZED = CDORevisionUtil.UNINITIALIZED;

  /**
   * Adjusts references according to the passed adjuster and resynchronizes indexes.
   *
   * @since 4.0
   */
  public boolean adjustReferences(CDOReferenceAdjuster adjuster, EStructuralFeature feature);

  /**
   * Clones the list.
   */
  public InternalCDOList clone(EClassifier classifier);

  /**
   * @since 4.0
   */
  public void freeze();

  /**
   * @since 4.0
   */
  public void setWithoutFrozenCheck(int i, Object value);

  /**
   * A mixin interface for {@link InternalCDOList} that allows to optimize the speed of equality checks.
   *
   * @author Eike Stepper
   * @since 4.2
   */
  public interface ConfigurableEquality extends InternalCDOList
  {
    public void setUseEquals(boolean useEquals);
  }
}
