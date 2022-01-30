package com.securityCSRF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home() {
		System.out.println("hi");
		return "home.html";
	}
	@PostMapping("/saveData")
	public String from(String uname) {
		System.out.println(uname);
		return "home.html";
	}
}
