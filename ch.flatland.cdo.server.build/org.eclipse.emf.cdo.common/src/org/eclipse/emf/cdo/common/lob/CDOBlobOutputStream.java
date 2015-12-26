/*
 * Copyright (c) 2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Christian W. Damus (CEA LIST) - initial API and implementation
 */
package org.eclipse.emf.cdo.common.lob;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * An {@link OutputStream} that produces a {@link #getBlob() CDOBlob}.
 *
 * @author Christian W. Damus (CEA LIST)
 * @since 4.3
 */
public class CDOBlobOutputStream extends OutputStream
{
  private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

  private CDOBlob blob;

  @Override
  public void write(int b) throws IOException
  {
    checkBuffer();
    buffer.write(b);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException
  {
    checkBuffer();
    buffer.write(b, off, len);
  }

  @Override
  public void close() throws IOException
  {
    if (buffer != null)
    {
      blob = new CDOBlob(new ByteArrayInputStream(buffer.toByteArray()));
      buffer = null;
    }
  }

  @Override
  public void flush() throws IOException
  {
    checkBuffer();
    buffer.flush();
  }

  public CDOBlob getBlob()
  {
    return blob;
  }

  void checkBuffer() throws IOException
  {
    if (buffer == null)
    {
      throw new IOException("CDOBlobOutputStream closed"); //$NON-NLS-1$
    }
  }
}
