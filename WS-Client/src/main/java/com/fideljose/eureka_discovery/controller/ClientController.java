package com.fideljose.eureka_discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

	@GetMapping("/status/check")
	public String index() {
		return "Client Up, services Working!!!";
	}
	
}
