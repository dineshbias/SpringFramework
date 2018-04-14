/**
 * 
 */
package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.application.domain.Department;

/**
 * @author edinjos
 *
 */
public class DepartmentMapper implements RowMapper<Department> {

	public DepartmentMapper() {
		System.out.println(DepartmentMapper.class + " instantiated...");
	}

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(DepartmentMapper.class + " mapRow... ");
		Department department = new Department();

		department.setId(rs.getInt("ID"));
		department.setName(rs.getString("NAME"));
		department.setDescription("DESCRIPTION");

		return department;
	}

}
