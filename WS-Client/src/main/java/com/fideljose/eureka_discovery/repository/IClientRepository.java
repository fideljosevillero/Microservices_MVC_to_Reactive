package com.fideljose.eureka_discovery.repository;


import org.springframework.data.repository.CrudRepository;

import com.fideljose.eureka_discovery.entity.ClientEntity;

public interface IClientRepository extends CrudRepository<ClientEntity, Long> {
	
}
