/**
 * 
 */
package com.spring.pojo;

/**
 * @author edinjos \ Class Used as Join for Tables Student and Student_Marks
 */
public class StudentMarks {

	private Integer id;
	private Integer age;
	private String name;
	private Integer marks;
	private String subject;
	private Integer yearResult;
	 
	/**
	 * 
	 */
	public StudentMarks() {
		System.out.println(StudentMarks.class + " Instantiated....");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getYearResult() {
		return yearResult;
	}

	public void setYearResult(Integer yearResult) {
		this.yearResult = yearResult;
	}

}
