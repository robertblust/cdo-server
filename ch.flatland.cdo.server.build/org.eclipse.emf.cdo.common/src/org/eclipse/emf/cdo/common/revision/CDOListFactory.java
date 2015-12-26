/*
 * Copyright (c) 2008, 2011, 2012, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.common.revision;

import org.eclipse.emf.cdo.internal.common.revision.CDOListImpl;

/**
 * Creates {@link CDOList list} instances.
 *
 * @author Simon McDuff
 * @since 2.0
 * @apiviz.uses {@link CDOList} - - creates
 */
public interface CDOListFactory
{
  public static final CDOListFactory DEFAULT = CDOListImpl.FACTORY;

  public CDOList createList(int intitialCapacity, int size, int initialChunk);
}
