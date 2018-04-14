package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.pojo.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public EmployeeMapper() {
		System.out.println(EmployeeMapper.class + " Instantiated... ");
	}

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(EmployeeMapper.class + " mapRow... ");

		Employee employee = new Employee();

		employee.setId(rs.getInt("ID"));
		employee.setName(rs.getString("NAME"));
		employee.setAge(rs.getInt("AGE"));

		return employee;
	}

}
