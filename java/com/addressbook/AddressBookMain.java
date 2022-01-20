package com.addressbook;

import java.util.Map;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program!!!!!");

		AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
		addressBookDictionary.addMultipleAddressBook();
		addressBookDictionary.printAddressBookDictionary();
//		addressBookDictionary.searchPersonInCityOrState("blore");
//		addressBookDictionary.viewPersonByCityOrState("blore");
//		addressBookDictionary.getPersonsCountByCityOrState("blore");
		addressBookDictionary.sortPersonByNames();

	}


}
