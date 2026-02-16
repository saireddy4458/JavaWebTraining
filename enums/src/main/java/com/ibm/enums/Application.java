package com.ibm.enums;

import com.ibm.enums.types.Apples;

public class Application
{
	public static void main( String[] args )
	{
		Apples apple1;
		
		apple1 = Apples.FUJI;
		
		System.out.println(apple1);
		
		Apples[] apples = Apples.values();
		
		for(Apples apple:apples) {
			System.out.println(apple+" costs us "+apple.getPrice());
		}
	
		Apples gold_del = Apples.valueOf("GOLDEN_DEL");
		System.out.println(gold_del);
	
	}
	
}