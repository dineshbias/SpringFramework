package com.application.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.dao.DepartmentDao;
import com.application.entity.Department;


@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public DepartmentDaoImpl() {
		System.out.println(DepartmentDaoImpl.class + " instantiated...");
	}

	@Override
	public List<Department> findAll() throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findAll...");

		String sql = "Select * FROM Department";

		List<Department> departments = jdbcTemplateObject.query(sql, new DepartmentMapper());

		System.out.println("Departments : " + departments.size());

		return departments;
	}

	@Override
	public List<Department> findByName(String name) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findByName...");

		String sql = "Select * FROM Department where NAME = ?";

		List<Department> departments = jdbcTemplateObject.query(sql, new DepartmentMapper(), name);

		System.out.println("Departments : " + departments.size());

		return departments;
	}

	@Override
	public Department findById(int id) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findById...");

		String sql = "Select * FROM Department where id = ?";

		Department department = jdbcTemplateObject.queryForObject(sql, Department.class, id);

		System.out.println("Department retrieved with id: " + id);

		return department;
	}

	@Override
	public void insert(Department department) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " insert...");

		String sql = "insert into Department (name,description) values (?,?)";

		int count = jdbcTemplateObject.update(sql, department.getName(), department.getDescription());

		System.out.println(this.getClass().getCanonicalName() + count + " rows inserted ");

	}

	@Override
	public void update(Department department) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " update...");

		String sql = "update Department set name=? , description=? where id=?";

		int count = jdbcTemplateObject.update(sql, department.getName(), department.getDescription(),
				department.getId());

		System.out.println(this.getClass().getCanonicalName() + count + " rows updated ");

	}

	@Override
	public void delete(Department department) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " delete...");

		String sql = "delete from Department where id=?";

		int count = jdbcTemplateObject.update(sql, department.getId());
		System.out.println(this.getClass().getCanonicalName() + " Deleted records..... " + count);
		return;

	}

}
