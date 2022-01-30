package com.securityFilter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


	@RequestMapping("/hello")
	public String home() {
		return "<h1>Custom Authetication filter<h1>";
	}
}
