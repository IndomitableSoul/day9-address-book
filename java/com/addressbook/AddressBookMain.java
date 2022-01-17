package com.addressbook;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program!!!!!");
		AddressBook addressBook = new AddressBook();
		addressBook.addContact();

		System.out.println("Enter name of person you wish to edit");
		String name = AddressBook.scanner.next();
		addressBook.editContact(name);

		System.out.println("Enter name of person you wish to delete");
		String deletePerson = AddressBook.scanner.next();
		addressBook.deleteContact(deletePerson);
		System.out.println("Address Book contains: \n" + addressBook.addressBook);

		addressBook.addMultipleContacts();
		System.out.println(addressBook.addressBook);
	}


}
