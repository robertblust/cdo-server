/*
 * Copyright (c) 2011, 2012, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.common.lob;

import org.eclipse.emf.cdo.spi.common.CDOLobStoreImpl;

import org.eclipse.net4j.util.io.ExtendedDataInput;

import java.io.IOException;
import java.io.InputStream;

/**
 * A identifiable binary large object with streaming support.
 *
 * @author Eike Stepper
 * @since 4.0
 * @apiviz.landmark
 */
public final class CDOBlob extends CDOLob<InputStream>
{
  public CDOBlob(InputStream contents) throws IOException
  {
    super(contents, CDOLobStoreImpl.INSTANCE);
  }

  public CDOBlob(InputStream contents, CDOLobStore store) throws IOException
  {
    super(contents, store);
  }

  CDOBlob(byte[] id, long size)
  {
    super(id, size);
  }

  CDOBlob(ExtendedDataInput in) throws IOException
  {
    super(in);
  }

  @Override
  public InputStream getContents() throws IOException
  {
    return getStore().getBinary(this);
  }

  @Override
  protected CDOLobInfo put(InputStream contents) throws IOException
  {
    return getStore().putBinary(contents);
  }
}
