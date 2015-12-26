/*
 * Copyright (c) 2010-2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.revision;

/**
 * An entity that {@link CDORevision revisions} can be added to.
 *
 * @author Eike Stepper
 * @since 4.0
 */
public interface CDORevisionCacheAdder
{
  /**
   * Adds the given revision to this cache.
   */
  public void addRevision(CDORevision revision);
}
