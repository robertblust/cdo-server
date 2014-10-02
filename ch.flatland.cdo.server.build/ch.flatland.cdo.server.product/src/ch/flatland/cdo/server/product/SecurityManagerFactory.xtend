package ch.flatland.cdo.server.product

import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.net4j.util.container.IPluginContainer

import static extension ch.flatland.cdo.server.AuthenticationUtil.*

class SecurityManagerFactory {
	private new() {
		// hide constructor
	}

	def static createSecurityManager() {
		val authenticator = new LdapAuthenticatorManager(LDAP_SERVER, LDAP_DOMAIN_BASE, LDAP_USER_ID_FIELD)
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}

}
