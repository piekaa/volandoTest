package pl.volanto.crm;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.volanto.crm.DAO.UserRepository;
import pl.volanto.crm.config.SpringSecurityConfig;
import pl.volanto.crm.model.Role;
import pl.volanto.crm.model.User;

@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(CrmApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner runner(UserRepository userRepository )
	{
		return args-> {
			if( !userRepository.existsByUsername("admin") )
			{
				User user = new User();
				user.setUsername("admin");
				user.setPassword(SpringSecurityConfig.passwordEncoder().encode("admin"));
				List<Role> roles = new LinkedList<Role>();
				roles.add( new Role("ROLE_ADMIN"));
				roles.add(new Role("ROLE_USER"));
				user.setRoles(roles);
				userRepository.save(user);
			}
		};
	}
}
