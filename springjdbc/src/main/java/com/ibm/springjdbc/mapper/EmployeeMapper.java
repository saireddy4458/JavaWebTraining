package com.ibm.springjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.springjdbc.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
//		Instead of class, Employee is considered as Entity as it has fields matching DB Columns 
		Employee employee = new Employee();
		employee.setId(resultSet.getInt("id"));
		employee.setFirstname(resultSet.getString("firstname"));
		employee.setLastname(resultSet.getString("lastname"));
		employee.setSalary(resultSet.getInt("salary"));
		
		return employee;
		
	}
	

}
