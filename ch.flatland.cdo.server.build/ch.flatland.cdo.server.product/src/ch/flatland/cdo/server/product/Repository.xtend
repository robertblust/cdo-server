package ch.flatland.cdo.server.product

import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.emf.cdo.server.CDOServerUtil
import org.eclipse.emf.cdo.server.IRepository
import org.eclipse.emf.cdo.spi.server.InternalRepository
import org.eclipse.net4j.util.container.IPluginContainer
import org.eclipse.net4j.util.lifecycle.LifecycleUtil

class Repository {
	
	private new () {
		// hide constructor
	}
	
	var static transient InternalRepository REPOSITORY
	var static transient SecurityManager SECURITY_MANAGER

	def static void start() {
		App.info("Start repository")

		// repository store
		val repositoryProps = newHashMap(
			IRepository.Props.SUPPORTING_AUDITS -> "false",
			IRepository.Props.SUPPORTING_BRANCHES -> "false",
			IRepository.Props.ENSURE_REFERENTIAL_INTEGRITY -> "true",
			IRepository.Props.ALLOW_INTERRUPT_RUNNING_QUERIES -> "true",
			IRepository.Props.ID_GENERATION_LOCATION -> "STORE",
			IRepository.Props.SERIALIZE_COMMITS -> "false",
			IRepository.Props.OPTIMISTIC_LOCKING_TIMEOUT -> "10000"
		)
		
		REPOSITORY = CDOServerUtil.createRepository("repo1", StoreFactory.createStore, repositoryProps) as InternalRepository
		
		CDOServerUtil.addRepository(IPluginContainer.INSTANCE, REPOSITORY);
		
		val authenticator = new LdapAuthenticatorManager("faked://uplex1-sec-ldap.appl.ubs.ch:54636|ou=person,o=UBS,c=CH|ubs-tnumber")
		SECURITY_MANAGER = new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
		
		SECURITY_MANAGER.addCommitHandler(CommitHandlerFactory.createAnnotationCommitHandler)
		SECURITY_MANAGER.addCommitHandler(CommitHandlerFactory.createHomeCommitHandler)
		SECURITY_MANAGER.repository = REPOSITORY
		SECURITY_MANAGER.activate

	}

	def static stop() {
		App.info("Stop repository")
		SECURITY_MANAGER.deactivate
		LifecycleUtil.deactivate(REPOSITORY)
	}
}
