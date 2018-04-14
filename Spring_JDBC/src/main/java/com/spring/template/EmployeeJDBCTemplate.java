/**
 * 
 */
package com.spring.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDAO;
import com.spring.mapper.EmployeeMapper;
import com.spring.pojo.Employee;

/**
 * @author edinjos
 *
 */
public class EmployeeJDBCTemplate implements EmployeeDAO {

	DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public EmployeeJDBCTemplate() {
		System.out.println(EmployeeJDBCTemplate.class + " instantiated......");
	}

	@Override
	public void setDatasource(DataSource ds) {
		System.out.println(EmployeeJDBCTemplate.class + " setDatasource......");
		datasource = ds;
		jdbcTemplateObject = new JdbcTemplate(datasource);

	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(String name, Integer age) {
		System.out.println(this.getClass() + " create....");

		String sql = "insert into Employee (name,age) values (?,?)";

		int count = jdbcTemplateObject.update(sql, name, age);
		System.out.println(this.getClass().getCanonicalName() + count
				+ " rows inserted ");
		if (name.contains("Mayank")) {
			System.out
			.println(this.getClass() + "-----------------------------------------------------------------------------  throwing exception" );
			throw new RuntimeException();
		}
	}

	@Override
	public List<Employee> listEmployee() {
		System.out.println(this.getClass() + " listEmployee....");

		String sql = "Select * from Employee";
		List<Employee> empList = jdbcTemplateObject.query(sql,
				new EmployeeMapper());
		System.out.println(this.getClass().getCanonicalName() + empList.size()
				+ " rows retrieved");
		return empList;
	}

}
