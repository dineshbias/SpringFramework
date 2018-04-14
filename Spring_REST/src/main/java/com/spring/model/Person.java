/**
 * 
 */
package com.spring.model;

/**
 * @author edinjos
 *
 */
public class Person {

	private String name;
	private int age;
	private float weight;

	public Person(String name, int age, float weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		System.out.println(this.getClass() + " instantiated");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getWeight() {
		return age;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + weight;
	}
}
