/**
 * 
 */
package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author edinjos
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	public HelloController() {
		System.out.println(this.getClass() + " Instantiated...");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printhello(ModelMap model) {
		System.out.println(this.getClass() + " printhello...");
		System.out.println("------------------");
		model.forEach((key, value) -> System.out.print(key + ":" + value + " "));
		System.out.println("------------------");
		model.addAttribute("message", "Hello Spring MVC Framework...");
		return "hello";
	}
	
}
