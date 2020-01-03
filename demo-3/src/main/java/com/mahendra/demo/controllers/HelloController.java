package com.mahendra.demo.controllers;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello India!";
	}
	
	@GetMapping("/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Hello "+name;
	}
}
