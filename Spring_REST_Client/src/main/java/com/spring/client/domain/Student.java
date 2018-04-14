/**
 * 
 */
package com.spring.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author edinjos
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
// indicate that any properties not bound in this type should be ignored.
public class Student {

	private String name;
	private short age;

	public Student() {
		System.out.println(this.getClass() + " instantiated...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

}
