package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.srccode.clas.VowelsCalculator;

class VowelCalculatorTest {
	VowelsCalculator objectUnderTest = new VowelsCalculator();

	@Test
	void testGetVowel() {
		assertEquals(1, objectUnderTest.getVowels("vlad"));
		assertEquals(2, objectUnderTest.getVowels("sasha"));
		assertEquals(2, objectUnderTest.getVowels("vlodmyr"));
	}

}
