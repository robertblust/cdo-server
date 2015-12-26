/*
 * Copyright (c) 2009, 2011, 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Martin Taal - derived from CDOFeatureMapEntryImpl
 */
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @since 3.0
 * @author Martin Taal
 */
public interface CDOFeatureMapEntry extends FeatureMap.Entry
{
  public void setEStructuralFeature(EStructuralFeature feature);

  public void setValue(Object value);
}
