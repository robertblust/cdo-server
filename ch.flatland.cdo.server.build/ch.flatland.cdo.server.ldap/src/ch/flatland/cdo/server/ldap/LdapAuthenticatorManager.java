package ch.flatland.cdo.server.ldap;

import org.eclipse.net4j.util.security.IAuthenticator;

public class LdapAuthenticatorManager implements IAuthenticator {


	public void authenticate(String userID, char[] password) {
		
		String p = new String(password);

		System.out.println("userId " + userID + " password " + p);
//		synchronized (this) {
//			userPassword = users.get(userID);
//		}
//
//		if (userPassword == null) {
//			throw new SecurityException("No such user: " + userID); //$NON-NLS-1$
//		}
//
//		if (!Arrays.equals(userPassword, password)) {
//			throw new SecurityException("Wrong password for user: " + userID); //$NON-NLS-1$
//		}
	}

}
