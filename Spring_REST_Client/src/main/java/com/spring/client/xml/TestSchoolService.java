/**
 * 
 */
package com.spring.client.xml;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author edinjos
 *
 */
public class TestSchoolService {

	private static String studentServiceURL = "http://localhost:9000/school/xml";

	public TestSchoolService() {
		System.out.println(this.getClass() + " Instantiated...");
	}

	public static void main(String... args) {
		RestTemplate restTemplate = new RestTemplate();

		System.out.println("main..restTemplate \n");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(studentServiceURL, HttpMethod.GET, entity, String.class);
		System.out.println("x : " + result);
		
		// Kaksha s = restTemplate.getForObject(studentServiceURL,
		// Kaksha.class);

		// System.out.println("main..\n" + s);
		ObjectMapper mapper = new ObjectMapper();
		try {
			// String jsonInString = mapper.writeValueAsString(s);
			// System.out.println("jsonInString : " + jsonInString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
