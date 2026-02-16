package com.ibm.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
//	Optional<Employee>  findByFristNameAndEmail(String firstName, String lastName);
	List<Employee> findByFirstNameLike(String pattern);
}
