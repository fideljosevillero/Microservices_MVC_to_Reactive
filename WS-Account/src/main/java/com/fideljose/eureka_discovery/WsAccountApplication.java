package com.fideljose.eureka_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WsAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsAccountApplication.class, args);
	}

}
