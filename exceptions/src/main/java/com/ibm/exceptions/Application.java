//package com.ibm.exceptions;
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		System.out.println(args[0] +" "+args[1]); //if we run we get error of indexoutofbounds c
//		// we need to use "PS C:\Bhargav\eclipse-workspace\exceptions>
//		// java -cp target\classes com.ibm.exceptions.Application "IBM Technoogies" Banglore" 
//		// to get output IBM Technologies Banglore 
//		
//	}
//}
//
//package com.ibm.exceptions;
//
//public class Application {
//	public static void main(String[] args) {
//		try {
//			System.out.println(Integer.parseInt(args[0])/Integer.parseInt(args[1]));
//		} catch (ArrayIndexOutOfBoundsException | NumberFormatException exception ) {
//			System.out.println("You need to provide 2 valid numbers");
//		} catch (ArithmeticException exception) {
//			System.out.println("You can't divide with zero");
//		} 
////		catch (NumberFormatException exception) {
////			System.out.println("You need to provide 2 valid numbers");
////		}
//		// only use base exception when we don't know what type of exception occurred 
//		catch(Exception exception) {
//			System.out.println("Unknown error");
//		}
//		System.out.println("The End");
//	}
//}
package com.ibm.exceptions;

//user defined exception
class IllegalAgeException extends Exception {
	@Override
	public String getMessage() {

		return "you need to be 18 or above to register for voting";
	}
}

class Voting {
	void register(int age) throws IllegalAgeException {
		if (age < 18) {
			throw new IllegalAgeException();
		}
	}
}

public class Application {
	public static void main(String[] args) {
		Voting voting = new Voting();
		try {
//			voting.register(15); //we get a user defined exception 
			voting.register(18);
			
		} catch (IllegalAgeException exception) {
			exception.printStackTrace();
			System.out.println("Catch block executed");
		}
		System.out.println("End");
	}
}