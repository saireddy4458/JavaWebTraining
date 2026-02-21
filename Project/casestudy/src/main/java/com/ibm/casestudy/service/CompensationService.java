package com.ibm.casestudy.service;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import com.ibm.casestudy.dto.CompensationDto;
import com.ibm.casestudy.dto.CompensationMonthlyDto;
import com.ibm.casestudy.dto.CompensationReportDto;

public interface CompensationService {
	void addCompensation(CompensationDto compensationDto);
	
	Map<YearMonth, Double> getMonthlyReport(CompensationReportDto reportDto);
	
	CompensationMonthlyDto getMonthlyBreakDown(Long employeeId,YearMonth yearMonth);
	
	//
	CompensationDto  getCompensationById(Long id);
	
	void updateCompensation(CompensationDto dto);
}