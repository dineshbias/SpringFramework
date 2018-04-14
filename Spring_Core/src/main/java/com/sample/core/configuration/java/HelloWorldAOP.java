/**
 * 
 */
package com.sample.core.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.sample.core.aop.target.Student;

/**
 * @author edinjos
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class HelloWorldAOP {

	public HelloWorldAOP() {
		System.out.println(this.getClass()
				+ " instantiated..........................");
	}

	@Bean
	@Scope("prototype")
	public Student getStudentBean() {
		System.out.println(this.getClass()
				+ " getStudentBean........................");
		Student student = new Student();
		student.setName("Dinesh");
		student.setAge(32);
		return student;
	}

	@Bean
	public HelloWorld getHelloWorld() {
		return new HelloWorld();
	}
}
