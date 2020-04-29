package com.fideljose.eureka_discovery.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fideljose.eureka_discovery.dto.ClientDto;

public class ClientService implements IClientService {

	@Autowired
	IClientService iClientService;

	@Override
	public ClientDto save(ClientDto clientDto) {
		ClientDto client = iClientService.save(clientDto);
		return client;
	}
	
}
