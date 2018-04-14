/**
 * 
 */
package com.sample.core.configuration.xml;

/**
 * @author edinjos
 *
 */
public class HelloAllInOne {

	private String message;
	
	public HelloAllInOne(){
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
	
	public void callOnInit(){
		System.out.println(this.getClass()+ " callOnInit...");
	}
	
	public void callOnDestroy(){
		System.out.println(this.getClass()+ " callOnDestroy...");
	}
}
