package com.addressbook;

import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;

public class AddressBookMain {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program....!!!");

        System.out.println("Add a ContactPerson");
        System.out.println();

        System.out.println("Enter the firstName");
        String fName = scanner.nextLine();

        System.out.println("Enter the LastName");
        String lName = scanner.nextLine();

        System.out.println("Enter the Address");
        String address = scanner.nextLine();

        System.out.println("Enter the City");
        String city = scanner.nextLine();

        System.out.println("Enter the State");
        String state = scanner.nextLine();

        System.out.println("Enter the Zip");
        int zip = scanner.nextInt();

        System.out.println("Enter the Phone Number");
        int phoneNumber = scanner.nextInt();

        System.out.println("Enter the E-Mail");
        String email = scanner.nextLine();
        
        //creating contact
        ContactPerson person = new ContactPerson(fName, lName, address, city, state, zip, phoneNumber, email);

        //Service class Object
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(person);
    }
}
