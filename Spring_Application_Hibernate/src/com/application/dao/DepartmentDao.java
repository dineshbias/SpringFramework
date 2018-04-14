package com.application.dao;

import java.util.List;

import com.application.entity.Department;

public interface DepartmentDao {

	public List<Department> findAll() throws Exception;

	public List<Department> findByName(String name) throws Exception;

	public Department findById(int id) throws Exception;

	public void insert(Department department) throws Exception;
	
	public void update(Department department) throws Exception;
		
	
	public void delete(Department department) throws Exception;

}
