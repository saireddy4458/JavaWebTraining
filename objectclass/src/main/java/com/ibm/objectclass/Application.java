//package com.ibm.objectclass;
//
//class Point {
//	public int x;
//	public int y;
//
//	@Override
//	public boolean equals(Object target) {
//
//		if (target != null && target instanceof Point) {
//			Point point3 = (Point) target;
//			if (this.x == point3.x && this.y == point3.y) {
//				return true;
//			}
//		}
//
//		return false;
//	}
//	@Override
//	public String toString() {
//		
//		return this.x+","+this.y;
//	}
//}
//
//public class Application {
//	public static void main(String[] args) {
//		Point point1 = null, point2 = null;
//
//		point1 = new Point();
//		point2 = new Point();
//
//		point1.x = 2;
//		point1.y = 4;
//
//		point2.x = 3;
//		point2.y = 6;
//
////		System.out.println(point1.equals(point2)); // false because point1 and poit2 has diff objects locations 
//
//		System.out.println(point1.equals(point2));
//		System.out.println(point1);
//	}
//}

package com.ibm.objectclass;

class Base {
	Base(int value){
		System.out.println("Base");
	}
	public void testing() {
		System.out.println("testing in base");
	}
}

class Derived extends Base{
	Derived(int value){
		super(value); //even if we dont give super() compiler gives it internally and calls base parameterized constructor
//		super() constructor must be firstline in derived class 
		System.out.println("Derived");
		
	}
	public void testing(){
		System.out.println("testing in derived");
//		super().testing();
	}
}

public class Application {
	public static void main(String[] args) {
		
		Base test = new Derived(10);
		test.testing();
		
	}
}