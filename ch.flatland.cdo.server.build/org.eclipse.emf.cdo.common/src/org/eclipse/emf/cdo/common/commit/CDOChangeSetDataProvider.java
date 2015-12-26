/*
 * Copyright (c) 2010-2012, 2015 Eike Stepper (Berlin, Germany) and others.
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
 * Provides consumers with {@link CDOChangeSetData change set data} structures.
 *
 * @author Eike Stepper
 * @since 4.0
 * @apiviz.uses {@link CDOChangeSetData} - - provides
 */
public interface CDOChangeSetDataProvider
{
  public CDOChangeSetData getChangeSetData();
}
