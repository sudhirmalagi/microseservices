package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigapplicationApplication.class, args);
//		System.out.println(System.getProperty("user.home"));
	}
}
