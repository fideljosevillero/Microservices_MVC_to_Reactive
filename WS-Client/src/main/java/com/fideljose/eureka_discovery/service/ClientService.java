package com.fideljose.eureka_discovery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fideljose.eureka_discovery.entity.ClientEntity;
//import com.fideljose.eureka_discovery.repository.IClientRepository;
import com.fideljose.eureka_discovery.repository.IClientRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
	IClientRepository iClientRepository;

	@Override
	public ClientEntity save(ClientEntity clientEntity) {
		ClientEntity client = iClientRepository.save(clientEntity);
		return client;
	}
	
}
