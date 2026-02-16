package com.ibm.springjdbc.Dao;

import java.util.List;

import javax.sql.DataSource;

import com.ibm.springjdbc.model.Employee;

public interface EmployeeDao {

	public void setDataSource(DataSource dataSource);
	
//	to insert into the table
	public void create(String firstName, String lastName, int salary);

//	to get 1 row or 0 row as result 
	public Employee getEmployee(Integer id);
	
//	to get multiple rows 
	public List<Employee> listEmployees();
	
//	to delete rows in the table 
	public void delete(Integer id);
	
//	to update rows in the table 
	public void update(Integer id, String firstName, String lastName, Integer salary);
		
}
