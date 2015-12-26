/*
 * Copyright (c) 2014, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Esteban Dugueperoux - initial API and implementation
 */
package org.eclipse.emf.cdo.common.revision;

import org.eclipse.net4j.util.event.IEvent;

import java.util.List;

/**
 * An {@link IEvent event} fired from a {@link CDORevisionManager revision manager} when a new {@link CDORevision revision} has
 * been loaded.
 *
 * @author Esteban Dugueperoux
 * @since 4.4
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CDORevisionsLoadedEvent extends IEvent
{
  public CDORevisionManager getSource();

  public List<? extends CDORevision> getPrimaryLoadedRevisions();

  public List<? extends CDORevision> getAdditionalLoadedRevisions();

  public int getPrefetchDepth();
}
