package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Contact viewDetails(ArrayList<Contact> contacts, String name) {
        // find the contact with the specified name
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }

        // if contact not found, return null
        return null;
    }
    


    @RequestMapping("/")
    @ResponseBody
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();

        // create a new contact
        Contact newContact = new Contact("jehad", "05981896562", "jehad@example.com", "here");
        contacts.add(newContact);

        // update a contact's phone number
        Contact contactToUpdate = contacts.get(0);
        contactToUpdate.setPhoneNumber("0987654321");

        // delete a contact
        contacts.remove(0);

        // view a list of all contacts
        for (Contact contact : contacts) {
            System.out.println(contact.getName());
        }
        
        // view a specific content 
        Contact specific = contacts.get(0);
        specific.viewDetails(contacts, "jehad");
        
        
    }


}
