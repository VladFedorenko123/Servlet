package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.srccode.clas.ConsonantsCalcualator;

class ConsonantCalcualatorTest {
	ConsonantsCalcualator objectUnderTest = new ConsonantsCalcualator();

	@Test
	void testGetConsonants() {
		assertEquals(1, objectUnderTest.getConsonants("vlad"));
		assertEquals(2, objectUnderTest.getConsonants("sasha"));
		assertEquals(2, objectUnderTest.getConsonants("vlodmyr"));
	}

}
