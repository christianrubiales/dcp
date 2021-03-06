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

		A = new int[] {0, 1, 2, 3, 4, 5};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElements(A),
				new int[]{120, 0, 0, 0, 0, 0});

		A = new int[] {0, 1, 2, 3, 4, 5, 0};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElements(A),
				new int[]{0, 0, 0, 0, 0, 0, 0});
	}

	@Test
	public void testGetProductOfAllOtherElementsConstant() {
		int[] A = {1, 2, 3, 4, 5};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElementsConstantSpace(A),
				new int[]{120, 60, 40, 30, 24});
	}

	@Test
	public void testGetProductOfAllOtherElementsWithoutDivision() {
		int[] A = {1, 2, 3, 4, 5};
		assertArrayEquals(
				GetProductOfAllOtherElements.getProductOfAllOtherElementsWithoutDivision(A),
				new int[]{120, 60, 40, 30, 24});
	}
}
