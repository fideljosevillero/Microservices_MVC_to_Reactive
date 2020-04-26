package com.fideljose.eureka_discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountComntroller {

	@GetMapping("/status/check")
	public String status() {
		return "Service Up and Working!";
	}
	
	
}
