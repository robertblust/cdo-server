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
import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOAddFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDOFeatureDelta.ListIndexAffecting;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDOFeatureDelta.ListTargetAdding;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;

/**
 * @author Simon McDuff
 */
public class CDOAddFeatureDeltaImpl extends CDOSingleValueFeatureDeltaImpl
    implements CDOAddFeatureDelta, ListIndexAffecting, ListTargetAdding
{
  public CDOAddFeatureDeltaImpl(EStructuralFeature feature, int index, Object value)
  {
    super(feature, index, value);
  }

  public CDOAddFeatureDeltaImpl(CDODataInput in, EClass eClass) throws IOException
  {
    super(in, eClass);
  }

  public Type getType()
  {
    return Type.ADD;
  }

  public Object applyTo(CDORevision revision)
  {
    EStructuralFeature feature = getFeature();
    int index = getIndex();
    Object value = getValue();

    InternalCDORevision internalRevision = (InternalCDORevision)revision;
    CDOList list = internalRevision.getList(feature);
    list.add(index, value);
    return null;
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }

  public CDOAddFeatureDelta copy()
  {
    return new CDOAddFeatureDeltaImpl(getFeature(), getIndex(), getValue());
  }

  public void affectIndices(ListTargetAdding[] source, int[] indices)
  {
    int index = getIndex();
    if (index == NO_INDEX)
    {
      return;
    }

    for (int i = 1; i <= indices[0]; i++)
    {
      if (indices[i] >= index)
      {
        ++indices[i];
      }
    }
  }
}
