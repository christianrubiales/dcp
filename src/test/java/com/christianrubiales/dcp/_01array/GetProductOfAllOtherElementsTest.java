package com.christianrubiales.dcp._01array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import junit.framework.TestCase;

public class GetProductOfAllOtherElementsTest extends TestCase {

	@Test
	public void testGetProductOfAllOtherElements() {
		int[] A = {1, 2, 3, 4, 5};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElements(A),
				new int[]{120, 60, 40, 30, 24});
	}

	@Test
	public void testGetProductOfAllOtherElementsWithoutDivision() {
		int[] A = {1, 2, 3, 4, 5};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElementsWithoutDivision(A),
				new int[]{120, 60, 40, 30, 24});
	}

	@Test
	public void testGetProductOfAllOtherElementsWithoutDivisionConstant() {
		int[] A = {1, 2, 3, 4, 5};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElementsWithoutDivisionConstant(A),
				new int[]{120, 60, 40, 30, 24});
	}
}
