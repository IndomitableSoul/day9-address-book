package com.addressbook;

public class Contact {
	/* UC-1
	 Ability to create a Contacts in Address
	Book with first and last names, address,
	city, state, zip, phone number and
	email...
	*/
		public String firstName;
		public String lastName;
		public String address;
		public String city;
		public String state;
		public long zip;
		public long phoneNumber;
		public String email;
		
		
		public Contact(String firstName, String lastName, String address, String city, 
						String state, long zip,long phoneNumber, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}
		
		
} 
