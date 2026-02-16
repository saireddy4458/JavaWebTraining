package com.ibm.encapsulation;
// encapsulation - hiding using any process 
class Student{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age >0 ) {
			this.age = age;
		}
		
	}
}

public class Application
{
	public static void main( String[] args )
	{
		Student student = new Student();
		student.setAge(-10);  // prevent -10 to enter using encapsulation of age 
		student.setAge(10);  // possible to change private field (variable) because of setter
		System.out.println(student.getAge()); //access/read using getter 
	}
}

