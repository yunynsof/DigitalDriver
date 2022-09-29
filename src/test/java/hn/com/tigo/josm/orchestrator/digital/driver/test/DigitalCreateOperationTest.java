package hn.com.tigo.josm.orchestrator.digital.driver.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.gson.Gson;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.digital.operations.DigitalCreateOperation;
import hn.com.tigo.josm.orchestrator.driver.digital.request.CreateServiceRequest;

public class DigitalCreateOperationTest extends AbstractTest {

	public DigitalCreateOperationTest() throws AdapterException {

	}

	@Test
	public void test() {
		final DigitalCreateOperation operation = new DigitalCreateOperation(getRequest());
		try {
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
			fail(e.getMessage());
		}
	}

	public CreateServiceRequest getRequest() {

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

		CreateServiceRequest testeo = null;
		try {
			Gson gson = new Gson();
			testeo = gson.fromJson(json, CreateServiceRequest.class);
			return testeo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testeo;
	}

	
	@Test
	public void testErr() {
		final DigitalCreateOperation operation = new DigitalCreateOperation(getRequestErr());
		try {
			final TaskResponseType response = driver.executeDriver(operation);
			System.out.println(response.getResponseCode());
			assertEquals(0, response.getResponseCode());
		} catch (AdapterException e) {
		}
	}

	public CreateServiceRequest getRequestErr() {

		String json = "";

		CreateServiceRequest testeo = null;
		try {
			Gson gson = new Gson();
			testeo = gson.fromJson(json, CreateServiceRequest.class);
			return testeo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testeo;
	}
}
