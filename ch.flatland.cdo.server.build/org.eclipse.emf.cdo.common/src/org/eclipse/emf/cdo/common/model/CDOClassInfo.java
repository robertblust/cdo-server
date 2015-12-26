/*
 * Copyright (c) 2009, 2011-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.model;

import org.eclipse.emf.cdo.spi.common.model.InternalCDOClassInfo;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An EMF {@link Adapter adapter} that encapsulates CDO specific information about an {@link EClass}.
 *
 * @author Eike Stepper
 * @since 2.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @apiviz.landmark
 * @apiviz.has {@link org.eclipse.emf.ecore.EClass}
 */
public interface CDOClassInfo extends Adapter
{
  public EClass getEClass();

  public boolean isResourceNode();

  public boolean isResourceFolder();

  public boolean isResource();

  /**
   * @since 4.2
   */
  public boolean isPersistent(int featureID);

  /**
   * @since 4.2
   */
  public boolean isPersistent(EStructuralFeature feature);

  /**
   * @since 4.2
   */
  public boolean hasPersistentOpposite(EStructuralFeature feature);

  public EStructuralFeature[] getAllPersistentFeatures();

  /**
   * @since 4.2
   */
  public EReference[] getAllPersistentReferences();

  /**
   * @since 4.2
   */
  public EStructuralFeature[] getAllPersistentContainments();

  /**
   * @deprecated As of 4.2 pushed down to {@link InternalCDOClassInfo#getPersistentFeatureIndex(EStructuralFeature)}.
   */
  @Deprecated
  public int getFeatureIndex(EStructuralFeature feature);

  /**
   * @deprecated As of 4.2 pushed down to {@link InternalCDOClassInfo#getPersistentFeatureIndex(int)}.
   */
  @Deprecated
  public int getFeatureIndex(int featureID);
}
