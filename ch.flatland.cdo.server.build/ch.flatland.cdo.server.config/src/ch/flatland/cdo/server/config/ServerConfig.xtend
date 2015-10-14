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
package ch.flatland.cdo.server.config

import ch.flatland.cdo.model.config.AuthenticatorType
import ch.flatland.cdo.model.config.Config
import ch.flatland.cdo.model.config.ConfigFactory
import ch.flatland.cdo.model.config.StoreType
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.FileReader
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.slf4j.LoggerFactory

class ServerConfig {
	val static logger = LoggerFactory.getLogger(ServerConfig)

	val static SYSTEM_PARAM_HOST = "org.eclipse.equinox.http.jetty.http.host"
	val static HOST = System.getProperty(SYSTEM_PARAM_HOST)
	val static SYSTEM_PARAM_DB_HOST = "ch.flatland.cdo.db.host"
	val static DB_HOST = System.getProperty(SYSTEM_PARAM_DB_HOST)
	val static SYSTEM_PARAM_CONFIG = "ch.flatland.cdo.server.config"
	val static FILE_PATH = System.getProperty(SYSTEM_PARAM_CONFIG)
	val static BRIDGE_PROPERTY = "ch.flatland.cdo.server.bridge"
	val static bridgeProperty = System.getProperty(BRIDGE_PROPERTY)
	var static Config CONFIG = null

	private new() {
		// hide constructor
	}
	
	def public static isBridgeMode() {			
		if (bridgeProperty != null && bridgeProperty == "true") {
			return true
		}
		return false
	}

	def static synchronized CONFIG() {
		if(CONFIG == null) {
			try {
				val configFile = readFile(FILE_PATH)
				val parser = new JsonParser
				val jsonObject = parser.parse(configFile) as JsonObject
				
				val template = getDefaultConfig
				jsonObject.convertObject(template)
				
				template.eClass.EAllReferences.forEach [
					if(!it.many) {
						val eObject = template.eGet(it) as EObject
						val jsonDetailObject = jsonObject.get(it.name) as JsonObject
						jsonDetailObject.convertObject(eObject)
					} else {
						val jsonArray = jsonObject.get(it.name) as JsonArray
						jsonArray.forEach [
							val jsonRepoObject = it as JsonObject
							val detail = defaultRepository
							detail.eClass.EAllReferences.forEach [
								val eObject = detail.eGet(it) as EObject
								val jsonRepoDetailObject = jsonRepoObject.get(it.name) as JsonObject
								jsonRepoDetailObject.convertObject(eObject)
							]
							if(HOST != null) {
								template.binding.ip = HOST
								logger.info("Bind host ip '{}' specified by '{}'", HOST, SYSTEM_PARAM_HOST)
							}
							if(DB_HOST != null) {
								detail.dataStore.connectionUrl = detail.dataStore.connectionUrl.replace("$HOST", DB_HOST)
								logger.info("Use connection url with host replacement '{}' specified by '{}'", detail.dataStore.connectionUrl, SYSTEM_PARAM_DB_HOST)
							}
							template.repositories.add(detail)
						]
					}
				]
				CONFIG = template
			} catch(Exception e) {
				logger.debug("Could not read config file!", e)
				CONFIG = getDefaultConfig
			}
		}
		return CONFIG
	}

	def private static convertObject(JsonObject jsonObject, EObject eObject) {
		logger.debug("Read Config object '{}' not found", jsonObject)
		if(jsonObject != null) {
			eObject.eClass.EAllAttributes.forEach [
				if(jsonObject.get(it.name) != null) {
					switch it.EAttributeType.instanceClass {
						case typeof(String): {
							eObject.eSet(it, jsonObject.get(it.name).asString)
						}
						case typeof(boolean): {
							eObject.eSet(it, jsonObject.get(it.name).asBoolean)
						}
					}
					if(it.EAttributeType instanceof EEnum) {
						val enum = it.EAttributeType as EEnum
						val literal = enum.getEEnumLiteral(jsonObject.get(it.name).asString)
						if(literal != null) {
							eObject.eSet(it, literal.instance)
						} else {
							logger.debug("Json primitive '{}' not found", it.name)
						}
					}
				} else {
					logger.debug("Json primitive '{}' not found", it.name)
				}
				logger.debug("Value '{}' = '{}'", it.name, eObject.eGet(it))
			]
		} else {
			logger.debug("Config object '{}' not found", jsonObject)
		}
	}

	def private static readFile(String filePath) {
		val reader = new BufferedReader(new FileReader(filePath))
		try {
			val builder = new StringBuilder()
			var line = reader.readLine()
			while(line != null) {
				builder.append(line)
				builder.append(System.lineSeparator())
				line = reader.readLine()
			}
			return builder.toString()
		} finally {
			reader.close();
		}
	}

	def private static getDefaultConfig() {
		val config = ConfigFactory.eINSTANCE.createConfig => [
			readOnlyPassword = "password"
			adminPassword = "password"
		]

		val binding = ConfigFactory.eINSTANCE.createBinding => [
			ip = "0.0.0.0"
			tcp = true
			tcpPort = "2036"
			http = true
			httpPort = "8080"
			checkSSL = false
		]

		val json = ConfigFactory.eINSTANCE.createJson => [
			validate = false
			rreferences = false
			creferences = false
			xreferences = false
			history = false
			fullUrl = false
			meta = false
			links = false
			xlinks = false
			arrayaccessor = false
			xtraces = false
		]

		config.binding = binding
		config.json = json

		return config
	}

	def private static getDefaultRepository() {
		val repo = ConfigFactory.eINSTANCE.createRepository

		val dataStore = ConfigFactory.eINSTANCE.createDataStore => [
			storeType = StoreType.H2
			repositoryName = "repo"
			connectionUrl = "jdbc:h2:database/"
			userName = "cdo"
			password = "cdo"
		]

		val authenticator = ConfigFactory.eINSTANCE.createAuthenticator => [
			authenticatorType = AuthenticatorType.LDAP
			connectionUrl = "faked://flatland.ch:333"
			domainBase = "ou=person,o=FLATLAND,c=CH"
			userIdField = "empid"
		]

		repo.dataStore = dataStore
		repo.authenticator = authenticator

		return repo
	}
}
