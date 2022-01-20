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

    //to print the entire address-book dictionary
    public void printAddressBookDictionary(){
        for(Map.Entry<String, AddressBook> e: dictionaryOfAddressBooks.entrySet()){
            System.out.println(e.getKey()+" " +e.getValue());
        }
    }

    // to add multiple address-books to the address-book dictionary
    public void addMultipleAddressBook() {
        System.out.println("How many AddressBooks do you want to create?");
        int numberOfAddressBooks = AddressBook.scanner.nextInt();
        for (int i = 0; i < numberOfAddressBooks; i++) {
            count++;
            dictionaryOfAddressBooks.put("AddressBook" + count, new AddressBook().addMultipleContacts());
        }
    }

        //UC-8 searching a person by state or city across all address-books
        public void searchPersonInCityOrState(String place) {
            for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                e.getValue().addressBook.stream().forEach(n -> {
                    if (n.address.city.equals(place) || n.address.state.equals(place)) {
                        System.out.println("We found " + n.name + " living in " + place);
                    }
                });
            }
        }

            //UC-9 Viewing all persons living in a state or city across all address-books
            public void viewPersonByCityOrState(String place) {
                for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                    e.getValue().addressBook.stream().forEach(n -> {
                        if (n.address.city.equals(place) || n.address.state.equals(place)) {
                            System.out.println("We found " + n + "\n living in " + place);
                        }
                    });
                }
            }


            //UC-10 getting count of persons in a state or city across all address-books
                public void getPersonsCountByCityOrState(String place){
                    long count = 0;
                    for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                        count = e.getValue().addressBook.stream().filter(n -> n.address.city.equals(place) || n.address.state.equals(place)).count();
                        }
                    System.out.println(count + " persons stay in "+place);
                    }



}



