/**
 * 
 */
package com.application.dto;

/**
 * @author edinjos
 *
 */
public class PositionDto {

	private int id;
	private String name;
	
	
	public PositionDto() {
		System.out.println(PositionDto.class + " instantiated...");
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
	
}
