//package com.ibm.collections;
//// if we want float we need to create another Point class to overcome we use Generics
////class Point<T extends Number> {  // for int, float, tiny int ......... in Number class 
//class Point<T> {
//	private T x;
//	private T y;
//
//	public Point(T x, T y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	public T getX() {
//		return x;
//	}
//
//	public void setX(T x) {
//		this.x = x;
//	}
//
//	public T getY() {
//		return y;
//	}
//
//	public void setY(T y) {
//		this.y = y;
//	}
//
//}
//
//public class Application {
//	public static void main(String[] args) {
//		Point<Float> point1 = new Point<Float>(2.0f, 4.0f);
//		System.out.println(point1.getX() + "," + point1.getY());
//		
//		Point<Integer> point2 = new Point<Integer>(2, 4);
//		System.out.println(point2.getX() + "," + point2.getY());
//
//	}
//}

//package com.ibm.collections;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class Application {
//	public static void main(String[] args) {
//		
//		ArrayList<String> arrayList = new ArrayList<String>();
//		
//		arrayList.add("A");
//		arrayList.add("B");
//		arrayList.add("C");
//		arrayList.add("D");
//		arrayList.add("E");
//		
//		for(String text : arrayList) {
//			System.out.println(text);
//		}
//		
//		System.out.println("Using Iterator");
//		
//		Iterator<String> iterator = arrayList.iterator();
//		
//		while(iterator.hasNext()) {
//			String text = iterator.next();
//			System.out.println(text);
//		}
//		
//	}
//}

//we use collections which has all datatypes incl array,list,set .......... 

//package com.ibm.collections;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Application {
//	
//	public Collection<String> getData() {
//		
//		List<String> result = new LinkedList<String>();
//
//		result.add("A");
//		result.add("B");
//		result.add("C");
//		result.add("D");
//		result.add("E");
//		
//		return result;
//	}
//	
//	public static void main(String[] args) {
//		Application application = new Application();
//		
//		Collection<String> data = application.getData();
//	
//		System.out.println("Using Iterator");
//		
//		Iterator<String> iterator = data.iterator();
//		
//		while(iterator.hasNext()) {
//			String text = iterator.next();
//			System.out.println(text);
//		}
//		
//	}
//}

package com.ibm.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Application {

	public Map<Integer, String> getData() {

		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(1, "Z");
		hashMap.put(5, "A");
		hashMap.put(2, "D");
		hashMap.put(4, "F");
		hashMap.put(6, "A");
		hashMap.put(3, "K");

		return hashMap;
	}

	public static void main(String[] args) {

		Application application = new Application();

		Map<Integer, String> data = application.getData();
		Set<Integer> keys = data.keySet();
		Iterator<Integer> keyIterator = keys.iterator();

		while (keyIterator.hasNext()) {
			Integer key = keyIterator.next();
			String value = data.get(key);
			System.out.println(key + " --> " + value);
		}
		Set<Entry<Integer,String>> entrySet = data.entrySet();
		
		Iterator<Entry<Integer,String>> entrySetIterator = entrySet.iterator();
		
		while(entrySetIterator.hasNext()) {
			Entry<Integer,String> entry = entrySetIterator.next();
			System.out.println(entry.getKey()+" --> "+entry.getValue());
		}	
	}

}
