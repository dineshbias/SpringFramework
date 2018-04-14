/**
 * 
 */
package com.spring.model;

import java.util.ArrayList;

/**
 * @author edinjos
 *
 */
public class Company {

	private ArrayList<Employee> employees;
	private String companyName;

	public Company(ArrayList<Employee> employees, String companyName) {
		this.employees = employees;
		this.companyName = companyName;

		System.out.println(this.getClass() + " instantiated");
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public String getCompanyName() {
		return companyName;
	}
}
