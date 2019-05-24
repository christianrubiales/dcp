package com.christianrubiales.dcp._00bonus;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumUsingHashMap implements ThreeSum {

	@Override
	public boolean hasThreeSum(int[] array, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i : array) {
			Integer count = map.get(i);
			if (count == null) {
				count = 0;
			}
			map.put(i, count + 1);
		}
		
		for (int i = 0; i < array.length - 2; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {
				int partial = array[i] + array[j];
				int k = sum - partial;
				if (map.containsKey(k)) {
					if (k == array[i]) {
						if (k == array[j]) {
							if (map.getOrDefault(k, 0) > 2) {
								return true;
							}
						} else if (map.getOrDefault(k, 0) > 1) {
							return true;
						}
					} else {
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
