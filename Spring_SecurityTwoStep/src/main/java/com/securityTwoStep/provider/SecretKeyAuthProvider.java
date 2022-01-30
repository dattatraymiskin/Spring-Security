package com.securityTwoStep.provider;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.securityTwoStep.auth.SecretKeyAuthToken;
import com.securityTwoStep.model.UserSecretKey;
import com.securityTwoStep.repo.UserSecretKeyRepo;
import com.securityTwoStep.service.MyUserDetailsService;

@Component
public class SecretKeyAuthProvider implements AuthenticationProvider {

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserSecretKeyRepo userSecretKeyRepo;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		 Optional<UserSecretKey> user = userSecretKeyRepo.findByUsername(auth.getName());
		
		if(user.isPresent()) {
			return new SecretKeyAuthToken(auth.getName(),auth.getCredentials(), Arrays.asList(()-> "read"));
		}
		  throw new BadCredentialsException("Failed Secret-key Authentication ?? ");
	}

	@Override
	public boolean supports(Class<?> authentication) {
       return SecretKeyAuthToken.class.equals(authentication);
	}

}
