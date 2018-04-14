/**
 * 
 */
package com.spring.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author edinjos
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	@XmlElement
	private String name;
	@XmlElement
	private short age;

	public Student() {
		super();
	}

	public Student(String name, short age) {
		super();
		this.name = name;
		this.age = age;
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
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
