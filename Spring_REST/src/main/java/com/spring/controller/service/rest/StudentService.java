/**
 * 
 */
package com.spring.controller.service.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.xml.Student;

/**
 * @author edinjos
 *
 */
@RestController
@RequestMapping("/student")
public class StudentService {

	@RequestMapping(value = "/studentJson", method = RequestMethod.GET, produces = "application/json")
	public Student getStudentJSON() {
		Student st = new Student();
		st.setName("JavaInterviewPoint");
		st.setAge((short) 11);

		return st;
	}

	@RequestMapping(value = "/studentXml", method = RequestMethod.GET, produces = "application/xml")
	public Student getStudentXml() {
		Student st = new Student();
		st.setName("JavaInterviewPoint");
		st.setAge((short) 99);

		return st;
	}

}
