package com.ibm.arrays;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class Application1 {

	public static void main(String[] args) {
		System.out.println("Annotation information:");
		
		// process class Annotation
		Class<CustomAnnotationUsage> clazz  = CustomAnnotationUsage.class;
		CustomAnnotation classAnn = clazz.getAnnotation(CustomAnnotation.class);
//		
		if(classAnn != null) {
			printAnnotation("Class Type Annotation",classAnn);
		}
		
		try {
			//process constructor Annotation
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			CustomAnnotation constAnn = constructor.getAnnotation(CustomAnnotation.class);
			
			if(constAnn != null) {
				printAnnotation("Constructor type Annotation",constAnn);
			}
		}catch(SecurityException e) {
			e.printStackTrace();
		}catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	private static void printAnnotation(String element, CustomAnnotation ann) {
		System.out.println("Element: "+ element);
		System.out.println("Name: "+ ann.name());
		System.out.println("Duration: "+ ann.duartion());
		System.out.println("Version: "+ java.util.Arrays.toString(ann.version()));
		System.out.println();
		

	}
	
}
