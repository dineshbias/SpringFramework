/**
 * 
 */
package com.sample.core.aop.oldStyle;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author edinjos
 *
 */
public class BeforeAdvisor implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("additional concern before actual logic");
		
	}

}
