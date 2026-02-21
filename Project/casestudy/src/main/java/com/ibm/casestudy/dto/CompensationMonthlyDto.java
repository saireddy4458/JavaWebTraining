package com.ibm.casestudy.dto;

import java.time.YearMonth;
import java.util.List;

public class CompensationMonthlyDto {

	private Long employeeId;
	
	private String employeeName;
	
	private YearMonth month;
	
	private List<CompensationDto> compensationList;
	
	private Double totalAmount;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public YearMonth getMonth() {
		return month;
	}

	public void setMonth(YearMonth month) {
		this.month = month;
	}

	public List<CompensationDto> getCompensationList() {
		return compensationList;
	}

	public void setCompensationList(List<CompensationDto> compensationList) {
		this.compensationList = compensationList;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}