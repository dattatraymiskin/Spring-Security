package com.securityFilter.filter;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MyBasicCustomAuthenticationFilter implements Filter{

	@Autowired
	AuthenticationManager manager;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
		// based on request 
		HttpServletRequest request=(HttpServletRequest) req;
		String authObj = request.getHeader("auth_key");
		//create authentication object
        MyCustomAuthenticationToken token = new MyCustomAuthenticationToken(authObj,null);
     
      //delegate obj to AuthenticationManager--> Authentication Provoider
        try {
        	Authentication authenticate = manager.authenticate(token);
        	
        	//for use save principal into Security Context
        	if(authenticate.isAuthenticated()) {
        		SecurityContextHolder.getContext().setAuthentication(authenticate);
        		chain.doFilter(req, response);
        	}
		} catch (AuthenticationException e) {
			new BadCredentialsException("Invalid Pricipal");
		}
        
	}

}
