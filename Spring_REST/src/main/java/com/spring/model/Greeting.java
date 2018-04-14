/**
 * 
 */
package com.spring.model;

/**
 * @author edinjos
 *
 */
public class Greeting {

	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		System.out.println(this.getClass() + " instantiated");
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return id + " " + content;
	}
}
