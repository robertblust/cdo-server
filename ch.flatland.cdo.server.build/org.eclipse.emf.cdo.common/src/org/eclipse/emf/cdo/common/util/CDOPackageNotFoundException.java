/*
 * Copyright (c) 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Esteban Dugueperoux - initial API and implementation
 */
package org.eclipse.emf.cdo.common.util;

import org.eclipse.emf.cdo.internal.common.messages.Messages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;

import java.text.MessageFormat;

/**
 * A {@link CDOException} to indicate that an {@link EPackage} is not available in the current {@link Registry}.
 *
 * @author Esteban Dugueperoux
 * @since 4.4
 */
public final class CDOPackageNotFoundException extends CDOException
{
  private static final long serialVersionUID = 1L;

  private final String packageURI;

  public CDOPackageNotFoundException(String packageURI)
  {
    super(MessageFormat.format(Messages.getString("CDOSessionImpl.0"), packageURI));
    this.packageURI = packageURI;
  }

  public String getPackageURI()
  {
    return packageURI;
  }
}
