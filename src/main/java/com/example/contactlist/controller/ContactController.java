package com.example.contactlist.controller;

import com.example.contactlist.ContactListApplication;
import com.example.contactlist.controller.dto.CreateContact;
import com.example.contactlist.repository.entity.Contact;
import com.example.contactlist.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public String displayAllContacts(Model model, @RequestParam(value = "keyword", required = false) String keyword){
        List<Contact> contactList = contactService.findContactByName(keyword);
        model.addAttribute("contacts", contactList);
        model.addAttribute("keyword", keyword);
        return "listcontactsView";
    }

    @GetMapping("/details/{id}")
    public String displayOneContact(@PathVariable("id") long contactId, Model model){
        Contact contact = contactService.findContactById(contactId);
        model.addAttribute("contact", contact);
        return "detailContactView";
    }

    @GetMapping("/add")
    public String createContactForm(Model model){
        List<Contact> contactListLink = contactService.findAllContacts();
        //todo liste enum ?
        model.addAttribute("contactListLink", contactListLink);
        return "createContactForm";
    }

    @PostMapping("/add")
    public String createContact(CreateContact createContact){
        contactService.addContact(createContact);
        return "redirect:/contacts/all";
    }

    @PostMapping ("/delete/{id}")
    public RedirectView deleteContact(@PathVariable("id") long id){
        contactService.deleteContact(id);
        return new RedirectView("/contacts/all");
    }

    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable("id") long id, Model model){
        Contact contact = contactService.findContactById(id);
        model.addAttribute("contact", contact);
        return "editContactForm";
    }

    @PostMapping ("/edit/{id}")
    public RedirectView editContact(@PathVariable("id") long id, CreateContact editContact){
        contactService.editContact(id,editContact);
        return new RedirectView("/contacts/details/" + id);
    }

}
