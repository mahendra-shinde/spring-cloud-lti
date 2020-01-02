package com.mahendra.demo.daos;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.mahendra.demo.models.Product;

@Repository
public class ProductRepository {
	
	List<Product> products = new LinkedList<>();
	
	@PostConstruct
	public void init() {
		System.out.println("Generate sample data");
		products.add(new Product("Product A",101,"Sample product A",120D));
		products.add(new Product("Product B",102,"Sample product B",110.3D));
		products.add(new Product("Product C",103,"Sample product C",320.67D));
	}
	
	public Product findById(int id) {
		
		return products.stream().filter(p->p.getId()==id).findFirst().get();
	}
}
