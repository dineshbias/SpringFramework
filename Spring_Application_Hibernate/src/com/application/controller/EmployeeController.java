/**
 * 
 */
package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.dto.Employee;
import com.application.service.EmployeeService;

/**
 * @author edinjos
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		System.out.println(EmployeeController.class + " instantiated....");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		System.out.println(EmployeeController.class + " mainPage....");
		return "employee/main";
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView employee() {
		System.out.println(EmployeeController.class + " employee....");

		return new ModelAndView("employee/employee", "command", new Employee());

	}

	@RequestMapping(method = RequestMethod.POST, value = "addEmployee")
	public ModelAndView addEmployee(ModelMap model, @ModelAttribute Employee employee) {
		System.out.println(EmployeeController.class + " addEmployee....");

		try {
			employeeService.insert(employee);

			System.out.println(EmployeeController.class + " addEmployee completed ....");

		} catch (Exception e) {
			System.out.println(EmployeeController.class + " addEmployee..." + e);

			return new ModelAndView("errorPage", "message", "Error adding Employee to database");
		}

		model.addAttribute("name", employee.getName());
		model.addAttribute("dateOfJoining", employee.getDateOfJoining());
		model.addAttribute("dateOfBirth", employee.getDateOfBirth());
		model.addAttribute("depId", employee.getDepId());
		model.addAttribute("positionid", employee.getPositionid());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee/createSuccess");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "findById")
	public ModelAndView findEmployeeById(@RequestParam(value = "employeeId", required = true) int employeeId,
			ModelMap model) {
		System.out.println(EmployeeController.class + " findEmployeeById.... " + employeeId);
		Employee employee = null;
		try {

			employee = employeeService.findById(employeeId);
			System.out.println(EmployeeController.class + " findEmployeeById completed ....");

		} catch (Exception e) {
			System.out.println(EmployeeController.class + " findEmployeeById..." + e);
			return new ModelAndView("errorPage", "message", "Error fetching Employee to database based on Id");
		}

		if (null == employee) {
			return new ModelAndView("errorPage", "message", "Employee with Id " + employeeId + " Not found..");
		}

		model.addAttribute("name", employee.getName());
		model.addAttribute("dateOfJoining", employee.getDateOfJoining());
		model.addAttribute("dateOfBirth", employee.getDateOfBirth());
		model.addAttribute("depId", employee.getDepId());
		model.addAttribute("positionid", employee.getPositionid());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee/employee");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "findByName")
	public ModelAndView findEmployeeByName(@RequestParam(value = "employeeName", required = true) String employeeName,
			ModelMap model) {
		System.out.println(EmployeeController.class + " findEmployeeByName.... " + employeeName);
		List<Employee> employees = null;
		try {

			employees = employeeService.findByName(employeeName);
			System.out.println(EmployeeController.class + " findEmployeeByName completed ....");

		} catch (Exception e) {
			System.out.println(EmployeeController.class + " findEmployeeByName..." + e);
			return new ModelAndView("errorPage", "message", "Error fetching Employee to database based on Name");
		}

		if (null == employees || employees.isEmpty()) {
			return new ModelAndView("errorPage", "message", "Employee with name " + employeeName + " Not found..");
		}

		model.addAttribute("employees", employees);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee/employees");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam(required = true, value = "employeeId") int employeeId) {
		System.out.println(EmployeeController.class + " deleteEmployee....");

		Employee employee = null;
		try {

			employee = employeeService.findById(employeeId);
			System.out.println(EmployeeController.class + " findEmployeeById completed ....");

		} catch (Exception e) {
			System.out.println(EmployeeController.class + " deleteEmployee..." + e);
			return new ModelAndView("errorPage", "message", "Error fetching Employee to database based on Id");
		}

		if (null == employee) {
			return new ModelAndView("errorPage", "message", "Employee with Id " + employeeId + " Not found..");
		}

		try {
			employeeService.delete(employee);
		} catch (Exception e) {
			System.out.println(EmployeeController.class + " deleteEmployee..." + e);
			return new ModelAndView("errorPage", "message", "Error deleting Employee with id " + employeeId);
		}

		return new ModelAndView("errorPage", "message", "Deleted Employee with id " + employeeId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listEmployees(ModelMap model) {
		System.out.println(EmployeeController.class + " listEmployees....");
		List<Employee> employees = null;
		try {

			employees = employeeService.findAll();
			for (Employee employee : employees) {
				System.out.println(employee.getId() + "--" + employee.getName() + "--" + employee.getDepId() + "--"
						+ employee.getPositionid());
			}

			System.out.println(EmployeeController.class + " listEmployees completed ....");

		} catch (Exception e) {
			System.out.println(EmployeeController.class + " listEmployees..." + e);
			return new ModelAndView("errorPage", "message", "Error fetching Employees from Database");
		}

		if (null == employees || employees.isEmpty()) {
			return new ModelAndView("errorPage", "message", "No employees Found");
		}

		model.addAttribute("employees", employees);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee/employees");
		return modelAndView;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		System.out.println(EmployeeController.class + " initBinder....");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}
}
