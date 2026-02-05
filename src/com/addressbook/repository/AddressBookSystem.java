package com.addressbook.repository;
import com.addressbook.model.ContactPerson;
import com.addressbook.service.AddressBook;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class AddressBookSystem {
    
    private Map<String,AddressBook> addressBookSystem = new HashMap<>();

    public void addAddressBook(String name) {
        if (addressBookSystem.containsKey(name)) {
            System.out.println("Address Book already exists");
            return;
        }
        addressBookSystem.put(name, new AddressBook());
        System.out.println("Address Book created: " + name);
    }

    public AddressBook getAddressBook(String name) {
        return addressBookSystem.get(name);
    }

    
    public List<ContactPerson> searchPersonsByCity(String city){

       return addressBookSystem.values()
                                .stream()
                                .flatMap(book -> book.getAllContacts().stream())
                                .filter(person -> person.getCity().equalsIgnoreCase(city))
                                .toList();
    }


    public List<ContactPerson> searchPersonsByState(String state){

        return addressBookSystem.values()
                                .stream()
                                .flatMap(book -> book.getAllContacts().stream())
                                .filter(person -> person.getState().equalsIgnoreCase(state))
                                .toList();
    }


}
