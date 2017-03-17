package pl.volanto.crm.service;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.volanto.crm.DAO.UserRepository;
import pl.volanto.crm.model.Role;
import pl.volanto.crm.model.User;


@RestController
//@ComponentScan("com.volando.crm.DAO")
public class UserService 
{
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value =  "users", method=RequestMethod.POST)
	public User RegisterUser(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		
		if( userRepository.findByUsername(username).size() > 0 )
			return null;
		
		
		User user = new User(username, password);
		List<Role> roles = new LinkedList<Role>();
		roles.add(new Role("ROLE_USER"));
		
		user.setRoles(roles);
		
		userRepository.save(user);
		
		return user;
	}
	
	@RequestMapping(value="users", method=RequestMethod.PUT)
	public User updateUser(@RequestBody User user, Principal principal)
	{ 
		Optional<User> optionalCurrentUser = userRepository.findByUsername(principal.getName()).stream().findFirst();
		 
		User currentUser = optionalCurrentUser.get();
		
		currentUser.setImage(user.getImage());
		
		User savedUser = userRepository.save(currentUser);
		
		return savedUser;
	}
	
	

}
