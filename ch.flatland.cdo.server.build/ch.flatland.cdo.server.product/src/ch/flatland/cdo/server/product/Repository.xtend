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

import java.util.List
import org.eclipse.emf.cdo.net4j.CDONet4jUtil
import org.eclipse.emf.cdo.server.CDOServerUtil
import org.eclipse.emf.cdo.server.IRepository
import org.eclipse.emf.cdo.server.spi.security.InternalSecurityManager
import org.eclipse.emf.cdo.spi.server.InternalRepository
import org.eclipse.net4j.Net4jUtil
import org.eclipse.net4j.util.container.IPluginContainer
import org.eclipse.net4j.util.lifecycle.Lifecycle
import org.eclipse.net4j.util.lifecycle.LifecycleUtil
import org.eclipse.xtend.lib.annotations.Data

import static ch.flatland.cdo.server.ServerUtil.*
import static ch.flatland.cdo.server.config.ServerConfig.*

class Repository {

	private new() {
		// hide constructor
	}

	var static transient List<RepositoryInfo> repositories = newArrayList

	def static void start() {
		App.info("Start repositories")

		CONFIG.repositories.forEach [
			App.info("Start " + it.dataStore.repositoryName)
			var InternalRepository repository
			var InternalSecurityManager securityManager
			// repository store
			val repositoryProps = newHashMap(
				IRepository.Props.SUPPORTING_AUDITS -> SUPPORTING_AUDITS.toString,
				IRepository.Props.SUPPORTING_BRANCHES -> SUPPORTING_BRANCHES.toString,
				IRepository.Props.ENSURE_REFERENTIAL_INTEGRITY -> ENSURE_REFERENTIAL_INTEGRITY.toString,
				IRepository.Props.ALLOW_INTERRUPT_RUNNING_QUERIES -> "true",
				IRepository.Props.ID_GENERATION_LOCATION -> "STORE",
				IRepository.Props.SERIALIZE_COMMITS -> "false",
				IRepository.Props.OPTIMISTIC_LOCKING_TIMEOUT -> "10000",
				IRepository.Props.OVERRIDE_UUID -> it.dataStore.repositoryName
			)
			repository = CDOServerUtil.createRepository(it.dataStore.repositoryName, StoreFactory.createStore(it.dataStore.repositoryName), repositoryProps) as InternalRepository
			CDOServerUtil.addRepository(IPluginContainer.INSTANCE, repository);

			val repositoryInfo = new RepositoryInfo(repository, securityManager)
			repositories.add(repositoryInfo)

			try {
				it.dataStore.repositoryName.init
			} catch(Exception e) {
				it.dataStore.repositoryName.init
			}

		]
	}

	def static stop() {
		App.info("Stop repositories")
		repositories.forEach [
			App.info("Stop " + it.repository.name)
			val lifecycle = it.securityManager as Lifecycle
			if(lifecycle !== null) {
				lifecycle.deactivate
			}

			if(it.repository !== null) {
				LifecycleUtil.deactivate(it.repository)
			}
		]
	}

	def static init(String repositoryName) {
		val acceptorName = repositoryName + "_init";

		val acceptor = Net4jUtil.getAcceptor(IPluginContainer.INSTANCE, "jvm", acceptorName)
		val connector = Net4jUtil.getConnector(IPluginContainer.INSTANCE, "jvm", acceptorName)

		val config = CDONet4jUtil.createNet4jSessionConfiguration()
		config.setConnector(connector)
		config.setRepositoryName(repositoryName)
		config.setUserID("INIT")

		val initSession = config.openNet4jSession()
		val transaction = initSession.openTransaction
		transaction.getOrCreateResourceFolder("root")
		transaction.commit
		transaction.close
		initSession.close
		connector.close
		acceptor.close
	}
}

@Data
package class RepositoryInfo {
	InternalRepository repository
	InternalSecurityManager securityManager
}
