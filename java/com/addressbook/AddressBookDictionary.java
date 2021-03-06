package com.addressbook;

/*UC-6
This class implements a HashMap to store multiple AdressBooks into a dictionary
Refactor to add multiple
Address Book to the
System. Each Address Book
has a unique Name - Use Console to add new Address Book*/


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBookDictionary {

    HashMap<String, AddressBook> dictionaryOfAddressBooks = new HashMap<>();
                static int count=0;
                final static String FILE_PATH = "/home/dell/IdeaProjects/AddressBook/src/main/java/resources/addressBookOutputData.txt";
                final static String CSV_FILE_PATH = "/home/dell/IdeaProjects/AddressBook/src/main/java/resources/addressBookOutputDataCSVFile.csv";
                final static String JSON_FILE_PATH = "/home/dell/IdeaProjects/AddressBook/src/main/java/resources/addressBookOutputDataJSONFile.json";

                //to print the entire address-book dictionary
                public void printAddressBookDictionary(){
                    for(Map.Entry<String, AddressBook> e: dictionaryOfAddressBooks.entrySet()){
                        System.out.println(e.getKey()+" " +e.getValue());
                    }
                }

                //UC-6 to add multiple address-books to the address-book dictionary
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

                //UC11- ability to sort individual address-book alphabetically by person names
                public void sortPersonByNames() {
                    for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                        HashSet<Contact> addressBook = e.getValue().addressBook;

                        List<Contact> contacts = addressBook.stream().collect(Collectors.toList());
                        Collections.sort(contacts);
                        System.out.println("\n The Address-Book is sorted by name ");
                        System.out.println(contacts);
                        }
                    }

                    //UC12- ability to sort individual address-book by person city
                    public void sortPersonByCity() {
                        for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                            HashSet<Contact> addressBook = e.getValue().addressBook;

                            List<Contact> contacts = addressBook.stream().collect(Collectors.toList());
                            Collections.sort(contacts, new SortByCity());
                            System.out.println("\n The Address-Book is sorted by cities ");
                            System.out.println(contacts);
                        }
                    }

                    //UC12- ability to sort individual address-book by person state
                    public void sortPersonByState() {
                        for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                            HashSet<Contact> addressBook = e.getValue().addressBook;

                            List<Contact> contacts = addressBook.stream().collect(Collectors.toList());
                            Collections.sort(contacts, new SortByState());
                            System.out.println("\n The Address-Book is sorted by states");
                            System.out.println(contacts);
                        }
                    }

                    //UC12- ability to sort individual address-book by person address-zip
                    public void sortPersonByZip(){
                        for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                            HashSet<Contact> addressBook = e.getValue().addressBook;

                            List<Contact> contacts = addressBook.stream().collect(Collectors.toList());
                            Collections.sort(contacts, new SortByZip());
                            System.out.println("\n The Address-Book is sorted by zip ");
                            System.out.println(contacts);
                        }
                    }

                    //UC-13 Wring address-book into file
                    public void addContactsToFile() throws IOException {

                        File file = new File(FILE_PATH);
                        BufferedWriter bufferWriter = null;
                        try {
                            bufferWriter = new BufferedWriter(new FileWriter(file));
                            //iterating the hashMap entries
                            for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                                bufferWriter.write(e.getKey()+ " "+e.getValue());
                                bufferWriter.newLine();
                            }
                            bufferWriter.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally {
                            bufferWriter.close();
                        }
                    }

                //UC-13 reading person data from file
                public void readPersonDataFromFile() throws IOException {
                    Files.lines(new File(FILE_PATH).toPath()).forEach(System.out::println);
                }

                //UC-14 Ability to Read/Write Data to CSV file
                public  void writeDataIntoCSVFile() {
                    FileWriter fileWrite;
                    try {
                        fileWrite = new FileWriter(CSV_FILE_PATH );
                        CSVWriter writer = new CSVWriter(fileWrite);
                        for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                            HashSet<Contact> addressBook = e.getValue().addressBook;
                            List<String[]> contacts = addressBook.stream().map(person -> {
                                        String[] contact = new String[]{person.name, person.address.city, person.address.state, person.email};
                                        return contact;
                                    }
                            ).collect(Collectors.toList());
                            writer.writeAll(contacts);
                        }
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.err.println("Invalid path");
                    }

                }

            public void readCSVDataFromFile() {
                System.out.println("Reading from CSV File");
                try {
                    FileReader filereader = new FileReader(CSV_FILE_PATH);
                    CSVReader csvReader = new CSVReader(filereader);
                    String[] nextRecord;
                    while ((nextRecord = csvReader.readNext()) != null) {
                        for (String cell : nextRecord) {
                            System.out.print(cell + "\t");
                        }
                        System.out.println();
                    }
                } catch (Exception e) {
                    System.err.println("File not found at given path");
                }
            }

            //UC-15 Ability to Read or Write the Address Book with Persons Contact as JSON File
            public void writeDataIntoJsonFile() throws IOException {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Writer writer = null;
                try {
                    writer = new FileWriter(JSON_FILE_PATH);
                    for (Map.Entry<String, AddressBook> e : dictionaryOfAddressBooks.entrySet()) {
                        gson.toJson(e.getValue(), writer);//HashSet to JSON
                    }

                    // close writer
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    writer.close();
                }
            }

            // UC-15 Read the data from JSON files
            public void readDataFromJsonFile() {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                try {
                    System.out.println("Reading data from a JSON file");
                    System.out.println("----------------------------");
                    AddressBook data = gson.fromJson(new FileReader(JSON_FILE_PATH), AddressBook.class);
                    System.out.println(gson.toJson(data));
                } catch (IOException e) {
                    System.err.println("File not found in given path");
                }
            }

    public void readEntriesFromDB() {
                    //AddressBookDatabase.retrievingEntriesFromAddressBookTable();
    }

    //UC-16 Ability for the AddressBook Service to retrieve all the Entries from the DB

}












