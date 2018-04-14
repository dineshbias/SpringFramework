/**
 * 
 */
package com.sample.core.di;

/**
 * @author edinjos
 *
 */
public class Person {

	private String name;
	private int age;
	private String sex;

	Person(String name, int age, String sex) {
		System.out.println(this.getClass() + " instantiated....");
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {

		return "name:" + name + " age:" + age + " sex:" + sex;
	}
}
