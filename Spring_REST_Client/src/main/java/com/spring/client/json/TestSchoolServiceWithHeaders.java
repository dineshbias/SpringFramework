/**
 * 
 */
package com.spring.client.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.client.domain.Kaksha;
import com.spring.client.interceptor.HeaderRequestInterceptor;

/**
 * @author edinjos
 *
 */
public class TestSchoolServiceWithHeaders {

	private static String studentServiceURL = "http://localhost:9000/school/jsonHeader";

	public TestSchoolServiceWithHeaders() {
		System.out.println(this.getClass() + " Instantiated...");
	}

	public static void main(String... args) {

		RestTemplate restTemplate = new RestTemplate();
		
		// HTTP Header
		//restTemplate.setInterceptors(getNonSecureHTTPHeaders("Dinesh Joshi",
		//		"1234"));
		
		//Base64 Encoded HTTP Header
		
		restTemplate.setInterceptors(getSecureHTTPHeaders("Dinesh Joshi",
				"1234"));

		Kaksha s = restTemplate.getForObject(studentServiceURL, Kaksha.class);
		System.out.println("main..\n" + s);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(s);
			System.out.println("jsonInString : " + jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<ClientHttpRequestInterceptor> getNonSecureHTTPHeaders(
			String username, String password) {
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Username", username));
		interceptors.add(new HeaderRequestInterceptor("Password", password));
		return interceptors;
	}

	public static List<ClientHttpRequestInterceptor> getSecureHTTPHeaders(
			String username, String password) {
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new BasicAuthorizationInterceptor(username, password));

		return interceptors;
	}
}
