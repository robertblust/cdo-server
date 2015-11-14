package ch.flatland.cdo.server.product;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.eclipse.net4j.db.DBException;
import org.eclipse.net4j.db.DBUtil;
import org.eclipse.net4j.db.ddl.IDBSchema;
import org.eclipse.net4j.db.ddl.IDBTable;
import org.eclipse.net4j.db.oracle.OracleAdapter;
import org.eclipse.net4j.internal.db.ddl.DBField;

@SuppressWarnings("restriction")
public class CustomOracleAdapter extends OracleAdapter {

	private String user;

	public CustomOracleAdapter(String user) {
		this.user = user;
	}

	@Override
	public void readSchema(Connection connection, IDBSchema schema) {
		try {
			DBField.trackConstruction(false);
			String schemaName = schema.getName();

			DatabaseMetaData metaData = connection.getMetaData();
			Set<String> schemaNames = DBUtil.getAllSchemaNames(metaData);
			if (!schemaNames.contains(schemaName)) {
				schemaName = null;
			}

			ResultSet tables = readTables(connection, metaData, schemaName);
			while (tables.next()) {
				String tableName = tables.getString(3);

				IDBTable table = schema.addTable(tableName);
				String dbUser = tables.getString(2);

				/**
				 * BUG FIX CSMDR-32 Only if the DB schema is owned by the user
				 * connecting to oracle, the schema should be analyzed. To be
				 * sure the user matches, the check must be done with both end
				 * toLowerCase cause oracle user names are not case sensitive.
				 */
				if (dbUser.toLowerCase().equals(user.toLowerCase())) {
					readFields(connection, table);
					readIndices(connection, metaData, table, schemaName);
				}

			}
		} catch (SQLException ex) {
			throw new DBException(ex);
		} finally {
			DBField.trackConstruction(true);
		}
	}
}
