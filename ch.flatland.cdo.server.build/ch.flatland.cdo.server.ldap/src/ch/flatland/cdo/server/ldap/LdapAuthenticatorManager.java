/*
 * Copyright (c) 2014 Robert Blust (Zürich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.server.ldap;

import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.eclipse.net4j.util.security.IAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.flatland.cdo.server.AuthenticationUtil;

public class LdapAuthenticatorManager implements IAuthenticator {

	private static final String LDAP_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	private String ldapServer = null;
	private String ldapDomainBase = null;
	private String ldapUserIdField = null;
	private boolean useSSL = false;
	private boolean faked = false;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Constructor with description of ldap server connectivity.
	 * 
	 * <code>
	 * <li><b>protocol:</b> possible values (ldap | ldaps | faked), fake means no authentication is performed
	 * <li><b>server:</b> server domain name or ip address
	 * <li><b>port:</b> port
	 * <li><b>domain base:</b> ldap node for searching the users e.g. ou=person,o=FLATLAND,c=CH
	 * <li><b>user id field:</b> the attribute name in ldap representing the user id e.g. member-id
	 * </code>
	 * 
	 * @param description
	 *            <code>protocol://server:port|domain base|user id field</code>
	 */
	public LdapAuthenticatorManager(String description) {
		initLdap(description);
		log();
	}

	public LdapAuthenticatorManager(String ldapServer, String ldapDomainBase, String ldapUserIdField) {
		this.ldapServer = ldapServer;
		this.ldapDomainBase = ldapDomainBase;
		this.ldapUserIdField = ldapUserIdField;
		if (ldapServer.startsWith("ldaps://")) {
			useSSL = true;
		}
		if (ldapServer.startsWith("faked://")) {
			faked = true;
		}
		log();
	}

	public void authenticate(String userId, char[] password) throws SecurityException {

		logger.debug("authenticate '{}'", userId);

		if (faked) {
			// NO AUTHENTICATION PERFORMED
			logger.error("!!!! NO AUTHENTICATION PERFORMED for {} !!!!", userId);
			return;
		}

		String p = new String(password);

		if (userId.equals(AuthenticationUtil.ADMIN_USER) && p.equals(AuthenticationUtil.ADMIN_PWD)) {
			return;
		}

		if (userId.equals(AuthenticationUtil.READONLY_USER) && p.equals(AuthenticationUtil.READONLY_PWD)) {
			return;
		}

		String ldapUserIdFieldFilter = ldapUserIdField + "=" + userId;

		String objectName = ldapLookupUser(ldapUserIdFieldFilter);

		String distinguishedName = objectName + "," + ldapDomainBase;
		ldapAuthenticate(distinguishedName, p);
	}

	private void ldapAuthenticate(String distinguishedName, String password) throws SecurityException {
		Hashtable<String, Object> env = new Hashtable<String, Object>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, LDAP_FACTORY);
		env.put(Context.PROVIDER_URL, ldapServer);
		if (useSSL) {
			env.put(Context.SECURITY_PROTOCOL, "ssl");
		}
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, distinguishedName);
		env.put(Context.SECURITY_CREDENTIALS, password);

		try {
			InitialDirContext ctx = new InitialDirContext(env);
			ctx.close();
		} catch (AuthenticationException ae) {
			throw new SecurityException(ae);
		} catch (NamingException ne) {
			throw new SecurityException(ne);
		}
	}

	private String ldapLookupUser(String ldapUserIdFieldFilter) throws SecurityException {
		Hashtable<String, Object> env = new Hashtable<String, Object>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, LDAP_FACTORY);
		env.put(Context.PROVIDER_URL, ldapServer);
		if (useSSL) {
			env.put(Context.SECURITY_PROTOCOL, "ssl");
		}
		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		try {

			LdapContext ctx = new InitialLdapContext(env, null);

			SearchControls searchControls = new SearchControls();

			String returnedAtts[] = {};
			searchControls.setReturningAttributes(returnedAtts);

			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			// Search for objects using the filter
			NamingEnumeration<SearchResult> answer = ctx.search(ldapDomainBase, ldapUserIdFieldFilter, searchControls);

			int i = 0;

			String objectName = null;

			while (answer.hasMoreElements()) {
				SearchResult searchResult = (SearchResult) answer.next();

				objectName = searchResult.getName();
				i++;
			}
			ctx.close();
			if (i == 1) {
				return objectName;
			} else {
				throw new SecurityException(ldapUserIdFieldFilter + " in domain base " + ldapDomainBase + " not found on " + ldapServer);
			}

		} catch (NamingException e) {
			throw new SecurityException(e);
		}
	}

	private void initLdap(String description) throws SecurityException {
		StringTokenizer tokenizer = new StringTokenizer(description, "|");

		if (tokenizer.countTokens() != 3) {
			throw new SecurityException("ldap description '" + description + "' not parsable!");
		}
		while (tokenizer.hasMoreTokens()) {
			ldapServer = tokenizer.nextToken();
			ldapDomainBase = tokenizer.nextToken();
			ldapUserIdField = tokenizer.nextToken();
		}
		if (ldapServer.startsWith("ldaps://")) {
			useSSL = true;
		}
		if (ldapServer.startsWith("faked://")) {
			faked = true;
		}
	}

	private void log() {
		logger.debug("Construct server '{}', domain base '{}', user id field '{}', use ssl '{}', faked '{}'", ldapServer, ldapDomainBase, ldapUserIdField, useSSL, faked);
	}

}
