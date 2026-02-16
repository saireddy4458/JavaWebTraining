package com.ibm.arrays;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// retention policy is to know when to execute the annotations (runtime,source-compile time etc)
@Target({ElementType.CONSTRUCTOR})
// Target is used to restrict the usage place of annotations from {Class,Constructor, Field}

public @interface CustomAnnotation {
	String name();
	int duartion();
	double[] version() default {1.0, 2.0, 3.0};
}
