package ch.flatland.cdo.server.ldap;

import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.security.UserManagerFactory;

public class LdapAuthenticatorFactory extends UserManagerFactory {

	public static final String TYPE = "ldap";

	public LdapAuthenticatorFactory() {
		super(TYPE);
	}

	@Override
	public Object create(String description) throws ProductCreationException {
		System.out.println(description);
		LdapAuthenticatorManager manager = new LdapAuthenticatorManager();
		return manager;
	}

}
