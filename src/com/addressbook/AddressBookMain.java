package com.addressbook;


import java.util.Scanner;
public class AddressBookMain {
	public static Scanner scanner = new Scanner(System.in);
	
	public void addContact() {
		System.out.println("Enter first name");
		String firstName = scanner.next();
		System.out.println("Enter last name");
		String lastName = scanner.next();
		System.out.println("Enter city");
		String city = scanner.next(); 
		System.out.println("Enter state ");
		String state = scanner.next();
		System.out.println("Enter zip");
		long zip = scanner.nextLong();
		System.out.println("Enter phone");
		long phone = scanner.nextLong();
		System.out.println("Enter email");
		String email = scanner.next();
		
		Contact person = new Contact(firstName, lastName, city, state, zip, phone, email);
		System.out.println(person);
	}
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program");
		AddressBookMain addressBook = new AddressBookMain();
		addressBook.addContact();	
	}
}
