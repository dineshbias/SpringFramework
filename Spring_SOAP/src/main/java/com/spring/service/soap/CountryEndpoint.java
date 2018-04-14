/**
 * 
 */
package com.spring.service.soap;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.spring.dao.CountryRepository;

/**
 * @author edinjos
 *
 */
@Endpoint
public class CountryEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	private CountryRepository countryRepository;
	
	public CountryEndpoint() {
		System.out.println(this.getClass() + " instantiated...");
	}

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		System.out.println(this.getClass() + " instantiated... " + countryRepository);
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(
			@RequestPayload GetCountryRequest request) {
		System.out.println(this.getClass() + " getCountry...");
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}

}
