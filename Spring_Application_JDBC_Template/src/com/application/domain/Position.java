/**
 * 
 */
package com.application.domain;

/**
 * @author edinjos
 *
 */
public class Position {

	private int id;
	private String name;
	
	
	public Position() {
		System.out.println(Position.class + " instantiated...");
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
