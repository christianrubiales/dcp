package com.christianrubiales.dcp._00bonus;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

	@Test
	public void testHasTwoSum1() {
		assertTrue(new TwoSumUsingHashMap().hasTwoSum(new int[]{10, 15, 3, 7}, 17));
	}

	@Test
	public void testHasTwoSum2() {
		assertFalse(new TwoSumUsingHashMap().hasTwoSum(new int[]{10, 15, 3, 7}, 19));
	}

	@Test
	public void testHasTwoSum3() {
		assertFalse(new TwoSumUsingHashMap().hasTwoSum(new int[]{5,4,3,2,1}, 2));
	}

	@Test
	public void testHasTwoSum4() {
		assertTrue(new TwoSumUsingHashMap().hasTwoSum(new int[]{5,4,3,2,1,1}, 2));
	}


	@Test
	public void testHasTwoSumBySorting1() {
		assertTrue(new TwoSumUsingSorting().hasTwoSum(new int[]{10, 15, 3, 7}, 17));
	}

	@Test
	public void testHasTwoSumBySorting2() {
		assertFalse(new TwoSumUsingSorting().hasTwoSum(new int[]{10, 15, 3, 7}, 19));
	}

	@Test
	public void testHasTwoSumBySorting3() {
		assertFalse(new TwoSumUsingSorting().hasTwoSum(new int[]{5,4,3,2,1}, 2));
	}

	@Test
	public void testHasTwoSumBySorting4() {
		assertTrue(new TwoSumUsingSorting().hasTwoSum(new int[]{5,4,3,2,1,1}, 2));
	}
}
