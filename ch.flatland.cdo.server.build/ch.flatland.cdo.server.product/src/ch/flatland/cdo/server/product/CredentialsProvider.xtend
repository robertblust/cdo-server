package ch.flatland.cdo.server.product

import org.eclipse.net4j.util.security.IPasswordCredentialsProvider
import org.eclipse.net4j.util.security.PasswordCredentials

class CredentialsProvider implements IPasswordCredentialsProvider {

	var String userID
	var String password

	new(String userID, String password) {
		this.userID = userID
		this.password = password
	}

	override getCredentials() {
		new PasswordCredentials(userID, password)
	}

	override isInteractive() {
		false
	}

}
