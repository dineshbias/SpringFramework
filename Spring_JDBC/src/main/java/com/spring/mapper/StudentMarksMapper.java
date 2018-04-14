/**
 * 
 */
package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.pojo.StudentMarks;

/**
 * @author edinjos
 *
 */
public class StudentMarksMapper implements RowMapper<StudentMarks> {

	public StudentMarksMapper() {
		System.out.println(StudentMarksMapper.class + " Instantiated... ");
	}

	@Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentMarks studentMarks = new StudentMarks();

		studentMarks.setAge(rs.getInt("AGE"));
		studentMarks.setId(rs.getInt("ID"));
		studentMarks.setMarks(rs.getInt("MARKS"));
		studentMarks.setName(rs.getString("NAME"));
		studentMarks.setSubject(rs.getString("SUBJECT"));
		studentMarks.setYearResult(rs.getInt("YEAR_RESULT"));

		return studentMarks;
	}

}
