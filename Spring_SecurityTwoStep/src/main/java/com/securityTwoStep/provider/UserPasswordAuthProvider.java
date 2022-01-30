package com.securityTwoStep.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.securityTwoStep.auth.UserPasswordAuthToken;
import com.securityTwoStep.service.MyUserDetailsService;
@Component
public class UserPasswordAuthProvider implements AuthenticationProvider{

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		var user = userDetailsService.loadUserByUsername(auth.getName());
		
		if(passwordEncoder.matches(auth.getCredentials()+"", user.getPassword())) {
			return new UserPasswordAuthToken(user.getUsername(), 
					user.getPassword(),
					user.getAuthorities());
			
		}
	    throw new BadCredentialsException("Failed Authentication");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UserPasswordAuthToken.class.equals(authentication);
	}

}
