/*
 * Copyright (c) 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.commit;

/**
 * Calls registered {@link CDOCommitInfoHandler commit info handlers}.
 *
 * @author Eike Stepper
 * @since 4.2
 */
public interface CDOCommitInfoProvider
{
  public CDOCommitInfoHandler[] getCommitInfoHandlers();

  public void addCommitInfoHandler(CDOCommitInfoHandler handler);

  public void removeCommitInfoHandler(CDOCommitInfoHandler handler);
}
