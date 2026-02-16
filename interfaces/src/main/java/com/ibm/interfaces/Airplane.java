package com.ibm.interfaces;

public class Airplane implements Flyer {

	@Override
	public void takeoff() {
		System.out.println("Airplane takeoff");

	}

	@Override
	public void land() {
		System.out.println("Airplane landing");
	}

	@Override
	public void fly() {
		System.out.println("Airplane flying");
	}

}
