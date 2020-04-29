package com.fideljose.eureka_discovery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fideljose.eureka_discovery.dto.ClientDto;
import com.fideljose.eureka_discovery.service.IClientService;
import com.sun.jersey.api.client.ClientResponse.Status;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	IClientService iClientService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String index() {
		return "Client Up, services Working!!! on port number:" 
				+ env.getProperty("local.server.port");
	}
	
	@PostMapping("/save-client")
	public ResponseEntity<ClientDto> saveClient(@Valid @RequestBody ClientDto clientDto){
		ClientDto cl = iClientService.save(clientDto);
		return new ResponseEntity<ClientDto>(cl, HttpStatus.CREATED);
	}

	
}
