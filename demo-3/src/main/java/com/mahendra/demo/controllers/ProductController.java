package com.mahendra.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
