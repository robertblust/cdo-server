/*
 * Copyright (c) 2008-2013, 2015 Eike Stepper (Berlin, Germany) and others.
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
import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDOListFactory;
import org.eclipse.emf.cdo.spi.common.revision.CDOReferenceAdjuster;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDOList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;

/**
 * @author Simon McDuff
 */
public class CDOListImpl extends BasicEList<Object>implements InternalCDOList.ConfigurableEquality
{
  public static final CDOListFactory FACTORY = new CDOListFactory()
  {
    public CDOList createList(int initialCapacity, int size, int initialChunk)
    {
      return new CDOListImpl(initialCapacity, size);
    }
  };

  private static final byte FROZEN_FLAG = 1;

  private static final byte USE_EQUALS_FLAG = 2;

  private static final long serialVersionUID = 1L;

  private transient byte flags = USE_EQUALS_FLAG;

  public CDOListImpl(int initialCapacity, int size)
  {
    super(initialCapacity);
    for (int j = 0; j < size; j++)
    {
      this.add(UNINITIALIZED);
    }
  }

  public InternalCDOList clone(EClassifier classifier)
  {
    CDOType type = CDOModelUtil.getType(classifier);
    int size = size();

    CDOListImpl list = new CDOListImpl(size, 0);
    list.setUseEquals(useEquals());

    for (int j = 0; j < size; j++)
    {
      Object value = this.get(j);
      list.add(j, type.copyValue(value));
    }

    return list;
  }

  public Object get(int index, boolean resolve)
  {
    return super.get(index);
  }

  /**
   * There's a duplicate of this method in WrappedHibernateList!!!
   */
  public boolean adjustReferences(CDOReferenceAdjuster revisionAdjuster, EStructuralFeature feature)
  {
    boolean changed = false;
    CDOType type = CDOModelUtil.getType(feature);
    int size = size();
    for (int i = 0; i < size; i++)
    {
      Object element = super.get(i);
      handleAdjustReference(i, element);
      Object newID = type.adjustReferences(revisionAdjuster, element, feature, i);
      if (newID != element) // Just an optimization for NOOP adjusters
      {
        super.set(i, newID);
        changed = true;
      }
    }

    return changed;
  }

  protected void handleAdjustReference(int index, Object element)
  {
  }

  public void freeze()
  {
    flags |= FROZEN_FLAG;
  }

  private void checkFrozen()
  {
    if ((flags & FROZEN_FLAG) != 0)
    {
      throw new IllegalStateException("Cannot modify a frozen list");
    }
  }

  @Override
  public boolean add(Object o)
  {
    checkFrozen();
    return super.add(o);
  }

  @Override
  public boolean remove(Object o)
  {
    checkFrozen();
    return super.remove(o);
  }

  @Override
  public boolean addAll(Collection<? extends Object> c)
  {
    checkFrozen();
    return super.addAll(c);
  }

  @Override
  public boolean addAll(int index, Collection<? extends Object> c)
  {
    checkFrozen();
    return super.addAll(index, c);
  }

  @Override
  public boolean removeAll(Collection<?> c)
  {
    checkFrozen();
    return super.removeAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c)
  {
    checkFrozen();
    return super.retainAll(c);
  }

  @Override
  public void clear()
  {
    checkFrozen();
    super.clear();
  }

  @Override
  public Object set(int index, Object element)
  {
    checkFrozen();
    return super.set(index, element);
  }

  @Override
  public void add(int index, Object element)
  {
    checkFrozen();
    super.add(index, element);
  }

  @Override
  public Object remove(int index)
  {
    checkFrozen();
    return super.remove(index);
  }

  public void setWithoutFrozenCheck(int index, Object element)
  {
    super.set(index, element);
  }

  @Override
  public final boolean useEquals()
  {
    return (flags & USE_EQUALS_FLAG) != 0;
  }

  public final void setUseEquals(boolean useEquals)
  {
    if (useEquals)
    {
      flags |= USE_EQUALS_FLAG;
    }
    else
    {
      flags &= ~USE_EQUALS_FLAG;
    }
  }
}
