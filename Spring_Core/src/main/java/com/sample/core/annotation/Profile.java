/**
 * 
 */
package com.sample.core.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author edinjos
 *
 */
public class Profile {

	@Autowired
	@Qualifier("student2")
	private Student student;

	public Profile() {
		System.out.println(this.getClass() + " instantiated..." + student);
	}

	public void printAge() {
		System.out.println(student + " Age : " + student.getAge());
	}

	public void printName() {
		System.out.println(student + " Name : " + student.getName());
	}

}
