package com.christianrubiales.dcp._13dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfWaysToDecodeStringTest {

	@Test
	public void testNumberOfDecodings() {
		assertEquals(0, new NumberOfWaysToDecodeString().numberOfDecodings(null));
		assertEquals(0, new NumberOfWaysToDecodeString().numberOfDecodings(""));
		assertEquals(0, new NumberOfWaysToDecodeString().numberOfDecodings("0"));
		assertEquals(0, new NumberOfWaysToDecodeString().numberOfDecodings("0123"));
		assertEquals(1, new NumberOfWaysToDecodeString().numberOfDecodings("1"));
		assertEquals(1, new NumberOfWaysToDecodeString().numberOfDecodings("9"));
		assertEquals(2, new NumberOfWaysToDecodeString().numberOfDecodings("12"));
		assertEquals(3, new NumberOfWaysToDecodeString().numberOfDecodings("226"));
		assertEquals(3, new NumberOfWaysToDecodeString().numberOfDecodings("111"));
	}

}
