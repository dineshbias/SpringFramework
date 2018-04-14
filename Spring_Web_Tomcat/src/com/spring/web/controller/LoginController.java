/**
 * 
 */
package com.spring.web.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.model.Student;

/**
 * @author edinjos
 *
 */
@Controller
@SessionAttributes("user")
public class LoginController {

	/**
	 * 
	 */
	public LoginController() {
		System.out.println(this.getClass() + " Instantiated...");
	}

	@GetMapping("/login")
	public String loginForm(Model model, HttpSession httpSession) {
		System.out.println(this.getClass() + " Get loginform ");
		System.out.println("Session :" + httpSession);
		System.out.println("login Session Attributes----------------------");
		Enumeration names = httpSession.getAttributeNames();
		while (names.hasMoreElements()) {
			Object name = names.nextElement();
			System.out.println(name + " "
					+ httpSession.getAttribute(name.toString()));
		}
		System.out.println("Session Attributes Done----------------------");
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			HttpSession httpSession) {
		System.out.println(this.getClass() + " login.. ");
		System.out.println(username + "*************" + password);
		System.out.println("login Session :" + httpSession);
		if ("admin".equals(username) && "password".equals("password")) {
			ModelAndView modelAndView = new ModelAndView("student", "command",
					new Student());
			modelAndView.addObject("user", username);
			
			System.out.println("login Session Attributes----------------------");
			Enumeration names = httpSession.getAttributeNames();
			while (names.hasMoreElements()) {
				Object name = names.nextElement();
				System.out.println(name + " "
						+ httpSession.getAttribute(name.toString()));
			}
			System.out.println("Session Attributes Done----------------------");
			return modelAndView;
		} else {

			return new ModelAndView("errorpage", "message",
					"Sorry, username or password error");
		}
	}
}
