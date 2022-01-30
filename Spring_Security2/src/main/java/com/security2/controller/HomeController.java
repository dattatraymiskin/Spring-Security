package com.security2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security2.model.User;
import com.security2.service.MyUserService;

@RestController
public class HomeController {


	@Autowired
	MyUserService service;
	
	@GetMapping("/index" )
	public String home() {
		return "<h1>UserDeatials Manager!!!<h1>";
	}
	
	@PostMapping("/createUser")
	public void addUser(@RequestBody User user) {
		service.addUser(user);
	}
}
