/**
 * 
 */
package com.sample.core.di;

/**
 * @author edinjos
 *
 */
public class Adress {

	private String number;
	private String buildingNumber;
	private String locality;
	private String city;
	private int pincode;

	/**
	 * 
	 */
	public Adress() {
		System.out.println(this.getClass() + " Instantiated...");
	}

	public String getNumber() {
		System.out.println(this.getClass() + " getNumber..");
		return number;
	}

	public void setNumber(String number) {
		System.out.println(this.getClass() + " setNumber..");
		this.number = number;
	}

	public String getLocality() {
		System.out.println(this.getClass() + " getLocality..");
		return locality;
	}

	public void setLocality(String locality) {
		System.out.println(this.getClass() + " setLocality..");
		this.locality = locality;
	}

	public String getCity() {
		System.out.println(this.getClass() + " getCity..");
		return city;
	}

	public void setCity(String city) {
		System.out.println(this.getClass() + " setCity..");
		this.city = city;
	}

	public int getPincode() {
		System.out.println(this.getClass() + " getPincode..");
		return pincode;
	}

	public void setPincode(int pincode) {
		System.out.println(this.getClass() + " setPincode..");
		this.pincode = pincode;
	}

	public String getBuildingNumber() {
		System.out.println(this.getClass() + " getBuildingNumber..");
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		System.out.println(this.getClass() + " setBuildingNumber..");
		this.buildingNumber = buildingNumber;
	}

	@Override
	public String toString() {

		return "number:" + number + " buildingNumber:" + buildingNumber
				+ " locality:" + locality + "city:" + city + " pincode:"
				+ pincode;
	}

}
