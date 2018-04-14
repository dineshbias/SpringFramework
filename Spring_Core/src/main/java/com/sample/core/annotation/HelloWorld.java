/**
 * 
 */
package com.sample.core.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author edinjos
 *
 */
public class HelloWorld {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		System.out.println("Your Message : " + message);
		return message;
	}

	@PostConstruct
	public void init() {
		System.out.println(this.getClass() + " Bean is going through init.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println(this.getClass() + " Bean will destroy now.");
	}

}
