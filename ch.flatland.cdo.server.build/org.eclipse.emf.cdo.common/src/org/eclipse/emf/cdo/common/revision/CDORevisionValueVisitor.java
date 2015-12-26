/*
 * Copyright (c) 2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.common.revision;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Visits {@link CDORevisionData#get(org.eclipse.emf.ecore.EStructuralFeature, int) values} of a {@link CDORevisionData revision}.
 *
 * @author Eike Stepper
 * @since 4.2
 */
public interface CDORevisionValueVisitor
{
  public void visit(EStructuralFeature feature, Object value, int index);
}
