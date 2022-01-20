package com.addressbook;

import java.util.*;


public class AddressBook {

    public static Scanner scanner = new Scanner(System.in);
    public HashSet<Contact> addressBook = new HashSet<>();
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
        Contact newPerson = new Contact(name, city, state, zip, phone, email);
        addressBook.add(newPerson);

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

    }

    public void editContact(String name) {
        Iterator<Contact> iterator = addressBook.iterator();
        while(iterator.hasNext()) {

            Contact person = iterator.next();
            if(name.equalsIgnoreCase(person.name)) {
                editContact(person);
            }
        }
    }

    public void deleteContact(String name) {

        boolean isDeleted = addressBook.removeIf(contact -> (contact.name.equalsIgnoreCase(name)) );
        if(isDeleted)
            System.out.println(name+"'s contact deleted successfully!!!");
        else {
            System.out.println("NO SUCH CONTACT EXITS!!! PLEASE ENTER VALID NAME");
            deleteContact(scanner.next());
        }
    }

    public AddressBook addMultipleContacts() {
        System.out.println("How many persons do you want to add to the address book?");
        int numberOfContacts = scanner.nextInt();
        for (int i=0;i<numberOfContacts;i++)
            this.addContact();
        return this;
    }

    @Override
    public String toString() {
        return ": {" +
                 addressBook +
                '}';
    }
}
