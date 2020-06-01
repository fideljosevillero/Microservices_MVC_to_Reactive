package com.fideljose.eureka_discovery.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fideljose.eureka_discovery.dto.ClientDto;

public interface IClientService extends UserDetailsService {

	ClientDto save(ClientDto clientDto);
	ClientDto getUserDetailsByEmail(String email);
	
}
