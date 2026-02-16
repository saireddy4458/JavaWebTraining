
package com.ibm.spring.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.spring.springmvc.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertEmployee(Employee employee) {
		String SQL = "INSERT INTO Employee (name, email, phone) VALUES (?, ?, ?)";
		jdbcTemplate.update(SQL, employee.getName(), employee.getEmail(), employee.getPhone());
	}
}