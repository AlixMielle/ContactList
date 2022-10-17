package com.example.contactlist.repository;

import com.example.contactlist.repository.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c WHERE c.lastname LIKE %:keyword%")
    List<Contact> searchByName(@Param("keyword") String keyword);
}
