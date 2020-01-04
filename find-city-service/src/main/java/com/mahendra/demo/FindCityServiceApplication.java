package com.mahendra.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FindCityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindCityServiceApplication.class, args);
	}

}
