package ch.flatland.cdo.service.tests

import com.eclipsesource.restfuse.HttpJUnitRunner
import com.eclipsesource.restfuse.Method
import com.eclipsesource.restfuse.Response
import com.eclipsesource.restfuse.annotation.Context
import com.eclipsesource.restfuse.annotation.HttpTest
import org.junit.Rule
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory

import static extension com.eclipsesource.restfuse.Assert.assertForbidden
import static extension com.eclipsesource.restfuse.Assert.assertOk
import static extension org.junit.Assert.assertTrue

@RunWith(typeof(HttpJUnitRunner))
class EndpointUnsecure extends AbstractTestCase {

	val logger = LoggerFactory.getLogger(this.class)
	
	@Rule
	val public destination = unsecureDestination

	@Context
	private Response response

	@HttpTest(method=Method.GET, path="/ping")
	def checkPing() {
		response.assertOk
		response.hasBody.assertTrue
		logger.debug("Body '{}'", response.body)
	}

	@HttpTest(method=Method.GET, path="/repo")
	def checkForbidden() {
		response.assertForbidden
		response.hasBody.assertTrue
		logger.debug("Body '{}'", response.body)
	}
}
