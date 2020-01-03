package com.mahendra.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mahendra.demo.controllers.HelloController;
import com.mahendra.demo.controllers.ProductController;
import com.mahendra.demo.models.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Autowired private HelloController hello;
	@Autowired private ProductController product;
	
	@Test
	public void contextLoads() {
		String result = hello.sayHello();
		assertEquals("Hello India!", result);
	}
	
	@Test
	public void testProductFind() {
		Product p = product.find(101);
		assertNotNull(p);
	}

}
