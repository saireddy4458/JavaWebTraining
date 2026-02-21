package com.ibm.casestudy.dto;

import java.time.YearMonth;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.ibm.casestudy.model.CompensationType;

public class CompensationDto {
	
	private Long id;
	
	private Long employeeId;
	
	@NotNull
	private CompensationType compensationType;
	
	@NotNull
	private Double amount;
	
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM")
	@NotNull
	private YearMonth compMonth;

	
	
	public CompensationDto() {
		
	}

	public CompensationDto(Long employeeId) {
		this.employeeId = employeeId;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public CompensationType getCompensationType() {
		return compensationType;
	}

	public void setCompensationType(CompensationType compensationType) {
		this.compensationType = compensationType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public YearMonth getCompMonth() {
		return compMonth;
	}

	public void setCompMonth(YearMonth compMonth) {
		this.compMonth = compMonth;
	}
	
}