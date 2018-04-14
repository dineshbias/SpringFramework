/**
 * 
 */
package com.spring.model;

/**
 * @author edinjos
 *
 */
public class Employee extends Person {

	private String employeeId;
	private String designation;
	private String department;

	public Employee(String employeeId, String designation, String department,
			String name, int age, float weight) {
		super(name, age, weight);
		this.employeeId = employeeId;
		this.designation = designation;
		this.department = department;
		System.out.println(this.getClass() + " instantiated");
	}

	public Employee(Person p, String employeeId, String designation,
			String department) {
		super(p.getName(), p.getAge(), p.getWeight());
		this.employeeId = employeeId;
		this.designation = designation;
		this.department = department;
		System.out.println(this.getClass() + " instantiated");
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getDesignation() {
		return designation;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return super.toString() + " " + employeeId + " " + designation + " "
				+ department;
	}

}
