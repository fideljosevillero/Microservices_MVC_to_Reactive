package com.fideljose.eureka_discovery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fideljose.eureka_discovery.dto.ClientDto;
import com.fideljose.eureka_discovery.dto.LoginUserDto;
import com.fideljose.eureka_discovery.service.IClientService;

//http://192.168.1.7:50811/client/status/check
//http://laptop-co51gmud:[PORT-ZULLGATEWAY]/ws-client/client/status/check
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
    IClientService iclientService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String index() {
		return "Client Up, services Working!!! on port number:" 
				+ env.getProperty("local.server.port");
	}
	
	@PostMapping("/save-client")
	public ResponseEntity<ClientDto> saveClient(@Valid @RequestBody ClientDto clientDto){
		ClientDto cdto = iclientService.save(clientDto);
		return new ResponseEntity<ClientDto>(cdto, HttpStatus.CREATED);
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<ClientDto> login(@RequestBody LoginUserDto loginUserDto) {
//		UserDetails cdto = iclientService.loadUserByUsername(loginUserDto.getEmail());
//		
//		return new ResponseEntity<ClientDto>(new ClientDto(), HttpStatus.CREATED);
//	}

	
}
