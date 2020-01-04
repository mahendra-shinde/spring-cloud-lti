package com.mahendra.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${spring.rabbitmq.username}")
	private String rabbitmqUser;
	
	@GetMapping("/")
	public String testConfig() {
		System.out.println("Processing the request");
		return "RabbitMQ User: "+rabbitmqUser;
	}
}
