//package com.ibm.client.cui;
//
//public class MainApp {
//	
//	public static void main(String[] args) {
//		System.out.println("Start");
//		
//		String str1, str2, str3;
//		
//		str1 = "IBM";
//		str2 = "IBM"; //same object id as str1 
//		str3 = "ibm"; //diff object as value is case sensitive i.e diff 
//		
//		System.out.println(str1);
//		System.out.println("End");
//	}
//}
//


//package com.ibm.client.cui;
//
//public class MainApp {
//	
//	public static void main(String[] args) {
//		System.out.println("Start");
//		
//		String str1, str2, str3;
//		
//		str1 = "IBM";
//		str2 = "IBM";
//		
//		System.out.println(str1== str2);
//		System.out.println(str1.equals(str2));
//		System.out.println("End");
//	}
//}

package com.ibm.client.cui;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("Start");
		
		String str1, str2;
		
		str1 = new String("IBM"); //creating new object 
		str2 = new String("IBM");
		
		System.out.println(str1== str2); //false because diff object
		System.out.println(str1.equals(str2)); //true because same value 
		System.out.println("End");
	}
}
