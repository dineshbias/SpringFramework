/**
 * 
 */
package com.spring.web.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.model.Student;

/**
 * @author edinjos
 *
 */
@Controller
public class StudentController {

	/**
	 * 
	 */
	public StudentController() {
		System.out.println(this.getClass() + " instantiated...");
	}

	@RequestMapping(method = RequestMethod.GET, value = "student")
	public ModelAndView student(HttpSession httpSession) {
		System.out.println(this.getClass() + " student...");
		System.out.println("***************************");
		System.out.println("Session :" + httpSession);
		Enumeration names = httpSession.getAttributeNames();
		while (names.hasMoreElements()) {
			Object name = names.nextElement();
			System.out.println(name + " "
					+ httpSession.getAttribute(name.toString()));
		}
		if (null == httpSession.getAttribute("user")) {
			return new ModelAndView("errorpage", "message", "Invalid Session");
		}
		return new ModelAndView("student", "command", new Student());
	}

	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(ModelMap model, @Valid Student student,
			HttpSession httpSession, BindingResult bindingResult) {
		System.out.println("***************************");

		System.out.println("Session :" + httpSession);
		Enumeration names = httpSession.getAttributeNames();
		System.out
				.println("addStudent Session Attributes----------------------");
		while (names.hasMoreElements()) {
			Object name = names.nextElement();
			System.out.println(name + " "
					+ httpSession.getAttribute(name.toString()));
		}
		System.out
				.println("addStudent Session Attributes----------------------");
		System.out.println(this.getClass() + " addStudent...");
		model.forEach((key, value) -> System.out.print(key + ":" + value + " "));
		System.out.println("\nmodel Items printed------------------");
		if (null == httpSession.getAttribute("user")) {
			return new ModelAndView("errorpage", "message", "Invalid Session");
		}

		if (bindingResult.hasErrors()) {
			System.out.println(this.getClass() + " Errors in Validation....");
			return new ModelAndView("errorpage", "message", "Invalid values");
		}

		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());
		System.out.println("");
		model.forEach((key, value) -> System.out.print(key + ":" + value + " "));
		System.out.println("\nmodel Items printed------------------");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result");
		return modelAndView;

	}

}
