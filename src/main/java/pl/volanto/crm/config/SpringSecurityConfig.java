package pl.volanto.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import pl.volanto.crm.service.CrmUserDetailsService;


@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{  
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/users").permitAll()
		.anyRequest().hasRole("USER")
	//	.anyRequest().permitAll()
		.and()
		.formLogin();
	}
	
	@Autowired
	public void configureGloabl(AuthenticationManagerBuilder auth) throws Exception
	{ 
		auth.userDetailsService(userDetailsService());
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new CrmUserDetailsService();
	}
	
}
