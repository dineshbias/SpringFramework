/**
 * 
 */
package com.sample.core.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author edinjos
 *
 */
@Configuration
public class HelloWorldConfig {

	public HelloWorldConfig() {
		System.out.println(this.getClass() + " instantiated...");
	}

	@Bean(initMethod="init", destroyMethod="cleanup")
	@Scope("prototype")
	public HelloWorld getHelloWorldBean() {
		return new HelloWorld();
	}
}
