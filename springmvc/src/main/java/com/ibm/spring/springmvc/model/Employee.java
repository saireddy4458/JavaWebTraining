package com.ibm.spring.springmvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	
//	server side validation connected to message source
	@NotBlank(message = "Name is required.")
	@Size(min = 2, max = 50, message = "Name must be between 2-30 characters long.")
	private String name;
	
	@NotBlank(message = "Email is required.")
	@Email(message = "Invalid email format")
	private String email;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits.")
	private String phone;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
