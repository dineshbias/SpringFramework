/**
 * 
 */
package com.sample.core.aop.xml;

/**
 * @author edinjos
 *
 */
public class Logging {

	/**
	 * 
	 */
	public Logging() {
		System.out.println(Logging.class + " instantiated.....");
	}

	/**
	 * * This is the method which I would like to execute * before a selected
	 * method execution.
	 */
	public void beforeAdvice() {
		System.out.println(Logging.class
				+ " beforeAdvice : Going to setup student profile.");
	}

	/**
	 * * This is the method which I would like to execute * after a selected
	 * method execution.
	 */
	public void afterAdvice() {
		System.out.println(Logging.class
				+ " afterAdvice: Student profile has been setup.");
	}

	/**
	 * * This is the method which I would like to execute * when any method
	 * returns.
	 */
	public void afterReturningAdvice(Object retVal) {
		System.out.println(Logging.class + " afterReturningAdvice: Returning:"
				+ retVal);
	}

	/**
	 * * This is the method which I would like to execute * if there is an
	 * exception raised.
	 */
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println(Logging.class
				+ " afterThrowingAdvice: There has been an exception: "
				+ ex.toString());
	}
}
