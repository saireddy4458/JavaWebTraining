package com.ibm.productservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public class ProductController {
	@Value("${server.port}")
		private String port;
	
	@GetMapping("/products")
	public String getProducts() {
		return "Product Service (Running on port: " + port + ")";
	}
	
	@GetMapping("/info")
	public String getInfo() {
		return "Product Service is running on port: " + port;
	}

}
