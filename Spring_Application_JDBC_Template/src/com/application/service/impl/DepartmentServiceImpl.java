package com.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.DepartmentDao;
import com.application.domain.Department;
import com.application.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> findAll() throws Exception {
		return departmentDao.findAll();
	}

	@Override
	public List<Department> findByName(String name) throws Exception {
		return departmentDao.findByName(name);
	}

	@Override
	public Department findById(int id) throws Exception {
		return departmentDao.findById(id);
	}

	@Override
	public void insert(Department department) throws Exception {
		departmentDao.insert(department);
	}

	@Override
	public void update(Department department) throws Exception {
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) throws Exception {
		departmentDao.delete(department);

	}

}
