/*
 * Copyright (c) 2008-2013, 2015, 2016 Eike Stepper (Loehne, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.db.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import org.eclipse.net4j.db.DBType;
import org.eclipse.net4j.db.IDBAdapter;
import org.eclipse.net4j.db.ddl.IDBField;
import org.eclipse.net4j.db.ddl.IDBIndex;
import org.eclipse.net4j.db.ddl.delta.IDBIndexDelta;
import org.eclipse.net4j.spi.db.DBAdapter;

/**
 * A {@link IDBAdapter DB adapter} for <a href="http://www.mysql.com/">MySQL</a>
 * databases.
 *
 * @author Eike Stepper
 * @since 2.0
 */
public class MYSQLAdapter extends DBAdapter {
	public static final String NAME = "mysql"; //$NON-NLS-1$

	public static final String VERSION = "5.1.47"; //$NON-NLS-1$

	private static final String[] RESERVED_WORDS = { "ACCESSIBLE", "ACTION", "ADD", "ALL", "ALTER", "ANALYZE", "AND", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			"AS", //$NON-NLS-1$
			"ASC", "ASENSITIVE", "BEFORE", "BETWEEN", "BIGINT", "BINARY", "BIT", "BLOB", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"BOTH", "BY", "CALL", "CASCADE", "CASE", "CHANGE", "CHAR", "CHARACTER", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"CHECK", "COLLATE", "COLUMN", "COLUMNS", "CONDITION", "CONNECTION", "CONSTRAINT", "CONTINUE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"CONVERT", "CREATE", "CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURSOR", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"DATABASE", "DATABASES", "DATE", "DAY_HOUR", "DAY_MICROSECOND", "DAY_MINUTE", "DAY_SECOND", "DEC", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"DECIMAL", "DECLARE", "DEFAULT", "DELAYED", "DELETE", "DESC", "DESCRIBE", "DETERMINISTIC", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"DISTINCT", "DISTINCTROW", "DIV", "DOUBLE", "DROP", "DUAL", "EACH", "ELSE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"ELSEIF", "ENCLOSED", "ENUM", "ESCAPED", "EXISTS", "EXIT", "EXPLAIN", "FALSE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"FETCH", "FIELDS", "FLOAT", "FLOAT4", "FLOAT8", "FOR", "FORCE", "FOREIGN", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"FROM", "FULLTEXT", "GENERAL", "GOTO", "GRANT", "GROUP", "HAVING", "HIGH_PRIORITY", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"HOUR_MICROSECOND", "HOUR_MINUTE", "HOUR_SECOND", "IF", "IGNORE", "IGNORE_SERVER_IDS", "IN", "INDEX", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"INFILE", "INNER", "INOUT", "INSENSITIVE", "INSERT", "INT", "INT1", "INT2", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"INT3", "INT4", "INT8", "INTEGER", "INTERVAL", "INTO", "IS", "ITERATE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"JOIN", "KEY", "KEYS", "KILL", "LABEL", "LEADING", "LEAVE", "LEFT", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"LIKE", "LIMIT", "LINEAR", "LINES", "LOAD", "LOCALTIME", "LOCALTIMESTAMP", "LOCK", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"LONG", "LONGBLOB", "LONGTEXT", "LOOP", "LOW_PRIORITY", "MASTER_HEARTBEAT_PERIOD", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"MASTER_SSL_VERIFY_SERVER_CERT", "MATCH", //$NON-NLS-1$ //$NON-NLS-2$
			"MAXVALUE", "MEDIUMBLOB", "MEDIUMINT", "MEDIUMTEXT", "MIDDLEINT", "MINUTE_MICROSECOND", "MINUTE_SECOND", "MOD", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"MODIFIES", "NATURAL", "NO", "NOT", "NO_WRITE_TO_BINLOG", "NULL", "NUMERIC", "ON", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"OPTIMIZE", "OPTION", "OPTIONALLY", "OR", "ORDER", "OUT", "OUTER", "OUTFILE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"PRECISION", "PRIMARY", "PRIVILEGES", "PROCEDURE", "PURGE", "RAID0", "RANGE", "READ", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"READS", "READ_WRITE", "REAL", "REFERENCES", "REGEXP", "RELEASE", "RENAME", "REPEAT", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"REPLACE", "REQUIRE", "RESIGNAL", "RESTRICT", "RETURN", "REVOKE", "RIGHT", "RLIKE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"SCHEMA", "SCHEMAS", "SECOND_MICROSECOND", "SELECT", "SENSITIVE", "SEPARATOR", "SET", "SHOW", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"SIGNAL", "SLOW", "SMALLINT", "SONAME", "SPATIAL", "SPECIFIC", "SQL", "SQL_BIG_RESULT", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"SQL_CALC_FOUND_ROWS", "SQLEXCEPTION", "SQL_SMALL_RESULT", "SQLSTATE", "SQLWARNING", "SSL", "STARTING", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			"STRAIGHT_JOIN", //$NON-NLS-1$
			"TABLE", "TABLES", "TERMINATED", "TEXT", "THEN", "TIME", "TIMESTAMP", "TINYBLOB", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"TINYINT", "TINYTEXT", "TO", "TRAILING", "TRIGGER", "TRUE", "UNDO", "UNION", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"UNIQUE", "UNLOCK", "UNSIGNED", "UPDATE", "UPGRADE", "USAGE", "USE", "USING", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"UTC_DATE", "UTC_TIME", "UTC_TIMESTAMP", "VALUES", "VARBINARY", "VARCHAR", "VARCHARACTER", "VARYING", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"WHEN", "WHERE", "WHILE", "WITH", "WRITE", "X509", "XOR", "YEAR_MONTH", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"ZEROFILL" }; //$NON-NLS-1$

	public MYSQLAdapter() {
		super(NAME, VERSION);
	}

	/**
	 * @since 2.0
	 */
	@Override
	public int getMaxTableNameLength() {
		return 64;
	}

	/**
	 * @since 2.0
	 */
	@Override
	public int getMaxFieldNameLength() {
		return 64;
	}

	@Override
	protected String getTypeName(IDBField field) {
		DBType type = field.getType();
		switch (type) {
		case VARCHAR:
		case CLOB:
			return "LONGTEXT"; //$NON-NLS-1$
		case BLOB:
			return "LONGBLOB"; //$NON-NLS-1$
		default:
			return super.getTypeName(field);
		}
	}

	@Override
	protected void dropPrimaryKey(IDBIndex index, StringBuilder builder) {
		builder.append("ALTER TABLE "); //$NON-NLS-1$
		builder.append(index.getTable());
		builder.append(" DROP PRIMARY KEY"); //$NON-NLS-1$
	}

	@Override
	protected void addIndexField(StringBuilder builder, IDBField field) {
		super.addIndexField(builder, field);
		if (field.getType() == DBType.VARCHAR) {
			builder.append("("); //$NON-NLS-1$
			builder.append(field.getPrecision());
			builder.append(")"); //$NON-NLS-1$
		}
	}

	public String[] getReservedWords() {
		return RESERVED_WORDS;
	}

	@Override
	public boolean isTypeIndexable(DBType type) {
		switch (type) {
		case VARCHAR:
			return false;

		default:
			return super.isTypeIndexable(type);
		}
	}

	@Override
	public boolean isDuplicateKeyException(SQLException ex) {
		return "23000".equals(ex.getSQLState());
	}

	@Override
	public String sqlRenameField(IDBField field, String oldName) {
		return "ALTER TABLE " + field.getTable() + " CHANGE COLUMN " + oldName + " " + field + " " + createFieldDefinition(field);
	}

	@Override
	protected String sqlModifyField(String tableName, String fieldName, String definition) {
		return "ALTER TABLE " + tableName + " MODIFY " + fieldName + " " + definition;
	}

	/**
	 * @since 4.2
	 */
	@Override
	protected void createIndex(Connection connection, IDBIndex index, IDBIndexDelta delta) {
		// do nothing
	}
}
