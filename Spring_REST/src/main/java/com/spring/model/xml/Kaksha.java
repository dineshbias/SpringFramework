/**
 * 
 */
package com.spring.model.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author edinjos
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Kaksha {

	@XmlElement(name = "class")
	private short number;
	@XmlElement(name = "Teacher")
	private String classTeacher;
	private Students students;

	/**
	 * 
	 */
	public Kaksha() {
		System.out.println(this.getClass() + " instantiated...");
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) {
		this.number = number;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "student" })
	public static class Students {

		private List<Student> student;

		public List<Student> getStudent() {
			if (student == null) {
				student = new ArrayList<Student>();
			}
			return student;
		}
	}
}
