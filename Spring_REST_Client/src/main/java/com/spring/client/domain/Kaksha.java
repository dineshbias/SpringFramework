/**
 * 
 */
package com.spring.client.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author edinjos
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Kaksha {

	private short number;
	private String classTeacher;
	private Students students;

	/**
	 * 
	 */
	public Kaksha() {
		System.out.println(this.getClass() + " instantiated....");
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

	public static class Students {

		private List<Student> student;

		public List<Student> getStudent() {
			if (student == null) {
				student = new ArrayList<Student>();
			}
			return student;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Students{");
			for (Student s : student) {
				sb.append(s.toString());
			}
			sb.append("}");
			return sb.toString();
		}
	}

	@Override
	public String toString() {
		return "Class{" + "number='" + number + '\'' + ", classTeacher="
				+ classTeacher + ", students" + '\'' + students.toString()
				+ '}';
	}
}
