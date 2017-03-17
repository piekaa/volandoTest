package com.volando.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact 
{
	@Id
	@GeneratedValue
	private Long ContactId;
	
	private String Name;
	private String Surname;
	private String Company;
	private String Phone;
	private String Email;
	public Long getContactId() {
		return ContactId;
	}
	public void setContactId(Long contactId) {
		ContactId = contactId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Contact() {
		super();
	}
	
	
	
	
	
	
	
}
