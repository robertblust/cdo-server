package ch.flatland.cdo.service.tests

import ch.flatland.cdo.util.Request
import com.eclipsesource.restfuse.Destination
import org.apache.commons.codec.binary.Base64

abstract class AbstractTestCase {

	val static private USER_READONLY = "ReadOnly"
	val static private USER_ADMIN = "Administrator"
	val static private USER_TEST = "TestUser"
	val static private PASSWORD = ""
	
	def getSecureDestinationAsAdmin() {
		return getSecureDestinationAsUser(USER_ADMIN, PASSWORD)
	}
	
	def getSecureDestinationAsReadOnly() {
		return getSecureDestinationAsUser(USER_READONLY, PASSWORD)
	}
	
	def getSecureDestinationAsTestUser() {
		return getSecureDestinationAsUser(USER_TEST, PASSWORD)
	}

	def private getSecureDestinationAsUser(String userId, String password) {
		val destination = new Destination(this, AllTests.ENDPOINT_SECURE)
		destination.getRequestContext().addHeader(Request.AUTH_HEADER,
			"Basic " + Base64.encodeBase64String((userId + ':' + password).bytes))
		return destination
	}

	def getSecureDestination() {
		val destination = new Destination(this, AllTests.ENDPOINT_SECURE)
		return destination
	}

	def getUnsecureDestination() {
		val destination = new Destination(this, AllTests.ENDPOINT_UNSECURE)
		return destination
	}
}
