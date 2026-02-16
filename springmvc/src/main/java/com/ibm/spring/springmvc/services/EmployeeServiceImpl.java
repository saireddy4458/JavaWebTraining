package com.ibm.spring.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.spring.springmvc.dao.EmployeeDao;
import com.ibm.spring.springmvc.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeDao employeeDao;
	
	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
		System.out.println("Employee inserted");
	}

}

