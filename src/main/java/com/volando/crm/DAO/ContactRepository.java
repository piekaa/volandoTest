package com.volando.crm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volando.crm.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>
{}
