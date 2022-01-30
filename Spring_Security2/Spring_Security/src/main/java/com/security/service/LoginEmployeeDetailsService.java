package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.model.Employee;
import com.security.repo.EmployeeRepository;
import com.security.repo.LoginEmployee;

public class LoginEmployeeDetailsService implements UserDetailsService{

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<Employee> username2 = repo.findByUsername(username);
		 Employee employee = username2.orElseThrow(() -> new UsernameNotFoundException("Employee Not Found"));
		return new LoginEmployee(employee);
		
	}

}
