package com.fideljose.eureka_discovery.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fideljose.eureka_discovery.entity.ClientEntity;

@Repository
public interface IClientRepository extends CrudRepository<ClientEntity, Long> {
	
}
