/**
 * 
 */
package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.spring.pojo.Student;

/**
 * @author edinjos
 *
 */
public interface StudentDAO {

	/*
	 * Method used to initialize datasource i.e. connection
	 */
	public void setDatasource(DataSource ds);
	
	/*
	 * Creates a record in employee table
	 */
	public void create(String name, Integer age);

	/*
	 * Retrieves a record from DB based on id.
	 */
	public Student getStudent(Integer id);

	/*
	 * List down all the records from student table.
	 */
	public List<Student> listStudents();

	/*
	 * Deletes records from Student tables based on id.
	 */
	public void delete(Integer id);

	/*
	 * Method used to update a record into the Student table.
	 */
	public void update(Integer id, Integer age);
	
	
	/*
	 * Method to create Tables 
	 */
	public void createTable();
	
	/*
	 * Method to delete Tables
	 */
	public void deleteTable();
}
