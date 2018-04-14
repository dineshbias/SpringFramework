package com.application.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.application.dao.EmployeeDao;
import com.application.domain.Employee;
import com.application.mapper.EmployeeMapper;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public EmployeeDaoImpl() {
		System.out.println(EmployeeDaoImpl.class + " instantiated...");
	}

	@Override
	public List<Employee> findAll() throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findAll...");

		String sql = "Select * FROM Employee";

		List<Employee> employees = jdbcTemplateObject.query(sql, new EmployeeMapper());

		System.out.println("Employees : " + employees.size());

		return employees;
	}

	@Override
	public List<Employee> findByName(String name) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findByName...");

		String sql = "Select * FROM Employee where NAME = ?";

		List<Employee> employees = jdbcTemplateObject.query(sql, new EmployeeMapper(), name);

		System.out.println("Employees : " + employees.size());

		return employees;
	}

	@Override
	public Employee findById(int id) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findById...");

		String sql = "Select * FROM Employee where id = ?";

		Employee employee = jdbcTemplateObject.queryForObject(sql, Employee.class, id);

		System.out.println("Employee retrieved with id: " + id);

		return employee;
	}

	@Override
	public void delete(Employee employee) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " delete...");

		String sql = "delete from Employee where id=?";

		int count = jdbcTemplateObject.update(sql, employee.getId());
		System.out.println(this.getClass().getCanonicalName() + " Deleted records..... " + count);
		return;

	}

	@Override
	public void insert(Employee employee) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " insert...");

		String sql = "insert into Employee (name , date_of_join , date_of_birth , dep_id ,position_id ) values (?,?,?,?,?)";

		int count = jdbcTemplateObject.update(sql, employee.getName(), employee.getDateOfBirth(),
				employee.getDateOfJoining(), employee.getDepId(), employee.getPositionid());

		System.out.println(this.getClass().getCanonicalName() + count + " rows inserted ");

	}

	@Override
	public void update(Employee employee) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " update...");

		String sql = "update Employee set name=? , date_of_join=? , date_of_birth=? , dep_id=? , position_id=? where id=?";

		int count = jdbcTemplateObject.update(sql, employee.getName(), employee.getDateOfJoining(),
				employee.getDateOfBirth(), employee.getDepId(), employee.getPositionid());

		System.out.println(this.getClass().getCanonicalName() + count + " rows updated ");

	}

}
