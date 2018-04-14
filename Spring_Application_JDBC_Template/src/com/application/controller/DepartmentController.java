/**
 * 
 */
package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.application.domain.Department;
import com.application.service.DepartmentService;

/**
 * @author edinjos
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	public DepartmentController() {
		System.out.println(DepartmentController.class + " instantiated....");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		System.out.println(MainController.class + " mainPage....");
		return "department/main";
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView department() {
		System.out.println(DepartmentController.class + " department....");

		return new ModelAndView("department/department", "command", new Department());

	}

	@RequestMapping(method = RequestMethod.POST, value = "addDepartment")
	public ModelAndView addDepartment(ModelMap model, @ModelAttribute Department department) {
		System.out.println(DepartmentController.class + " addDepartment....");

		try {
			departmentService.insert(department);

			System.out.println(DepartmentController.class + " addDepartment completed ....");

		} catch (Exception e) {
			System.out.println(DepartmentController.class + " addDepartment..." + e);

			return new ModelAndView("errorPage", "message", "Error adding Department to database");
		}

		model.addAttribute("name", department.getName());
		model.addAttribute("description", department.getDescription());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("department/createSuccess");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listDepartments(ModelMap model) {
		System.out.println(DepartmentController.class + " listDepartments....");
		List<Department> departments = null;
		try {

			departments = departmentService.findAll();
			
			for (Department dept : departments) {
				System.out.println(dept.getId() + "--" + dept.getName() + "--" + dept.getDescription());
			}
			System.out.println(DepartmentController.class + " listDepartments completed ....");

		} catch (Exception e) {
			System.out.println(DepartmentController.class + " listDepartments..." + e);
			return new ModelAndView("errorPage", "message", "Error fetching Departments from Database");
		}

		if (null == departments || departments.isEmpty()) {
			return new ModelAndView("errorPage", "message", "No Departments Found");
		}

		model.addAttribute("Departments", departments);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("department/departments");
		return modelAndView;
	}

}
