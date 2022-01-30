package com.securityFilter.filter;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class MyCustomAuthenticationToken extends UsernamePasswordAuthenticationToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6748800269918783390L;

	public MyCustomAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public MyCustomAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
   
}
