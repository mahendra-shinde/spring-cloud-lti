package com.mahendra.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mahendra.demo.daos.ProductRepository;
import com.mahendra.demo.models.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired private ProductRepository productRepo;
	
	@GetMapping(value="/find/{id}",produces= {"application/json","application/xml"})
	public Product find(@PathVariable("id") Integer id) {
		return productRepo.findById(id);
	}
	
	// POST http://localhost:8081/products/save
	@PostMapping(value="/save",consumes="application/json")
	public ResponseEntity<String> save(@RequestBody Product product){
		try {
		productRepo.save(product);
		return new ResponseEntity<>("Saved !",HttpStatus.CREATED);
		}catch(RuntimeException ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	// PUT http://localhost:8081/products/update
	@PutMapping(value="/update",consumes="application/json")
	public ResponseEntity<String> update(@RequestBody Product product){
		try {
			productRepo.update(product);
			return new ResponseEntity<>("Saved !",HttpStatus.CREATED);
			}catch(RuntimeException ex) {
				System.out.println(ex.getMessage());
				return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
			}
	}
	
	// DELETE http://localhost:8081/products/{id}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		try {
			productRepo.delete(id);
			return new ResponseEntity<String>("Record Deleted",HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
}
