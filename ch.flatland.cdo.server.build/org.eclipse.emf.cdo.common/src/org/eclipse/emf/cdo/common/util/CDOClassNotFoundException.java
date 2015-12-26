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

import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.internal.common.messages.Messages;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;

import java.text.MessageFormat;

/**
 * A {@link CDOException} to indicate that an {@link EClass} is not available for an {@link EPackage} in the current {@link Registry}.
 *
 * @author Esteban Dugueperoux
 * @since 4.4
 */
public final class CDOClassNotFoundException extends CDOException
{
  private static final long serialVersionUID = 1L;

  private final String packageURI;

  private final String classifierName;

  public CDOClassNotFoundException(String packageURI, String classifierName)
  {
    super(MessageFormat.format(Messages.getString("CDOSessionImpl.1"),
        packageURI + CDOClassifierRef.URI_SEPARATOR + classifierName));
    this.packageURI = packageURI;
    this.classifierName = classifierName;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public String getClassifierName()
  {
    return classifierName;
  }
}
