package com.christianrubiales.dcp._00bonus;

import java.util.HashSet;
import java.util.Set;

public class TwoSumUsingSet implements TwoSum {

	public boolean hasTwoSum(int[] array, int sum) {
		if (array == null || array.length < 2) {
			return false;
		}

		Set<Integer> map = new HashSet<>();

		for (int i : array) {
			if (map.contains(sum - i)) {
				return true;
			} else {
				map.add(i);
			}
		}

		return false;
	}
}
