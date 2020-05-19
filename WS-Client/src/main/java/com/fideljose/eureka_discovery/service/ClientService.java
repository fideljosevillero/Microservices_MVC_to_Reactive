package com.fideljose.eureka_discovery.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fideljose.eureka_discovery.dto.ClientDto;
import com.fideljose.eureka_discovery.entity.ClientEntity;
//import com.fideljose.eureka_discovery.repository.IClientRepository;
import com.fideljose.eureka_discovery.repository.IClientRepository;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	IClientRepository iClientRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public ClientService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		ClientEntity c = new ClientEntity();
		c.setPasswordEncrypted(bCryptPasswordEncoder.encode("passwordToByCrypter"));
		c.setId(clientDto.getId());
		c.setIdClientDB("iohuiggoipiuhi1221");
		c.setAddress(clientDto.getAddress());
		c.setFirstName(clientDto.getFirstName());
		c.setLastName(clientDto.getLastName());
		ClientEntity cl = iClientRepository.save(c);

		modelMapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);
		ClientDto cdto = modelMapper.map(cl, ClientDto.class);
		return cdto;
	}
	
}
