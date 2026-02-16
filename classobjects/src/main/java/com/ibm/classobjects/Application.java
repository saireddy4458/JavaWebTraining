package com.ibm.classobjects;

import com.ibm.classobjects.mammals.Man;

public class Application
{
	public static void main( String[] args )
	{
		Man man = new Man();
		man.leftEye.color = "black";
		man.rightEye.color= "black";
		
		man.leftEye.power = 1.0f;
		man.rightEye.power = 1.0f;
	}
}