package ch.flatland.cdo.service.ping

import ch.flatland.cdo.service.ping.model.PingBean
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/ping")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class PingService {
	
	@GET
	def ping() {
		return new PingBean("Flatland CDO Server", "1.0.0")
	}
}
