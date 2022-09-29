package hn.com.tigo.josm.orchestrator.digital.driver.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ TigoSportProvisioningOperationTest.class,
	            DigitalCreateOperationTest.class,
	            DigitalDeleteOperationTest.class
	            })

public class AllTest {

	@AfterClass
	public static void tearDownAfterClass() throws IOException {
		EjbContainerContext.INSTANCE.close();
	}
}
