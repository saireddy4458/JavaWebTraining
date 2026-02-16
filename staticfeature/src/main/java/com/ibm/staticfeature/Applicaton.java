package com.ibm.staticfeature;

import static java.lang.Math.*;

class Student {
	private int rollno;
	public static String name = "Bhargav";
	static final String COMPANY = "IBM";

}

class Employee {

	private static String lastName = " Krishna";

	public String getNamev1(String name) {
		return name + lastName;
	}

	public static String getNamev2(String name) {
		return name + lastName;
	}

	static double getSalary() {
//		return Math.incrementExact(10000);
		return incrementExact(10000);
	}
}

class Manager extends Employee {
//	not possible as getSalary() is a static method which cannot be overridden. 
	public double getSalary() {
		return 40000.0;
	}
}

// inner class can be static but not outer class
class Outer {
	static class Inner {
		void show() {
			System.out.println("Static inner class");
		}
	}
}

// If the static member is public it can be accessed from outside the class without an instance
public class Applicaton {

	static {
		System.out.println("Static block executed");
	}

	public static void main(String[] args) {

		System.out.println("Hello: " + Student.name);
		System.out.println("Working in : "+Student.COMPANY);

//		we created a object to access the getNamev1 
		Employee employee = new Employee();
		String fullName = employee.getNamev1(Student.name);
		System.out.println("Hello : " + fullName + " using v1");

//		we make static getNamev2 so we dont need a object created to access that method 
		System.out.println("Hello " + Employee.getNamev2(Student.name));

		Outer.Inner obj = new Outer.Inner();
		obj.show();

		Employee employee2 = new Manager();
		System.out.println(employee2.getSalary());
		
		System.out.println(Math.PI);
		System.out.println(PI);

	}
}