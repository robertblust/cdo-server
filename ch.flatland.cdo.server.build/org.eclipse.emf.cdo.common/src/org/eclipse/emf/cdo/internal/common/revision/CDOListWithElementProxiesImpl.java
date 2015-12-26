/*
 * Copyright (c) 2011-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.internal.common.revision;

import org.eclipse.emf.cdo.common.model.CDOModelUtil;
import org.eclipse.emf.cdo.common.model.CDOType;
import org.eclipse.emf.cdo.common.revision.CDOElementProxy;
import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDOListFactory;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDOList;

import org.eclipse.emf.ecore.EClassifier;

/**
 * @author Simon McDuff
 */
public class CDOListWithElementProxiesImpl extends CDOListImpl
{
  public static final CDOListFactory FACTORY = new CDOListFactory()
  {
    public CDOList createList(int initialCapacity, int size, int initialChunk)
    {
      return new CDOListWithElementProxiesImpl(initialCapacity, size, initialChunk);
    }
  };

  private static final long serialVersionUID = 1L;

  public CDOListWithElementProxiesImpl(int initialCapacity, int size, int initialChunk)
  {
    super(initialCapacity, initialChunk);
    for (int j = initialChunk; j < size; j++)
    {
      this.add(new CDOElementProxyImpl(j));
    }
  }

  @Override
  public Object get(int index, boolean resolve)
  {
    if (resolve == true)
    {
      return get(index);
    }

    Object element = super.get(index);

    return element instanceof CDOElementProxy ? UNINITIALIZED : element;
  }

  @Override
  protected void handleAdjustReference(int index, Object element)
  {
    if (element instanceof CDOElementProxy)
    {
      ((CDOElementProxyImpl)element).setIndex(index);
    }
  }

  @Override
  public InternalCDOList clone(EClassifier classifier)
  {
    CDOType type = CDOModelUtil.getType(classifier);
    int size = size();

    CDOListWithElementProxiesImpl list = new CDOListWithElementProxiesImpl(size, 0, 0);
    list.setUseEquals(useEquals());

    for (int j = 0; j < size; j++)
    {
      Object value = this.get(j);

      if (value instanceof CDOElementProxy)
      {
        list.add(j, new CDOElementProxyImpl(((CDOElementProxy)value).getIndex()));
      }
      else
      {
        list.add(j, type.copyValue(value));
      }
    }

    return list;
  }
}
