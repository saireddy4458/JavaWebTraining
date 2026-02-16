package com.ibm.unittesting.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.unittesting.arithmetic.Arithmetic;

public class ArithmeticTesting4 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting Airthmetic Class Methods");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Ending Airthmetic Class Methods");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting each method text execution ");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("End of each method tests");
	}

	@Test
	public void test() {
		int expectedResult = 6;
		Arithmetic arithmetic = new Arithmetic();
		int actualResult = arithmetic.sum(2,4);
		
		assertEquals("Comparing results :",expectedResult, actualResult);
		
		
//		fail("Not yet implemented");
	}

}
