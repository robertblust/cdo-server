/*
 * Copyright (c) 2011-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Caspar De Groot - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.lock;

import org.eclipse.emf.cdo.common.lock.CDOLockOwner;
import org.eclipse.emf.cdo.common.lock.CDOLockState;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Caspar De Groot
 * @since 4.1
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface InternalCDOLockState extends CDOLockState
{
  public void addReadLockOwner(CDOLockOwner lockOwner);

  public boolean removeReadLockOwner(CDOLockOwner lockOwner);

  public void setWriteLockOwner(CDOLockOwner lockOwner);

  public void setWriteOptionOwner(CDOLockOwner lockOwner);

  /**
   * @since 4.4
   */
  public boolean removeOwner(CDOLockOwner lockOwner);

  /**
   * @since 4.2
   */
  public void updateFrom(Object object, CDOLockState source);

  /**
   * @since 4.2
   */
  public void dispose();
}
