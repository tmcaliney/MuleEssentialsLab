package com.mulesoft.mule.training.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class TestUnitedPrice extends FunctionalTestCase {

	@Test
	public void testSFOUnitedPrice() throws Exception {
		getOneLocationResult("SFO", "[300 United, 300 Delta]");
	}

	@Test
	public void testSEAUnitedPrice() throws Exception {
		getOneLocationResult("SEA", "[400 United, 400 Delta]");
	}

	@Test
	public void testLAXUnitedPrice() throws Exception {
		getOneLocationResult("LAX", "[500 United, 500 Delta]");
	}

	private void getOneLocationResult(String location, String price)
			throws MuleException, Exception {
		String expectedResult="["+price+" United" +
			                  ", "+price+" Delta" +
				              ", "+price+" Southwest]";
		MuleClient client = muleContext.getClient();
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("http.method", "GET");
		MuleMessage reply = client.send("http://localhost:8081/" + location,
				"", headers, 30000);
		assertNotNull(reply);
		String sReply = reply.getPayloadAsString();
		System.out.println("sReply=" + sReply);
		assertEquals(expectedResult, sReply);
	}

	@Override
	protected String getConfigResources() {
		// TODO Auto-generated method stub
		return "src/main/app/muleessentials2.xml";
	}

}
