//package com.ibm.spring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ibm.spring.beans.SpellChecker;
//import com.ibm.spring.beans.TextEditor;
//
//public class Application {
//	public static void main(String[] args) 
//	{
//		//beans created
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		
////		If the scope of spellchecker1 bean is singleton only 1 output
////		if scope is prototype it is multiple times as getBean instantiate 
//		
//		SpellChecker spellChecker1 = (SpellChecker) context.getBean("spellChecker1");
//		
//		SpellChecker spellChecker2 = (SpellChecker) context.getBean("spellChecker1");
//		
//		SpellChecker spellChecker3 = (SpellChecker) context.getBean("spellChecker1");
//		
////		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
//		
////		textEditor.spellCheck();
//	}
//}
//
//package com.ibm.spring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ibm.spring.beans.SpellChecker;
//import com.ibm.spring.beans.TextEditor;
//
//public class Application {
//	public static void main(String[] args) 
//	{
//		//beans created
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		
//		
////		autowire = "constructor" or autowire ="byName" autowire ="byType" each has diff rule in spring.xml 
//		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
//		
////		textEditor.spellCheck();
//		
////		to destroy the created beans update xml file 
//		AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) context;
//		
//		abstractApplicationContext.registerShutdownHook();
//		
//	}
//}

//package com.ibm.spring;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//import java.util.Set;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ibm.spring.beans.SpellChecker;
//import com.ibm.spring.beans.TextEditor;
//import com.ibm.spring.beans.JavaCollection;
//
//public class Application {
//	public static void main(String[] args) 
//	{
//		
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		
//		JavaCollection javaCollection =(JavaCollection) context.getBean("javaCollection");
//		
//		System.out.println("List Address");
//		List<String> listaddress = javaCollection.getAddressList();
//		listaddress.forEach(System.out::println);
//		
//		System.out.println("Address Set");
//		Set<String> setaddress = javaCollection.getAddressSet();
//		setaddress.forEach(System.out::println);
//		
//		System.out.println("Map Address");
//		Map<String, String> mapaddress = javaCollection.getAddressMap();
//		mapaddress.forEach((key, value) ->
//	    System.out.println(key + " --> " + value));
//		
//		System.out.println("Properties Address");
//		Properties propaddress = javaCollection.getAddressProp();
//		propaddress.forEach(System.out::println);
//		
//		System.out.println("The End");
//	}	
//}

// doing this for creating beans in different place instead of spring.xml file 
//package com.ibm.spring;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.ibm.spring.beans.TextEditor;
//import com.ibm.spring.config.BeanConfig;
//
//public class Application {
//	public static void main(String[] args) {
//
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//
//		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
//		textEditor.spellCheck();
//		System.out.println("The End");
//	}
//
//}

//doing this for Autowired
//package com.ibm.spring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ibm.spring.beans.TextEditor;
//
//public class Application {
//	public static void main(String[] args) {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		TextEditor textEditor = (TextEditor)context.getBean("textEditor");
//		textEditor.spellCheck();
//		System.out.println("The End");
//	}
//
//}

// doing this for quailifier()
//package com.ibm.spring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ibm.spring.beans.TextEditor;
//
//public class Application {
//	public static void main(String[] args) {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		TextEditor textEditor = (TextEditor)context.getBean("textEditor");
//		textEditor.spellCheck();
//		System.out.println("The End");
//	}
//}

// doing this for context component scan 
//package com.ibm.spring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ibm.spring.beans.TextEditor;
//
//public class Application {
//	public static void main(String[] args) {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		TextEditor textEditor = (TextEditor)context.getBean("textEditor");
//		textEditor.spellCheck();
//		System.out.println("The End");
//	}
//}

// doing this to understand services
package com.ibm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.spring.beans.TextEditor;
import com.ibm.spring.services.OrderService;

public class Application {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.makePayment(1000.50);
		System.out.println("The End");
	}
}
