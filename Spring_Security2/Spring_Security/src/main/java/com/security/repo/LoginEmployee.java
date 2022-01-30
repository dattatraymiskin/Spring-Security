package com.security.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.model.Employee;

public class LoginEmployee implements UserDetails{
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private Employee emp;
	
	public LoginEmployee(Employee emp) {
		super();
		this.emp = emp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->"read");
	}

	@Override
	public String getPassword() {
		return emp.getPassword();
	}

	@Override
	public String getUsername() {
		return emp.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
