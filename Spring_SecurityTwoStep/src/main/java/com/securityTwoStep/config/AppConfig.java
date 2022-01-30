package com.securityTwoStep.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.securityTwoStep.filter.ReceiptAuthFilter;
import com.securityTwoStep.filter.UserPasswordAuthFilter;
import com.securityTwoStep.provider.ReceiptAuthProvider;
import com.securityTwoStep.provider.SecretKeyAuthProvider;
import com.securityTwoStep.provider.UserPasswordAuthProvider;

@SuppressWarnings("deprecation")
@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	UserPasswordAuthFilter filter;
	
	@Autowired
	UserPasswordAuthProvider userPasswordAuthProvider;
	
	@Autowired
	SecretKeyAuthProvider secretKeyAuthProvider;
	
	//@Autowired ReceiptAuthFilter receiptAuthFilter;
	
	@Autowired
	ReceiptAuthProvider receiptAuthProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(userPasswordAuthProvider)
		.authenticationProvider(secretKeyAuthProvider)
		.authenticationProvider(receiptAuthProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(filter, BasicAuthenticationFilter.class)
		.addFilterBefore(receiptAuthFilter(), BasicAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		 return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public ReceiptAuthFilter receiptAuthFilter() {
		return new ReceiptAuthFilter();
	}
	
}
