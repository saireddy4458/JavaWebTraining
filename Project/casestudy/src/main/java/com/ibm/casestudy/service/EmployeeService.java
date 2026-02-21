package com.ibm.casestudy.service;

import java.util.List;

import com.ibm.casestudy.dto.EmployeeDto;
import com.ibm.casestudy.dto.EmployeeSearchDto;
import com.ibm.casestudy.model.Employee;

public interface EmployeeService {
	EmployeeDto addEmployee(EmployeeDto emp);
	
	List<Employee> searchEmployees(EmployeeSearchDto dto);
	
	EmployeeDto findById(Long id);
	
	boolean updateEmployee(EmployeeDto dto);
}