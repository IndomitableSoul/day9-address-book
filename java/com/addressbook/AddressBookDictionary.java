package com.addressbook;

/*UC-6
This class implements a HashMap to store multiple AdressBooks into a dictionary
Refactor to add multiple
Address Book to the
System. Each Address Book
has a unique Name - Use Console to add new Address Book*/


import java.util.HashMap;


public class AddressBookDictionary {
    HashMap<String, AddressBook> dictionaryOfAddressBooks = new HashMap<>();
    static int count=0;

    public void addMultipleAddressBook() {
        System.out.println("How many AddressBooks do you want to create?");
        int numberOfAddressBooks = AddressBook.scanner.nextInt();
        for (int i = 0;i < numberOfAddressBooks; i++) {
            count++;
            dictionaryOfAddressBooks.put("AddressBook"+count, new AddressBook().addMultipleContacts());
        }
    }
}
