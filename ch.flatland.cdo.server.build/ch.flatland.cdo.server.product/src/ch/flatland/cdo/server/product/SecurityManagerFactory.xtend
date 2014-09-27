package ch.flatland.cdo.server.product

import ch.flatland.cdo.server.AuthenticationUtil
import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.net4j.util.container.IPluginContainer

class SecurityManagerFactory {
	private new() {
		// hide constructor
	}
	
	def static createSecurityManager() {
		val authenticator = new LdapAuthenticatorManager(AuthenticationUtil.LDAP_SERVER, AuthenticationUtil.LDAP_DOMAIN_BASE, AuthenticationUtil.LDAP_USER_ID_FIELD)
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}
	
	
}