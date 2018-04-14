package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.template.EmployeeJDBCTemplate;
import com.spring.template.StudentMarksAnnotationTransactionJDBCTemplate;

@Configuration
@EnableTransactionManagement
public class BeanConfig {

	public BeanConfig() {
		System.out.println(BeanConfig.class + " instantiated.......");
	}

	/*
	 * Creates DataSource Bean
	 */
	@Bean
	public DriverManagerDataSource getdDataSource() {

		System.out.println(BeanConfig.class
				+ " getdDataSource.......................");

		DriverManagerDataSource driverManagerDataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();

		// <property name="driverClassName"
		// value="org.apache.derby.jdbc.EmbeddedDriver" />
		driverManagerDataSource
				.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");

		// <property name="url"
		// value="jdbc:derby:testAnnotationDB;user=dinesh;password=joshi;create=true"
		// />
		driverManagerDataSource
				.setUrl("jdbc:derby:testAnnotationDB;user=dinesh;password=joshi;create=true");

		// <property name="username" value="dinesh" />
		driverManagerDataSource.setUsername("dinesh");

		// <property name="password" value="joshi" />
		driverManagerDataSource.setPassword("joshi");

		return driverManagerDataSource;
	}

	@Bean
	@Autowired
	public DataSourceTransactionManager getTransactionManager(
			DriverManagerDataSource dataSource) {

		System.out.println(BeanConfig.class
				+ " getTransactionManager.......................");

		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

		dataSourceTransactionManager.setDataSource(dataSource);

		return dataSourceTransactionManager;
	}

	@Bean
	@Autowired
	public StudentMarksAnnotationTransactionJDBCTemplate getStudentMarksAnnotationJDBCTemplate(
			DriverManagerDataSource dataSource) {

		System.out
				.println(BeanConfig.class
						+ " getStudentMarksAnnotationJDBCTemplate.......................");

		StudentMarksAnnotationTransactionJDBCTemplate studentMarksAnnotationTransactionJDBCTemplate = new StudentMarksAnnotationTransactionJDBCTemplate();

		studentMarksAnnotationTransactionJDBCTemplate.setDatasource(dataSource);

		return studentMarksAnnotationTransactionJDBCTemplate;
	}

	@Bean
	@Autowired
	public EmployeeJDBCTemplate getEmployeeJDBCTemplate(
			DriverManagerDataSource dataSource) {

		System.out.println(BeanConfig.class
				+ " getEmployeeJDBCTemplate.......................");

		EmployeeJDBCTemplate employeeJDBCTemplate = new EmployeeJDBCTemplate();

		employeeJDBCTemplate.setDatasource(dataSource);

		return employeeJDBCTemplate;
	}

}
