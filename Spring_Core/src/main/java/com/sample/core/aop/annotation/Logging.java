/**
 * 
 */
package com.sample.core.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author edinjos
 *
 */
@Aspect
public class Logging {

	/**
	 * 
	 */
	public Logging() {
		System.out.println(Logging.class + " instantiated.....");
	}

	@Pointcut("execution(* com.sample.core.aop.target.*.*(..))")
	private void selectAll() {
		System.out
				.println(Logging.class
						+ " This method is never called by framework. So body should be empty.");
	}

	/**
	 * * This is the method which I would like to execute * before a selected
	 * method execution.
	 */
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println(Logging.class
				+ " beforeAdvice : Going to setup student profile.");
	}

	/**
	 * * This is the method which I would like to execute * after a selected
	 * method execution.
	 */
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println(Logging.class
				+ " afterAdvice: Student profile has been setup.");
	}

	/**
	 * * This is the method which I would like to execute * when any method
	 * returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println(Logging.class + " afterReturningAdvice: Returning:"
				+ retVal);
	}

	/**
	 * * This is the method which I would like to execute * if there is an
	 * exception raised.
	 */
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println(Logging.class
				+ " afterThrowingAdvice: There has been an exception: "
				+ ex.toString());
	}
}