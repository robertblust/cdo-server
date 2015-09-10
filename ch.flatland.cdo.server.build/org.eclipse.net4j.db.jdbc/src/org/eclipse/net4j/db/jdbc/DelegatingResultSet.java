/*
 * Copyright (c) 2013 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.db.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class DelegatingResultSet implements ResultSet
{
  private final ResultSet delegate;

  private final PreparedStatement preparedStatement;

  public DelegatingResultSet(ResultSet delegate, PreparedStatement preparedStatement)
  {
    this.delegate = delegate;
    this.preparedStatement = preparedStatement;
  }

  public final ResultSet getDelegate()
  {
    return delegate;
  }

  public PreparedStatement getStatement() throws SQLException
  {
    return preparedStatement;
  }

  public boolean next() throws SQLException
  {
    return delegate.next();
  }

  public void close() throws SQLException
  {
    delegate.close();
  }

  public boolean wasNull() throws SQLException
  {
    return delegate.wasNull();
  }

  public String getString(int columnIndex) throws SQLException
  {
    return delegate.getString(columnIndex);
  }

  public boolean getBoolean(int columnIndex) throws SQLException
  {
    return delegate.getBoolean(columnIndex);
  }

  public byte getByte(int columnIndex) throws SQLException
  {
    return delegate.getByte(columnIndex);
  }

  public short getShort(int columnIndex) throws SQLException
  {
    return delegate.getShort(columnIndex);
  }

  public int getInt(int columnIndex) throws SQLException
  {
    return delegate.getInt(columnIndex);
  }

  public long getLong(int columnIndex) throws SQLException
  {
    return delegate.getLong(columnIndex);
  }

  public float getFloat(int columnIndex) throws SQLException
  {
    return delegate.getFloat(columnIndex);
  }

  public double getDouble(int columnIndex) throws SQLException
  {
    return delegate.getDouble(columnIndex);
  }

  @Deprecated
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException
  {
    return delegate.getBigDecimal(columnIndex, scale);
  }

  public byte[] getBytes(int columnIndex) throws SQLException
  {
    return delegate.getBytes(columnIndex);
  }

  public Date getDate(int columnIndex) throws SQLException
  {
    return delegate.getDate(columnIndex);
  }

  public Time getTime(int columnIndex) throws SQLException
  {
    return delegate.getTime(columnIndex);
  }

  public Timestamp getTimestamp(int columnIndex) throws SQLException
  {
    return delegate.getTimestamp(columnIndex);
  }

  public InputStream getAsciiStream(int columnIndex) throws SQLException
  {
    return delegate.getAsciiStream(columnIndex);
  }

  @Deprecated
  public InputStream getUnicodeStream(int columnIndex) throws SQLException
  {
    return delegate.getUnicodeStream(columnIndex);
  }

  public InputStream getBinaryStream(int columnIndex) throws SQLException
  {
    return delegate.getBinaryStream(columnIndex);
  }

  public String getString(String columnLabel) throws SQLException
  {
    return delegate.getString(columnLabel);
  }

  public boolean getBoolean(String columnLabel) throws SQLException
  {
    return delegate.getBoolean(columnLabel);
  }

  public byte getByte(String columnLabel) throws SQLException
  {
    return delegate.getByte(columnLabel);
  }

  public short getShort(String columnLabel) throws SQLException
  {
    return delegate.getShort(columnLabel);
  }

  public int getInt(String columnLabel) throws SQLException
  {
    return delegate.getInt(columnLabel);
  }

  public long getLong(String columnLabel) throws SQLException
  {
    return delegate.getLong(columnLabel);
  }

  public float getFloat(String columnLabel) throws SQLException
  {
    return delegate.getFloat(columnLabel);
  }

  public double getDouble(String columnLabel) throws SQLException
  {
    return delegate.getDouble(columnLabel);
  }

  @Deprecated
  public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException
  {
    return delegate.getBigDecimal(columnLabel, scale);
  }

  public byte[] getBytes(String columnLabel) throws SQLException
  {
    return delegate.getBytes(columnLabel);
  }

  public Date getDate(String columnLabel) throws SQLException
  {
    return delegate.getDate(columnLabel);
  }

  public Time getTime(String columnLabel) throws SQLException
  {
    return delegate.getTime(columnLabel);
  }

  public Timestamp getTimestamp(String columnLabel) throws SQLException
  {
    return delegate.getTimestamp(columnLabel);
  }

  public InputStream getAsciiStream(String columnLabel) throws SQLException
  {
    return delegate.getAsciiStream(columnLabel);
  }

  @Deprecated
  public InputStream getUnicodeStream(String columnLabel) throws SQLException
  {
    return delegate.getUnicodeStream(columnLabel);
  }

  public InputStream getBinaryStream(String columnLabel) throws SQLException
  {
    return delegate.getBinaryStream(columnLabel);
  }

  public SQLWarning getWarnings() throws SQLException
  {
    return delegate.getWarnings();
  }

  public void clearWarnings() throws SQLException
  {
    delegate.clearWarnings();
  }

  public String getCursorName() throws SQLException
  {
    return delegate.getCursorName();
  }

  public ResultSetMetaData getMetaData() throws SQLException
  {
    return delegate.getMetaData();
  }

  public Object getObject(int columnIndex) throws SQLException
  {
    return delegate.getObject(columnIndex);
  }

  public Object getObject(String columnLabel) throws SQLException
  {
    return delegate.getObject(columnLabel);
  }

  public int findColumn(String columnLabel) throws SQLException
  {
    return delegate.findColumn(columnLabel);
  }

  public Reader getCharacterStream(int columnIndex) throws SQLException
  {
    return delegate.getCharacterStream(columnIndex);
  }

  public Reader getCharacterStream(String columnLabel) throws SQLException
  {
    return delegate.getCharacterStream(columnLabel);
  }

  public BigDecimal getBigDecimal(int columnIndex) throws SQLException
  {
    return delegate.getBigDecimal(columnIndex);
  }

  public BigDecimal getBigDecimal(String columnLabel) throws SQLException
  {
    return delegate.getBigDecimal(columnLabel);
  }

  public boolean isBeforeFirst() throws SQLException
  {
    return delegate.isBeforeFirst();
  }

  public boolean isAfterLast() throws SQLException
  {
    return delegate.isAfterLast();
  }

  public boolean isFirst() throws SQLException
  {
    return delegate.isFirst();
  }

  public boolean isLast() throws SQLException
  {
    return delegate.isLast();
  }

  public void beforeFirst() throws SQLException
  {
    delegate.beforeFirst();
  }

  public void afterLast() throws SQLException
  {
    delegate.afterLast();
  }

  public boolean first() throws SQLException
  {
    return delegate.first();
  }

  public boolean last() throws SQLException
  {
    return delegate.last();
  }

  public int getRow() throws SQLException
  {
    return delegate.getRow();
  }

  public boolean absolute(int row) throws SQLException
  {
    return delegate.absolute(row);
  }

  public boolean relative(int rows) throws SQLException
  {
    return delegate.relative(rows);
  }

  public boolean previous() throws SQLException
  {
    return delegate.previous();
  }

  public void setFetchDirection(int direction) throws SQLException
  {
    delegate.setFetchDirection(direction);
  }

  public int getFetchDirection() throws SQLException
  {
    return delegate.getFetchDirection();
  }

  public void setFetchSize(int rows) throws SQLException
  {
    delegate.setFetchSize(rows);
  }

  public int getFetchSize() throws SQLException
  {
    return delegate.getFetchSize();
  }

  public int getType() throws SQLException
  {
    return delegate.getType();
  }

  public int getConcurrency() throws SQLException
  {
    return delegate.getConcurrency();
  }

  public boolean rowUpdated() throws SQLException
  {
    return delegate.rowUpdated();
  }

  public boolean rowInserted() throws SQLException
  {
    return delegate.rowInserted();
  }

  public boolean rowDeleted() throws SQLException
  {
    return delegate.rowDeleted();
  }

  public void updateNull(int columnIndex) throws SQLException
  {
    delegate.updateNull(columnIndex);
  }

  public void updateBoolean(int columnIndex, boolean x) throws SQLException
  {
    delegate.updateBoolean(columnIndex, x);
  }

  public void updateByte(int columnIndex, byte x) throws SQLException
  {
    delegate.updateByte(columnIndex, x);
  }

  public void updateShort(int columnIndex, short x) throws SQLException
  {
    delegate.updateShort(columnIndex, x);
  }

  public void updateInt(int columnIndex, int x) throws SQLException
  {
    delegate.updateInt(columnIndex, x);
  }

  public void updateLong(int columnIndex, long x) throws SQLException
  {
    delegate.updateLong(columnIndex, x);
  }

  public void updateFloat(int columnIndex, float x) throws SQLException
  {
    delegate.updateFloat(columnIndex, x);
  }

  public void updateDouble(int columnIndex, double x) throws SQLException
  {
    delegate.updateDouble(columnIndex, x);
  }

  public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException
  {
    delegate.updateBigDecimal(columnIndex, x);
  }

  public void updateString(int columnIndex, String x) throws SQLException
  {
    delegate.updateString(columnIndex, x);
  }

  public void updateBytes(int columnIndex, byte[] x) throws SQLException
  {
    delegate.updateBytes(columnIndex, x);
  }

  public void updateDate(int columnIndex, Date x) throws SQLException
  {
    delegate.updateDate(columnIndex, x);
  }

  public void updateTime(int columnIndex, Time x) throws SQLException
  {
    delegate.updateTime(columnIndex, x);
  }

  public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException
  {
    delegate.updateTimestamp(columnIndex, x);
  }

  public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException
  {
    delegate.updateAsciiStream(columnIndex, x, length);
  }

  public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException
  {
    delegate.updateBinaryStream(columnIndex, x, length);
  }

  public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException
  {
    delegate.updateCharacterStream(columnIndex, x, length);
  }

  public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException
  {
    delegate.updateObject(columnIndex, x, scaleOrLength);
  }

  public void updateObject(int columnIndex, Object x) throws SQLException
  {
    delegate.updateObject(columnIndex, x);
  }

  public void updateNull(String columnLabel) throws SQLException
  {
    delegate.updateNull(columnLabel);
  }

  public void updateBoolean(String columnLabel, boolean x) throws SQLException
  {
    delegate.updateBoolean(columnLabel, x);
  }

  public void updateByte(String columnLabel, byte x) throws SQLException
  {
    delegate.updateByte(columnLabel, x);
  }

  public void updateShort(String columnLabel, short x) throws SQLException
  {
    delegate.updateShort(columnLabel, x);
  }

  public void updateInt(String columnLabel, int x) throws SQLException
  {
    delegate.updateInt(columnLabel, x);
  }

  public void updateLong(String columnLabel, long x) throws SQLException
  {
    delegate.updateLong(columnLabel, x);
  }

  public void updateFloat(String columnLabel, float x) throws SQLException
  {
    delegate.updateFloat(columnLabel, x);
  }

  public void updateDouble(String columnLabel, double x) throws SQLException
  {
    delegate.updateDouble(columnLabel, x);
  }

  public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException
  {
    delegate.updateBigDecimal(columnLabel, x);
  }

  public void updateString(String columnLabel, String x) throws SQLException
  {
    delegate.updateString(columnLabel, x);
  }

  public void updateBytes(String columnLabel, byte[] x) throws SQLException
  {
    delegate.updateBytes(columnLabel, x);
  }

  public void updateDate(String columnLabel, Date x) throws SQLException
  {
    delegate.updateDate(columnLabel, x);
  }

  public void updateTime(String columnLabel, Time x) throws SQLException
  {
    delegate.updateTime(columnLabel, x);
  }

  public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException
  {
    delegate.updateTimestamp(columnLabel, x);
  }

  public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException
  {
    delegate.updateAsciiStream(columnLabel, x, length);
  }

  public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException
  {
    delegate.updateBinaryStream(columnLabel, x, length);
  }

  public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException
  {
    delegate.updateCharacterStream(columnLabel, reader, length);
  }

  public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException
  {
    delegate.updateObject(columnLabel, x, scaleOrLength);
  }

  public void updateObject(String columnLabel, Object x) throws SQLException
  {
    delegate.updateObject(columnLabel, x);
  }

  public void insertRow() throws SQLException
  {
    delegate.insertRow();
  }

  public void updateRow() throws SQLException
  {
    delegate.updateRow();
  }

  public void deleteRow() throws SQLException
  {
    delegate.deleteRow();
  }

  public void refreshRow() throws SQLException
  {
    delegate.refreshRow();
  }

  public void cancelRowUpdates() throws SQLException
  {
    delegate.cancelRowUpdates();
  }

  public void moveToInsertRow() throws SQLException
  {
    delegate.moveToInsertRow();
  }

  public void moveToCurrentRow() throws SQLException
  {
    delegate.moveToCurrentRow();
  }

  public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException
  {
    return delegate.getObject(columnIndex, map);
  }

  public Ref getRef(int columnIndex) throws SQLException
  {
    return delegate.getRef(columnIndex);
  }

  public Blob getBlob(int columnIndex) throws SQLException
  {
    return delegate.getBlob(columnIndex);
  }

  public Clob getClob(int columnIndex) throws SQLException
  {
    return delegate.getClob(columnIndex);
  }

  public Array getArray(int columnIndex) throws SQLException
  {
    return delegate.getArray(columnIndex);
  }

  public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException
  {
    return delegate.getObject(columnLabel, map);
  }

  public Ref getRef(String columnLabel) throws SQLException
  {
    return delegate.getRef(columnLabel);
  }

  public Blob getBlob(String columnLabel) throws SQLException
  {
    return delegate.getBlob(columnLabel);
  }

  public Clob getClob(String columnLabel) throws SQLException
  {
    return delegate.getClob(columnLabel);
  }

  public Array getArray(String columnLabel) throws SQLException
  {
    return delegate.getArray(columnLabel);
  }

  public Date getDate(int columnIndex, Calendar cal) throws SQLException
  {
    return delegate.getDate(columnIndex, cal);
  }

  public Date getDate(String columnLabel, Calendar cal) throws SQLException
  {
    return delegate.getDate(columnLabel, cal);
  }

  public Time getTime(int columnIndex, Calendar cal) throws SQLException
  {
    return delegate.getTime(columnIndex, cal);
  }

  public Time getTime(String columnLabel, Calendar cal) throws SQLException
  {
    return delegate.getTime(columnLabel, cal);
  }

  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException
  {
    return delegate.getTimestamp(columnIndex, cal);
  }

  public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException
  {
    return delegate.getTimestamp(columnLabel, cal);
  }

  public URL getURL(int columnIndex) throws SQLException
  {
    return delegate.getURL(columnIndex);
  }

  public URL getURL(String columnLabel) throws SQLException
  {
    return delegate.getURL(columnLabel);
  }

  public void updateRef(int columnIndex, Ref x) throws SQLException
  {
    delegate.updateRef(columnIndex, x);
  }

  public void updateRef(String columnLabel, Ref x) throws SQLException
  {
    delegate.updateRef(columnLabel, x);
  }

  public void updateBlob(int columnIndex, Blob x) throws SQLException
  {
    delegate.updateBlob(columnIndex, x);
  }

  public void updateBlob(String columnLabel, Blob x) throws SQLException
  {
    delegate.updateBlob(columnLabel, x);
  }

  public void updateClob(int columnIndex, Clob x) throws SQLException
  {
    delegate.updateClob(columnIndex, x);
  }

  public void updateClob(String columnLabel, Clob x) throws SQLException
  {
    delegate.updateClob(columnLabel, x);
  }

  public void updateArray(int columnIndex, Array x) throws SQLException
  {
    delegate.updateArray(columnIndex, x);
  }

  public void updateArray(String columnLabel, Array x) throws SQLException
  {
    delegate.updateArray(columnLabel, x);
  }

  /**
   * Since JDK 1.6.
   */
  public <T> T unwrap(Class<T> iface) throws SQLException
  {
    return delegate.unwrap(iface);
  }

  /**
   * Since JDK 1.6.
   */
  public boolean isWrapperFor(Class<?> iface) throws SQLException
  {
    return delegate.isWrapperFor(iface);
  }

  /**
   * Since JDK 1.6.
   */
  public java.sql.RowId getRowId(int columnIndex) throws SQLException
  {
    return delegate.getRowId(columnIndex);
  }

  /**
   * Since JDK 1.6.
   */
  public java.sql.RowId getRowId(String columnLabel) throws SQLException
  {
    return delegate.getRowId(columnLabel);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateRowId(int columnIndex, java.sql.RowId x) throws SQLException
  {
    delegate.updateRowId(columnIndex, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateRowId(String columnLabel, java.sql.RowId x) throws SQLException
  {
    delegate.updateRowId(columnLabel, x);
  }

  /**
   * Since JDK 1.6.
   */
  public int getHoldability() throws SQLException
  {
    return delegate.getHoldability();
  }

  /**
   * Since JDK 1.6.
   */
  public boolean isClosed() throws SQLException
  {
    return delegate.isClosed();
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNString(int columnIndex, String nString) throws SQLException
  {
    delegate.updateNString(columnIndex, nString);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNString(String columnLabel, String nString) throws SQLException
  {
    delegate.updateNString(columnLabel, nString);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNClob(int columnIndex, java.sql.NClob nClob) throws SQLException
  {
    delegate.updateNClob(columnIndex, nClob);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNClob(String columnLabel, java.sql.NClob nClob) throws SQLException
  {
    delegate.updateNClob(columnLabel, nClob);
  }

  /**
   * Since JDK 1.6.
   */
  public java.sql.NClob getNClob(int columnIndex) throws SQLException
  {
    return delegate.getNClob(columnIndex);
  }

  /**
   * Since JDK 1.6.
   */
  public java.sql.NClob getNClob(String columnLabel) throws SQLException
  {
    return delegate.getNClob(columnLabel);
  }

  /**
   * Since JDK 1.6.
   */
  public java.sql.SQLXML getSQLXML(int columnIndex) throws SQLException
  {
    return delegate.getSQLXML(columnIndex);
  }

  /**
   * Since JDK 1.6.
   */
  public java.sql.SQLXML getSQLXML(String columnLabel) throws SQLException
  {
    return delegate.getSQLXML(columnLabel);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateSQLXML(int columnIndex, java.sql.SQLXML xmlObject) throws SQLException
  {
    delegate.updateSQLXML(columnIndex, xmlObject);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateSQLXML(String columnLabel, java.sql.SQLXML xmlObject) throws SQLException
  {
    delegate.updateSQLXML(columnLabel, xmlObject);
  }

  /**
   * Since JDK 1.6.
   */
  public String getNString(int columnIndex) throws SQLException
  {
    return delegate.getNString(columnIndex);
  }

  /**
   * Since JDK 1.6.
   */
  public String getNString(String columnLabel) throws SQLException
  {
    return delegate.getNString(columnLabel);
  }

  /**
   * Since JDK 1.6.
   */
  public Reader getNCharacterStream(int columnIndex) throws SQLException
  {
    return delegate.getNCharacterStream(columnIndex);
  }

  /**
   * Since JDK 1.6.
   */
  public Reader getNCharacterStream(String columnLabel) throws SQLException
  {
    return delegate.getNCharacterStream(columnLabel);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException
  {
    delegate.updateNCharacterStream(columnIndex, x, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException
  {
    delegate.updateNCharacterStream(columnLabel, reader, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException
  {
    delegate.updateAsciiStream(columnIndex, x, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException
  {
    delegate.updateBinaryStream(columnIndex, x, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException
  {
    delegate.updateCharacterStream(columnIndex, x, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException
  {
    delegate.updateAsciiStream(columnLabel, x, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException
  {
    delegate.updateBinaryStream(columnLabel, x, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException
  {
    delegate.updateCharacterStream(columnLabel, reader, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException
  {
    delegate.updateBlob(columnIndex, inputStream, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException
  {
    delegate.updateBlob(columnLabel, inputStream, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateClob(int columnIndex, Reader reader, long length) throws SQLException
  {
    delegate.updateClob(columnIndex, reader, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateClob(String columnLabel, Reader reader, long length) throws SQLException
  {
    delegate.updateClob(columnLabel, reader, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException
  {
    delegate.updateNClob(columnIndex, reader, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException
  {
    delegate.updateNClob(columnLabel, reader, length);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException
  {
    delegate.updateNCharacterStream(columnIndex, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException
  {
    delegate.updateNCharacterStream(columnLabel, reader);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException
  {
    delegate.updateAsciiStream(columnIndex, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException
  {
    delegate.updateBinaryStream(columnIndex, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateCharacterStream(int columnIndex, Reader x) throws SQLException
  {
    delegate.updateCharacterStream(columnIndex, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException
  {
    delegate.updateAsciiStream(columnLabel, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException
  {
    delegate.updateBinaryStream(columnLabel, x);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException
  {
    delegate.updateCharacterStream(columnLabel, reader);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException
  {
    delegate.updateBlob(columnIndex, inputStream);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException
  {
    delegate.updateBlob(columnLabel, inputStream);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateClob(int columnIndex, Reader reader) throws SQLException
  {
    delegate.updateClob(columnIndex, reader);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateClob(String columnLabel, Reader reader) throws SQLException
  {
    delegate.updateClob(columnLabel, reader);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNClob(int columnIndex, Reader reader) throws SQLException
  {
    delegate.updateNClob(columnIndex, reader);
  }

  /**
   * Since JDK 1.6.
   */
  public void updateNClob(String columnLabel, Reader reader) throws SQLException
  {
    delegate.updateNClob(columnLabel, reader);
  }

  /**
   * Since JDK 1.7.
   */
  public <T> T getObject(int columnIndex, Class<T> type) throws SQLException
  {
    return delegate.getObject(columnIndex, type);
  }

  /**
   * Since JDK 1.7.
   */
  public <T> T getObject(String columnLabel, Class<T> type) throws SQLException
  {
    return delegate.getObject(columnLabel, type);
  }
}
