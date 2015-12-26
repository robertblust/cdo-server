/*
 * Copyright (c) 2008-2012, 2014, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.internal.common.revision.delta;

import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.common.revision.delta.CDORemoveFeatureDelta;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDOFeatureDelta.ListIndexAffecting;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;

/**
 * @author Simon McDuff
 */
public class CDORemoveFeatureDeltaImpl extends CDOSingleValueFeatureDeltaImpl
    implements CDORemoveFeatureDelta, ListIndexAffecting
{
  public CDORemoveFeatureDeltaImpl(EStructuralFeature feature, int index)
  {
    super(feature, index, UNKNOWN_VALUE);
  }

  public CDORemoveFeatureDeltaImpl(CDODataInput in, EClass eClass) throws IOException
  {
    super(in, eClass);
  }

  @Override
  protected void writeValue(CDODataOutput out, EClass eClass) throws IOException
  {
    // Do nothing
  }

  @Override
  protected Object readValue(CDODataInput in, EClass eClass) throws IOException
  {
    return UNKNOWN_VALUE;
  }

  public Type getType()
  {
    return Type.REMOVE;
  }

  public CDOFeatureDelta copy()
  {
    CDORemoveFeatureDeltaImpl delta = new CDORemoveFeatureDeltaImpl(getFeature(), getIndex());
    delta.setValue(getValue());
    return delta;
  }

  public Object applyTo(CDORevision revision)
  {
    EStructuralFeature feature = getFeature();
    int index = getIndex();

    InternalCDORevision internalRevision = (InternalCDORevision)revision;
    CDOList list = internalRevision.getList(feature);
    return list.remove(index);
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }

  public void affectIndices(ListTargetAdding sources[], int[] indices)
  {
    int index = getIndex();
    for (int i = 1; i <= indices[0]; i++)
    {
      if (indices[i] > index)
      {
        --indices[i];
      }
      else if (indices[i] == index)
      {
        int rest = indices[0]-- - i;
        if (rest > 0)
        {
          System.arraycopy(indices, i + 1, indices, i, rest);
          System.arraycopy(sources, i + 1, sources, i, rest);
          --i;
        }
      }
    }
  }
}
