package com.mahendra.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class HomeController {

	@Autowired RestTemplate template;
	
	@GetMapping
	public String testIt() {
		System.out.println("Making a request to REST Service");
		String result = template.getForObject("http://book-service/", String.class);
		return result;
	}
}
