/**
 * 
 */
package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.spring.pojo.Employee;

/**
 * @author edinjos
 *
 */
public interface EmployeeDAO {

	/*
	 * Method used to initialize datasource i.e. connection
	 */
	public void setDatasource(DataSource ds);

	/*
	 * Creates a record in employee table
	 */
	public void create(String name, Integer age);

	/*
	 * List down all the records from Employee table.
	 */
	public List<Employee> listEmployee();
}
