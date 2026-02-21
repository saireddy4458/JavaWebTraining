package com.ibm.casestudy.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.casestudy.dto.CompensationDto;
import com.ibm.casestudy.dto.CompensationMonthlyDto;
import com.ibm.casestudy.dto.CompensationReportDto;
import com.ibm.casestudy.dto.EmployeeDto;
import com.ibm.casestudy.model.Compensation;
import com.ibm.casestudy.model.CompensationType;
import com.ibm.casestudy.model.Employee;
import com.ibm.casestudy.repo.CompensationRepository;
import com.ibm.casestudy.repo.EmployeeRepository;

@Service
public class CompensationServiceImpl implements CompensationService{

	private CompensationRepository comRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public CompensationServiceImpl(CompensationRepository comRepository) {
		this.comRepository = comRepository;
	}

	//------ADDING COMPENSATION----------
	@Override
	public void addCompensation(CompensationDto compensationDto) {
		
	try
	 {
		CompensationType type = compensationDto.getCompensationType();
		
		LocalDate monthDate = compensationDto.getCompMonth().atEndOfMonth();
				
		compensationValidation(compensationDto,type,monthDate);
		
		Optional<Employee> employeeList = employeeRepository.findById(compensationDto.getEmployeeId());
		Employee emp = employeeList.get();
		
		Compensation compensation = new Compensation();
		compensation.setAmount(compensationDto.getAmount());
		compensation.setDescription(compensationDto.getDescription());
		compensation.setCompMonth(monthDate);
		compensation.setCompensationType(type);
		compensation.setEmployee(emp);
		
			comRepository.save(compensation);
			
		}catch(IllegalArgumentException message)
		{
			throw message;
		}catch(Exception e){
			throw new RuntimeException("Something Went Wrong again");
		}	
	}
	
	//---CHECKING AND VALIDATING COMPENSATION TYPES
	private void compensationValidation(CompensationDto compensationDto, CompensationType type, LocalDate monthDate) {
		
		Double amount = compensationDto.getAmount();
		
		switch(type)
		{
			case SALARY:
						boolean exists = comRepository.existsByEmployee_IdAndCompensationTypeAndCompMonth(
								compensationDto.getEmployeeId(),
								type, 
								monthDate);
						
						if(exists)
						{
							throw new IllegalArgumentException("Employe Salary Already Exists for this Month");
						}
						break;
			case BONUS:
			case COMMISSION:
			case ALLOWANCE:
				if(amount<=0)
				{
					throw new IllegalArgumentException(type +"amount must be greater than zero");
				}
				if(compensationDto.getDescription()==null || compensationDto.getDescription().trim().isEmpty())
				{
					throw new IllegalArgumentException("Description is required for "+type);
				}
				break;
			case ADJUSTMENT:
					if(amount==0) {
						throw new IllegalArgumentException(type +"amount cannot be zero");
					}
					if(compensationDto.getDescription()==null || compensationDto.getDescription().trim().isEmpty())
					{
						throw new IllegalArgumentException("Description is required for "+type);
					}
					break;
		}
		
	}

	//GENERATING COMPENSATION REPORT
	@Override
	public Map<YearMonth,Double> getMonthlyReport(CompensationReportDto reportDto) {
		// TODO Auto-generated method stub	
	try{
		YearMonth startMonth = reportDto.getStartMonth();
		YearMonth endMonth = reportDto.getEndMonth();
		
		if(endMonth.isBefore(startMonth))
		{
			throw new IllegalArgumentException(
	                "End month cannot be before Start month");
		}
		
		LocalDate startDate = startMonth.atDay(1);
		LocalDate endDate = endMonth.atEndOfMonth();
		
		List<Object[]> employeCompensation = comRepository.findMonthlyTotals(reportDto.getEmployeeId(), startDate, endDate);
		
		Map<YearMonth, Double> report = new LinkedHashMap<>();
		
		for (Object[] row : employeCompensation) {

	        LocalDate date = (LocalDate) row[0];
	        Double total = (Double) row[1];

	        report.put(YearMonth.from(date), total);
	    }
		
		return report;
		}catch(IllegalArgumentException argumentException){
			throw argumentException;
		}catch(Exception e){
			throw new RuntimeException("Something went wrong,try again");
		}

	}

	@Override
	public CompensationMonthlyDto getMonthlyBreakDown(Long employeeId, YearMonth yearMonth) {
		
		LocalDate startDate = yearMonth.atDay(1);
		LocalDate endDate = yearMonth.atEndOfMonth();
		
		List<Compensation> results =  comRepository.findByEmployee_IdAndCompMonthBetween(employeeId, startDate, endDate);
		
		Optional<Employee> empList = employeeRepository.findById(employeeId);
		Employee employee = empList.get();
		
		List<CompensationDto> dtoList = results.stream()
	            .map(this::convertToDto)
	            .collect(Collectors.toList());
		
		 double totalAmount = dtoList.stream()
		            .mapToDouble(CompensationDto::getAmount)
		            .sum();
		 
		 CompensationMonthlyDto compensationMonthlyDto = new CompensationMonthlyDto();
		 compensationMonthlyDto.setEmployeeId(employeeId);
		 compensationMonthlyDto.setEmployeeName(employee.getFirstName());
		 compensationMonthlyDto.setCompensationList(dtoList);
		 compensationMonthlyDto.setMonth(yearMonth);
		 compensationMonthlyDto.setTotalAmount(totalAmount);
		
		return compensationMonthlyDto;
		
	}
		
	
	private CompensationDto convertToDto(Compensation compensation) {
	    CompensationDto dto = new CompensationDto();
	    dto.setCompensationType(compensation.getCompensationType());
	    dto.setAmount(compensation.getAmount());
	    dto.setCompMonth(YearMonth.from(compensation.getCompMonth()));
	    dto.setDescription(compensation.getDescription());
	    return dto;
	    
	    
	}
	
	@Override
	public CompensationDto getCompensationById(Long id) {
		// TODO Auto-generated method stub
		Compensation compensation = comRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Compensation Not Found"));
		CompensationDto compensationDto = new CompensationDto();
		compensationDto.setId(compensation.getId());
		compensationDto.setEmployeeId(compensation.getEmployee().getId());
		compensationDto.setCompensationType(compensation.getCompensationType());
		compensationDto.setAmount(compensation.getAmount());
		compensationDto.setDescription(compensation.getDescription());
		compensationDto.setCompMonth(YearMonth.from(compensation.getCompMonth()));
		
		return compensationDto;
	}

	@Override
	public void updateCompensation(CompensationDto dto) {
		
		Optional<Compensation> compensationList =comRepository.findById(dto.getId());
		Compensation compensation = compensationList.get();	
		
		compensation.setAmount(dto.getAmount());
	    compensation.setDescription(dto.getDescription());
		comRepository.save(compensation);
	}

		
}