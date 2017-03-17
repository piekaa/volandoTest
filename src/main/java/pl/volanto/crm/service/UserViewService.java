package pl.volanto.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.volanto.crm.DAO.UserRepository;
import pl.volanto.crm.model.User;


@RestController
public class UserViewService 
{
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("admin/users")
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
}
