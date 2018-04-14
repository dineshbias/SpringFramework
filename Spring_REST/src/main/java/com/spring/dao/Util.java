/**
 * 
 */
package com.spring.dao;

import java.util.ArrayList;

import com.spring.model.xml.Kaksha;
import com.spring.model.xml.Kaksha.Students;
import com.spring.model.xml.Student;

/**
 * @author edinjos
 *
 */
public class Util {

	public static ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<Student>();

		students.add(new Student("Dinesh Joshi", (short) 32));
		students.add(new Student("Dishita", (short) 4));
		students.add(new Student("Ramesh", (short) 15));
		students.add(new Student("Bhupesh", (short) 40));

		return students;
	}

	public static Kaksha getKaksha() {
		Kaksha c = new Kaksha();
		Kaksha.Students students = new Students();
		students.getStudent().addAll(getStudents());
		c.setStudents(students);
		c.setNumber((short) 10);
		c.setClassTeacher("Mrs. Kashyap");
		return c;
	}

}
