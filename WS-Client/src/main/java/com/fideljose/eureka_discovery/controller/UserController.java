package com.fideljose.eureka_discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/index")
	public String index() {
		return "Fine!!!";
	}
	
}
