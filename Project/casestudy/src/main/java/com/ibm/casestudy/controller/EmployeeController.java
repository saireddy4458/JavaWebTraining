package com.ibm.casestudy.controller;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.casestudy.dto.CompensationDto;
import com.ibm.casestudy.dto.CompensationMonthlyDto;
import com.ibm.casestudy.dto.CompensationReportDto;
import com.ibm.casestudy.dto.EmployeeDto;
import com.ibm.casestudy.dto.EmployeeSearchDto;
import com.ibm.casestudy.model.Compensation;
import com.ibm.casestudy.model.Employee;
import com.ibm.casestudy.service.CompensationService;
import com.ibm.casestudy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private CompensationService comService;
	
	@GetMapping("/home")
	public String homePage()
	{
		return "home-page";
	}	
	//Adding Employee
	@GetMapping("/add")
	public String addEmployee(Model model)
	{
		model.addAttribute("employee",new EmployeeDto());
		
		return "add-employee";
	}

	
	//Saving Employee
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto emp, BindingResult result,RedirectAttributes redirect,
			Model model)
	{
		
		if(result.hasErrors())
		{
			return "add-employee";
		}
		
		try
		{
			EmployeeDto savedResult = empService.addEmployee(emp);
			
			redirect.addFlashAttribute("successMessage", "Employee ID : "+savedResult.getId()+" Added Successfully");
			
			return "redirect:/employee/add";
		}catch(IllegalArgumentException e)
		{
			model.addAttribute("duplicateMessage","Employee With Given Details Already Exists");
			return "add-employee";
		}catch(Exception e)
		{
			model.addAttribute("genericMessage",e.getMessage());
			return "add-employee";
		}
		
	}
	
	@GetMapping("/search")
	public String searchForm(Model model)
	{
		model.addAttribute("searchDto", new EmployeeSearchDto());
		return "search-employee";
	}
	
	@PostMapping("/results")
	public String searchEmployeeResults(@ModelAttribute("searchDto") EmployeeSearchDto searchDto,Model model)
	{
		
		List<Employee> searchResults = empService.searchEmployees(searchDto);

		model.addAttribute("employees", searchResults);
		
		model.addAttribute("searchDto", new EmployeeSearchDto());
		
		return "search-employee";
	}
	
//	@GetMapping("/viewEdit")
	// Shows View/Edit Form
		@GetMapping("/viewEdit")
		public String viewEditEmployee(@RequestParam("id") Long eid,Model model)
		{
			EmployeeDto employeeDto = empService.findById(eid);
			
			model.addAttribute("employeeDetails", employeeDto);
			
			return "view-edit";
			
		}
		
		
		//Update Employees
		@PostMapping("/update")
		public String updateEmployee(@Valid @ModelAttribute("employeeDetails") EmployeeDto emp,
				BindingResult result,Model model,RedirectAttributes redirect)
		{
			if(result.hasErrors())
			{
				return "view-edit";
			}
			
			try
			{
				 empService.updateEmployee(emp);
				 redirect.addFlashAttribute("successMessage","Employee ID: "+emp.getId()+" Updated Successfully");
				 return "redirect:/employee/viewEdit?id=" + emp.getId();
			}catch(IllegalArgumentException e)
			{
				model.addAttribute("errorMessage", e.getMessage());
				return "view-edit";
			}catch(Exception e)
			{
				model.addAttribute("genericError", e.getMessage());
				return "view-edit";
			}			
		}
		//User Story 5. COMPENSATION FORM
		@GetMapping("/addCompensation")
		public String getCompensationForm(@RequestParam("id") Long empId,Model model)
		{
			model.addAttribute("employeeName",empService.findById(empId).getFirstName());
			model.addAttribute("compDto", new CompensationDto(empId));
			return "add-compensation";
		}
		
		//User Story 5. ADD COMPENSATION
		@PostMapping("/saveCompensation")
		public String addCompensation(@Valid @ModelAttribute("compDto") CompensationDto compensationDto,
				BindingResult result,Model model,RedirectAttributes redirectAttributes){
			model.addAttribute("employeeName",empService.findById(compensationDto.getEmployeeId()).getFirstName());
			if(result.hasErrors()){
				return "add-compensation";
			}
			try{
				comService.addCompensation(compensationDto);
				model.addAttribute("successMessage", "Employee ID: "+compensationDto.getEmployeeId()+" Compensation Added Successfully");
				return "add-compensation";
			}catch(IllegalArgumentException e){
				model.addAttribute("errorMessage", e.getMessage());
				return "add-compensation";
			}catch(Exception e){
				model.addAttribute("genericMessage", e.getMessage());
				return "add-compensation";
			}
				
		}
		
		
		//USER STORY.6 VIEW COMPENSATION FORM
		@GetMapping("/report")
		public String showReportForm(@RequestParam("id") Long empId,Model model)
		{
			CompensationReportDto compensationReportDto = new CompensationReportDto();
		    compensationReportDto.setEmployeeId(empId);
		    
		    model.addAttribute("reportDto", compensationReportDto);
		    model.addAttribute("empName",empService.findById(empId).getFirstName());
		    
		    return "compensation-history";
		}
		
		//USER STORY.6 PROCESS OF MONTHLY COMPENSATION
		@GetMapping("/viewReport")
		public String viewCompensationReport(@Valid @ModelAttribute("reportDto") CompensationReportDto compReportDto,
				BindingResult result,Model model,RedirectAttributes redirect){
			EmployeeDto employeeDto = empService.findById(compReportDto.getEmployeeId());
			model.addAttribute("empName", employeeDto.getFirstName());
			if(result.hasErrors()){
				return "compensation-history";
			}
			try{
				Map<YearMonth,Double> compensationReport= comService.getMonthlyReport(compReportDto);
				redirect.addFlashAttribute("reportData",compensationReport);
				redirect.addFlashAttribute("empName",employeeDto.getFirstName());
				redirect.addFlashAttribute("employeeId", compReportDto.getEmployeeId());
				return "redirect:/employee/reportResult";
				
			}catch(IllegalArgumentException message){
				model.addAttribute("validationError", message);
				return "compensation-history";
			}catch(Exception e){
				model.addAttribute("errorMessage", e.getMessage());
				return "compensation-history";
			}
			
		}
		
		//USER STORY 6. REPORT OF MONTHLY COMPENSATION
		@GetMapping("/reportResult")
		public String displayReportResult()
		{
			return "compensation-report";
			
		}
		
		@GetMapping("/monthBreakDown")
		public String monthlyBreakDown(@RequestParam("empId") Long employeeId,@RequestParam("month") String month,Model model)
		{
			YearMonth yearMonth = YearMonth.parse(month);
			
			CompensationMonthlyDto monthBreakDown=comService.getMonthlyBreakDown(employeeId,yearMonth);
			model.addAttribute("monthlyBreakDown",monthBreakDown);
			
			return "month-breakdown";
			
		}
		
		//User Story 8. Edit Compensation Details
		@GetMapping("/editCompensation")
		public String showEditCompensation(@RequestParam("id") Long id,
				@RequestParam("empId") Long employeeId,@RequestParam("month") String month,Model model)
		{
			
			CompensationDto compensationDto = comService.getCompensationById(id);
			model.addAttribute("compensation", compensationDto);
			return "edit-compensation";
		}

		
		//User Stroy 8.Update Compensation
		@PostMapping("/updateCompensation")
		public String updateCompensation(@ModelAttribute("compensation") CompensationDto dto,RedirectAttributes redirect)
		{
			comService.updateCompensation(dto);
			
			redirect.addFlashAttribute("successMessage", "Compensation Updated For Employee ID: "+dto.getEmployeeId());
			return "redirect:/employee/monthBreakDown?empId="+dto.getEmployeeId()+"&month="+dto.getCompMonth();
		}

}
