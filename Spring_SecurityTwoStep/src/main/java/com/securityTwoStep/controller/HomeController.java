package com.securityTwoStep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


	
	@GetMapping("/hello" )
	public String home() {
		return "<h1>Hi 2 Step Authentication<h1>";
	}
	
}
