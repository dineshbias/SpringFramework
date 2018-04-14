/**
 * 
 */
package com.spring.service.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.generated.AddIntegersRequest;
import com.generated.AddIntegersResponse;
import com.generated.GetfactorialRequest;
import com.generated.GetfactorialResponse;

/**
 * @author edinjos
 *
 */
public class MathOperationClient extends WebServiceGatewaySupport {

	private String serviceURL = "http://127.0.0.1:9000/ws/operation";

	public MathOperationClient() {
		System.out.println(this.getClass() + " Instantiated....");
	}

	public AddIntegersResponse addInteger(int a, int b) {

		System.out.println(this.getClass() + " addInteger  " + a + " " + b);

		AddIntegersRequest request = new AddIntegersRequest();
		request.setNumber1(a);
		request.setNumber2(b);

		AddIntegersResponse response = (AddIntegersResponse) getWebServiceTemplate()
				.marshalSendAndReceive(serviceURL, request,
						new SoapActionCallback(serviceURL));
		System.out.println(this.getClass() + " addInteger " + response);

		return response;
	}

	public GetfactorialResponse factorial(int a) {

		System.out.println(this.getClass() + " factorial ..." + a);

		GetfactorialRequest request = new GetfactorialRequest();
		request.setNumber(a);

		GetfactorialResponse response = (GetfactorialResponse) getWebServiceTemplate()
				.marshalSendAndReceive(serviceURL, request,
						new SoapActionCallback(serviceURL));
		System.out.println(this.getClass() + " factorial ...." + response);

		return response;
	}
}
