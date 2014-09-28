package ch.flatland.cdo.server.ldap

import org.eclipse.net4j.util.factory.ProductCreationException
import org.eclipse.net4j.util.security.UserManagerFactory

class LdapAuthenticatorFactory extends UserManagerFactory {
	
	val static TYPE = "ldap"
	
	new() {
		super(TYPE)
	}
	
	override create(String description) throws ProductCreationException {
		new LdapAuthenticatorManager(description)
	}
	
}