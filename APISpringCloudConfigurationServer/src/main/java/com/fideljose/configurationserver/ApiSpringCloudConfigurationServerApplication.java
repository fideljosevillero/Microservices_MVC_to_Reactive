package com.fideljose.configurationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ApiSpringCloudConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringCloudConfigurationServerApplication.class, args);
	}

}
