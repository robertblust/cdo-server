/*
 * Copyright (c) 2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.branch;

import org.eclipse.emf.cdo.common.branch.CDOBranchManager;

/**
 * @author Eike Stepper
 * @since 4.3
 */
public interface CDOBranchAdjustable
{
  public void adjustBranches(CDOBranchManager newBranchManager);
}
