package com.ibm.arrays;

@CustomAnnotation(duartion = 10, name = "Class", version = {1.2, 1.3} )
public class CustomAnnotationUsage {

	@CustomAnnotation(duartion = 4, name = "Constructor")
	public CustomAnnotationUsage() {
		
	}
}
