package com.ibm.classobjects.mammals;

import com.ibm.classobjects.mammals.organs.Eye;
//import com.ibm.classobjects.mammals.organs.HumanEye;

public class Human {
	public HumanEye leftEye,rightEye;
	
	public Human() {
		leftEye = new HumanEye();
		rightEye = new HumanEye();
	}
	public static class HumanEye extends Eye {
		public float power;
	}

}