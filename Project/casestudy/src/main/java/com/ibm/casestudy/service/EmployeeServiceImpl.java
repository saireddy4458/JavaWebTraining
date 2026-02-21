package com.ibm.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibm.casestudy.dto.EmployeeDto;
import com.ibm.casestudy.dto.EmployeeSearchDto;
import com.ibm.casestudy.model.Employee;
import com.ibm.casestudy.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	//Constructor Injection
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	//UserStory2. ADD EMPLOYEE
	@Override
	public EmployeeDto addEmployee(EmployeeDto emp) {
		
		try
		{
			Long result = checkEmployeeExists(emp);
			
			if(result>0)
			{
				throw new IllegalArgumentException(
		                "Employee already exists with same Name and Birth Date");
			}
			
			Employee employee = new Employee();
			employee.setFirstName(emp.getFirstName().trim());
			employee.setMiddleName(emp.getMiddleName());
			employee.setLastName(emp.getLastName().trim());
			employee.setBirthDate(emp.getBirthDate());
			employee.setPosition(emp.getPosition().trim());
			
			
		    employeeRepository.save(employee);
		    
		    emp.setId(employee.getId());
		    
		    return emp;
			
		}catch(IllegalArgumentException message)
		{
			throw message;
		}catch(Exception e)
		{
			throw new RuntimeException(
	                "Something went wrong, please try again later.");
		}
		
	}
	
  //	UserStory2. Checking Duplicate Employee
	public Long checkEmployeeExists(EmployeeDto emp)
	{
		
		String firstName = emp.getFirstName().trim();
		String lastName = emp.getLastName().trim();
		String middleName = emp.getMiddleName() == null ? "" : emp.getMiddleName().trim(); 
		
		long count = employeeRepository.countByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCaseAndBirthDate(
				firstName,
				middleName, 
				lastName, 
				emp.getBirthDate());
		
		return count;
		
	}

	
    //User Story 3. Searching Employees
	@Override
	public List<Employee> searchEmployees(EmployeeSearchDto dto) {

	    String criteria = dto.getSearchCriteria();
	    String value = formatValue(dto.getSearchValue());

	    String firstName = null;
	    String lastName = null;
	    String position = null;

	    if (criteria == null || criteria.equals("all")) {

	        firstName = formatValue(dto.getFirstName());
	        lastName = formatValue(dto.getLastName());
	        position = formatValue(dto.getPosition());

	    } else if (criteria.equals("firstName")) {

	        firstName = value;

	    } else if (criteria.equals("lastName")) {

	        lastName = value;

	    } else if (criteria.equals("position")) {

	        position = value;
	    }

	    if (firstName == null && lastName == null && position == null) {
	        return java.util.Collections.emptyList();
	    }

	    return employeeRepository.searchEmployees(firstName, lastName, position);
	}


	
	
	//UserStory3. Removing the Trailing Spaces
	private String formatValue(String fieldValue) {
		 if(fieldValue==null || fieldValue.trim().isEmpty())
		 {
			 return null;
		 }
		 return fieldValue.trim();
	}

	

	//UserStory 4.Update the Employee.
	@Override
	public boolean updateEmployee(EmployeeDto dto) {
		
	try
	{
		if(checkDuplicateForUpdate(dto))
		{
			throw new IllegalArgumentException(
				"Given Details Already matches existing employees");
			
		}
		
		Optional<Employee> employeeResults = employeeRepository.findById(dto.getId());
		
		Employee updateEmp = employeeResults.get();
		updateEmp.setFirstName(dto.getFirstName().trim());
		updateEmp.setMiddleName(dto.getMiddleName());
		updateEmp.setLastName(dto.getLastName().trim());
		updateEmp.setBirthDate(dto.getBirthDate());
		updateEmp.setPosition(dto.getPosition().trim());
		
		employeeRepository.save(updateEmp);
		
		return true;
	 }catch(IllegalArgumentException message){
			throw message;
	 }catch(Exception e)
	{
		 throw new RuntimeException(" Something went wrong, please try again later.");
	}
	
		
}
	
	//UserStory4.Find Employee By id
		@Override
	public EmployeeDto findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employees = employeeRepository.findById(id);
		
		Employee result = employees.get();
		
		EmployeeDto dto = new EmployeeDto();
		dto.setId(result.getId());
		dto.setFirstName(result.getFirstName());
		dto.setMiddleName(result.getMiddleName());
		dto.setLastName(result.getLastName());
		dto.setBirthDate(result.getBirthDate());
		dto.setPosition(result.getPosition());
		return dto;
	}

	
	//UserStory4.check for Duplicate Updates
	public boolean checkDuplicateForUpdate(EmployeeDto dto)
	{
		Long count =employeeRepository.countByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCaseAndBirthDateAndIdNot(
				dto.getFirstName().trim(), 
				dto.getMiddleName()==null?"":dto.getMiddleName().trim(),
			    dto.getLastName().trim(), 
			    dto.getBirthDate(),dto.getId()
			    );
		return count>0?true:false;
	}

}