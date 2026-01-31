package com.addressbook.repository;
import com.addressbook.service.AddressBook;
import java.util.*;

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
}
