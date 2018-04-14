/**
 * 
 */
package com.spring.client.json;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.client.domain.Student;

/**
 * @author edinjos
 *
 */
public class TestStudentService {

	private static String studentServiceURL = "http://localhost:9000/student/studentJson";

	public TestStudentService() {
		System.out.println(this.getClass() + " Instantiated...");
	}

	public static void main(String... args) {
		RestTemplate restTemplate = new RestTemplate();
		Student s = restTemplate.getForObject(studentServiceURL, Student.class);
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

}
