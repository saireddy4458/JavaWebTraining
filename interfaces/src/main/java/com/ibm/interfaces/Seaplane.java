package com.ibm.interfaces;

public class Seaplane implements Flyer, Sailer {

	@Override
	public void sailing() {
		System.out.println("Seaplane is sailing");

	}

	@Override
	public void dock() {
		System.out.println("Seaplane is docking");

	}

	@Override
	public void takeoff() {
		System.out.println("Seaplane is taking off");
	}

	@Override
	public void land() {
		System.out.println("Seaplane is landing");

	}

	@Override
	public void fly() {
		System.out.println("Seaplane is flying");

	}

}
