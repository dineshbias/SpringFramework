/**
 * 
 */
package com.sample.core.inheritence;

/**
 * @author edinjos
 *
 */
public class B {

	public B() {
		
		System.out.println(this.getClass() + " Instantiated");
	}

	public String getMessage2() {
		System.out.println(this.getClass() + " getMessage2");
		return message2;
	}

	public void setMessage2(String message2) {
		System.out.println(this.getClass() + " setMessage2");
		this.message2 = message2;
	}

	private String message1;
	private String message2;
	private String message4;

	public String getMessage1() {
		System.out.println(this.getClass() + " getMessage1");
		return message1;
	}

	public void setMessage1(String message1) {
		System.out.println(this.getClass() + " setMessage1");
		this.message1 = message1;
	}

	public String getMessage4() {
		System.out.println(this.getClass() + " getMessage4");
		return message4;
	}

	public void setMessage4(String message4) {
		System.out.println(this.getClass() + " setMessage4");
		this.message4 = message4;
	}

}
