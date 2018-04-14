package com.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.EmployeeDao;
import com.application.entity.Employee;
import com.application.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> findAll() throws Exception {
		return employeeDao.findAll();
	}

	@Override
	public List<Employee> findByName(String name) throws Exception {
		return employeeDao.findByName(name);
	}

	@Override
	public Employee findById(int id) throws Exception {
		return employeeDao.findById(id);
	}

	@Override
	public void insert(Employee employee) throws Exception {
		employeeDao.insert(employee);

	}

	@Override
	public void update(Employee employee) throws Exception {
		employeeDao.update(employee);

	}

	@Override
	public void delete(Employee employee) throws Exception {
		employeeDao.delete(employee);

	}

}
