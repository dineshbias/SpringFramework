/**
 * 
 */
package com.application.service;

import java.util.List;

import com.application.domain.Employee;

/**
 * @author edinjos
 *
 */
public interface EmployeeService {

	public List<Employee> findAll() throws Exception;

	public List<Employee> findByName(String name) throws Exception;

	public Employee findById(int id) throws Exception;

	public void insert(Employee employee) throws Exception;

	public void update(Employee employee) throws Exception;

	public void delete(Employee employee) throws Exception;

}
