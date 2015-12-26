/*
 * Copyright (c) 2008, 2011-2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.common.revision.delta;

import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.List;

/**
 * A {@link CDOFeatureDelta feature delta} that represents any modification of the list of a many-valued
 * {@link EStructuralFeature feature}. The detailed changes to this list are returned by the {@link #getListChanges()}
 * method.
 *
 * @author Simon McDuff
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @apiviz.composedOf {@link CDOFeatureDelta} - - listChanges
 */
public interface CDOListFeatureDelta extends CDOFeatureDelta, CDOOriginSizeProvider
{
  public List<CDOFeatureDelta> getListChanges();
}
