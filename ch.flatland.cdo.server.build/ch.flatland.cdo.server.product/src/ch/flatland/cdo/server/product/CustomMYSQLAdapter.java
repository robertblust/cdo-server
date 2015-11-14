package ch.flatland.cdo.server.product;

import org.eclipse.net4j.db.DBType;
import org.eclipse.net4j.db.ddl.IDBField;
import org.eclipse.net4j.db.mysql.MYSQLAdapter;

public class CustomMYSQLAdapter extends MYSQLAdapter {
	@Override
	protected String getTypeName(IDBField field) {
		DBType type = field.getType();
		/*
		 * http://dev.mysql.com/doc/refman/5.0/en/timestamp-initialization.html
		 * In addition, you can initialize or update any TIMESTAMP column to the
		 * current date and time by assigning it a NULL value, unless it has
		 * been defined with the NULL attribute to permit NULL values.
		 */
		if (type.equals(DBType.TIMESTAMP)) {
			return "TIMESTAMP NULL DEFAULT NULL";
		}
		return super.getTypeName(field);
	}
}
