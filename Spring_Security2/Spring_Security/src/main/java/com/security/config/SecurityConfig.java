package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.service.LoginEmployeeDetailsService;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService useDetailsServices() {
		return new LoginEmployeeDetailsService();
		
		/*
		 * InMemoryUserDetailsManager ud=new InMemoryUserDetailsManager();
		 * 
		 * var user = User.withUsername("admin") .password("123") .authorities("read")
		 * .build(); ud.createUser(user); return ud;
		 */
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
