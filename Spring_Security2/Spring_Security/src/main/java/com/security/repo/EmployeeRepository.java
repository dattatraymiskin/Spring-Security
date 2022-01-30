package com.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByUsername(String uname);
}
