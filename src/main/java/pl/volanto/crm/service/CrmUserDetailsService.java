package pl.volanto.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; 

import pl.volanto.crm.DAO.UserRepository; 
 
public class CrmUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	{
		
		Optional<pl.volanto.crm.model.User> optionalCrmUser = userRepository.findByUsername(username).stream().findFirst();
		
		if (optionalCrmUser.isPresent() == false )
		{
			System.out.println("User not found");
			return null;
		}
		
		else
		{ 
			pl.volanto.crm.model.User crmUser = optionalCrmUser.get(); 
			User user = new User(crmUser.getUsername(), crmUser.getPassword(), crmUser.getRoles());
			return user;
		}
	}
	
}
