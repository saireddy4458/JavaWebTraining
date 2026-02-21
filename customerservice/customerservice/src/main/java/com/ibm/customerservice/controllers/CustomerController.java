package com.ibm.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/customers")
	public String getCustomers() {
		return "Customer Service";
	}
	
	@GetMapping("/customer-products")
	public String getProducts() {
		String response = restTemplate.getForObject("http://PRODUCTSERVICE/products", String.class);
		return "Customer Products received: " + response;
	}

}
