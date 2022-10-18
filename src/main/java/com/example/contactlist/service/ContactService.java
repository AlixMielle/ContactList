package com.example.contactlist.service;

import com.example.contactlist.controller.dto.CreateContact;
import com.example.contactlist.exception.ContactNotFoundException;
import com.example.contactlist.repository.ContactRepository;
import com.example.contactlist.repository.entity.Contact;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private StorageService storageService;

    public ContactService(ContactRepository contactRepository, StorageService storageService) {
        this.contactRepository = contactRepository;
        this.storageService = storageService;
    }

    public List<Contact> findAllContacts() {
        return (List<Contact>) this.contactRepository.findAll();
    }

    public List<Contact> findContactByName(String keyword) {
        if (keyword != null){
            return this.contactRepository.searchByName(keyword);
        }
        return (List<Contact>) this.contactRepository.findAll();
    }

    public Contact findContactById(long id) {
        return this.contactRepository
                .findById(id)
                .orElseThrow(()->new ContactNotFoundException(id));
    }

    public void addContact(CreateContact createContact) {
        //List<Long> contactIds = createContact.getContactIds();

        //demande de chercher les objets avec les id demandés
        //List<Contact> contactList = (List<Contact>) contactRepository.findAllById(contactIds);

        Contact c = new Contact();
        c.setFirstname(createContact.getFirstname());
        c.setLastname(createContact.getLastname());
        c.setDateBirth(createContact.getDateBirth());
        c.setEmail(createContact.getEmail());
        c.setMobile(createContact.getMobile());
        c.setCompany(createContact.getCompany());
        c.setJob(createContact.getJob());
        c.setNote(createContact.getNote());
        c.setLink(createContact.getLink());

        MultipartFile picture = createContact.getPictureFile();
        if (picture == null || picture.isEmpty()){
            c.setPictureUrl(createContact.getPictureUrl());
        } else {
            storageService.store(picture);
            c.setPictureUrl("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        this.contactRepository.save(c);
    }

    public void deleteContact(long id) {
        contactRepository.deleteById(id);
    }

    public void editContact(long id, CreateContact editContact) {
        Contact contact = this.contactRepository
                .findById(id)
                .orElseThrow(()->new ContactNotFoundException(id));

        contact.setFirstname(editContact.getFirstname());
        contact.setLastname(editContact.getLastname());
        contact.setDateBirth(editContact.getDateBirth());
        contact.setEmail(editContact.getEmail());
        contact.setMobile(editContact.getMobile());
        contact.setCompany(editContact.getCompany());
        contact.setJob(editContact.getJob());
        contact.setNote(editContact.getNote());
        contact.setLink(editContact.getLink());
        this.contactRepository.save(contact);
    }



}
