package ch.flatland.cdo.server.product

import ch.flatland.cdo.server.ldap.LdapAuthenticatorManager
import org.eclipse.net4j.util.container.IPluginContainer

class SecurityManagerFactory {
	private new() {
		// hide constructor
	}
	
	// network config
	val static LDAP_SERVER = "ldaps://flatland.ch:333"
	val static LDAP_DOMAIN_BASE = "ou=person,o=FLATLAND,c=CH"
	val static LDAP_USER_ID_FIELD = "empid"
	
	def static createSecurityManager() {
		val authenticator = new LdapAuthenticatorManager(LDAP_SERVER, LDAP_DOMAIN_BASE, LDAP_USER_ID_FIELD)
		return new SecurityManager("/security", IPluginContainer.INSTANCE, authenticator)
	}
	
	
}