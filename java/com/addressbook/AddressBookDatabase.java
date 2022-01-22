package com.addressbook;

import java.sql.*;

public class AddressBookDatabase {

    final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/addressbook_service_db?useSSL=false";
    final static String DB_USERNAME = "root";
    final static String DB_PASSWORD = "Welcome123";

    static boolean retrievingEntriesFromAddressBookTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //loading the driver
            System.out.println("Driver loaded successfully");
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //establishing connection to adressbook_service_db
            Connection connection = DriverManager.getConnection(CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected");
            //creating statement
            Statement statement = connection.createStatement();
            //retrieving data from address_book table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address_book");
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("Name")
                        + "\n Address: " + resultSet.getString("Address")
                        + "\n City: " + resultSet.getString("City")
                        + "\n State: " + resultSet.getString("State")
                        + "\n Phone: " + resultSet.getString("Phone_No")
                        + "\n Email: " + resultSet.getString("Email"));


            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        retrievingEntriesFromAddressBookTable();
    }
}




