package ch.flatland.cdo.service.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	PingUnsecure.class,
	PingSecure.class
	})

public class AllTests {
	public static String SECURE_ENDPOINT = "https://localhost:9080";
	public static String UNSECURE_ENDPOINT = "http://localhost:8080";
}
