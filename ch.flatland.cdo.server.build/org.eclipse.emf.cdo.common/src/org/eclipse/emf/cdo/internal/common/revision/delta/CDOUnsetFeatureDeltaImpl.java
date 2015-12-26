/*
 * Copyright (c) 2008-2012, 2014 Eike Stepper (Berlin, Germany) and others.
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

import org.eclipse.emf.cdo.common.model.CDOModelUtil;
import org.eclipse.emf.cdo.common.model.CDOType;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.common.revision.delta.CDOUnsetFeatureDelta;
import org.eclipse.emf.cdo.spi.common.revision.CDOReferenceAdjuster;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;
import java.util.List;

/**
 * @author Simon McDuff
 */
public class CDOUnsetFeatureDeltaImpl extends CDOFeatureDeltaImpl implements CDOUnsetFeatureDelta
{
  public CDOUnsetFeatureDeltaImpl(EStructuralFeature feature)
  {
    super(feature);
  }

  public CDOUnsetFeatureDeltaImpl(CDODataInput in, EClass eClass) throws IOException
  {
    super(in, eClass);
  }

  public Type getType()
  {
    return Type.UNSET;
  }

  public CDOFeatureDelta copy()
  {
    return new CDOUnsetFeatureDeltaImpl(getFeature());
  }

  public Object applyTo(CDORevision revision)
  {
    EStructuralFeature feature = getFeature();

    InternalCDORevision internalRevision = (InternalCDORevision)revision;
    if (feature.isUnsettable())
    {
      internalRevision.unset(feature);
    }
    else
    {
      if (feature.isMany())
      {
        Object value = internalRevision.getValue(feature);
        if (value != null)
        {
          @SuppressWarnings("unchecked")
          List<Object> list = (List<Object>)value;
          list.clear();
        }
      }
      else
      {
        Object defaultValue = feature.getDefaultValue();

        CDOType type = CDOModelUtil.getType(feature.getEType());
        if (type != null)
        {
          defaultValue = type.convertToCDO(feature.getEType(), defaultValue);
        }

        internalRevision.set(feature, NO_INDEX, defaultValue);
      }
    }

    return null;
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }

  @Override
  public boolean adjustReferences(CDOReferenceAdjuster adjuster)
  {
    return false;
  }

  @Override
  protected String toStringAdditional()
  {
    return null;
  }
}
