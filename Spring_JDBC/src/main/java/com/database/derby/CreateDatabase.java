/**
 * 
 */
package com.database.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author edinjos
 *
 */
public class CreateDatabase {

	private final static String CREATE_STUDENT = "create table Student"
			+ " ( ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), "
			+ "NAME VARCHAR(20) default NULL, "
			+ "AGE INT default NULL, "
			+ "PRIMARY KEY (ID) )";
			
	
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
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
		    createTables(stmt);
			fetchDataStudent(stmt);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createTables(Statement stmt) throws SQLException {
		System.out.println("Creating DB");
		stmt.executeUpdate(CREATE_STUDENT);
		System.out.println("Table Created : " + CREATE_STUDENT);
	}

	public static void fetchDataStudent(Statement stmt)
			throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * from Student");
		System.out.println("Fetch Data from Student");
		while (rs.next()) {
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String age = rs.getString("AGE");
			
			System.out.println(" id:" + id + " name:" + name
					+ " age:" + age );
		}

	}
	
	

}
