package com.ibm.oops.payroll;

public class Finance {
	public void processPay(Employee employee){
		employee.netPay();
		if(employee instanceof PermanentEmployee) {
			PermanentEmployee permanentEmployee = (PermanentEmployee)employee;  // downcasting from employee to permanent employee
			permanentEmployee.transportation();
		}
	}
}
