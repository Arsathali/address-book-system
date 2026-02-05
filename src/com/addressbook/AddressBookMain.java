package com.addressbook;

import java.util.Scanner;

import com.addressbook.model.ContactPerson;
import com.addressbook.repository.AddressBookSystem;
import com.addressbook.service.AddressBook;

public class AddressBookMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program.");
        System.out.println();

        AddressBookSystem addressBookSystem = new AddressBookSystem();
        char addMore;
        do{
       
            System.out.println("Enter the Addresss Book Name");
            String bookName = scanner.nextLine();
            addressBookSystem.addAddressBook(bookName);
            AddressBook addressBook = addressBookSystem.getAddressBook(bookName);

            int choice;
                do{
                    System.out.println("1.Add Contact to "+bookName);
                    System.out.println("2.Edit the Contact");
                    System.out.println("3.Delete the Contact");
                    System.out.println("4.Exit");

                    System.out.println();
                    System.out.println("Enter Your Choice");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (choice) {

                            case 1:
                                addContact(addressBook);
                                break;
                            case 2:
                                editContact(addressBook);
                                break;
                            case 3:
                                deleteContact(addressBook);
                                break;
                            case 4:
                                break;
                            default:
                                break;
                    }

                }while(choice != 4);

                System.out.println("Do you want to add another Address Book? (Y/N)");
                addMore = scanner.nextLine().charAt(0);

        }while(addMore == 'Y' || addMore == 'y');
    }

    private static void deleteContact(AddressBook addressBook) {
        
        System.out.println("Enter First Name of contact to Delete:");
        String nameToDelete = scanner.nextLine();

        boolean isDeleted = addressBook.deleteContact(nameToDelete);

        if (isDeleted) {
            System.out.println("Contact Deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }

    }

    private static void editContact(AddressBook addressBook) {
        
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
    private static void addContact(AddressBook addressBook){
        
        System.out.println("Add a ContactPerson:");
        System.out.println();

        System.out.println("Enter the firstName: ");
        String fName = scanner.nextLine();

        System.out.println("Enter the LastName: ");
        String lName = scanner.nextLine();

        System.out.println("Enter the Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter the City: ");
        String city = scanner.nextLine();

        System.out.println("Enter the State: ");
        String state = scanner.nextLine();

        System.out.println("Enter the Zip: ");
        String zip = scanner.nextLine();

        System.out.println("Enter the Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter the E-Mail: ");
        String email = scanner.nextLine();

        //creating contact
        ContactPerson person = new ContactPerson(fName, lName, address, city, state, zip, phoneNumber, email);
        boolean isAdded = addressBook.addContact(person);

        if (isAdded) {
            System.out.println("Contact Added Successfully");
        } else {
            System.out.println("Duplicate Contact. Entry not allowed.");
        }
                
    }
}
