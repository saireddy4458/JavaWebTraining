package com.ibm.spring.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.spring.springmvc.model.Employee;
import com.ibm.spring.springmvc.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("employeee", new Employee());
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employeeeeee") Employee employee, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
			return "employee-form"; // redirecting to employee form along with errors
		}
		employeeService.insertEmployee(employee);
		return "list-employees";
	}

}
