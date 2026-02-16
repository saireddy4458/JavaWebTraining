////package com.ibm.arrays;
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		
//		int numbers[];
//		
//		numbers = new int[5];
//		
//		System.out.println(numbers.length);
//		
//		numbers[2] = 4;
//		
//		for(int num:numbers) {
//			System.out.println(num);
//		}
//		
//		System.out.println(nums[2]);
//		
//	}
//}

//package com.ibm.arrays;
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		
//		Integer numbers[];
//		
//		numbers = new Integer[5];
//		
//		System.out.println(numbers.length);
//		
//		numbers[0] = 1;
//		numbers[1] = 2;
//		numbers[2] = 3;
//		numbers[3] = 4;
//		numbers[4] = 5;
//		
//		// if int autounboxing causes nullpointer exception so use Integer
//		for(int num:numbers) {   
//			System.out.println(num);
//		}
//	}
//}


//package com.ibm.arrays;
//
//class Point {
//	public int x;
//	public int y;
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		
//		Point[] points;
//		
//		points point1 = new Point[3];
//		
//		point1.x = 2;
//		
//		
//		// if int autounboxing causes nullpointer exception so use Integer
//		for(Point point:points) {   
//			System.out.println(point.x+","+point.y);
//		}
//	}
//}


//package com.ibm.arrays;

//class Point {
//	public int x;
//	public int y;
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

//public class Application
//{
//	public static void main( String[] args )
//	{
//		int[][] nums;
//		
//		nums = new int[3][2];
//		
//		nums[1][1] = 4;
//		
//		for(int[] firstDim:nums) {
//			for(int value:firstDim) {
//				System.out.print(value);
//			}
//			System.out.println();
//		}
//		
//		
//	}
//}
//package com.ibm.arrays;
//
//class Test{
//	static int num; //class scope if static then i is class variable else instance variable
//	public void testing() {
//		int value; //local scope
//	}
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		Test test1 = new Test();
//		Test test2 = new Test();
//		
//		test1.num = 1;
//		test2.num = 2;
//		
//		//Test.num = 10; // we can use this to get 10,10 because of static keyword allowing class name to access variable 
//		System.out.println(test1.num +","+test2.num);  // 2,2 if static not there 1,2 
//		
//	}
//}

package com.ibm.arrays;

class Test{
	static int num; //class scope if static then i is class variable else instance variable
	public void testing() {
		int value; //local scope
	}
}

public class Application
{
	static int var1;
//	int var1;
	public static void main( String[] args )
	{
//		Application application = new Application();
//		application.var1 = 15;
//		this is one way or easily use static int var1;
		var1 = 15;
		
	}
}


