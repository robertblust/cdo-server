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
				String user = tables.getString(2);
				if (user.toLowerCase().equals("cdo")) {
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
