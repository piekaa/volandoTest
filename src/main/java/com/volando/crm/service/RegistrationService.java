package com.volando.crm.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volando.crm.DAO.UserRepository;
import com.volando.crm.model.Role;
import com.volando.crm.model.User;


@RestController
//@ComponentScan("com.volando.crm.DAO")
public class RegistrationService 
{
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value =  "registration/user", method=RequestMethod.POST)
	public boolean RegisterUser(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		
		if( userRepository.findByUsername(username).size() > 0 )
			return false;
		
		
		User user = new User(username, password);
		List<Role> roles = new LinkedList<Role>();
		roles.add(new Role("ROLE_USER"));
		
		user.setRoles(roles);
		
		userRepository.save(user);
		
		return true;
	}
	

}
