package com.fideljose.eureka_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.fideljose.eureka_discovery.repository.IClientRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class WsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsClientApplication.class, args);
	}
	
	

}
