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
import oracle.jdbc.pool.OracleDataSource
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

	def static createStore(String repoName) {
		val info = '''
			--------------------------------------------------------------------
			Create Data Store 'ch.flatland.cdo.server.product'
			Store type: «CONFIG.getByName(repoName).dataStore.storeType»
			Connection url: «CONFIG.getByName(repoName).dataStore.connectionUrl»
			--------------------------------------------------------------------
		'''
		println(info)
		if(CONFIG.getByName(repoName).dataStore.storeType == StoreType.H2) {
			logger.info("Create H2 data store")
			return createH2Store(repoName)
		}
		if(CONFIG.getByName(repoName).dataStore.storeType == StoreType.MYSQL) {
			logger.info("Create MYSQL data store")
			return createMySQLStore(repoName)
		}
		if(CONFIG.getByName(repoName).dataStore.storeType == StoreType.ORACLE) {
			logger.info("Create ORACLE data store")
			return createOracleStore(repoName)
		}
	}

	def private static createH2Store(String repoName) {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, false)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new JdbcDataSource
		dataSource.URL = CONFIG.getByName(repoName).dataStore.connectionUrl + CONFIG.getByName(repoName).dataStore.repositoryName
		dataSource.user = CONFIG.getByName(repoName).dataStore.userName
		dataSource.password = CONFIG.getByName(repoName).dataStore.password

		// dbAdapter
		val dbAdapter = DBUtil.getDBAdapter("h2")

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}

	def private static createMySQLStore(String repoName) {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, false)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new MysqlDataSource
		dataSource.URL = CONFIG.getByName(repoName).dataStore.connectionUrl
		dataSource.user = CONFIG.getByName(repoName).dataStore.userName
		dataSource.password = CONFIG.getByName(repoName).dataStore.password

		// dbAdapter
		val dbAdapter = new CustomMYSQLAdapter

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}

	def private static createOracleStore(String repoName) {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, false)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new OracleDataSource
		dataSource.URL = CONFIG.getByName(repoName).dataStore.connectionUrl
		dataSource.user = CONFIG.getByName(repoName).dataStore.userName
		dataSource.password = CONFIG.getByName(repoName).dataStore.password

		// dbAdapter
		val dbAdapter = new CustomOracleAdapter(CONFIG.getByName(repoName).dataStore.userName)

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}
}
