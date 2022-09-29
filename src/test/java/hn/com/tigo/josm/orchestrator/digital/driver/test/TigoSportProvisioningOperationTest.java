package hn.com.tigo.josm.orchestrator.digital.driver.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.gson.Gson;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.digital.operations.TigoSportProvisioningOperation;
import hn.com.tigo.josm.orchestrator.driver.digital.request.TigoSportsProvInput;

public class TigoSportProvisioningOperationTest extends AbstractTest {

	public TigoSportProvisioningOperationTest() throws AdapterException {

	}

	@Test
	public void test() {
		final TigoSportProvisioningOperation operation = new TigoSportProvisioningOperation(getRequest());
		try {
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
			fail(e.getMessage());
		}
	}

	public TigoSportsProvInput getRequest() {

		String json = "{\r\n" + 
				"    \"transactionId\": \"5652a915-d3d6-4082-9dab-6465a27c5f18\",\r\n" + 
				"    \"dateEvent\": \"2022-08-12 14:03:42\",\r\n" + 
				"    \"duration\": 10,\r\n" + 
				"    \"productId\": 1133,\r\n" + 
				"    \"orderType\": \"PURCHASE\",\r\n" + 
				"    \"eventType\": \"TIGO_SPORT_SUBSCRIPCION\",\r\n" + 
				"    \"additionalsParams\": [\r\n" + 
				"        {\r\n" + 
				"            \"attribute\": \"PAYMENTID\",\r\n" + 
				"            \"value\": \"9723500420211129150342\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"attribute\": \"AMOUNT\",\r\n" + 
				"            \"value\": \"0.0\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"attribute\": \"MTR\",\r\n" + 
				"            \"value\": \"CPE;7;5652a915-d3d6-4082-9dab-6465a27c5f18\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"attribute\": \"CHANNELID\",\r\n" + 
				"            \"value\": \"7\"\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";

		TigoSportsProvInput testeo = null;
		try {
			Gson gson = new Gson();
			testeo = gson.fromJson(json, TigoSportsProvInput.class);
			return testeo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testeo;
	}

	
	@Test
	public void testErr() {
		final TigoSportProvisioningOperation operation = new TigoSportProvisioningOperation(getRequestErr());
		try {
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
		}
	}

	public TigoSportsProvInput getRequestErr() {

		String json = "";

		TigoSportsProvInput testeo = null;
		try {
			Gson gson = new Gson();
			testeo = gson.fromJson(json, TigoSportsProvInput.class);
			return testeo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testeo;
	}
}
