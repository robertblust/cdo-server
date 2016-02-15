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
import java.io.FileInputStream
import java.util.Properties
import oracle.jdbc.pool.OracleDataSource
import org.eclipse.emf.cdo.server.db.CDODBUtil
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy
import org.eclipse.net4j.db.DBUtil
import org.h2.jdbcx.JdbcDataSource
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.server.config.ServerConfig.*

class StoreFactory {

	val static logger = LoggerFactory.getLogger(StoreFactory)

	val static CONNECTION_URL_PARAM = "ch.flatland.cdo.db.connection.url"
	val static CONNECTION_URL = System.getProperty(CONNECTION_URL_PARAM)
	val static CONNECTION_PASSWORD_PARAM = "ch.flatland.cdo.db.connection.passwd"
	val static CONNECTION_PASSWORD = System.getProperty(CONNECTION_PASSWORD_PARAM)
	val static CONNECTION_PROPS_PARAM = "ch.flatland.cdo.server.db.connection"
	val static CONNECTION_PROPS = System.getProperty(CONNECTION_PROPS_PARAM)

	private new() {
		// hide constructor
	}

	def static createStore(String repoName) {
		val info = '''
			
				--------------------------------------------------------------------
				Create Data Store 'ch.flatland.cdo.server.product'
				Repository Name: �repoName�
				Store type: �CONFIG.getByName(repoName).dataStore.storeType�
				Temporality: �CONFIG.getByName(repoName).dataStore.temporality�
				Connection url: �CONFIG.getByName(repoName).dataStore.connectionUrl�
				--------------------------------------------------------------------
		'''
		logger.info(info)
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
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(CONFIG.getByName(repoName).dataStore.temporality, false)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new JdbcDataSource
		dataSource.URL = CONFIG.getByName(repoName).dataStore.connectionUrl + CONFIG.getByName(repoName).dataStore.repositoryName
		if(CONFIG.getByName(repoName).dataStore.userName != null && CONFIG.getByName(repoName).dataStore.userName.length > 0) {
			dataSource.user = CONFIG.getByName(repoName).dataStore.userName
		}
		if(CONFIG.getByName(repoName).dataStore.password != null && CONFIG.getByName(repoName).dataStore.password.length > 0) {
			dataSource.password = CONFIG.getByName(repoName).dataStore.password
		}

		// dbAdapter
		val dbAdapter = DBUtil.getDBAdapter("h2")

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}

	def private static createMySQLStore(String repoName) {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(CONFIG.getByName(repoName).dataStore.temporality, false)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "true")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new MysqlDataSource
		if(CONNECTION_URL != null && CONNECTION_URL.length > 0) {
			dataSource.URL = CONNECTION_URL
		} else {
			dataSource.URL = CONFIG.getByName(repoName).dataStore.connectionUrl
		}
		if(CONFIG.getByName(repoName).dataStore.userName != null && CONFIG.getByName(repoName).dataStore.userName.length > 0) {
			dataSource.user = CONFIG.getByName(repoName).dataStore.userName
		}
		if(CONFIG.getByName(repoName).dataStore.password != null && CONFIG.getByName(repoName).dataStore.password.length > 0) {
			dataSource.password = CONFIG.getByName(repoName).dataStore.password
		}

		// dbAdapter
		val dbAdapter = new CustomMYSQLAdapter

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}

	def private static createOracleStore(String repoName) {

		// db mapping strategy 
		val mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(CONFIG.getByName(repoName).dataStore.temporality, false)
		val mappingProps = newHashMap(IMappingStrategy.PROP_QUALIFIED_NAMES -> "false")
		mappingStrategy.properties = mappingProps

		// db datasource
		val dataSource = new OracleDataSource
		if(CONNECTION_URL != null && CONNECTION_URL.length > 0) {
			dataSource.URL = CONNECTION_URL
		} else {
			dataSource.URL = CONFIG.getByName(repoName).dataStore.connectionUrl
		}

		if(CONNECTION_PROPS != null && CONNECTION_PROPS.length > 0) {
			val pin = new FileInputStream(CONNECTION_PROPS)
			val cnxProp = new Properties()
			cnxProp.load(pin)
			dataSource.setConnectionProperties(cnxProp)
			if (logger.isDebugEnabled) {
				dataSource.connectionProperties?.keySet.forEach[
					logger.debug("Key {} Value {}", it, dataSource.connectionProperties.get(it))
				]
			}
		}

		if(CONFIG.getByName(repoName).dataStore.userName != null && CONFIG.getByName(repoName).dataStore.userName.length > 0) {
			dataSource.user = CONFIG.getByName(repoName).dataStore.userName
		}
		if (CONNECTION_PASSWORD != null && CONNECTION_PASSWORD.length > 0) {
			dataSource.password = CONNECTION_PASSWORD
		}
		if(CONFIG.getByName(repoName).dataStore.password != null && CONFIG.getByName(repoName).dataStore.password.length > 0) {
			dataSource.password = CONFIG.getByName(repoName).dataStore.password
		}

		// dbAdapter
		val dbAdapter = new CustomOracleAdapter(CONFIG.getByName(repoName).dataStore.userName)

		// db connection
		val dbConnectionProvider = dbAdapter.createConnectionProvider(dataSource)
		val store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider)

		return store
	}
}
