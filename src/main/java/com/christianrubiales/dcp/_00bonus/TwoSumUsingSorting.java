package com.christianrubiales.dcp._00bonus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUsingSorting implements TwoSum {

	public boolean hasTwoSum(int[] array, int sum) {
		if (array == null || array.length < 2) {
			return false;
		}

		Arrays.sort(array);
		int i = 0;
		int j = array.length - 1;
		
		while (i < j) {
			if (array[i] + array[j] == sum) {
				return true;
			} else if (array[i] + array[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}
}
