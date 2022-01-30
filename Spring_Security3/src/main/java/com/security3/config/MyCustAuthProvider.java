package com.security3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyCustAuthProvider  implements AuthenticationProvider{

	@Autowired
	UserDetailsService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//authenticate to authentication user request
		
		//throws AuthenticationException/return null
	
		//Password From user input
		String password = authentication.getCredentials().toString();
		//Password Fetch from db
		UserDetails user = service.loadUserByUsername(authentication.getName());
		
		if(user!=null && passwordEncoder.matches(password, user.getPassword())) {
			return new UsernamePasswordAuthenticationToken
			(authentication.getName(), authentication.getCredentials().toString());
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
