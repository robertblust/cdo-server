/*
 * Copyright (c) 2009, 2011-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.protocol;

import org.eclipse.emf.cdo.common.CDOCommonSession;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.revision.CDORevisionProvider;
import org.eclipse.emf.cdo.common.security.CDOPermission;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * The communications protocol associated with a CDO {@link CDOCommonSession session}.
 *
 * @author Eike Stepper
 * @since 2.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @apiviz.uses {@link CDODataInput}
 * @apiviz.uses {@link CDODataOutput}
 */
public interface CDOProtocol extends CDOProtocolConstants
{
  public CDOCommonSession getSession();

  /**
   * A data transfer object for commit notifications.
   *
   * @author Eike Stepper
   * @since 4.3
   */
  public static final class CommitNotificationInfo
  {
    public static final byte IMPACT_NONE = 0;

    public static final byte IMPACT_PERMISSIONS = 1;

    public static final byte IMPACT_REALM = 2;

    private int senderID;

    private CDOCommonSession sender;

    private CDORevisionProvider revisionProvider;

    private CDOCommitInfo commitInfo;

    private Map<CDOID, CDOPermission> newPermissions;

    private Set<? extends Object> impactedRules;

    private byte securityImpact = IMPACT_NONE;

    private boolean clearResourcePathCache;

    public CommitNotificationInfo()
    {
    }

    public CommitNotificationInfo(CDODataInput in) throws IOException
    {
      senderID = in.readInt();
      commitInfo = in.readCDOCommitInfo();
      clearResourcePathCache = in.readBoolean();
      securityImpact = in.readByte();

      int size = in.readInt();
      if (size != 0)
      {
        newPermissions = CDOIDUtil.createMap();
        for (int i = 0; i < size; i++)
        {
          CDOID id = in.readCDOID();
          byte bits = in.readByte();

          CDOPermission permission = CDOPermission.get(bits);
          newPermissions.put(id, permission);
        }
      }
    }

    public void write(CDODataOutput out) throws IOException
    {
      out.writeInt(senderID);
      out.writeCDOCommitInfo(commitInfo);
      out.writeBoolean(clearResourcePathCache);
      out.writeByte(securityImpact); // Must come after writeCDOCommitInfo()

      // Must come after writeCDOCommitInfo()
      if (newPermissions == null)
      {
        out.writeInt(0);
      }
      else
      {
        int size = newPermissions.size();
        out.writeInt(size);

        for (Map.Entry<CDOID, CDOPermission> entry : newPermissions.entrySet())
        {
          CDOID id = entry.getKey();
          byte bits = entry.getValue().getBits();

          out.writeCDOID(id);
          out.writeByte(bits);
        }
      }
    }

    public int getSenderID()
    {
      return senderID;
    }

    public CDOCommonSession getSender()
    {
      return sender;
    }

    public void setSender(CDOCommonSession sender)
    {
      this.sender = sender;
      senderID = sender.getSessionID();
    }

    public CDORevisionProvider getRevisionProvider()
    {
      return revisionProvider;
    }

    public void setRevisionProvider(CDORevisionProvider revisionProvider)
    {
      this.revisionProvider = revisionProvider;
    }

    public CDOCommitInfo getCommitInfo()
    {
      return commitInfo;
    }

    public void setCommitInfo(CDOCommitInfo commitInfo)
    {
      this.commitInfo = commitInfo;
    }

    public Map<CDOID, CDOPermission> getNewPermissions()
    {
      return newPermissions;
    }

    public void setNewPermissions(Map<CDOID, CDOPermission> newPermissions)
    {
      this.newPermissions = newPermissions;
    }

    public Set<? extends Object> getImpactedRules()
    {
      return impactedRules;
    }

    public void setImpactedRules(Set<? extends Object> impactedRules)
    {
      this.impactedRules = impactedRules;
    }

    public byte getSecurityImpact()
    {
      return securityImpact;
    }

    public void setSecurityImpact(byte securityImpact)
    {
      this.securityImpact = securityImpact;
    }

    public boolean isClearResourcePathCache()
    {
      return clearResourcePathCache;
    }

    public void setClearResourcePathCache(boolean clearResourcePathCache)
    {
      this.clearResourcePathCache = clearResourcePathCache;
    }
  }
}
