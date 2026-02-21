package com.ibm.customers.service;



import java.util.List;
import java.util.Optional;

import com.ibm.customers.models.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	Optional<Customer> getCustomerById(Long id);

	Optional<Customer> getCustomerByEmail(String email);

	Customer createCustomer(Customer customer);
	
	Customer updateCustomer(Long id, Customer customerDetails);

	void deleteCustomer(Long id);

}