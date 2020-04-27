package com.fideljose.eureka_discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String index() {
		return "Client Up, services Working!!! on port number:" 
				+ env.getProperty("local.server.port");
	}
	
}
