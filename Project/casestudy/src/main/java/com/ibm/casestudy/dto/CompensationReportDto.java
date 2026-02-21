package com.ibm.casestudy.dto;

import java.time.YearMonth;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class CompensationReportDto {

	private Long employeeId;
	
	@NotNull(message = "Start month is required")
    @DateTimeFormat(pattern = "yyyy-MM")
	private YearMonth startMonth;
	
	@NotNull(message = "Last month is required")
    @DateTimeFormat(pattern = "yyyy-MM")
	private YearMonth endMonth;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public YearMonth getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(YearMonth startMonth) {
		this.startMonth = startMonth;
	}

	public YearMonth getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(YearMonth endMonth) {
		this.endMonth = endMonth;
	}
}