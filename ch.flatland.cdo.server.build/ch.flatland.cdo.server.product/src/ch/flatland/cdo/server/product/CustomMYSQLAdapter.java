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

	/**
	 * Overloaded to reduce precision
	 * 
	 * http://bugs.mysql.com/bug.php?id=71613
	 * https://www.eclipse.org/forums/index.php/t/795487/
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=439772
	 * 
	 * @param builder
	 * @param field
	 */
	@Override
	protected void addIndexField(StringBuilder builder, IDBField field) {
		builder.append(field);
		if (field.getType() == DBType.VARCHAR) {
			builder.append("(");
			int precision = field.getPrecision();
			if (precision > 767) {
				precision = 767;
			}
			builder.append(precision);
			builder.append(")"); //$NON-NLS-1$
		}
	}
}
