package com.security3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService useDetailsServices() {
		
		  InMemoryUserDetailsManager ud=new InMemoryUserDetailsManager();
		  
		  UserDetails user = User.withUsername("admin") 
				  .password("123")
				  .authorities("read")
		          .build();
		  ud.createUser(user); 
		  return ud;
		 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
