/*
 * Copyright (c) 2010-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.branch;

import org.eclipse.net4j.util.event.IEvent;

/**
 * An {@link IEvent event} fired from a {@link CDOBranchManager branch manager} when a new {@link CDOBranch branch} has
 * been created.
 *
 * @author Eike Stepper
 * @since 3.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @deprecated As of 4.3 use {@link CDOBranchChangedEvent}.
 */
@Deprecated
public interface CDOBranchCreatedEvent extends CDOBranchChangedEvent
{
  public CDOBranchManager getSource();

  public CDOBranch getBranch();
}
