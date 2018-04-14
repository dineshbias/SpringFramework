package com.sample.core.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {

	private List addressList;
	private Set addressSet;
	private Map addressMap;
	private Properties addressProp;

	public JavaCollection() {
		System.out.println(this.getClass() + " instantiated...");
	}

	public List getAddressList() {
		System.out.println(this.getClass() + " getAddressList...");
		return addressList;
	}

	public void setAddressList(List addressList) {
		System.out.println(this.getClass() + " setAddressList...");
		this.addressList = addressList;
	}

	public Set getAddressSet() {
		System.out.println(this.getClass() + " getAddressSet...");
		return addressSet;
	}

	public void setAddressSet(Set addressSet) {
		System.out.println(this.getClass() + " setAddressSet...");
		this.addressSet = addressSet;
	}

	public Map getAddressMap() {
		System.out.println(this.getClass() + " getAddressMap...");
		return addressMap;
	}

	public void setAddressMap(Map addressMap) {
		System.out.println(this.getClass() + " setAddressMap...");
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		System.out.println(this.getClass() + " getAddressProp...");
		return addressProp;
	}

	public void setAddressProp(Properties addressProp) {
		System.out.println(this.getClass() + " setAddressProp...");
		this.addressProp = addressProp;
	}

}
