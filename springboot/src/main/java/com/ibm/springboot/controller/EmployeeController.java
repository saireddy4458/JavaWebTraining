package com.ibm.springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.model.Employee;
import com.ibm.springboot.services.EmployeeService;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		List<Employee> d =  employeeService.getAllEmployees();
//		System.out.println(d.get(0));
//		System.out.println(d.get(1));
		
		return employeeService.getAllEmployees();
	}
	
//	@GetMapping("/employee")
//	public Employee getEmployee() {
//		return new Employee(1, "Bhargav","Krishna","Bhargav@ibm.com");
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeId(id));
	}
	
	@GetMapping("/like/{pattern}")
	public List<Employee> getFirstNameLike(@PathVariable String pattern) {
		return employeeService.getFirstNameLike(pattern+"%");
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	
}

