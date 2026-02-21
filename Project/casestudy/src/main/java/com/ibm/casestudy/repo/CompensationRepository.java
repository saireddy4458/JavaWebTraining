package com.ibm.casestudy.repo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.casestudy.model.Compensation;
import com.ibm.casestudy.model.CompensationType;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation,Long>{

	boolean existsByEmployee_IdAndCompensationTypeAndCompMonth(Long employeeId,CompensationType compensationType,
			LocalDate compMonth);
	
	@Query("SELECT c.compMonth, SUM(c.amount)FROM Compensation c "
			+ "WHERE c.employee.id = :empId AND c.compMonth "
			+ "BETWEEN :startDate AND :endDate "
			+ "GROUP BY c.compMonth "
			+ "ORDER BY c.compMonth")
		List<Object[]> findMonthlyTotals(
		        @Param("empId") Long empId,
		        @Param("startDate") LocalDate startDate,
		        @Param("endDate") LocalDate endDate
		);
		
		
	List<Compensation> findByEmployee_IdAndCompMonthBetween(Long empId,LocalDate startDate,LocalDate endDate);


	
}