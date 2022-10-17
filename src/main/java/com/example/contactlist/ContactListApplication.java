package com.example.contactlist;

import com.example.contactlist.repository.ContactRepository;
import com.example.contactlist.repository.entity.Contact;
import com.example.contactlist.repository.entity.Link;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ContactListApplication implements CommandLineRunner {

    private ContactRepository contactRepository;

    public ContactListApplication(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ContactListApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");

        Contact contact1 = new Contact("Georges", "Michel", LocalDate.of(1957, 6, 13), "georges.m@axa.com", "0678987654","https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1200&q=60","AXA","comptable", "efficace", Link.NONE);
        contact1.addContact(contact1);
        contactRepository.save(contact1);

        Contact contact2 = new Contact("Ernest", "Paratroa", LocalDate.of(1948, 12, 25), "ernest.paratroa.m@edf.com", "0600987654","https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fG1lbiUyMHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1200&q=60","EDF","chef marketing", "a de bons contacts", Link.PERE);

        Contact contact3 = new Contact("Paul", "Tuile", LocalDate.of(1993, 2, 16), "paul.tuile@apple.com", "0654321294","https://images.unsplash.com/photo-1503443207922-dff7d543fd0e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bWVufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1200&q=60","Apple","Business Manager", "à rappeler pour partenariat", Link.FRERE);

        Contact contact4 = new Contact("Mathilde", "Tuile", LocalDate.of(1989, 3, 4), "mathilde.tm@cdiscount.com", "0678985434","https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1200&q=60","Cdiscount","Web Designer", "très créative", Link.SOEUR);

        Contact contact5 = new Contact("Lucinda", "Paratroa", LocalDate.of(1976, 11, 29), "lucinda@gouv.fr", "0698754364","https://images.unsplash.com/photo-1594744803329-e58b31de8bf5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8d29tYW58ZW58MHx8MHx8&auto=format&fit=crop&w=1200&q=60","Gouvernement","Assistante du premier ministre", "efficace", Link.FILLE);

        contact2.addContact(contact5);
        contact5.addContact(contact2);
        contactRepository.save(contact2);
        contactRepository.save(contact5);

        contact3.addContact(contact4);
        contact4.addContact(contact3);
        contactRepository.save(contact3);
        contactRepository.save(contact4);
    }
}
