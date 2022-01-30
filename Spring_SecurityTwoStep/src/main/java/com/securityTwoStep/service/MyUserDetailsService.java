package com.securityTwoStep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.securityTwoStep.model.SecureUser;
import com.securityTwoStep.model.User;
import com.securityTwoStep.repo.UserDetailsRepo;

@Component
public class MyUserDetailsService  implements UserDetailsService{

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u= userDetailsRepo.findByUsername(username).orElse(new User());
		return new SecureUser(u);
	}
}
