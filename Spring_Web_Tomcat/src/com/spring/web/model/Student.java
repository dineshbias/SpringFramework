package com.spring.web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

	public Student() {
		System.out.println(this.getClass() + " instantiated...");
	}
	
	@Min(4)
	private Integer age;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String name;
	
	
	private Integer id;

	public Integer getAge() {
		System.out.println(this.getClass() + " getAge...");
		return age;
	}

	public void setAge(Integer age) {
		System.out.println(this.getClass() + " setAge...");
		this.age = age;
	}

	public String getName() {
		System.out.println(this.getClass() + " getName...");
		return name;
	}

	public void setName(String name) {
		System.out.println(this.getClass() + " setName...");
		this.name = name;
	}

	public Integer getId() {
		System.out.println(this.getClass() + " getId...");
		return id;
	}

	public void setId(Integer id) {
		System.out.println(this.getClass() + " setId...");
		this.id = id;
	}

}
