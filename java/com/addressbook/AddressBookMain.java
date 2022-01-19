package com.addressbook;

import java.util.Map;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Program!!!!!");

		AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
		addressBookDictionary.addMultipleAddressBook();
		for(Map.Entry<String, AddressBook> e: addressBookDictionary.dictionaryOfAddressBooks.entrySet()){
			System.out.println(e.getKey()+" " +e.getValue());
		}
	}


}
