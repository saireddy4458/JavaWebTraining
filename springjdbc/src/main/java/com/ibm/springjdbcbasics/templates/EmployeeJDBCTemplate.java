package com.ibm.springjdbcbasics.templates;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibm.springjdbc.Dao.EmployeeDao;
import com.ibm.springjdbc.mapper.EmployeeMapper;
import com.ibm.springjdbc.model.Employee;

@Repository("employeeJDBCTemplateBean")
public class EmployeeJDBCTemplate implements EmployeeDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public void create(String firstName, String lastName, int salary) {
		String SQL = " insert into Employee(firstName, lastName, Salary) values(?, ?, ?) ";
		jdbcTemplateObject.update(SQL, firstName, lastName, salary);
		System.out.println("Created Record Name = " + firstName + "Salary = " + salary);
		System.out.println();

	}

	@Override
	public Employee getEmployee(Integer id) {
		String SQL = "select * from Employee where id = ? ";
		Employee employee = jdbcTemplateObject.queryForObject(SQL, new EmployeeMapper(), id);

		return employee;
	}

	@Override
	public List<Employee> listEmployees() {
		String SQL = "Select * from Employee";
		List<Employee> employees = jdbcTemplateObject.query(SQL, new EmployeeMapper());
		return employees;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "Delete from Employee where id=?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		System.out.println();
	}

	@Override
	public void update(Integer id, String firstName, String lastName, Integer salary) {
		String SQL = "update Employee set salary = ? where id= ?";
		jdbcTemplateObject.update(SQL, salary, id);
		System.out.println("Updated Record with Id = " + id);
		System.out.println();

	}

}
