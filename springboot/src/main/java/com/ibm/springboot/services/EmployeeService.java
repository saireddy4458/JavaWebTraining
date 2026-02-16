package com.ibm.springboot.services;

import java.util.List;
import java.util.Optional;

import com.ibm.springboot.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeId(Long id);
	
	public Employee createEmployee(Employee employee);
	
	public Employee updateEmployee(Long id, Employee employee);
	
	public void deleteEmployee(Long id);
	
	public List<Employee> getFirstNameLike(String pattern);
	
	public Optional<Employee> getFirstNameAndEmail(String firstName, String lastName);

}
