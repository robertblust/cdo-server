/*
 * Copyright (c) 2012, 2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Christian W. Damus (CEA) - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.model;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOClassInfo;
import org.eclipse.emf.cdo.common.model.EMFUtil;
import org.eclipse.emf.cdo.internal.common.revision.CDORevisionImpl;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject.EStore;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @since 4.2
 * @author Eike Stepper
 */
public interface InternalCDOClassInfo extends CDOClassInfo
{
  public static final int NO_SLOT = EStore.NO_INDEX;

  public InternalCDORevision getRevisionForID(CDOID id);

  /**
   * Returns the index of the specified {@link EStructuralFeature feature} in the {@link CDORevisionImpl#values} array, never {@link #NO_SLOT}.
   *
   * @throws IllegalArgumentException if the specified feature is <b>not</b> {@link #isPersistent(int) persistent}.
   * @see #getPersistentFeatureIndex(int)
   */
  public int getPersistentFeatureIndex(EStructuralFeature feature) throws IllegalArgumentException;

  /**
   * Returns the index of the specified {@link EStructuralFeature feature} in the {@link CDORevisionImpl#values} array, never {@link #NO_SLOT}.
   *
   * @throws IllegalArgumentException if the specified feature is <b>not</b> {@link #isPersistent(int) persistent}.
   * @see #getPersistentFeatureIndex(EStructuralFeature)
   */
  public int getPersistentFeatureIndex(int featureID) throws IllegalArgumentException;

  /**
   * Returns the number of {@link EStructuralFeature features} whose values are <b>always</b> stored in the
   * <code>CDOObjectImpl.eSettings</code> array, whether an object is in <code>CDOState.TRANSIENT</code> or not.
   * <p>
   * These are the {@link EMFUtil#isPersistent(EStructuralFeature) transient} and/or {@link EStructuralFeature#isMany() many-valued} features.
   *
   * @see #getSettingsFeatureIndex(int)
   */
  public int getSettingsFeatureCount();

  /**
   * Returns the index of the specified {@link EStructuralFeature feature} in the <code>CDOObjectImpl.eSettings</code> array,
   * or {@link #NO_SLOT} if the feature is {@link EMFUtil#isPersistent(EStructuralFeature) non-transient} or {@link EStructuralFeature#isMany() single-valued}.
   *
   * @see #getSettingsFeatureCount()
   */
  public int getSettingsFeatureIndex(int featureID);

  /**
   * Returns the number of {@link EStructuralFeature features} whose values are additionally stored in the <code>CDOObjectImpl.eSettings</code> array,
   * if an object is in <code>CDOState.TRANSIENT</code>.
   * <p>
   * These are the {@link EMFUtil#isPersistent(EStructuralFeature) non-transient} and/or {@link EStructuralFeature#isMany() single-valued} features.
   *
   * @see #getTransientFeatureIndex(int)
   */
  public int getTransientFeatureCount();

  /**
   * Returns the index of the specified {@link EStructuralFeature feature} in the <code>CDOObjectImpl.eSettings</code> array,
   * or {@link #NO_SLOT} if the feature is {@link EMFUtil#isPersistent(EStructuralFeature) transient} or {@link EStructuralFeature#isMany() many-valued}
   *
   * @see #getTransientFeatureCount()
   */
  public int getTransientFeatureIndex(int featureID);

  /**
   * @see #getTransientFeatureIndex(int)
   */
  public int getTransientFeatureIndex(EStructuralFeature feature);

  /**
   * Obtains a rule that filters/transforms the persist values of the given
   * {@code feature}.
   *
   * @param feature a feature to be persisted
   * @return a persistence filter rule for the {@code feature}, or {@code null}
   *    if it has no filter but just follows the default persistence rules
   */
  public PersistenceFilter getPersistenceFilter(EStructuralFeature feature);

  /**
   * Encapsulation of a rule for filtering the persistent values
   * of a {@linkplain EStructuralFeature feature} in some model element.
   * Some models (such as UML's Activity metaclass) require partial persistence
   * of features, persisting a subset of the values in a feature that are also
   * in some other feature (the filtering feature). Other models may apply other
   * transformations to features that require partial or otherwise custom
   * persistence rules.
   */
  public interface PersistenceFilter
  {
    /**
     * Get a subset or other transformation of the specified {@code value} of
     * a persistable feature, based on its dependencies.
     *
     * @param owner an object this filter is to be applied to.
     * @param value the value (which may be a collection) of the {@code owner}'s feature.
     *
     * @return the transformed value to persist. It should be a collection (possibly empty)
     * if the {@code value} is a collection, or a scalar (possibly {@code null}) if the
     * {@code value} is a scalar
     */
    public Object getPersistableValue(EObject owner, Object value);
  }
}
