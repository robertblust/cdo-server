package ch.flatland.cdo.server.product

import org.eclipse.emf.cdo.server.db.CDODBUtil
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy
import org.eclipse.net4j.db.DBUtil
import org.h2.jdbcx.JdbcDataSource
import ch.flatland.cdo.server.ServerUtil

class StoreFactory {
	private new() {
		// hide constructor
	}

	def static createStore() {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, true)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new JdbcDataSource()
		dataSource.setURL("jdbc:h2:database/" + ServerUtil.REPOSITORY_NAME)

		// dbAdapter
		val dbAdapter = DBUtil.getDBAdapter("h2")

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}
}
