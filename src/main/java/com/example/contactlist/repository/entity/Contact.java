package com.example.contactlist.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private LocalDate dateBirth;
    private String email;
    private String mobile;
    private String pictureUrl;
    private String company;
    private String job;
    private String note;

    private String link;

    @ManyToOne
    @JoinColumn(name = "contact_principal_id")
    private Contact contactPrincipal;

    @OneToMany(mappedBy= "contactPrincipal", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    public Contact() {
    }

    public Contact(String firstname, String lastname, LocalDate dateBirth, String email, String mobile, String pictureUrl, String company, String job, String note, String link) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateBirth = dateBirth;
        this.email = email;
        this.mobile = mobile;
        this.pictureUrl = pictureUrl;
        this.company = company;
        this.job = job;
        this.note = note;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Contact getContactPrincipal() {
        return contactPrincipal;
    }

    public void setContactPrincipal(Contact contactPrincipal) {
        this.contactPrincipal = contactPrincipal;
    }

    public List<Contact> getcontacts() {
        return contacts;
    }

    public void setContactLinkList(List<Contact> contactLinkList) {
        this.contacts = contactLinkList;
    }

    public void addContact(Contact contactPrincipal) {
        this.contacts.add(contactPrincipal);
        contactPrincipal.getcontacts().add(this);
    }
}
