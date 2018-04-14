package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.application.domain.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public EmployeeMapper() {
		System.out.println(EmployeeMapper.class + " instantiated...");
	}

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(EmployeeMapper.class + " mapRow... ");

		Employee employee = new Employee();

		employee.setId(rs.getInt("ID"));
		employee.setName(rs.getString("NAME"));
		employee.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
		employee.setDateOfJoining(rs.getDate("DATE_OF_JOIN"));
		employee.setDepId(rs.getInt("DEP_ID"));
		employee.setPositionid(rs.getInt("POSITION_ID"));

		return employee;
	}

}
