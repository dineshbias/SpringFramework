/**
 * 
 */
package com.spring.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDAO;
import com.spring.mapper.StudentMapper;
import com.spring.pojo.Student;

/**
 * @author edinjos
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public StudentJDBCTemplate() {
		System.out.println(StudentJDBCTemplate.class + " instantiated..... ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.dao.StudentDAO#setDataSource(javax.sql.DataSource)
	 */
	@Override
	public void setDatasource(DataSource ds) {
		datasource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.dao.StudentDAO#create(java.lang.String,
	 * java.lang.Integer)
	 */
	@Override
	public void create(String name, Integer age) {

		String sql = "insert into Student (name,age) values (?,?)";
		int count = jdbcTemplateObject.update(sql, name, age);
		System.out.println(StudentJDBCTemplate.class
				+ " Inserted records..... " + count);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.dao.StudentDAO#getStudent(java.lang.Integer)
	 */
	@Override
	public Student getStudent(Integer id) {

		String sql = "select * from Student where id=?";
		Student student = jdbcTemplateObject.queryForObject(sql,
				new Object[] { id }, new StudentMapper());
		System.out.println(StudentJDBCTemplate.class + " Fetched record..... "
				+ student);

		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.dao.StudentDAO#listStudents()
	 */
	@Override
	public List<Student> listStudents() {

		String sql = "Select * from Student";

		List<Student> students = jdbcTemplateObject.query(sql,
				new StudentMapper());

		System.out.println(StudentJDBCTemplate.class + " Fetched records..... "
				+ students.size());

		return students;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.dao.StudentDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		String sql = "delete from Student where id=?";

		int count = jdbcTemplateObject.update(sql, id);
		System.out.println(StudentJDBCTemplate.class + " Deleted records..... "
				+ count);
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.dao.StudentDAO#update(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void update(Integer id, Integer age) {
		String sql = "Update Student set age=? where id=?";

		int count = jdbcTemplateObject.update(sql, age, id);
		System.out.println(StudentJDBCTemplate.class + " Updated records..... "
				+ count);

		return;
	}

	@Override
	public void createTable() {
		String sql = "create table Student"
				+ " ( ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), "
				+ "NAME VARCHAR(20) default NULL, " + "AGE INT default NULL, "
				+ "PRIMARY KEY (ID) )";

		jdbcTemplateObject.execute(sql);
		System.out.println(StudentJDBCTemplate.class + "Table Created..... "
				+ sql);

	}

	@Override
	public void deleteTable() {

		String sql = "DROP table Student";
		jdbcTemplateObject.execute(sql);
		System.out.println(StudentJDBCTemplate.class + "Table Dropped..... "
				+ sql);
	}

}
