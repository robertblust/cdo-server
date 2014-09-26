package ch.flatland.cdo.server

import org.eclipse.emf.cdo.net4j.CDONet4jUtil
import org.eclipse.net4j.Net4jUtil
import org.eclipse.net4j.util.container.IPluginContainer
import org.eclipse.emf.cdo.session.CDOSession

class ServerUtil {
	public val static SUPPORTING_AUDITS = false
	public val static SUPPORTING_BRANCHES = false
	public val static ENSURE_REFERENTIAL_INTEGRITY = true
	public val static REPOSITORY_NAME = "repo1"
	public val static ACCEPTOR_PORT = "2036"
	
	def static openReadOnlySession() {
		val repositoryName = REPOSITORY_NAME
		val acceptorName = repositoryName + "_" + UserUtil.READONLY_USER
		
		Net4jUtil.getAcceptor(IPluginContainer.INSTANCE, "jvm", acceptorName)
		val connector = Net4jUtil.getConnector(IPluginContainer.INSTANCE, "jvm", acceptorName)

		val config = CDONet4jUtil.createNet4jSessionConfiguration()
		config.setConnector(connector)
		config.setRepositoryName(repositoryName)
		config.setUserID(UserUtil.READONLY_USER)

		config.openNet4jSession() as CDOSession
	}
}
