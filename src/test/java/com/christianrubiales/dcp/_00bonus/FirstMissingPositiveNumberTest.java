package com.christianrubiales.dcp._00bonus;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstMissingPositiveNumberTest {

	@Test
	public void testFirstMissing() {
		assertEquals(2, new FirstMissingPositiveNumber().firstMissing(new int[]{3, 4, -1, 1}));
		assertEquals(3, new FirstMissingPositiveNumber().firstMissing(new int[]{1,2,0}));
		assertEquals(1, new FirstMissingPositiveNumber().firstMissing(new int[]{7,8,9,11,12}));
		assertEquals(4, new FirstMissingPositiveNumber().firstMissing(new int[]{3,2,1}));
		assertEquals(3, new FirstMissingPositiveNumber().firstMissing(new int[]{2,1}));
	}

}
