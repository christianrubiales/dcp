package com.christianrubiales.dcp._00bonus;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeSumTest {

	@Test
	public void testHasThreeSum1() {
		assertTrue(new ThreeSumUsingHashMap().hasThreeSum(new int[]{10, 15, 3, 7}, 20));
	}

	@Test
	public void testHasThreeSum2() {
		assertFalse(new ThreeSumUsingHashMap().hasThreeSum(new int[]{10, 15, 3, 7}, 19));
	}

	@Test
	public void testHasThreeSum3() {
		assertFalse(new ThreeSumUsingHashMap().hasThreeSum(new int[]{5,4,3,2,1}, 2));
	}

	@Test
	public void testHasThreeSum4() {
		assertTrue(new ThreeSumUsingHashMap().hasThreeSum(new int[]{5,4,3,2,1,1}, 4));
	}


	@Test
	public void testHasThreeSumBySorting1() {
		assertTrue(new ThreeSumUsingSorting().hasThreeSum(new int[]{10, 15, 3, 7}, 20));
	}

	@Test
	public void testHasThreeSumBySorting2() {
		assertFalse(new ThreeSumUsingSorting().hasThreeSum(new int[]{10, 15, 3, 7}, 19));
	}

	@Test
	public void testHasThreeSumBySorting3() {
		assertFalse(new ThreeSumUsingSorting().hasThreeSum(new int[]{5,4,3,2,1}, 2));
	}

	@Test
	public void testHasThreeSumBySorting4() {
		assertTrue(new ThreeSumUsingSorting().hasThreeSum(new int[]{5,4,3,2,1,1}, 4));
	}
}
