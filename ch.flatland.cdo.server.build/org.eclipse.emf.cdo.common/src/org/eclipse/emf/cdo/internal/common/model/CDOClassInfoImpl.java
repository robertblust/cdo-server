/*
 * Copyright (c) 2009, 2011-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Christian W. Damus (CEA) - support partially persistent features
 *    Christian W. Damus (CEA) - bug 404318: NPEs in dynamic objects whose EClasses are unloaded
 */
package org.eclipse.emf.cdo.internal.common.model;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOClassInfo;
import org.eclipse.emf.cdo.common.model.CDOModelUtil;
import org.eclipse.emf.cdo.common.model.EMFUtil;
import org.eclipse.emf.cdo.internal.common.bundle.OM;
import org.eclipse.emf.cdo.spi.common.model.InternalCDOClassInfo;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.spi.common.revision.StubCDORevision;

import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * @author Eike Stepper
 */
public final class CDOClassInfoImpl implements InternalCDOClassInfo, Adapter.Internal
{
  private static final PersistenceFilter[] NO_FILTERS = {};

  private final InternalCDORevision revisionWithoutID = new RevisionWithoutID(this);

  private EClass eClass;

  private final BitSet persistentBits = new BitSet();

  private final BitSet persistentOppositeBits = new BitSet();

  private PersistenceFilter[] persistenceFilters = NO_FILTERS;

  private EStructuralFeature[] allPersistentFeatures;

  private EReference[] allPersistentReferences;

  private EStructuralFeature[] allPersistentContainments;

  private int[] persistentFeatureIndices;

  private int settingsFeatureCount;

  private int[] settingsFeatureIndices;

  /**
   * The number of *extra* features on top of {@link #settingsFeatureCount} when the object is TRANSIENT.
   */
  private int transientFeatureCount;

  /**
   * This is not about transient features! But about indices of all features of TRANSIENT objects.
   */
  private int[] transientFeatureIndices;

  public CDOClassInfoImpl()
  {
  }

  public InternalCDORevision getRevisionForID(CDOID id)
  {
    if (id == null)
    {
      return revisionWithoutID;
    }

    return new RevisionWithID(this, id);
  }

  public boolean isAdapterForType(Object type)
  {
    return type == CDOClassInfo.class;
  }

  public void notifyChanged(Notification notification)
  {
  }

  public EClass getTarget()
  {
    return eClass;
  }

  public void setTarget(Notifier newTarget)
  {
    init((EClass)newTarget);
  }

  public void unsetTarget(Notifier oldTarget)
  {
    // pass. In particular, don't forget the EClass because it may still
    // be required by dependents such as DynamicCDOObjectImpls that retain
    // me as a descriptor of their class
  }

  public EClass getEClass()
  {
    return eClass;
  }

  public boolean isResource()
  {
    return CDOModelUtil.isResource(eClass);
  }

  public boolean isResourceFolder()
  {
    return CDOModelUtil.isResourceFolder(eClass);
  }

  public boolean isResourceNode()
  {
    return CDOModelUtil.isResourceNode(eClass);
  }

  public boolean isPersistent(int featureID)
  {
    return persistentBits.get(featureID);
  }

  public boolean isPersistent(EStructuralFeature feature)
  {
    int featureID = eClass.getFeatureID(feature);
    return isPersistent(featureID);
  }

  public boolean hasPersistentOpposite(EStructuralFeature feature)
  {
    int featureID = eClass.getFeatureID(feature);
    return persistentOppositeBits.get(featureID);
  }

  public EStructuralFeature[] getAllPersistentFeatures()
  {
    return allPersistentFeatures;
  }

  public EReference[] getAllPersistentReferences()
  {
    return allPersistentReferences;
  }

  public EStructuralFeature[] getAllPersistentContainments()
  {
    return allPersistentContainments;
  }

  public int getPersistentFeatureIndex(EStructuralFeature feature) throws IllegalArgumentException
  {
    int featureID = eClass.getFeatureID(feature);
    return getPersistentFeatureIndex(featureID);
  }

  public int getPersistentFeatureIndex(int featureID) throws IllegalArgumentException
  {
    int index = persistentFeatureIndices[featureID];
    if (index == NO_SLOT)
    {
      throw new IllegalArgumentException("Feature not mapped: " + eClass.getEStructuralFeature(featureID)); //$NON-NLS-1$
    }

    return index;
  }

  public int getSettingsFeatureCount()
  {
    return settingsFeatureCount;
  }

  public int getSettingsFeatureIndex(int featureID)
  {
    return settingsFeatureIndices[featureID];
  }

  public int getTransientFeatureCount()
  {
    return transientFeatureCount;
  }

  public int getTransientFeatureIndex(int featureID)
  {
    return transientFeatureIndices[featureID];
  }

  public int getTransientFeatureIndex(EStructuralFeature feature)
  {
    int featureID = eClass.getFeatureID(feature);
    return getTransientFeatureIndex(featureID);
  }

  public PersistenceFilter getPersistenceFilter(EStructuralFeature feature)
  {
    if (persistenceFilters == NO_FILTERS)
    {
      return null;
    }

    int featureID = eClass.getFeatureID(feature);
    return persistenceFilters[featureID];
  }

  private PersistenceFilter initPersistenceFilter(EStructuralFeature feature)
  {
    CDOPersistenceFilterImpl result = null;
    String filter = EcoreUtil.getAnnotation(feature, EMFUtil.CDO_ANNOTATION_SOURCE, "filter");

    if (filter != null)
    {
      EStructuralFeature dependency = feature.getEContainingClass().getEStructuralFeature(filter);
      if (dependency != null)
      {
        result = new CDOPersistenceFilterImpl(dependency);
      }
      else
      {
        OM.LOG.warn("Persistence filter '" + filter + "' not found for " + feature);
      }
    }

    return result;
  }

  private void init(EClass eClass)
  {
    this.eClass = eClass;
    EList<EStructuralFeature> allFeatures = eClass.getEAllStructuralFeatures();
    int featureCount = eClass.getFeatureCount();

    List<EStructuralFeature> persistentFeatures = new ArrayList<EStructuralFeature>();
    List<EReference> persistentReferences = new ArrayList<EReference>();
    List<EStructuralFeature> persistentContainments = new ArrayList<EStructuralFeature>();

    // Used for tests for containment
    EStructuralFeature[] containments = ((EClassImpl.FeatureSubsetSupplier)eClass.getEAllStructuralFeatures())
        .containments();

    persistentBits.clear();
    persistentOppositeBits.clear();
    settingsFeatureIndices = new int[featureCount];

    for (int i = 0; i < featureCount; i++)
    {
      EStructuralFeature feature = eClass.getEStructuralFeature(i);
      if (EMFUtil.isPersistent(feature)) // persistentBits is not initialized, yet
      {
        int featureID = eClass.getFeatureID(feature);
        persistentBits.set(featureID);

        persistentFeatures.add(feature);
        if (isContainment(containments, feature))
        {
          persistentContainments.add(feature);
        }

        if (feature instanceof EReference)
        {
          EReference reference = (EReference)feature;
          persistentReferences.add(reference);

          EReference opposite = reference.getEOpposite();
          if (opposite != null && EMFUtil.isPersistent(opposite))
          {
            persistentOppositeBits.set(featureID);
          }
        }

        if (feature.isMany() || FeatureMapUtil.isFeatureMap(feature))
        {
          settingsFeatureIndices[i] = settingsFeatureCount++;
        }
        else
        {
          settingsFeatureIndices[i] = NO_SLOT;
        }
      }
      else
      {
        settingsFeatureIndices[i] = settingsFeatureCount++;
      }
    }

    transientFeatureIndices = new int[featureCount];
    for (int featureID = 0; featureID < featureCount; featureID++)
    {
      if (isPersistent(featureID))
      {
        transientFeatureIndices[featureID] = settingsFeatureCount + transientFeatureCount++;
      }
      else
      {
        // Transient *features* are already allocated to a slot (see above)
        transientFeatureIndices[featureID] = settingsFeatureIndices[featureID];
      }
    }

    allPersistentFeatures = persistentFeatures.toArray(new EStructuralFeature[persistentFeatures.size()]);
    allPersistentReferences = persistentReferences.toArray(new EReference[persistentReferences.size()]);
    allPersistentContainments = persistentContainments.toArray(new EStructuralFeature[persistentContainments.size()]);

    persistentFeatureIndices = new int[allFeatures.size()];
    Arrays.fill(persistentFeatureIndices, NO_SLOT);

    for (int i = 0; i < allPersistentFeatures.length; i++)
    {
      EStructuralFeature feature = allPersistentFeatures[i];
      int featureID = eClass.getFeatureID(feature);
      persistentFeatureIndices[featureID] = i;

      PersistenceFilter persistenceFilter = initPersistenceFilter(feature);
      if (persistenceFilter != null)
      {
        if (persistenceFilters == NO_FILTERS)
        {
          persistenceFilters = new PersistenceFilter[allFeatures.size()];
        }

        persistenceFilters[featureID] = persistenceFilter;
      }
    }
  }

  private boolean isContainment(EStructuralFeature[] containments, EStructuralFeature feature)
  {
    if (containments != null)
    {
      for (EStructuralFeature containment : containments)
      {
        if (containment == feature)
        {
          return true;
        }
      }
    }

    return false;
  }

  @Deprecated
  public int getFeatureIndex(EStructuralFeature feature)
  {
    return getPersistentFeatureIndex(feature);
  }

  @Deprecated
  public int getFeatureIndex(int featureID)
  {
    return getPersistentFeatureIndex(featureID);
  }

  @Override
  public String toString()
  {
    return eClass.toString();
  }

  /**
   * @author Eike Stepper
   */
  private static final class RevisionWithoutID extends StubCDORevision
  {
    public RevisionWithoutID(InternalCDOClassInfo classInfo)
    {
      super(classInfo);
    }

    @Override
    public CDOID getID()
    {
      return null;
    }

    @Override
    public InternalCDORevision getRevisionForID(CDOID id)
    {
      if (id == null)
      {
        return this;
      }

      return new RevisionWithID(getClassInfo(), id);
    }

    @Override
    public InternalCDORevision getProperRevision()
    {
      return null;
    }

    @Override
    public String toString()
    {
      return MessageFormat.format("RevisionWithoutID[{0}]", getClassInfo());
    }
  }

  /**
   * @author Eike Stepper
   */
  private static final class RevisionWithID extends StubCDORevision
  {
    private final CDOID id;

    public RevisionWithID(InternalCDOClassInfo classInfo, CDOID id)
    {
      super(classInfo);
      this.id = id;
    }

    @Override
    public CDOID getID()
    {
      return id;
    }

    @Override
    public InternalCDORevision getRevisionForID(CDOID id)
    {
      if (id == null)
      {
        return getClassInfo().getRevisionForID(null);
      }

      if (id.equals(this.id))
      {
        throw new ImplementationError(); // XXX Remove me
      }

      return new RevisionWithID(getClassInfo(), id);
    }

    @Override
    public InternalCDORevision getProperRevision()
    {
      return null;
    }

    @Override
    public String toString()
    {
      return MessageFormat.format("RevisionWithoutID[{0}, {1}]", getClassInfo(), id);
    }
  }
}
