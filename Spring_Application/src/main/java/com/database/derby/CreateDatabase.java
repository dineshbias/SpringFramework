/**
 * 
 */
package com.database.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author edinjos
 *
 */
public class CreateDatabase {

	private final static String CREATE_EMPLOYEE = "create table Employee"
			+ " ( ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), "
			+ "NAME VARCHAR(20) NOT NULL, " + "DATE_OF_JOIN DATE NOT NULL, " + "DATE_OF_BIRTH DATE NOT NULL, "
			+ "DEP_ID INT references Department(ID), " + "POSITION_ID INT references Employee_Position(ID), "
			+ "PRIMARY KEY (ID) )";

	private final static String CREATE_DEPARTMENT = "create table Department"
			+ " ( ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), "
			+ "NAME VARCHAR(20) NOT NULL, " + "DESCRIPTION VARCHAR(20) NOT NULL, " + "PRIMARY KEY (ID) )";

	private final static String CREATE_EMPLOYEE_POSITION = "create table Employee_Position"
			+ " ( ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), "
			+ "NAME VARCHAR(20) NOT NULL, " + "PRIMARY KEY (ID) )";

	/**
	 * 
	 */
	public CreateDatabase() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) {

		// String url = "jdbc:derby:zoo;create=true";
		// String url = "jdbc:derby:application;create=true";
		String url = "jdbc:derby:testAnnotationDB;user=dinesh;password=joshi;create=true";
		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			
			//createTables(stmt);
			
			fetchDataDepartment(stmt);
			fetchDataEmployeePosition(stmt);
			fetchDataEmployee(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createTables(Statement stmt) throws SQLException {
		System.out.println("Creating DB");
		stmt.executeUpdate(CREATE_DEPARTMENT);
		stmt.executeUpdate(CREATE_EMPLOYEE_POSITION);
		stmt.executeUpdate(CREATE_EMPLOYEE);

		System.out.println("Tables Created : ");
	}

	public static void fetchDataEmployee(Statement stmt) throws SQLException {

		ResultSet rs = stmt.executeQuery("SELECT * from Department");
		System.out.println("Fetch Data from Department");
		while (rs.next()) {
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			Date dateOfBirth = rs.getDate("DATE_OF_BIRTH");
			String dateOfjoining = rs.getString("DATE_OF_JOIN");
			String depId = rs.getString("DEP_ID");
			String positionId = rs.getString("POSITION_ID");

			System.out.println(" id:" + id + " name:" + name + " dateOfBirth:" + dateOfBirth + " dateOfjoining:"
					+ dateOfjoining + " positionId:" + positionId + " depId" + depId);
		}

	}

	public static void fetchDataDepartment(Statement stmt) throws SQLException {

		ResultSet rs = stmt.executeQuery("SELECT * from Employee");
		System.out.println("Fetch Data from Employee");
		while (rs.next()) {
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String description = rs.getString("DESCRIPTION");

			System.out.println(" id:" + id + " name:" + name + " description:" + description);
		}

	}

	public static void fetchDataEmployeePosition(Statement stmt) throws SQLException {

		ResultSet rs = stmt.executeQuery("SELECT * from Employee_Position");
		System.out.println("Fetch Data from Employee_Position");
		while (rs.next()) {
			String id = rs.getString("ID");
			String name = rs.getString("NAME");

			System.out.println(" id:" + id + " name:" + name);
		}

	}
}
