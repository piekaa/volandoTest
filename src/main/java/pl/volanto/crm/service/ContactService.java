package pl.volanto.crm.service;

import java.util.List;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.volanto.crm.DAO.ContactRepository;
import pl.volanto.crm.model.Contact;


@RestController
public class ContactService 
{ 
	ContactRepository contactRepository;
	  
	public ContactService(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@RequestMapping(value = "contacts")
	public List<Contact> getContacts()
	{
		return contactRepository.findAll();
	}
	
	
	@RequestMapping(value = "contacts/{id}")
	public Contact getContact(@PathVariable Long id)
	{
		return contactRepository.findOne(id);
	}
	
	
	
	@RequestMapping(value = "contacts", method = RequestMethod.POST)
	public Contact createContact(@RequestBody Contact contact)
	{
		return contactRepository.save(contact);
	}
	

	@RequestMapping(value = "contacts" , method=RequestMethod.PUT)
	public Contact editContact(@RequestBody Contact contact)
	{
		return contactRepository.save(contact);
	}
	
	@RequestMapping(value = "contacts/{id}" , method=RequestMethod.PATCH)
	public Contact editContact(@PathVariable Long id, @RequestBody Contact toEdit)
	{
		Contact contact = contactRepository.findOne(id);
		
		contact.CopyNotNullValues(toEdit);
		
		contact = contactRepository.save(contact);
		
		return contact;
		
	}
	
	
	@RequestMapping( value = "contacts/{id}" , method=RequestMethod.DELETE)
	public void deleteContact(@PathVariable Long id)
	{
		contactRepository.delete(id);
	}
	
	
	
}
