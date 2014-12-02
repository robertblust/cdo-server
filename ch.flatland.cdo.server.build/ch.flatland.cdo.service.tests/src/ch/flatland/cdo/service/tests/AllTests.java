package ch.flatland.cdo.service.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	EndpointUnsecure.class,
	EndpointSecure.class,
	RepoAuthentication.class
})

public class AllTests {
	public static String ENDPOINT_SECURE = "https://localhost:9080";
	public static String ENDPOINT_UNSECURE = "http://localhost:8080";
	public static String SERVICE_PING = "/ping";
	public static String SERVICE_REPO = "/repo";
}
