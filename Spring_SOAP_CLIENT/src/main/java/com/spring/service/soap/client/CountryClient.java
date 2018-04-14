/**
 * 
 */
package com.spring.service.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.generated.GetCountryRequest;
import com.generated.GetCountryResponse;

/**
 * @author edinjos
 *
 */

public class CountryClient extends WebServiceGatewaySupport {

	String serviceURL = "http://127.0.0.1:9000/ws/countries";

	public CountryClient() {
		System.out.println(this.getClass() + " instantiated....");
	}

	public GetCountryResponse getCountryDetails(String countryName) {
		System.out.println(this.getClass() + " getCountryDetails.... "
				+ countryName);

		GetCountryRequest request = new GetCountryRequest();
		request.setName(countryName);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive(serviceURL, request,
						new SoapActionCallback(serviceURL));

		System.out.println(this.getClass() + " getCountryDetails.... "
				+ response);

		return response;

	}
}
