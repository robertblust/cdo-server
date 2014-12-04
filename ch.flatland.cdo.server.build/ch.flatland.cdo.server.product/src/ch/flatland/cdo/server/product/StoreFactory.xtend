/*
 * Copyright (c) 2014 Robert Blust (Zürich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
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
		dataSource.user = "cdo"
		dataSource.password = "cdo"

		// dbAdapter
		val dbAdapter = DBUtil.getDBAdapter("h2")

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}
}
