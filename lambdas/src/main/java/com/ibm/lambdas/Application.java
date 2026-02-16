//package com.ibm.lambdas;
//
//interface Printer{
//	public void printing();
//}
//
//class Process{
//	public void execute(Printer printer) {
//		printer.printing();
//	}
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		Process process = new Process();
//		process.execute(()-> System.out.println("HP Printing"));
//		process.execute(()-> System.out.println("Canon Printing"));
////		Anonymous class 
////		process1.execute(new Printer() {
////			public void printing() {
////				System.out.println("canon printing");
////			}
////		});
//	}
//}

//package com.ibm.lambdas;
//
//interface Printer{
//	public void printing(String name);
//}
//
//class Process{
//	public void execute(String printerName, Printer printer) {
//		printer.printing(printerName);
//	}
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		Process process = new Process();
//		// try to use pname as name i.e interface method parameter 
//		process.execute("HP",(pname)-> System.out.println(pname+" printer Printing"));
//		
//		process.execute("Canon",(pname) ->System.out.println(pname+" printer printing"));
//		
//	}
//}

//package com.ibm.lambdas;
//
//interface Printer{
//	public void printing(String name, int count);
//}
//
//class Process{
//	public void execute(String printerName,int count, Printer printer) {
//		printer.printing(printerName,count);
//	}
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		Process process = new Process();
//		
//		// lambda functional interface methods  ::membership reference operator
//		process.execute("HP",5,Application::printIt);
//		
//		process.execute("Canon",8,(pname,count) ->System.out.println(pname+" printer printing "+count+" pages."));
//		
//	}
//	
//	static void printIt(String name, int count) {
//		System.out.println(name+" printer printing "+count+" pages");
//	}
//}

package com.ibm.lambdas;

import java.util.Arrays;
import java.util.List;

public class Application
{
	public static void main( String[] args )
	{
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		numbers.forEach((number)->System.out.println(number));
		
		numbers.forEach(number -> System.out.println(number));
		
		numbers.forEach(System.out::println);
		
		numbers.stream()
				.map(element -> String.valueOf(element))
				.forEach(System.out::println);
		
		numbers.stream()
				.map(String::valueOf)
				.forEach(System.out::println);
		
		System.out.println(numbers.stream()
									.reduce(0,(total,element) -> Integer.sum(total,element)));
		
		System.out.println(numbers.stream()
									.reduce(0, Integer::sum));
		
		
	}
}
