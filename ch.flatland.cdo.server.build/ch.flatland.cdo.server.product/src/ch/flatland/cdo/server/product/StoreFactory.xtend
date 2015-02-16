/*
 * Copyright (c) 2014 Robert Blust (Zurich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.server.product

import ch.flatland.cdo.model.config.StoreType
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import org.eclipse.emf.cdo.server.db.CDODBUtil
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy
import org.eclipse.net4j.db.DBUtil
import org.h2.jdbcx.JdbcDataSource
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*

class StoreFactory {
	
	val static logger = LoggerFactory.getLogger(StoreFactory)
	
	private new() {
		// hide constructor
	}
	
	def static createStore() {
		if (CONFIG.dataStore.storeType == StoreType.H2) {
			logger.info("Create H2 data store")
			return createH2Store
		} else {
			logger.info("Create MYSQL data store")
			return createMySQLStore
		}
	}

	def private static createH2Store() {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, true)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new JdbcDataSource
		dataSource.setURL(CONFIG.dataStore.connectionUrl + CONFIG.dataStore.repositoryName)
		dataSource.user = CONFIG.dataStore.userName
		dataSource.password = CONFIG.dataStore.password

		// dbAdapter
		val dbAdapter = DBUtil.getDBAdapter("h2")

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}

	def private static createMySQLStore() {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, true)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new MysqlDataSource
		dataSource.setURL(CONFIG.dataStore.connectionUrl)
		dataSource.user = CONFIG.dataStore.userName
		dataSource.password = CONFIG.dataStore.password

		// dbAdapter
		val dbAdapter = new CustomMYSQLAdapter

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}
}
