/*
 * Copyright (c) 2009-2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 */
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDORevisionUtil;

import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Map;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Simon McDuff
 * @since 2.0
 */
public class CDOIDMapper implements CDOReferenceAdjuster
{
  private Map<CDOID, CDOID> idMappings;

  private boolean allowUnmappedTempIDs;

  public CDOIDMapper(Map<CDOID, CDOID> idMappings)
  {
    this.idMappings = idMappings;
  }

  public Map<CDOID, CDOID> getIDMappings()
  {
    return idMappings;
  }

  /**
   * @since 3.0
   */
  public boolean isAllowUnmappedTempIDs()
  {
    return allowUnmappedTempIDs;
  }

  /**
   * @since 3.0
   */
  public void setAllowUnmappedTempIDs(boolean allowUnmappedTempIDs)
  {
    this.allowUnmappedTempIDs = allowUnmappedTempIDs;
  }

  /**
   * @since 4.0
   */
  public Object adjustReference(Object value, EStructuralFeature feature, int index)
  {
    return CDORevisionUtil.remapID(value, idMappings, allowUnmappedTempIDs);
  }
}
