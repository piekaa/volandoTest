package pl.volanto.crm.service;

import java.util.List;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.volanto.crm.DAO.UserRepository;
import pl.volanto.crm.model.User;


@RestController
public class UserViewService 
{
	  
	public UserViewService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private UserRepository userRepository;
	
	@RequestMapping("admin/users")
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
}
