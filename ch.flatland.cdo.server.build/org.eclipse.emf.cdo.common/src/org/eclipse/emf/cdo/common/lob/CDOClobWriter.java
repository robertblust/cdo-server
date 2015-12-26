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

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * A {@link Writer} that produces a {@link #getClob() CDOClob}.
 *
 * @author Christian W. Damus (CEA LIST)
 * @since 4.3
 */
public class CDOClobWriter extends Writer
{
  private StringWriter buffer = new StringWriter();

  private CDOClob clob;

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException
  {
    checkBuffer();
    buffer.write(cbuf, off, len);
  }

  @Override
  public void close() throws IOException
  {
    if (buffer != null)
    {
      clob = new CDOClob(new StringReader(buffer.toString()));
      buffer = null;
    }
  }

  @Override
  public void flush() throws IOException
  {
    checkBuffer();
    buffer.flush();
  }

  public CDOClob getClob()
  {
    return clob;
  }

  void checkBuffer() throws IOException
  {
    if (buffer == null)
    {
      throw new IOException("CDOClobWriter closed"); //$NON-NLS-1$
    }
  }
}
