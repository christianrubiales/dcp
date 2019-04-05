package com.christianrubiales.dcp._00bonus;

import java.util.HashMap;
import java.util.Map;

public class TwoSumUsingHashMap implements TwoSum {

	public boolean hasTwoSum(int[] array, int sum) {
		if (array == null || array.length < 2) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : array) {
			if (map.containsKey(sum - i)) {
				if ((i == sum - i)) {
					return (map.get(sum - i) > 0);
				}
				return true;
			} else {
				if (map.containsKey(i)) {
					map.put(i, map.get(i) + 1);
				} else {
					map.put(i, 1);
				}
			}
		}

		return false;
	}
}
