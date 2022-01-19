package com.addressbook;

import java.util.Objects;

public class Contact {
	/* UC-1
	 Ability to create a Contacts in Address
	Book with first and last names, address,
	city, state, zip, phone number and
	email...
	*/
	String name;
	public Address address;
	public long phoneNumber;
	public String email;


	public Contact(String name, String city,
				   String state, long zip, long phoneNumber, String email) {
		super();
		this.name = name;
		this.address = new Address(city, state, zip);
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Name: " + name + "\n address: " + address
				+ "\n Phone: " + phoneNumber + "\n Email: " + email;
	}

	//UC-7 to avoid duplicate contacts of person in an AddressBook
	@Override
	public boolean equals(Object o) {
		Contact ob = (Contact) o;
		if (this.name.equals(ob.name))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
