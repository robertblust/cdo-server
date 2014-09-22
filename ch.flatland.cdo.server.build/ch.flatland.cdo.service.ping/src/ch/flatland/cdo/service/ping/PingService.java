package ch.flatland.cdo.service.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path( "/ping" )
public class PingService {
  
  @GET
  public String ping() {
    return "Hello Flatland.";
  }
}