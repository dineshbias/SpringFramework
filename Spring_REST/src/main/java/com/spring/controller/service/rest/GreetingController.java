/**
 * 
 */
package com.spring.controller.service.rest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.SchoolException;
import com.spring.model.Company;
import com.spring.model.Employee;
import com.spring.model.Greeting;
import com.spring.model.Person;

/**
 * @author edinjos
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final static Person person = new Person("Dinesh Joshi", 32,
			(float) 68.4);
	private final static Employee employee = new Employee(person, "gur19185",
			"SSE", "Engineering");

	public GreetingController() {
		System.out.println("GreetingController instantiated....");
	}

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World", required = false) String name) {
		System.out.println("Received request on greeting....");
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

	@RequestMapping("/person")
	public Person getPerson() {
		System.out.println("Received request on person....");
		return person;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/xml")
	public Employee getEmployee() throws SchoolException {
		System.out.println("Received request on employee....");
		throw new SchoolException("Invalid employee name");
		// return employee;
	}

	@RequestMapping("/company")
	public Company getCompany() {
		System.out.println("Received request on company....");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees
				.add(new Employee("EGIL22718", "SSI", "RSSA CAC", "DJ", 31, 68));
		employees.forEach(System.out::print);
		return new Company(employees, "Aricent");
	}
}
