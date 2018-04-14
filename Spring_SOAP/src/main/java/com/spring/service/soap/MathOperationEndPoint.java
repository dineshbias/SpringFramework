/**
 * 
 */
package com.spring.service.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bottom.math.test.AddIntegersRequest;
import com.bottom.math.test.AddIntegersResponse;
import com.bottom.math.test.GetfactorialRequest;
import com.bottom.math.test.GetfactorialResponse;

/**
 * @author edinjos
 *
 */
@Endpoint
public class MathOperationEndPoint {

	private static final String NAMESPACE_URI = "http://test.math.bottom.com/";

	public MathOperationEndPoint() {
		System.out.println(this.getClass() + " instantiated...");
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addIntegersRequest")
	@ResponsePayload
	public AddIntegersResponse addInteger(
			@RequestPayload AddIntegersRequest request) {
		int a = request.getNumber1();
		int b = request.getNumber2();

		System.out.println(this.getClass() + " addInteger " + a + " " + b);

		AddIntegersResponse resp = new AddIntegersResponse();
		resp.setSum(a + b);

		return resp;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getfactorialRequest")
	@ResponsePayload
	public GetfactorialResponse getFactorial(
			@RequestPayload GetfactorialRequest request) {

		int n = request.getNumber();
		System.out.println(this.getClass() + " getFactorial " + n);

		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}

		GetfactorialResponse response = new GetfactorialResponse();
		response.setNumber(result);
		return response;
	}

}
