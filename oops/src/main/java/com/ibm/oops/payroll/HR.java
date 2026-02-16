package com.ibm.oops.payroll;

public class HR {
	public static Employee recruit(String empType) {
		if(empType.equalsIgnoreCase("I")) {
			return new Intern();
		}
		else if (empType.equalsIgnoreCase("p")) {
			return new PermanentEmployee();
		}
		else if (empType.equalsIgnoreCase("F")) {
			return new Freelancer();
		}
		return null;
	}
}
