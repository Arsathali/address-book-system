package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.addressbook.model.ContactPerson;

public class AddressBook {
    
    private List<ContactPerson> addressBook = new ArrayList<>();
    

    //Adding contact to addressBook
    public boolean addContact(ContactPerson person){

        //stream logic
        boolean isDuplicate = addressBook.stream().anyMatch(existingPerson -> existingPerson.equals(person));

        if(isDuplicate){
            return false;
        }
        addressBook.add(person);
        return true;
    }

    //Edit the contact In addressBook
    public boolean editContact(String fName,ContactPerson updatedData){

        for(ContactPerson person : addressBook){

            if(fName.equalsIgnoreCase(person.getFirstName())){
                person.setAddress(updatedData.getAddress());
                person.setCity(updatedData.getCity());
                person.setState(updatedData.getState());
                person.setZip(updatedData.getZip());
                person.setPhoneNumber(updatedData.getPhoneNumber());
                person.setEmail(updatedData.getEmail());
                return true;
            }
        }
        return false;
    }

    //deleting contact
    public boolean deleteContact(String fName){

        for(ContactPerson person : addressBook){

            if(fName.equalsIgnoreCase(person.getFirstName())){
                addressBook.remove(person);
                return true;
            }
        }
        return false;
    }
}
