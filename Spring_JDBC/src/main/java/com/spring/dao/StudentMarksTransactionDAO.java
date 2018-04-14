/**
 * 
 */
package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;

import com.spring.pojo.StudentMarks;

/**
 * @author edinjos
 *
 */
public interface StudentMarksTransactionDAO {

	/*
	 * Method used to initialize datasource i.e. connection
	 */
	public void setDatasource(DataSource ds);

	/*
	 * Method used to initialize Transaction Manager
	 */
	public void setTransactionManager(
			PlatformTransactionManager transactionManager);

	/*
	 * Creates a record in employee and Marks table.
	 */
	public void create(String name, Integer age, Integer marks, String subject,
			Integer yearResult);

	/*
	 * Retrieves a record from DB based on id.
	 */
	public StudentMarks getStudentMark(Integer id);

	/*
	 * List down all the records from student and Marks table.
	 */
	public List<StudentMarks> listStudentMarks();

	/*
	 * Method to create Tables
	 */
	public void createTable();

	/*
	 * Method to delete Tables
	 */
	public void deleteTable();
}
