package com.ibm.unittesting.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.ibm.unittesting.arithmetic.Arithmetic;

class AirthmeticTest {

	Arithmetic arithmetic = new Arithmetic();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	final void testSum() {
//
//		arithmetic = new Arithmetic();
//		int expected = 6;
//		int actual = arithmetic.sum(2, 4);
//		assertEquals(expected, actual);
//   	fail("Not yet implemented");
//	}

	@ParameterizedTest
	@CsvSource({"2, 3, 5", "-1, 1, 0", "0, 0, 0", "10, -5, 5"})
	void testSum(int num1, int num2, int expected) {
		assertEquals(expected, arithmetic.sum(num1, num2));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
	void testIsOdd(int number) {
		assertTrue(number%2 != 0);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"racecar", "radar", "level", "rotor"})
	void testLength(String text) {
		assertTrue(text.length() == 5);
	}

	@ParameterizedTest
	@CsvSource({"apple, 5", "banana, 6", "'',0", "hello IBMer!, 12"})
	void testStringLength(String input, int expectedLength) {
		assertEquals(expectedLength, input.length());
	}
}
