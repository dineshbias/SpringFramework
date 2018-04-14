package com.run;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.BeanConfig;
import com.spring.dao.EmployeeDAO;
import com.spring.dao.StudentMarksDeclarativeTransactionDAO;
import com.spring.pojo.Employee;
import com.spring.pojo.Student;
import com.spring.pojo.StudentMarks;
import com.spring.template.EmployeeJDBCTemplate;
import com.spring.template.StudentJDBCTemplate;
import com.spring.template.StudentMarksJDBCTemplate;

public class MainApp {

	public static void main(String[] args) throws IOException {
		//testStudentTable("beans.xml");
		//testProgramaticTransactionManagement("BeansProgramaticTransaction.xml");
		//testDeclarativeTransactionManagement("BeansDeclarativeTransaction.xml");
		//testAnnotationTransactionManagement("BeansAnnotationBasedTransaction.xml");
		testJavaBeanAnnotationTransactionManagement();
	}

	public static void testStudentTable(String fileName) throws IOException {
		System.out.println("testStudentTable****************************");

		Path p = Paths.get(".").toRealPath();
		System.out.println(" ...........loadUsingApplicationContext... "
				+ fileName);
		AbstractXmlApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		context.registerShutdownHook();

		System.out.println(" ...........loadUsingApplicationContext... loaded");

		StudentJDBCTemplate jdbcTemplate = context.getBean(
				"studentJDBCTemplate", StudentJDBCTemplate.class);
		try {
			jdbcTemplate.deleteTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}
		try {
			jdbcTemplate.createTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}
		System.out
				.println("testStudentTable**Listing Students-----------------------------");
		List<Student> students = jdbcTemplate.listStudents();
		students.forEach((s) -> System.out.println(s.getId() + " " + s.getAge()
				+ " " + s.getName()));

		System.out
				.println("testStudentTable**Insert Students------------------");
		jdbcTemplate.create("Dinesh Joshi", 32);
		jdbcTemplate.create("Bhuwan Joshi", 30);
		jdbcTemplate.create("Ramesh", 5);

		System.out
				.println("testStudentTable**Listing Students----------------------");
		students = jdbcTemplate.listStudents();
		students.forEach((s) -> System.out.println(s.getId() + " " + s.getAge()
				+ " " + s.getName()));

		System.out
				.println("testStudentTable**Updating Students----------------------");
		for (Student student : students) {
			jdbcTemplate.update(student.getId(),
					student.getId() + student.getAge());
		}

		System.out
				.println("testStudentTable**Listing Students by searching with id----------------------");

		for (Student student : students) {
			Student s = jdbcTemplate.getStudent(student.getId());
			System.out
					.println(s.getId() + " " + s.getAge() + " " + s.getName());
		}

		System.out
				.println("testStudentTable**Deleting Students----------------------");
		for (Student student : students) {
			jdbcTemplate.delete(student.getId());
		}

		System.out
				.println("testStudentTable**Listing Students----------------------");
		students = jdbcTemplate.listStudents();
		students.forEach((s) -> System.out.println(s.getId() + " " + s.getAge()
				+ " " + s.getName()));
		System.out.println("testStudentTable****************************");
	}

	public static void testProgramaticTransactionManagement(String fileName)
			throws IOException {

		Path p = Paths.get(".").toRealPath();
		System.out.println(" ...........loadUsingApplicationContext... "
				+ fileName);
		AbstractXmlApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		context.registerShutdownHook();

		System.out.println(" ...........loadUsingApplicationContext... loaded");

		System.out
				.println("enter testProgramaticTransactionManagement****************************");

		StudentMarksJDBCTemplate studentMarksJDBCTemplate = context.getBean(
				"studentMarksJDBCTemplate", StudentMarksJDBCTemplate.class);

		try {
			studentMarksJDBCTemplate.deleteTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}
		try {
			studentMarksJDBCTemplate.createTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}

		// Insert records in table

		studentMarksJDBCTemplate.create("Dinesh Joshi", 32, 84, "Maths", 2000);
		studentMarksJDBCTemplate.create("Mayank Joshi", 28, 96, "Maths", 2000);
		studentMarksJDBCTemplate.create("Sameera Joshi", 88, 46, "Maths", 2000);

		List<StudentMarks> studentMarks = studentMarksJDBCTemplate
				.listStudentMarks();
		studentMarks.forEach((s) -> System.out.println(s.getId() + " "
				+ s.getName() + " " + s.getSubject() + " " + s.getAge() + " "
				+ s.getMarks() + " " + s.getYearResult()));

		System.out
				.println("exit testProgramaticTransactionManagement****************************");
	}

	public static void testDeclarativeTransactionManagement(String fileName)
			throws IOException {

		Path p = Paths.get(".").toRealPath();
		System.out.println(" ...........loadUsingApplicationContext... "
				+ fileName);
		AbstractXmlApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		context.registerShutdownHook();

		System.out.println(" ...........loadUsingApplicationContext... loaded");

		System.out
				.println("enter testDeclarativeTransactionManagement****************************");

		StudentMarksDeclarativeTransactionDAO studentMarksJDBCTemplate = (StudentMarksDeclarativeTransactionDAO) context
				.getBean("studentMarksDeclTransJDBCTemplate");

		try {
			studentMarksJDBCTemplate.deleteTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}
		try {
			studentMarksJDBCTemplate.createTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}

		// Insert records in table
		try {
			studentMarksJDBCTemplate.create("Dinesh Joshi", 32, 84, "Maths",
					2000);
			studentMarksJDBCTemplate.create("Mayank Joshi", 28, 96, "Maths",
					2000);
			studentMarksJDBCTemplate.create("Sameera Joshi", 88, 46, "Maths",
					2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		List<StudentMarks> studentMarks = studentMarksJDBCTemplate
				.listStudentMarks();
		studentMarks.forEach((s) -> System.out.println(s.getId() + " "
				+ s.getName() + " " + s.getSubject() + " " + s.getAge() + " "
				+ s.getMarks() + " " + s.getYearResult()));

		System.out
				.println("exit testProgramaticTransactionManagement****************************");
	}

	public static void testAnnotationTransactionManagement(String fileName)
			throws IOException {

		Path p = Paths.get(".").toRealPath();
		System.out.println(" ...........loadUsingApplicationContext... "
				+ fileName);
		AbstractXmlApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		context.registerShutdownHook();

		System.out.println(" ...........loadUsingApplicationContext... loaded");

		System.out
				.println("enter testAnnotationTransactionManagement****************************");

		StudentMarksDeclarativeTransactionDAO studentMarksJDBCTemplate = (StudentMarksDeclarativeTransactionDAO) context
				.getBean("studentMarksAnnotationJDBCTemplate");

		try {
			studentMarksJDBCTemplate.deleteTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}
		try {
			studentMarksJDBCTemplate.createTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}

		// Insert records in table
		try {
			studentMarksJDBCTemplate.create("Dinesh Joshi", 32, 84, "Maths",
					2000);
			studentMarksJDBCTemplate.create("Mayank Joshi", 28, 96, "Maths",
					2000);
			studentMarksJDBCTemplate.create("Sameera Joshi", 88, 46, "Maths",
					2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		List<StudentMarks> studentMarks = studentMarksJDBCTemplate
				.listStudentMarks();
		studentMarks.forEach((s) -> System.out.println(s.getId() + " "
				+ s.getName() + " " + s.getSubject() + " " + s.getAge() + " "
				+ s.getMarks() + " " + s.getYearResult()));

		EmployeeDAO employeeJDBCTemplate = (EmployeeDAO) context
				.getBean("employeeJDBCTemplate");

		List<Employee> employees = employeeJDBCTemplate.listEmployee();
		employees.forEach((s) -> System.out.println(s.getId() + " "
				+ s.getAge() + " " + s.getName()));

		System.out
				.println("exit testProgramaticTransactionManagement****************************");
	}

	public static void testJavaBeanAnnotationTransactionManagement() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanConfig.class);

		context.refresh();
		context.registerShutdownHook();

		System.out
				.println(" ...................................................................................");
		System.out.println(" ...........loadUsingAnnotationContext... loaded");
		System.out
				.println(" ...................................................................................");

		System.out
				.println("enter testJavaBeanAnnotationTransactionManagement****************************");

		// Use when Transaction Management has not been enabled in
		// BeanConfig.java
		/*
		 * StudentMarksDeclarativeTransactionDAO studentMarksJDBCTemplate =
		 * (StudentMarksDeclarativeTransactionDAO) context
		 * .getBean(StudentMarksAnnotationTransactionJDBCTemplate.class);
		 */

		// Use when Transaction Management has been enabled in BeanConfig.java
		StudentMarksDeclarativeTransactionDAO studentMarksJDBCTemplate = (StudentMarksDeclarativeTransactionDAO) context
				.getBean(StudentMarksDeclarativeTransactionDAO.class);

		try {
			studentMarksJDBCTemplate.deleteTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}
		try {
			studentMarksJDBCTemplate.createTable();
		} catch (Exception e) {
			System.out.println("testStudentTable**************************** "
					+ e);
		}

		// Insert records in table
		try {
			studentMarksJDBCTemplate.create("Dinesh Joshi", 32, 84, "Maths",
					2000);
			studentMarksJDBCTemplate.create("Mayank Joshi", 28, 96, "Maths",
					2000);
			studentMarksJDBCTemplate.create("Sameera Joshi", 88, 46, "Maths",
					2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		List<StudentMarks> studentMarks = studentMarksJDBCTemplate
				.listStudentMarks();
		studentMarks.forEach((s) -> System.out.println(s.getId() + " "
				+ s.getName() + " " + s.getSubject() + " " + s.getAge() + " "
				+ s.getMarks() + " " + s.getYearResult()));

		// Use when Transaction Management has not been enabled in
		// BeanConfig.java
		/*EmployeeDAO employeeJDBCTemplate = (EmployeeDAO) context
				.getBean(EmployeeJDBCTemplate.class);
		*/
		
		
		// Use when Transaction Management has been enabled in BeanConfig.java
		EmployeeDAO employeeJDBCTemplate = (EmployeeDAO) context
				.getBean(EmployeeDAO.class);

		List<Employee> employees = employeeJDBCTemplate.listEmployee();
		employees.forEach((s) -> System.out.println(s.getId() + " "
				+ s.getAge() + " " + s.getName()));

		System.out
				.println("Close Context testProgramaticTransactionManagement****************************");
		context.close();

		System.out
				.println("exit testProgramaticTransactionManagement****************************");

	}
}
