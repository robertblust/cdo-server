/*
 * Copyright (c) 2009-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - maintenance
 */
package org.eclipse.emf.cdo.spi.common.revision;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDProvider;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.revision.CDOList;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.CDORevisionData;
import org.eclipse.emf.cdo.common.security.CDOPermission;
import org.eclipse.emf.cdo.spi.common.branch.CDOBranchAdjustable;
import org.eclipse.emf.cdo.spi.common.branch.InternalCDOBranch;
import org.eclipse.emf.cdo.spi.common.model.InternalCDOClassInfo;

import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;
import java.util.List;

/**
 * If the meaning of this type isn't clear, there really should be more of a description here...
 *
 * @author Eike Stepper
 * @since 2.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface InternalCDORevision extends CDORevision, CDORevisionData, CDOReferenceAdjustable, CDOBranchAdjustable
{
  /**
   * @since 4.2
   */
  public InternalCDOClassInfo getClassInfo();

  /**
   * @since 4.2
   */
  public InternalCDOBranch getBranch();

  /**
   * @since 4.2
   */
  public InternalCDORevision getRevisionForID(CDOID id);

  /**
   * @since 4.2
   */
  public InternalCDORevision getProperRevision();

  public void setID(CDOID id);

  public void setVersion(int version);

  /**
   * @since 3.0
   */
  public void setBranchPoint(CDOBranchPoint branchPoint);

  public void setRevised(long revised);

  public void setResourceID(CDOID resourceID);

  public void setContainerID(Object containerID);

  public void setContainingFeatureID(int containingFeatureID);

  /**
   * @since 3.0
   */
  public void adjustForCommit(CDOBranch branch, long timeStamp);

  public void add(EStructuralFeature feature, int index, Object value);

  public void clear(EStructuralFeature feature);

  public Object move(EStructuralFeature feature, int targetIndex, int sourceIndex);

  public Object remove(EStructuralFeature feature, int index);

  public Object set(EStructuralFeature feature, int index, Object value);

  public void unset(EStructuralFeature feature);

  /**
   * Should never return {@link InternalCDORevision#NIL}
   */
  public Object getValue(EStructuralFeature feature);

  public Object setValue(EStructuralFeature feature, Object value);

  public void setList(EStructuralFeature feature, InternalCDOList list);

  public CDOList getList(EStructuralFeature feature);

  /**
   * @param initialCapacity
   *          the initialCapacity of a new list to be created if this revision has no list so far (its size will always
   *          be 0), or -1 to skip list creation and return <code>null</code> in this case.
   */
  public CDOList getList(EStructuralFeature feature, int initialCapacity);

  /**
   * @since 3.0
   */
  public void read(CDODataInput in) throws IOException;

  /**
   * @since 4.3
   */
  public boolean readValues(CDODataInput in) throws IOException;

  /**
   * @since 3.0
   */
  public void write(CDODataOutput out, int referenceChunk) throws IOException;

  /**
   * @since 4.1
   */
  public void write(CDODataOutput out, int referenceChunk, CDOBranchPoint securityContext) throws IOException;

  /**
   * @since 4.3
   */
  public void writeValues(CDODataOutput out, int referenceChunk) throws IOException;

  /**
   * @since 3.0
   */
  public void convertEObjects(CDOIDProvider oidProvider);

  /**
   * @since 3.0
   */
  public InternalCDORevisionDelta compare(CDORevision origin);

  /**
   * @since 3.0
   */
  public InternalCDORevision copy();

  /**
   * @since 4.2
   */
  public EStructuralFeature[] clearValues();

  /**
   * @since 4.3
   */
  public String getResourceNodeName();

  /**
   * @since 4.1
   */
  public void setPermission(CDOPermission permission);

  /**
   * Enables or disables permission checking for this revision.
   * <p>
   * This method is used on the client side if the framework changes the revision on another
   * user's behalf, e.g., during invalidation or general revision copying. It's safe to offer this method
   * on the client side because the server is always the permission checking authority (during load or commit).
   *
   * @since 4.3
   */
  public boolean bypassPermissionChecks(boolean on);

  /**
   * @since 4.3
   */
  public boolean isListPreserving();

  /**
   * The default behavior of a revision for calls to the {@link #clear(EStructuralFeature)} and
   * {@link #unset(EStructuralFeature)} methods is to set the feature's value to null (discarding the
   * value itself, a List). By calling this {@link #setListPreserving()} method the default behavior
   * is changed; instead of setting the feature's value to null, the {@link List#clear()} method is
   * called on the feature's list instance.
   *
   * @since 4.3
   */
  public void setListPreserving();

  /**
   * @since 4.0
   */
  public void freeze();

  /**
   * @since 4.2
   */
  public boolean isFrozen();

  /**
   * @since 4.1
   */
  public boolean isUnchunked();

  /**
   * @since 4.1
   */
  public void setUnchunked();
}
