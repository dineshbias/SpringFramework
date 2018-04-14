/**
 * 
 */
package com.sample.core.aop.target;

/**
 * @author edinjos
 *
 */
public class A {

	/**
	 * 
	 */
	public A() {
		System.out.println(A.class + " instantiated........");
	}

	public void m() {
		System.out.println("m.... actual business logic");
	}

	public void n() {
		System.out.println("n.... actual business logic");
	}
}
