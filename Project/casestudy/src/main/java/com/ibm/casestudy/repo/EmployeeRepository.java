package com.ibm.casestudy.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.casestudy.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//Duplicate Employee
	long countByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCaseAndBirthDate(
	        String firstName,
	        String middleName,
	        String lastName,
	        LocalDate birthDate);

	//Search Employee
	@Query("SELECT e FROM Employee e " +
	           "WHERE (:firstName IS NULL OR LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))) " +
	           "AND (:lastName IS NULL OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) " +
	           "AND (:position IS NULL OR LOWER(e.position) LIKE LOWER(CONCAT('%', :position, '%')))")
	List<Employee> searchEmployees(
	            @Param("firstName") String firstName,
	            @Param("lastName") String lastName,
	            @Param("position") String position);
	
	//Duplicate Identifical Fields for Update
	long countByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCaseAndBirthDateAndIdNot(
			String firstName,
			String middleName,
			String lastName,
			LocalDate birthDate,
			Long Id);
	
}