package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import com.addressbook.model.ContactPerson;

public class AddressBook {
    
    private static List<ContactPerson> addressBook = new ArrayList<>();

    //Adding contact to addressBook
    public void addContact(ContactPerson person){

        addressBook.add(person);
    }
    
}
