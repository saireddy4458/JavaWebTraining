//Abstraction example
//package com.ibm.oops;
//
//import com.ibm.oops.payroll.Employee;
//
//import com.ibm.oops.payroll.PermanentEmployee;
//
//public class Application {
//	public static void main(String[] args) {
//		
//		Employee employee = new PermanentEmployee();
//		
//		employee.netPay();
//
//	}
//}

//package com.ibm.oops;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Application {
//	public static void main(String[] args) {
//		
////		Calendar calendar = new Calendar(); error because calendar is abstract class 
//		
//		Calendar calendar = new GregorianCalendar();  // up casting 
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//		
//		GregorianCalendar gregorianCalendar = (GregorianCalendar)calendar; 
//		
//		List<String> list = new LinkedList<String>();
//		
////		Both Linkedlist and arrayList implements list interface(siblings) thus downcasting not possible between siblings
////		ArrayList<String> arrayList = (ArrayList<String>) list;  //runtime error class cast exception 
//		if(list instanceof ArrayList) { // we check if likedList is instance of arraylist 
//			ArrayList<String> arrayList = (ArrayList<String>) list;
//		}
//	}
//}

package com.ibm.oops;

import com.ibm.oops.payroll.Employee;
import com.ibm.oops.payroll.Finance;
import com.ibm.oops.payroll.HR;
import com.ibm.oops.payroll.Intern;
import com.ibm.oops.payroll.PermanentEmployee;

public class Application {
	public static void main(String[] args) {
		Finance finance = new Finance();
		Employee employee = HR.recruit("p");
		if (employee != null) {
			finance.processPay(employee);
		}
		// we get a null pointer exception because recruit points to 'l' which is not available in hr class  
		// thats why we check if it is returning null 
		employee = HR.recruit("I");
		if(employee != null) {
			finance.processPay(employee); 
		}
		employee = HR.recruit("F");
		if(employee != null) {
			finance.processPay(employee); 
		}
		 
	}
}
