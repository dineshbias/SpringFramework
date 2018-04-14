/**
 * 
 */
package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.spring.service.soap.client.CountryClient;
import com.spring.service.soap.client.MathOperationClient;

/**
 * @author edinjos
 *
 */
@Configuration
public class ClientConfiguration {

	//String serviceURL = "http://127.0.0.1:9000/ws/countries";
	String clientPack = "com.generated";

	public ClientConfiguration() {
		System.out.println(this.getClass() + " instantiated....");
	}

	@Bean
	public Jaxb2Marshaller getMarshallerBean() {
		System.out.println(this.getClass() + " getMarshallerBean....");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(clientPack);
		return marshaller;
	}

	@Bean
	public CountryClient getCountryClientBean(Jaxb2Marshaller marshaller) {
		System.out.println(this.getClass() + " getCountryClientBean....");
		
		CountryClient countryClient = new CountryClient();
		countryClient.setMarshaller(marshaller);
		countryClient.setUnmarshaller(marshaller);
		//countryClient.setDefaultUri(serviceURL);
		return countryClient;
	}

	@Bean
	public MathOperationClient getMathOperationClientBean(
			Jaxb2Marshaller marshaller) {
		System.out.println(this.getClass() + " getMathOperationClientBean....");
		
		MathOperationClient countryClient = new MathOperationClient();
		countryClient.setMarshaller(marshaller);
		countryClient.setUnmarshaller(marshaller);
		//countryClient.setDefaultUri(serviceURL);
		return countryClient;
	}
}
