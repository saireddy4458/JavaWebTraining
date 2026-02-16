package com.ibm.enums.types;

public enum Apples {
	RED_DEL(100),
	GOLDEN_DEL(200),
	FUJI(120),
	GREEN(300);
	
	private int price;
	
	Apples(int price){
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
}
