package com.qa.AutomationPractice.types;

public class Address {

	public Address(String street, String city, String state, String zipcode, String country) {
		super();
		this.city = city;
		this.state = state;
		this.Zipcode = zipcode;
		this.country = country;
		this.street = street;
	}

	public String street;
	public String city;
	public String state;
	public String Zipcode;
	public String country;

}
