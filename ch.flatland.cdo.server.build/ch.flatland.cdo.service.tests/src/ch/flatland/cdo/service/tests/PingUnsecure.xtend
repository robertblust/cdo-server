package ch.flatland.cdo.service.tests

import com.eclipsesource.restfuse.Destination
import com.eclipsesource.restfuse.HttpJUnitRunner
import com.eclipsesource.restfuse.Method
import com.eclipsesource.restfuse.Response
import com.eclipsesource.restfuse.annotation.Context
import com.eclipsesource.restfuse.annotation.HttpTest
import org.junit.Rule
import org.junit.runner.RunWith

import static com.eclipsesource.restfuse.Assert.assertOk

@RunWith(typeof(HttpJUnitRunner))
class PingUnsecure {
	
	@Rule
	val public restfuse = new Destination(this, AllTests.UNSECURE_ENDPOINT);

	@Context
	private Response response;

	@HttpTest(method=Method.GET, path="/ping")
	def checkServerOnlineStatus() { 
		assertOk(response);
  }
}
	