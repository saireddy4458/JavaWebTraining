package com.ibm.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibm.springboot.model.Employee;
import com.ibm.springboot.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeId(Long id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee) ;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		
		Employee employee = getEmployeeId(id);
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		
	
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = getEmployeeId(id);
		employeeRepository.delete(employee);
		
	}
	
	@Override
	public List<Employee> getFirstNameLike(String pattern) {
		return employeeRepository.findAll();
	}
	
	@Override
	public Optional<Employee> getFirstNameAndEmail(String firstName, String lastName) {
		return null;
		
	}

}
