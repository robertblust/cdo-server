package ch.flatland.cdo.service.tests

import com.eclipsesource.restfuse.HttpJUnitRunner
import com.eclipsesource.restfuse.Method
import com.eclipsesource.restfuse.Response
import com.eclipsesource.restfuse.annotation.Context
import com.eclipsesource.restfuse.annotation.HttpTest
import org.junit.Rule
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory

import static extension com.eclipsesource.restfuse.Assert.assertUnauthorized
import static extension org.junit.Assert.assertTrue

@RunWith(typeof(HttpJUnitRunner))
class RepoAuthenticationFailes extends AbstractTestCase {

	val logger = LoggerFactory.getLogger(this.class)

	@Rule
	val public destination = secureDestination

	@Context
	private Response response

	@HttpTest(method=Method.GET, path="/repo")
	def checkUnauthenticated() {
		response.assertUnauthorized
		response.hasBody.assertTrue
		logger.debug("Body '{}'", response.body)
	}
}
