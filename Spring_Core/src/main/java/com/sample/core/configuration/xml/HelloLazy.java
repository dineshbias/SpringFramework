/**
 * 
 */
package com.sample.core.configuration.xml;

/**
 * @author edinjos
 *
 */
public class HelloLazy {

	private String message;
	
	public HelloLazy(){
		System.out.println(this.getClass()+ " instantiated...");
	}
	
	public void setMessage(String message) {
		System.out.println(this.getClass()+ " setMessage...");
		this.message = message;
	}

	public String getMessage() {
		System.out.println(this.getClass()+ " getMessage...");
		return message;
	}

}
