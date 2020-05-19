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
import com.fideljose.eureka_discovery.entity.ClientEntity;
import com.fideljose.eureka_discovery.service.ClientService;

//http://192.168.1.7:50811/client/status/check
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
    ClientService clientService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String index() {
		return "Client Up, services Working!!! on port number:" 
				+ env.getProperty("local.server.port");
	}
	
	@PostMapping("/save-client")
	public ResponseEntity<ClientDto> saveClient(@Valid @RequestBody ClientDto clientDto){
		ClientEntity c = new ClientEntity();
		c.setId(Long.parseLong(clientDto.getId()));
		c.setIdClientDB("iohuiggoipiuhi122");
		c.setAddress(clientDto.getAddress());
		c.setFirstName(clientDto.getFirstName());
		c.setLastName(clientDto.getLastName());
		c.setPasswordEncrypted("passwordEncrypted1");
		ClientEntity cl = clientService.save(c);
		ClientDto cdto = new ClientDto();
		cdto.setId(cl.getId().toString());
		cdto.setFirstName(cl.getFirstName());
		cdto.setLastName(cl.getLastName());
		cdto.setAddress(cl.getAddress());
		return new ResponseEntity<ClientDto>(cdto, HttpStatus.CREATED);
	}

	
}
