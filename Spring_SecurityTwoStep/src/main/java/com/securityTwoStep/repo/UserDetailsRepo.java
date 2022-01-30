package com.securityTwoStep.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityTwoStep.model.User;

public interface UserDetailsRepo extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String uname);
}
