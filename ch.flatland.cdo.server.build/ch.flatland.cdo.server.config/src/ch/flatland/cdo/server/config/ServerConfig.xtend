package ch.flatland.cdo.server.config

import ch.flatland.cdo.model.config.AuthenticatorType
import ch.flatland.cdo.model.config.Config
import ch.flatland.cdo.model.config.ConfigFactory
import ch.flatland.cdo.model.config.StoreType
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.FileReader
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.slf4j.LoggerFactory

class ServerConfig {
	val static logger = LoggerFactory.getLogger(ServerConfig)

	val static SYSTEM_PARAM = "ch.flatland.cdo.server.config"
	val static FILE_PATH = System.getProperty(SYSTEM_PARAM)
	var static Config CONFIG = null

	private new() {
		// hide constructor
	}

	def static synchronized getConfig() {
		if(CONFIG == null) {
			try {
				val configFile = readFile(FILE_PATH)
				val parser = new JsonParser
				val jsonObject = parser.parse(configFile) as JsonObject

				val template = getDefault
				template.eClass.EAllReferences.forEach [
					val eObject = template.eGet(it) as EObject
					val jsonDetailObject = jsonObject.get(it.name) as JsonObject
					logger.debug("Read config object '{}'", it.name)
					if(jsonDetailObject != null) {
						eObject.eClass.EAllAttributes.forEach [
							switch it.EAttributeType.instanceClass {
								case typeof(String): {
									if(jsonDetailObject.get(it.name) != null) {
										eObject.eSet(it, jsonDetailObject.get(it.name).asString)
									} else {
										logger.debug("Json primitive '{}' not found", it.name)
									}
								}
								case typeof(boolean): {
									if(jsonDetailObject.get(it.name) != null) {
										eObject.eSet(it, jsonDetailObject.get(it.name).asBoolean)
									} else {
										logger.debug("Json primitive '{}' not found", it.name)
									}
								}
							}
							if(it.EAttributeType instanceof EEnum) {
								val enum = it.EAttributeType as EEnum
								if(jsonDetailObject.get(it.name) != null) {
									val literal = enum.getEEnumLiteral(jsonDetailObject.get(it.name).asString)
									if(literal != null) {
										eObject.eSet(it, literal.instance)
									} else {
										logger.debug("Json primitive '{}' not found", it.name)
									}
								} else {
									logger.debug("Json primitive '{}' not found", it.name)
								}
							}
							logger.debug("Value '{}' = '{}'", it.name, eObject.eGet(it))
						]
					} else {
						logger.debug("Config object '{}' not found", it.name)
					}
				]
				CONFIG = template
			} catch(Exception e) {
				logger.debug("Could not read config file!", e)
				CONFIG = getDefault
			}
		}
		return CONFIG
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

	def private static getDefault() {
		val config = ConfigFactory.eINSTANCE.createConfig

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
			readOnlyPassword = "password"
			adminPassword = "password"
		]

		val binding = ConfigFactory.eINSTANCE.createBinding => [
			ip = "0.0.0.0"
			tcp = true
			tcpPort = "2036"
			http = true
			httpPort = "8080"
		]
		config.dataStore = dataStore
		config.authenticator = authenticator
		config.binding = binding

		return config
	}
}
