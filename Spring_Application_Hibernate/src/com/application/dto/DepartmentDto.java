/**
 * 
 */
package com.application.dto;

/**
 * @author edinjos
 *
 */
public class DepartmentDto {

	private int id;
	private String name;
	private String description;
	
	public DepartmentDto() {
		System.out.println(DepartmentDto.class + " instantiated...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
