package com.addressbook;

/*UC-6
This class implements a HashMap to store multiple AdressBooks into a dictionary
Refactor to add multiple
Address Book to the
System. Each Address Book
has a unique Name - Use Console to add new Address Book*/


import java.util.HashMap;
import java.util.Map;

public class AddressBookDictionary {
    HashMap<String, AddressBook> dictionaryOfAddressBooks = new HashMap<>();
    static int count=0;
    public static void main(String[] args) {
        AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
        addressBookDictionary.addMultipleAddressBook();
        //System.out.println(addressBookDictionary);
        for(Map.Entry<String, AddressBook> e: addressBookDictionary.dictionaryOfAddressBooks.entrySet()){
            System.out.println(e.getKey()+" " +e.getValue());
        }
    }

    private void addMultipleAddressBook() {
        System.out.println("How many AddressBooks you want to add?");
        int numberOfAddressBooks = AddressBook.scanner.nextInt();
        for (int i = 0;i < numberOfAddressBooks; i++) {
            count++;
            dictionaryOfAddressBooks.put("AddressBook"+count, new AddressBook().addMultipleContacts());
        }
    }
}
