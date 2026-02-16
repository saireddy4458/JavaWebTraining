package com.ibm.encapsulation.pack2;

import com.ibm.encapsulation.pack1.Base1;

public class Derived1 extends Base1{
	public void access() {
//		prif = 1;
//		deff = 2; not visible 
		prof = 1;
		pubf = 2;
	}
}
