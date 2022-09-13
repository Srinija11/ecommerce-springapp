package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Product;
import com.springrest.springrest.services.ProductService;

@RestController
@CrossOrigin("*")
public class MyController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return "welcome to e-commerce application";
	}
	
	//get all products
	
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		
		return this.productService.getProducts();
	}
	
	//single product get
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId)
	{
		return this.productService.getProduct(Long.parseLong(productId));
	}
	
	//add product
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
		
	}
	
}
