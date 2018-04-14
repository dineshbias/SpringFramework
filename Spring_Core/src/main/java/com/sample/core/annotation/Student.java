package com.sample.core.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Student {

	private Integer age;
	private String name;

	public Student() {
		System.out.println(this.getClass() + " instantiated....");
	}

	public Integer getAge() {
		System.out.println(this.getClass() + " getAge....");
		return age;
	}

	@Autowired
	public void setAge(Integer age) {
		System.out.println(this.getClass() + " setAge....");
		this.age = age;
	}

	public String getName() {
		System.out.println(this.getClass() + " getName....");
		return name;
	}

	@Required
	public void setName(String name) {
		System.out.println(this.getClass() + " setName....");
		this.name = name;
	}

}
