package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.pojo.Student;

public class StudentMapper implements RowMapper<Student> {

	public StudentMapper() {
		System.out.println(StudentMapper.class + " Instantiated... ");
	}

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(StudentMapper.class + " mapRow... ");
		
		Student student = new Student();

		student.setId(rs.getInt("ID"));
		student.setName(rs.getString("NAME"));
		student.setAge(rs.getInt("AGE"));

		return student;
	}

}
