package com.ibm.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.springjdbc.config.JDBCConfig;
import com.ibm.springjdbc.model.Employee;
import com.ibm.springjdbcbasics.templates.EmployeeJDBCTemplate;

public class Application {
	public static void main(String[] args) {
		
//		Xml based configuration:
//		ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
//
//		EmployeeJDBCTemplate employeeJDBCTemplate = (EmployeeJDBCTemplate) context.getBean("employeeJDBCTemplateBean");

		
//		Java Configuration:
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
		
		EmployeeJDBCTemplate employeeJDBCTemplate = (EmployeeJDBCTemplate) context.getBean("employeeJDBCTemplateBean"); 
		
		System.out.println("-------- Records Creation -----------");
//		employeeJDBCTemplate.create("Smitha", "Raj", 15000);
//		employeeJDBCTemplate.create("Allen", "Peter", 18000);
//		employeeJDBCTemplate.create("Allen", "Peter", 18000);
		

		System.out.println("-------- Listing Records ------------");
		List<Employee> employees = employeeJDBCTemplate.listEmployees();

		for (Employee employee : employees) {
			System.out.println("ID: " + employee.getId());
			System.out.println("FirstName: " + employee.getFirstname());
			System.out.println("LastName: " + employee.getLastname());
			System.out.println("Salary: " + employee.getSalary() + "\n");

		}

		employeeJDBCTemplate.update(2, "Allen", "peter", 25000);

		Employee employee = employeeJDBCTemplate.getEmployee(2);
		System.out.println("ID: " + employee.getId());
		System.out.println("FirstName: " + employee.getFirstname());
		System.out.println("LastName: " + employee.getLastname());
		System.out.println("Salary: " + employee.getSalary() + "\n");
				
//		employeeJDBCTemplate.delete(3);
	}
}