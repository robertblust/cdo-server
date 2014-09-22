package ch.flatland.cdo.service.ping;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.flatland.cdo.service.ping.model.PingBean;


@Path( "/ping" ) 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PingService {
  
  @GET
  public PingBean ping() {
    return new PingBean();
  }
}