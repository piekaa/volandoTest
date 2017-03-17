package pl.volanto.crm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.volanto.crm.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>
{}
