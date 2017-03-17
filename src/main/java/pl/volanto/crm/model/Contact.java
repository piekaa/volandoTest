package pl.volanto.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 

@Entity
public class Contact 
{
	@Id
	@GeneratedValue
	private Long contactId;
	
	private String name;
	private String surname;
	private String company;
	private String phone;
	private String email;
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Contact() {
		super();
	}
	
	
	public void CopyNotNullValues(Contact c)
	{ 
		if( c.email != null) email = c.email;
		if( c.phone != null) phone = c.phone;
		if( c.company != null) company = c.company;
		if( c.name != null) name = c.name;
		if( c.surname != null ) surname = c.surname;
	}
	
}

