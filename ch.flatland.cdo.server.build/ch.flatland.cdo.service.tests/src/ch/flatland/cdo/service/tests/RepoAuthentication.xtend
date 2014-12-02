package ch.flatland.cdo.service.tests

import com.eclipsesource.restfuse.HttpJUnitRunner
import com.eclipsesource.restfuse.Method
import com.eclipsesource.restfuse.Response
import com.eclipsesource.restfuse.annotation.Context
import com.eclipsesource.restfuse.annotation.HttpTest
import org.junit.Rule
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory

import static extension com.eclipsesource.restfuse.Assert.assertOk
import static extension org.junit.Assert.assertTrue

@RunWith(typeof(HttpJUnitRunner))
class RepoAuthentication extends AbstractTestCase {

	val logger = LoggerFactory.getLogger(this.class)

	@Rule
	val public destination = secureDestinationAsReadOnly

	@Context
	private Response response

	@HttpTest(method=Method.GET, path="/repo")
	def checkAuthenticated() {
		response.assertOk
		response.hasBody.assertTrue
		logger.debug("Body '{}'", response.body)
	}
}
