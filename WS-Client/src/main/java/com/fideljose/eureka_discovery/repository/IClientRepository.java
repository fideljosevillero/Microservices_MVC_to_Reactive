package com.fideljose.eureka_discovery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fideljose.eureka_discovery.entity.ClientEntity;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
	
}
