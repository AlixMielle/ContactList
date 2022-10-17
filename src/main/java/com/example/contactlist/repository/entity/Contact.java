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

    @Enumerated(EnumType.STRING)
    private Enum familyLink;

    @ManyToMany
    @JoinTable(name="contact_link",
            joinColumns = @JoinColumn(name = "contact1_fk"),
            inverseJoinColumns = @JoinColumn(name = "contact2_fk"))
    private List<Contact> contactLinkList = new ArrayList<>();

    public Contact() {
    }

    public Contact(String firstname, String lastname, LocalDate dateBirth, String email, String mobile, String pictureUrl, String company, String job, String note, Enum familyLink) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateBirth = dateBirth;
        this.email = email;
        this.mobile = mobile;
        this.pictureUrl = pictureUrl;
        this.company = company;
        this.job = job;
        this.note = note;
        this.familyLink = familyLink;
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

    public Enum getFamilyLink() {
        return familyLink;
    }

    public void setFamilyLink(Enum familyLink) {
        this.familyLink = familyLink;
    }

    public List<Contact> getContactLinkList() {
        return contactLinkList;
    }

    public void setContactLinkList(List<Contact> contactLinkList) {
        this.contactLinkList = contactLinkList;
    }

    public void addContact(Contact contact){
        this.contactLinkList.add(contact);
        contact.getContactLinkList().add(this);
    }
}
