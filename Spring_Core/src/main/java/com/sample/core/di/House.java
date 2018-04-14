/**
 * 
 */
package com.sample.core.di;

/**
 * @author edinjos
 *
 */
public class House {

	private Adress address;
	private Person person;

	/**
	 * 
	 */
	public House(Adress address) {
		System.out.println(this.getClass() + " instantiated...");
		this.address = address;
	}

	public Person getPerson() {
		System.out.println(this.getClass() + " getPerson...");
		return person;
	}

	public void setPerson(Person person) {
		System.out.println(this.getClass() + " setPerson...");
		this.person = person;
	}

	@Override
	public String toString() {
		String p = null == person ? "" : person.toString();
		return "[" + address.toString() + "|" + p + "]";
	}
}
