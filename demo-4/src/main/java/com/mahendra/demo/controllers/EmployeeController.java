package com.mahendra.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//// URL http://localhost:8081/emps
@RequestMapping("/emps")
public class EmployeeController {

	
	// GET http://localhost:8081/emps
	@GetMapping
	public String doGet() {
		return "Processing GET type method!";
	}
	
	// PUT GET http://localhost:8081/emps
	@PutMapping
	public String doPut() {
		return "Processing PUT type method!";
	}
	
	
	// DELETE GET http://localhost:8081/emps
	@DeleteMapping
	public String doDelete() {
		return "Processing DELETE type method!";
	}
	
	// POST http://localhost:8081/emps
	@PostMapping
	public String doPost() {
		return "Processing POST type method!";
	}
}
