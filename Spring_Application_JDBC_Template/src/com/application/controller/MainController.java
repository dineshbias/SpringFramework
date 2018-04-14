/**
 * 
 */
package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.database.derby.CreateDatabase;

/**
 * @author edinjos
 *
 */
@Controller
public class MainController {

	static {
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println(MainController.class + " static block ....");
		try {
			CreateDatabase.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(MainController.class + " static block....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");
		System.out.println("............................................... ....");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public MainController() {
		System.out.println(MainController.class + " instantiated....");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		System.out.println(MainController.class + " mainPage....");
		return "main";
	}
}