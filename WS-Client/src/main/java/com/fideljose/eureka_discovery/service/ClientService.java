package com.fideljose.eureka_discovery.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		modelMapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);
		ClientEntity entity = modelMapper.map(clientDto, ClientEntity.class);
		entity.setPasswordEncrypted(bCryptPasswordEncoder.encode(clientDto.getPassword()));
		String uuid = UUID.randomUUID().toString();
		entity.setIdClientDB(uuid);		
		
		ClientEntity cl = iClientRepository.save(entity);

		ClientDto cdto = modelMapper.map(cl, ClientDto.class);
		cdto.setPassword(cl.getPasswordEncrypted());
		return cdto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ClientEntity clientEntity = iClientRepository.findByEmail(email);
		if(clientEntity == null) throw new UsernameNotFoundException("Username(email) " + email + "Not Found"); 
		return new User(clientEntity.getEmail(), clientEntity.getPasswordEncrypted(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public ClientDto getUserDetailsByEmail(String email) {
		ClientEntity clientEntity = iClientRepository.findByEmail(email);
		if(clientEntity == null) throw new UsernameNotFoundException("Username(email) " + email + " Not Found");
		ClientDto dto = new ModelMapper().map(clientEntity, ClientDto.class);
		dto.setPassword(clientEntity.getPasswordEncrypted());
		return dto;
	}
	
}
