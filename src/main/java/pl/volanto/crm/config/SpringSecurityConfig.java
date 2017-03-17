package pl.volanto.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; 

import pl.volanto.crm.DAO.UserRepository;
import pl.volanto.crm.service.CrmUserDetailsService;


@EnableWebSecurity 
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{  
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/users").permitAll()
		.anyRequest().hasRole("USER") 
		.and()
		.formLogin();
	}
	
	@Autowired
	public void configureGloabl(AuthenticationManagerBuilder auth) throws Exception
	{ 
		auth.
		userDetailsService(userDetailsService())
		.passwordEncoder(passwordEncoder());
	}
	
	UserRepository userRepository;
	
	
	
	
	public SpringSecurityConfig(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Bean
	public UserDetailsService userDetailsService()
	{
		return new CrmUserDetailsService(userRepository);
	}
	
	
	@Bean
	public static PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
