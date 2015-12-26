/*
 * Copyright (c) 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Christian W. Damus (CEA) - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.model;

import org.eclipse.emf.cdo.spi.common.model.InternalCDOClassInfo.PersistenceFilter;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.Collections;

/**
 * Encapsulation of a rule for filtering the persistent values
 * of a {@linkplain EStructuralFeature feature} in some model element.
 * <p>
 * Some models (such as UML's Activity metaclass) require partial persistence
 * of features, persisting a subset of the values in a feature that are also
 * in some other feature (the filtering feature).  Other models may apply other
 * transformations to features that require partial or otherwise custom
 * persistence rules.
 *
 * @since 4.2
 */
public class CDOPersistenceFilterImpl implements PersistenceFilter
{
  private final EStructuralFeature dependency;

  public CDOPersistenceFilterImpl(EStructuralFeature dependency)
  {
    this.dependency = dependency;
  }

  public Object getPersistableValue(EObject owner, Object value)
  {
    if (value instanceof Collection<?>)
    {
      Collection<?> collection = (Collection<?>)value;
      return filter(collection, asCollection(owner.eGet(dependency)));
    }

    if (asCollection(owner.eGet(dependency)).contains(value))
    {
      return value;
    }

    return null;
  }

  private Collection<?> asCollection(Object value)
  {
    if (value instanceof Collection<?>)
    {
      return (Collection<?>)value;
    }

    if (value == null)
    {
      return Collections.emptyList();
    }

    return Collections.singletonList(value);
  }

  private Collection<?> filter(Collection<?> elements, Collection<?> filter)
  {
    Collection<?> result = new BasicEList<Object>(elements);
    result.retainAll(filter);
    return result;
  }
}
