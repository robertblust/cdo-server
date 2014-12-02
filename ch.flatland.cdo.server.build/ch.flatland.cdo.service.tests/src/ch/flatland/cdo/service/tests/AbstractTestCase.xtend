package ch.flatland.cdo.service.tests

import com.eclipsesource.restfuse.Destination
import org.apache.commons.codec.binary.Base64

abstract class AbstractTestCase {

	val static private USER = "ReadOnly"
	val static private PASSWORD = ""

	def Destination getSecureDestinationWithAuthentication() {
		val destination = new Destination(this, AllTests.ENDPOINT_SECURE)
		destination.getRequestContext().addHeader("Authorization",
			"Basic " + Base64.encodeBase64String((USER + ':' + PASSWORD).bytes))
		return destination
	}

	def Destination getSecureDestination() {
		val destination = new Destination(this, AllTests.ENDPOINT_SECURE)
		return destination
	}

	def Destination getUnsecureDestination() {
		val destination = new Destination(this, AllTests.ENDPOINT_UNSECURE)
		return destination
	}
}
