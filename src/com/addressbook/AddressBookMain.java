package com.addressbook;

import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;

public class AddressBookMain {

    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program....!!!");
        System.out.println();

        int choice;
        do{
            System.out.println("1.Add Contact");
            System.out.println("2.Edit the Contact");
            System.out.println("3.Delete the Contact");
            System.out.println("4.Exit");

            System.out.println();
            System.out.println("Enter Your Choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {

                    case 1:
                        addContact();
                        break;
                    case 2:
                        editContact();
                        break;
                    case 3:
                        deleteContact();
                        break;
                    case 4:
                        break;
                    default:
                        break;
            }

        }while(choice != 4);


        
    }

    private static void deleteContact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteContact'");
    }

    private static void editContact() {
        
        System.out.println("Enter First Name of contact to edit:");
        String nameToEdit = scanner.nextLine();

        System.out.println("Enter new Address:");
        String address = scanner.nextLine();

        System.out.println("Enter new City:");
        String city = scanner.nextLine();

        System.out.println("Enter new State:");
        String state = scanner.nextLine();

        System.out.println("Enter new Zip:");
        String zip = scanner.nextLine();
        scanner.nextLine(); // consume newline

        System.out.println("Enter new Phone Number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter new Email:");
        String email = scanner.nextLine();

        // temporary object holding updated data
        ContactPerson updatedPerson = new ContactPerson(null,null,address,city,state,zip,phoneNumber,email);
        boolean isEdited = addressBook.editContact(nameToEdit,updatedPerson);

        if (isEdited) {
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    //adding contact
    private static void addContact(){
        
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
        String zip = scanner.nextLine();

        System.out.println("Enter the Phone Number");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter the E-Mail");
        String email = scanner.nextLine();
        
        //creating contact
        ContactPerson person = new ContactPerson(fName, lName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(person);
        System.out.println("Contact Added Successfully");
    }
}
