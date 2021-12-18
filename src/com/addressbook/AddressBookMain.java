package com.addressbook;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class AddressBookMain {
	public static Scanner scanner = new Scanner(System.in);
	public ArrayList<Contact> addressBook = new ArrayList<>();
	public void addContact() {
		System.out.println("Enter name");
		String name = scanner.next();
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
		
		addressBook.add(new Contact(name, city, state, zip, phone, email));
		System.out.println(addressBook);
	}
	public void editContact(Contact person) {
		System.out.println("What do you wish to edit for: "+person.name+".\n Enter 1 for name \n Enter 2 for"
				+ " address \n Enter 3 for phone number \n Enter 4 for email ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			 System.out.println("enter new name");
			 person.name = scanner.next();
			 System.out.println(person);
			 break;
		case 2:
			 System.out.println("enter new city");
			 String city = scanner.next();
			 System.out.println("enter new state");
			 String state = scanner.next();
			 System.out.println("enter new zip");
			 long zip = scanner.nextLong();
			 person.address = new Address(city, state, zip);
			 System.out.println(person);
			 break;
		case 3:
			 System.out.println("enter new phone");
			 person.phoneNumber = scanner.nextLong();
			 System.out.println(person);
			 break;
		case 4:
			 System.out.println("enter new email");
			 person.email = scanner.next();
			 System.out.println(person);
			 break;
		}
			
	}
	
	public void editContact(String name) {
		System.out.println("RRRRR");
		Iterator<Contact> iterator = addressBook.iterator();
		while(iterator.hasNext()) {
			System.out.println("ertyui");
			Contact person = iterator.next();
			System.out.println(person);
		    if(name.equalsIgnoreCase(person.name)) {
		    	System.out.println("sdfg");
		    	editContact(person);
		    }
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program");
		AddressBookMain addressBookMain = new AddressBookMain();
		addressBookMain.addContact();	
		addressBookMain.addContact();	
		System.out.println("Enter name of person you wish to edit");
		String name = scanner.next();
		addressBookMain.editContact(name);
	}
}
