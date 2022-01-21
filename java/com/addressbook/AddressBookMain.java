package com.addressbook;

import java.io.IOException;
import java.util.Map;

public class AddressBookMain {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome To Address Book Program!!!!!");

		AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
		addressBookDictionary.addMultipleAddressBook();
	addressBookDictionary.printAddressBookDictionary();
//		addressBookDictionary.searchPersonInCityOrState("blore");
//		addressBookDictionary.viewPersonByCityOrState("blore");
//		addressBookDictionary.getPersonsCountByCityOrState("blore");
//		addressBookDictionary.sortPersonByNames();
//		addressBookDictionary.sortPersonByCity();
//		addressBookDictionary.sortPersonByState();
//		addressBookDictionary.sortPersonByZip();
//		addressBookDictionary.addContactsToFile();
//		addressBookDictionary.readPersonDataFromFile();
		addressBookDictionary.writeDataIntoCSVFile();
		addressBookDictionary.readCSVDataFromFile();


	}


}
