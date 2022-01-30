package com.securityTwoStep.auth;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserPasswordAuthToken extends UsernamePasswordAuthenticationToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserPasswordAuthToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public UserPasswordAuthToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

	
}
