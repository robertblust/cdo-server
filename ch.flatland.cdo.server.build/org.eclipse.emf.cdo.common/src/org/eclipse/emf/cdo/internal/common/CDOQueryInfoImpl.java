/*
 * Copyright (c) 2009-2013, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.internal.common;

import org.eclipse.emf.cdo.common.commit.CDOChangeSetData;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.util.CDOQueryInfo;
import org.eclipse.emf.cdo.common.util.CDOClassNotFoundException;
import org.eclipse.emf.cdo.common.util.CDOPackageNotFoundException;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Simon McDuff
 */
public class CDOQueryInfoImpl implements CDOQueryInfo
{
  protected String queryLanguage;

  protected String queryString;

  protected Object context;

  protected Map<String, Object> parameters = new HashMap<String, Object>();

  protected int maxResults = UNLIMITED_RESULTS;

  protected CDOChangeSetData changeSetData;

  public CDOQueryInfoImpl(String queryLanguage, String queryString, Object context)
  {
    this.queryLanguage = queryLanguage;
    this.queryString = queryString;
    this.context = context;
  }

  public CDOQueryInfoImpl(CDODataInput in) throws IOException
  {
    queryLanguage = in.readString();
    queryString = in.readString();

    try
    {
      context = in.readCDORevisionOrPrimitiveOrClassifier();
    }
    catch (CDOPackageNotFoundException e)
    {
      //$FALL-THROUGH$
    }
    catch (CDOClassNotFoundException e)
    {
      //$FALL-THROUGH$
    }
    
    maxResults = in.readInt();

    if (in.readBoolean())
    {
      changeSetData = in.readCDOChangeSetData();
    }

    int size = in.readInt();
    for (int i = 0; i < size; i++)
    {
      String key = in.readString();
      try
      {
        Object object = in.readCDORevisionOrPrimitiveOrClassifier();
        parameters.put(key, object);
      }
      catch (CDOPackageNotFoundException e)
      {
        //$FALL-THROUGH$
      }
      catch (CDOClassNotFoundException e)
      {
        //$FALL-THROUGH$
      }
    }
  }

  public void write(CDODataOutput out) throws IOException
  {
    out.writeString(queryLanguage);
    out.writeString(queryString);
    out.writeCDORevisionOrPrimitiveOrClassifier(context);
    out.writeInt(maxResults);

    if (changeSetData != null)
    {
      out.writeBoolean(true);
      out.writeCDOChangeSetData(changeSetData);
    }
    else
    {
      out.writeBoolean(false);
    }

    out.writeInt(parameters.size());
    for (Entry<String, Object> entry : parameters.entrySet())
    {
      out.writeString(entry.getKey());
      out.writeCDORevisionOrPrimitiveOrClassifier(entry.getValue());
    }
  }

  public String getQueryString()
  {
    return queryString;
  }

  public String getQueryLanguage()
  {
    return queryLanguage;
  }

  public Map<String, Object> getParameters()
  {
    return Collections.unmodifiableMap(parameters);
  }

  public Object getContext()
  {
    return context;
  }

  public CDOQueryInfoImpl setContext(Object context)
  {
    this.context = context;
    return this;
  }

  public void addParameter(String key, Object value)
  {
    parameters.put(key, value);
  }

  public int getMaxResults()
  {
    return maxResults;
  }

  public CDOQueryInfoImpl setMaxResults(int maxResults)
  {
    this.maxResults = maxResults;
    return this;
  }

  @Deprecated
  public boolean isLegacyModeEnabled()
  {
    return true;
  }

  public CDOChangeSetData getChangeSetData()
  {
    return changeSetData;
  }

  public void setChangeSetData(CDOChangeSetData changeSetData)
  {
    this.changeSetData = changeSetData;
  }
}
