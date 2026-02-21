package com.ibm.customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.customers.models.Customer;
import com.ibm.customers.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}

	public Optional<Customer> getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Transactional
	public Customer createCustomer(Customer customer) {
		if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
			throw new RuntimeException("Customer with email " + customer.getEmail() + " already exists");
		}
		return customerRepository.save(customer);
	}

	@Transactional
	public Customer updateCustomer(Long id, Customer customerDetails) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setPhone(customerDetails.getPhone());
		customer.setAddress(customerDetails.getAddress());

		if (!customer.getEmail().equals(customerDetails.getEmail())) {
			if (customerRepository.findByEmail(customerDetails.getEmail()).isPresent()) {
				throw new RuntimeException("Customer with email " + customerDetails.getEmail() + " already exists");
			}
			customer.setEmail(customerDetails.getEmail());
		}

		return customerRepository.save(customer);
	}

	@Transactional
	public void deleteCustomer(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
		customerRepository.delete(customer);
	}
}