package com.ibm.arrays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class internationalization {

	public static void main(String[] args) {
		
		double d = 1234567.890;
		
		NumberFormat nf =  NumberFormat.getInstance(Locale.ITALY);
		NumberFormat nf1 =  NumberFormat.getInstance(Locale.CHINA);
		NumberFormat nf2 =  NumberFormat.getInstance(Locale.US);
		NumberFormat nf3 = NumberFormat.getInstance(Locale.FRANCE);
		 
		System.out.println("Italy represenatation of : "+d+ " is: "+nf.format(d));
		
		System.out.println("China represenatation of : "+d+ " is: "+nf1.format(d));
		
		System.out.println("US represenatation of : "+d+ " is: "+nf2.format(d));
		
		System.out.println("France represenatation of : "+d+ " is: "+nf3.format(d));
		System.out.println();
		
//		Locale defaultLocale = Locale.getDefault();
		Locale defaultLocale = Locale.FRANCE;
//		Locale defaultLocale = new Locale("es");
		
		System.out.println(defaultLocale);
		System.out.println("Default Locale:");
		System.out.println("Language :"+defaultLocale.getLanguage());
		System.out.println("Country :"+defaultLocale.getCountry());
		System.out.println("Dsiplay Name :"+defaultLocale.getDisplayName());
		System.out.println("Variant :"+defaultLocale.getVariant());
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages",defaultLocale);
		
		System.out.println("\n"+defaultLocale.getDisplayName()+"\n");
		printMessages(resourceBundle);
		
	}
	
	public static void printMessages(ResourceBundle bundle) {
		System.out.println("Greeting: " +bundle.getString("greeting"));
		System.out.println("Farewell: " +bundle.getString("farewell"));
		System.out.println("question: " +bundle.getString("question"));
	}
}

