package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.encrypt.RsaProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudconfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudconfigServerApplication.class, args);
	}
	
	/*@Bean
	RsaProperties rsaProperties() {
		return new RsaProperties();
	}*/
}
