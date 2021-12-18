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
			 break;
		case 2:
			 System.out.println("enter new city");
			 String city = scanner.next();
			 System.out.println("enter new state");
			 String state = scanner.next();
			 System.out.println("enter new zip");
			 long zip = scanner.nextLong();
			 person.address = new Address(city, state, zip);
			 break;
		case 3:
			 System.out.println("enter new phone");
			 person.phoneNumber = scanner.nextLong();
			 break;
		case 4:
			 System.out.println("enter new email");
			 person.email = scanner.next();
			 break;
		}
		 System.out.println(person);	
	}
	
	public void editContact(String name) {
		Iterator<Contact> iterator = addressBook.iterator();
		while(iterator.hasNext()) {
	
			Contact person = iterator.next();
			System.out.println(person);
		    if(name.equalsIgnoreCase(person.name)) {
		    	editContact(person);	
		    }
		}
	}
	
	public void deleteContact(String name) {
		     
		    boolean isDeleted = addressBook.removeIf(contact -> (contact.name.equalsIgnoreCase(name)) );
		    if(isDeleted)
		    	System.out.println(name+"'s contact deleted successfully");
		    else {
		    	System.out.println("NO SUCH CONTACT EXITS!!! PLEASE ENTER VALID NAME");
		        deleteContact(scanner.next());
		    }
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program");
		AddressBookMain addressBookMain = new AddressBookMain();
		addressBookMain.addContact();	
		addressBookMain.addContact();	
//		System.out.println("Enter name of person you wish to edit");
//		String name = scanner.next();
//		addressBookMain.editContact(name);
		System.out.println("Enter name of person you wish to delete");
		String deletePerson = scanner.next();
		addressBookMain.deleteContact(deletePerson);
		System.out.println(addressBookMain.addressBook);
	}
}
