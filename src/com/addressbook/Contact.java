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
		public Address address;
		public long phoneNumber;
		public String email;
		
		
		public Contact(String firstName, String lastName, String city, 
						String state, long zip,long phoneNumber, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = new Address(city, state, zip);
			this.phoneNumber = phoneNumber;
			this.email = email;
		}


		@Override
		public String toString() {
			return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
		}
		
		
		
		
} 
